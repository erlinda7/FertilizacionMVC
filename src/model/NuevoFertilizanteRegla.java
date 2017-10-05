package model;

public class NuevoFertilizanteRegla {
	int idNuevoFertilizante;
	int formulaN;
	int formulaP;
	int formulaK;
	
	public NuevoFertilizanteRegla(){
		
	}
	
	public NuevoFertilizanteRegla(int idNuevoFertilizante, int formulaN, int formulaP, int formulaK) {
		super();
		this.idNuevoFertilizante = idNuevoFertilizante;
		this.formulaN = formulaN;
		this.formulaP = formulaP;
		this.formulaK = formulaK;
	}
	String nombreRegla;

	public int getIdNuevoFertilizante() {
		return idNuevoFertilizante;
	}

	public void setIdNuevoFertilizante(int idNuevoFertilizante) {
		this.idNuevoFertilizante = idNuevoFertilizante;
	}

	public int getFormulaN() {
		return formulaN;
	}

	public void setFormulaN(int formulaN) {
		this.formulaN = formulaN;
	}

	public int getFormulaP() {
		return formulaP;
	}

	public void setFormulaP(int formulaP) {
		this.formulaP = formulaP;
	}

	public int getFormulaK() {
		return formulaK;
	}

	public void setFormulaK(int formulaK) {
		this.formulaK = formulaK;
	}

	public String getNombreRegla() {
		return nombreRegla;
	}

	public void setNombreRegla(String nombreRegla) {
		this.nombreRegla = nombreRegla;
	}
	
	
	
	
	
}
