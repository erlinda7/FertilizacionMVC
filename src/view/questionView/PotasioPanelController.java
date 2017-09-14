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
public class PotasioPanelController {

    PotasioPanel potasioPanel;
    Cultivo cultivo;

    public PotasioPanelController(PotasioPanel potasioPanel, Cultivo cultivo) {
        this.potasioPanel = potasioPanel;
        this.cultivo = cultivo;
        confPotasioPanel();
    }

    public void confPotasioPanel() {
        confPotasioLabel();
        confRadiobutonPotasio();
    }

    public void confPotasioLabel() {
        potasioPanel.jLabelPotasio.setIcon(new ImageIcon(getClass().getResource("/img/fondoLabelPotasio.jpg")));
    }
    
    public void confRadiobutonPotasio() {
        potasioPanel.jRadioButtonPotMedium.setSelected(true);
        potasioPanel.jRadioButtonPotTrace.setActionCommand("79");
        potasioPanel.jRadioButtonPotLow.setActionCommand("106");
        potasioPanel.jRadioButtonPotMedium.setActionCommand("146");
        potasioPanel.jRadioButtonPotHigh.setActionCommand("161");
        
    }

    public void llenarDatosModelo() {
        Integer Valorpotasio = Integer.parseInt(potasioPanel.getButtonGroupPotasio().getSelection().getActionCommand());
        cultivo.setNivelPotasio(Valorpotasio);
        //System.out.println(ValorNitrogeno);
    }
}
