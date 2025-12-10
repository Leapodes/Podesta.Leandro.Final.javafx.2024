package Gestion.Vehiculos;

import java.text.MessageFormat;

/**
 *
 * @author LENOVO
 */
public class VehiculoCamion extends Vehiculo {
    protected double capacidad;
    protected boolean acoplado;
    protected int ejes;
    
    public VehiculoCamion(String nombre, String tipo, double precio, EstadoVehiculo estado, double capacidad, boolean acoplado, int ejes) {
        super(nombre, tipo, precio, estado);
        this.acoplado = acoplado;
        this.capacidad = capacidad;
        this.ejes = ejes;
    }
    
    public VehiculoCamion(String nombre, String tipo, double precio, EstadoVehiculo estado, double capacidad, int ejes) {
        super(nombre, tipo, precio, estado);
        this.acoplado = true;
        this.capacidad = capacidad;
        this.ejes = ejes;
    }
    
    public VehiculoCamion(String nombre, String tipo, double precio, EstadoVehiculo estado, boolean acoplado) {
        super(nombre, tipo, precio, estado);
        this.acoplado = acoplado;
        this.capacidad = 30;
        this.ejes = 4;
    }

    /**ORDENAMIENTO NATURAL COMPARABLE**/
    @Override
    public int compareTo(Vehiculo otroVehiculo) {
        return (int) (this.precio - otroVehiculo.precio);/**ordenamiento de menor a mayor**/
    }
    
     @Override
    public String getDatos() {
        return super.getDatos() + MessageFormat.format(" - {0} - {1} - {2}",capacidad,acoplado, ejes);   
    }
    
}
