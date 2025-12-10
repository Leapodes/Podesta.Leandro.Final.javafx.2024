package Gestion.Vehiculos;

import java.text.MessageFormat;

/**
 *
 * @author LENOVO
 */
public class VehiculoAuto extends Vehiculo {
    protected int cantidadPuertas;
    protected CajasDeCambios cajaDeCambios;
    
    public VehiculoAuto(String marcaModelo, String tipo, double precio, EstadoVehiculo estado, int CantidadPuertas, CajasDeCambios cajaDeCambios) {
        super(marcaModelo, tipo, precio, estado);
        this.cantidadPuertas = CantidadPuertas;
        this.cajaDeCambios = cajaDeCambios;
    }
    
    public VehiculoAuto(String marcaModelo, String tipo, double precio, EstadoVehiculo estado, CajasDeCambios cajaDeCambios) {
        super(marcaModelo, tipo, precio, estado);
        this.cantidadPuertas = 4;
        this.cajaDeCambios = cajaDeCambios;
    }
    
    public VehiculoAuto(String marcaModelo, String tipo, double precio, EstadoVehiculo estado, int cantidadPuertas) {
        super(marcaModelo, tipo, precio, estado);
        this.cantidadPuertas = cantidadPuertas;
        this.cajaDeCambios = CajasDeCambios.MANUAL;
    }

    @Override
    public String getDatos() {
        return super.getDatos() + MessageFormat.format(" - {0} - {1}",this.cantidadPuertas ,cajaDeCambios );   
    }
    

    
    
}
