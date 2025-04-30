package ar.unrn.tp4.ejercicio1.ui;

import ar.unrn.tp4.ejercicio1.model.ParticipanteService;

import javax.swing.*;
import java.awt.*;

public class AgregarParticipante extends JFrame {
    private JTextField nombre;
    private JTextField telefono;
    private JTextField region;
    private ParticipanteService service; // Interfaz

    public AgregarParticipante(ParticipanteService service) {
        this.service = service;
        setupUIComponents();
    }

//    private void setupBaseDeDatos() throws SQLException {
//        String url = "jdbc:derby://localhost:1527/participantes";
//        String user = "app";
//        String password = "app";
//        this.dbConn = DriverManager.getConnection(url, user, password);
//    }

    private void setupUIComponents() {
        setTitle("Agregar Participante");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        nombre = new JTextField(10);
        telefono = new JTextField(10);
        region = new JTextField(10);
        region.setText("China");

        JPanel contentPane = new JPanel(new FlowLayout());
        contentPane.add(new JLabel("Nombre:"));
        contentPane.add(nombre);
        contentPane.add(new JLabel("Teléfono:"));
        contentPane.add(telefono);
        contentPane.add(new JLabel("Región:"));
        contentPane.add(region);

        JButton cargar = new JButton("Cargar");
        cargar.addActionListener(e -> onBotonCargar());
        contentPane.add(cargar);

        setContentPane(contentPane);
        pack();
        setVisible(true);
    }

    private void onBotonCargar() {
        try {
            service.agregarParticipante(nombre.getText(), telefono.getText(), region.getText());
            dispose();
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error inesperado: " + ex.getMessage());
        }
    }

}


