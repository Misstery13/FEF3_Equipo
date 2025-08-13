package tarea3.fef3;

public class Jugadores {
    private String ci;
    private String nombres;
    private String posicion;
    private int edad;
    private float peso;
    private String equipo;

    public Jugadores(String ci, String nombres, String posicion, int edad, float peso, String equipo) {
        this.ci = ci;
        this.nombres = nombres;
        this.posicion = posicion;
        this.edad = edad;
        this.peso = peso;
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

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }
}
