package Juego;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static Juego.Voids.*;

public class Juegos {


    public static void menuDeJuego(Equipo equipo, Liga liga) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1)jugar \n2) salir\n");
        int op = tomaropcion();
        if(op == 1){
            System.out.println(liga.getEquipos());
            System.out.println("a que equipo te vas a enfretar \n");
            int id = scanner.nextInt();
            Equipo rival = buscarIdEquipo(id, liga);
            Juego(equipo, rival, liga);
        }
        MenuJuego(equipo,liga);

    }


    public static void Juego(Equipo local, Equipo visitante, Liga liga){
        double mediaLocal = getMediaEquipo(local) + calculoTacticoRival(local, visitante);
        double mediaVisita = getMediaEquipo(visitante) + calculoTacticoRival(visitante, local);
        int defLocal = local.getNivelDefensivo();
        int ofLocal = local.getNivelOfensivo();
        int defVisita = visitante.getNivelDefensivo();
        int ofVisita = visitante.getNivelOfensivo();
        double resistenciaL = resistenciaPromedio(local);
        double resistenciaV = resistenciaPromedio(visitante);
        int presionL = local.getPresion();
        int presionV = visitante.getPresion();
        int marcadorL = 0;
        int marcadorV = 0;
        int velocidadL = local.getVelocidad();
        int velocidadV = visitante.getVelocidad();

        //minuto 0 - 10
        if(presionL > presionV){
            goledor(local);
            asistencia(local);
            marcadorL++;
            resistenciaL -= 10;
            resistenciaV -= 5;
        } else if (presionV > presionL){
            goledor(visitante);
            asistencia(visitante);
            marcadorV++;
            resistenciaV -= 10;
            resistenciaL -= 5;
        } else {
            resistenciaL -= 5;
            resistenciaV -= 5;
        }

        //minuto 10 - 20
        if(mediaLocal > mediaVisita){
            goledor(local);
            asistencia(local);
            marcadorL++;
        } else if (mediaVisita > mediaLocal){
            goledor(visitante);
            marcadorV++;
            asistencia(visitante);
        }
        resistenciaL -= 5;
        resistenciaV -= 5;

        //minuto 20 - 30
        if(ofLocal > defVisita){
            goledor(local);
            marcadorL++;
            asistencia(local);
            resistenciaL -= 10;
            resistenciaV -= 5;
        } else {
            resistenciaL -= 5;
            resistenciaV -= 5;
        }

        //minuto 30 - 45
        if (ofVisita > defLocal){
            goledor(visitante);
            marcadorV++;
            asistencia(visitante);
            resistenciaV -= 10;
            resistenciaL -= 5;
        } else {
            resistenciaL -= 5;
            resistenciaV -= 5;
        }

        //minuto 45 - 60
        if (ofVisita > defLocal){
            goledor(visitante);
            marcadorV++;
            asistencia(visitante);
            resistenciaV -= 10;
            resistenciaL -= 5;
        } else {
            resistenciaL -= 5;
            resistenciaV -= 5;
        }

        //minuto 60 - 70
        if(ofLocal > defVisita){
            goledor(local);
            marcadorL++;
            asistencia(local);
            resistenciaL -= 10;
            resistenciaV -= 5;
        } else {
            resistenciaL -= 5;
            resistenciaV -= 5;
        }

        //minuto 70 - 80
        if(mediaLocal > mediaVisita){
            goledor(local);
            marcadorL++;
            asistencia(local);
        } else if (mediaVisita > mediaLocal){
            goledor(visitante);
            marcadorV++;
            asistencia(visitante);
        }
        resistenciaL -= 5;
        resistenciaV -= 5;

        //minuto 80 - 90
        if(velocidadL > velocidadV){
            goledor(local);
            marcadorL++;
            asistencia(local);
            resistenciaL -= 10;
            resistenciaV -= 5;
        } else if (velocidadV > velocidadL){
            goledor(visitante);
            marcadorV++;
            asistencia(visitante);
            resistenciaV -= 10;
            resistenciaL -= 5;
        } else {
            resistenciaL -= 5;
            resistenciaV -= 5;
        }

        // 90+
        if(resistenciaL > resistenciaV){
            goledor(local);
            marcadorL++;
            asistencia(local);
        } else if (resistenciaV > resistenciaL) {
            goledor(visitante);
            marcadorV++;
            asistencia(visitante);
        }


        System.out.println("Marcador: " + local.getNombreEquipo() + " " + marcadorL +
                " - " + marcadorV + " " + visitante.getNombreEquipo());


        int puntosL = local.getPuntos();
        int puntosV = visitante.getPuntos();

        if(marcadorL > marcadorV){
            System.out.println(local.getNombreEquipo() + " gana \n");
            puntosL += 3;
        } else if(marcadorV > marcadorL){
            System.out.println(visitante.getNombreEquipo() + " gana \n");
            puntosV += 3;
        } else {
            puntosL++;
            puntosV++;
        }

        local.setPuntos(puntosL);
        visitante.setPuntos(puntosV);


        MenuJuego(local,liga);
    }

    public static Equipo miequipo(Liga liga){
        int num = liga.getNum_equipos() - 1;
        Equipo equipo = buscarIdEquipo(num, liga);
        return equipo;
    }

    public static Jugador goledor(Equipo equipo){
        List<Jugador> jugadores = equipo.getTitulares();
        Random rand = new Random();
        int i = 0;
        int opcion = rand.nextInt(10);
        for(Jugador jugador: jugadores){
            if(i == opcion){
                int goles = jugador.getGoles() + 1;
                jugador.setGoles(goles);
                System.out.println("gol de " + jugador.getNombre() + " - " + equipo.getNombreEquipo());

                return jugador;
            }
            i++;
        }
        return null;
    }

    public static void asistencia(Equipo equipo){
        List<Jugador> jugadores = equipo.getTitulares();
        Random rand = new Random();
        int i = 0;
        int opcion = rand.nextInt(10);
        for(Jugador jugador: jugadores){
            if(i == opcion){
                int asistencia = jugador.getAsistencias() + 1;
                jugador.setAsistencias(asistencia);

            }
            i++;
        }
    }

    public static double resistenciaPromedio(Equipo equipo){
        double resistencia = 0;
        List<Jugador> jugadores = equipo.getJugadores();
        for(Jugador jugador: jugadores){
            resistencia += jugador.getResistencia();
        }
        return resistencia / 11;
    }

    public static double calculoTacticoRival(Equipo equipo1, Equipo equipo2){
        double media = 0;
        int complejidadLocal = equipo1.getComplejidad();
        int complejidadVisita = equipo2.getComplejidad();
        int diferencia = 0;
        if(complejidadLocal > complejidadVisita){
            diferencia = complejidadLocal - complejidadVisita;
            switch (diferencia){
                case 1, 2:
                    media += 1;
                    break;
                case 3, 4:
                    media += 2;
                    break;
                case 5, 6:
                    media += 3;
                    break;
                case 7, 8:
                    media += 4;
                    break;
                case 9, 10:
                    media += 5;
                    break;
                default:
                    break;
            }
        } else {
            diferencia = complejidadVisita - complejidadLocal;
            switch (diferencia){
                case 1, 2:
                    media += 1;
                    break;
                case 3, 4:
                    media += 2;
                    break;
                case 5, 6:
                    media += 3;
                    break;
                case 7, 8:
                    media += 4;
                    break;
                case 9, 10:
                    media += 5;
                    break;
                default:
                    break;
            }
        }

        return media;

    }


    public static double getMediaEquipo(Equipo equipo){
        double mediaAcumulada = 0;
        List<Jugador> jugadores = equipo.getTitulares();
        for(Jugador jugador: jugadores){
            mediaAcumulada += jugador.getMedia();
        }
        return mediaAcumulada / 11;
    }
}
