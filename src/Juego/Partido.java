package Juego;

public class Partido {
    private int jornada;
    private Equipo equipo1;
    private Equipo equipo2;
    private int mediaE1;
    private int mediaE2;
    private int tacticas1;
    private int tacticas2;

    public Partido(int jornada, Equipo equipo1, Equipo equipo2, int mediaE1, int mediaE2, int tacticas1, int tacticas2) {
        this.jornada = jornada;
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.mediaE1 = mediaE1;
        this.mediaE2 = mediaE2;
        this.tacticas1 = tacticas1;
        this.tacticas2 = tacticas2;
    }



}
