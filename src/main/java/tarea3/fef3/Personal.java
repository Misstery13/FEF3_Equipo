package tarea3.fef3;

public class Personal {
    private String ci;
    private String nombres;
    private String ocupacion;
    private String equipo;


    public Personal(String ci, String nombres, String ocupacion, String equipo) {
        this.ci = ci;
        this.nombres = nombres;
        this.ocupacion = ocupacion;
        this.equipo = equipo;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }
    public String getEquipo() {
        return equipo;
    }
    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }
}
