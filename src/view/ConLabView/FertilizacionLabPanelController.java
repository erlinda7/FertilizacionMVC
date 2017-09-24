/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.ConLabView;

import controller.CultivoConfiguradoLabPanelController;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import model.Cultivo;
import model.Textura;
import view.CultivoConfiguradoLabPanel;
import view.sinLabView.TexturaPanel;

/**
 *
 * @author Erlinda
 */
public class FertilizacionLabPanelController {

    FertilizacionLabPanel fertilizacionLabPanel;
    HortalizaLabPanel hortalizaLabPanel;
    HortalizaLabPanelController hortalizaLabPanelController;

    RendimientoLabPanel rendimientoLabPanel;
    RendimientoLabPanelController rendimientoLabPanelController;

    TexturaLabPanel texturaLabPanel;
    TexturaLabPanelController texturaLabPanelController;

    NutrientesLabPanel nutrientesLabPanel;
    NutrientesLabPanelController nutrientesLabPanelController;

    PHLabPanel pHLabPanel;
    PHLabPanelController pHLabPanelController;

    MOLabPanel mOLabPanel;
    MOLabPanelController mOLabPanelController;

    MemoriaTrabajoPanel memoriaTrabajoPanel;
    MemoriaTrabajoPanelController memoriaTrabajoPanelController;

    CultivoConfiguradoLabPanel cultivoConfiguradoLabPanel;
    CultivoConfiguradoLabPanelController cultivoConfiguradoLabPanelController;

    RecomendacionesCultivoPanel recomendacionesCultivoPanel;
    RecomendacionesCultivoPanelController recomendacionesCultivoPanelController;

    /*Iinicio Memorias de trabajo para panelLab*/
    MemoriaTrabajoPanelController mtpcHortaliza;
    MemoriaTrabajoPanelController mtpcRendimiento;
    MemoriaTrabajoPanelController mtpcTextura;
    //falta 3 mas
    /*Fin Memorias de trabajo para panelLab*/
    int pivote;
    JTabbedPane NavegacionTabbe;
    Cultivo cultivo;
    Textura textura;

    public FertilizacionLabPanelController(FertilizacionLabPanel fertilizacionLabPanel) {
        this.fertilizacionLabPanel = fertilizacionLabPanel;
        cultivo = new Cultivo();
        textura = new Textura();
        NavegacionTabbe = fertilizacionLabPanel.getjTabbedNavegacion();
        pivote = 1;
        inicializarVistasControladoresLab();
        confButtonAtrasLab();
        confButtonSiguienteLab();
        navegarVista();

    }

