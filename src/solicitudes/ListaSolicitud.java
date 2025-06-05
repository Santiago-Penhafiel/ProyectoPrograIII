package solicitudes;
import personas.Estudiante;
import becas.Beca;

import java.util.ArrayList;
import java.util.List;

public class ListaSolicitud {
    private List<SolicitudBeca> solicitudes;

    public ListaSolicitud() {
        this.solicitudes = new ArrayList<>();
    }

    // Agregar solicitud si el estudiante cumple requisitos
    public boolean agregarSolicitud(Estudiante estudiante, Beca beca) {
        SolicitudBeca nueva = new SolicitudBeca(estudiante, beca);

        if (nueva.cumpleRequisitos()) {
            solicitudes.add(nueva);
            return true; // Agregada
        }
        return false; // No cumple requisitos
    }

    // Obtener todas las solicitudes
    public List<SolicitudBeca> listarSolicitudes() {
        return solicitudes;
    }

    // Buscar por cédula de estudiante
    public List<SolicitudBeca> buscarPorCedula(String cedula) {
        List<SolicitudBeca> resultado = new ArrayList<>();
        for (SolicitudBeca s : solicitudes) {
            if (s.getEstudiante().getCedula().equalsIgnoreCase(cedula)) {
                resultado.add(s);
            }
        }
        return resultado;
    }

    // Filtrar por estado ("Pendiente", "Aprobada", "Rechazada")
    public List<SolicitudBeca> filtrarPorEstado(String estado) {
        List<SolicitudBeca> resultado = new ArrayList<>();
        for (SolicitudBeca s : solicitudes) {
            if (s.getEstado().equalsIgnoreCase(estado)) {
                resultado.add(s);
            }
        }
        return resultado;
    }

    // Contar cuántas solicitudes hay por estado
    public int contarPorEstado(String estado) {
        int count = 0;
        for (SolicitudBeca s : solicitudes) {
            if (s.getEstado().equalsIgnoreCase(estado)) {
                count++;
            }
        }
        return count;
    }
}
