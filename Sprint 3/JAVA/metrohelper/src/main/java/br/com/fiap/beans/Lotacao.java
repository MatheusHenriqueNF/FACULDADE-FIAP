package br.com.fiap.beans;

import java.util.Random;

public class Lotacao {
    public static void duvidaLotacao() {
        Random random = new Random();

        int vag1 = random.nextInt(90) + 10;
        int vag2 = random.nextInt(90) + 10;
        int vag3 = random.nextInt(90) + 10;
        int vag4 = random.nextInt(90) + 10;
        int vag5 = random.nextInt(90) + 10;
        int vag6 = random.nextInt(90) + 10;
        int vag7 = random.nextInt(90) + 10;
        int vag8 = random.nextInt(90) + 10;

        int tempoChegadaMin = random.nextInt(16);
        int tempoChegadaSeg = random.nextInt(60);

        System.out.println("\nA lotação de cada vagão é:");
        System.out.println("Vagão 1 = " + vag1 + "%");
        System.out.println("Vagão 2 = " + vag2 + "%");
        System.out.println("Vagão 3 = " + vag3 + "%");
        System.out.println("Vagão 4 = " + vag4 + "%");
        System.out.println("Vagão 5 = " + vag5 + "%");
        System.out.println("Vagão 6 = " + vag6 + "%");
        System.out.println("Vagão 7 = " + vag7 + "%");
        System.out.println("Vagão 8 = " + vag8 + "%");
        System.out.println("\nA chegada do próximo trem está prevista para " + tempoChegadaMin + " minutos e " + tempoChegadaSeg + " segundos");

        
    }
}

