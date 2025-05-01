package ar.unrn.tp4.ejercicio3.Main;

import ar.unrn.tp4.ejercicio3.RadioCompetition;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new Main().start();
                } catch (Exception e) {
                    // log exception...
                    System.out.println(e);
                }
            }
        });
    }

    private void start() {
        new RadioCompetition();
    }
}