import traceback

if __name__ == "__main__":

    try:
        arq = open("excecoes/exemplo1.py", mode='r')
        conteudo = arq.read()
        arq.close()
    except:
        print("O arquivo não foi encontrado.")
        traceback.print_exc()

    else:
        print(conteudo)