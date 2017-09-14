/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.questionView;

import javax.swing.ImageIcon;
import model.Cultivo;

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
        confNitrogenoPanel();
    }

    public void confNitrogenoPanel() {
        confNitrogenoLabel();
        confRadiobutonNitrogeno();
    }

    public void confNitrogenoLabel() {
        nitrogenoPanel.jLabelNitrogeno.setIcon(new ImageIcon(getClass().getResource("/img/fondoLabelNitrogeno.jpg")));
    }

    public void confRadiobutonNitrogeno() {
        nitrogenoPanel.jRadioButtonMedium.setSelected(true);
        nitrogenoPanel.jRadioButtonTrace.setActionCommand("24");
        nitrogenoPanel.jRadioButtonLow.setActionCommand("31");
        nitrogenoPanel.jRadioButtonMedium.setActionCommand("43");
        nitrogenoPanel.jRadioButtonHigh.setActionCommand("49");
        nitrogenoPanel.jRadioButtonTraceLow.setActionCommand("27");
        nitrogenoPanel.jRadioButtonLowMedium.setActionCommand("37");
        nitrogenoPanel.jRadioButtonMediumHigh.setActionCommand("46");        
    }

    public void llenarDatosModelo() {
        Integer ValorNitrogeno = Integer.parseInt(nitrogenoPanel.getButtonGroupNitrogeno().getSelection().getActionCommand());
        cultivo.setNivelNitrogeno(ValorNitrogeno);
        //System.out.println(ValorNitrogeno);
    }
}
