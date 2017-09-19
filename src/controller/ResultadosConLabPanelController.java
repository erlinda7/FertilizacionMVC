/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.itextpdf.text.DocumentException;

//import drools.DroolsMain;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cultivo;
import model.Textura;
import view.ResultadosConLabPanel;

/**
 *
 * @author Erlinda
 */
public class ResultadosConLabPanelController {

    ResultadosConLabPanel jPResultados;
    String rutaDocumentoPdf;

    public ResultadosConLabPanelController(ResultadosConLabPanel jPResultados) {
        this.jPResultados = jPResultados;

    }

    public void llenarPanelInformacion(Cultivo cultivo, Textura textura) {
        //comentar para netbenas
//         DroolsMain.calcularResultados(cultivo, textura);

        jPResultados.resultadosDatosCultivoPanel1.jLabelTituloDatos.setText(cultivo.getHortaliza());
        jPResultados.resultadosDatosCultivoPanel1.jLabelRendimiento.setText(cultivo.getRendimiento() + "  Ton/ha");
        jPResultados.resultadosDatosCultivoPanel1.jLabelArena.setText(textura.getTexturaArena() + "  %");
        jPResultados.resultadosDatosCultivoPanel1.jLabelLimo.setText(textura.getTexturaLimo() + "  %");
        jPResultados.resultadosDatosCultivoPanel1.jLabelArcilla.setText(textura.getTexturaArcilla() + "  %");
        jPResultados.resultadosDatosCultivoPanel1.jLabelNitrogeno.setText(cultivo.getNivelNitrogeno() + "  ppm");
        jPResultados.resultadosDatosCultivoPanel1.jLabelFosforo.setText(cultivo.getNivelFosforo() + "  ppm");
        jPResultados.resultadosDatosCultivoPanel1.jLabelPotasio.setText(cultivo.getNivelPotasio() + "  ppm");
        jPResultados.resultadosDatosCultivoPanel1.jLabelpH.setText(cultivo.getNivelpH() + "  ppm");
        jPResultados.resultadosDatosCultivoPanel1.jLabelMO.setText(cultivo.getNivelMO() + "  ppm");
//
        jPResultados.resultadosRecFertilizacionPanel1.jLabelTituloRecomendacion.setText(cultivo.getHortaliza() + "  (" + cultivo.getRendimiento() + "  Ton/ha )");
        jPResultados.resultadosExplicacionPanel1.jLabelPropiedadTextura.setText(textura.getTipoTextura() + " ");
        jPResultados.resultadosExplicacionPanel1.jLabelPropiedadpH.setText(cultivo.getTipoSuelo() + "");
        jPResultados.resultadosExplicacionPanel1.jLabelPropiedadNitrogeno.setText(cultivo.getRangoNivelNitrogeno() + "");
        jPResultados.resultadosExplicacionPanel1.jLabelPropiedadFosforo.setText(cultivo.getRangoNivelFosforo() + "");
        jPResultados.resultadosExplicacionPanel1.jLabelPropiedadPotasio.setText(cultivo.getRangoNivelPotasio() + "");
        jPResultados.resultadosExplicacionPanel1.jLabelPropiedadMO.setText(cultivo.getRangoNivelMO() + "");
        jPResultados.resultadosRecFertilizacionPanel1.jLabelAplicacionFerti.setText("<html><body><p align='justify'>" + cultivo.getFormaAplicar() + "</p></body></html>");
        jPResultados.resultadosRecFertilizacionPanel1.jLabelCantidadNPK.setText("[ " + cultivo.getCantKgN() + " ]" + "  -  " + "[ " + cultivo.getCantKgP() + " ]" + "  -  " + "[ " + cultivo.getCantKgK() + " ]");
        jPResultados.resultadosRecFertilizacionPanel1.jTextPaneRecomendacion.setText(cultivo.getRecomendacionesString());

        generarResultadoPdf(cultivo, textura);
        confButtonAbrirPdf();
        confButtonImprimir();
    }

    public void generarResultadoPdf(Cultivo cultivo, Textura textura) {
        Date fechaActual = new Date();
        SimpleDateFormat fecha = new SimpleDateFormat("dd-MM-yy");
        SimpleDateFormat hora = new SimpleDateFormat("HH.mm.ss");
        String nombreArchivo = cultivo.getHortaliza() + " " + fecha.format(fechaActual) + " " + hora.format(fechaActual);
        String ruta = "C:\\Users\\Public\\Documents\\" + nombreArchivo + ".pdf";
        rutaDocumentoPdf = ruta;
        PdfCultivo resultadoPdf = new PdfCultivo(ruta, cultivo, textura);

        try {
            resultadoPdf.generarPdf();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void confButtonAbrirPdf() {
        jPResultados.buttonAbrirPdf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                buttonAbrirPdfActionPerformed(evt);
            }
        });
    }

    public void confButtonImprimir() {
        jPResultados.buttonImprimir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                buttonImprimirActionPerformed(evt);
            }
        });
    }

    private void buttonAbrirPdfActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            File path;
            path = new File(rutaDocumentoPdf);
            Desktop.getDesktop().open(path);
        } catch (IOException ex) {
            Logger.getLogger(PdfCultivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void buttonImprimirActionPerformed(java.awt.event.ActionEvent evt) {
        ImprimirResultados.imprimir(rutaDocumentoPdf);
    }
}
