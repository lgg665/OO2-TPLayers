package ar.unrn.tp4.ejercicio1.ui;

import ar.unrn.tp4.ejercicio1.model.ParticipanteService;

import javax.swing.*;
import java.awt.*;

public class AgregarParticipante extends JFrame {
    private final JTextField nombre = new JTextField(10);
    private final JTextField telefono = new JTextField(10);
    private final JTextField region = new JTextField(10);
    private final ParticipanteService service;

    public AgregarParticipante(ParticipanteService service) {
        this.service = service;
        setupUI();
    }

    private void setupUI() {
        setTitle("Agregar Participante");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        region.setText("China");

        add(new JLabel("Nombre:"));
        add(nombre);
        add(new JLabel("Teléfono:"));
        add(telefono);
        add(new JLabel("Región:"));
        add(region);

        JButton boton = new JButton("Cargar");
        boton.addActionListener(e -> cargarParticipante());
        add(boton);

        pack();
        setVisible(true);
    }

    private void cargarParticipante() {
        try {
            service.agregarParticipante(nombre.getText(), telefono.getText(), region.getText());
            JOptionPane.showMessageDialog(this, "Participante guardado");
            dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }
}