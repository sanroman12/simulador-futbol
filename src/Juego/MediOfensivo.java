package Juego;

import java.util.ArrayList;
import java.util.Random;

import static Juego.Datos.*;
import static Juego.Voids.*;

public class MediOfensivo extends Jugador {
    private int tiroLibre;

    public MediOfensivo(int id, String nombre, String apellido, int edad, Float altura, int velocidad, int pase, int fuerza, int resistencia, int control, int paseLargo, int cabeceo, int tiro, int vision, int regate, int centro, int tiroLargo, int tiroLibre) {
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
        this.tiroLibre = tiroLibre;
        CalcularMedia();
        CalcularValor();
        CalcularSalario();
        calificacionPromedio = new ArrayList<>();
        Id++;
    }


    @Override
    public void CalcularMedia() {
        this.media = (float) (control * 0.15 + paseLargo * 0.15 + pase * 0.20 + vision * 0.10 + regate * 0.15 +tiro * 0.05 +
                tiroLargo * 0.10 + tiroLibre * 0.10);
    }

    @Override
    public void CalcularValor() {
        if (edad >= 15 && edad < 21) {
            this.valor = (double) ((media * 100000 + 20000000) * 0.8);
        } else if (edad >= 21 && edad < 28) {
            this.valor = (double) ((media * 1000000 + 10000000) * 0.8);
        } else if (edad >= 28 && edad < 33) {
            this.valor = (double) ((media * 1000000 + 5000000) * 0.8);
        } else {
            this.valor = (double) ((media * 1000000) * 0.8);
        }
    }

    @Override
    public void CalcularSalario() {
        this.salario = (float) (valor * 0.08);
    }

    @Override
    public String Tipo(){
        return "Ofensivo";
    }

    @Override
    public String toStringLargo() {
        String valorFormateado = getFormato(valor);
        String salrioFormateado = getFormato(salario);
        return "Medio Ofensivo{" + "id=" + id + ", nombre='" + nombre + " " + apellido + ", media=" + media +
                ", edad=" + edad + ", altura=" + altura + ", resistencia=" + resistencia +
                ", valor=" + valorFormateado + ", salario=" + salrioFormateado +  '}';
    }

    @Override
    public String toString() {
        String valorFormateado = getFormato(valor);
        String salrioFormateado = getFormato(salario);
        return "Medio Ofensivo{" + "id=" + id + ", nombre='" + nombre + " " + apellido + ", media=" + media +
                ", edad=" + edad + '}';
    }

    public void agregarOfensivo(MediOfensivo mediOfensivo){
        listaJugadores.add(mediOfensivo);
    }

    public static void generarOfensivo(int cantidad,Equipo equipo){
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
            int tirolibre = rand.nextInt(50) + 50;
            Jugador mediOfensivo =  new MediOfensivo(Id,nombre ,apellido ,edadAleatoria,altura,velocidad,
                    pase, fuerza, resistencia, control, paselargo,cabeceo,tiro,vision,regate,centro, tirolargo, tirolibre);

            listaJugadores.add((Jugador) mediOfensivo);
            listaOfensivo.add((MediOfensivo) mediOfensivo);


            equipo.JugadoresEquipo.add(mediOfensivo);
        }
    }

    public static void generarOfensivo(int cantidad){
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
            int tirolibre = rand.nextInt(50) + 50;
            Jugador mediOfensivo =  new MediOfensivo(Id,nombre,apellido,edadAleatoria,altura,velocidad,
                    pase, fuerza, resistencia, control, paselargo,cabeceo,tiro,vision,regate,centro, tirolargo, tirolibre);

            listaJugadores.add( mediOfensivo);
            listaOfensivo.add((MediOfensivo) mediOfensivo);
            listaJugadoresLibres.add(mediOfensivo);
            listaOfensivoLibres.add((MediOfensivo) mediOfensivo);


        }
    }
}
