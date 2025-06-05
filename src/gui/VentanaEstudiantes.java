package gui;


import personas.Estudiante;
import personas.GestorEstudiante;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VentanaEstudiantes extends JPanel {
    private JLabel titulo;
    private JButton regresarAlMenuButton;
    private JButton agregarButton, eliminarButton, buscarButton, editarButton, mostrarTablaButton;
    private JTextField nombreField, cedulaField, correoField, promedioField, puntajeField, cedulaBuscarField;
    private JCheckBox esDeportistaCheck;
    private JTable tabla;
    private JScrollPane scrollPane;
    private JPanel panelFormulario;
    private GestorEstudiante gestor;

    public VentanaEstudiantes() {
        this.setLayout(new BorderLayout());
        gestor = new GestorEstudiante();

        // Panel principal
        JPanel panel = new JPanel(new BorderLayout());

        // Título
        JLabel titulo = new JLabel("Gestión de Estudiantes", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 22));
        panel.add(titulo, BorderLayout.NORTH);

        // Formulario
        panelFormulario = new JPanel(new GridLayout(7, 2, 5, 5));
        nombreField = new JTextField();
        cedulaField = new JTextField();
        correoField = new JTextField();
        promedioField = new JTextField();
        puntajeField = new JTextField();
        cedulaBuscarField = new JTextField();
        esDeportistaCheck = new JCheckBox("¿Deportista?");

        panelFormulario.add(new JLabel("Nombre:")); panelFormulario.add(nombreField);
        panelFormulario.add(new JLabel("Cédula:")); panelFormulario.add(cedulaField);
        panelFormulario.add(new JLabel("Correo:")); panelFormulario.add(correoField);
        panelFormulario.add(new JLabel("Promedio:")); panelFormulario.add(promedioField);
        panelFormulario.add(new JLabel("Puntaje Económico:")); panelFormulario.add(puntajeField);
        panelFormulario.add(esDeportistaCheck); panelFormulario.add(new JLabel());
        panelFormulario.add(new JLabel("Buscar / Editar por Cédula:")); panelFormulario.add(cedulaBuscarField);

        panel.add(panelFormulario, BorderLayout.WEST);

        // Botones
        JPanel panelBotones = new JPanel(new GridLayout(5, 1, 5, 5));
        agregarButton = new JButton("Agregar Estudiante");
        eliminarButton = new JButton("Eliminar Estudiante");
        buscarButton = new JButton("Buscar Estudiante");
        editarButton = new JButton("Editar Estudiante");
        mostrarTablaButton = new JButton("Mostrar Todos");

        panelBotones.add(agregarButton);
        panelBotones.add(eliminarButton);
        panelBotones.add(buscarButton);
        panelBotones.add(editarButton);
        panelBotones.add(mostrarTablaButton);

        panelFormulario.add(panelBotones);

        // Tabla
        tabla = new JTable();
        scrollPane = new JScrollPane(tabla);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Botón de volver
        regresarAlMenuButton = new JButton("Regresar al Menú");
        JPanel panelRegreso = new JPanel();
        panelRegreso.add(regresarAlMenuButton);
        panel.add(panelRegreso, BorderLayout.SOUTH);

        // Añadir todo al GUI
        this.add(panel, BorderLayout.CENTER);

        // ACCIONES

        agregarButton.addActionListener(e -> {
            try {
                Estudiante nuevo = new Estudiante(
                        nombreField.getText(),
                        cedulaField.getText(),
                        correoField.getText(),
                        Double.parseDouble(promedioField.getText()),
                        esDeportistaCheck.isSelected(),
                        Integer.parseInt(puntajeField.getText())
                );
                gestor.agregarEstudiante(nuevo);
                JOptionPane.showMessageDialog(this, "Estudiante agregado correctamente.");
                actualizarTabla(gestor.getEstudiantes());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al agregar. Verifica los campos.");
            }
        });

        eliminarButton.addActionListener(e -> {
            String cedula = cedulaBuscarField.getText();
            boolean eliminado = gestor.eliminarEstudiante(cedula);
            if (eliminado) {
                JOptionPane.showMessageDialog(this, "Estudiante eliminado.");
                actualizarTabla(gestor.getEstudiantes());
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró el estudiante.");
            }
        });

        buscarButton.addActionListener(e -> {
            String cedula = cedulaBuscarField.getText();
            Estudiante encontrado = gestor.busquedaLinealPorCedula(cedula);
            if (encontrado != null) {
                llenarFormulario(encontrado);
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró ningún estudiante con esa cédula.");
            }
        });

        editarButton.addActionListener(e -> {
            String cedula = cedulaBuscarField.getText();
            Estudiante nuevo = new Estudiante(
                    nombreField.getText(),
                    cedula,
                    correoField.getText(),
                    Double.parseDouble(promedioField.getText()),
                    esDeportistaCheck.isSelected(),
                    Integer.parseInt(puntajeField.getText())
            );
            boolean editado = gestor.editarEstudiante(cedula, nuevo);
            if (editado) {
                JOptionPane.showMessageDialog(this, "Estudiante editado correctamente.");
                actualizarTabla(gestor.getEstudiantes());
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró el estudiante para editar.");
            }
        });

        mostrarTablaButton.addActionListener(e -> {
            actualizarTabla(gestor.getEstudiantes());
        });
    }

    // Metodo para mostrar la tabla
    private void actualizarTabla(java.util.List<Estudiante> lista) {
        tabla.setModel(gestor.generarTablaEstudiantes(lista).getModel());
    }

    // Llena el formulario con los datos del estudiante encontrado
    private void llenarFormulario(Estudiante e) {
        nombreField.setText(e.getNombre());
        cedulaField.setText(e.getCedula());
        correoField.setText(e.getCorreo());
        promedioField.setText(String.valueOf(e.getPromedio()));
        puntajeField.setText(String.valueOf(e.getPuntajeEconomico()));
        esDeportistaCheck.setSelected(e.isDeportista());
    }

    public JButton getRegresarAlMenuButton() {
        return regresarAlMenuButton;
    }
}
