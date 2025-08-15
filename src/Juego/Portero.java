package Juego;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

import static Juego.Datos.*;
import static Juego.Voids.*;

public class Portero extends Jugador {
    private int atajada;
    private int manejo;
    private int reflejos;
    private int pocicion;
    private int saque;

    public Portero(int id, String nombre, String apellido,int edad,  int atajada,int manejo, int reflejos, int pocicion, int saque, Float altura, int resistencia){
        this.id = Id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.atajada = atajada;
        this.manejo = manejo;
        this.reflejos = reflejos;
        this.pocicion = pocicion;
        this.saque = saque;
        this.altura = altura;
        this.resistencia = resistencia;
        CalcularMedia();
        CalcularValor();
        CalcularSalario();
        calificacionPromedio = new ArrayList<>();
        Id++;
    }

    @Override
    public void CalcularMedia() {
        this.media = (float) (atajada * .25 + manejo *.20 + reflejos * .30 + saque * .10 + pocicion * .15);
    }

    @Override
    public void CalcularValor(){
        if(edad >= 15 && edad < 21){
            this.valor = (double) ((media * 100000 + 20000000)* 0.3);
        } else if (edad >=21 && edad < 28) {
            this.valor = (double) ((media * 1000000 + 10000000)* 0.3);
        } else if (edad >=28 && edad < 33) {
            this.valor = (double) ((media * 1000000 + 5000000)* 0.3);
        }else {
            this.valor = (double) ((media * 1000000)* 0.3);
        }
    }

    @Override
    public void CalcularSalario(){
        this.salario = (float) (valor * 0.03);
    }

    @Override
    public String Tipo(){
        return "Portero";
    }

    @Override
    public String toStringLargo(){
        String valorFormateado = getFormato(valor);
        String salrioFormateado = getFormato(salario);
        return "Portero{" + "id=" + id + ", nombre='" + nombre + " " + apellido + ", media=" + media +
                ", edad=" + edad + ", altura=" + altura + ", resistencia=" + resistencia +
                ", valor=" + valorFormateado + ", salario=" + salrioFormateado +  '}';
    }

    @Override
    public String toString() {
        String valorFormateado = getFormato(valor);
        String salrioFormateado = getFormato(salario);
        return "Portero{" + "id=" + id + ", nombre='" + nombre + " " + apellido + ", media=" + media +
                ", edad=" + edad + '}';
    }

    public void agregarPortero(Portero portero){
        listaPorteros.add(portero);
    }

    public static void generarPortero(int cantidad, Equipo equipo){
        Random rand = new Random();
        for(int i = 0;i<cantidad;i++) {
            String nombre = nombreAleatorio();
            String apellido = apellidoAleatorio();
            int edadAleatoria = rand.nextInt(31) + 15;
            int atajada = rand.nextInt(50) + 50;
            int manejo = rand.nextInt(50) + 50;
            int reflejos = rand.nextInt(50) + 50;
            int pocicion = rand.nextInt(50) + 50;
            int saque = rand.nextInt(50) + 50;
            Float altura = (float) (1.50 + rand.nextFloat() *(2.15 - 1.50));
            int resistencia = rand.nextInt(50) + 50;
            Jugador portero =  new Portero(Id,nombre,apellido,
                    edadAleatoria,atajada, manejo,reflejos,pocicion,saque,altura,resistencia);

            listaJugadores.add((Jugador) portero);
            listaPorteros.add((Portero) portero);


            equipo.JugadoresEquipo.add(portero);

        }
    }

    public static void generarPortero(int cantidad){
        Random rand = new Random();
        for(int i = 0;i<cantidad;i++) {
            String nombre = nombreAleatorio();
            String apellido = apellidoAleatorio();
            int edadAleatoria = rand.nextInt(31) + 15;
            int atajada = rand.nextInt(50) + 50;
            int manejo = rand.nextInt(50) + 50;
            int reflejos = rand.nextInt(50) + 50;
            int pocicion = rand.nextInt(50) + 50;
            int saque = rand.nextInt(50) + 50;
            Float altura = (float) (1.50 + rand.nextFloat() *(2.15 - 1.50));
            int resistencia = rand.nextInt(50) + 50;
            Jugador portero =  new Portero(Id,nombre,apellido,
                    edadAleatoria,atajada, manejo,reflejos,pocicion,saque,altura,resistencia);

            listaJugadores.add(portero);
            listaPorteros.add((Portero) portero);
            listaJugadoresLibres.add( portero);
            listaPorterosLibres.add((Portero) portero);


        }
    }
}
