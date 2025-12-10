package MainFx;

import Gestion.Vehiculos.GestionVehiculos;
import Gestion.Vehiculos.Vehiculo;
import java.io.FileWriter;
import java.util.Comparator;
import java.util.Iterator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author LENOVO
 */
public class ListarVehiculoView {

    public void mostrar(GestionVehiculos gestionVehiculos) {
        Stage stage = new Stage();
        stage.setTitle("LISTA DE VEHÍCULOS");

        ObservableList<Vehiculo> listaObsVehiculos = FXCollections.observableArrayList(gestionVehiculos.Leer());
        FilteredList<Vehiculo> listaFiltrada = new FilteredList<>(listaObsVehiculos, p -> true);
        SortedList<Vehiculo> listaOrdenada = new SortedList<>(listaFiltrada);
        ListView<Vehiculo> listaVehiculos = new ListView(listaOrdenada);

        Label lblNombre = new Label("Vehículos disponibles: ");

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

        Button btnCerrar = new Button("Cerrar");

        btnCerrar.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                stage.close();
            }

        });

        ChoiceBox<String> filtroVehiculo = new ChoiceBox<>();
        filtroVehiculo.getItems().addAll("Auto", "Moto", "Camión");
        filtroVehiculo.setValue("Vehículo");
        filtroVehiculo.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            listaFiltrada.setPredicate(vehiculo -> vehiculo.getTipo().equals(newValue));
        });
        Button btnOrdenModelo = new Button("Modelo");
        Button btnPrecioVehiculo = new Button("Precio");
        Button btnEstadoDeServicio = new Button("Estado");
        Button btnExportar = new Button("Exportar");

        Comparator<Vehiculo> ordenModelo = new Comparator<Vehiculo>() {
            @Override
            public int compare(Vehiculo vehiculo1, Vehiculo vehiculo2) {
                return vehiculo1.getNombre().compareTo(vehiculo2.getNombre());
            }
        };
        /*WILDCARD EXTENDS*/
        Comparator<? extends Vehiculo> ordenEstado = new Comparator<Vehiculo>() {
            @Override
            public int compare(Vehiculo vehiculo1, Vehiculo vehiculo2) {
                return vehiculo1.getEstado().compareTo(vehiculo2.getEstado());
            }
        };

        btnOrdenModelo.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                listaOrdenada.setComparator(ordenModelo);
            }
        });

        btnPrecioVehiculo.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                listaOrdenada.setComparator(Comparator.naturalOrder());
            }
        });

        btnEstadoDeServicio.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                listaOrdenada.setComparator((Comparator<? super Vehiculo>) ordenEstado);
            }
        });

        btnExportar.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                new ExportarVehiculosTXTView().mostrar(listaVehiculos);
            }
        });

        HBox manejoArchivos1 = new HBox(15);
        manejoArchivos1.setAlignment(Pos.CENTER);
        manejoArchivos1.getChildren().addAll(filtroVehiculo, btnOrdenModelo);

        HBox manejoArchivos2 = new HBox(15);
        manejoArchivos2.setAlignment(Pos.CENTER);
        manejoArchivos2.getChildren().addAll(btnPrecioVehiculo, btnEstadoDeServicio);

        VBox manejoArchivos3 = new VBox(15);
        manejoArchivos3.setAlignment(Pos.CENTER);
        manejoArchivos3.getChildren().addAll(btnExportar);

        VBox filtro = new VBox(10);
        filtro.getChildren().addAll(manejoArchivos1, manejoArchivos2);

        HBox export = new HBox(10);
        export.getChildren().addAll(filtro, manejoArchivos3);

        VBox root = new VBox(10);
        root.getChildren().addAll(export, lblNombre, listaVehiculos, btnCerrar);

        Scene scene = new Scene(root, 400, 400);
        stage.setScene(scene);
        stage.show();
    }
}
