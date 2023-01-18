package com.example.javafx.modelo;

import java.util.Objects;

public class Jugador {

    private String nombre;
    private int partidasGanadas;
    private int partidasPerdidas;
    private int partidasEmpatadas;


    public Jugador(String nombre, int partidasGanadas, int partidasPerdidas, int partidasEmpatadas) {
        this.nombre = nombre;
        this.partidasGanadas = partidasGanadas;
        this.partidasPerdidas = partidasPerdidas;
        this.partidasEmpatadas = partidasEmpatadas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPartidasGanadas() {
        return partidasGanadas;
    }

    public void setPartidasGanadas(int partidasGanadas) {
        this.partidasGanadas = partidasGanadas;
    }

    public int getPartidasPerdidas() {
        return partidasPerdidas;
    }

    public void setPartidasPerdidas(int partidasPerdidas) {
        this.partidasPerdidas = partidasPerdidas;
    }

    public int getPartidasEmpatadas() {
        return partidasEmpatadas;
    }

    public void setPartidasEmpatadas(int partidasEmpatadas) {
        this.partidasEmpatadas = partidasEmpatadas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jugador jugador = (Jugador) o;
        return partidasGanadas == jugador.partidasGanadas && partidasPerdidas == jugador.partidasPerdidas && partidasEmpatadas == jugador.partidasEmpatadas && Objects.equals(nombre, jugador.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, partidasGanadas, partidasPerdidas, partidasEmpatadas);
    }
}
