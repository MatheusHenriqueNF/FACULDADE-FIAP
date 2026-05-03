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
        print(lista[i])
        arq = open("excecoes/exemplo1.py", mode='r')
        conteudo = arq.read()
        arq.close()
        
    except ValueError:
        print("O valor inserido não é um número.")
    except IndexError:
        print("Índice inválido")
    except FileNotFoundError:
        print("Arquivo não encontrado.")
    except PermissionError:
        print("Você não tem permissão para acessar este arquivo.")
    except:
        print("Ocorreu um erro inesperado.")