/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.OtrasRecomendaciones;

import model.Cultivo;

/**
 *
 * @author Erlinda
 */
public class MateriaOrganicaRecomendacionPanelController {

    MateriaOrganicaRecomendacionPanel materiaOrganicaRecPanel;

    public MateriaOrganicaRecomendacionPanelController(MateriaOrganicaRecomendacionPanel aumentarMateriaOrganicaPanel) {
        this.materiaOrganicaRecPanel = aumentarMateriaOrganicaPanel;
        //mostrarExplicacionMO();
    }

    public void mostrarExplicacionMO(Cultivo cultivo) {
        ///capturar desde cultivo nivelMO, rangoMO
        double nivelMO = cultivo.getNivelMO();
        String rangoMO = cultivo.getRangoNivelMO();

        if (nivelMO <= 4.0) {
            materiaOrganicaRecPanel.nivelMOlabel.setText("<html><body><p align='justify'>"+"El nivel de  Materia Organica en el suelo es ' "+nivelMO + " ' por lo cual se considera ' "+rangoMO+" '</body></html>");
            materiaOrganicaRecPanel.explicacionMOLabel.setText("<html><body><p align='justify'>La Materia Organica del suelo se mejora aplicando esteriecol, abono verde o compostaje.</body></html>");
        } else {
             materiaOrganicaRecPanel.nivelMOlabel.setText("<html><body><p align='justify'>"+"El nivel de  Materia Organica en el suelo es ' "+nivelMO + " ' por lo cual se considera ' "+rangoMO+" '</body></html>");
            materiaOrganicaRecPanel.explicacionMOLabel.setText("<html><body><p align='justify'>La Materia Organica del suelo es adecuada no necesita agregar materia organica.</body></html>");
        }

    }
}
