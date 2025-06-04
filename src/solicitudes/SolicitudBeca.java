package solicitudes;

import becas.Beca;
import personas.Estudiante;
import java.util.Date;

public class SolicitudBeca {

    private Estudiante estudiante;
    private Beca becaSolicitada;
    private String estado; // Ej: "Pendiente", "Aprobada", "Rechazada"
    private Date fechaSolicitud;

    public SolicitudBeca(Estudiante estudiante, Beca becaSolicitada) {
        this.estudiante = estudiante;
        this.becaSolicitada = becaSolicitada;
        this.estado = "Pendiente";
        this.fechaSolicitud = new Date(); // Fecha actual
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public Beca getBecaSolicitada() {
        return becaSolicitada;
    }

    public String getEstado() {
        return estado;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void aprobar() {
        this.estado = "Aprobada";
    }

    public void rechazar() {
        this.estado = "Rechazada";
    }

    public boolean cumpleRequisitos() {
        return becaSolicitada.cumpleRequisitos(estudiante);
    }

}
