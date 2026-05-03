package br.com.fiap.beans;

import javax.swing.*;
import java.util.*;

public class Caminho {
    // Classe Grafo para representar o mapa
    public static class Grafo {
        private final Map<String, List<String>> adjacencia;

        public Grafo() {
            adjacencia = new HashMap<>();
        }

        public void addEdge(String origem, String destino, int peso) {
            adjacencia.putIfAbsent(origem, new ArrayList<>());
            adjacencia.get(origem).add(destino);
        }

        public List<String> caminhoMaisCurto(String origem, String destino) {
            // Algoritmo de busca em largura (BFS) para encontrar o caminho mais curto
            Queue<String> fila = new LinkedList<>();
            Map<String, String> predecessores = new HashMap<>();
            Set<String> visitados = new HashSet<>();

            fila.add(origem);
            visitados.add(origem);

            while (!fila.isEmpty()) {
                String atual = fila.poll();

                if (atual.equals(destino)) {
                    List<String> caminho = new ArrayList<>();
                    for (String station = destino; station != null; station = predecessores.get(station)) {
                        caminho.add(station);
                    }
                    Collections.reverse(caminho);
                    return caminho;
                }

                for (String vizinho : adjacencia.getOrDefault(atual, new ArrayList<>())) {
                    if (!visitados.contains(vizinho)) {
                        fila.add(vizinho);
                        visitados.add(vizinho);
                        predecessores.put(vizinho, atual);
                    }
                }
            }
            return Collections.emptyList(); // Se não encontrar o caminho
        }
    }

    // Método para consultar o caminho
    public static void consultarCaminho() {
        String origem = JOptionPane.showInputDialog(null, "Qual estação você está?");
        String destino = JOptionPane.showInputDialog(null, "Qual estação você quer ir?");

        // Criar o grafo e adicionar as arestas
        Grafo grafo = new Grafo();
        grafo.addEdge("Júlio Prestes", "Palmeiras-Barra Funda", 1);
        grafo.addEdge("Palmeiras-Barra Funda", "Júlio Prestes", 1);
        grafo.addEdge("Palmeiras-Barra Funda", "Lapa", 1);
        grafo.addEdge("Lapa", "Palmeiras-Barra Funda", 1);
        grafo.addEdge("Lapa", "Domingos de Moraes", 1);
        grafo.addEdge("Domingos de Moraes", "Lapa", 1);
        grafo.addEdge("Domingos de Moraes", "Imperatriz Leopoldina", 1);
        grafo.addEdge("Imperatriz Leopoldina", "Domingos de Moraes", 1);
        grafo.addEdge("Imperatriz Leopoldina", "Presidente Altino", 1);
        grafo.addEdge("Presidente Altino", "Imperatriz Leopoldina", 1);
        grafo.addEdge("Presidente Altino", "Osasco", 1);
        grafo.addEdge("Osasco", "Presidente Altino", 1);
        grafo.addEdge("Osasco", "Comandante Sampaio", 1);
        grafo.addEdge("Comandante Sampaio", "Osasco", 1);
        grafo.addEdge("Comandante Sampaio", "Quitaúna", 1);
        grafo.addEdge("Quitaúna", "Comandante Sampaio", 1);
        grafo.addEdge("Quitaúna", "General Miguel Costa", 1);
        grafo.addEdge("General Miguel Costa", "Quitaúna", 1);
        grafo.addEdge("General Miguel Costa", "Carapicuíba", 1);
        grafo.addEdge("Carapicuíba", "General Miguel Costa", 1);
        grafo.addEdge("Carapicuíba", "Santa Terezinha", 1);
        grafo.addEdge("Santa Terezinha", "Carapicuíba", 1);
        grafo.addEdge("Santa Terezinha", "Antonio João", 1);
        grafo.addEdge("Antonio João", "Santa Terezinha", 1);
        grafo.addEdge("Antonio João", "Barueri", 1);
        grafo.addEdge("Barueri", "Antonio João", 1);
        grafo.addEdge("Barueri", "Jardim Belval", 1);
        grafo.addEdge("Jardim Belval", "Barueri", 1);
        grafo.addEdge("Jardim Belval", "Jardim Silveira", 1);
        grafo.addEdge("Jardim Silveira", "Jardim Belval", 1);
        grafo.addEdge("Jardim Silveira", "Jandira", 1);
        grafo.addEdge("Jandira", "Jardim Silveira", 1);
        grafo.addEdge("Jandira", "Sagrado Coração", 1);
        grafo.addEdge("Sagrado Coração", "Jandira", 1);
        grafo.addEdge("Sagrado Coração", "Engenheiro Cardoso", 1);
        grafo.addEdge("Engenheiro Cardoso", "Sagrado Coração", 1);
        grafo.addEdge("Engenheiro Cardoso", "Itapevi", 1);
        grafo.addEdge("Itapevi", "Engenheiro Cardoso", 1);
        grafo.addEdge("Itapevi", "Amador Bueno", 1);
        grafo.addEdge("Amador Bueno", "Itapevi", 1);

        // Encontrar o caminho mais curto
        List<String> caminhoMaisCurto = grafo.caminhoMaisCurto(origem, destino);

        // Exibir o caminho
        if (caminhoMaisCurto.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não foi possível encontrar o caminho entre as estações.");
        } else {
            JOptionPane.showMessageDialog(null, "Caminho mais curto: " + caminhoMaisCurto);
        }
    }
}