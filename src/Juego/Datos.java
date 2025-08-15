package Juego;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Datos {

    static boolean primeraAlineacion = false;
    static boolean PrimerMenu = false;
    static boolean primeraTactica = false;

    static List<String> nombresDeEquipos = Arrays.asList("América", "Chivas", "Cruz Azul", "Pumas", "Tigres", "Monterrey", "Toluca",
            "Santos", "León", "Querétaro", "Pachuca", "Atlas", "Necaxa", "Juárez", "Mazatlán", "San Luis", "FC Juárez", "Puebla",
            "FC Juárez", "Xolos de Tijuana","Real Madrid", "Barcelona", "Atlético de Madrid", "Sevilla", "Villarreal", "Real Sociedad",
            "Real Betis", "Celta de Vigo", "Valencia", "Athletic Club", "Osasuna", "Getafe", "Granada", "Levante", "Espanyol", "Alavés",
            "Cádiz", "Rayo Vallecano", "Mallorca", "Elche");

    static List<String> nombresJugadores = Arrays.asList(
            "Liam", "Noah", "Oliver", "William", "Elijah", "James", "Benjamin", "Lucas", "Henry", "Alexander",
            "Mason", "Michael", "Ethan", "Daniel", "Jacob", "Logan", "Jackson", "Levi", "Sebastian", "Mateo",
            "Jack", "Owen", "Theodore", "Aiden", "Samuel", "Joseph", "John", "David", "Wyatt", "Matthew",
            "Luke", "Asher", "Carter", "Julian", "Grayson", "Leo", "Jayden", "Gabriel", "Isaac", "Lincoln",
            "Anthony", "Hudson", "Dylan", "Ezra", "Thomas", "Charles", "Christopher", "Jaxon", "Maverick",
            "Josiah", "Isaiah", "Andrew", "Elias", "Joshua", "Nathan", "Caleb", "Ryan", "Adrian", "Miles",
            "Eli", "Nolan", "Christian", "Aaron", "Cameron", "Ezekiel", "Colton", "Luca", "Landon", "Hunter",
            "Jonathan", "Santiago", "Axel", "Easton", "Cooper", "Jeremiah", "Angel", "Roman", "Connor",
            "Jameson", "Robert", "Greyson", "Jordan", "Ian", "Carson", "Jaxson", "Leonardo", "Nicholas",
            "Dominic", "Austin", "Everett", "Brooks", "Xavier", "Kai", "Jose", "Parker", "Adam", "Jace"
    );

    static List<String> apellidosJugadores = Arrays.asList(
            "González", "Rodríguez", "López", "Martínez", "Sánchez", "Pérez", "Gómez", "Fernández", "Díaz", "Alvarez",
            "Gutiérrez", "Jiménez", "Vázquez", "Ramos", "Romero", "Navarro", "Torres", "Domínguez", "Gil", "Reyes",
            "Morales", "Ortega", "Delgado", "Castro", "Ortiz", "Rubio", "Marín", "Serrano", "Iglesias", "Nuñez",
            "Medina", "Garrido", "Cortés", "Pardo", "Guerrero", "Lozano", "Ramírez", "Suárez", "Blanco", "Molina",
            "Castillo", "Alonso", "Herrera", "Sanroman", "Méndez", "Peña", "Cabrera", "Rivera", "Rojas", "Bermúdez",
            "Diez", "Ferrer", "Cruz", "Gallego", "Vidal", "Arias", "Carmona", "Crespo", "Carvajal", "Pastor",
            "Santana", "Santos", "Mora", "Esteban", "Bravo", "Parra", "Ríos", "Flores", "Ibáñez", "León",
            "Álvarez", "Aguilar", "Campos", "Hidalgo", "Mendez", "Luna", "Segura", "Santiago", "Duran", "Vega",
            "Benítez", "Pascual", "Fuentes", "Giménez", "Arias", "Salas", "Moya", "Soler", "Vargas", "Molina",
            "Aragon", "Martinez","Beltran","Ibarra","Salah","Messi","Do Santos","Da Silva", "Aveiro","Cuccitini"
    );

    static List<String> pociciones = Arrays.asList("Portero","Central","Lateral","Pivot","Medio","Ofensivo","Extremo","Delantero");

    static List<String> alineaciones = Arrays.asList("1) 4-3-3 ofensivo","2) 4-3-3 defencivo","3) 4-2-3-1","4) 4-4-2","5) 5-4-1 \n");
    static ArrayList<Jugador> listaJugadores = new ArrayList<>();
    static ArrayList<Portero> listaPorteros = new ArrayList<>();
    static ArrayList<DefensaCentral> listaCentrales = new ArrayList<>();
    static ArrayList<DefensaLateral> listaLaterales = new ArrayList<>();
    static ArrayList<Pivot> listaPivot = new ArrayList<>();
    static ArrayList<Medio> listaMedio = new ArrayList<>();
    static ArrayList<MediOfensivo> listaOfensivo = new ArrayList<MediOfensivo>();
    static ArrayList<Extremo> listaExtremo = new ArrayList<>();
    static ArrayList<Delantero> listaDelanteros = new ArrayList<>();
    static ArrayList<Jugador> listaJugadoresLibres = new ArrayList<>();
    static ArrayList<Portero> listaPorterosLibres = new ArrayList<>();
    static ArrayList<DefensaCentral> listaCentralesLibres = new ArrayList<>();
    static ArrayList<DefensaLateral> listaLateralesLibres = new ArrayList<>();
    static ArrayList<Pivot> listaPivotLibres = new ArrayList<>();
    static ArrayList<Medio> listaMedioLibres = new ArrayList<>();
    static ArrayList<MediOfensivo> listaOfensivoLibres = new ArrayList<MediOfensivo>();
    static ArrayList<Extremo> listaExtremoLibres = new ArrayList<>();
    static ArrayList<Delantero> listaDelanterosLibres = new ArrayList<>();



    private List<String> Calendario;
    private List<String> Goleadores;
    private List<String> tablaGeneral;


}
