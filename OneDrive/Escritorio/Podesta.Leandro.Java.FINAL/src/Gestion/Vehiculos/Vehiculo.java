
package Gestion.Vehiculos;

import java.text.MessageFormat;
import java.util.Objects;

/**
 *
 * @author LENOVO
 */
public abstract class Vehiculo implements Comparable<Vehiculo> {
    protected String marcaModelo;
    protected String tipo;
    protected double precio;
    protected EstadoVehiculo estado;

    public Vehiculo(String marcaModelo, String tipo, double precio, EstadoVehiculo estado) {
        this.marcaModelo = marcaModelo;
        this.tipo = tipo;
        this.precio = precio;
        this.estado = estado;
    }

    public String getNombre() {
        return marcaModelo;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public EstadoVehiculo getEstado() {
        return estado;
    }

    public void setMarcaModelo(String marcaModelo) {
        this.marcaModelo = marcaModelo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setEstado(EstadoVehiculo estado) {
        this.estado = estado;
    }
    
    
    public String getDatos() {
        return MessageFormat.format("{0} - {1} - {2} - {3}",tipo, marcaModelo, precio, estado);
    }

    @Override
    public int compareTo(Vehiculo vehiculo) {
        return (int) (this.precio - vehiculo.precio);
    }


    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.marcaModelo);
        hash = 23 * hash + Objects.hashCode(this.tipo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vehiculo other = (Vehiculo) obj;
        if (!Objects.equals(this.marcaModelo, other.marcaModelo)) {
            return false;
        }
        return Objects.equals(this.tipo, other.tipo);
    }
    
    
    
    
}
