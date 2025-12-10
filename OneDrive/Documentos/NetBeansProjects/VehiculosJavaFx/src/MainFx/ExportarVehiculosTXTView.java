package MainFx;

import Gestion.Vehiculos.Vehiculo;
import java.io.FileWriter;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author LENOVO
 */
public class ExportarVehiculosTXTView {

    public void mostrar(ListView listaVehiculos) {
        Stage stage = new Stage();
        stage.setTitle("EXPORTANDO VEHÍCULOS");
        
        String autos = "AUTOS:\n";
        String motos = "MOTOS:\n";
        String camiones = "CAMIONES:\n";

        for (Object vehiculoObjeto : listaVehiculos.getItems()) {
            Vehiculo vehiculoActual = (Vehiculo) vehiculoObjeto;
            switch (vehiculoActual.getTipo()) {
                case "Auto":
                    autos += vehiculoActual.getDatos() + "\n";
                    break;
                case "Moto":
                    motos += vehiculoActual.getDatos() + "\n";
                    break;
                case "Camión":
                    camiones += vehiculoActual.getDatos() + "\n";
                    break;
            }
        }

        try (FileWriter escritura = new FileWriter("./src/MainFx/ListaVehiculosTXT.txt")) {
            escritura.write(autos);
            escritura.write(motos);
            escritura.write(camiones);
        } catch (Exception e) {
            System.out.println("error");
            System.out.println(e.getMessage());
        }

        Label lblExportar = new Label("EXPORTANDO EN FORMATO TXT");
        VBox root = new VBox(15);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(lblExportar);

        Scene scene = new Scene(root, 300, 100);
        stage.setScene(scene);
        stage.show();
    }

}
