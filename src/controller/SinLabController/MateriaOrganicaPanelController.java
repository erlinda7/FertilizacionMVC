/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.SinLabController;

import model.Cultivo;
import view.sinLabView.MateriaOrganicaPanel;

/**
 *
 * @author Erlinda
 */
public class MateriaOrganicaPanelController {

    MateriaOrganicaPanel materiaOrganicaPanel;
    Cultivo cultivo;

    public MateriaOrganicaPanelController(MateriaOrganicaPanel materiaOrganicaPanel, Cultivo cultivo) {
        this.materiaOrganicaPanel = materiaOrganicaPanel;
        this.cultivo = cultivo;
        confRadiobutonMO();
    }

    public void confRadiobutonMO() {
        materiaOrganicaPanel.jRadioButtonMOMedio.setSelected(true);
        materiaOrganicaPanel.jRadioButtonMOAlto.setActionCommand("4.5");
        materiaOrganicaPanel.jRadioButtonMOMedio.setActionCommand("3.0");
        materiaOrganicaPanel.jRadioButtonMOBajo.setActionCommand("1.5");

    }

    public void llenarDatosModelo() {
        Double valorMO = Double.parseDouble(materiaOrganicaPanel.getButtonGroupMO().getSelection().getActionCommand());
        cultivo.setNivelMO(valorMO);
    }

}
