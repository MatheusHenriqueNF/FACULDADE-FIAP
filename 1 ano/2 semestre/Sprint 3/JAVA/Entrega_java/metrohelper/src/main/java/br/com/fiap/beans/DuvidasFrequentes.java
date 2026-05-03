package br.com.fiap.beans;

import javax.swing.*;

public class DuvidasFrequentes {
    public static void duvidasFrequentes() {
        String duvida = JOptionPane.showInputDialog(null, "\nSelecione uma dentre as opções:\n1- Horário de funcionamento\n2- Compra de bilhetes\n3- Frequência de Trens\n4- Opções de integração\n5- Atendimento ao Cliente\nQual seria sua dúvida?", "Dúvidas Frequentes", JOptionPane.QUESTION_MESSAGE);

        while (!duvida.matches("[1-5]")) {
            duvida = JOptionPane.showInputDialog(null, "\nOpção inválida. Por favor, selecione uma das opções.", "Erro", JOptionPane.ERROR_MESSAGE);
        }

        switch (duvida) {
            case "1":
                JOptionPane.showMessageDialog(null, "\nHorário Geral: Das 4h até às 23:59 \nObservações: \n - Este horário pode ser prolongado em ocasiões especiais \n - Em feriados, este horário pode ser reduzido");
                break;
            case "2":
                JOptionPane.showMessageDialog(null, "\nTarifa: \n - A tarifa é de R$5, mas pode sofrer alterações em casos de reajuste \n\nComo Comprar Passagens: \n - Você pode adquirir seu bilhete nas máquinas e nos guichês.");
                break;
            case "3":
                JOptionPane.showMessageDialog(null, "\nFrequência de Trens: \n - Nos horários de pico, o intervalo de tempo entre trens é de 3 a 5 minutos \n - Fora do horário de pico, o intervalo pode ser maior.");
                break;
            case "4":
                JOptionPane.showMessageDialog(null, "\nIntegrações: \n - Integração com metrô está disponível em várias estações \n - Integrações com ônibus são viáveis em pontos principais.");
                break;
            case "5":
                JOptionPane.showMessageDialog(null, "\nAtendimento ao Cliente: \n - Caso precise de mais informações, nossa central de atendimento está disponível 24h.");
                break;
        }
    }
}