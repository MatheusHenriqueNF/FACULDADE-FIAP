package br.com.fiap.beans;

import br.com.fiap.dao.LinhaDAO;
import javax.swing.*;
import java.sql.SQLException;

public class InserirLinha {
    public static void inserir() throws SQLException, ClassNotFoundException {
        Linha objLinha = new Linha();
        LinhaDAO dao = new LinhaDAO();

        objLinha.setNomeLinha(texto("Digite o nome da linha:"));
        objLinha.setStatus(Integer.parseInt(texto("Digite o status[0 = Ativado] e [1 = Desativado] linha:")));
        int valor = 1;  // Variable to save the value 1
        objLinha.setValor(valor);  // Assuming you have a setValor method in Linha class

        try {
            dao.inserir(objLinha);
            System.out.println("Linha inserida com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static String texto(String j) {
        return JOptionPane.showInputDialog(j);
    }
}