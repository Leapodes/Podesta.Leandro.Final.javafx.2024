package Gestion.Vehiculos;

import java.text.MessageFormat;

/**
 *
 * @author LENOVO
 */
public class VehiculoMoto extends Vehiculo{
    protected int cilindrada;
    protected TipoDeMoto tipoDeMoto;
    
    public VehiculoMoto(String marcaModelo, String tipo, double precio, EstadoVehiculo estado, int cilindrada, TipoDeMoto tipoDeMoto) {
        super(marcaModelo, tipo, precio, estado);
        this.cilindrada = cilindrada;
        this.tipoDeMoto = tipoDeMoto;
    }
    
    public VehiculoMoto(String marcaModelo, String tipo, double precio, EstadoVehiculo estado, TipoDeMoto tipoDeMoto) {
        super(marcaModelo, tipo, precio, estado);
        this.cilindrada = 200;
        this.tipoDeMoto = tipoDeMoto;
    }
    
    public VehiculoMoto(String marcaModelo, String tipo, double precio, EstadoVehiculo estado, int cilindrada) {
        super(marcaModelo, tipo, precio, estado);
        this.cilindrada = cilindrada;
        this.tipoDeMoto = TipoDeMoto.SCOOTER;
    }
    
    @Override
    public String getDatos() {
        return super.getDatos() + MessageFormat.format(" - {0} - {1}",cilindrada, tipoDeMoto);   
    }
    
    
    
}
