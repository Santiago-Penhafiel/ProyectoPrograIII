package becas;

import personas.Estudiante;

public class BecaDeportiva extends Beca {

    private double promedioMinimo;

    public BecaDeportiva(double promedioMinimo) {
        super(
                "Beca Deportiva",
                "Otorgada a estudiantes destacados en actividades deportivas.",
                "Pertenecer a un equipo deportivo institucional, mantener un promedio mínimo de" + promedioMinimo + ", y representar a la universidad en competencias.",
                "Exoneración parcial de matrícula y apoyo logístico para entrenamientos y competencias."
        );
        this.promedioMinimo = promedioMinimo;
    }

    public double getPromedioMinimo(){
        return promedioMinimo;
    }

    @Override
    public boolean cumpleRequisitos(Estudiante estudiante) {
        return estudiante.isDeportista() && estudiante.getPromedio() >= promedioMinimo;
    }
}
