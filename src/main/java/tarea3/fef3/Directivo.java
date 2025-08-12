package tarea3.fef3;

public class Directivo {
    private String ci;
    private String nombres;
    private String cargo;

    public Directivo(String ci, String nombres, String cargo) {
        this.ci = ci;
        this.nombres = nombres;
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