    public void confButtonSiguienteLab() {
        fertilizacionLabPanel.jButtonSiguienteLAb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSiguienteLabActionPerformed(evt);
            }
        });
    }

    public void confButtonAtrasLab() {
        fertilizacionLabPanel.jButtonAtrasLab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAtrasLabActionPerformed(evt);
            }
        });
    }

    public void inicializarVistasControladoresLab() {
        //Inicio memoria de trabajo
        memoriaTrabajoPanel = new MemoriaTrabajoPanel();
        memoriaTrabajoPanelController = new MemoriaTrabajoPanelController(memoriaTrabajoPanel);
        //Fin memoria de trabajo
        hortalizaLabPanel = new HortalizaLabPanel();
        hortalizaLabPanelController = new HortalizaLabPanelController(hortalizaLabPanel, cultivo);
        rendimientoLabPanel = new RendimientoLabPanel();
        rendimientoLabPanelController = new RendimientoLabPanelController(rendimientoLabPanel, cultivo);
        texturaLabPanel = new TexturaLabPanel();
        texturaLabPanelController = new TexturaLabPanelController(texturaLabPanel, textura);
        nutrientesLabPanel = new NutrientesLabPanel();
        nutrientesLabPanelController = new NutrientesLabPanelController(nutrientesLabPanel, cultivo);
        pHLabPanel = new PHLabPanel();
        pHLabPanelController = new PHLabPanelController(pHLabPanel, cultivo);
        mOLabPanel = new MOLabPanel();
        mOLabPanelController = new MOLabPanelController(mOLabPanel, cultivo);

        mtpcHortaliza = new MemoriaTrabajoPanelController(hortalizaLabPanel.memoriaTrabajoPanel1);
        mtpcRendimiento = new MemoriaTrabajoPanelController(rendimientoLabPanel.memoriaTrabajoPanel1);
        mtpcTextura = new MemoriaTrabajoPanelController(texturaLabPanel.memoriaTrabajoPanel1);
        //falta 3 mas 

        cultivoConfiguradoLabPanel = new CultivoConfiguradoLabPanel();
        cultivoConfiguradoLabPanelController = new CultivoConfiguradoLabPanelController(cultivoConfiguradoLabPanel);
        recomendacionesCultivoPanel = new RecomendacionesCultivoPanel();
    }

    private void buttonSiguienteLabActionPerformed(java.awt.event.ActionEvent evt) {

        if (pivote != 8) {
            pivote = pivote + 1;
        }

        navegarVista();
        llenarDatosVista();
        if (pivote == 8) {
            NavegacionTabbe.setSelectedIndex(1);
        }
        // System.out.println("pivote siguiente"+pivote);

    }

    private void buttonAtrasLabActionPerformed(java.awt.event.ActionEvent evt) {
        if (pivote == 8) {
            NavegacionTabbe.remove(1);
        }
        if (pivote != 1) {
            pivote = pivote - 1;
        }
        navegarVista();
        //System.out.println("pivote atras"+pivote);
    }

    public void navegarVista() {
        switch (pivote) {
            case 1:
                int numTab = NavegacionTabbe.getTabCount();
                if (numTab != 0) {
                    NavegacionTabbe.remove(0);
                }
                NavegacionTabbe.addTab("Hortaliza", hortalizaLabPanel);
                break;
            case 2:

                NavegacionTabbe.remove(0);
                NavegacionTabbe.addTab("Rendimiento Esperado", rendimientoLabPanel);
                break;
            case 3:
                NavegacionTabbe.remove(0);
                NavegacionTabbe.addTab("Textura del Suelo", texturaLabPanel);

                break;
            case 4:
                double sumaSlider = texturaLabPanel.jSliderArenaLab.getValue() + texturaLabPanel.jSliderLimoLab.getValue() + texturaLabPanel.jSliderArcillaLab.getValue();
                if (sumaSlider == 100) {
                    NavegacionTabbe.remove(0);
                    NavegacionTabbe.addTab("Nutrientes del Suelo", nutrientesLabPanel);
                } else {
                    JOptionPane.showMessageDialog(null, "La sumatoria del porcentaje de Arena, Limo y Arcilla debe ser igual a 100", "Valores incorrectos de textura", JOptionPane.ERROR_MESSAGE);
                    pivote = 3;
                }
                break;
            case 5:
                NavegacionTabbe.remove(0);
                NavegacionTabbe.addTab("Reaccion del Suelo(pH))", pHLabPanel);
                break;
            case 6:
                NavegacionTabbe.remove(0);
                NavegacionTabbe.addTab("Materia Orgánica", mOLabPanel);
                break;
            case 7:
                NavegacionTabbe.remove(0);
                NavegacionTabbe.addTab("Fertilización de Hortalizas", cultivoConfiguradoLabPanel);
                break;
            case 8:
                NavegacionTabbe.addTab("Recomendaciones", recomendacionesCultivoPanel);
                //crear variable global para la vista y el controlador del recomendacionesCultivo panel;
                break;
            default:
                System.out.println("No hay Valores");
                break;
        }
    }

    public void llenarDatosVista() {
        switch (pivote) {

            case 2:
                hortalizaLabPanelController.llenarDatosModelo();
                rendimientoLabPanelController.actualizarVistaRendimiento();
                System.out.println(cultivo.getHortaliza());
                rendimientoLabPanelController.actualizaValorRadioButtonRendimiento(hortalizaLabPanelController.getRendimientoActual());

                mtpcRendimiento.mostrarHortaliza(cultivo.getHortaliza());
                
                break;
            case 3:
                rendimientoLabPanelController.llenarDatosModelo();
                System.out.println(cultivo.getRendimiento());
                mtpcTextura.mostrarHortaliza(cultivo.getHortaliza());
                mtpcTextura.mostrarRendimiento(cultivo.getRendimiento()+"");
                break;
            case 4:
                texturaLabPanelController.llenarDatosModelo();
                System.out.println(textura.getTexturaArena());
                System.out.println(textura.getTexturaLimo());
                System.out.println(textura.getTexturaArcilla());
                break;
            case 5:
                nutrientesLabPanelController.llenarDatosModelo();
                System.out.println(cultivo.getNivelNitrogeno());
                System.out.println(cultivo.getNivelFosforo());
                System.out.println(cultivo.getNivelPotasio());
                break;
            case 6:
                pHLabPanelController.llenarDatosModelo();
                System.out.println(cultivo.getNivelpH());
                break;
            case 7:
                mOLabPanelController.llenarDatosModelo();
                System.out.print(cultivo.getNivelMO());
                break;
            case 8:
                recomendacionesCultivoPanelController.llenarDatosModelo();
                break;
            default:
                System.out.println("No hay Valores");
                break;
        }
    }
//    public void actualizarVistaRendimiento(){
//    rendimientoLabPanel.jLabelNombreHortaliza.setText(cultivo.getHortaliza()+"  (ton/ha): ");
//    }

}
