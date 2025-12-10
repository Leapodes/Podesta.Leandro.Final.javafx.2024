package Gestion.Vehiculos;

/**
 *
 * @author LENOVO
 */
public class VehiculoNoEncontrado extends Exception{
    public VehiculoNoEncontrado(String mensaje){
        super (mensaje);
    }
    
    public VehiculoNoEncontrado(String mensaje, Throwable causa){
        super (mensaje, causa);
    }
}   
