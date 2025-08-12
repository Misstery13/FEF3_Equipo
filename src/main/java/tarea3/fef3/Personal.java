package tarea3.fef3;

public class Personal {
    private String ci;
    private String nombres;
    private String ocupacion;


    public Personal(String ci, String nombres, String ocupacion) {
        this.ci = ci;
        this.nombres = nombres;
        this.ocupacion = ocupacion;
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
}
