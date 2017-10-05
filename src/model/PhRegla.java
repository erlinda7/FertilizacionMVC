package model;

public class PhRegla {

    int idPhRegla;
    String nombreRegla;
    int limiteSuperior;
    int limiteInferior;
    String conclusion;

    public PhRegla() {

    }

    public PhRegla(int idPhRegla, String nombreRegla, int limiteSuperior, int limiteInferior, String conclusion) {
        this.idPhRegla = idPhRegla;
        this.nombreRegla = nombreRegla;
        this.limiteSuperior = limiteSuperior;
        this.limiteInferior = limiteInferior;
        this.conclusion = conclusion;
    }

    public int getIdPhRegla() {
        return idPhRegla;
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

    public void setIdPhRegla(int idPhRegla) {
        this.idPhRegla = idPhRegla;
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
        return "PhRegla{" + "idPhRegla=" + idPhRegla + ", nombreRegla=" + nombreRegla + ", limiteSuperior=" + limiteSuperior + ", limiteInferior=" + limiteInferior + ", conclusion=" + conclusion + '}';
    }

}
