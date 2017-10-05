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
public class PotasioRegla {
    int idPotasioRegla;
    String nombreRegla;
    int limiteSuperior;
    int limiteInferior;
    String conclusion;
    
    public PotasioRegla(){
    
    }

    public PotasioRegla(int idPotasioRegla, String nombreRegla, int limiteSuperior, int limiteInferior, String conclusion) {
        this.idPotasioRegla = idPotasioRegla;
        this.nombreRegla = nombreRegla;
        this.limiteSuperior = limiteSuperior;
        this.limiteInferior = limiteInferior;
        this.conclusion = conclusion;
    }

    public int getIdPotasioRegla() {
        return idPotasioRegla;
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

    public void setIdPotasioRegla(int idPotasioRegla) {
        this.idPotasioRegla = idPotasioRegla;
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
    
    
}
