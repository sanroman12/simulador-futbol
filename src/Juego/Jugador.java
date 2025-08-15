package Juego;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static Juego.Datos.listaJugadores;

public abstract class Jugador{
    String nombre;
    String apellido;
    int id;
    int edad;
    private int moral;
    static ArrayList<Float> calificacionPromedio;
    Float altura;
    Double valor;
    Float salario;
    int goles;
    int asistencias;

    Float media;

    //media
    int velocidad;
    int pase;
    int fuerza;
    int resistencia;
    int control;
    int paseLargo;
    int cabeceo;

    //ofencivo
    int tiro;
    int vision;
    int regate;
    int centro;
    int tiroLargo;

    //defensivo
    int intercepcion;
    int entrada;
    int barrida;
    int percepcion;
    int agresividad;

    //getters

    public int getId() {
        return id;
    }
    public String getNombre() {
        return nombre + " " + apellido;
    }
    public int getEdad() {
        return edad;
    }

    public int getGoles() {
        return goles;
    }

    public int getAsistencias() {
        return asistencias;
    }

    public int getMoral() {
        return moral;
    }
    public Float getAltura() {
        return altura;
    }
    public double getValor() {
        return valor;
    }
    public Float getSalrio() {
        return salario;
    }
    public int getVelocidad() {
        return velocidad;
    }
    public int getPase() {
        return pase;
    }
    public int getFuerza() {
        return fuerza;
    }
    public int getResistencia() {
        return resistencia;
    }
    public int getControl() {
        return control;
    }
    public int getPaseLargo() {
        return paseLargo;
    }
    public int getCabeceo() {
        return cabeceo;
    }
    public int getIntercepcion() {
        return intercepcion;
    }
    public int getEntrada() {
        return entrada;
    }
    public int getBarrida() {
        return barrida;
    }
    public int getPercepcion() {
        return percepcion;
    }
    public int getAgresividad() {
        return agresividad;
    }
    public int getTiro() {
        return tiro;
    }
    public int getCentro() {
        return centro;
    }
    public int getRegate() {
        return regate;
    }
    public int getTiroLargo() {
        return tiroLargo;
    }
    public int getVision() {
        return vision;
    }
    public Float getMedia() {
        return media;
    }
    public static ArrayList<Float> getCalificacionPromedio() {
        return calificacionPromedio;
    }




    //setters


    public void setGoles(int goles) {
        this.goles = goles;
    }

    public void setAsistencias(int asistencias) {
        this.asistencias = asistencias;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public void setMoral(int moral) {
        this.moral = moral;
    }
    public void setAltura(Float altura) {
        this.altura = altura;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public void setSalrio(Float salrio) {
        this.salario = salrio;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }
    public void setPase(int pase) {
        this.pase = pase;
    }
    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }
    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }
    public void setControl(int control) {
        this.control = control;
    }
    public void setPaseLargo(int paseLargo) {
        this.paseLargo = paseLargo;
    }
    public void setCabeceo(int cabeceo) {
        this.cabeceo = cabeceo;
    }
    public void setIntercepcion(int intercepcion) {
        this.intercepcion = intercepcion;
    }
    public void setEntrada(int entrada) {
        this.entrada = entrada;
    }
    public void setBarrida(int barrida) {
        this.barrida = barrida;
    }
    public void setPercepcion(int percepcion) {
        this.percepcion = percepcion;
    }
    public void setAgresividad(int agresividad) {
        this.agresividad = agresividad;
    }
    public void setTiro(int tiro) {
        this.tiro = tiro;
    }
    public void setRegate(int regate) {
        this.regate = regate;
    }
    public void setCentro(int centro) {
        this.centro = centro;
    }
    public void setTiroLargo(int tiroLargo) {
        this.tiroLargo = tiroLargo;
    }
    public void setVision(int vision) {
        this.vision = vision;
    }
    public void setMedia(Float media) {
        this.media = media;
    }
    public void setCalificacionPromedio(ArrayList<Float> calificacionPromedio) {
        this.calificacionPromedio = calificacionPromedio;
    }




    //voids abstract
    public abstract void CalcularMedia();
    public abstract void CalcularValor();
    public abstract void CalcularSalario();
    public abstract String toString();
    public abstract String toStringLargo();
    public abstract String Tipo();



    //voids static
    public static void agregarJugador(Jugador jugador){
        listaJugadores.add(jugador);
    }
    public static void agregarCalificacion(float calificacion){
        calificacionPromedio.add(calificacion);
    }


    //voids
    public String getFormato(double valor){
        if(valor < 1000000){
            DecimalFormat formato = new DecimalFormat("$###,###");
            String valorFormateado = formato.format(valor);
            return  valorFormateado;
        } else if (valor >= 1000000 && valor < 10000000){
            DecimalFormat formato = new DecimalFormat("$#,###,###");
            String valorFormateado = formato.format(valor);
            return  valorFormateado;
        } else if (valor >= 10000000 && valor < 100000000){
            DecimalFormat formato = new DecimalFormat("$##,###,###");
            String valorFormateado = formato.format(valor);
            return  valorFormateado;
        } else if (valor >= 10000000 && valor < 1000000000) {
            DecimalFormat formato = new DecimalFormat("$###,###,###");
            String valorFormateado = formato.format(valor);
            return  valorFormateado;
        }else {
            return "valor irreconocible";
        }
    }

    public String getEstadisticas(){
        return nombre + " " + apellido + " - Goles = " + goles + " - Asistencias = " + asistencias + " \n";
    }


}