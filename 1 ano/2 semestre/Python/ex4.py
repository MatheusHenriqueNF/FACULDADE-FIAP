def ocorrencia():
    texto = input("Digite uma frase ou letra: ")
    texto = list(texto) 
    conjunto = input("Digite os caracteres para substituir: ")

    for j in range(len(conjunto)):
        for i in range(len(texto)):
            if texto[i].lower() == conjunto[j]:
                texto[i] = '*'

    texto_modificado = "".join(texto) 
    print("Texto modificado:", texto_modificado)

def _main():
    ocorrencia()

_main()
