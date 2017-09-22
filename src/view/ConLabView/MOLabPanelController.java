/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.ConLabView;

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

    public MOLabPanelController(MOLabPanel mopLabPanel, Cultivo cultivo) {
        this.mopLabPanel = mopLabPanel;
        this.cultivo = cultivo;
        confSpinnerMOLab();
        
        ///buton test
        mopLabPanel.jButtonTestMO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                llenarDatosModelo();
            }
        });
        ///
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
}
