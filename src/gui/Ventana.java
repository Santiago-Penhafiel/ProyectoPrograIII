package gui;

import solicitudes.SolicitudBeca;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Ventana extends JFrame {
    private CardLayout card;
    private JPanel panel;
    private VentanaMenu ventanaMenu;

    private VentanaEstudiantes estudiantes;
    private VentanaSolicitudes solicitudes;
    private VentanaEvaluacionSolicitudes evaluacion;
    private VentanaTiposDeBeca tiposDeBeca;
    private VentanaReportes reportes;

    public Ventana(){
        this.setTitle("Sistema de Becas");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        card = new CardLayout();
        panel = new JPanel(card);

        ventanaMenu = new VentanaMenu();

        estudiantes = new VentanaEstudiantes();
        evaluacion = new VentanaEvaluacionSolicitudes();
        solicitudes = new VentanaSolicitudes();
        tiposDeBeca = new VentanaTiposDeBeca();
        reportes = new VentanaReportes();

        panel.add(ventanaMenu, "menu");

        panel.add(estudiantes, "estudiantes");
        panel.add(evaluacion, "evaluacion");
        panel.add(solicitudes, "solicitudes");
        panel.add(tiposDeBeca, "tiposDeBeca");
        panel.add(reportes, "reportes");

        this.setContentPane(panel);

        ventanaMenu.getGestiónDeEstudiantesButton().addActionListener(e -> card.show(panel,"estudiantes"));
        ventanaMenu.getSolicitudesDeBecaButton().addActionListener(e -> card.show(panel, "solicitudes"));
        ventanaMenu.getEvaluciónDeSolicitudesButton().addActionListener(e -> card.show(panel, "evaluacion"));
        ventanaMenu.getTiposDeBecaButton().addActionListener(e -> card.show(panel, "tiposDeBeca"));
        ventanaMenu.getReportesYEstadísticasButton().addActionListener(e -> card.show(panel, "reportes"));

        estudiantes.getRegresarAlMenuButton().addActionListener(e -> card.show(panel, "menu"));
        solicitudes.getRegresarAlMenúButton().addActionListener(e -> card.show(panel, "menu"));
        evaluacion.getRegresarAlMenúButton().addActionListener(e -> card.show(panel, "menu"));
        tiposDeBeca.getRegresarAlMenúButton().addActionListener(e -> card.show(panel, "menu"));
        reportes.getRegresarAlMenúButton().addActionListener(e -> card.show(panel, "menu"));

        card.show(panel, "menu");

        this.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Ventana::new);
    }

}
