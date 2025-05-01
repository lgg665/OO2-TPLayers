package ar.unrn.tp4.ejercicio1.ui;

import ar.unrn.tp4.ejercicio1.model.ParticipanteService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AgregarParticipante extends JFrame {
    private JTextField nombre;
    private JTextField telefono;
    private JTextField region;
    private ParticipanteService service;

    public AgregarParticipante(ParticipanteService service) {
        this.service = service;
        setupUIComponents();
    }

    private void setupUIComponents() {
        setTitle("Add Participant");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        nombre = new JTextField(10);
        telefono = new JTextField(10);
        region = new JTextField(10);
        region.setText("China");

        JPanel contentPane = new JPanel(new FlowLayout());
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.add(new JLabel("Nombre: "));
        contentPane.add(nombre);
        contentPane.add(new JLabel("Telefono: "));
        contentPane.add(telefono);
        contentPane.add(new JLabel("Region: "));
        contentPane.add(region);

        JButton botonCargar = new JButton("Cargar");
        botonCargar.addActionListener(e -> onBotonCargar());
        contentPane.add(botonCargar);

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


