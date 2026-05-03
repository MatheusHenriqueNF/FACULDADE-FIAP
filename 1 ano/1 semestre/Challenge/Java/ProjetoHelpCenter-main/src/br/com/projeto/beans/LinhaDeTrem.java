epackage br.com.projeto.beans;

import java.util.ArrayList;
import java.util.List;

public class LinhaDeTrem {
    private final String nome;
    private final List<Estacao> estacoes;

    public LinhaDeTrem(String nome) {
        this.nome = nome;
        this.estacoes = new ArrayList<>();
    }
    public void adicionarEstacao(Estacao estacao) {
        estacoes.add(estacao);
    }

    public String getNome() {
        return nome;
    }

    public List<Estacao> getEstacoes() {
        return estacoes;
    }

    public void mostrarEstacoes() {
        System.out.println("Estações da " + nome + ":");
        for (Estacao estacao : estacoes) {
            System.out.println(estacao.getNome());
        }
    }

    // Método para calcular o tempo de viagem entre duas estações
    public int calcularTempo(Estacao origem, Estacao destino) {
        if (origem.getTempos().containsKey(destino)) {
            return origem.getTempos().get(destino);
        }
        return -1; // Se a rota não existir
    }
}
