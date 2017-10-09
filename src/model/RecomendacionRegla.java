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
public class RecomendacionRegla {

    int id_recomendacion_regla;
    String nombreFertilizanteNitrogenado;
    String nombreFertilizanteFosfatado;
    String nombreFertilizantePotasico;
    int formulaFertilizanteNitrogenado;
    int formulaFertilizanteFosfatado;
    int formulaFertilizantePotasico;

    public RecomendacionRegla() {

    }

    public RecomendacionRegla(int id_recomendacion_regla, String nombreFertilizanteNitrogenado, String nombreFertilizanteFosfatado, String nombreFertilizantePotasico, int formulaFertilizanteNitrogenado, int formulaFertilizanteFosfatado, int formulaFertilizantePotasico) {
        this.id_recomendacion_regla = id_recomendacion_regla;
        this.nombreFertilizanteNitrogenado = nombreFertilizanteNitrogenado;
        this.nombreFertilizanteFosfatado = nombreFertilizanteFosfatado;
        this.nombreFertilizantePotasico = nombreFertilizantePotasico;
        this.formulaFertilizanteNitrogenado = formulaFertilizanteNitrogenado;
        this.formulaFertilizanteFosfatado = formulaFertilizanteFosfatado;
        this.formulaFertilizantePotasico = formulaFertilizantePotasico;
    }

    public int getId_recomendacion_regla() {
        return id_recomendacion_regla;
    }

    public String getNombreFertilizanteNitrogenado() {
        return nombreFertilizanteNitrogenado;
    }

    public String getNombreFertilizanteFosfatado() {
        return nombreFertilizanteFosfatado;
    }

    public String getNombreFertilizantePotasico() {
        return nombreFertilizantePotasico;
    }

    public int getFormulaFertilizanteNitrogenado() {
        return formulaFertilizanteNitrogenado;
    }

    public int getFormulaFertilizanteFosfatado() {
        return formulaFertilizanteFosfatado;
    }

    public int getFormulaFertilizantePotasico() {
        return formulaFertilizantePotasico;
    }

    public void setId_recomendacion_regla(int id_recomendacion_regla) {
        this.id_recomendacion_regla = id_recomendacion_regla;
    }

    public void setNombreFertilizanteNitrogenado(String nombreFertilizanteNitrogenado) {
        this.nombreFertilizanteNitrogenado = nombreFertilizanteNitrogenado;
    }

    public void setNombreFertilizanteFosfatado(String nombreFertilizanteFosfatado) {
        this.nombreFertilizanteFosfatado = nombreFertilizanteFosfatado;
    }

    public void setNombreFertilizantePotasico(String nombreFertilizantePotasico) {
        this.nombreFertilizantePotasico = nombreFertilizantePotasico;
    }

    public void setFormulaFertilizanteNitrogenado(int formulaFertilizanteNitrogenado) {
        this.formulaFertilizanteNitrogenado = formulaFertilizanteNitrogenado;
    }

    public void setFormulaFertilizanteFosfatado(int formulaFertilizanteFosfatado) {
        this.formulaFertilizanteFosfatado = formulaFertilizanteFosfatado;
    }

    public void setFormulaFertilizantePotasico(int formulaFertilizantePotasico) {
        this.formulaFertilizantePotasico = formulaFertilizantePotasico;
    }

    
}
