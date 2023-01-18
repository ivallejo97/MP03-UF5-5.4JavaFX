package com.example.javafx.controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;



public class MainController {

    @FXML
    private AnchorPane pane;

    @FXML
    private Button a1, a2, a3, b1, b2, b3, c1, c2, c3, btnJugar, btnEstadisticas;

    @FXML
    private MenuItem btnHelp, btnCerrar, btnEstadisticas1, btnAñadirJugador, btnCambiarDiseño, btnCambiarDiseño2;

    @FXML
    private ToggleGroup group = new ToggleGroup();

    @FXML
    private RadioButton rb1, rb2, rb3;

    Stats stats = new Stats();

    Boolean partidaJugVSJug = true;
    //Metodo para seleccionar el modo de juego y empezar la partida
    @FXML
    private void seleccionarModo(ActionEvent actionEvent) {

        RadioButton rb = (RadioButton) group.getSelectedToggle();

        if (rb != null) {

            if (rb1.isSelected()) {
                reiniciarCasillas();
                maquinaVSMaquina();
            }
            if (rb2.isSelected()) {
                jugadorVSMaquina();
                partidaJugVSJug = false;
            }
            if (rb3.isSelected()) {
                reiniciarCasillas();
                jugadorVSJugador();
                partidaJugVSJug = true;
            }

        }
    }


    //Metodo para cerrar la aplicación.
    @FXML
    private void cerrarApp(ActionEvent actionEvent) {
        System.exit(0);
    }


    @FXML
    private void cargarNuevoCSS(ActionEvent actionEvent) {

        pane.getStylesheets().clear();
        pane.getStylesheets().add(String.valueOf(MainController.class.getResource("/com/example/javafx/styles/estilo1.css")));

    }

    @FXML
    private void cargarNuevoCSS1(ActionEvent actionEvent) {

        pane.getStylesheets().clear();
        pane.getStylesheets().add(String.valueOf(MainController.class.getResource("/com/example/javafx/styles/estilo2.css")));

    }


    //Metodo para cargar la ayuda disponible en el menu superior.
    @FXML
    private void loadHelp(ActionEvent actionEvent) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/javafx/help.fxml"));
            Parent root = fxmlLoader.load();

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("AYUDA");
            stage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Metodo para cargar la pantalla en la que se encuentran las estadisticas de un jugador.
    @FXML
    private void loadEstadisticas(ActionEvent actionEvent) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/javafx/stats.fxml"));
            Parent root = fxmlLoader.load();

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Estadísticas");
            stage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Meotodo para añadir Jugadores a la tabla de estadisticas.
    @FXML
    private void agregarJugador(ActionEvent actionEvent) {
        stats.agregarJugador(actionEvent);
    }

    Boolean casillaMarcada1 = false;
    Boolean casillaMarcada2 = false;
    Boolean casillaMarcada3 = false;
    Boolean casillaMarcada4 = false;
    Boolean casillaMarcada5 = false;
    Boolean casillaMarcada6 = false;
    Boolean casillaMarcada7 = false;
    Boolean casillaMarcada8 = false;
    Boolean casillaMarcada9 = false;

    int casilla = 0;

    // Metodo del modo de juego Jugador vs Jugador
    @FXML
    private void jugadorVSJugador() {
        a1.setOnAction(this::marcarCasilla1);
        a2.setOnAction(this::marcarCasilla2);
        a3.setOnAction(this::marcarCasilla3);
        b1.setOnAction(this::marcarCasilla4);
        b2.setOnAction(this::marcarCasilla5);
        b3.setOnAction(this::marcarCasilla6);
        c1.setOnAction(this::marcarCasilla7);
        c2.setOnAction(this::marcarCasilla8);
        c3.setOnAction(this::marcarCasilla9);
    }

    // Metodo del modo de juego Jugador vs Maquina
    int turno = 0;
    int num = 1;

