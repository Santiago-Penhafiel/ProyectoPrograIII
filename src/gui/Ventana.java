package gui;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    private CardLayout card;
    private JPanel panel;
    private VentanaMenu ventanaMenu;

    public Ventana(){
        this.setTitle("Sistema de Becas");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        card = new CardLayout();
        panel = new JPanel(card);

        ventanaMenu = new VentanaMenu();
        panel.add(ventanaMenu, "menu");

        this.setContentPane(panel);

        ventanaMenu.getGestiónDeEstudiantesButton().addActionListener(e -> card.show(panel,""));

        card.show(panel, "menu");

        this.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Ventana::new);
    }

}
