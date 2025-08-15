package Juego;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static Juego.Voids.IdEquipo;


public class Equipo{
    private String NombreEquipo;
    private int presupuesto;
    static ArrayList<Jugador> JugadoresEquipo;
    static ArrayList<Jugador> Titulares;
    static ArrayList<Jugador> Banca;
    static ArrayList<Jugador> Racha;
    private int numJugadores;
    private int idEquipo;
    private int puntos;



    private double mediaEquipo;

    //tacticas
    private int velocidad;
    private int nivelDefensivo;
    private int nivelOfensivo;
    private int presion;
    private int complejidad;

    static int puntosTactica;



    //Clases
    public Equipo(List<String> nombresEquipos){
        this.idEquipo = IdEquipo;
        Random rand = new Random();
        int index = rand.nextInt(nombresEquipos.size());
        this.NombreEquipo = nombresEquipos.get(index);
        this.JugadoresEquipo = new ArrayList<>();
        this.Titulares = new ArrayList<>();
        this.Banca = new ArrayList<>();
        this.Racha = new ArrayList<>();

        nombresEquipos.remove(index);
        IdEquipo++;
    }

    public Equipo(String NombreEquipo){
        this.idEquipo = IdEquipo;
        this.NombreEquipo = NombreEquipo;
        this.JugadoresEquipo = new ArrayList<>();
        this.Titulares = new ArrayList<>();
        this.Banca = new ArrayList<>();
        this.Racha = new ArrayList<>();
        IdEquipo++;
    }


    //voids
    public static void agregarJugadores(Jugador jugador) {
        JugadoresEquipo.add(jugador);
    }
    public static void agregarTitulares(Jugador jugador) {
        Titulares.add(jugador);
    }
    public static void agregarBanca(Jugador jugador) {
        Banca.add(jugador);
    }

    public static void quitarJugadores(Jugador jugador) {
        JugadoresEquipo.remove(jugador);
    }
    public static void quitarTitulares(Jugador jugador) {
        Titulares.remove(jugador);
    }
    public static void quitarBanca(Jugador jugador) {
        Banca.remove(jugador);
    }





    //setters

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public void setNombreEquipo(String nombreEquipo) {
        NombreEquipo = nombreEquipo;
    }

    public void setIdEquipo(int idEquipo) {this.idEquipo = idEquipo;}

    public void setComplejidad(int complejidad) {
        this.complejidad = complejidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public void setNivelDefensivo(int nivelDefensivo) {
        this.nivelDefensivo = nivelDefensivo;
    }

    public void setNivelOfensivo(int nivelOfensivo) {
        this.nivelOfensivo = nivelOfensivo;
    }

    public void setPresion(int presion) {
        this.presion = presion;
    }

    public void setPresupuesto(int presupuesto) {
        this.presupuesto = presupuesto;
    }

    //getters
    public int getIdEquipo() {
        return idEquipo;
    }
    public List<Jugador> getJugadores(){
        return JugadoresEquipo;
    }
    public List<Jugador> getTitulares(){
        return Titulares;
    }
    public List<Jugador> getBanca() {
        return Banca;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public int getComplejidad() {
        return complejidad;
    }

    public int getNivelDefensivo() {
        return nivelDefensivo;
    }

    public int getNivelOfensivo() {
        return nivelOfensivo;
    }

    public double getMediaEquipo() {
        return mediaEquipo;
    }

    public int getPresion() {
        return presion;
    }

    public int getPresupuesto() {
        return presupuesto;
    }

    public int getNumJugadores() {
        return JugadoresEquipo.size();
    }

    public String getNombreEquipo() {
        return NombreEquipo;
    }

    public int getPuntos() {
        return puntos;
    }

    @Override
    public String toString() {
        return getNombreEquipo() + ", id = " + idEquipo + " ";
    }
}

