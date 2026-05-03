package br.com.fiap.beans;

import br.com.fiap.dao.LinhaDAO;

import javax.swing.*;

public class Linha {
    private int status;
    private String nomeLinha;
    private int valor;

    public Linha() {
        super();
    }

    public Linha(int status, String nomeLinha, int valor) {
        super();
        this.status = status;
        this.nomeLinha = nomeLinha;
        this.valor = valor;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getNomeLinha() {
        return nomeLinha;
    }

    public void setNomeLinha(String nomeLinha) {
        this.nomeLinha = nomeLinha;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Linha{" +
                "status=" + status +
                ", nomeLinha='" + nomeLinha + '\'' +
                ", valor=" + valor +
                '}';
    }

}
