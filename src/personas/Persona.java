package personas;

public abstract class Persona {
    protected String nombre;
    protected String cedula;
    protected String correo;

    public Persona(String nombre, String cedula, String correo) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public String getCorreo() {
        return correo;
    }

    @Override
    public String toString() {
        return nombre + " (" + cedula + ")";
    }
}

