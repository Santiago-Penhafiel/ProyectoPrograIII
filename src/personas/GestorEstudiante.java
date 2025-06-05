package personas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class GestorEstudiante {
    private List<Estudiante> estudiantes;

    public GestorEstudiante() {
        this.estudiantes = new ArrayList<>();
    }

    public void agregarEstudiante(Estudiante e) {
        estudiantes.add(e);
    }

    public boolean eliminarEstudiante(String cedula) {
        return estudiantes.removeIf(e -> e.getCedula().equalsIgnoreCase(cedula));
    }

    public List<Estudiante> buscarPorNombre(String nombre) {
        List<Estudiante> encontrados = new ArrayList<>();
        for (Estudiante e : estudiantes) {
            if (e.getNombre().equalsIgnoreCase(nombre)) {
                encontrados.add(e);
            }
        }
        return encontrados;
    }

    public Estudiante buscarPorCedula(String cedula) {
        for (Estudiante e : estudiantes) {
            if (e.getCedula().equalsIgnoreCase(cedula)) {
                return e;
            }
        }
        return null; // No encontrado
    }

    public boolean editarEstudiante(String cedula, Estudiante actualizado) {
        for (int i = 0; i < estudiantes.size(); i++) {
            Estudiante actual = estudiantes.get(i);
            if (actual.getCedula().equalsIgnoreCase(cedula)) {
                estudiantes.set(i, actualizado);
                return true;
            }
        }
        return false;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    // Ordenar por promedio usando Bubble Sort
    public void ordenarPorPromedio() {
        for (int i = 0; i < estudiantes.size() - 1; i++) {
            for (int j = 0; j < estudiantes.size() - i - 1; j++) {
                if (estudiantes.get(j).getPromedio() > estudiantes.get(j + 1).getPromedio()) {
                    Estudiante temp = estudiantes.get(j);
                    estudiantes.set(j, estudiantes.get(j + 1));
                    estudiantes.set(j + 1, temp);
                }
            }
        }
    }

    // busqueda lineal
    public Estudiante busquedaLinealPorCedula(String cedula) {
        for (int i = 0; i < estudiantes.size(); i++) {
            if (estudiantes.get(i).getCedula().equalsIgnoreCase(cedula)) {
                return estudiantes.get(i); // Devuelve el estudiante encontrado
            }
        }
        return null; // No se encontró
    }

    // Tabla visual desde cualquier lista
    public JTable generarTablaEstudiantes(List<Estudiante> lista) {
        String[] columnas = {"Nombre", "Cédula", "Correo", "Promedio", "¿Deportista?", "Puntaje Económico"};
        DefaultTableModel model = new DefaultTableModel(columnas, 0);

        for (Estudiante e : lista) {
            Object[] fila = {
                    e.getNombre(),
                    e.getCedula(),
                    e.getCorreo(),
                    e.getPromedio(),
                    e.isDeportista() ? "Sí" : "No",
                    e.getPuntajeEconomico()
            };
            model.addRow(fila);
        }

        return new JTable(model);
    }
}
