package gui;

import javax.swing.*;
import java.awt.*;

public class    VentanaReportes extends JPanel{

    private JButton regresarAlMenúButton;
    private JPanel panel;
    private JLabel titulo;

    public VentanaReportes() {
        this.setLayout(new BorderLayout());
        this.add(panel, BorderLayout.CENTER);
    }

    public JButton getRegresarAlMenúButton() {
        return regresarAlMenúButton;
    }
}
