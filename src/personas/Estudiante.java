package personas;

public class Estudiante extends Persona {

    private double promedio;
    private boolean deportista;
    private int puntajeEconomico;

    public Estudiante(String nombre, String cedula, String correo, double promedio, boolean deportista, int puntajeEconomico) {
        super(nombre, cedula, correo);
        this.promedio = promedio;
        this.deportista = deportista;
        this.puntajeEconomico = puntajeEconomico;
    }

    public double getPromedio() {
        return promedio;
    }

    public boolean isDeportista() {
        return deportista;
    }

    public int getPuntajeEconomico() {
        return puntajeEconomico;
    }
}
