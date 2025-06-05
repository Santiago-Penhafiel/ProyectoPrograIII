package gui;

import javax.swing.*;
import java.awt.*;
import becas.Beca;
import becas.BecaAcademica;
import becas.BecaDeportiva;
import becas.BecaEconomica;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class VentanaTiposDeBeca extends JPanel{
    private JButton regresarAlMenúButton;
    private JPanel panel;
    private JLabel titulo;
    private JTable tablaTiposBeca;
    private JScrollPane scrollPane;

    public VentanaTiposDeBeca() {
        this.setLayout(new BorderLayout());

        // Crear el panel principal
        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Título
        titulo = new JLabel("Tipos de Becas Disponibles", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 22));
        panel.add(titulo, BorderLayout.NORTH);

        // Tabla
        String[] columnas = {"Nombre", "Descripción", "Requisitos", "Beneficios"};
        DefaultTableModel model = new DefaultTableModel(columnas, 0);
        tablaTiposBeca = new JTable(model);
        scrollPane = new JScrollPane(tablaTiposBeca);

        // Simulación de becas (puedes adaptarlo a tu lógica real si usas un sistema de carga)
        List<Beca> becas = new ArrayList<>();
        becas.add(new BecaAcademica(8.5));
        becas.add(new BecaDeportiva(7.5));
        becas.add(new BecaEconomica(60));

        for (Beca beca : becas) {
            model.addRow(new Object[]{
                    beca.getNombre(),
                    beca.getDescripcion(),
                    beca.getRequisitos(),
                    beca.getBeneficios()
            });
        }

        panel.add(scrollPane, BorderLayout.CENTER);

        // Botón volver
        regresarAlMenúButton = new JButton("Regresar al Menú");
        JPanel panelBoton = new JPanel();
        panelBoton.add(regresarAlMenúButton);
        panel.add(panelBoton, BorderLayout.SOUTH);

        // Agregar al panel principal
        this.add(panel, BorderLayout.CENTER);
    }

    public JButton getRegresarAlMenúButton() {
        return regresarAlMenúButton;
    }
}
