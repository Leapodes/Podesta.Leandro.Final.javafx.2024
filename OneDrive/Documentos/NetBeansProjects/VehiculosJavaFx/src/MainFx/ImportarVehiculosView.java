package MainFx;

import Gestion.Vehiculos.GestionVehiculos;
import Gestion.Vehiculos.Vehiculo;
import java.util.Iterator;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author LENOVO
 */
public class ImportarVehiculosView {
    public void mostrar(GestionVehiculos gestionVehiculos) {
        Stage stage = new Stage();
        stage.setTitle("IMPORTANDO VEHÍCULOS");
        
        gestionVehiculos.importarVehiculos();
        
        Label lblImportar = new Label("IMPORTACIÓN EXITOSA!");
        
        VBox root = new VBox(15);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(lblImportar);
        
        Scene scene = new Scene(root, 300, 100);
        stage.setScene(scene);
        stage.show();
    }
}
