package com.example.javafx.controlador;

import com.example.javafx.modelo.Jugador;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Stats implements Initializable{

    @FXML
    private TableView<Jugador> tblJugadores = new TableView<>();

    @FXML
    private TableColumn nombreJugador = new TableColumn<>();

    @FXML
    private TableColumn partidasGanadas = new TableColumn<>();

    @FXML
    private TableColumn partidasPerdidas = new TableColumn<>();

    @FXML
    private TableColumn partidasEmpatadas = new TableColumn<>();

    @FXML
    private ObservableList<Jugador> jugadores = FXCollections.observableArrayList();
    ;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        this.nombreJugador.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.partidasGanadas.setCellValueFactory(new PropertyValueFactory("partidasGanadas"));
        this.partidasPerdidas.setCellValueFactory(new PropertyValueFactory("partidasPerdidas"));
        this.partidasEmpatadas.setCellValueFactory(new PropertyValueFactory("partidasEmpatadas"));
    }

    @FXML
    public void agregarJugador(ActionEvent actionEvent){

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/javafx/añadirJugador.fxml"));
            Parent root = fxmlLoader.load();

            AñadirJugador jugador = fxmlLoader.getController();
            jugador.initAttributtes(jugadores);

            Scene scene = new Scene(root);
            Stage stage = new Stage();


            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Añadir Jugador");
            stage.showAndWait();

            Jugador jg = jugador.getJugador();

            this.jugadores.add(jg);

            this.tblJugadores.refresh();


        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
