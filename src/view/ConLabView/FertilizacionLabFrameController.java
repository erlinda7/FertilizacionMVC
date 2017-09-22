/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.ConLabView;

import model.Cultivo;

/**
 *
 * @author Erlinda
 */
public class FertilizacionLabFrameController {

    FertilizacionLabFrame fertilizacionLabFrame;

    public FertilizacionLabFrameController(FertilizacionLabFrame fertilizacionLabFrame) {
        this.fertilizacionLabFrame = fertilizacionLabFrame;
        //crear cultivo con datos inicializados

        //para probar buton test
        // HortalizaLabPanelController cultivoLabPanelController = new HortalizaLabPanelController(fertilizacionLabFrame.fertilizacionLabPanel1.cultivoLabPanel2, null);
        //RendimientoLabPanelController rendimientoLabPanelController = new RendimientoLabPanelController(fertilizacionLabFrame.fertilizacionLabPanel1.rendimientoLabPanel1, null);
        //TexturaLabPanelController texturaLabPanelController =new TexturaLabPanelController(fertilizacionLabFrame.fertilizacionLabPanel1.texturaLabPanel1, null);
        //NutrientesLabPanelController nutrientesLabPanelController =new NutrientesLabPanelController(fertilizacionLabFrame.fertilizacionLabPanel1.nutrientesLabPanel1, null);
        //PHLabPanelController pHLabPanelController=new PHLabPanelController(fertilizacionLabFrame.fertilizacionLabPanel1.pHLabPanel1, null);
        //MOLabPanelController mOLabPanelController=new MOLabPanelController(fertilizacionLabFrame.fertilizacionLabPanel1.mOLabPanel1, null);
        fertilizacionLabFrame.setVisible(true);
    }

    public static void main(String args[]) {

        FertilizacionLabFrame fertilizacionLabFrame = new FertilizacionLabFrame();
        FertilizacionLabFrameController fertilizacionLabFrameController = new FertilizacionLabFrameController(fertilizacionLabFrame);
        
        FertilizacionLabPanel fertilizacionLabPanel=fertilizacionLabFrame.fertilizacionLabPanel1;
        FertilizacionLabPanelController fertilizacionLabPanelController1= new FertilizacionLabPanelController(fertilizacionLabPanel);
    }
}
