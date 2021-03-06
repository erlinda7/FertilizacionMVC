package model;

public class MateriaOrganicaRegla {

    int idMateriaOrganicaRegla;
    String nombreRegla;
    int limiteSuperior;
    int limiteInferior;
    String conclusion;

    public MateriaOrganicaRegla() {

    }

    public MateriaOrganicaRegla(int idMateriaOrganicaRegla, String nombreRegla, int limiteSuperior, int limiteInferior, String conclusion) {
        this.idMateriaOrganicaRegla = idMateriaOrganicaRegla;
        this.nombreRegla = nombreRegla;
        this.limiteSuperior = limiteSuperior;
        this.limiteInferior = limiteInferior;
        this.conclusion = conclusion;
    }

    public int getIdMateriaOrganicaRegla() {
        return idMateriaOrganicaRegla;
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

    public void setIdMateriaOrganicaRegla(int idMateriaOrganicaRegla) {
        this.idMateriaOrganicaRegla = idMateriaOrganicaRegla;
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
        return "MateriaOrganicaRegla{" + "idMateriaOrganicaRegla=" + idMateriaOrganicaRegla + ", nombreRegla=" + nombreRegla + ", limiteSuperior=" + limiteSuperior + ", limiteInferior=" + limiteInferior + ", conclusion=" + conclusion + '}';
    }

}
