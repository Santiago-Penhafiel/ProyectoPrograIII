package gui;

import javax.swing.*;
import java.awt.*;

public class VentanaMenu extends JPanel{
    private JPanel panel;
    private JButton gestiónDeEstudiantesButton;
    private JButton solicitudesDeBecaButton;
    private JButton tiposDeBecaButton;
    private JButton evaluciónDeSolicitudesButton;
    private JButton reportesYEstadísticasButton;

    public VentanaMenu() {
        this.setLayout(new BorderLayout());
        this.add(panel, BorderLayout.CENTER);
    }

    public JButton getGestiónDeEstudiantesButton() {
        return gestiónDeEstudiantesButton;
    }

    public JButton getSolicitudesDeBecaButton() {
        return solicitudesDeBecaButton;
    }

    public JButton getTiposDeBecaButton() {
        return tiposDeBecaButton;
    }

    public JButton getEvaluciónDeSolicitudesButton() {
        return evaluciónDeSolicitudesButton;
    }

    public JButton getReportesYEstadísticasButton() {
        return reportesYEstadísticasButton;
    }
}
