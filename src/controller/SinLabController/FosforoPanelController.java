/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.SinLabController;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import model.Cultivo;
import view.sinLabView.FosforoPanel;

/**
 *
 * @author Erlinda
 */
public class FosforoPanelController {

    FosforoPanel fosforoPanel;
    Cultivo cultivo;

    public FosforoPanelController(FosforoPanel fosforoPanel, Cultivo cultivo) {
        this.fosforoPanel = fosforoPanel;
        this.cultivo = cultivo;
        confRadiobutonFosforo();
        mostrarExplicacionFosforo();
    }

    public void confRadiobutonFosforo() {
        fosforoPanel.jRadioButtonFosfoTrace.setSelected(true);
        fosforoPanel.jRadioButtonFosfoTrace.setActionCommand("9");
        fosforoPanel.jRadioButtonFosfoLow.setActionCommand("14");
        fosforoPanel.jRadioButtonFosfoMedium.setActionCommand("24");
        fosforoPanel.jRadioButtonFosfoHigh.setActionCommand("30");
//        fosforoPanel.jRadioButtonFosfoTraceLow.setActionCommand("12");
//        fosforoPanel.jRadioButtonFosfoLowMedium.setActionCommand("19");
//        fosforoPanel.jRadioButtonFosfoMediumHigh.setActionCommand("27");
    }

    public void llenarDatosModelo() {
        Integer valorFosforo = Integer.parseInt(fosforoPanel.getButtonGroupFosforo().getSelection().getActionCommand());
        cultivo.setNivelFosforo(valorFosforo);
    }

    public void mostrarExplicacionFosforo() {
        fosforoPanel.jLabelPreguntaFosforo.setToolTipText("<html><body><p align='justify'>Elija el color que ha obtenido con el kit de analisis de fosforo <br>para realizar una correcta Recomendación de Fertilización</html></body>");
        fosforoPanel.jLabelPreguntaFosforo.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jLabelPreguntaFosforoMouseEntered(evt);
            }
        });
    }

    public void jLabelPreguntaFosforoMouseEntered(MouseEvent evt) {
        fosforoPanel.jLabelPreguntaFosforo.getToolTipText();
    }
}