    @FXML
    private void jugadorVSMaquina() {

        if (turno == 0 || turno == 2 || turno == 4 || turno == 6 || turno == 8) {
            a1.setOnAction(this::marcarCasilla1);
            a2.setOnAction(this::marcarCasilla2);
            a3.setOnAction(this::marcarCasilla3);
            b1.setOnAction(this::marcarCasilla4);
            b2.setOnAction(this::marcarCasilla5);
            b3.setOnAction(this::marcarCasilla6);
            c1.setOnAction(this::marcarCasilla7);
            c2.setOnAction(this::marcarCasilla8);
            c3.setOnAction(this::marcarCasilla9);
            btnJugar.setText("Tu turno");

        } else if (turno == 1 || turno == 3 || turno == 5 || turno == 7 || turno == 9) {
            if (num == 1) {
                    marcarMaquina1(new ActionEvent());
                } else if (num == 2) {
                    marcarMaquina2(new ActionEvent());
                } else if (num == 3) {
                    marcarMaquina3(new ActionEvent());
                } else if (num == 4) {
                    marcarMaquina4(new ActionEvent());
                } else if (num == 5) {
                    marcarMaquina5(new ActionEvent());
                } else if (num == 6) {
                    marcarMaquina6(new ActionEvent());
                } else if (num == 7) {
                    marcarMaquina7(new ActionEvent());
                } else if (num == 8) {
                    marcarMaquina8(new ActionEvent());
                } else if (num == 9) {
                    marcarMaquina9(new ActionEvent());
                }

            btnJugar.setText("Turno de la maquina");

        }
    }


    @FXML
    private void maquinaVSMaquina() {}



    //Metodo para marcar una casilla aleatoria
    private void marcarMaquina1(ActionEvent actionEvent) {
        if (casillaMarcada1 == false){
            if (casilla %2 == 0) {
                a1.setText("X");
                casilla++;
            } else {
                a1.setText("O");
                casilla++;
            }
            casillaMarcada1 = true;
            turno++;
            comprobarVictoria();
        }
    }

    //Metodo para marcar una casilla aleatoria
    private void marcarMaquina2(ActionEvent actionEvent) {
        if (casillaMarcada2 == false){
            if (casilla %2 == 0) {
                a2.setText("X");
                casilla++;
            } else {
                a2.setText("O");
                casilla++;
            }
            casillaMarcada2 = true;
            turno++;
            comprobarVictoria();
        }
    }

    //Metodo para marcar una casilla aleatoria
    private void marcarMaquina3(ActionEvent actionEvent) {
        if (casillaMarcada3 == false){
            if (casilla %2 == 0) {
                a3.setText("X");
                casilla++;
            } else {
                a3.setText("O");
                casilla++;
            }
            casillaMarcada3 = true;
            turno++;
            comprobarVictoria();
        }
    }

    //Metodo para marcar una casilla aleatoria
    private void marcarMaquina4(ActionEvent actionEvent) {
        if (casillaMarcada4 == false){
            if (casilla %2 == 0) {
                b1.setText("X");
                casilla++;
            } else {
                b1.setText("O");
                casilla++;
            }
            casillaMarcada4 = true;
            turno++;
            comprobarVictoria();
        }
    }

    //Metodo para marcar una casilla aleatoria
    private void marcarMaquina5(ActionEvent actionEvent) {
        if (casillaMarcada5 == false){
            if (casilla %2 == 0) {
                b2.setText("X");
                casilla++;
            } else {
                b2.setText("O");
                casilla++;
            }
            casillaMarcada5 = true;
            turno++;
            comprobarVictoria();
        }
    }

    //Metodo para marcar una casilla aleatoria
    private void marcarMaquina6(ActionEvent actionEvent) {
        if (casillaMarcada6 == false){
            if (casilla %2 == 0) {
                b3.setText("X");
                casilla++;
            } else {
                b3.setText("O");
                casilla++;
            }
            casillaMarcada6 = true;
            turno++;
            comprobarVictoria();
        }
    }

    //Metodo para marcar una casilla aleatoria
    private void marcarMaquina7(ActionEvent actionEvent) {
        if (casillaMarcada7 == false){
            if (casilla %2 == 0) {
                c1.setText("X");
                casilla++;
            } else {
                c1.setText("O");
                casilla++;
            }
            casillaMarcada7 = true;
            turno++;
            comprobarVictoria();
        }
    }

    //Metodo para marcar una casilla aleatoria
    private void marcarMaquina8(ActionEvent actionEvent) {
        if (casillaMarcada8 == false){
            if (casilla %2 == 0) {
                c2.setText("X");
                casilla++;
            } else {
                c2.setText("O");
                casilla++;
            }
            casillaMarcada8 = true;
            turno++;
            comprobarVictoria();
        }
    }

