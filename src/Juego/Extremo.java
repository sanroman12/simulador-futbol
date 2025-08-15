package Juego;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

import static Juego.Datos.*;
import static Juego.Voids.*;

public class Extremo extends Jugador{

    private int encare;

    public Extremo(int id, String nombre, String apellido, int edad, Float altura, int velocidad,int pase, int fuerza, int resistencia, int control, int paseLargo, int cabeceo, int tiro, int vision, int regate, int centro, int tiroLargo, int encare) {
        this.id = Id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.altura = altura;
        this.velocidad = velocidad;
        this.pase = pase;
        this.fuerza = fuerza;
        this.resistencia = resistencia;
        this.control = control;
        this.paseLargo = paseLargo;
        this.cabeceo = cabeceo;
        this.tiro = tiro;
        this.vision = vision;
        this.regate = regate;
        this.centro = centro;
        this.tiroLargo = tiroLargo;
        this.encare = encare;
        CalcularMedia();
        CalcularValor();
        CalcularSalario();
        calificacionPromedio = new ArrayList<>();
        Id++;
    }


    @Override
    public void CalcularMedia() {
        this.media = (float) (control * 0.15 + paseLargo * 0.15 + pase * 0.10 + regate * 0.20 +centro * 0.15 +
                tiroLargo * 0.10 + encare * 0.15);
    }

    @Override
    public void CalcularValor() {
        if (edad >= 15 && edad < 21) {
            this.valor = (double) ((media * 100000 + 20000000) * 0.9);
        } else if (edad >= 21 && edad < 28) {
            this.valor = (double) ((media * 1000000 + 10000000) * 0.9);
        } else if (edad >= 28 && edad < 33) {
            this.valor = (double) ((media * 1000000 + 5000000) * 0.9);
        } else {
            this.valor = (double) ((media * 1000000) * 0.9);
        }
    }

    @Override
    public void CalcularSalario() {
        this.salario = (float) (valor * 0.09);
    }

    @Override
    public String Tipo(){
        return "Extremo";
    }

    @Override
    public String toStringLargo() {
        String valorFormateado = getFormato(valor);
        String salrioFormateado = getFormato(salario);
        String tipo = Tipo();
        return "Extemo{" + "id=" + id + ", nombre='" + nombre + " " + apellido + ", media=" + media +
                ", edad=" + edad + ", altura=" + altura + ", resistencia=" + resistencia +
                ", valor=" + valorFormateado + ", salario=" + salrioFormateado + '}';
    }

    @Override
    public String toString() {
        String valorFormateado = getFormato(valor);
        String salrioFormateado = getFormato(salario);
        String tipo = Tipo();
        return "Extremo{" + "id=" + id + ", nombre='" + nombre + " " + apellido + ", media=" + media +
                ", edad=" + edad + '}';
    }


    public void agregarExtremo(Extremo extremo){
        listaExtremo.add(extremo);
    }

    public static void generarExtremo(int cantidad, Equipo equipo){
        Random rand = new Random();
        for(int i = 0;i<cantidad;i++) {
            String nombre = nombreAleatorio();
            String apellido = apellidoAleatorio();
            int edadAleatoria = rand.nextInt(31) + 15;
            Float altura = (float) (1.50 + rand.nextFloat() *(2.15 - 1.50));
            int velocidad = rand.nextInt(50) + 50;
            int pase = rand.nextInt(50) + 50;
            int fuerza = rand.nextInt(50) + 50;
            int resistencia = rand.nextInt(50) + 50;
            int control = rand.nextInt(50) + 50;
            int paselargo = rand.nextInt(50) + 50;
            int cabeceo = rand.nextInt(50) + 50;
            int tiro = rand.nextInt(50) + 50;
            int vision = rand.nextInt(50) + 50;
            int regate = rand.nextInt(50) + 50;
            int centro = rand.nextInt(50) + 50;
            int tirolargo = rand.nextInt(50) + 50;
            int encare = rand.nextInt(50) + 50;
            Jugador extremo =  new Extremo(Id,nombre ,apellido ,edadAleatoria,altura,velocidad,
                    pase, fuerza, resistencia, control, paselargo,cabeceo,tiro,vision,regate,centro, tirolargo, encare);

            listaJugadores.add((Jugador) extremo);
            listaExtremo.add((Extremo) extremo);


            equipo.JugadoresEquipo.add(extremo);
        }
    }

    public static void generarExtremo(int cantidad){
        Random rand = new Random();
        for(int i = 0;i<cantidad;i++) {
            String nombre = nombreAleatorio();
            String apellido = apellidoAleatorio();
            int edadAleatoria = rand.nextInt(31) + 15;
            Float altura = (float) (1.50 + rand.nextFloat() *(2.15 - 1.50));
            int velocidad = rand.nextInt(50) + 50;
            int pase = rand.nextInt(50) + 50;
            int fuerza = rand.nextInt(50) + 50;
            int resistencia = rand.nextInt(50) + 50;
            int control = rand.nextInt(50) + 50;
            int paselargo = rand.nextInt(50) + 50;
            int cabeceo = rand.nextInt(50) + 50;
            int tiro = rand.nextInt(50) + 50;
            int vision = rand.nextInt(50) + 50;
            int regate = rand.nextInt(50) + 50;
            int centro = rand.nextInt(50) + 50;
            int tirolargo = rand.nextInt(50) + 50;
            int encare = rand.nextInt(50) + 50;
            Jugador extremo =  new Extremo(Id,nombre,apellido,edadAleatoria,altura,velocidad,
                    pase, fuerza, resistencia, control, paselargo,cabeceo,tiro,vision,regate,centro, tirolargo, encare);

            listaJugadores.add( extremo);
            listaExtremo.add((Extremo) extremo);
            listaJugadoresLibres.add( extremo);
            listaExtremoLibres.add((Extremo) extremo);



        }
    }
}
