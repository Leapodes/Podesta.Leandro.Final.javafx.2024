package Gestion.Vehiculos;

import java.util.Comparator;

/**
 *
 * @author LENOVO
 */
public class ComparadorDeCapacidad implements Comparator<VehiculoCamion> {
    @Override
    public int compare(VehiculoCamion camion1, VehiculoCamion camion2) {
        return Double.compare(camion1.capacidad, camion2.capacidad);
    }
}