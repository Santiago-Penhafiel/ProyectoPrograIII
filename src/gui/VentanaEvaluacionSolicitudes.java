package gui;

import javax.swing.*;
import java.awt.*;

public class VentanaEvaluacionSolicitudes extends JPanel{
    private JPanel panel;
    private JLabel titulo;
    private JButton regresarAlMenúButton;

    public VentanaEvaluacionSolicitudes() {
        this.setLayout(new BorderLayout());
        this.add(panel, BorderLayout.CENTER);
    }

    public JButton getRegresarAlMenúButton() {
        return regresarAlMenúButton;
    }
}
