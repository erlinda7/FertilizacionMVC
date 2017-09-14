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
import view.ConceptosBasicosFrame;
import view.DocumentacionPanel;
import view.InterpretacionPanel;

public class ConceptosBasicosFrameController {

    ConceptosBasicosFrame jFConceptosBasicos;

    public ConceptosBasicosFrameController(ConceptosBasicosFrame jFConceptosBasicos) {
        this.jFConceptosBasicos = jFConceptosBasicos;
        InterpretacionPanel jPInterpretacion = jFConceptosBasicos.getInterpretacionPanel1();
        InterpretacionPanelController controladorInterpretacion = new InterpretacionPanelController(jPInterpretacion);

        DocumentacionPanel jPDocumentacion = jFConceptosBasicos.getDocumentacionPanel1();
        DocumentacionPanelController controladorDocumentacion = new DocumentacionPanelController(jPDocumentacion);
        this.jFConceptosBasicos.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        this.jFConceptosBasicos.setLocationRelativeTo(null);

    }

    public void ocultarVista() {
        this.jFConceptosBasicos.setVisible(false);
    }

    public void mostrarVista() {
        this.jFConceptosBasicos.setVisible(true);
    }
}
