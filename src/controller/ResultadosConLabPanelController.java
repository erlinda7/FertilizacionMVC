/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.itextpdf.text.DocumentException;

//import drools.DroolsMain;
import java.awt.Desktop;
import java.awt.FlowLayout;
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

    ResultadosConLabPanel resultadosConLabPanel;
    String rutaDocumentoPdf;

    public ResultadosConLabPanelController(ResultadosConLabPanel resultadosConLabPanel) {
        this.resultadosConLabPanel = resultadosConLabPanel;

    }

    public void llenarPanelInformacion(Cultivo cultivo, Textura textura) {
        
        //comentar para netbenas
//         DroolsMain.calcularResultados(cultivo, textura);

        //datos introducidos del cultivo
//        resultadosConLabPanel.resultadosContenidoPanel1.resultadosDatosCultivoPanel1.jLabelTituloDatos.setText(cultivo.getHortaliza());
//        resultadosConLabPanel.resultadosContenidoPanel1.resultadosDatosCultivoPanel1.jLabelRendimiento.setText(cultivo.getRendimiento() + "  Ton/ha");
//        resultadosConLabPanel.resultadosContenidoPanel1.resultadosDatosCultivoPanel1.jLabelArena.setText(textura.getTexturaArena() + "  %");
//        resultadosConLabPanel.resultadosContenidoPanel1.resultadosDatosCultivoPanel1.jLabelLimo.setText(textura.getTexturaLimo() + "  %");
//        resultadosConLabPanel.resultadosContenidoPanel1.resultadosDatosCultivoPanel1.jLabelArcilla.setText(textura.getTexturaArcilla() + "  %");
//        resultadosConLabPanel.resultadosContenidoPanel1.resultadosDatosCultivoPanel1.jLabelNitrogeno.setText(cultivo.getNivelNitrogeno() + "  ppm");
//        resultadosConLabPanel.resultadosContenidoPanel1.resultadosDatosCultivoPanel1.jLabelFosforo.setText(cultivo.getNivelFosforo() + "  ppm");
//        resultadosConLabPanel.resultadosContenidoPanel1.resultadosDatosCultivoPanel1.jLabelPotasio.setText(cultivo.getNivelPotasio() + "  ppm");
//        resultadosConLabPanel.resultadosContenidoPanel1.resultadosDatosCultivoPanel1.jLabelpH.setText(cultivo.getNivelpH() + "  ppm");
//        resultadosConLabPanel.resultadosContenidoPanel1.resultadosDatosCultivoPanel1.jLabelMO.setText(cultivo.getNivelMO() + "  ppm");
//Propiedades del suelo
       resultadosConLabPanel.resultadosContenidoPanel1.resultadosRecFertilizacionPanel1.jLabelTituloRecomendacion.setText(cultivo.getHortaliza() + "  (" + cultivo.getRendimiento() + "  Ton/ha )");
//       resultadosConLabPanel.resultadosContenidoPanel1.tipotextura.setText(textura.getTipoTextura() + " ");
//        resultadosConLabPanel.resultadosContenidoPanel1.resultadosExplicacionPanel1.jLabelPropiedadpH.setText(cultivo.getTipoSuelo() + "");
//        resultadosConLabPanel.resultadosContenidoPanel1.resultadosExplicacionPanel1.jLabelPropiedadNitrogeno.setText(cultivo.getRangoNivelNitrogeno() + "");
//        resultadosConLabPanel.resultadosContenidoPanel1.resultadosExplicacionPanel1.jLabelPropiedadFosforo.setText(cultivo.getRangoNivelFosforo() + "");
//        resultadosConLabPanel.resultadosContenidoPanel1.resultadosExplicacionPanel1.jLabelPropiedadPotasio.setText(cultivo.getRangoNivelPotasio() + "");
//        resultadosConLabPanel.resultadosContenidoPanel1.resultadosExplicacionPanel1.jLabelPropiedadMO.setText(cultivo.getRangoNivelMO() + "");
        //mostrarExplicacionRecomendacionFertilizacion(cultivo, textura);
        ///Recomendacion de fertilizacion
        resultadosConLabPanel.resultadosContenidoPanel1.resultadosRecFertilizacionPanel1.jLabelAplicacionFerti.setText("<html><body><p align='justify'>" + cultivo.getFormaAplicar() + "</p></body></html>");
        resultadosConLabPanel.resultadosContenidoPanel1.resultadosRecFertilizacionPanel1.jLabelCantidadNPK.setText("[ " + cultivo.getCantKgN() + " ]" + "  -  " + "[ " + cultivo.getCantKgP() + " ]" + "  -  " + "[ " + cultivo.getCantKgK() + " ]");
        resultadosConLabPanel.resultadosContenidoPanel1.resultadosRecFertilizacionPanel1.jTextPaneRecomendacion.setText(cultivo.getRecomendacionesString());

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
        resultadosConLabPanel.resultadosContenidoPanel1.buttonAbrirPdf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                buttonAbrirPdfActionPerformed(evt);
            }
        });
    }

    public void confButtonImprimir() {
        resultadosConLabPanel.resultadosContenidoPanel1.buttonImprimir.addActionListener(new ActionListener() {
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

    public void mostrarExplicacionRecomendacionFertilizacion(Cultivo cultivo, Textura textura) {

        if (textura.getTipoTextura().equals("arenosa") || textura.getTipoTextura().equals("arenoso franca") || textura.getTipoTextura().equals("franco arenosa") || textura.getTipoTextura().equals("franco arcillo arenosa")) {
            resultadosConLabPanel.resultadosContenidoPanel1.jLabelExplicacionFertiTextura.setText("<html><body><p align='justify'>La textura del suelo es ' " + textura.getTipoTextura() + " ' por lo cual se agrega 10% de nutrientes a la cantidad recomendada de Nitrogeno, Fosforo y Potasio.</body></html>");
        } else {
            resultadosConLabPanel.resultadosContenidoPanel1.jLabelExplicacionFertiTextura.setText("<html><body><p align='justify'>La textura del suelo es ' " + textura.getTipoTextura() + " ' por lo cual NO se agrega 10% de nutrientes a la cantidad recomendada de Nitrogeno, Fosforo y Potasio.</body></html>");
        }

        if (cultivo.getCantKgN() > 0) {
            resultadosConLabPanel.resultadosContenidoPanel1.jLabelExplicacionFertiNitrogeno.setText("<html><body><p align='justify'>El nivel de Nitrogeno en el suelo es  ' " + cultivo.getNivelNitrogeno() + " ' por lo cual se considera que el nivel de nitrogeno en el suelo es ' " + cultivo.getRangoNivelNitrogeno() + " ' y es necesario fertilizar con el nutriente Nitrogeno.</body></html>");
        } else {
            resultadosConLabPanel.resultadosContenidoPanel1.jLabelExplicacionFertiNitrogeno.setText("<html><body><p align='justify'>El nivel de Nitrogeno en el suelo es  ' " + cultivo.getNivelNitrogeno() + " ' por lo cual se considera que el nivel de nitrogeno en el suelo es ' " + cultivo.getRangoNivelNitrogeno() + " ' y NO es necesario fertilizar con el nutriente Nitrogeno.</body></html>");
        }

        if (cultivo.getCantKgP() > 0) {
            resultadosConLabPanel.resultadosContenidoPanel1.jLabelExplicacionFertiFosforo.setText("<html><body><p align='justify'>El nivel de Fosforo en el suelo es  ' " + cultivo.getNivelFosforo() + " ' por lo cual se considera que el nivel de fosforo en el suelo es ' " + cultivo.getRangoNivelFosforo() + " ' y es necesario fertilizar con el nutriente Fosforo.</body></html>");
        } else {
            resultadosConLabPanel.resultadosContenidoPanel1.jLabelExplicacionFertiFosforo.setText("<html><body><p align='justify'>El nivel de Fosforo en el suelo es  ' " + cultivo.getNivelFosforo() + " ' por lo cual se considera que el nivel de fosforo en el suelo es ' " + cultivo.getRangoNivelFosforo() + " ' y NO es necesario fertilizar con el nutriente Fosforo.</body></html>");
        }

        if (cultivo.getCantKgP() > 0) {
            resultadosConLabPanel.resultadosContenidoPanel1.jLabelExplicacionFertiPotasio.setText("<html><body><p align='justify'>El nivel de Potasio en el suelo es  ' " + cultivo.getNivelPotasio() + " ' por lo cual se considera que el nivel de fosforo en el suelo es ' " + cultivo.getRangoNivelPotasio() + " ' y es necesario fertilizar con el nutriente Potasio.</body></html>");
        } else {
            resultadosConLabPanel.resultadosContenidoPanel1.jLabelExplicacionFertiPotasio.setText("<html><body><p align='justify'>El nivel de Potasio en el suelo es  ' " + cultivo.getNivelPotasio() + " ' por lo cual se considera que el nivel de fosforo en el suelo es ' " + cultivo.getRangoNivelPotasio() + " ' y NO es necesario fertilizar con el nutriente Potasio.</body></html>");
        }
    }
}
