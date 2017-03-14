//Classe Comparador
package Classes;

import java.util.Comparator;

/**
 *
 * @author Rodrigo Vignolli
 */
public class Comparador implements Comparator {

    @Override
    public int compare(Object objeto_1, Object objeto_2) {
        return objeto_1.hashCode() - objeto_2.hashCode();
    }
    
}
