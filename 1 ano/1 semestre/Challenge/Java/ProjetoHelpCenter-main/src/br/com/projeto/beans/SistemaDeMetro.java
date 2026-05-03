package br.com.projeto.beans;

import java.util.ArrayList;
import java.util.List;

public class SistemaDeMetro {
    private final List<LinhaDeTrem> linhas;

    public SistemaDeMetro() {
        this.linhas = new ArrayList<>();
    }

    public void adicionarLinha(LinhaDeTrem linha) {
        linhas.add(linha);
    }

    public void mostrarLinhas() {
        System.out.println("Linhas disponíveis:");
        for (LinhaDeTrem linha : linhas) {
            System.out.println("- " + linha.getNome());
        }
    }

    // Método para encontrar a melhor rota entre duas estações
    public void encontrarRota(Estacao origem, Estacao destino) {
        for (LinhaDeTrem linha : linhas) {
            if (linha.getEstacoes().contains(origem) && linha.getEstacoes().contains(destino)) {
                int tempo = linha.calcularTempo(origem, destino);
                if (tempo != -1) {
                    System.out.println("Rota encontrada na " + linha.getNome() + ": " +
                            origem.getNome() + " -> " + destino.getNome() +
                            " em " + tempo + " minutos.");
                    return;
                }
            }
        }
        System.out.println("Nenhuma rota encontrada entre " + origem.getNome() + " e " + destino.getNome() + ".");
    }
}
