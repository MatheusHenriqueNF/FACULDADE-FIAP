package br.com.fiap.beans;

import java.util.*;

public class Grafo {
    private Map<String, Map<String, Integer>> grafo;

    // Construtor da classe Grafo
    public Grafo() {
        grafo = new HashMap<>();
    }

    // Método para adicionar uma conexão entre duas estações
    public void addEdge(String origem, String destino, int distancia) {
        // Se a estação de origem ainda não estiver no grafo, adiciona ela
        grafo.putIfAbsent(origem, new HashMap<>());
        grafo.putIfAbsent(destino, new HashMap<>());

        // Adiciona a conexão no grafo (distância entre origem e destino)
        grafo.get(origem).put(destino, distancia);
        grafo.get(destino).put(origem, distancia); // Grafo não direcionado (duas vias)
    }

    // Método para obter as conexões de uma estação
    public Map<String, Integer> getConexoes(String estacao) {
        return grafo.getOrDefault(estacao, new HashMap<>());
    }

    // Método para verificar se uma estação existe no grafo
    public boolean existeEstacao(String estacao) {
        return grafo.containsKey(estacao);
    }

    // Método para calcular o caminho mais curto utilizando o algoritmo de Dijkstra
    public List<String> caminhoMaisCurto(String origem, String destino) {
        // Mapa para armazenar a distância mínima de cada estação até a origem
        Map<String, Integer> distancias = new HashMap<>();
        // Mapa para armazenar o caminho (anterior) de cada estação
        Map<String, String> predecessores = new HashMap<>();
        // Mapa para armazenar as estações não visitadas
        Set<String> naoVisitadas = new HashSet<>();
        
        // Inicializa as distâncias com infinito e a origem com distância 0
        for (String estacao : grafo.keySet()) {
            distancias.put(estacao, Integer.MAX_VALUE);
            naoVisitadas.add(estacao);
        }
        distancias.put(origem, 0);

        // Enquanto houver estações não visitadas
        while (!naoVisitadas.isEmpty()) {
            // Estação com a menor distância (a mais próxima)
            String atual = null;
            int menorDistancia = Integer.MAX_VALUE;
            for (String estacao : naoVisitadas) {
                int distancia = distancias.get(estacao);
                if (distancia < menorDistancia) {
                    menorDistancia = distancia;
                    atual = estacao;
                }
            }

            // Se a estação atual for a estação de destino, terminou o algoritmo
            if (atual.equals(destino)) {
                break;
            }

            // Remover a estação atual da lista de não visitadas
            naoVisitadas.remove(atual);

            // Para cada vizinho da estação atual
            for (Map.Entry<String, Integer> vizinho : grafo.get(atual).entrySet()) {
                String vizinhoEstacao = vizinho.getKey();
                int peso = vizinho.getValue();
                
                // Se a distância através da estação atual for menor que a distância já registrada
                int novaDistancia = distancias.get(atual) + peso;
                if (novaDistancia < distancias.get(vizinhoEstacao)) {
                    distancias.put(vizinhoEstacao, novaDistancia);
                    predecessores.put(vizinhoEstacao, atual);
                }
            }
        }

        // Reconstruir o caminho a partir do destino até a origem
        List<String> caminho = new ArrayList<>();
        String atual = destino;
        while (atual != null) {
            caminho.add(atual);
            atual = predecessores.get(atual);
        }
        
        // Se o caminho for encontrado, inverte o caminho para origem → destino
        Collections.reverse(caminho);
        return caminho.size() == 1 && !caminho.get(0).equals(origem) ? new ArrayList<>() : caminho;  // Retorna lista vazia se não houver caminho
    }
}


