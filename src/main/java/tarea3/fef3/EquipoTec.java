package tarea3.fef3;

public class EquipoTec {
    private String ci;
    private String nombres;
    private String nacionalidad;
    private String cargo;

    public EquipoTec(String ci, String nombres, String nacionalidad, String cargo) {
        this.ci = ci;
        this.nombres = nombres;
        this.nacionalidad = nacionalidad;
        this.cargo = cargo;
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
}
