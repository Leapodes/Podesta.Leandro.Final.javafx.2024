
package MainFx;

import Gestion.Vehiculos.CajasDeCambios;
import Gestion.Vehiculos.EstadoVehiculo;
import Gestion.Vehiculos.GestionVehiculos;
import Gestion.Vehiculos.TipoDeMoto;
import Gestion.Vehiculos.VehiculoAuto;
import Gestion.Vehiculos.VehiculoCamion;
import Gestion.Vehiculos.VehiculoMoto;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author LENOVO
 */
public class CrearVehiculoView {
    VBox dynamicVbox = new VBox();
    
    /* Atributos de todos los vehiculos*/
    String tipo;
    int precio;
    String marcaModelo;
    EstadoVehiculo estado;
    
    /*Atributos de auto*/
    int cantidadPuertas;
    CajasDeCambios cajaDeCambios;
    
    /*Atributos de moto*/
    TipoDeMoto tipoDeMoto;
    int cilindrada;
    
    /*Atributos de camión*/
    double capacidad;
    boolean acoplado;
    int ejes;

    public void mostrar(GestionVehiculos gestionVehiculos) {
        dynamicVbox.setStyle("-fx-padding: 20; -fx-alignment: center;");
        
        Stage stage = new Stage();
        stage.setTitle("NUEVO VEHÍCULO");
        
        Label lblseleccionTipoVehiculo = new Label("Seleccione el tipo de vehículo");
        ChoiceBox<String> tipos = new ChoiceBox<>();
        tipos.getItems().addAll("Auto","Moto","Camión");
        tipos.setValue("Seleccione");
        
        tipos.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                tipo = tipos.getValue();
                
                /* Inputs para todos los autos*/
                Label lblcantidadPuertas = new Label("Ingrese la cantidad de puertas: ");
                TextField txtcantidadDePuertas = new TextField();

                Label lblcajaDeCambios = new Label("Seleccione la caja de cambios: ");
                ChoiceBox<String> cajasDeCambios = new ChoiceBox<>();
                cajasDeCambios.getItems().addAll(CajasDeCambios.AUTOMATICA.name(), CajasDeCambios.SEMI_AUTOMATICA.name(), CajasDeCambios.MANUAL.name());
                cajasDeCambios.setValue("Seleccione");
                cajasDeCambios.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                    cajaDeCambios = CajasDeCambios.valueOf(newValue);
                });
                if ("Auto".equals(tipo)) {
                    dynamicVbox.getChildren().clear();
                    dynamicVbox.getChildren().addAll(lblcantidadPuertas, txtcantidadDePuertas, lblcajaDeCambios, cajasDeCambios);
                }
                
                 /* Inputs para todos las motos*/
                Label lblcilindrada = new Label("Ingrese la cilindrada: ");
                TextField txtcilindrada = new TextField();

                Label lbltipoDeMoto = new Label("Seleccione el tipo de moto: ");
                ChoiceBox<String> tiposDeMotos = new ChoiceBox<>();
                tiposDeMotos.getItems().addAll(TipoDeMoto.DEPORTIVA.name(), TipoDeMoto.ENDURO.name(), TipoDeMoto.SCOOTER.name());
                tiposDeMotos.setValue("Seleccione");
                tiposDeMotos.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                    tipoDeMoto = TipoDeMoto.valueOf(newValue);
                });
                if ("Moto".equals(tipo)) {
                    dynamicVbox.getChildren().clear();
                    dynamicVbox.getChildren().addAll(lblcilindrada,txtcilindrada, lbltipoDeMoto, tiposDeMotos);
                }
                
                /* Inputs para todos los camiones*/
                Label lblcapacidad = new Label("Ingrese la capacidad del camión: ");
                TextField txtcapacidad = new TextField();

                Label lblejes = new Label("Ingrese la cantidad de ejes: ");
                TextField txtejes = new TextField();

                Label lblacoplado = new Label("Tiene acoplado?: ");
                ChoiceBox<String> choiceAcoplado = new ChoiceBox<>();
                choiceAcoplado.getItems().addAll("Si", "No");
                choiceAcoplado.setValue("Seleccione");
                choiceAcoplado.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                acoplado = "Si".equalsIgnoreCase(newValue);

                   
                });

                if ("Camión".equals(tipo)) {
                    dynamicVbox.getChildren().clear();
                    dynamicVbox.getChildren().addAll(lblcapacidad, txtcapacidad, lblejes, txtejes, lblacoplado, choiceAcoplado);
                }
            }
        });
        
        /* Inputs para todos los vehiculos*/
        Label lblNombre = new Label("Ingrese nuevo vehículo: ");
        TextField txtNombre = new TextField();
        
        Label lblPrecio = new Label("Ingrese precio: ");
        TextField txtPrecio = new TextField();
        
        Label lblestado = new Label("Seleccione el estado del vehículo: ");
        ChoiceBox<String> estados = new ChoiceBox<>();
        estados.getItems().addAll(EstadoVehiculo.DISPONIBLE.name(), EstadoVehiculo.EN_REPARACION.name(), EstadoVehiculo.FUERA_DE_SERVICIO.name());
        estados.setValue("Seleccione");
        estados.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            estado = EstadoVehiculo.valueOf(newValue);
        });
        
        Button btnGuardar = new Button("Guardar");
        
        btnGuardar.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                marcaModelo = txtNombre.getText();
                precio = Integer.parseInt(txtPrecio.getText());
                switch (tipo) {
                    case "Auto":
                        gestionVehiculos.Crear(new VehiculoAuto(marcaModelo, tipo, precio, estado, cantidadPuertas, cajaDeCambios));
                        break;
                    case "Moto":
                        gestionVehiculos.Crear(new VehiculoMoto(marcaModelo, tipo, precio, estado, cilindrada, tipoDeMoto));
                        break;
                    case "Camión":
                        gestionVehiculos.Crear(new VehiculoCamion(marcaModelo, tipo, precio, estado, capacidad, acoplado, ejes));
                        break;
                    default:
                        throw new AssertionError();
                }
                stage.close();
            }
        });
        
       
        
        
        VBox root = new VBox(lblseleccionTipoVehiculo, tipos, lblNombre, txtNombre, lblPrecio, txtPrecio, lblestado, estados, dynamicVbox, btnGuardar);
        
        root.setStyle("-fx-padding: 20; -fx-alignment: center;");
        
        Scene scene = new Scene(root, 300, 500);
        stage.setScene(scene);
        stage.show();
    }
    
}
