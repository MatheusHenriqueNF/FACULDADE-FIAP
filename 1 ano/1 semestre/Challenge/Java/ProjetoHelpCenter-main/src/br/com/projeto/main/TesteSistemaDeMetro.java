package br.com.projeto.main;

import br.com.projeto.beans.Estacao;
import br.com.projeto.beans.LinhaDeTrem;
import br.com.projeto.beans.SistemaDeMetro;

public class TesteSistemaDeMetro {
    public static void main(String[] args) {
        // Criando o sistema de metrô
        SistemaDeMetro sistema = new SistemaDeMetro();

        // Criando a Linha Azul e suas estações
        LinhaDeTrem linha1 = new LinhaDeTrem("Linha Azul");
        Estacao estacaoA = new Estacao("Estação A");
        Estacao estacaoB = new Estacao("Estação B");
        Estacao estacaoC = new Estacao("Estação C");

        // Adicionando estações à Linha Azul
        linha1.adicionarEstacao(estacaoA);
        linha1.adicionarEstacao(estacaoB);
        linha1.adicionarEstacao(estacaoC);

        // Definindo tempos de viagem entre as estações da Linha Azul
        estacaoA.adicionarTempo(estacaoB, 5); // 5 minutos de A para B
        estacaoB.adicionarTempo(estacaoC, 3); // 3 minutos de B para C
        estacaoA.adicionarTempo(estacaoC, 8); // 8 minutos de A para C

        // Adicionando a Linha Azul ao sistema
        sistema.adicionarLinha(linha1);

        // Criando a Linha Vermelha e suas estações
        LinhaDeTrem linha2 = new LinhaDeTrem("Linha Vermelha");
        Estacao estacaoD = new Estacao("Estação D");
        Estacao estacaoE = new Estacao("Estação E");

        // Adicionando estações à Linha Vermelha
        linha2.adicionarEstacao(estacaoD);
        linha2.adicionarEstacao(estacaoE);

        // Definindo tempos de viagem entre as estações da Linha Vermelha
        estacaoD.adicionarTempo(estacaoE, 6); // 6 minutos de D para E

        // Adicionando a Linha Vermelha ao sistema
        sistema.adicionarLinha(linha2);

        // Exibindo as linhas disponíveis
        sistema.mostrarLinhas();

        // Exibindo estações de cada linha
        System.out.println("\nEstações na Linha Azul:");
        linha1.mostrarEstacoes();

        System.out.println("\nEstações na Linha Vermelha:");
        linha2.mostrarEstacoes();

        // Testando a funcionalidade de encontrar rotas
        System.out.println("\nTestando rotas:");
        sistema.encontrarRota(estacaoA, estacaoC); // Deve encontrar a rota na Linha Azul
        sistema.encontrarRota(estacaoD, estacaoE); // Deve encontrar a rota na Linha Vermelha
        sistema.encontrarRota(estacaoA, estacaoE); // Não deve encontrar rota, pois são linhas diferentes
        // }
    }

}