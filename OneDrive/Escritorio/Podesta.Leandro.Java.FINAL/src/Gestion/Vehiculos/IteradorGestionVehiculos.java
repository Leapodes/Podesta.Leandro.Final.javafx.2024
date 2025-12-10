package Gestion.Vehiculos;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author LENOVO
 */

public class IteradorGestionVehiculos implements Iterator<Vehiculo>{
    private GestionVehiculos gestionVehiculos;
    private int indiceActual;

    public IteradorGestionVehiculos(GestionVehiculos gestionVehiculos) {
        this.gestionVehiculos = gestionVehiculos;
        this.indiceActual = 0;
    }

    @Override
    public boolean hasNext() {
        return this.indiceActual < gestionVehiculos.cantidadVehiculos();
    }

    @Override
    public Vehiculo next() {
        if (hasNext()) {
            return gestionVehiculos.listaDeVehiculos.get(indiceActual++);
        } else {
            throw new NoSuchElementException();
        }
    }
    
}
