package Juego;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static Juego.Datos.*;
import static Juego.DefensaCentral.generarCentral;
import static Juego.DefensaLateral.generarLateral;
import static Juego.Delantero.generarDelantero;
import static Juego.Equipo.JugadoresEquipo;
import static Juego.Equipo.puntosTactica;
import static Juego.Extremo.generarExtremo;
import static Juego.Juegos.menuDeJuego;
import static Juego.Medio.generarMedio;
import static Juego.MediOfensivo.generarOfensivo;
import static Juego.Pivot.generarPivot;
import static Juego.Portero.generarPortero;




public class Voids {

    static int Id = 0;
    static int IdEquipo = 0;


    //Inicio

    public static void DarBienvenida(){
        System.out.print("Bienvenido a Proyecto Mbappe \n");
    }
    public static void DesplegarMenu(){
        System.out.print("Menu principal \n 1) nueva partida \n 2)cargar partida \n");
        int opcion = tomaropcion();
        nuevaPartida();
    }

    public static void nuevaPartida(){
        System.out.print("Nueva partida \n 1) importar liga \n 2) Generar nueva \n");
        //si escoge 2 -> GenerarCompetencia();
        int opcion = tomaropcion();
        while(opcion != 6){
            switch (opcion) {
                case 2:
                    GenerarCompetencia();
                    break;
            }
        }
    }
    public static void GenerarCompetencia(){
        Liga liga = new Liga("liga", "pais");
        Scanner scanner = new Scanner(System.in);
        System.out.print("escribe el nombre de la liga \n");
        String nombreLiga = scanner.nextLine();
        System.out.print("escribe el nombre del pais \n");
        String pais = scanner.nextLine();
        liga.setNombreLiga(nombreLiga);
        liga.setPais(pais);

        System.out.print("ingresa el numero de equipos (min. 4 - max. 34) \n");
        int num_equipos = scanner.nextInt();
        liga.setNum_equipos(num_equipos);

        List<String> nombresEquipos = new ArrayList<>(nombresDeEquipos);
        for (int i = 0; i < num_equipos; i++) {
            Equipo equipo = new Equipo(nombresEquipos);
            liga.agregarEquipo(equipo);
            asignarEquipoos(equipo);
            TacticasPrecreadasAleatoria(liga);
            TitularesAleatorio(equipo);
        }

        System.out.print("Ingrese el nombre de su equipo: \n ");
        String nombreEquipoPrincipal = scanner.next();
        Equipo miEquipo = new Equipo(nombreEquipoPrincipal);
        liga.agregarEquipo(miEquipo);
        asignarEquipoos(miEquipo);
        generarLibres(num_equipos);

        System.out.print("Competencia creada \n");

        MenuJuego(miEquipo, liga);
    }





    //Menus

    static boolean PrimerMenu = false;

    public  static void MenuJuego(Equipo equipo, Liga liga){

        if(!PrimerMenu) {
            System.out.print("Bienvenido a tu nueva liga \n");
            System.out.print("Crea tu alineacion \n");
            alineaciones(equipo, liga);
            PrimerMenu = true;
        }

        System.out.print("\n 1) JUGAR \n 2)ALINEACIONES \n 3)ESTADISTICAS \n 4)TRANFERENCIAS \n 5)CONTRATOS \n 6)SALIR \n");
        int opcion = tomaropcion();
        while(opcion != 6){

            switch (opcion) {
                case 1:
                    menuDeJuego(equipo, liga);
                    break;
                case 2:
                    alineaciones(equipo, liga);
                    break;
                case 3:
                    menuEstadisitcas(equipo, liga);
                case 6:
                    break;
            }
        }
    }

    public static void menuEstadisitcas(Equipo equipo, Liga liga){
        System.out.println("1) Estadisticas Individuales \n 2) Estadisticas Grupales \n 3) Estadisticas de liga \n 4) Salir \n" );
        int opcion = tomaropcion();
        switch (opcion){
            case 1:
                estaditicasIndividuales(liga);
                break;
            case 2:
                liga.toStringEquipos();
                System.out.println("Selecciona el id del equipo \n");
                int id = tomaropcion();
                Equipo equipox = buscarIdEquipo(id, liga);
                System.out.println("1) goleadores \n 2) asistidores \n 3) ambos \n 4) Salir \n");
                int op = tomaropcion();
                switch (op){
                    case 1:
                        desplegarGoleadores(equipox);
                        break;
                    case 2:
                        desplegarAsistidores(equipox);
                        break;
                    case 3:
                        desplegarGoleadores(equipox);
                        desplegarAsistidores(equipox);
                        break;
                    default:
                        return;
                }
            case 3:
                System.out.println("1) goleadores \n 2) asistidores \n 3) ambos \n 4) Salir \n");
                int opc = tomaropcion();
                switch (opc){
                    case 1:
                        desplegarTablaGoleo(liga);
                        break;
                    case 2:
                        desplegarTablaAsistencia(liga);
                        break;
                    case 3:
                        desplegarTablaGoleo(liga);
                        desplegarTablaAsistencia(liga);
                        break;
                    default:
                        return;
                }
            default:
                break;
        }
        menuDeJuego(equipo, liga);
    }



    //Alineaciones

    static boolean primeraAlineacion = false;

