package br.com.fiap.main;

import br.com.fiap.beans.Grafo;

import java.util.*;

public class Estacao {

    // Método que consulta o caminho mais curto entre duas estações
    public static void consultarCaminho(String origem, String destino) {
        // Criando o grafo com as estações e as distâncias
        Grafo grafo = new Grafo();

        // Adicionando as conexões entre as estações (os mesmos dados do código original)
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

        // Aqui ele aplica o algoritmo de Dijkstra e calcula o caminho mais curto
        List<String> caminhoMaisCurto = grafo.caminhoMaisCurto(origem, destino);
        
        // Exibe o caminho mais curto
        if (caminhoMaisCurto.isEmpty()) {
            System.out.println("Não foi possível encontrar o caminho entre as estações.");
        } else {
            System.out.println("Caminho mais curto de " + origem + " para " + destino + ": " + caminhoMaisCurto);
        }
    }

    // Método principal para testar
    public static void main(String[] args) {
        consultarCaminho("Júlio Prestes", "Amador Bueno"); // Exemplo de uso
    }
}

