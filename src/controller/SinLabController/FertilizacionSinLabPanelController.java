/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.SinLabController;

import controller.ResultadosConLabPanelController;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import model.Cultivo;
import model.Textura;
import view.OtrasRecomendaciones.MateriaOrganicaRecomendacionPanel;
import view.OtrasRecomendaciones.MateriaOrganicaRecomendacionPanelController;
import view.OtrasRecomendaciones.PhRecomendacionPanel;
import view.OtrasRecomendaciones.PhRecomendacionPanelController;
import view.ResultadosConLabPanel;
import view.sinLabView.CultivoPanel;
import view.sinLabView.FertilizacionSinLabPanel;
import view.sinLabView.FosforoPanel;
import view.sinLabView.MateriaOrganicaPanel;
import view.sinLabView.NitrogenoPanel;
import view.sinLabView.PHPanel;
import view.sinLabView.PotasioPanel;
import view.sinLabView.TexturaPanel;

/**
 *
 * @author Erlinda
 */
public class FertilizacionSinLabPanelController {

    FertilizacionSinLabPanel fertilizacionSinLabPanel;
    CultivoPanel cultivoPanel;
    CultivoPanelController cultivoPanelController;
    TexturaPanel texturaPanel;
    TexturaPanelController texturaPanelController;
    NitrogenoPanel nitrogenoPanel;
    NitrogenoPanelController nitrogenoPanelController;
    FosforoPanel fosforoPanel;
    FosforoPanelController fosforoPanelController;
    PotasioPanel potasioPanel;
    PotasioPanelController potasioPanelController;
    PHPanel pHPanel;
    PHPanelController pHPanelController;
    MateriaOrganicaPanel materiaOrganicaPanel;
    MateriaOrganicaPanelController materiaOrganicaPanelController;
    MateriaOrganicaRecomendacionPanel materiaOrganicaRecomendacionPanel;
    MateriaOrganicaRecomendacionPanelController materiaOrganicaRecomendacionPanelController;

    PhRecomendacionPanel phRecomendacionPanel;
    PhRecomendacionPanelController phRecomendacionPanelController;

    ResultadosConLabPanel resultadosConLabPanel;
    ResultadosConLabPanelController resultadosConLabPanelController;
    int pivote;
    JTabbedPane navegacionTabbe;
    Cultivo cultivo;
    Textura textura;

    public FertilizacionSinLabPanelController(FertilizacionSinLabPanel fertilizacionSinLabPanel) {
        this.fertilizacionSinLabPanel = fertilizacionSinLabPanel;
        navegacionTabbe = fertilizacionSinLabPanel.getjTabbedPaneNavegacion();
        pivote = 1;
        cultivo = new Cultivo();
        textura = new Textura();
        inicializarVistasControladores();
        confButtonSiguiente();
        confButtonAtras();
        navegarVista();
    }

