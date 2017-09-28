/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.SinLabController;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import model.Cultivo;
import view.sinLabView.PHPanel;

/**
 *
 * @author Erlinda
 */
public class PHPanelController {

    PHPanel pHPanel;
    Cultivo cultivo;

    public PHPanelController(PHPanel pHPanel, Cultivo cultivo) {
        this.pHPanel = pHPanel;
        this.cultivo = cultivo;
        confRadiobutonPh();
        mostrarExplicacionPh();
    }

    public void confRadiobutonPh() {
        pHPanel.jRadioButtonPh6.setSelected(true);
        pHPanel.jRadioButtonPh4.setActionCommand("4.01");
        pHPanel.jRadioButtonPh5.setActionCommand("5.01");
        pHPanel.jRadioButtonPh6.setActionCommand("6.01");
        pHPanel.jRadioButtonPh7.setActionCommand("7.00");
        pHPanel.jRadioButtonpH8.setActionCommand("8.00");
        pHPanel.jRadioButtonpH9.setActionCommand("9.00");
    }

    public void llenarDatosModelo() {
        Double valorPh = Double.parseDouble(pHPanel.getButtonGroupPh().getSelection().getActionCommand());
        cultivo.setNivelpH(valorPh);
    }
      public void mostrarExplicacionPh() {
        pHPanel.jLabelPreguntaPh.setToolTipText("<html><body><p align='justify'>Elija el nivel de pH obtenido con el kit de analisis del pH  <br>para realizar una correcta Recomendación de Fertilización</html></body>");
        pHPanel.jLabelPreguntaPh.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jLabelPreguntaPhMouseEntered(evt);
            }
        });
    }

    public void jLabelPreguntaPhMouseEntered(MouseEvent evt) {
       pHPanel.jLabelPreguntaPh.getToolTipText();
    }
}
