package MainFx;

import Gestion.Vehiculos.GestionVehiculos;
import Gestion.Vehiculos.Vehiculo;
import Gestion.Vehiculos.VehiculoNoEncontrado;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author LENOVO
 */
public class ModificarVehiculoView {

    public void mostrar(GestionVehiculos gestionVehiculos) {
        Stage stage = new Stage();
        stage.setTitle("MODIFICAR VEHÍCULO ");

        ListView<Vehiculo> listaVehiculos = new ListView<>();
        listaVehiculos.setItems(FXCollections.observableArrayList(gestionVehiculos.Leer()));

        listaVehiculos.setCellFactory(param -> new ListCell<Vehiculo>() {
            @Override
            public void updateItem(Vehiculo vehiculo, boolean vacio) {
                super.updateItem(vehiculo, vacio);

                if (vacio || vehiculo == null) {
                    setText(null);
                } else {
                    setText(vehiculo.getDatos());
                }
            }
        });

        Label lblnombre = new Label("Nombre: ");
        TextField txtnombre = new TextField();

        Label lbltipo = new Label("Tipo: ");
        TextField txttipo = new TextField();

        Label lblprecio = new Label("Precio: ");
        TextField txtprecio = new TextField();

        Button btnModificar = new Button("Modificar");

        btnModificar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Vehiculo vehiculoModificado = listaVehiculos.getSelectionModel().getSelectedItem();
                //MANEJO DE EXCEPCIONES
                try {
                    if (vehiculoModificado == null) {
                        throw new VehiculoNoEncontrado("Seleccioná un vehículo primero");
                    }
                    vehiculoModificado.setMarcaModelo(txtnombre.getText());
                    vehiculoModificado.setTipo(txttipo.getText());
                    try {
                        vehiculoModificado.setPrecio(Double.parseDouble(txtprecio.getText()));
                    } catch (NumberFormatException e) {
                        System.out.println("Precio inválido");
                        return;
                    }

                    // Actualizar la vista (opcional)
                    listaVehiculos.refresh();
                } catch (VehiculoNoEncontrado error) {
                    System.out.println(error.getMessage());
                    System.out.println("Revisá que tengas seleccionado un vehículo");
                }
            }
        });

        VBox root = new VBox(10);
        root.getChildren().addAll(listaVehiculos, lblnombre, txtnombre, lbltipo, txttipo, lblprecio, txtprecio, btnModificar);

        Scene scene = new Scene(root, 500, 500);
        stage.setScene(scene);
        stage.show();
    }

}