    public static void alineaciones(Equipo equipo, Liga liga){
        //mostrar primera lineacion y no se volvera a mostrar mas que laprimera ves
        //despues mostrar menu normal

        if(!primeraAlineacion){
            System.out.print("Bienvenido a tu primera creacion de plantilla \n");
            crearAlineacion(equipo);
            System.out.print("Crea tu tactica \n");
            System.out.print("1) tactica predefinida \n 2) crear tactica \n");
            int opcion = tomaropcion();
            switch (opcion){
                case 1:
                    TacticasPrecreadas(equipo);
                    break;
                case 2:
                    crearTactica(equipo);
                    break;
            }
            primeraAlineacion = true;
            desplegarAlineacion(equipo);
        }
        System.out.print("\n 1) desplegar alineacion \n 2) cambios \n 3) Tactica \n 4) salir \n");
        int opcion = tomaropcion();
        switch (opcion){
            case 1:
                desplegarAlineacion(equipo);
            case 2:
                cambios(equipo);
                break;
            case 3:
                tacticas(equipo);
                break;
            default:
                return;
        }

        MenuJuego(equipo, liga);

        //menu para poner tacticas, cambierlas, volver a crear plantilla o hacer cambios

    }

    public static void cambios(Equipo equipo){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del jugador que desea cambiar: \n ");
        int idJugador = scanner.nextInt();
        Jugador jugador = buscarId(idJugador, equipo);
        if (jugador == null) {
            System.out.println("Jugador no encontrado. \n");
            return;
        }
        System.out.print("Ingrese el ID del jugador que desea ingresar: \n");
        int idNuevoJugador = scanner.nextInt();
        Jugador nuevoJugador = buscarId(idNuevoJugador, equipo);
        if (nuevoJugador == null) {
            System.out.println("Jugador no encontrado. \n");
            return;
        }
        equipo.quitarTitulares(jugador);
        equipo.agregarBanca(jugador);
        equipo.agregarTitulares(nuevoJugador);
        equipo.quitarBanca(nuevoJugador);
    }

    public static void agregar(Equipo equipo, List<Jugador> list) {
        List<Jugador> titulares = equipo.getTitulares();
        Jugador eleccion;
        int opcion;

        do {
            opcion = tomaropcion();
            eleccion = buscarId(opcion, equipo);

            if (eleccion == null) {
                System.out.println("Jugador invalido, selecciona otro. \n");
                continue;
            }

            boolean yaEsTitular = false;
            for (Jugador jugador : titulares) {
                if (jugador.getId() == eleccion.getId()) {
                    System.out.println("Jugador ya seleccionado, elige otro. \n");
                    yaEsTitular = true;
                    break;
                }
            }


            if (!yaEsTitular) break;

        } while (true);

        equipo.agregarTitulares(eleccion);
        quitarTitular(equipo, opcion, list);
    }

    public static void TitularesAleatorio(Equipo equipo){
        List<Jugador> JugadoresTemporal = new ArrayList<>(JugadoresEquipo);
        Random rand = new Random();
        int formacion = rand.nextInt(6);
        switch (formacion){
            case 1:
                A433OA(equipo, JugadoresTemporal);
                break;
            case 2:
                A433DA(equipo, JugadoresTemporal);
                break;
            case 3:
                A4231A(equipo, JugadoresTemporal);
                break;
            case 4:
                A442A(equipo, JugadoresTemporal);
                break;
            case 5:
                A541A(equipo, JugadoresTemporal);
                break;
            default:
                A433OA(equipo, JugadoresTemporal);
                break;
        }
    }

    public static void agregarTemporalAleatorio(String tipo,List<Jugador> lista,Equipo equipo){
        float alta = 0;
        Jugador alto = null;
        for(Jugador jugador : lista){
            if (tipo.equals(jugador.Tipo()) || tipo.equals("todos")){
                if(alta < jugador.getMedia()){
                    alto = jugador;
                }
            }
        }
        equipo.agregarTitulares(alto);
        lista.remove(alto);
    }

    public static void bancaAleatoria(List<Jugador> lista,Equipo equipo){
        for(Jugador jugador : lista){
            equipo.agregarBanca(jugador);
        }
    }



    //Complementos de alineacion

    //- A al principio es de alineacion y al final de de aleatorio para los equipos bot
    public static void A433O(Equipo equipo,List<Jugador> lista){
        System.out.print("selecciona 1 Portero \n");
        mostrarTemporal("Portero",lista);
        agregar(equipo,lista);
        System.out.print("selecciona los 2 centrales \n");
        mostrarTemporal("Central",lista);
        agregar(equipo,lista);
        agregar(equipo,lista);
        System.out.print("selecciona los 2 Laterales \n");
        mostrarTemporal("Lateral",lista);
        agregar(equipo,lista);
        agregar(equipo,lista);
        System.out.print("selecciona los 2 medios \n");
        mostrarTemporal("Medio",lista);
        agregar(equipo,lista);
        agregar(equipo,lista);
        System.out.print("selecciona 1 Medio Ofensivo \n");
        mostrarTemporal("Ofensivo",lista);
        agregar(equipo,lista);
        System.out.print("selecciona 2 Extremos \n");
        mostrarTemporal("Extremo",lista);
        agregar(equipo,lista);
        agregar(equipo,lista);
        System.out.print("selecciona 1 Delantero \n");
        mostrarTemporal("Delantero",lista);
        agregar(equipo,lista);
    }

