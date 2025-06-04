package personas;

public class Evaluador extends Persona {

    private String cargo;
    private String especialidad;

    public Evaluador(String nombre, String cedula, String correo, String cargo, String especialidad) {
        super(nombre, cedula, correo);
        this.cargo = cargo;
        this.especialidad = especialidad;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return super.toString() + " | Cargo: " + cargo + ", Especialidad: " + especialidad;
    }
}
