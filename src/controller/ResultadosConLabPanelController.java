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

        jPResultados.jLabelTituloDatos.setText(cultivo.getHortaliza());
        jPResultados.jLabelRendimiento.setText(cultivo.getRendimiento() + "  Ton/ha");
        jPResultados.jLabelArena.setText(textura.getTexturaArena() + "  %");
        jPResultados.jLabelLimo.setText(textura.getTexturaLimo() + "  %");
        jPResultados.jLabelArcilla.setText(textura.getTexturaArcilla() + "  %");
        jPResultados.jLabelNitrogeno.setText(cultivo.getNivelNitrogeno() + "  ppm");
        jPResultados.jLabelFosforo.setText(cultivo.getNivelFosforo() + "  ppm");
        jPResultados.jLabelPotasio.setText(cultivo.getNivelPotasio() + "  ppm");
        jPResultados.jLabelpH.setText(cultivo.getNivelpH() + "  ppm");
        jPResultados.jLabelMO.setText(cultivo.getNivelMO() + "  ppm");

        jPResultados.jLabelTituloRecomendacion.setText(cultivo.getHortaliza() + "  (" + cultivo.getRendimiento() + "  Ton/ha )");
        jPResultados.jLabelPropiedadTextura.setText(textura.getTipoTextura() + " ");
        jPResultados.jLabelPropiedadpH.setText(cultivo.getTipoSuelo() + "");
        jPResultados.jLabelPropiedadNitrogeno.setText(cultivo.getRangoNivelNitrogeno() + "");
        jPResultados.jLabelPropiedadFosforo.setText(cultivo.getRangoNivelFosforo() + "");
        jPResultados.jLabelPropiedadPotasio.setText(cultivo.getRangoNivelPotasio() + "");
        jPResultados.jLabelPropiedadMO.setText(cultivo.getRangoNivelMO() + "");
        jPResultados.jLabelAplicacionFertilizantes.setText(cultivo.getFormaAplicar() + "");
        jPResultados.jLabelCantidadNPK.setText("[ " + cultivo.getCantKgN() + " ]" + "  -  " + "[ " + cultivo.getCantKgP() + " ]" + "  -  " + "[ " + cultivo.getCantKgK() + " ]");

        jPResultados.jTextPaneRecomendacion.setText(cultivo.getRecomendacionesString());

        generarResultadoPdf(cultivo, textura);

        // this.jFResultados.setVisible(true);
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