    public static void A433OA(Equipo equipo,List<Jugador> lista){
        agregarTemporalAleatorio("Portero",lista,equipo);
        agregarTemporalAleatorio("Central",lista,equipo);
        agregarTemporalAleatorio("Central",lista,equipo);
        agregarTemporalAleatorio("Lateral",lista,equipo);
        agregarTemporalAleatorio("Lateral",lista,equipo);
        agregarTemporalAleatorio("Medio",lista,equipo);
        agregarTemporalAleatorio("Medio",lista,equipo);
        agregarTemporalAleatorio("Ofensivo",lista,equipo);
        agregarTemporalAleatorio("Extremo",lista,equipo);
        agregarTemporalAleatorio("Extremo",lista,equipo);
        agregarTemporalAleatorio("Delantero",lista,equipo);
        bancaAleatoria(lista,equipo);
    }

    public static void A433D(Equipo equipo,List<Jugador> lista){
        System.out.print("selecciona 1 Portero \n");
        mostrarTemporal("Portero",lista);
        agregar(equipo,lista);
        System.out.print("selecciona los 2 centrales \n");
        mostrarTemporal("Central",lista);
        agregar(equipo,lista);
        agregar(equipo,lista);
        System.out.print("selecciona los 2 Laterales \n");
        mostrarTemporal("Lateral",lista);
        agregar(equipo,lista);
        agregar(equipo,lista);
        System.out.print("selecciona los 2 medios \n");
        mostrarTemporal("Medio",lista);
        agregar(equipo,lista);
        agregar(equipo,lista);
        System.out.print("selecciona 1 Pivot \n");
        mostrarTemporal("Pivot",lista);
        agregar(equipo,lista);
        System.out.print("selecciona 2 Extremos \n");
        mostrarTemporal("Extremo",lista);
        agregar(equipo,lista);
        agregar(equipo,lista);
        System.out.print("selecciona 1 Delantero \n");
        mostrarTemporal("Delantero",lista);
        agregar(equipo,lista);
    }

    public static void A433DA(Equipo equipo,List<Jugador> lista){
        agregarTemporalAleatorio("Portero",lista,equipo);
        agregarTemporalAleatorio("Central",lista,equipo);
        agregarTemporalAleatorio("Central",lista,equipo);
        agregarTemporalAleatorio("Lateral",lista,equipo);
        agregarTemporalAleatorio("Lateral",lista,equipo);
        agregarTemporalAleatorio("Medio",lista,equipo);
        agregarTemporalAleatorio("Medio",lista,equipo);
        agregarTemporalAleatorio("Pivot",lista,equipo);
        agregarTemporalAleatorio("Extremo",lista,equipo);
        agregarTemporalAleatorio("Extremo",lista,equipo);
        agregarTemporalAleatorio("Delantero",lista,equipo);
        bancaAleatoria(lista,equipo);
    }
    public static void A4231(Equipo equipo, List<Jugador> lista){
        System.out.print("selecciona 1 Portero \n");
        mostrarTemporal("Portero",lista);
        agregar(equipo,lista);
        System.out.print("selecciona los 2 centrales \n");
        mostrarTemporal("Central",lista);
        agregar(equipo,lista);
        agregar(equipo,lista);
        System.out.print("selecciona los 2 Laterales \n");
        mostrarTemporal("Lateral",lista);
        agregar(equipo,lista);
        agregar(equipo,lista);
        System.out.print("selecciona los 2 Pivot \n");
        mostrarTemporal("Pivot",lista);
        agregar(equipo,lista);
        agregar(equipo,lista);
        System.out.print("selecciona 1 Medio \n");
        mostrarTemporal("Medio",lista);
        agregar(equipo,lista);
        System.out.print("selecciona 2 Medios Ofensivos \n ");
        mostrarTemporal("Ofensivo",lista);
        agregar(equipo,lista);
        agregar(equipo,lista);
        System.out.print("selecciona 1 Delantero \n");
        mostrarTemporal("Delantero",lista);
        agregar(equipo,lista);
    }

    public static void A4231A(Equipo equipo,List<Jugador> lista){
        agregarTemporalAleatorio("Portero",lista,equipo);
        agregarTemporalAleatorio("Central",lista,equipo);
        agregarTemporalAleatorio("Central",lista,equipo);
        agregarTemporalAleatorio("Lateral",lista,equipo);
        agregarTemporalAleatorio("Lateral",lista,equipo);
        agregarTemporalAleatorio("Pivot",lista,equipo);
        agregarTemporalAleatorio("Pivot",lista,equipo);
        agregarTemporalAleatorio("Medio",lista,equipo);
        agregarTemporalAleatorio("Ofensivo",lista,equipo);
        agregarTemporalAleatorio("Ofensivo",lista,equipo);
        agregarTemporalAleatorio("Delantero",lista,equipo);
        bancaAleatoria(lista,equipo);
    }

