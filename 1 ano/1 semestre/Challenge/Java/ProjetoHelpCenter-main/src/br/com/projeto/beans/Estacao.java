package br.com.projeto.beans;

import java.util.HashMap;
import java.util.Map;

public class Estacao {
    private final String nome;
    private final Map<Estacao, Integer> tempos; // mapa que armazena tempos para outras estações

    public Estacao(String nome) {
        this.nome = nome;
        this.tempos = new HashMap<>();
    }
    public String getNome() {
        return nome;
    }
    public void adicionarTempo(Estacao estacao, int tempo) {
        tempos.put(estacao, tempo);
    }

    public Map<Estacao, Integer> getTempos() {
        return tempos;
    }
}
