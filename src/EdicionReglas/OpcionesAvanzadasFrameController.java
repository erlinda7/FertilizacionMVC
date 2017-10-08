/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EdicionReglas;

/**
 *
 * @author Erlinda
 */
public class OpcionesAvanzadasFrameController {
    OpcionesAvanzadasFrame opcionesAvanzadasFrame;
    OpcionesAvanzadasPanelController opcionesAvanzadasPanelController;

    public OpcionesAvanzadasFrameController(OpcionesAvanzadasFrame opcionesAvanzadasFrame) {
        this.opcionesAvanzadasFrame = opcionesAvanzadasFrame;      
        mostrarVista();
    }

    
    public void mostrarVista(){
    this.opcionesAvanzadasFrame.setVisible(true);
    }
    
    
}
