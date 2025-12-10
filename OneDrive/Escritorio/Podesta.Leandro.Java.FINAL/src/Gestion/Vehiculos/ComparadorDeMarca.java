
package Gestion.Vehiculos;

import java.util.Comparator;

/**
 *
 * @author LENOVO
 */
public class ComparadorDeMarca implements Comparator<Vehiculo> {
    @Override 
    public int compare(Vehiculo camion1, Vehiculo camion2) {
        return camion1.getNombre().compareToIgnoreCase(camion2.getNombre());
    }
}