    public static void A442(Equipo equipo, List<Jugador> lista){
        System.out.print("selecciona 1 Portero \n");
        mostrarTemporal("Portero",lista);
        agregar(equipo,lista);
        System.out.print("selecciona los 2 centrales \n");
        mostrarTemporal("Central",lista);
        agregar(equipo,lista);
        agregar(equipo,lista);
        System.out.print("selecciona los 2 Laterales \n");
        mostrarTemporal("Lateral",lista);
        agregar(equipo,lista);
        agregar(equipo,lista);
        System.out.print("selecciona los 2 Medios \n");
        mostrarTemporal("Medio",lista);
        agregar(equipo,lista);
        agregar(equipo,lista);
        System.out.print("selecciona 2 Extremos \n");
        mostrarTemporal("Medio",lista);
        agregar(equipo,lista);
        agregar(equipo,lista);
        System.out.print("selecciona 2 Delenteros \n");
        mostrarTemporal("Delantero",lista);
        agregar(equipo,lista);
        agregar(equipo,lista);
    }

    public static void A442A(Equipo equipo,List<Jugador> lista){
        agregarTemporalAleatorio("Portero",lista,equipo);
        agregarTemporalAleatorio("Central",lista,equipo);
        agregarTemporalAleatorio("Central",lista,equipo);
        agregarTemporalAleatorio("Lateral",lista,equipo);
        agregarTemporalAleatorio("Lateral",lista,equipo);
        agregarTemporalAleatorio("Medio",lista,equipo);
        agregarTemporalAleatorio("Medio",lista,equipo);
        agregarTemporalAleatorio("Extremo",lista,equipo);
        agregarTemporalAleatorio("Extremo",lista,equipo);
        agregarTemporalAleatorio("Delantero",lista,equipo);
        agregarTemporalAleatorio("Delantero",lista,equipo);
        bancaAleatoria(lista,equipo);
    }

    public static void A541(Equipo equipo,List<Jugador> lista){
        System.out.print("selecciona 1 Portero \n");
        mostrarTemporal("Portero",lista);
        agregar(equipo,lista);
        System.out.print("selecciona los 3 centrales \n");
        mostrarTemporal("Central",lista);
        agregar(equipo,lista);
        agregar(equipo,lista);
        agregar(equipo,lista);
        System.out.print("selecciona los 2 Laterales \n");
        mostrarTemporal("Lateral",lista);
        agregar(equipo,lista);
        agregar(equipo,lista);
        System.out.print("selecciona los 2 Medios \n");
        mostrarTemporal("Medios",lista);
        agregar(equipo,lista);
        agregar(equipo,lista);
        System.out.print("selecciona 2 Extemos \n");
        mostrarTemporal("Extremo",lista);
        agregar(equipo,lista);
        agregar(equipo,lista);
        System.out.print("selecciona 1 Delantero \n");
        mostrarTemporal("Delantero",lista);
        agregar(equipo,lista);
    }

    public static void A541A(Equipo equipo,List<Jugador> lista){
        agregarTemporalAleatorio("Portero",lista,equipo);
        agregarTemporalAleatorio("Central",lista,equipo);
        agregarTemporalAleatorio("Central",lista,equipo);
        agregarTemporalAleatorio("Central",lista,equipo);
        agregarTemporalAleatorio("Lateral",lista,equipo);
        agregarTemporalAleatorio("Lateral",lista,equipo);
        agregarTemporalAleatorio("Medio",lista,equipo);
        agregarTemporalAleatorio("Medio",lista,equipo);
        agregarTemporalAleatorio("Extremo",lista,equipo);
        agregarTemporalAleatorio("Extremo",lista,equipo);
        agregarTemporalAleatorio("Delantero",lista,equipo);
        bancaAleatoria(lista,equipo);
    }

    public static void desplegarAlineacion(Equipo equipo){
        System.out.println("Titulares: \n");
        mostrarTitulares(equipo,"Portero");
        mostrarTitulares(equipo,"Lateral");
        mostrarTitulares(equipo,"Central");
        mostrarTitulares(equipo,"Pivot");
        mostrarTitulares(equipo,"Medio");
        mostrarTitulares(equipo,"Ofensivo");
        mostrarTitulares(equipo,"Extremo");
        mostrarTitulares(equipo,"Delantero");

        System.out.println("Banca: \n");
        mostrarBanca(equipo,"Portero");
        mostrarBanca(equipo,"Lateral");
        mostrarBanca(equipo,"Central");
        mostrarBanca(equipo,"Pivot");
        mostrarBanca(equipo,"Medio");
        mostrarBanca(equipo,"Ofensivo");
        mostrarBanca(equipo,"Extremo");
        mostrarBanca(equipo,"Delantero");


    } //muestra los titulares y banca

