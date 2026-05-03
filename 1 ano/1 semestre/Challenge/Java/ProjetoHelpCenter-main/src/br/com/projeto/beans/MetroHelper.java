package br.com.projeto.beans;

public class MetroHelper {
    public static void main(String[] args) {
                SistemaDeMetro sistema = new SistemaDeMetro();

                LinhaDeTrem linha1 = new LinhaDeTrem("Linha Azul");
                Estacao estacaoA = new Estacao("Estação A");
                Estacao estacaoB = new Estacao("Estação B");
                Estacao estacaoC = new Estacao("Estação C");

                // Adicionando estações à linha
                linha1.adicionarEstacao(estacaoA);
                linha1.adicionarEstacao(estacaoB);
                linha1.adicionarEstacao(estacaoC);

                // Definindo tempos de viagem entre estações
                estacaoA.adicionarTempo(estacaoB, 5); // 5 minutos de A para B
                estacaoB.adicionarTempo(estacaoC, 3); // 3 minutos de B para C
                estacaoA.adicionarTempo(estacaoC, 8); // 8 minutos de A para C (direto)

                sistema.adicionarLinha(linha1);
                sistema.mostrarLinhas();

                // Encontrando a rota entre as estações
                sistema.encontrarRota(estacaoA, estacaoC);
    }
}
