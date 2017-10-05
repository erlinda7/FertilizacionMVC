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
public class NitrogenoRegla {

    int idNitrogenoRegla;
    String nombreRegla;
    int limiteSuperior;
    int limiteInferior;
    String conclusion;
    //String nombreNutriente;

    /**///
    public NitrogenoRegla() {

    }

    public NitrogenoRegla(int idNitrogenoRegla, String nombreRegla, int limiteSuperior, int limiteInferior, String conclusion) {
        this.idNitrogenoRegla = idNitrogenoRegla;
        this.nombreRegla = nombreRegla;
        this.limiteSuperior = limiteSuperior;
        this.limiteInferior = limiteInferior;
        this.conclusion = conclusion;
    }

    public int getIdNitrogenoRegla() {
        return idNitrogenoRegla;
    }

    public void setIdNitrogenoRegla(int idNitrogenoRegla) {
        this.idNitrogenoRegla = idNitrogenoRegla;
    }

    public String getNombreRegla() {
        return nombreRegla;
    }

    public int getLimiteSuperior() {
        return limiteSuperior;
    }

    public int getLimiteInferior() {
        return limiteInferior;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setNombreRegla(String nombreRegla) {
        this.nombreRegla = nombreRegla;
    }

    public void setLimiteSuperior(int limiteSuperior) {
        this.limiteSuperior = limiteSuperior;
    }

    public void setLimiteInferior(int limiteInferior) {
        this.limiteInferior = limiteInferior;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    @Override
    public String toString() {
        return "NitrogenoRegla{" + "idNitrogenoRegla=" + idNitrogenoRegla + ", nombreRegla=" + nombreRegla + ", limiteSuperior=" + limiteSuperior + ", limiteInferior=" + limiteInferior + ", conclusion=" + conclusion + '}';
    }

}
