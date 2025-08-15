package act23;

import com.sun.tools.javac.Main;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;




    public class ejer3 {
        public static void main(String[] args) {
            ArrayDeque<Number> array = new ArrayDeque<>();
            ArrayDeque<Object> objetos = new ArrayDeque<>();

            array.add(10);
            array.add(25);
            array.add(45.12);

            copiar(array, objetos);

            for(Object objeto : objetos){
                System.out.println(objeto);
            }
        }
        public static void copiar(ArrayDeque<Number> source, ArrayDeque<Object> destin){
            for(Number num : source){
                destin.add(num);
            }
        }

    }
