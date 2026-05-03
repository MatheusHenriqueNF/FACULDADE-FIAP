with open("arquivo/dados.txt", "r") as arq:
    dados = arq.read()
print(dados)

arq = open("arquivo/dados.txt", "r")
dados = arq.read()
arq.close()
print(dados)