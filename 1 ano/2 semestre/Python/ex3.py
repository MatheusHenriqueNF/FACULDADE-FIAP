def ocorrencia():
    texto = input("Digite uma frase ou letra: ")
    texto = list(texto) 

    for i in range(len(texto)):
        if texto[i].lower() == 'a':
            texto[i] = '*'

    texto_modificado = "".join(texto) 
    print("Texto modificado:", texto_modificado)

def _main():
    ocorrencia()

_main()
