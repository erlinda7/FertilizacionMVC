package model;

public class PhRegla {
	int idPhRegla;
    String nombreReglaPh;
    int limiteSuperiorPh;
    int limiteInferiorPh;
    String conclusionPh;

    
    public PhRegla(){
    	
    }

	public PhRegla(int idNutrienteReglaPh, String nombreReglaPh, int limiteSuperiorPh, int limiteInferiorPh,
			String conclusionPh) {
		super();
		this.idPhRegla = idNutrienteReglaPh;
		this.nombreReglaPh = nombreReglaPh;
		this.limiteSuperiorPh = limiteSuperiorPh;
		this.limiteInferiorPh = limiteInferiorPh;
		this.conclusionPh = conclusionPh;
	
	}

	

	public int getIdPhRegla() {
		return idPhRegla;
	}

	public void setIdPhRegla(int idPhRegla) {
		this.idPhRegla = idPhRegla;
	}

	public String getNombreReglaPh() {
		return nombreReglaPh;
	}

	public void setNombreReglaPh(String nombreReglaPh) {
		this.nombreReglaPh = nombreReglaPh;
	}

	public int getLimiteSuperiorPh() {
		return limiteSuperiorPh;
	}

	public void setLimiteSuperiorPh(int limiteSuperiorPh) {
		this.limiteSuperiorPh = limiteSuperiorPh;
	}

	public int getLimiteInferiorPh() {
		return limiteInferiorPh;
	}

	public void setLimiteInferiorPh(int limiteInferiorPh) {
		this.limiteInferiorPh = limiteInferiorPh;
	}

	public String getConclusionPh() {
		return conclusionPh;
	}

	public void setConclusionPh(String conclusionPh) {
		this.conclusionPh = conclusionPh;
	}    
}