    public static void crearAlineacion(Equipo equipo){
        List<Jugador> JugadoresTemporal = new ArrayList<>(JugadoresEquipo);
        System.out.println("1) Crear alineacion \n2) Auto-seleccion \n");
        int op1 = tomaropcion();
        if(op1 == 1) {
            int formacion = tipoAlineacion();
            switch (formacion) {
                case 1:
                    A433O(equipo, JugadoresTemporal);

                    break;
                case 2:
                    A433D(equipo, JugadoresTemporal);
                    break;
                case 3:
                    A4231(equipo, JugadoresTemporal);
                    break;
                case 4:
                    A442(equipo, JugadoresTemporal);
                    break;
                case 5:
                    A541(equipo, JugadoresTemporal);
                    break;
                default:
                    A433O(equipo, JugadoresTemporal);
                    break;

            }
            for(Jugador jugador: JugadoresTemporal){
                equipo.agregarBanca(jugador);
            }
        } else {
            int formacion = tipoAlineacion();
            switch (formacion) {
                case 1:
                    A433OA(equipo, JugadoresTemporal);
                    break;
                case 2:
                    A433DA(equipo, JugadoresTemporal);
                    break;
                case 3:
                    A4231A(equipo, JugadoresTemporal);
                    break;
                case 4:
                    A442A(equipo, JugadoresTemporal);
                    break;
                case 5:
                    A541A(equipo, JugadoresTemporal);
                    break;
                default:
                    A433OA(equipo, JugadoresTemporal);
                    break;
            }
        }

        JugadoresTemporal = null;

    } //usado para crear alineacion por primera vez


    public static void quitarTitular(Equipo equipo,int opcion,List<Jugador> temporal){
        Jugador jugador = buscarId(opcion, equipo);
        if (jugador != null) {
            temporal.remove(jugador);
        }

    }

    public static int tipoAlineacion(){
        for(String alineacion : alineaciones){
            System.out.print(alineacion);
        }
        System.out.print("selecciona el tipo de alineacion que deceas \n");
        int opcion = tomaropcion();
        switch (opcion){
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 5;
            default:
                return 1;
        }
    } //complemento de crear alineacion


    public static void mostrarJugadores(Equipo equipo, String tipo){
        List<Jugador> JugadoresEquipo = equipo.getJugadores();
        for (Jugador jugador : JugadoresEquipo) {
            if (tipo.equals(jugador.Tipo()) || tipo.equals("todos")) {
                System.out.println(jugador);
            }
        }
    } //muestra jugadoresde cierto tipo

    public static void mostrarTitulares(Equipo equipo, String tipo){
        List<Jugador> JugadoresEquipo = equipo.getTitulares();
        for (Jugador jugador : JugadoresEquipo) {
            if (tipo.equals(jugador.Tipo()) || tipo.equals("todos")) {
                System.out.println(jugador);
            }
        }
    }

    public static void mostrarBanca(Equipo equipo, String tipo){
        List<Jugador> JugadoresEquipo = equipo.getBanca();
        for (Jugador jugador : JugadoresEquipo) {
            if (tipo.equals(jugador.Tipo()) || tipo.equals("todos")) {
                System.out.println(jugador);
            }
        }
    }

    public static void mostrarTemporal(String tipo,List<Jugador> lista){
        for (Jugador jugador : lista) {
            if (tipo.equals(jugador.Tipo())) {
                System.out.println(jugador);
            }
        }
    }




    //Tacticas


    public static void calculoTacticas(Equipo equipo){
        int velocidad = equipo.getVelocidad();
        int presion = equipo.getPresion();
        int ofensivo = equipo.getNivelOfensivo();
        int defensivo = equipo.getNivelDefensivo();
        int complejidad = equipo.getComplejidad();

        //precicion
       switch (presion){
           case 1,2:
               ofensivo -= 2;
               velocidad -=2;
               break;
           case 3,4:
               ofensivo -= 1;
               velocidad -= 1;
               break;
           case 7,8:
               defensivo += 1;
               velocidad += 1;
               break;
           case 9,10:
               defensivo += 2;
               velocidad += 2;
               break;
       }

        //velocidad
       switch (velocidad){
           case 1,2:
               ofensivo -= 2;
               defensivo += 2;
               break;
           case 3,4:
               ofensivo -= 1;
               defensivo += 1;
               break;
           case 7-8:
               ofensivo += 1;
               defensivo -= 1;
               break;
           case 9, 10:
               ofensivo += 2;
               defensivo -= 2;
               break;
           default:
               break;
       }

       //complejidad
       switch (complejidad){
           case 1,2:
               ofensivo -= 2;
               velocidad +=2;
               break;
           case 3,4:
               ofensivo -= 1;
               velocidad += 1;
               break;
           case 7,8:
               defensivo += 1;
               velocidad -= 1;
               break;
           case 9,10:
               defensivo += 2;
               velocidad -= 2;
               break;
       }

        equipo.setNivelOfensivo(ofensivo);
        equipo.setNivelDefensivo(defensivo);
        equipo.setVelocidad(velocidad);
   }

    public static void tacticas(Equipo equipo){
        if(!primeraTactica) {
            System.out.print("1) crear tactica \n2) usar precreada \n3)salir \n");
            primeraTactica = true;
        }else {
            System.out.print("1) crear tactica \n2) usar precreada \n3)modificar la actual \n4)salir \n");
        }
        int opcion = tomaropcion();

        switch (opcion){
            case 1:
                crearTactica(equipo);
                break;
            case 2:
                TacticasPrecreadas(equipo);
                break;
            case 3:
                cambiarTacticaIndividual(equipo);
                break;
            case 4:
                break;
        }
        calculoTacticas(equipo);
    }

