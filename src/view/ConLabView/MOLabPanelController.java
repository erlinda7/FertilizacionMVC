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
public class MOLabPanelController {

    MOLabPanel mopLabPanel;
    Cultivo cultivo;
       final WebPopOver popOverMO = new WebPopOver();

    public MOLabPanelController(MOLabPanel mopLabPanel, Cultivo cultivo) {
        this.mopLabPanel = mopLabPanel;
        this.cultivo = cultivo;
        confSpinnerMOLab();
        mostrarExplicacionMO();
        confLabelMO();
        confPopOverMO();
    }

    public void confSpinnerMOLab() {
        JSpinner spinnerMO = this.mopLabPanel.jSpinnerMOlab;
        SpinnerNumberModel modelMO = new SpinnerNumberModel();
        modelMO.setMinimum(0.00);
        modelMO.setMaximum(10.00);
        modelMO.setValue(5.00);
        modelMO.setStepSize(((double) 0.01));
        spinnerMO.setModel(modelMO);
        JSpinner.NumberEditor editorMO = (JSpinner.NumberEditor) spinnerMO.getEditor();
        DecimalFormat format = editorMO.getFormat();
        format.setMinimumFractionDigits(2);
        DefaultFormatter formatter = (DefaultFormatter) editorMO.getTextField().getFormatter();
        formatter.setAllowsInvalid(false);
        editorMO.getTextField().setHorizontalAlignment(SwingConstants.CENTER);
    }

    public void llenarDatosModelo() {
        Double moSuelo = Double.parseDouble(this.mopLabPanel.jSpinnerMOlab.getValue().toString());
        cultivo.setNivelMO(moSuelo);
        //System.out.println(moSuelo);
    }
     public void mostrarExplicacionMO() {
        mopLabPanel.jLabelPreguntaMO.setToolTipText("<html><body><p align='justify'>Ingrese el nivel de Materia Organica  <br>de los resultados de laboratorio de suelos  para una correcta<br> Recomendación de Fertilización</html></body>");
        mopLabPanel.jLabelPreguntaMO.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jLabelPreguntaMOMouseEntered(evt);
            }
        });
    }

    public void jLabelPreguntaMOMouseEntered(MouseEvent evt) {
        mopLabPanel.jLabelPreguntaMO.getToolTipText();
    }
    
    //Inicio Popover
    public void confLabelMO() {
        mopLabPanel.jLabelMO.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jLabelMOMouseEntered(evt);
            }
        });
    }
    public void jLabelMOMouseEntered(MouseEvent evt) {
        popOverMO.show(mopLabPanel.jLabelMO, 50, mopLabPanel.jLabelMO.getHeight());
    }
    public void confPopOverMO() {
        popOverMO.setCloseOnFocusLoss(true);
        popOverMO.setMargin(10);
        popOverMO.setLayout(new VerticalFlowLayout());
        popOverMO.add(new WebLabel("Los valores de Materia Organica"));
        popOverMO.add(new WebLabel("en un suelo agricola varia"));
        popOverMO.add(new WebLabel(" entre 1.00 y 10.00"));
    }
    //fin Popover
}
