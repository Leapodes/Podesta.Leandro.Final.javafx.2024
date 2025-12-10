package Gestion.Vehiculos;

import java.util.List;

/**
 *
 * @author LENOVO
 */
public interface Crud<T> {
    void Crear(T elemento);
    List<T> Leer();
    void Actualizar(T elementoViejo, T elementoNuevo);
    void Borrar(T elemento);
}