    public void confButtonSiguiente() {
        fertilizacionSinLabPanel.jButtonSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSiguienteActionPerformed(evt);
            }
        });
    }

    public void confButtonAtras() {
        fertilizacionSinLabPanel.jButtonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAtrasActionPerformed(evt);
            }
        });
    }

    public void inicializarVistasControladores() {
        cultivoPanel = new CultivoPanel();
        cultivoPanelController = new CultivoPanelController(cultivoPanel, cultivo);
        texturaPanel = new TexturaPanel();
        texturaPanelController = new TexturaPanelController(texturaPanel, textura);
        nitrogenoPanel = new NitrogenoPanel();
        nitrogenoPanelController = new NitrogenoPanelController(nitrogenoPanel, cultivo);
        fosforoPanel = new FosforoPanel();
        fosforoPanelController = new FosforoPanelController(fosforoPanel, cultivo);
        potasioPanel = new PotasioPanel();
        potasioPanelController = new PotasioPanelController(potasioPanel, cultivo);
        pHPanel = new PHPanel();
        pHPanelController = new PHPanelController(pHPanel, cultivo);
        materiaOrganicaPanel = new MateriaOrganicaPanel();
        materiaOrganicaPanelController = new MateriaOrganicaPanelController(materiaOrganicaPanel, cultivo);
        materiaOrganicaRecomendacionPanel = new MateriaOrganicaRecomendacionPanel();
        materiaOrganicaRecomendacionPanelController = new MateriaOrganicaRecomendacionPanelController(materiaOrganicaRecomendacionPanel);
        phRecomendacionPanel = new PhRecomendacionPanel();
        phRecomendacionPanelController = new PhRecomendacionPanelController(phRecomendacionPanel);

        resultadosConLabPanel = new ResultadosConLabPanel();
        resultadosConLabPanelController = new ResultadosConLabPanelController(resultadosConLabPanel);

    }

    private void buttonSiguienteActionPerformed(java.awt.event.ActionEvent evt) {

        if (pivote != 8) {
            pivote = pivote + 1;
        }
        navegarVista();
        llenarDatosVista();
        if (pivote == 8) {
            navegacionTabbe.setSelectedIndex(1);
            resultadosConLabPanelController.llenarPanelInformacion(cultivo, textura);
        }
    }

    private void buttonAtrasActionPerformed(java.awt.event.ActionEvent evt) {
        if (pivote == 8) {
            navegacionTabbe.remove(1);
            navegacionTabbe.remove(1);
            navegacionTabbe.remove(1);
            cultivo.getRecomendaciones().removeAll(cultivo.getRecomendaciones());
        }
        if (pivote != 1) {
            pivote = pivote - 1;
        }
        navegarVista();
    }

    public void navegarVista() {
        switch (pivote) {
            case 1:
                int numTab = navegacionTabbe.getTabCount();
                if (numTab != 0) {
                    navegacionTabbe.remove(0);
                }
                navegacionTabbe.addTab("Cultivo", cultivoPanel);
                break;
            case 2:
                navegacionTabbe.remove(0);
                navegacionTabbe.addTab("Textura", texturaPanel);
                break;
            case 3:
                double sumatextura = Double.parseDouble(texturaPanel.jSpinnerArena.getValue().toString()) + Double.parseDouble(texturaPanel.jSpinnerLimo.getValue().toString()) + Double.parseDouble(texturaPanel.jSpinnerArcilla.getValue().toString());
                double totalTextura = Double.parseDouble(texturaPanel.jSpinnerTexturaTotal.getValue().toString());
                if (sumatextura == totalTextura) {
                    navegacionTabbe.remove(0);
                    navegacionTabbe.addTab("Nitrogeno", nitrogenoPanel);
                } else {
                    JOptionPane.showMessageDialog(null, "Ingrese los valores correctos de la medicion realizada en la botella: \n*Profundidad de Arena\n*Profundidad de Limo\n*Profundidad de Arcilla\n*Profundidad Total del suelo en la botella", "Valores incorrectos de textura", JOptionPane.ERROR_MESSAGE);
                    pivote = 2;
                }
                break;
            case 4:

                navegacionTabbe.remove(0);
                navegacionTabbe.addTab("Fosforo", fosforoPanel);
                break;
            case 5:
                navegacionTabbe.remove(0);
                navegacionTabbe.addTab("Potasio", potasioPanel);
                break;
            case 6:
                navegacionTabbe.remove(0);
                navegacionTabbe.addTab("Reaccion del suelo (pH)", pHPanel);
                break;
            case 7:
                navegacionTabbe.remove(0);
                navegacionTabbe.addTab("Materia Organica", materiaOrganicaPanel);
                break;
            case 8:
                navegacionTabbe.addTab("Resultados", resultadosConLabPanel);
                navegacionTabbe.addTab("Recomendacion de pH", phRecomendacionPanel);
                navegacionTabbe.addTab("Recomendacion de Materia Organica", materiaOrganicaRecomendacionPanel);

                break;
            default:
                System.out.println("No hay Valores");
                break;
        }
    }

    public void llenarDatosVista() {
        switch (pivote) {

            case 2:
                cultivoPanelController.llenarDatosModelo();
                break;
            case 3:
                texturaPanelController.llenarDatosModelo();
                break;
            case 4:
                nitrogenoPanelController.llenarDatosModelo();
                break;
            case 5:
                fosforoPanelController.llenarDatosModelo();
                break;
            case 6:
                potasioPanelController.llenarDatosModelo();
                break;
            case 7:
                pHPanelController.llenarDatosModelo();
                break;
            case 8:
                materiaOrganicaPanelController.llenarDatosModelo();
                 //primero
                resultadosConLabPanelController.llenarPanelInformacion(cultivo, textura);
               //segundo
                materiaOrganicaRecomendacionPanelController.mostrarExplicacionMO(cultivo);
                phRecomendacionPanelController.mostrarRecomendacionPh(cultivo);
                break;
            default:
                System.out.println("No hay Valores");
                break;

        }
    }
}
