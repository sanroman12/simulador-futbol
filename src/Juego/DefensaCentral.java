package Juego;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

import static Juego.Datos.*;
import static Juego.Equipo.agregarJugadores;
import static Juego.Voids.*;

public class DefensaCentral extends Jugador {

    private int perfilamiento;
    public DefensaCentral(int id, String nombre, String apellido,int edad, Float altura, int velocidad,int pase, int fuerza, int resistencia, int paseLargo, int control, int cabeceo, int intercepcion, int entrada, int barrida, int percepcion, int agresividad,int perfilamiento){
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
        this.perfilamiento = perfilamiento;
        CalcularMedia();
        CalcularValor();
        CalcularSalario();
        calificacionPromedio = new ArrayList<>();
        Id++;
    }

    @Override
    public void CalcularMedia() {
        this.media = (float) (control * 0.05 + pase * 0.05 + intercepcion * 0.20 + entrada * 0.20 +
                barrida * 0.20 + percepcion * 0.1 + agresividad * 0.05 + perfilamiento * 0.15);
    }

    @Override
    public void CalcularValor(){
        if(edad >= 15 && edad < 21){
            this.valor = (double) ((media * 100000 + 20000000)* 0.5);
        } else if (edad >=21 && edad < 28) {
            this.valor = (double) ((media * 1000000 + 10000000)* 0.5);
        } else if (edad >=28 && edad < 33) {
            this.valor = (double) ((media * 1000000 + 5000000)* 0.5);
        }else {
            this.valor = (double) ((media * 1000000)* 0.5);
        }
    }

    @Override
    public void CalcularSalario(){
        this.salario = (float) (valor * 0.05);
    }

    @Override
    public String Tipo(){
        return "Central";
    }

    @Override
    public String toStringLargo(){
        String valorFormateado = getFormato(valor);
        String salrioFormateado = getFormato(salario);
        return "Defensa Central{" + "id=" + id + ", nombre='" + nombre + " " + apellido + ", media=" + media +
                ", edad=" + edad + ", altura=" + altura + ", resistencia=" + resistencia +
                ", valor=" + valorFormateado + ", salario=" + salrioFormateado +  '}';
    }

    @Override
    public String toString() {
        String valorFormateado = getFormato(valor);
        String salrioFormateado = getFormato(salario);
        return "Defensa Central{" + "id=" + id + ", nombre='" + nombre + " " + apellido + ", media=" + media +
                ", edad=" + edad + '}';
    }

    public void agregarCentral(DefensaCentral central){
        listaCentrales.add(central);
    }

    public static void generarCentral(int cantidad, Equipo equipo){
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
            int perfilamiento = rand.nextInt(50) + 50;
            Jugador Central =  new DefensaCentral(Id,nombre,apellido,edadAleatoria,altura,velocidad,
                    pase, fuerza, resistencia, paselargo,control,cabeceo,intercepcion,entrada,barrida,percepcion, agersividad, perfilamiento);

            listaJugadores.add((Jugador) Central);
            listaCentrales.add((DefensaCentral) Central);


            equipo.JugadoresEquipo.add(Central);

            
        }
    }

    public static void generarCentral(int cantidad){
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
            int perfilamiento = rand.nextInt(50) + 50;
            Jugador Central =  new DefensaCentral(Id,nombre,apellido,edadAleatoria,altura,velocidad,
                    pase, fuerza, resistencia, paselargo,control,cabeceo,intercepcion,entrada,barrida,percepcion, agersividad, perfilamiento);

            listaJugadores.add(Central);
            listaCentrales.add((DefensaCentral) Central);
            listaJugadoresLibres.add(Central);
            listaCentralesLibres.add((DefensaCentral) Central);


        }
    }


}
