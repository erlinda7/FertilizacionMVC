package model;

public enum Fertilizante {
	UREA("  Kg/ha Urea",46,0,0),
	NITRATO_DE_AMONIO("  Kg/ha Nitrato de Amonio",33,0,0),
	SUPERFOSFATO_TRIPLE("  Kg/ha Superfosfato Triple",0,46,0),
	DI_FOSFATO_DE_AMONIO("  Kg/ha Di Fosfato de Amonio",18,46,0),
	TRIPLE_15("  Kg/ha '15-15-15",15,15,15),
	TRIPLE_20("  Kg/ha '20-20-20",20,20,20),
	CLORURO_DE_POTASIO("  Kg/ha Cloruro de Potasio",0,0,60),
	SULFATO_DE_POTASIO("  Kg/ha Sulfato de Potasio",0,0,50),
	NITRATO_DE_POTASIO("  Kg/ha Nitrato de Potasio",13,0,44);
	private String nombreFertilizante;
	private int formulaN;
	private int formulaP;
	private int formulaK;
	private Fertilizante(String nombreFertilizante,int formulaN, int formulaP,int formulaK){
		this.formulaN = formulaN;
		this.formulaP = formulaP;
		this.formulaK = formulaK;
		this.nombreFertilizante = nombreFertilizante;
	}

	public String getNombreFertilizante(){
		return nombreFertilizante;
	}
	
	public int getFormulaN() {
		return formulaN;
	}

	public int getFormulaP() {
		return formulaP;
	}

	public int getFormulaK() {
		return formulaK;
	}
}
