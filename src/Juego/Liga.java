package Juego;

import java.util.ArrayList;
import java.util.List;

public class Liga {
    private String NombreLiga;
    private String Pais;
    private List<String> Calendario;
    private List<String> Goleadores;
    private List<String> tablaGeneral;
    private int numJugadores;
    private int num_equipos;
    static ArrayList<Equipo> equipos;

    private int numJornadas;


    //Clases
    public Liga(String nombreLiga, String pais){
        this.NombreLiga = nombreLiga;
        this.Pais = pais;
        this.equipos = new ArrayList<>();
        this.Calendario = new ArrayList<>();
        this.Goleadores = new ArrayList<>();
        this.tablaGeneral = new ArrayList<>();
    }

    //setters
    public void setNombreLiga(String nombreLiga) {
        this.NombreLiga = nombreLiga;
    }
    public void setPais(String pais) {
        this.Pais = pais;
    }

    public void setNum_equipos(int num_equipos) {
        if(num_equipos >= 4 && num_equipos <= 35){
            this.num_equipos = num_equipos;
        } else {
            this.num_equipos = 18;
        }

    }

    //getters

    public int getNum_equipos() {
        return num_equipos;
    }
    public List<Equipo> getEquipos() {
        return equipos;
    }
    public String getNombreLiga() {
        return NombreLiga;
    }
    public String getPais() {
        return Pais;
    }

    public int getNumJornadas() {
        return num_equipos - 1;
    }

    //voids
    public void agregarEquipo(Equipo equipo) {
        equipos.add(equipo);
    }

    public static void agregarEquipos(Equipo equipo) {
        equipos.add(equipo);
    }

    public void toStringEquipos(){
        for(Equipo equipo: equipos){
            System.out.println(equipo);
        }
    }

}