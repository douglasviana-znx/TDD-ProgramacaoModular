package testes;

import classes.Relogio;

public class Teste {
    public static void main(String[] args) {
        try {
            Relogio relogioPositivo1 = new Relogio(12, 30, 45);
            
            // Teste cronômetro
            relogioPositivo1.ligarCronometro();
            Thread.sleep(2000); // Espera por 2 segundos
            relogioPositivo1.desligarCronometro();
            System.out.println("Teste positivo 1 (Cronômetro): Tempo decorrido = " + relogioPositivo1.tempoDecorridoCronometro() + " ms");

            // Teste citar hora
            System.out.println("Teste positivo 1 (Citar Hora): " + relogioPositivo1.citarHora());
            
            // Teste definir e verificar alarme
            relogioPositivo1.definirAlarme(13, 0);
            Thread.sleep(1000); // Espera por 1 segundo
            relogioPositivo1.aumentarMinuto(); // Avança o tempo
            if (relogioPositivo1.verificarAlarme()) {
                System.out.println("Teste positivo 1 (Definir e Verificar Alarme): Alarme ativado!");
            } else {
                System.out.println("Teste positivo 1 (Definir e Verificar Alarme): Alarme não ativado.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.out.println("Teste positivo 1 falhou: " + e.getMessage());
        }

        // Testes negativos
        try {
            Relogio relogioNegativo1 = new Relogio(25, 30, 15);
            System.out.println("Teste negativo 1 passou: " + relogioNegativo1);
        } catch (IllegalArgumentException e) {
            System.out.println("Teste negativo 1 falhou: " + e.getMessage());
        }

        try {
            Relogio relogioNegativo2 = new Relogio(18, 75, 0);
            System.out.println("Teste negativo 2 passou: " + relogioNegativo2);
        } catch (IllegalArgumentException e) {
            System.out.println("Teste negativo 2 falhou: " + e.getMessage());
        }

        try {
            Relogio relogioNegativo3 = new Relogio(10, 30, -5);
            System.out.println("Teste negativo 3 passou: " + relogioNegativo3);
        } catch (IllegalArgumentException e) {
            System.out.println("Teste negativo 3 falhou: " + e.getMessage());
        }
    }
}