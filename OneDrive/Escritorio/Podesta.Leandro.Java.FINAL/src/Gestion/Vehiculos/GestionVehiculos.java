package Gestion.Vehiculos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.io.FileReader;
import com.google.gson.*;
import java.io.FileWriter;
import java.util.Collections;

/**
 *
 * @author LENOVO
 */
public class GestionVehiculos implements Crud<Vehiculo>, Iterable<Vehiculo>{
    protected List<Vehiculo> listaDeVehiculos = new ArrayList<>();
    
    public int cantidadVehiculos(){
        return listaDeVehiculos.size();
    }
    
    public Iterator<Vehiculo> Iterator(){
        return new IteradorGestionVehiculos(this);
    }

    @Override
    public void Crear(Vehiculo vehiculo) {
        this.listaDeVehiculos.add(vehiculo);
    }

    @Override
    public List<Vehiculo> Leer() {
        return this.listaDeVehiculos;
    }

    @Override
    public void Actualizar(Vehiculo vehiculoViejo, Vehiculo vehiculoNuevo) {
        int posicion = this.listaDeVehiculos.indexOf(vehiculoViejo);
        this.listaDeVehiculos.set(posicion, vehiculoNuevo);
    }

    @Override
    public void Borrar(Vehiculo vehiculo) {
        this.listaDeVehiculos.remove(vehiculo);
    }
    
    public void Ordenar(){
        Collections.sort(listaDeVehiculos);
    }
    
    public void importarVehiculos(){
        Gson gson = new Gson();
        List<Vehiculo> aux = this.listaDeVehiculos;
        try (FileReader lector = new FileReader("./src/MainFx/ListaVehiculosJSON.json")) {
            this.listaDeVehiculos.clear();
            JsonElement element = new JsonParser().parse(lector);
            JsonArray elementArray = element.getAsJsonArray();
            for (JsonElement jsonElement : elementArray) {
                JsonObject elementObject = jsonElement.getAsJsonObject();
                if (elementObject.has("acoplado")){
                    VehiculoCamion camion = gson.fromJson(elementObject, VehiculoCamion.class);
                    this.Crear(camion);
                } else if (elementObject.has("cilindrada")){
                    VehiculoMoto moto = gson.fromJson(elementObject, VehiculoMoto.class);
                    this.Crear(moto);
                } else {
                    VehiculoAuto auto = gson.fromJson(elementObject, VehiculoAuto.class);
                    this.Crear(auto); 
                }
                
            }
            
        } catch (Exception e) {
            System.out.println("error");
            System.out.println(e.getMessage());
            this.listaDeVehiculos = aux;
        }
        
    }
    
    public void exportarVehiculos(){
        Gson gson = new Gson();
        
        try (FileWriter escritura = new FileWriter("./src/MainFx/ListaVehiculosJSON.json")) {
            String listaJson = gson.toJson(this.listaDeVehiculos);
            escritura.write(listaJson);
        } catch (Exception e) {
            System.out.println("error");
            System.out.println(e.getMessage());
        }
    }

     @Override
    public Iterator<Vehiculo> iterator() {
        return new IteradorGestionVehiculos(this);
    }
    
}


