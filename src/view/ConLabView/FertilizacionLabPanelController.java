/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.ConLabView;

import controller.CultivoConfiguradoLabPanelController;
import controller.ResultadosConLabPanelController;
import controller.SinLabController.MateriaOrganicaPanelController;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import model.Cultivo;
import model.Textura;
import view.CultivoConfiguradoLabPanel;
import view.OtrasRecomendaciones.MateriaOrganicaRecomendacionPanel;
import view.OtrasRecomendaciones.MateriaOrganicaRecomendacionPanelController;
import view.OtrasRecomendaciones.PhRecomendacionPanel;
import view.OtrasRecomendaciones.PhRecomendacionPanelController;
import view.ResultadosConLabPanel;
import view.sinLabView.MateriaOrganicaPanel;
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

    MateriaOrganicaRecomendacionPanel materiaOrganicaRecomendacionPanel;
    MateriaOrganicaRecomendacionPanelController materiaOrganicaRecomendacionPanelController;

    PhRecomendacionPanel phRecomendacionPanel;
    PhRecomendacionPanelController phRecomendacionPanelController;


    /*Iinicio Memorias de trabajo para panelLab*/
    MemoriaTrabajoPanelController mtpcHortaliza;
    MemoriaTrabajoPanelController mtpcRendimiento;
    MemoriaTrabajoPanelController mtpcTextura;
    MemoriaTrabajoPanelController mtpcNutrientes;
    MemoriaTrabajoPanelController mtpcPh;
    MemoriaTrabajoPanelController mtpcMo;
    //falta 3 mas
    /*Fin Memorias de trabajo para panelLab*/

    ResultadosConLabPanel resultadosConLabPanel;
    ResultadosConLabPanelController resultadosConLabPanelController;
    int pivote;
    JTabbedPane navegacionTabbe;
    Cultivo cultivo;
    Textura textura;

    public FertilizacionLabPanelController(FertilizacionLabPanel fertilizacionLabPanel) {
        this.fertilizacionLabPanel = fertilizacionLabPanel;
        cultivo = new Cultivo();
        textura = new Textura();
        navegacionTabbe = fertilizacionLabPanel.getjTabbedNavegacion();
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
        materiaOrganicaRecomendacionPanel = new MateriaOrganicaRecomendacionPanel();
        materiaOrganicaRecomendacionPanelController = new MateriaOrganicaRecomendacionPanelController(materiaOrganicaRecomendacionPanel);
        phRecomendacionPanel = new PhRecomendacionPanel();
        phRecomendacionPanelController = new PhRecomendacionPanelController(phRecomendacionPanel);

        mtpcHortaliza = new MemoriaTrabajoPanelController(hortalizaLabPanel.memoriaTrabajoPanel1);
        mtpcRendimiento = new MemoriaTrabajoPanelController(rendimientoLabPanel.memoriaTrabajoPanel1);
        mtpcTextura = new MemoriaTrabajoPanelController(texturaLabPanel.memoriaTrabajoPanel1);
        mtpcNutrientes = new MemoriaTrabajoPanelController(nutrientesLabPanel.memoriaTrabajoPanel1);
        mtpcPh = new MemoriaTrabajoPanelController(pHLabPanel.memoriaTrabajoPanel1);
        mtpcMo = new MemoriaTrabajoPanelController(mOLabPanel.memoriaTrabajoPanel1);
        //falta 3 mas 

        resultadosConLabPanel = new ResultadosConLabPanel();
      // resultadosConLabPanel = fertilizacionLabPanel.resultadosConLabPanel1X;
        resultadosConLabPanelController = new ResultadosConLabPanelController(resultadosConLabPanel);

        cultivoConfiguradoLabPanel = new CultivoConfiguradoLabPanel();
        cultivoConfiguradoLabPanelController = new CultivoConfiguradoLabPanelController(cultivoConfiguradoLabPanel);
        recomendacionesCultivoPanel = new RecomendacionesCultivoPanel();
        
         //fertilizacionLabPanel.getjScrollPane1().add(resultadosConLabPanel);
    }

    private void buttonSiguienteLabActionPerformed(java.awt.event.ActionEvent evt) {

        if (pivote != 7) {
            pivote = pivote + 1;
        }

        navegarVista();
        llenarDatosVista();
        if (pivote == 7) {
            navegacionTabbe.setSelectedIndex(1);
            // resultadosConLabPanelController.llenarPanelInformacion(cultivo, textura);
        }
        // System.out.println("pivote siguiente"+pivote);

    }

    private void buttonAtrasLabActionPerformed(java.awt.event.ActionEvent evt) {
        if (pivote == 7) {
            navegacionTabbe.remove(1);
            navegacionTabbe.remove(1);
            navegacionTabbe.remove(1);
            cultivo.getRecomendaciones().removeAll(cultivo.getRecomendaciones());
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
                int numTab = navegacionTabbe.getTabCount();
                if (numTab != 0) {
                    navegacionTabbe.remove(0);
                }
                navegacionTabbe.addTab("Hortaliza", hortalizaLabPanel);
                break;
            case 2:

                navegacionTabbe.remove(0);
                navegacionTabbe.addTab("Rendimiento Esperado", rendimientoLabPanel);
                break;
            case 3:
                navegacionTabbe.remove(0);
                navegacionTabbe.addTab("Textura del Suelo", texturaLabPanel);

                break;
            case 4:
                double sumaSlider = texturaLabPanel.jSliderArenaLab.getValue() + texturaLabPanel.jSliderLimoLab.getValue() + texturaLabPanel.jSliderArcillaLab.getValue();
                if (sumaSlider == 100) {
                    navegacionTabbe.remove(0);
                    navegacionTabbe.addTab("Nutrientes del Suelo", nutrientesLabPanel);
                } else {
                    JOptionPane.showMessageDialog(null, "La sumatoria del porcentaje de Arena, Limo y Arcilla debe ser igual a 100", "Valores incorrectos de textura", JOptionPane.ERROR_MESSAGE);
                    pivote = 3;
                }
                break;
            case 5:
                navegacionTabbe.remove(0);
                navegacionTabbe.addTab("Reaccion del Suelo(pH))", pHLabPanel);
                break;
            case 6:
                navegacionTabbe.remove(0);
                navegacionTabbe.addTab("Materia Orgánica", mOLabPanel);
                break;

            case 7:

                     
                navegacionTabbe.addTab("Recomendacion de Fertilizacion", resultadosConLabPanel);
                navegacionTabbe.addTab("Recomendacion de pH", phRecomendacionPanel);
                navegacionTabbe.addTab("Recomendacion de Materia Organica", materiaOrganicaRecomendacionPanel);

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
                mtpcTextura.mostrarRendimiento(cultivo.getRendimiento() + "");
                break;
            case 4:
                texturaLabPanelController.llenarDatosModelo();
                System.out.println(textura.getTexturaArena());
                System.out.println(textura.getTexturaLimo());
                System.out.println(textura.getTexturaArcilla());
                mtpcNutrientes.mostrarHortaliza(cultivo.getHortaliza());
                mtpcNutrientes.mostrarRendimiento(cultivo.getRendimiento() + "");
                mtpcNutrientes.mostrarTextura(textura.getTexturaArena() + "", textura.getTexturaLimo() + "", textura.getTexturaArcilla() + "");
                break;
            case 5:
                nutrientesLabPanelController.llenarDatosModelo();
                System.out.println(cultivo.getNivelNitrogeno());
                System.out.println(cultivo.getNivelFosforo());
                System.out.println(cultivo.getNivelPotasio());
                mtpcPh.mostrarHortaliza(cultivo.getHortaliza());
                mtpcPh.mostrarRendimiento(cultivo.getRendimiento() + "");
                mtpcPh.mostrarTextura(textura.getTexturaArena() + "", textura.getTexturaLimo() + "", textura.getTexturaArcilla() + "");
                mtpcPh.mostrarNutrientes(cultivo.getNivelNitrogeno() + "", cultivo.getNivelFosforo() + "", cultivo.getNivelPotasio() + "");
                break;
            case 6:
                pHLabPanelController.llenarDatosModelo();
                System.out.println(cultivo.getNivelpH());
                mtpcMo.mostrarHortaliza(cultivo.getHortaliza());
                mtpcMo.mostrarRendimiento(cultivo.getRendimiento() + "");
                mtpcMo.mostrarTextura(textura.getTexturaArena() + "", textura.getTexturaLimo() + "", textura.getTexturaArcilla() + "");
                mtpcMo.mostrarNutrientes(cultivo.getNivelNitrogeno() + "", cultivo.getNivelFosforo() + "", cultivo.getNivelPotasio() + "");
                mtpcMo.mostrarPh(cultivo.getNivelpH() + "");
                break;
            case 7:
                mOLabPanelController.llenarDatosModelo();
                //primero
                resultadosConLabPanelController.llenarPanelInformacion(cultivo, textura);
               //segundo
                resultadosConLabPanelController.mostrarExplicacionRecomendacionFertilizacion(cultivo, "limosa");
                materiaOrganicaRecomendacionPanelController.mostrarExplicacionMO(cultivo);
                phRecomendacionPanelController.mostrarRecomendacionPh(cultivo);
                System.out.print(cultivo.getNivelMO());
                pHLabPanelController.llenarDatosModelo();
                System.out.println(cultivo.getNivelpH());
//                mtpcMo.mostrarHortaliza(cultivo.getHortaliza());
//                mtpcMo.mostrarRendimiento(cultivo.getRendimiento() + "");
//                mtpcMo.mostrarTextura(textura.getTexturaArena() + "", textura.getTexturaLimo() + "", textura.getTexturaArcilla() + "");
//                mtpcMo.mostrarNutrientes(cultivo.getNivelNitrogeno() + "", cultivo.getNivelFosforo() + "", cultivo.getNivelPotasio() + "");
//                mtpcMo.mostrarPh(cultivo.getNivelpH()+"");
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
