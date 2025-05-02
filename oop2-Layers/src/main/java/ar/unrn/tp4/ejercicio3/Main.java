package ar.unrn.tp4.ejercicio3;

import ar.unrn.tp4.ejercicio3.DataBase.DBArchivoConcurso;
import ar.unrn.tp4.ejercicio3.DataBase.DBArchivoInscripto;
import ar.unrn.tp4.ejercicio3.Ui.RadioCompetition;

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
        var c = new DBArchivoConcurso();
        var i = new DBArchivoInscripto();
        new RadioCompetition(c, i);
    }
}