import random

times = ["Palmeiras", "Botafogo", "Flamengo", "Corinthians", "Santos", "Internacional"]

with open("arquivo/resultados.txt", "w") as arq:
    for i in range(len(times)):
        for j in range(i + 1, len(times)):
            gc = random.randint(0,7)
            gv = random.randint(0,7)
            arq.write(f"{times[i]} {gc} X {gv} {times[j]}")
            arq.write("\n")
