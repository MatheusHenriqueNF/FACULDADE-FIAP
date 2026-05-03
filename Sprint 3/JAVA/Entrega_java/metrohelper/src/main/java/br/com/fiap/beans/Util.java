package br.com.fiap.beans;

import java.util.*;

public class Util {

    // Método para calcular o caminho mais curto usando o algoritmo de Dijkstra
    public static List<String> shortestPath(Grafo grafo, String origem, String destino) {
        // Dijkstra - Inicializa a tabela de distâncias
        Map<String, Integer> distancias = new HashMap<>();
        Map<String, String> antecessores = new HashMap<>();
        Set<String> visitados = new HashSet<>();
        PriorityQueue<String> filaPrioridade = new PriorityQueue<>(Comparator.comparingInt(distancias::get));

        // Inicializa todas as distâncias como infinito, exceto a origem
        for (String estacao : grafo.getConexoes(origem).keySet()) {
            distancias.put(estacao, Integer.MAX_VALUE);
        }
        distancias.put(origem, 0);
        filaPrioridade.add(origem);

        // Algoritmo de Dijkstra
        while (!filaPrioridade.isEmpty()) {
            String estacaoAtual = filaPrioridade.poll();

            if (estacaoAtual.equals(destino)) {
                break; // Encontrou o destino
            }

            if (visitados.contains(estacaoAtual)) {
                continue;
            }

            visitados.add(estacaoAtual);

            for (Map.Entry<String, Integer> vizinho : grafo.getConexoes(estacaoAtual).entrySet()) {
                String proximaEstacao = vizinho.getKey();
                int distancia = vizinho.getValue();
                int novaDistancia = distancias.get(estacaoAtual) + distancia;

                if (novaDistancia < distancias.getOrDefault(proximaEstacao, Integer.MAX_VALUE)) {
                    distancias.put(proximaEstacao, novaDistancia);
                    antecessores.put(proximaEstacao, estacaoAtual);
                    filaPrioridade.add(proximaEstacao);
                }
            }
        }

        // Reconstruir o caminho mais curto
        List<String> caminho = new ArrayList<>();
        String atual = destino;
        while (atual != null) {
            caminho.add(atual);
            atual = antecessores.get(atual);
        }
        Collections.reverse(caminho); // Reverte o caminho para ficar do começo ao fim

        return caminho.size() == 1 ? Collections.emptyList() : caminho;
    }

    // Método para exibir o caminho
    public static void exibirCaminho(List<String> caminho) {
        if (caminho.isEmpty()) {
            System.out.println("Não há caminho disponível.");
        } else {
            System.out.print("Caminho mais curto: ");
            for (String estacao : caminho) {
                System.out.print(estacao + " -> ");
            }
            System.out.println("Fim");
        }
    }

    // Método para calcular a distância total de um caminho
    public static int calcularDistanciaTotal(Grafo grafo, List<String> caminho) {
        int distanciaTotal = 0;
        for (int i = 0; i < caminho.size() - 1; i++) {
            String origem = caminho.get(i);
            String destino = caminho.get(i + 1);
            distanciaTotal += grafo.getConexoes(origem).getOrDefault(destino, Integer.MAX_VALUE);
        }
        return distanciaTotal;
    }

    // Método para exibir as conexões de uma estação
    public static void exibirConexoes(Grafo grafo, String estacao) {
        Map<String, Integer> conexoes = grafo.getConexoes(estacao);
        System.out.println("Conexões de " + estacao + ":");
        if (conexoes.isEmpty()) {
            System.out.println("Não há conexões disponíveis.");
        } else {
            for (Map.Entry<String, Integer> conexao : conexoes.entrySet()) {
                System.out.println(conexao.getKey() + " - Distância: " + conexao.getValue() + "km");
            }
        }
    }
}

