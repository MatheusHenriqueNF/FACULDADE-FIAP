if __name__ == "__main__":
    try:
        nome = input("Insira o nome")
        dia_nas = int(input("Dia do nascimento"))

        num_a = float(input("A:"))
        num_b = float(input("B:"))
        divisao = num_a / num_b
        print(f"A divisão de {num_a} por {num_b} é {divisao}")


        lista = ['Ana', 'Beatriz', 'Carol', 'Duda']
        i = 10
        if i < len(lista):
            print(lista[i])
        else:
            print("Índice inválido")
        
        arq = open("excecoes/exemplo1.py", mode='r')
        print(arq.read())
    except:
        print("Ocorreu um erro inesperado.")