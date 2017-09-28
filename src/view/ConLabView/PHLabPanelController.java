/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.ConLabView;

import com.alee.extended.layout.VerticalFlowLayout;
import com.alee.extended.window.WebPopOver;
import com.alee.laf.label.WebLabel;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.text.DefaultFormatter;
import model.Cultivo;

/**
 *
 * @author Erlinda
 */
public class PHLabPanelController {

    PHLabPanel pHLabPanel;
    Cultivo cultivo;
    final WebPopOver popOverpH = new WebPopOver();

    public PHLabPanelController(PHLabPanel pHLabPanel, Cultivo cultivo) {
        this.pHLabPanel = pHLabPanel;
        this.cultivo = cultivo;
        confSpinnerpHLab();
        mostrarExplicacionPH();
        confLabelpH();
        confPopOverpH();

    }

    public void confSpinnerpHLab() {
        JSpinner spinnerpH = this.pHLabPanel.jSpinnerPhLab;
        SpinnerNumberModel modelpH = new SpinnerNumberModel();
        modelpH.setMinimum(3.00);
        modelpH.setMaximum(10.00);
        modelpH.setValue(5.00);
        modelpH.setStepSize(((double) 0.01));
        spinnerpH.setModel(modelpH);
        JSpinner.NumberEditor editorpH = (JSpinner.NumberEditor) spinnerpH.getEditor();
        DecimalFormat formatpH = editorpH.getFormat();
        formatpH.setMinimumFractionDigits(2);
        DefaultFormatter formatter = (DefaultFormatter) editorpH.getTextField().getFormatter();
        formatter.setAllowsInvalid(false);
        editorpH.getTextField().setHorizontalAlignment(SwingConstants.CENTER);
    }

    public void llenarDatosModelo() {
        Double pHSuelo = Double.parseDouble(this.pHLabPanel.jSpinnerPhLab.getValue().toString());
        cultivo.setNivelpH(pHSuelo);
        //System.out.println(pHSuelo);
    }

    public void mostrarExplicacionPH() {
        pHLabPanel.jLabelPreguntaPH.setToolTipText("<html><body><p align='justify'>Ingrese el nivel de pH <br>de los resultados de laboratorio de suelos  para una correcta<br> Recomendación de Fertilización</html></body>");
        pHLabPanel.jLabelPreguntaPH.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jLabelPreguntaPHMouseEntered(evt);
            }
        });
    }

    public void jLabelPreguntaPHMouseEntered(MouseEvent evt) {
        pHLabPanel.jLabelPreguntaPH.getToolTipText();
    }

    ///Inicio popover
    public void confLabelpH() {
        pHLabPanel.jLabelPh.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jlabelpHMouseEntered(evt);
            }
        });
    }

    public void jlabelpHMouseEntered(MouseEvent evt) {
        popOverpH.show(pHLabPanel.jLabelPh, 50, pHLabPanel.jLabelPh.getHeight());
    }

    public void confPopOverpH() {
        popOverpH.setCloseOnFocusLoss(true);
        popOverpH.setMargin(10);
        popOverpH.setLayout(new VerticalFlowLayout());
        popOverpH.add(new WebLabel("Los valores de pH"));
        popOverpH.add(new WebLabel("en un suelo agricola varia"));
        popOverpH.add(new WebLabel(" entre 3.00 y 10.00"));
    }
    //fin Popover
}
