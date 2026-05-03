package br.com.fiap.main;

import br.com.fiap.beans.*;
import javax.swing.*;
import java.sql.SQLException;

public class SistemaCPTM {
    public static void main(String[] args) {
        menuPrincipal();
    }

    public static void menuPrincipal() {
        String opcao = JOptionPane.showInputDialog(null, "\nMenu Principal\n1 - Consultar caminho mais curto\n2 - Informações sobre lotação de trens\n3 - Dúvidas frequentes\n4 - Cadastrar linha\n5 - Encerrar atendimento", "Menu", JOptionPane.QUESTION_MESSAGE);

        while (!opcao.matches("[1-5]")) {
            opcao = JOptionPane.showInputDialog(null, "\nOpção inválida. Escolha uma opção entre 1 e 5.", "Erro", JOptionPane.ERROR_MESSAGE);
        }

        switch (opcao) {
            case "1":
                Caminho.consultarCaminho();  // Chama o método na classe Caminho
                break;
            case "2":
                Lotacao.duvidaLotacao();  // Chama o método na classe Lotacao
                break;
            case "3":
                DuvidasFrequentes.duvidasFrequentes();  // Chama o método na classe DuvidasFrequentes
                break;
            case "4":
                try {
                    InserirLinha.inserir();  // Chama o método para inserir linha
                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case "5":
                encerrar();  // Chama o método para encerrar o programa
                break;
        }
    }

    public static void encerrar() {
        System.out.println("\nAtendimento Encerrado.");
        System.exit(0);
    }
}