package gui;

import becas.BecaAcademica;
import personas.Estudiante;
import solicitudes.ListaSolicitud;
import solicitudes.SolicitudBeca;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.util.List;
import java.awt.*;

public class VentanaSolicitudes extends JPanel {
    private JButton regresarAlMenúButton;
    private JButton agregarSolicitudButton;
    private JButton listarSolicitudesButton;
    private JTable tablaSolicitudes;
    private JScrollPane scrollPane;
    private JPanel panel;
    private JLabel titulo;
    private ListaSolicitud listaSolicitudes;

    public VentanaSolicitudes() {
        this.setLayout(new BorderLayout());
        listaSolicitudes = new ListaSolicitud(); // Manejador de solicitudes

        // Panel principal
        panel = new JPanel(new BorderLayout());

        // Título
        titulo = new JLabel("Gestión de Solicitudes de Beca", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 22));
        panel.add(titulo, BorderLayout.NORTH);

        // Tabla
        tablaSolicitudes = new JTable();
        scrollPane = new JScrollPane(tablaSolicitudes);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Botones
        JPanel panelBotones = new JPanel(new FlowLayout());
        regresarAlMenúButton = new JButton("Regresar al Menú");
        agregarSolicitudButton = new JButton("Agregar Solicitud");
        listarSolicitudesButton = new JButton("Listar Solicitudes");

        panelBotones.add(agregarSolicitudButton);
        panelBotones.add(listarSolicitudesButton);
        panelBotones.add(regresarAlMenúButton);

        panel.add(panelBotones, BorderLayout.SOUTH);

        // Agrega todo al panel principal
        this.add(panel, BorderLayout.CENTER);

        // Acción: Agregar Solicitud (simulada)
        agregarSolicitudButton.addActionListener(e -> {
            // Simulación de estudiante y beca (puedes reemplazarlo por campos reales)
            Estudiante estudiante = new Estudiante("Juan Pérez", "1101234567", "juan@email.com", 9.1, false, 40);
            BecaAcademica beca = new BecaAcademica(8.5);
            boolean agregado = listaSolicitudes.agregarSolicitud(estudiante,beca);

            if (agregado) {
                JOptionPane.showMessageDialog(this, "Solicitud agregada correctamente.");
            } else {
                JOptionPane.showMessageDialog(this, "El estudiante no cumple con los requisitos de la beca.");
            }
        });

        // Acción: Listar Solicitudes
        listarSolicitudesButton.addActionListener(e -> {
            actualizarTabla(listaSolicitudes.listarSolicitudes());
        });
    }

    // Actualiza la tabla con una lista de solicitudes
    private void actualizarTabla(List<SolicitudBeca> solicitudes) {
        String[] columnas = {"Estudiante", "Beca", "Estado", "Fecha"};
        DefaultTableModel model = new DefaultTableModel(columnas, 0);

        for (SolicitudBeca s : solicitudes) {
            Object[] fila = {
                    s.getEstudiante().getNombre(),
                    s.getBecaSolicitada().getNombre(),
                    s.getEstado(),
                    s.getFechaSolicitud().toString()
            };
            model.addRow(fila);
        }

        tablaSolicitudes.setModel(model);
    }

    public JButton getRegresarAlMenúButton() {
        return regresarAlMenúButton;
    }
}