    public static void cambiarTacticaIndividual(Equipo equipo){
        System.out.print("Que deseas cambiar\n 1) Velocidad \n2) Nivel Defensivo \n3) Nivel Ofensivo \n4) Complejidad \n5) Presion \n6) Salir \n");
        int opcion = tomaropcion();
        switch (opcion){
            case 1:
                System.out.print("Selecciona un valor entre 1-10 \n");
                System.out.print("Puntos acumulados = " + puntosTactica);
                int velocidad = tomaropcion();
                if (velocidad >= 1 && velocidad <= 10){
                    equipo.setVelocidad(velocidad);
                    if((puntosTactica + velocidad) >= 30){
                        equipo.setVelocidad(0);
                    } else {
                        puntosTactica += velocidad;
                    }
                } else {
                    equipo.setPresion(0);
                }
                break;
            case 2:
                System.out.print("Selecciona un valor entre 1-10 \n");
                System.out.print("Puntos acumulados = " + puntosTactica);
                int Defensivo = tomaropcion();
                if (Defensivo >= 1 && Defensivo <= 10){
                    equipo.setNivelDefensivo(Defensivo);
                    if((puntosTactica + Defensivo) >= 30){
                        equipo.setNivelDefensivo(0);
                    } else {
                        puntosTactica += Defensivo;
                    }
                } else {
                    equipo.setNivelDefensivo(0);
                }
                break;
            case 3:
                System.out.print("Selecciona un valor entre 1-10 \n");
                System.out.print("Puntos acumulados = " + puntosTactica);
                int Ofensivo = tomaropcion();
                if (Ofensivo >= 1 && Ofensivo <= 10){
                    equipo.setNivelOfensivo(Ofensivo);
                    if((puntosTactica + Ofensivo) >= 30){
                        equipo.setNivelOfensivo(0);
                    } else {
                        puntosTactica += Ofensivo;
                    }
                } else {
                    equipo.setNivelOfensivo(0);
                }
                break;
            case 4:
                System.out.print("Selecciona un valor entre 1-10 \n");
                System.out.print("Puntos acumulados = " + puntosTactica);
                int complejidad = tomaropcion();
                if (complejidad >= 1 && complejidad <= 10){
                    equipo.setComplejidad(complejidad);
                    if((puntosTactica + complejidad) >= 30){
                        equipo.setComplejidad(0);
                    } else {
                        puntosTactica += complejidad;
                    }
                } else {
                    equipo.setComplejidad(0);
                }
                break;
            case 5:
                System.out.print("Selecciona un valor entre 1-10 \n");
                System.out.print("Puntos acumulados = " + puntosTactica);
                int presion = tomaropcion();
                if (presion >= 1 && presion <= 10){
                    equipo.setPresion(presion);
                    if((puntosTactica + presion) >= 30){
                        equipo.setPresion(0);
                    } else {
                        puntosTactica += presion;
                    }
                } else {
                    equipo.setPresion(0);
                }
                break;
            case 6:
                break;
        }
    }

    public static void crearTactica(Equipo equipo){
        System.out.print("Selecciona un valor entre 1-10 \nTienes maximo 30 puntos \nAsigna tu velocidad \n");
        puntosTactica = 0;
        int velocidad = tomaropcion();
        if (velocidad >= 1 && velocidad <= 10){
            equipo.setVelocidad(velocidad);
            puntosTactica += velocidad;
        } else {
            equipo.setVelocidad(0);
        }
        System.out.print("Asigna tu nivel defensivo \n");
        System.out.print("Puntos acumulados = " + puntosTactica);
        int nivelDefensivo = tomaropcion();
        if (nivelDefensivo >= 1 && nivelDefensivo <= 10){
            equipo.setNivelDefensivo(nivelDefensivo);
            puntosTactica += nivelDefensivo;
        } else {
            equipo.setNivelDefensivo(0);
        }
        System.out.print("Asigna tu nivel ofensivo \n");
        System.out.print("Puntos acumulados = " + puntosTactica);
        int nivelOfensivo = tomaropcion();
        if (nivelOfensivo >= 1 && nivelOfensivo <= 10){
            equipo.setNivelOfensivo(nivelOfensivo);
            puntosTactica += nivelOfensivo;
        } else {
            equipo.setNivelOfensivo(0);
        }
        System.out.print("Asigna tu complejidad de juego \n");
        System.out.print("Puntos acumulados = " + puntosTactica);
        int complejidad = tomaropcion();
        if (complejidad >= 1 && complejidad <= 10){
            equipo.setComplejidad(complejidad);
            if((puntosTactica + complejidad) >= 30){
                equipo.setComplejidad(0);
            } else {
                puntosTactica += complejidad;
            }
        } else {
            equipo.setComplejidad(0);
        }
        System.out.print("Asigna tu presion de juego \n");
        System.out.print("Puntos acumulados = " + puntosTactica);
        int presion = tomaropcion();
        if (presion >= 1 && presion <= 10){
            equipo.setPresion(presion);
            if((puntosTactica + presion) >= 30){
                equipo.setPresion(0);
            } else {
                puntosTactica += presion;
            }
        } else {
            equipo.setPresion(0);
        }
    }

