package becas;

public abstract class Beca {
    private String nombre;
    private String descripcion;
    private String requisitos;
    private String beneficios;

    public Beca(String nombre, String descripcion, String requisitos, String beneficios) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.requisitos = requisitos;
        this.beneficios = beneficios;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getRequisitos() {
        return requisitos;
    }

    public String getBeneficios() {
        return beneficios;
    }
}
