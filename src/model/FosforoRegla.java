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
public class FosforoRegla {

    int idFosforoRegla;
    String nombreRegla;
    int limiteSuperior;
    int limiteInferior;
    String conclusion;
    
    public FosforoRegla(){
    
    }

    public FosforoRegla(int idFosforoRegla, String nombreRegla, int limiteSuperior, int limiteInferior, String conclusion) {
        this.idFosforoRegla = idFosforoRegla;
        this.nombreRegla = nombreRegla;
        this.limiteSuperior = limiteSuperior;
        this.limiteInferior = limiteInferior;
        this.conclusion = conclusion;
    }

    public int getIdFosforoRegla() {
        return idFosforoRegla;
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

    public void setIdFosforoRegla(int idFosforoRegla) {
        this.idFosforoRegla = idFosforoRegla;
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
        return "FosforoRegla{" + "idFosforoRegla=" + idFosforoRegla + ", nombreRegla=" + nombreRegla + ", limiteSuperior=" + limiteSuperior + ", limiteInferior=" + limiteInferior + ", conclusion=" + conclusion + '}';
    }
    
    
}
