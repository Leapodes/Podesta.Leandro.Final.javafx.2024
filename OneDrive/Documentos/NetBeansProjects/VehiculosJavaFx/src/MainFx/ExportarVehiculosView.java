package MainFx;

import Gestion.Vehiculos.GestionVehiculos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author LENOVO
 */
public class ExportarVehiculosView {

    public void mostrar(GestionVehiculos gestionVehiculos) {
        Stage stage = new Stage();
        stage.setTitle("EXPORTANDO VEHÍCULOS");

        gestionVehiculos.exportarVehiculos();

        Label lblExportar = new Label("EXPORTACÍON EXITOSA!");

        VBox root = new VBox(15);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(lblExportar);

        Scene scene = new Scene(root, 300, 100);
        stage.setScene(scene);
        stage.show();
    }

}
