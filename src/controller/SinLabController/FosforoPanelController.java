/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.SinLabController;

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
}
