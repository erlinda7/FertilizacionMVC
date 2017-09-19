/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.SinLabController;

import model.Cultivo;
import view.sinLabView.PotasioPanel;

/**
 *
 * @author Erlinda
 */
public class PotasioPanelController {

    PotasioPanel potasioPanel;
    Cultivo cultivo;

    public PotasioPanelController(PotasioPanel potasioPanel, Cultivo cultivo) {
        this.potasioPanel = potasioPanel;
        this.cultivo = cultivo;
        confRadiobutonPotasio();
    }

    public void confRadiobutonPotasio() {
        potasioPanel.jRadioButtonPotTrace.setSelected(true);
        potasioPanel.jRadioButtonPotTrace.setActionCommand("25");
        potasioPanel.jRadioButtonPotLow.setActionCommand("40");
        potasioPanel.jRadioButtonPotMedium.setActionCommand("55");
        potasioPanel.jRadioButtonPotHigh.setActionCommand("85");
    }

    public void llenarDatosModelo() {
        Integer Valorpotasio = Integer.parseInt(potasioPanel.getButtonGroupPotasio().getSelection().getActionCommand());
        cultivo.setNivelPotasio(Valorpotasio);
    }
}
