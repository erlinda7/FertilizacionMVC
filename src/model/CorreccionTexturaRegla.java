package model;

public class CorreccionTexturaRegla {

    int idCorreccionTextura;
    String nombreRegla;
    String texturaACorregir;
    int ConclusionPorcACorregir;

    public CorreccionTexturaRegla() {

    }

    public CorreccionTexturaRegla(int idCorreccionTextura, String nombreRegla, String texturaACorregir,
            int ConclusionPorcACorregir) {
        super();
        this.idCorreccionTextura = idCorreccionTextura;
        this.nombreRegla = nombreRegla;
        this.texturaACorregir = texturaACorregir;
        this.ConclusionPorcACorregir = ConclusionPorcACorregir;
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

    public void setConclusionPorcACorregir(String texturaACorregir) {
        this.texturaACorregir = texturaACorregir;
    }

    public int getConclusionPorcACorregir() {
        return ConclusionPorcACorregir;
    }

    public void setPorcentajeACorregir(int porcentajeACorregir) {
        this.ConclusionPorcACorregir = porcentajeACorregir;
    }

}
