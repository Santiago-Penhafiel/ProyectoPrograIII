package becas;

import estudiantes.Estudiante;

public class BecaAcademica extends Beca {
    private double promedioMinimo;

    public BecaAcademica(double promedioMinimo) {
        super(
                "Beca Académica",
                "Otorgada a estudiantes con excelente rendimiento académico.",
                "Promedio mínimo de " + promedioMinimo", sin materias reprobadas, y estar matriculado en al menos 4 materias.",
                "Cobertura total de matrícula y un estipendio mensual."
        );
        this.promedioMinimo = promedioMinimo;
    }

    public double getPromedioMinimo (){
        return promedioMinimo;
    }

    @Override
    public boolean cumpleRequisitos(Estudiante estudiante){
        return estudiante.getPromedio() >= promedioMinimo;
    }
}
