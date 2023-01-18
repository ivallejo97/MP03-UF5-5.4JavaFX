package com.example.javafx.controlador;

import com.example.javafx.modelo.Jugador;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AñadirJugador implements Initializable {

    @FXML
    private TextField nombreJugador = new TextField();

    @FXML
    private Button btnCancelar;

    @FXML
    private  Button btnAceptar;

    private Jugador jugador;

    @FXML
    private ObservableList<Jugador> jugadores ;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }

    public void initAttributtes(ObservableList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    @FXML
    private void guardar(ActionEvent actionEvent){


        String nombre = this.nombreJugador.getText();
        int partidasGanadas = 0;
        int partidasPerdidas = 0;
        int partidasEmpatadas = 0;


        Jugador jugador = new Jugador(nombre,partidasGanadas,partidasPerdidas,partidasEmpatadas);

        this.jugadores.add(jugador);

        Stage stage = (Stage) this.btnAceptar.getScene().getWindow();
        stage.close();

    }

    @FXML
    private void salir(ActionEvent actionEvent){
        this.jugador = null;
        // Cerrar ventana
        Stage stage = (Stage) this.btnCancelar.getScene().getWindow();
        stage.close();
    }

    public Jugador getJugador() {
        return jugador;
    }

}
