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
public class NutrienteRegla {
    int idNutrienteRegla;
    String nombreRegla;
    int limiteSuperior;
    int limiteInferior;
    String conclusion;
    String nombreNutriente;
    
    /**///
    public NutrienteRegla(){
    
    }
    
    
    public NutrienteRegla(int idNutrienteRegla, String nombreRegla, int limiteSuperior, int limiteInferior, String conclusion, String nombreNutriente) {
        this.idNutrienteRegla = idNutrienteRegla;
        this.nombreRegla = nombreRegla;
        this.limiteSuperior = limiteSuperior;
        this.limiteInferior = limiteInferior;
        this.conclusion = conclusion;
        this.nombreNutriente = nombreNutriente;
    }

    public int getIdNutrienteRegla() {
        return idNutrienteRegla;
    }

    public void setIdNutrienteRegla(int idNutrienteRegla) {
        this.idNutrienteRegla = idNutrienteRegla;
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

    public String getNombreNutriente() {
        return nombreNutriente;
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

    public void setNombreNutriente(String nombreNutriente) {
        this.nombreNutriente = nombreNutriente;
    }

    @Override
    public String toString() {
        return "NutrienteRegla{" + "idNutrienteRegla=" + idNutrienteRegla + ", nombreRegla=" + nombreRegla + ", limiteSuperior=" + limiteSuperior + ", limiteInferior=" + limiteInferior + ", conclusion=" + conclusion + ", nombreNutriente=" + nombreNutriente + '}';
    }

    
    
    
}
