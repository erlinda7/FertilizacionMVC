package model;

public class MateriaOrganicaRegla {
	int idMoRegla;
    String nombreReglaMO;
    int limiteSuperiorMO;
    int limiteInferiorMO;
    String conclusionMO;
    
    public MateriaOrganicaRegla(){
    	
    }

	public MateriaOrganicaRegla(int idNutrienteReglaMO, String nombreReglaMO, int limiteSuperiorMO,
			int limiteInferiorMO, String conclusionMO) {
		super();
		this.idMoRegla = idNutrienteReglaMO;
		this.nombreReglaMO = nombreReglaMO;
		this.limiteSuperiorMO = limiteSuperiorMO;
		this.limiteInferiorMO = limiteInferiorMO;
		this.conclusionMO = conclusionMO;
	}

	

	public int getIdMoRegla() {
		return idMoRegla;
	}

	public void setIdMoRegla(int idMoRegla) {
		this.idMoRegla = idMoRegla;
	}

	public String getNombreReglaMO() {
		return nombreReglaMO;
	}

	public void setNombreReglaMO(String nombreReglaMO) {
		this.nombreReglaMO = nombreReglaMO;
	}

	public int getLimiteSuperiorMO() {
		return limiteSuperiorMO;
	}

	public void setLimiteSuperiorMO(int limiteSuperiorMO) {
		this.limiteSuperiorMO = limiteSuperiorMO;
	}

	public int getLimiteInferiorMO() {
		return limiteInferiorMO;
	}

	public void setLimiteInferiorMO(int limiteInferiorMO) {
		this.limiteInferiorMO = limiteInferiorMO;
	}

	public String getConclusionMO() {
		return conclusionMO;
	}

	public void setConclusionMO(String conclusionMO) {
		this.conclusionMO = conclusionMO;
	}

	@Override
	public String toString() {
		return "MateriaOrganicaRegla [idNutrienteReglaMO=" + idMoRegla + ", nombreReglaMO=" + nombreReglaMO
				+ ", limiteSuperiorMO=" + limiteSuperiorMO + ", limiteInferiorMO=" + limiteInferiorMO
				+ ", conclusionMO=" + conclusionMO + "]";
	}

    
    
}