    //Metodo para marcar una casilla aleatoria
    private void marcarMaquina9(ActionEvent actionEvent) {
        if (casillaMarcada9 == false){
            if (casilla %2 == 0) {
                c3.setText("X");
                casilla++;
            } else {
                c3.setText("O");
                casilla++;
            }
            casillaMarcada9 = true;
            turno++;
            comprobarVictoria();
        }
    }

    //Metodo para marcar la casilla 1
    @FXML
    private void marcarCasilla1(ActionEvent actionEvent){

        if (casillaMarcada1 == false){
            if (casilla %2 == 0) {
                a1.setText("X");
                casilla++;
            } else {
                a1.setText("O");
                casilla++;
            }
            casillaMarcada1 = true;
            comprobarVictoria();
            num = 4;
            turno++;
        }
    }

    //Metodo para marcar la casilla 2
    @FXML
    private void marcarCasilla2(ActionEvent actionEvent){

        if (casillaMarcada2 == false){
            if (casilla %2 == 0){
                a2.setText("X");
                casilla++;
            } else {
                a2.setText("O");
                casilla++;
            }
            casillaMarcada2 = true;
            comprobarVictoria();
            turno++;
            num = 8;
        }
    }

    //Metodo para marcar la casilla 3
    @FXML
    private void marcarCasilla3(ActionEvent actionEvent){

        if (casillaMarcada3 == false){
            if (casilla %2 == 0){
                a3.setText("X");
                casilla++;
            } else {
                a3.setText("O");
                casilla++;
            }
            casillaMarcada3 = true;
            comprobarVictoria();
            num = 5;
            turno++;
        }
    }

    //Metodo para marcar la casilla 4
    @FXML
    private void marcarCasilla4(ActionEvent actionEvent){

        if (casillaMarcada4 == false){
            if (casilla %2 == 0){
                b1.setText("X");
                casilla++;
            } else {
                b1.setText("O");
                casilla++;
            }
            casillaMarcada4 = true;
            comprobarVictoria();
            num = 2;
            turno++;
        }
    }

    //Metodo para marcar la casilla 5
    @FXML
    private void marcarCasilla5(ActionEvent actionEvent){

        if (casillaMarcada5 == false){
            if (casilla %2 == 0){
                b2.setText("X");
                casilla++;
            } else {
                b2.setText("O");
                casilla++;
            }
            casillaMarcada5 = true;
            comprobarVictoria();
            num = 7;
            turno++;
        }
    }

    //Metodo para marcar la casilla 6
    @FXML
    private void marcarCasilla6(ActionEvent actionEvent){

        if (casillaMarcada6 == false){
            if (casilla %2 == 0){
                b3.setText("X");
                casilla++;
            } else {
                b3.setText("O");
                casilla++;
            }
            casillaMarcada6 = true;
            comprobarVictoria();
            num = 9;

        }
    }

    //Metodo para marcar la casilla 7
    @FXML
    private void marcarCasilla7(ActionEvent actionEvent){

        if (casillaMarcada7 == false){
            if (casilla %2 == 0){
                c1.setText("X");
                casilla++;
            } else {
                c1.setText("O");
                casilla++;
            }
            casillaMarcada7 = true;
            comprobarVictoria();
            num = 6;
            turno++;
        }
    }

    //Metodo para marcar la casilla 8
    @FXML
    private void marcarCasilla8(ActionEvent actionEvent){

        if (casillaMarcada8 == false){
            if (casilla %2 == 0){
                c2.setText("X");
                casilla++;
            } else {
                c2.setText("O");
                casilla++;
            }
            casillaMarcada8 = true;
            comprobarVictoria();
            num = 1;
            turno++;
        }
    }

    //Metodo para marcar la casilla 9
    @FXML
    private void marcarCasilla9(ActionEvent actionEvent){

        if (casillaMarcada9 == false){
            if (casilla %2 == 0){
                c3.setText("X");
                casilla++;
            } else {
                c3.setText("O");
                casilla++;
            }
            casillaMarcada9 = true;
            turno++;
            num = 3;
            comprobarVictoria();
        }
    }

