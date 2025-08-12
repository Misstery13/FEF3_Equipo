package tarea3.fef3;

import java.util.ArrayList;
import java.util.List;

public class Equipo {
    private String nombreEq;
    private String ciudad;
    private String estado;

    private List<Personal> personal;
    private List<Directivo> directivos;
    private List<EquipoTec> equipoTec;
    private List<Jugadores> jugadores;

    public Equipo(String nombreEq, String ciudad, String estado) {
        this.nombreEq = nombreEq;
        this.ciudad = ciudad;
        this.estado = estado;
        this.personal = new ArrayList<>();
        this.directivos = new ArrayList<>();
        this.equipoTec = new ArrayList<>();
        this.jugadores = new ArrayList<>();
    }
    public String getNombreEq() {
        return nombreEq;
    }
    public void setNombreEq(String nombreEq) {
        this.nombreEq = nombreEq;
    }
    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Personal> getPersonal() {
        return personal;
    }
    public void setPersonal(List<Personal> personal) {
        this.personal = personal;
    }
    public List<Directivo> getDirectivos() {
        return directivos;
    }
    public void setDirectivos(List<Directivo> directivos) {
        this.directivos = directivos;
    }
    public List<EquipoTec> getEquipoTec() {
        return equipoTec;
    }
    public void setEquipoTec(List<EquipoTec> equipoTec) {
        this.equipoTec = equipoTec;
    }
    public List<Jugadores> getJugadores() {
        return jugadores;
    }
    public void setJugadores(List<Jugadores> jugadores) {
        this.jugadores = jugadores;
    }
}