    public static void TacticasPrecreadas(Equipo equipo){
        System.out.print("selecciona la tactica que deseas \n1)Tiki Taka \n2)Gegenpressing \n3)Park The Bus \n4)Contragolpe \n");
        int opcion = tomaropcion();
        switch (opcion) {
            case 1:
                equipo.setVelocidad(5);
                equipo.setNivelDefensivo(7);
                equipo.setNivelOfensivo(5);
                equipo.setComplejidad(8);
                equipo.setPresion(5);
                break;
            case 2:
                equipo.setVelocidad(7);
                equipo.setNivelDefensivo(4);
                equipo.setNivelOfensivo(7);
                equipo.setComplejidad(4);
                equipo.setPresion(8);
                break;
            case 3:
                equipo.setVelocidad(5);
                equipo.setNivelDefensivo(10);
                equipo.setNivelOfensivo(3);
                equipo.setComplejidad(6);
                equipo.setPresion(6);
                break;
            case 4:
                equipo.setVelocidad(9);
                equipo.setNivelDefensivo(7);
                equipo.setNivelOfensivo(5);
                equipo.setComplejidad(4);
                equipo.setPresion(5);
                break;
        }
    }

    public static void TacticasPrecreadasAleatoria(Liga liga){
        List<Equipo> equipos = liga.getEquipos();
        Random rand = new Random();
        for(Equipo equipo: equipos) {
            int opcion = rand.nextInt(5);
            switch (opcion) {
                case 1:
                    equipo.setVelocidad(5);
                    equipo.setNivelDefensivo(7);
                    equipo.setNivelOfensivo(5);
                    equipo.setComplejidad(8);
                    equipo.setPresion(5);
                    break;
                case 2:
                    equipo.setVelocidad(7);
                    equipo.setNivelDefensivo(4);
                    equipo.setNivelOfensivo(7);
                    equipo.setComplejidad(4);
                    equipo.setPresion(7);
                    break;
                case 3:
                    equipo.setVelocidad(5);
                    equipo.setNivelDefensivo(10);
                    equipo.setNivelOfensivo(4);
                    equipo.setComplejidad(6);
                    equipo.setPresion(6);
                    break;
                case 4:
                    equipo.setVelocidad(9);
                    equipo.setNivelDefensivo(7);
                    equipo.setNivelOfensivo(5);
                    equipo.setComplejidad(4);
                    equipo.setPresion(5);
                    break;
            }
        }
    }



    //Dependencias de Generacion

    public static void asignarEquipoos(Equipo equipo){
        generarPortero(2, equipo);
        generarCentral(4, equipo);
        generarLateral(4, equipo);
        generarMedio(4, equipo);
        generarPivot(3, equipo);
        generarMedio(3, equipo);
        generarOfensivo(2, equipo);
        generarExtremo(4, equipo);
        generarDelantero(2, equipo);

    }

    public static String nombreAleatorio(){
        Random rand = new Random();
        int num = rand.nextInt(50);
        return nombresJugadores.get(num);
    }

    public static String apellidoAleatorio(){
        Random rand = new Random();
        int num = rand.nextInt(50);
        return apellidosJugadores.get(num);
    }

    public static void generarLibres(int numEquipos){
        generarPortero((int) (numEquipos*.3));
        generarCentral((int) (numEquipos*.3));
        generarLateral((int) (numEquipos*.3));
        generarMedio((int) (numEquipos*.3));
        generarPivot((int) (numEquipos*.3));
        generarMedio((int) (numEquipos*.3));
        generarOfensivo((int) (numEquipos*.3));
        generarExtremo((int) (numEquipos*.3));
        generarDelantero((int) (numEquipos*.3));
    }

    public static int tomaropcion(){
        Scanner scanner = new Scanner(System.in);
        int opcion = scanner.nextInt();
        return opcion;
    }

    public static int cantidadPociciones(String pocicion, int numEquipos){
        switch (pocicion){
            case "Ofensivo","Delantero":
                return 2 * (numEquipos + 5);
            case "Portero","Pivot","Medio":
                return 3 * (numEquipos + 5);
            case "Centrales","Lateral","Extremo":
                return 4 * (numEquipos + 5);
            default:
                return 0;
        }
    }




    //Busqueda

    public static Jugador buscarId(int idBuscado,Equipo equipo) {
        List<Jugador> JugadoresEquipo = equipo.getJugadores();
        for (Jugador jugador : JugadoresEquipo) {
            if (jugador.getId() == idBuscado) {
                return jugador;
            }
        }
        return null;
    } //buscar id en un equipo

    public static Jugador buscarIdGeneral(int id){
        List<Jugador> jugadores = listaJugadores;
        for(Jugador jugador: jugadores){
            if (jugador.getId() == id) {
                return jugador;
            }
        }
        return null;
    } //buscar id entre todos los jugadores

    public static Equipo buscarIdEquipo(int idBuscado, Liga liga) {
        List<Equipo> Equipos = new ArrayList<>(liga.getEquipos());
        for (Equipo equipo: Equipos) {
            if (equipo.getIdEquipo() == idBuscado) {
                return equipo;
            }
        }
        return null;
    } //buscar id de un equipo





    // estadisticas

