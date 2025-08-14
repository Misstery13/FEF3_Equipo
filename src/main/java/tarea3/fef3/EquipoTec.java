package tarea3.fef3;

public class EquipoTec {
    private String ci;
    private String nombres;
    private String nacionalidad;
    private String cargo;
    private String equipo;

    public EquipoTec(String ci, String nombres, String nacionalidad, String cargo, String equipo) {
        this.ci = ci;
        this.nombres = nombres;
        this.nacionalidad = nacionalidad;
        this.cargo = cargo;
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
    public String getNacionalidad() {
        return nacionalidad;
    }
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public String getEquipo() {
        return equipo;
    }
    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }
}
