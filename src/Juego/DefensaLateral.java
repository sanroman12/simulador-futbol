package Juego;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

import static Juego.Datos.*;
import static Juego.Voids.*;

public class DefensaLateral extends Jugador{

    private int ataque;

    public DefensaLateral(int id, String nombre, String apellido,int edad, Float altura, int velocidad,int pase, int fuerza, int resistencia, int paseLargo, int control, int cabeceo, int intercepcion, int entrada, int barrida, int percepcion, int agresividad,int ataque){
        this.id = Id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.altura = altura;
        this.velocidad = velocidad;
        this.pase = pase;
        this.fuerza = fuerza;
        this.resistencia = resistencia;
        this.paseLargo = paseLargo;
        this.control = control;
        this.cabeceo = cabeceo;
        this.intercepcion = intercepcion;
        this.entrada = entrada;
        this.barrida = barrida;
        this.percepcion = percepcion;
        this.agresividad = agresividad;
        this.ataque = ataque;
        CalcularMedia();
        CalcularValor();
        CalcularSalario();
        calificacionPromedio = new ArrayList<>();
        Id++;
    }

    @Override
    public void CalcularMedia() {
        this.media = (float) (pase * 0.10 + control * 0.10 + paseLargo * 0.05 + intercepcion * 0.10 + entrada * 0.20 +
                barrida * 0.20 + percepcion * 0.10 + agresividad * 0.05 + ataque * 0.10);
    }

    @Override
    public void CalcularValor(){
        if(edad >= 15 && edad < 21){
            this.valor = (double) ((media * 100000 + 20000000)* 0.4);
        } else if (edad >=21 && edad < 28) {
            this.valor = (double) ((media * 1000000 + 10000000)* 0.4);
        } else if (edad >=28 && edad < 33) {
            this.valor = (double) ((media * 1000000 + 5000000)* 0.4);
        }else {
            this.valor = (double) ((media * 1000000)* 0.4);
        }
    }

    @Override
    public void CalcularSalario(){
        this.salario = (float) (valor * 0.04);
    }

    @Override
    public String Tipo(){
        return "Lateral";
    }

    @Override
    public String toStringLargo(){
        String valorFormateado = getFormato(valor);
        String salrioFormateado = getFormato(salario);
        return "Defensa Lateral{" + "id=" + id + ", nombre='" + nombre + " " + apellido + ", media=" + media +
                ", edad=" + edad + ", altura=" + altura + ", resistencia=" + resistencia +
                ", valor=" + valorFormateado + ", salario=" + salrioFormateado +  '}';
    }

    @Override
    public String toString() {
        String valorFormateado = getFormato(valor);
        String salrioFormateado = getFormato(salario);
        return "Defensa Lateral{" + "id=" + id + ", nombre='" + nombre + " " + apellido + ", media=" + media +
                ", edad=" + edad + '}';
    }

    public void agregarLateral(DefensaLateral lateral){
        listaLaterales.add(lateral);
    }


    public static void generarLateral(int cantidad,Equipo equipo){
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
            int paselargo = rand.nextInt(50) + 50;
            int control = rand.nextInt(50) + 50;
            int cabeceo = rand.nextInt(50) + 50;
            int intercepcion = rand.nextInt(50) + 50;
            int entrada = rand.nextInt(50) + 50;
            int barrida = rand.nextInt(50) + 50;
            int percepcion = rand.nextInt(50) + 50;
            int agersividad = rand.nextInt(50) + 50;
            int ataque = rand.nextInt(50) + 50;
            Jugador lateral =  new DefensaLateral(Id,nombre,apellido,edadAleatoria,altura,velocidad,
                    pase, fuerza, resistencia, paselargo,control,cabeceo,intercepcion,entrada,barrida,percepcion, agersividad, ataque);

            listaJugadores.add((Jugador) lateral);
            listaLaterales.add((DefensaLateral) lateral);


            equipo.JugadoresEquipo.add(lateral);
        }
    }

    public static void generarLateral(int cantidad){
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
            int paselargo = rand.nextInt(50) + 50;
            int control = rand.nextInt(50) + 50;
            int cabeceo = rand.nextInt(50) + 50;
            int intercepcion = rand.nextInt(50) + 50;
            int entrada = rand.nextInt(50) + 50;
            int barrida = rand.nextInt(50) + 50;
            int percepcion = rand.nextInt(50) + 50;
            int agersividad = rand.nextInt(50) + 50;
            int ataque = rand.nextInt(50) + 50;
            Jugador lateral =  new DefensaLateral(Id,nombre,apellido,edadAleatoria,altura,velocidad,
                    pase, fuerza, resistencia, paselargo,control,cabeceo,intercepcion,entrada,barrida,percepcion, agersividad, ataque);

            listaJugadores.add(lateral);
            listaLaterales.add((DefensaLateral) lateral);
            listaJugadoresLibres.add(lateral);
            listaLateralesLibres.add((DefensaLateral) lateral);


        }
    }

}
