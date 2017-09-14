/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Erlinda
 */
public class Textura {

    private double texturaArena;
    private double texturaLimo;
    private double texturaArcilla;
    private String tipoTextura;

    public Textura() {
        texturaArena = 0;
        texturaLimo = 0;
        texturaArcilla = 0;
        tipoTextura = "";
    }

    public double getTexturaArena() {
        return texturaArena;
    }

    public void setTexturaArena(double texturaArena) {
        this.texturaArena = texturaArena;
    }

    public double getTexturaLimo() {
        return texturaLimo;
    }

    public void setTexturaLimo(double texturaLimo) {
        this.texturaLimo = texturaLimo;
    }

    public double getTexturaArcilla() {
        return texturaArcilla;
    }

    public void setTexturaArcilla(double texturaArcilla) {
        this.texturaArcilla = texturaArcilla;
    }

    public String getTipoTextura() {
        return tipoTextura;
    }

    public void setTipoTextura(String tipoTextura) {
        if (this.tipoTextura.isEmpty()) {
            this.tipoTextura = tipoTextura;
        }
    }
}