    public static void desplegarTablaGoleo(Liga liga){
        System.out.println("Goleadores: \n");
        int lugar = 1;
        List<Jugador> jugadores = new ArrayList<>(listaJugadores);
        do {
            int alto = 0;
            Jugador maximo = null;
            for (Jugador jugador : jugadores) {
                int goles = jugador.getGoles();
                if(goles > 0){
                    if (goles > alto) {
                        maximo = jugador;
                    }
                }
            }
            Equipo equipo = EquipoJugador(liga, maximo);

            if(equipo == null) {
                System.out.println(lugar + "- " + maximo.getNombre() + " - Id " + maximo.getId() + " - Equipo: no identificado - Goles  " + maximo.getGoles() + " \n");
            } else {
                System.out.println(lugar + "- " + maximo.getNombre() + " - Id " + maximo.getId() + " - Equipo: " + equipo.getNombreEquipo() + " - goles " + maximo.getGoles() + " \n");
            }
            lugar++;
            jugadores.remove(maximo);
        } while (lugar != 10);
    }

    public static void desplegarTablaAsistencia(Liga liga){
        System.out.println("Asistidores: \n");
        int lugar = 1;
        List<Jugador> jugadores = listaJugadores;
        do {
            int alto = 0;
            Jugador maximo = null;
            for (Jugador jugador : jugadores) {
                int asistencias = jugador.getAsistencias();
                if (asistencias >= alto) {
                    maximo = jugador;
                }
            }
            Equipo equipo = EquipoJugador(liga, maximo);
            if(equipo == null) {
                System.out.println(lugar + "- " + maximo.getNombre() + " - Id " + maximo.getId() + " - Equipo: no identificado - Asistencias  " + maximo.getAsistencias() + " \n");
            } else {
                System.out.println(lugar + "- " + maximo.getNombre() + " - Id " + maximo.getId() + " - Equipo: " + equipo.getNombreEquipo() + " - Asistencias  " + maximo.getAsistencias() + " \n");
            }
            lugar++;
            jugadores.remove(maximo);
        } while (lugar != 10);
    }

    public static Equipo EquipoJugador(Liga liga, Jugador jugador){
        if(jugador != null) {
            int idBuscado = jugador.getId();
            List<Equipo> equipos = new ArrayList<>(liga.getEquipos());
            for (Equipo equipo : equipos) {
                List<Jugador> jugadores = equipo.getJugadores();
                for (Jugador jugador1 : jugadores) {
                    int id = jugador1.getId();
                    if (idBuscado == id) {
                        return equipo;
                    }
                }
            }
        }
        return null;
    }

    public static void desplegarGoleadores(Equipo equipo){
        System.out.println("Maximos goleadores de " + equipo.getNombreEquipo() + " \n");
        int lugar = 1;
        List<Jugador> jugadores = new ArrayList<>(equipo.getTitulares());
        do {
            int alto = 0;
            Jugador maximo = null;
            for (Jugador jugador : jugadores) {
                int goles = jugador.getGoles();
                if (goles >= alto) {
                    maximo = jugador;
                }
            }
            System.out.println(lugar + "- " + maximo.getNombre() + " - " + maximo.getGoles() + " \n");
            lugar++;
            jugadores.remove(maximo);
        } while (lugar != 11);
    } //despliega goleadores de equipo

    public static void desplegarAsistidores(Equipo equipo){
        System.out.println("Maximos asisitidores de " + equipo.getNombreEquipo() + " \n");
        int lugar = 1;
        List<Jugador> jugadores = new ArrayList<>(equipo.getTitulares());
        do {
            int alto = 0;
            Jugador maximo = null;
            for (Jugador jugador : jugadores) {
                int asistencias = jugador.getAsistencias();
                if (asistencias >= alto) {
                    maximo = jugador;
                }
            }
            System.out.println(lugar + "- " + maximo.getNombre() + " \n");
            lugar++;
            jugadores.remove(maximo);
        } while (lugar != 11);
    } //despliego asistidores de equipo

    public static void estaditicasIndividuales(Liga liga){
        System.out.print("1) Buscar equipo \n 2) buscar jugador \n");
        int opcion = tomaropcion();
        switch (opcion){
            case 1:
                liga.toStringEquipos();
                System.out.print("Selecciona el id del equipo \n");
                int idEquipo = tomaropcion();
                Equipo equipo = buscarIdEquipo(idEquipo, liga);
                desplegarAlineacion(equipo);
                System.out.print("Selecciona el id \n");
                int idjugador = tomaropcion();
                Jugador jugado = buscarIdGeneral(idjugador);
                if (jugado != null) {
                    jugado.getEstadisticas();
                }
                break;
            case 2:
                System.out.print("1) desplegar lista de jugadores \n 2) seleccionar id \n");
                int op = tomaropcion();
                if(op == 1){
                    desplegarTodos();
                    System.out.print("Selecciona el id \n");
                    int id = tomaropcion();
                    Jugador jugador = buscarIdGeneral(id);
                    if (jugador != null) {
                        jugador.getEstadisticas();
                    }
                } else if(op == 2){
                    System.out.print("Selecciona el id \n");
                    int id = tomaropcion();
                    Jugador jugador = buscarIdGeneral(id);
                    if (jugador != null) {
                        jugador.getEstadisticas();
                    }
                } else {
                    break;
                }
                break;
        }

    }

    public static void desplegarTodos(){
        List<Jugador> jugadores = listaJugadores;
        for(Jugador jugador: jugadores){
            System.out.println(jugador);
        }
    }

}
