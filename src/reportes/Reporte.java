package reportes;

import solicitudes.SolicitudBeca;
import solicitudes.EvaluacionSolicitud;
import personas.Estudiante;
import becas.Beca;

import java.util.List;

public class Reporte {

    // Por simplicidad, suponemos que recibes las listas a procesar
    public static void generarReportePorTipoDeBeca(List<SolicitudBeca> solicitudes) {
        System.out.println("=== Reporte por Tipo de Beca ===");
        for (SolicitudBeca solicitud : solicitudes) {
            Beca beca = solicitud.getBecaSolicitada();
            Estudiante estudiante = solicitud.getEstudiante();
            System.out.println("- " + beca.getNombre() + ": " + estudiante.getNombre());
        }
    }

    public static void generarPromediosPorCarrera(List<SolicitudBeca> solicitudes) {
        System.out.println("=== Promedios por Carrera ===");

        // Aquí podrías agrupar por carrera y calcular promedios
        // Este método puede volverse más complejo usando mapas si lo deseas
    }

    public static void generarResumenEvaluaciones(List<EvaluacionSolicitud> evaluaciones) {
        System.out.println("=== Estado de Evaluaciones ===");
        for (EvaluacionSolicitud eval : evaluaciones) {
            System.out.println(eval.toString());
        }
    }

    // Puedes agregar más métodos según filtros y estadísticas necesarias
}
