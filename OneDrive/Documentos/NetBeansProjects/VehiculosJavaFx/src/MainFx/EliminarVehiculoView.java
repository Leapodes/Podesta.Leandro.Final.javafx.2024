package MainFx;

import Gestion.Vehiculos.GestionVehiculos;
import Gestion.Vehiculos.Vehiculo;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author LENOVO
 */
public class EliminarVehiculoView {
    public void mostrar(GestionVehiculos gestionVehiculos) {
        Stage stage = new Stage();
        stage.setTitle("ELIMINAR VEHÍCULO ");

        Label lblborrar = new Label("Seleccione ");

        ListView<Vehiculo> listaVehiculos = new ListView();
        listaVehiculos.setItems(FXCollections.observableArrayList(gestionVehiculos.Leer()));
        
        listaVehiculos.setCellFactory(param -> new ListCell<Vehiculo>() {
            @Override
            public void updateItem(Vehiculo vehiculo, boolean vacio) {
                super.updateItem(vehiculo, vacio);
                
                if (vacio || vehiculo == null){
                    setText(null);
                } 
                else {
                    setText(vehiculo.getDatos());
                }
            }
        });

        Button btnBorrar = new Button("Borrar");
        btnBorrar.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Vehiculo vehiculoSeleccionado = listaVehiculos.getSelectionModel().getSelectedItem();
                gestionVehiculos.Borrar(vehiculoSeleccionado);
                listaVehiculos.getItems().remove(vehiculoSeleccionado);
            }

        });
        
        Button btnCerrar = new Button("Cerrar");
        
        

        btnCerrar.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                stage.close();
            }

        });

        VBox root = new VBox(10);
        root.getChildren().addAll(lblborrar, listaVehiculos, btnBorrar, btnCerrar);

        Scene scene = new Scene(root, 300, 300);
        stage.setScene(scene);
        stage.show();
    }
}
