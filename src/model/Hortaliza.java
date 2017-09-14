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
public class Hortaliza {

    private String nombreHortaliza;
    private String[] rendimientoHortaliza;
    private String rutaImgHortaliza;
    private String descripcionHortaliza;

    public Hortaliza(String nombreHortaliza, String[] rendimientoHortaliza, String rutaImgHortaliza, String descripcionHortaliza) {
        this.nombreHortaliza = nombreHortaliza;
        this.rendimientoHortaliza = rendimientoHortaliza;
        this.rutaImgHortaliza = rutaImgHortaliza;
        this.descripcionHortaliza = descripcionHortaliza;
    }

    public String getNombreHortaliza() {
        return nombreHortaliza;
    }

    public void setNombreHortaliza(String nombreHortaliza) {
        this.nombreHortaliza = nombreHortaliza;
    }

    public String getDescripcionHortaliza() {
        return descripcionHortaliza;
    }

    public void setDescripcionHortaliza(String descripcionHortaliza) {
        this.descripcionHortaliza = descripcionHortaliza;
    }

    public String[] getRendimientoHortaliza() {
        return rendimientoHortaliza;
    }

    public void setRendimientoHortaliza(String[] rendimientoHortaliza) {
        this.rendimientoHortaliza = rendimientoHortaliza;
    }

    public String getRutaImgHortaliza() {
        return rutaImgHortaliza;
    }

    public void setRutaImgHortaliza(String rutaImgHortaliza) {
        this.rutaImgHortaliza = rutaImgHortaliza;
    }

}