    //Metodo para reiniciar el valor de las casillas
    @FXML
    private void reiniciarCasillas() {
        a1.setText(""); casillaMarcada1 = false;
        a2.setText(""); casillaMarcada2 = false;
        a3.setText(""); casillaMarcada3 = false;
        b1.setText(""); casillaMarcada4 = false;
        b2.setText(""); casillaMarcada5 = false;
        b3.setText(""); casillaMarcada6 = false;
        c1.setText(""); casillaMarcada7 = false;
        c2.setText(""); casillaMarcada8 = false;
        c3.setText(""); casillaMarcada9 = false;

    }


    // Metodo para notificar la victoria del jugador 1
    private void notificarVictoriaJugador1(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("¡VICTORIA!");
        alert.setHeaderText("¡Enhorabuena jugador 1, has ganado!");
        alert.getButtonTypes().setAll(ButtonType.CLOSE);
        alert.showAndWait();
        seleccionarModo(new ActionEvent());
        agregarJugador(new ActionEvent());
        reiniciarCasillas();
        turno = 0;
    }

    // Metodo para notificar la victoria del jugador 2
    private void notificarVictoriaJugador2(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("¡VICTORIA!");
        alert.setHeaderText("¡Enhorabuena jugador 2, has ganado!");
        alert.getButtonTypes().setAll(ButtonType.CLOSE);
        alert.showAndWait();
        agregarJugador(new ActionEvent());
        reiniciarCasillas();
        turno = 0;
    }


    private void notificarVictoriaMaquina(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("¡VICTORIA!");
        alert.setHeaderText("¡Ha ganado la maquina!");
        alert.getButtonTypes().setAll(ButtonType.CLOSE);
        alert.showAndWait();
        reiniciarCasillas();
    }


    //Metodo para notificar que la partida ha terminado en empate
    private void notificarEmpate(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("¡EMPATE!");
        alert.setHeaderText("La partida ha terminado en empate");
        alert.getButtonTypes().setAll(ButtonType.CLOSE);
        alert.showAndWait();
    }

    // Metodo para comprobar si algún jugador ha ganado la partida
    private void comprobarVictoria(){

            if (a1.getText().equals("X")&&a2.getText().equals("X") && a3.getText().equals("X")
                || b1.getText().equals("X") && b2.getText().equals("X") && b3.getText().equals("X")
                || c1.getText().equals("X") && c2.getText().equals("X") && c3.getText().equals("X")
                || a1.getText().equals("X") && b1.getText().equals("X") && c1.getText().equals("X")
                || a2.getText().equals("X") && b2.getText().equals("X") && c2.getText().equals("X")
                || a3.getText().equals("X") && b3.getText().equals("X") && c3.getText().equals("X")
                || a1.getText().equals("X") && b2.getText().equals("X") && c3.getText().equals("X")
                || a3.getText().equals("X") && b2.getText().equals("X") && c1.getText().equals("X")) {

                    notificarVictoriaJugador1();
                    reiniciarCasillas();

                } else if (a1.getText().equals("O") && a2.getText().equals("O") && a3.getText().equals("O")
                          || b1.getText().equals("O") && b2.getText().equals("O") && b3.getText().equals("O")
                          || c1.getText().equals("O") && c2.getText().equals("O") && c3.getText().equals("O")
                          || a1.getText().equals("O") && b1.getText().equals("O") && c1.getText().equals("O")
                          || a2.getText().equals("O") && b2.getText().equals("O") && c2.getText().equals("O")
                          || a3.getText().equals("O") && b3.getText().equals("O") && c3.getText().equals("O")
                          || a1.getText().equals("O") && b2.getText().equals("O") && c3.getText().equals("O")
                          || a3.getText().equals("O") && b2.getText().equals("O") && c1.getText().equals("O")){

                if (partidaJugVSJug == true){
                    notificarVictoriaJugador2();
                } else {
                    notificarVictoriaMaquina();
                }                    reiniciarCasillas();

                } else if (a1.getText() != "" && a2.getText() != "" && a3.getText() != ""        // Una vez marcadas las 9 casillas si no ha ganado
                           && b1.getText() != "" && b2.getText() != "" && b3.getText() != ""     // nadie con esto comprobamos que la partida
                   && c1.getText() != "" && c2.getText() != "" && c3.getText() != ""){           // ha quedado en empate
                notificarEmpate();
                reiniciarCasillas();
            }

    }





}