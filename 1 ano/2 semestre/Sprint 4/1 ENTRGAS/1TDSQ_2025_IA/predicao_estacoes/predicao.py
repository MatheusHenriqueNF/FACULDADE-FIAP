import pandas as pd
import numpy as np
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import StandardScaler, LabelEncoder
from sklearn.linear_model import LinearRegression
from sklearn.tree import DecisionTreeRegressor
from sklearn.ensemble import RandomForestRegressor
from sklearn.multioutput import MultiOutputRegressor
from sklearn.metrics import r2_score
import joblib
from flask import Flask, request, render_template, jsonify

# Configurações por linha
config = {
    "azul": {
        "arquivo": "Dataset_azul.csv",
        "estacoes": ["JAB", "CON", "JUD", "SAU", "ARV", "SCZ", "VMN", "ANR", "PSO", "VGO",
                     "JQM", "LIB", "PSE", "BTO", "TRD", "PPQ", "TTE", "CDU", "SAN", "JPA", "PIG", "TUC", "LUZ"]
    },
    "verde": {
        "arquivo": "Dataset_verde.csv",
        "estacoes": ["VPT", "TTI", "SAC", "AIP", "IMG", "CKB", "ANR", "PSO", "BGD", "TRI",
                      "CNS", "CLI", "SUM", "VMD"]
    },
    "vermelha": {
        "arquivo": "Dataset_vermelha.csv",
        "estacoes": ["ITQ", "ART", "PCA", "VPA", "VTD", "PEN", "CAR", "TAT", "BEL", "BRE",
                     "BAS", "PDS", "PSE", "GBU", "REP", "CEC", "DEO", "BFU"]
    },
    "prata": {
        "arquivo": "Dataset_prata.csv",
        "estacoes": ["VPM", "ORT", "SLU", "CAD", "VTL", "VUN", "JPL", "SAP", "FJT", "MAT", "IGT"]
    }
}

for linha_nome, props in config.items():
    df = pd.read_csv(props["arquivo"], sep=";", decimal=",")
    df.columns = df.columns.str.strip()

    label_encoder_mes = LabelEncoder()
    df["MES"] = label_encoder_mes.fit_transform(df["MES"])

    X = df[["MES", "DIA"]]
    y = df[props["estacoes"]]

    scaler = StandardScaler()
    X_scaled = scaler.fit_transform(X)

    X_train, X_test, y_train, y_test = train_test_split(X_scaled, y, test_size=0.3, random_state=42)

    # Testando diferentes modelos
    modelos_teste = {
        "RandomForest": RandomForestRegressor(random_state=42),
        "DecisionTree": DecisionTreeRegressor(random_state=42),
        "LinearRegression": LinearRegression()
    }

    melhor_modelo = None
    melhor_nome = ""
    melhor_score = float("-inf")

    for nome, base_modelo in modelos_teste.items():
        print(f"Treinando modelo: {nome}")
        modelo_multi = MultiOutputRegressor(base_modelo)
        modelo_multi.fit(X_train, y_train)
        y_pred = modelo_multi.predict(X_test)
        score = r2_score(y_test, y_pred)
        print(f"{nome} - R² Score: {score:.4f}")

        if score > melhor_score:
            melhor_score = score
            melhor_modelo = modelo_multi
            melhor_nome = nome

    print(f"\n✅ Melhor modelo: {melhor_nome} com R² = {melhor_score:.4f}")

    # Salvando modelo e ferramentas
    joblib.dump(melhor_modelo, f"modelo_{linha_nome}.pkl")
    joblib.dump(scaler, f"scaler_{linha_nome}.pkl")
    joblib.dump(label_encoder_mes, f"encoder_mes_{linha_nome}.pkl")
    print(f"[{linha_nome}] Modelo treinado e salvo com sucesso.")


# ---------------------- FLASK ----------------------


app = Flask(__name__)

