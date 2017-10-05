package model;

public class FormaAplicarFertilizanteRegla {
	int idFormaAplicFertilizante;
	String nombreRegla;
	String hortalizaAFertilizar;
	String conclusion;
	
	public FormaAplicarFertilizanteRegla(){
		
	}

	public FormaAplicarFertilizanteRegla(int idFormaAplicFertilizante, String nombreRegla, String hortalizaAFertilizar,
			String conclusion) {
		super();
		this.idFormaAplicFertilizante = idFormaAplicFertilizante;
		this.nombreRegla = nombreRegla;
		this.hortalizaAFertilizar = hortalizaAFertilizar;
		this.conclusion = conclusion;
	}

	public int getIdFormaAplicFertilizante() {
		return idFormaAplicFertilizante;
	}

	public void setIdFormaAplicFertilizante(int idFormaAplicFertilizante) {
		this.idFormaAplicFertilizante = idFormaAplicFertilizante;
	}

	public String getNombreRegla() {
		return nombreRegla;
	}

	public void setNombreRegla(String nombreRegla) {
		this.nombreRegla = nombreRegla;
	}

	public String getHortalizaAFertilizar() {
		return hortalizaAFertilizar;
	}

	public void setHortalizaAFertilizar(String hortalizaAFertilizar) {
		this.hortalizaAFertilizar = hortalizaAFertilizar;
	}

	public String getConclusion() {
		return conclusion;
	}

	public void setConclusion(String conclusion) {
		this.conclusion = conclusion;
	}
	
	
}
