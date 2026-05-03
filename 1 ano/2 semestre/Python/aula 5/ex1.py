def ocorrencia():
    texto = 'Amanha'
    contagem = {}

    for caractere in texto.lower():
        if caractere in contagem:
            contagem[caractere] += 1
        else:
            contagem[caractere] = 1

    for caractere, qtd in contagem.items():
        print(f'O caractere "{caractere}" aparece {qtd} vezes.')

ocorrencia()
