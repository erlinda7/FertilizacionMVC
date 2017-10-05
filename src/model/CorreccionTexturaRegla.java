package model;

public class CorreccionTexturaRegla {

	int idCorreccionTextura;
	String nombreRegla;
	String texturaACorregir;
	int porcentajeACorregir;

	public CorreccionTexturaRegla() {

	}

	public CorreccionTexturaRegla(int idCorreccionTextura, String nombreRegla, String texturaACorregir,
			int porcentajeACorregir) {
		super();
		this.idCorreccionTextura = idCorreccionTextura;
		this.nombreRegla = nombreRegla;
		this.texturaACorregir = texturaACorregir;
		this.porcentajeACorregir = porcentajeACorregir;
	}

	public int getIdCorreccionTextura() {
		return idCorreccionTextura;
	}

	public void setIdCorreccionTextura(int idCorreccionTextura) {
		this.idCorreccionTextura = idCorreccionTextura;
	}

	public String getNombreRegla() {
		return nombreRegla;
	}

	public void setNombreRegla(String nombreRegla) {
		this.nombreRegla = nombreRegla;
	}

	public String getTexturaACorregir() {
		return texturaACorregir;
	}

	public void setTexturaACorregir(String texturaACorregir) {
		this.texturaACorregir = texturaACorregir;
	}

	public int getPorcentajeACorregir() {
		return porcentajeACorregir;
	}

	public void setPorcentajeACorregir(int porcentajeACorregir) {
		this.porcentajeACorregir = porcentajeACorregir;
	}

}
