package MainFx;


import Gestion.Vehiculos.GestionVehiculos;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
/**import javafx.scene.layout.StackPane;**/
import javafx.stage.Stage;


/**
 *
 * @author LENOVO
 */
public class NewFXMain extends Application {
    protected GestionVehiculos gestionVehiculos = new GestionVehiculos();
    
    @Override
    public void start(Stage primaryStage) {
        Button btnCrear = new Button("Agregar vehículo");
        Button btnListar = new Button("Listar vehículos");
        Button btnModificar = new Button("Modificar vehículo");
        Button btnBorrar = new Button("Borrar vehículo");
        Button btnImportarVehiculo = new Button("Importar Vehículos");
        Button btnExportarVehiculo = new Button("Exportar Vehículos");
        Button btnSalir = new Button("Salir");
        
        
        btnCrear.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                new CrearVehiculoView().mostrar(gestionVehiculos);
            }
        });
        
        btnListar.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                new ListarVehiculoView().mostrar(gestionVehiculos);
            }
        });
        
        btnModificar.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                new ModificarVehiculoView().mostrar(gestionVehiculos);
            }
        });
        
        btnBorrar.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                new EliminarVehiculoView().mostrar(gestionVehiculos);
            }
        });
        
        btnImportarVehiculo.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                new ImportarVehiculosView().mostrar(gestionVehiculos);
            }
        });
        
        btnExportarVehiculo.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                new ExportarVehiculosView().mostrar(gestionVehiculos);
            }
        });
              
        
        btnSalir.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                primaryStage.close();
            }
        });
        
        
        /**StackPane root = new StackPane();
        StackPane.setAlignment(btnCrear, Pos.TOP_CENTER);
        StackPane.setAlignment(btnListar, Pos.CENTER_LEFT);
        StackPane.setAlignment(btnModificar, Pos.CENTER_RIGHT);
        StackPane.setAlignment(btnBorrar, Pos.BOTTOM_LEFT);
        StackPane.setAlignment(btnSalir, Pos.BOTTOM_RIGHT);
        
        root.getChildren().addAll(btnCrear, btnListar, btnModificar, btnBorrar, btnSalir);**/
        
        
        HBox manejoArchivos = new HBox(15);
        manejoArchivos.setAlignment(Pos.CENTER);
        manejoArchivos.getChildren().addAll(btnImportarVehiculo, btnExportarVehiculo);
        
        VBox root = new VBox(15);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(btnCrear, btnListar, btnModificar, btnBorrar, manejoArchivos, btnSalir);
        
        Scene scene = new Scene(root, 500, 500);
        
        primaryStage.setTitle("TIENDA DE VEHICULOS");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
