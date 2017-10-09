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

    public String getNombreRegla() {
        return nombreRegla;
    }

    public String getTexturaACorregir() {
        return texturaACorregir;
    }

    public int getConclusionPorcACorregir() {
        return ConclusionPorcACorregir;
    }

    public void setIdCorreccionTextura(int idCorreccionTextura) {
        this.idCorreccionTextura = idCorreccionTextura;
    }

    public void setNombreRegla(String nombreRegla) {
        this.nombreRegla = nombreRegla;
    }

    public void setTexturaACorregir(String texturaACorregir) {
        this.texturaACorregir = texturaACorregir;
    }

    public void setConclusionPorcACorregir(int ConclusionPorcACorregir) {
        this.ConclusionPorcACorregir = ConclusionPorcACorregir;
    }


}
