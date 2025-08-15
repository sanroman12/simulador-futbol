package act25;
import java.util.HashMap;
import java.util.Random;

public class testDate {
    public static void main(String[] args) {
        HashMap<Integer, Date> fechas = new HashMap<>();
        Date d;
        for(int i = 0;i<100;i++){
            Random rand = new Random();
            int day = rand.nextInt(28) + 1;
            int month = rand.nextInt(11) + 1;
            int year = rand.nextInt(200) + 1900;
            d = new Date(year, month, day);
            fechas.put(i, d);
        }

        System.out.println(fechas);

        System.out.println(fechas.size());

        HashMap<Integer, Date> fechas2 = new HashMap<>();
        Date d2;
        for(int i = 0;i<100;i++){
            Random rand = new Random();
            int day = rand.nextInt(28) + 1;
            int month = rand.nextInt(11) + 1;
            int year = rand.nextInt(200) + 1900;
            d2 = new Date(year, month, day);
            fechas2.put(i, d2);
        }

        System.out.println(fechas2);

        System.out.println(fechas2.size());



    }

    @Override
    public int hashCode() {
        System.out.println("Llamada a hashCode()");
        return 5;
    }
}
