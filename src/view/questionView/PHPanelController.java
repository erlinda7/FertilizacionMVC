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
public class PHPanelController {
    PHPanel pHPanel;
    Cultivo cultivo;
    public PHPanelController(PHPanel pHPanel,Cultivo cultivo) {
        this.pHPanel=pHPanel;
        this.cultivo=cultivo;
    confPhPanel();
    }

    public void confPhPanel() {
        confRadiobutonPh();
    }

   
    public void confRadiobutonPh() {
        pHPanel.jRadioButtonPh7.setSelected(true);
        pHPanel.jRadioButtonPh4.setActionCommand("4.01");
        pHPanel.jRadioButtonPh5.setActionCommand("5.01");
        pHPanel.jRadioButtonPh6.setActionCommand("6.01");
        pHPanel.jRadioButtonPh7.setActionCommand("7.00");
        pHPanel.jRadioButtonpH8.setActionCommand("8.00");
        pHPanel.jRadioButtonpH9.setActionCommand("9.00");   
    }

    public void llenarDatosModelo() {
        Double ValorPh = Double.parseDouble(pHPanel.getButtonGroupPh().getSelection().getActionCommand());
        cultivo.setNivelpH(ValorPh);
        //System.out.println(ValorNitrogeno);
    }
}
