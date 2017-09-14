package controller;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import model.Cultivo;
import model.Recomendacion;
import model.Textura;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class PdfCultivo {

    private String ruta;
    private Document documento;
    private Cultivo cultivo;
    private Textura textura;

    public PdfCultivo(String ruta, Cultivo cultivo, Textura textura) {
        this.cultivo = cultivo;
        this.ruta = ruta;
        this.textura = textura;
    }

    public void generarPdf() throws FileNotFoundException, DocumentException {
        float left = 90;
        float right = 50;
        float top = 50;
        float bottom = 50;
        documento = new Document(PageSize.LETTER, left, right, top, bottom);
        PdfWriter.getInstance(documento, new FileOutputStream(ruta));
        documento.open();
        Font myfuenteTitulo = new Font(FontFamily.TIMES_ROMAN, 16, Font.NORMAL, new BaseColor(0, 0, 255));
        Font myfuenteSubtitulos = new Font(FontFamily.HELVETICA, 12, Font.NORMAL, new BaseColor(0, 0, 0));
        Font myfuenteContenido = new Font(FontFamily.HELVETICA, 11, Font.NORMAL, new BaseColor(0, 0, 0));
        Font myfuenteSubtitulos2 = new Font(FontFamily.HELVETICA, 12, Font.BOLD, new BaseColor(0, 0, 0));
        Font myfuenteNota = new Font(FontFamily.HELVETICA, 8, Font.NORMAL, new BaseColor(0, 0, 0));

        Paragraph parrafoTituloDat = new Paragraph("Datos indroducidos de: " + cultivo.getHortaliza(), myfuenteTitulo);
        parrafoTituloDat.setAlignment(Paragraph.ALIGN_CENTER);
        parrafoTituloDat.setSpacingAfter(20f);
        documento.add(parrafoTituloDat);

        Paragraph parrafoRendimiento = new Paragraph("Rendimiento  :    " + cultivo.getRendimiento() + "   Ton/ha", myfuenteSubtitulos);
        parrafoRendimiento.setSpacingAfter(5f);
        documento.add(parrafoRendimiento);

        Paragraph parrafoTexturaSuelo = new Paragraph("Textura del Suelo :    ", myfuenteSubtitulos);
        documento.add(parrafoTexturaSuelo);
        Paragraph parrafoTexturaArena = new Paragraph("Arena  :    " + textura.getTexturaArena() + "  %", myfuenteContenido);
        parrafoTexturaArena.setIndentationLeft(40f);
        documento.add(parrafoTexturaArena);
        Paragraph parrafoTexturaLimo = new Paragraph("Limo    :    " + textura.getTexturaLimo() + "  %", myfuenteContenido);
        parrafoTexturaLimo.setIndentationLeft(40f);
        documento.add(parrafoTexturaLimo);
        Paragraph parrafoTexturaArcilla = new Paragraph("Arcilla  :    " + textura.getTexturaArcilla() + "  %", myfuenteContenido);
        parrafoTexturaArcilla.setIndentationLeft(40f);
        parrafoTexturaArcilla.setSpacingAfter(5f);
        documento.add(parrafoTexturaArcilla);

        Paragraph parrafoNutrientes = new Paragraph("Nutrientes del Suelo  :    ", myfuenteSubtitulos);
        documento.add(parrafoNutrientes);
        Paragraph parrafoNNitrogeno = new Paragraph("Nitrogeno :     " + cultivo.getNivelNitrogeno() + "     ppm", myfuenteContenido);
        parrafoNNitrogeno.setIndentationLeft(40f);
        documento.add(parrafoNNitrogeno);
        Paragraph parrafoNFosforo = new Paragraph("F�sforo    :     " + cultivo.getNivelFosforo() + "     ppm", myfuenteContenido);
        parrafoNFosforo.setIndentationLeft(40f);
        documento.add(parrafoNFosforo);
        Paragraph parrafoNPotasio = new Paragraph("Potasio    :     " + cultivo.getNivelPotasio() + "   ppm", myfuenteContenido);
        parrafoNPotasio.setIndentationLeft(40f);
        parrafoNPotasio.setSpacingAfter(5f);
        documento.add(parrafoNPotasio);

        Paragraph parrafoPH = new Paragraph("Nivel de pH en el suelo  :    " + cultivo.getNivelpH(), myfuenteSubtitulos);
        parrafoPH.setSpacingAfter(5f);
        documento.add(parrafoPH);

        Paragraph parrafoMO = new Paragraph("Nivel de materia org�nica en el suelo  :     " + cultivo.getNivelMO(), myfuenteSubtitulos);
        documento.add(parrafoMO);

        Paragraph parrafoTituloRec = new Paragraph("Recomendacion de Fertilizaci�n :     " + cultivo.getHortaliza() + "  ( " + cultivo.getRendimiento() + "  Ton/ha )", myfuenteTitulo);
        parrafoTituloRec.setAlignment(Paragraph.ALIGN_CENTER);
        parrafoTituloRec.setSpacingBefore(30f);
        parrafoTituloRec.setSpacingAfter(10f);
        documento.add(parrafoTituloRec);

        Paragraph parrafoPropiedadesSuelo = new Paragraph("Propiedades del Suelo :", myfuenteSubtitulos2);
        documento.add(parrafoPropiedadesSuelo);
        Paragraph parrafoPTextura = new Paragraph("Textura                 :    " + textura.getTipoTextura(), myfuenteContenido);
        parrafoPTextura.setIndentationLeft(40f);
        documento.add(parrafoPTextura);
        Paragraph parrafoPpH = new Paragraph("pH                         :     " + cultivo.getTipoSuelo(), myfuenteContenido);
        parrafoPpH.setIndentationLeft(40f);
        documento.add(parrafoPpH);
        Paragraph parrafoPNitrogeno = new Paragraph("Nitrogeno              :    " + cultivo.getRangoNivelNitrogeno(), myfuenteContenido);
        parrafoPNitrogeno.setIndentationLeft(40f);
        documento.add(parrafoPNitrogeno);
        Paragraph parrafoPFosforo = new Paragraph("F�sforo                 :    " + cultivo.getRangoNivelFosforo(), myfuenteContenido);
        parrafoPFosforo.setIndentationLeft(40f);
        documento.add(parrafoPFosforo);
        Paragraph parrafoPPotasio = new Paragraph("Potasio                 :    " + cultivo.getRangoNivelPotasio(), myfuenteContenido);
        parrafoPPotasio.setIndentationLeft(40f);
        documento.add(parrafoPPotasio);
        Paragraph parrafoPMO = new Paragraph("Materia Org�nica :    " + cultivo.getRangoNivelMO(), myfuenteContenido);
        parrafoPMO.setIndentationLeft(40f);
        parrafoPMO.setSpacingAfter(5f);
        documento.add(parrafoPMO);

        Paragraph parrafoTituloAplicacionFertlizantes = new Paragraph("Aplicaci�n de los Fertilizantes :", myfuenteSubtitulos2);
        documento.add(parrafoTituloAplicacionFertlizantes);
        Paragraph parrafoAplicacionFertilizantes = new Paragraph(cultivo.getFormaAplicar(), myfuenteContenido);
        parrafoAplicacionFertilizantes.setAlignment(Paragraph.ALIGN_JUSTIFIED);
        parrafoAplicacionFertilizantes.setSpacingAfter(10f);
        documento.add(parrafoAplicacionFertilizantes);

        Paragraph parrafoCantRecomendada = new Paragraph("Cantidad Recomendada (Kg/ha)  N - P - K :      " + "[ " + cultivo.getCantKgN() + " ]" + "  -  " + "[ " + cultivo.getCantKgP() + " ]" + "  -  " + "[ " + cultivo.getCantKgK() + " ]", myfuenteSubtitulos2);
        documento.add(parrafoCantRecomendada);
        Paragraph parrafoNota = new Paragraph("Nota: En la 'Cantidad Recomendada' El numero negativo expresa exceso, por lo tanto no se requiere fertilizar con ese Nutriente (N,P,K).", myfuenteNota);
        parrafoNota.setAlignment(Paragraph.ALIGN_JUSTIFIED);
        parrafoNota.setSpacingAfter(5f);
        documento.add(parrafoNota);

        Paragraph parrafoRecomendacion = new Paragraph("Recomendaciones :", myfuenteSubtitulos2);
        documento.add(parrafoRecomendacion);
        ArrayList<Recomendacion> recomendaciones = cultivo.getRecomendaciones();
        for (int i = 0; i < recomendaciones.size(); i++) {
            Paragraph numRecomendacion = new Paragraph("Recomendacion " + (i + 1) + " :", myfuenteSubtitulos2);
            numRecomendacion.setIndentationLeft(40);
            numRecomendacion.setSpacingBefore(10f);
            documento.add(numRecomendacion);

            ArrayList<String> fertilizanteN = recomendaciones.get(i).getFertilizanteN();
            Paragraph parrafoFertilizanteN = new Paragraph("Fertilizantes nitrogenados : ", myfuenteSubtitulos2);
            parrafoFertilizanteN.setIndentationLeft(70);
            documento.add(parrafoFertilizanteN);
            for (int j = 0; j < fertilizanteN.size(); j++) {
                Paragraph paragraphOpcionN = new Paragraph("Opcion " + (j + 1) + "    :   " + fertilizanteN.get(j));
                paragraphOpcionN.setIndentationLeft(120);
                documento.add(paragraphOpcionN);
            }

            ArrayList<String> fertilizanteP = recomendaciones.get(i).getFertilizanteP();
            Paragraph parrafoFertilizanteP = new Paragraph("Fertilizantes fosfatados : ", myfuenteSubtitulos2);
            parrafoFertilizanteP.setIndentationLeft(70);
            documento.add(parrafoFertilizanteP);
            for (int j = 0; j < fertilizanteP.size(); j++) {
                Paragraph paragraphOpcionP = new Paragraph("Opcion " + (j + 1) + "   :    " + fertilizanteP.get(j));
                paragraphOpcionP.setIndentationLeft(120);
                documento.add(paragraphOpcionP);
            }

            ArrayList<String> fertilizanteK = recomendaciones.get(i).getFertilizanteK();
            Paragraph parrafoFertilizanteK = new Paragraph("Fertilizantes potasicos : ", myfuenteSubtitulos2);
            parrafoFertilizanteK.setIndentationLeft(70);
            documento.add(parrafoFertilizanteK);
            for (int j = 0; j < fertilizanteK.size(); j++) {
                Paragraph paragraphOpcionK = new Paragraph("Opcion " + (j + 1) + "   :   " + fertilizanteK.get(j));
                paragraphOpcionK.setIndentationLeft(120);
                documento.add(paragraphOpcionK);
            }
        }

        documento.close();
    }
}
