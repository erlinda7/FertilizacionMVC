/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.ConLabView;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.text.DefaultFormatter;
import model.Cultivo;

/**
 *
 * @author Erlinda
 */
public class NutrientesLabPanelController {

    NutrientesLabPanel nutrientesLabPanel;
    Cultivo cultivo;

    public NutrientesLabPanelController(NutrientesLabPanel nutrientesLabPanel, Cultivo cultivo) {
        this.nutrientesLabPanel = nutrientesLabPanel;
        this.cultivo = cultivo;
        confSpinnerNitrogenoLab();
        confSpinerFosforoLab();
        confSpinnerPotasioLab();
        
        ///buton test
        nutrientesLabPanel.jButtonTestNutrientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                llenarDatosModelo();
            }
        });
        ///
    }

    public void confSpinnerNitrogenoLab() {
        JSpinner spinnerNitrogeno = this.nutrientesLabPanel.jSpinnerNitrogenoLab;
        SpinnerNumberModel modelNitrogeno = new SpinnerNumberModel(10, 1, 100, 1);
        modelNitrogeno.setMinimum(0);
        modelNitrogeno.setMaximum(100);
        modelNitrogeno.setValue(5);
        modelNitrogeno.setStepSize(((int) 1));
        spinnerNitrogeno.setModel(modelNitrogeno);
        JSpinner.NumberEditor editorNitrogeno = (JSpinner.NumberEditor) spinnerNitrogeno.getEditor();
        DefaultFormatter formatter = (DefaultFormatter) editorNitrogeno.getTextField().getFormatter();
        formatter.setAllowsInvalid(false);
        editorNitrogeno.getTextField().setHorizontalAlignment(SwingConstants.CENTER);
    }

    public void confSpinerFosforoLab() {
        JSpinner spinnerFosforo = this.nutrientesLabPanel.jSpinnerFosforoLab;
        SpinnerNumberModel modelFosforo = new SpinnerNumberModel();
        modelFosforo.setMinimum(0);
        modelFosforo.setMaximum(100);
        modelFosforo.setValue(5);
        modelFosforo.setStepSize(((int) 1));
        spinnerFosforo.setModel(modelFosforo);
        JSpinner.NumberEditor editorFosforo = (JSpinner.NumberEditor) spinnerFosforo.getEditor();
        DefaultFormatter formatter = (DefaultFormatter) editorFosforo.getTextField().getFormatter();
        formatter.setAllowsInvalid(false);
        editorFosforo.getTextField().setHorizontalAlignment(SwingConstants.CENTER);
    }

    public void confSpinnerPotasioLab() {
        JSpinner spinnerPotasio = this.nutrientesLabPanel.jSpinnerPotasioLab;
        SpinnerNumberModel modelPotasio = new SpinnerNumberModel();
        modelPotasio.setMinimum(0);
        modelPotasio.setMaximum(250);
        modelPotasio.setValue(10);
        modelPotasio.setStepSize(((int) 1));
        spinnerPotasio.setModel(modelPotasio);
        JSpinner.NumberEditor editorPotasio = (JSpinner.NumberEditor) spinnerPotasio.getEditor();
        DefaultFormatter formatter = (DefaultFormatter) editorPotasio.getTextField().getFormatter();
        formatter.setAllowsInvalid(false);
        editorPotasio.getTextField().setHorizontalAlignment(SwingConstants.CENTER);
    }

    public void llenarDatosModelo() {
        Integer nitrogenoSuelo = Integer.parseInt(this.nutrientesLabPanel.jSpinnerNitrogenoLab.getValue().toString());
        cultivo.setNivelNitrogeno(nitrogenoSuelo);
        //System.out.println(nitrogenoSuelo);
        
        Integer fosforoSuelo = Integer.parseInt(this.nutrientesLabPanel.jSpinnerFosforoLab.getValue().toString());
        cultivo.setNivelFosforo(fosforoSuelo);
        //System.out.println(fosforoSuelo);
        
        Integer potasioSuelo = Integer.parseInt(this.nutrientesLabPanel.jSpinnerPotasioLab.getValue().toString());
        cultivo.setNivelPotasio(potasioSuelo);
        //System.out.println(potasioSuelo);
        
    }
}
