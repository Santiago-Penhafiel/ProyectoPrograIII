package estudiantes;

public class Estudiante {
    private String id;
    private String nombre;
    private String carrera;
    private double promedio;
    private boolean deportista;
    private int puntajeEconomico;

    public Estudiante(String id, String nombre, String carrera, double promedio, boolean deportista, int puntajeEconomico) {
        this.id = id;
        this.nombre = nombre;
        this.carrera = carrera;
        this.promedio = promedio;
        this.deportista = deportista;
        this.puntajeEconomico = puntajeEconomico;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCarrera() {
        return carrera;
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
