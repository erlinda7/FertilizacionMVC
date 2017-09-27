/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import view.MuestreoSuelosPanel;
/**
 *
 * @author Erlinda
 */
public class MuestreosuelosPanelController {
    MuestreoSuelosPanel  muestreoSuelosPanel;

    public MuestreosuelosPanelController(MuestreoSuelosPanel muestreoSuelosPanel) {
        this.muestreoSuelosPanel = muestreoSuelosPanel;
        confVistaMuestreoSuelo();
    }
    
    public void confVistaMuestreoSuelo(){
    muestreoSuelosPanel.jLabelMuestreo.setText("Proceso de muestreo +++++....");
    }
    
    
}