# Estações para cada linha
estacoes = {
    "1-Azul": ["JABAQUARA-COMITÊ PARALÍMPICO BRASILEIRO",
        "CONCEIÇÃO",
        "SÃO JUDAS",
        "SAÚDE-ULTRAFARMA",
        "PRAÇA DA ÁRVORE",
        "SANTA CRUZ",
        "VILA MARIANA",
        "ANA ROSA",
        "PARAÍSO",
        "VERGUEIRO",
        "SÃO JOAQUIM",
        "JAPÃO-LIBERDADE",
        "SÉ",
        "SÃO BENTO",
        "LUZ",
        "TIRADENTES",
        "ARMÊNIA",
        "PORTUGUESA-TIETÊ",
        "CARANDIRU",
        "SANTANA",
        "JARDIM SÃO PAULO-AYRTON SENNA",
        "PARADA INGLESA",
        "TUCURUVI"
    ],

    "2-Verde": ["VILA PRUDENTE",
        "TAMANDUATEÍ",
        "SACOMÃ",
        "ALTO DO IPIRANGA",
        "SANTOS-IMIGRANTES",
        "CHÁCARA KLABIN",
        "ANA ROSA",
        "PARAÍSO",
        "BRIGADEIRO",
        "TRIANON-MASP",
        "CONSOLAÇÃO",
        "CLÍNICAS",
        "S. N. SRA. DE FÁTIMA-SUMARÉ",
        "VILA MADALENA"
    ],
                    
    "3-Vermelha": ["CORINTHIANS-ITAQUERA",
        "ARTUR ALVIM",
        "PATRIARCA-VILA RÉ",
        "GUILHERMINA-ESPERANÇA",
        "VILA MATILDE",
        "PENHA-LOJAS BESNI",
        "CARRÃO-ASSAÍ ATACADISTA",
        "TATUAPÉ",
        "BELÉM",
        "BRESSER-MOOCA",
        "BRÁS",
        "PEDRO II",
        "SÉ",
        "ANHANGABAÚ",
        "REPÚBLICA",
        "SANTA CECÍLIA",
        "MARECHAL DEODORO",
        "PALMEIRAS-BARRA FUNDA"
        ],

    
    "15-Prata": ["VILA PRUDENTE",
        "ORATÓRIO",
        "SÃO LUCAS",
        "CAMILO HADDAD",
        "VILA TOLSTÓI",
        "VILA UNIÃO",
        "JARDIM PLANALTO",
        "SAPOPEMBA",
        "FAZENDA DA JUTA",
        "SÃO MATEUS",
        "JARDIM COLONIAL"
    ]
}

meses ={
    "Janeiro": [1],
    "Fevereiro": [2],
    "Março": [3],
    "Abril": [4],
    "Maio": [5],
    "Junho": [6],
    "Julho": [7],
    "Agosto": [8],
    "Setembro": [9],
    "Outubro": [10],
    "Novembro": [11],
    "Dezembro": [12]
} 

@app.route("/", methods=["GET", "POST"])
def index():
    predicao = None
    if request.method == "POST":
        linha = request.form["linha"]
        mes = request.form["mes"]
        dia = int(request.form["dia"])

        base_nome = linha.split('-')[1].lower()
        modelo = joblib.load(f"modelo_{base_nome}.pkl")
        scaler = joblib.load(f"scaler_{base_nome}.pkl")
        encoder_mes = joblib.load(f"encoder_mes_{base_nome}.pkl")

        mes_encoded = encoder_mes.transform([mes])[0]
        entrada = np.array([[mes_encoded, dia]])
        entrada_scaled = scaler.transform(entrada)
        predicoes = modelo.predict(entrada_scaled)[0]

        ests = estacoes[linha]
        predicao = dict(zip(ests, map(lambda x: round(x, 2), predicoes)))

    return render_template("index.html", predicao=predicao, linhas=list(estacoes.keys()), meses=list(meses.keys()))

@app.route("/api/predict", methods=["POST"])
def predict_api():
    data = request.get_json()

    linha = data.get("linha")
    mes = data.get("mes")
    dia = data.get("dia")

    if not all([linha, mes, dia]):
        return jsonify({"erro": "Campos 'linha', 'mes' e 'dia' são obrigatórios."}), 400

    try:
        modelo = joblib.load(f"modelo_{linha.split('-')[1].lower()}.pkl")
        scaler = joblib.load(f"scaler_{linha.split('-')[1].lower()}.pkl")
        encoder_mes = joblib.load(f"encoder_mes_{linha.split('-')[1].lower()}.pkl")
    except FileNotFoundError:
        return jsonify({"erro": "Modelo não encontrado para a linha especificada."}), 404

    try:
        mes_encoded = encoder_mes.transform([mes])[0]
    except ValueError:
        return jsonify({"erro": f"Mês inválido: {mes}"}), 400

    entrada = np.array([[mes_encoded, int(dia)]])
    entrada_scaled = scaler.transform(entrada)
    predicoes = modelo.predict(entrada_scaled)[0]
    ests = estacoes[linha]

    predicao = dict(zip(ests, map(lambda x: round(x, 2), predicoes)))

    return jsonify(predicao)

if __name__ == "__main__":
    app.run(debug=True)