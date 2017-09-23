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
public class PHLabPanelController {

    PHLabPanel pHLabPanel;
    Cultivo cultivo;

    public PHLabPanelController(PHLabPanel pHLabPanel, Cultivo cultivo) {
        this.pHLabPanel = pHLabPanel;
        this.cultivo = cultivo;
        confSpinnerpHLab();
        
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
}
