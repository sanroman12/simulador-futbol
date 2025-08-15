package act23;

import java.util.Collection;
import java.util.Collections;

public class ejer2 {

    public static <T> int frequency(Collection<T> collection, T object){
        int cont = 0;
        for(T elem: collection){
            if(elem.equals(object)){
                cont++;
            }
        }
        return cont;
    }
}
