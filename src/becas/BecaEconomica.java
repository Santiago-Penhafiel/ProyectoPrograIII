package becas;

import personas.Estudiante;

public class BecaEconomica extends Beca {

    private int puntajeMaxEconomico;

    public BecaEconomica(int puntajeMaxEconomico) {
        super(
                "Beca Económica",
                "Destinada a estudiantes con recursos económicos limitados.",
                "Puntaje económico máximo permitido: " + puntajeMaxEconomico + ".",
                "Ayuda financiera mensual y cobertura de materiales académicos básicos."
        );
        this.puntajeMaxEconomico = puntajeMaxEconomico;
    }

    public int getPuntajeMaxEconomico(){
        return puntajeMaxEconomico;
    }

    @Override
    public boolean cumpleRequisitos(Estudiante estudiante){
        return estudiante.getPuntajeEconomico() <= puntajeMaxEconomico;
    }
}
