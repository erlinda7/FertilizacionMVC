/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author Erlinda
 */
import java.awt.Image;
import javax.swing.ImageIcon;
import view.ConceptosBasicosFrame;
import view.DocumentacionPanel;
import view.InterpretacionPanel;
import view.MuestreoSuelosPanel;

public class ConceptosBasicosFrameController {

    ConceptosBasicosFrame jFConceptosBasicos;

    public ConceptosBasicosFrameController(ConceptosBasicosFrame jFConceptosBasicos) {
        this.jFConceptosBasicos = jFConceptosBasicos;
        InterpretacionPanel jPInterpretacion = jFConceptosBasicos.getInterpretacionPanel1();
        InterpretacionPanelController controladorInterpretacion = new InterpretacionPanelController(jPInterpretacion);

        DocumentacionPanel jPDocumentacion = jFConceptosBasicos.getDocumentacionPanel1();
        DocumentacionPanelController controladorDocumentacion = new DocumentacionPanelController(jPDocumentacion);
       
        MuestreoSuelosPanel muestreoSuelosPanel =jFConceptosBasicos.muestreoSuelosPanel1;
        MuestreosuelosPanelController muestreosuelosPanelController = new MuestreosuelosPanelController(muestreoSuelosPanel);
        
        this.jFConceptosBasicos.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        this.jFConceptosBasicos.setLocationRelativeTo(null);
        jFConceptosBasicos.setResizable(false);
        confFrameConceptosB();
    }

    public void confFrameConceptosB() {
        jFConceptosBasicos.setTitle("Recomendación de Fertilización de Hortalizas");
        jFConceptosBasicos.setLocationRelativeTo(null);
        Image icon = new ImageIcon(getClass().getResource("/img/icon1.png")).getImage();
        jFConceptosBasicos.setIconImage(icon);
    }

    public void ocultarVista() {
        this.jFConceptosBasicos.setVisible(false);
    }

    public void mostrarVista() {
        this.jFConceptosBasicos.setVisible(true);
    }
}
