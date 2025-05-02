package ar.unrn.tp4.ejercicio3.Ui;


import ar.unrn.tp4.ejercicio3.Model.ArchivoConcurso;
import ar.unrn.tp4.ejercicio3.Model.ArchivoInscripto;
import ar.unrn.tp4.ejercicio3.Model.Concurso;
import ar.unrn.tp4.ejercicio3.Model.Inscripto;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RadioCompetition {
    public static final String TITLE = "Inscription to Competition";
    private final ArchivoConcurso serviceConcurso;
    private final ArchivoInscripto serviceInscripto;
    private List<Concurso> concursosDisponibles = new ArrayList<>(); //para obtener el id correcto del concurso
    private JPanel contentPane;
    private JLabel lblName;
    private JTextField txtName;
    private JLabel lblLastName;
    private JTextField txtLastName;
    private JLabel lblId;
    private JTextField txtId;
    private JLabel lblPhone;
    private JTextField txtPhone;
    private JLabel lblEmail;
    private JTextField txtEmail;
    private JComboBox<String> comboBox;
    private JButton btnOk;
    private JLabel lblCompetition;

    public RadioCompetition(ArchivoConcurso serviceConcurso, ArchivoInscripto serviceInscripto) {
        this.serviceConcurso = serviceConcurso;
        this.serviceInscripto = serviceInscripto;

        var frame = new JFrame(TITLE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 451, 229);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        frame.setContentPane(contentPane);
        formElements();
        layout();
        frame.setVisible(true);
    }

    private void formElements() {
        lblName = new JLabel("Nombre:");
        txtName = new JTextField();
        txtName.setColumns(10);
        lblLastName = new JLabel("Apellido:");
        txtLastName = new JTextField();
        txtLastName.setColumns(10);
        lblId = new JLabel("Dni:");
        txtId = new JTextField();
        txtId.setColumns(10);
        lblPhone = new JLabel("Telefono:");
        txtPhone = new JTextField();
        txtPhone.setColumns(10);
        lblEmail = new JLabel("Email:");
        txtEmail = new JTextField();
        txtEmail.setColumns(10);
        btnOk = new JButton("Ok");
        btnOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnOk.setEnabled(false);
                saveInscription();
                btnOk.setEnabled(true);
            }
        });
        lblCompetition = new JLabel("Concurso:");
        comboBox = new JComboBox<String>();
        todosLosConcursos();
    }

    private void todosLosConcursos() {
        // carga del archivo de texto concursos.txt los concursos
        // y los agrega al comboBox
        try {
            LocalDate hoy = LocalDate.now();
            for (var concurso : serviceConcurso.cargarConcursos()) {
                if (inscripcionDisponible(concurso, hoy)) {
                    concursosDisponibles.add(concurso);
                    comboBox.addItem(concurso.getNombre());
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar concursos: " + e.getMessage());
        }

    }


    private void saveInscription() {
        // Guarda en inscriptos.txt los datos de la persona y el concurso elegido
        try {
            String nombre = txtName.getText();
            String apellido = txtLastName.getText();
            String telefono = txtPhone.getText();
            String email = txtEmail.getText();
            int dni = Integer.parseInt(txtId.getText());
            int indexSeleccionado = comboBox.getSelectedIndex();
            if (indexSeleccionado >= 0) {
                Concurso concursoSeleccionado = concursosDisponibles.get(indexSeleccionado);
                int idDelConcurso = concursoSeleccionado.getId(); // ID real

                var inscripto = new Inscripto(apellido, nombre, telefono, email, idDelConcurso, dni);
                serviceInscripto.guardarIncripcion(inscripto);
            }
            JOptionPane.showMessageDialog(this.contentPane, "Inscripción exitosa");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(contentPane, "El DNI debe ser un número válido.");
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(contentPane, ex.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this.contentPane, "Error al guardar inscripción: " + e.getMessage());
        }

    }

    private boolean inscripcionDisponible(Concurso concurso, LocalDate hoy) {
        return (hoy.isEqual(concurso.CuandoIniciaIncripcion()) || hoy.isAfter(concurso.CuandoIniciaIncripcion()))
                && (hoy.isEqual(concurso.CuandoTerminaIncripcion()) || hoy.isBefore(concurso.CuandoTerminaIncripcion()));
    }

    private void layout() {
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(gl_contentPane
                .createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
                        .addGroup(gl_contentPane
                                .createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
                                        .createSequentialGroup()
                                        .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                .addComponent(lblLastName).addComponent(lblId)
                                                .addComponent(lblPhone).addComponent(lblEmail)
                                                .addComponent(lblName).addComponent(lblCompetition))
                                        .addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                        .addGroup(
                                                gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                                        .addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)
                                                        .addComponent(txtEmail, Alignment.TRAILING)
                                                        .addComponent(txtPhone, Alignment.TRAILING)
                                                        .addComponent(txtId, Alignment.TRAILING)
                                                        .addComponent(txtLastName, Alignment.TRAILING)
                                                        .addComponent(txtName, Alignment.TRAILING,
                                                                GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)))
                                .addComponent(btnOk, Alignment.TRAILING,
                                        GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap()));
        gl_contentPane
                .setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(txtName, GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblName))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblLastName).addComponent(txtLastName,
                                                GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                        .addComponent(lblId).addComponent(
                                                txtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(
                                                gl_contentPane.createSequentialGroup().addComponent(lblPhone)
                                                        .addPreferredGap(ComponentPlacement.UNRELATED)
                                                        .addComponent(lblEmail))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addComponent(txtPhone, GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(txtEmail, GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED).addGroup(
                                                        gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                                .addComponent(comboBox, GroupLayout.PREFERRED_SIZE,
                                                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(lblCompetition))))
                                .addPreferredGap(ComponentPlacement.RELATED).addComponent(btnOk)
                                .addContainerGap(67, Short.MAX_VALUE)));
        contentPane.setLayout(gl_contentPane);
    }
}