# def dicionario_palavras():
#     # Dicionário original (inglês -> português)
#     dicionario = {'green': 'verde', 'apple': 'maçã', 'banana': 'banana'}

#     # Criando um dicionário invertido (português -> inglês)
#     dicionario_port = {valor: chave for chave, valor in dicionario.items()}

#     # Exibindo os dois dicionários
#     print("Dicionário original (inglês -> português):")
#     for chave, valor in dicionario.items():
#         print(f'{chave} -> {valor}')

#     print("\nDicionário invertido (português -> inglês):")
#     for chave, valor in dicionario_port.items():
#         print(f'{chave} -> {valor}')

# dicionario_palavras()


def dicionario_palavras():
    # Dicionário original (inglês -> português)
    dicionario = {'green': 'verde', 'apple': 'maçã', 'banana': 'banana'}

    # Criando um dicionário invertido (português -> inglês)
    dicionario_port = {}

    # Exibindo os dois dicionários
    print("Dicionário original (inglês -> português):")
    for chave, valor in dicionario.items():
        print(f'{chave} -> {valor}')
        dicionario_port[valor] = chave
    print(dicionario_port)

dicionario_palavras()
