/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.SinLabController;

import model.Cultivo;
import view.sinLabView.NitrogenoPanel;

/**
 *
 * @author Erlinda
 */
public class NitrogenoPanelController {

    NitrogenoPanel nitrogenoPanel;
    Cultivo cultivo;

    public NitrogenoPanelController(NitrogenoPanel nitrogenoPanel, Cultivo cultivo) {
        this.nitrogenoPanel = nitrogenoPanel;
        this.cultivo = cultivo;
        confRadiobutonNitrogeno();
    }

    public void confRadiobutonNitrogeno() {
        nitrogenoPanel.jRadioButtonTrace.setSelected(true);
        nitrogenoPanel.jRadioButtonTrace.setActionCommand("24");
        nitrogenoPanel.jRadioButtonLow.setActionCommand("31");
        nitrogenoPanel.jRadioButtonMedium.setActionCommand("43");
        nitrogenoPanel.jRadioButtonHigh.setActionCommand("49");
        nitrogenoPanel.jRadioButtonTraceLow.setActionCommand("27");
        nitrogenoPanel.jRadioButtonLowMedium.setActionCommand("37");
        nitrogenoPanel.jRadioButtonMediumHigh.setActionCommand("46");
    }

    public void llenarDatosModelo() {
        Integer valorNitrogeno = Integer.parseInt(nitrogenoPanel.getButtonGroupNitrogeno().getSelection().getActionCommand());
        cultivo.setNivelNitrogeno(valorNitrogeno);
    }
}
