package solicitudes;

import personas.Evaluador;

public class EvaluacionSolicitud {
    private SolicitudBeca solicitud;
    private Evaluador evaluador;
    private double puntaje;
    private String observaciones;
    private EstadoEvaluacion estado;

    public enum EstadoEvaluacion {
        PENDIENTE,
        EN_REVISION,
        APROBADA,
        RECHAZADA
    }

    public EvaluacionSolicitud(SolicitudBeca solicitud, Evaluador evaluador) {
        this.solicitud = solicitud;
        this.evaluador = evaluador;
        this.estado = EstadoEvaluacion.PENDIENTE;
    }

    public SolicitudBeca getSolicitud() {
        return solicitud;
    }

    public Evaluador getEvaluador() {
        return evaluador;
    }

    public double getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(double puntaje) {
        this.puntaje = puntaje;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public EstadoEvaluacion getEstado() {
        return estado;
    }

    public void setEstado(EstadoEvaluacion estado) {
        this.estado = estado;
    }

    public void evaluar(double puntaje, String observaciones, EstadoEvaluacion estado) {
        this.puntaje = puntaje;
        this.observaciones = observaciones;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Evaluación de la solicitud de " + solicitud.getEstudiante().getNombre() +
                " por " + evaluador.getNombre() +
                " | Puntaje: " + puntaje +
                " | Estado: " + estado +
                " | Observaciones: " + observaciones;
    }
}
