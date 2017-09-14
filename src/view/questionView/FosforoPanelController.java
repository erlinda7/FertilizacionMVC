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
public class FosforoPanelController {

    FosforoPanel fosforoPanel;
    Cultivo cultivo;

    public FosforoPanelController(FosforoPanel fosforoPanel, Cultivo cultivo) {
        this.fosforoPanel = fosforoPanel;
        this.cultivo = cultivo;
        confFosforoPanel();
    }

    public void confFosforoPanel() {
        confFosforoLabel();
        confRadiobutonFosforo();

    }

    public void confFosforoLabel() {
        fosforoPanel.jLabelFosforo.setIcon(new ImageIcon(getClass().getResource("/img/fondoLabelFosforo.jpg")));
    }

    public void confRadiobutonFosforo() {
        fosforoPanel.jRadioButtonFosfoMedium.setSelected(true);
        fosforoPanel.jRadioButtonFosfoTrace.setActionCommand("9");
        fosforoPanel.jRadioButtonFosfoLow.setActionCommand("14");
        fosforoPanel.jRadioButtonFosfoMedium.setActionCommand("24");
        fosforoPanel.jRadioButtonFosfoHigh.setActionCommand("30");
        fosforoPanel.jRadioButtonFosfoTraceLow.setActionCommand("12");
        fosforoPanel.jRadioButtonFosfoLowMedium.setActionCommand("19");
        fosforoPanel.jRadioButtonFosfoMediumHigh.setActionCommand("27");
    }

    public void llenarDatosModelo() {
        Integer ValorFosforo = Integer.parseInt(fosforoPanel.getButtonGroupFosforo().getSelection().getActionCommand());
        cultivo.setNivelFosforo(ValorFosforo);
        //System.out.println(ValorNitrogeno);
    }
}