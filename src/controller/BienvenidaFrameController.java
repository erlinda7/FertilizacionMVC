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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import view.BienvenidaFrame;
import view.ConceptosBasicosFrame;
import view.ConceptosBasicosFrame;
import view.FertilizacionConLabFrame;

import view.FertilizacionConLabPanel;
import view.ResultadosConLabPanel;
import view.BienvenidaPanel;
import view.questionView.FertilizacionSinLabFrame;
import view.questionView.FertilizacionSinLabFrameController;
import view.questionView.FertilizacionSinLabPanel;
import view.questionView.FertilizacionSinLabPanelController;

public class BienvenidaFrameController {

    BienvenidaFrame vistaBienvenida;

    public BienvenidaFrameController(BienvenidaFrame vistaBienvenida) {
        this.vistaBienvenida = vistaBienvenida;

        confFrameBienvenida();
        confLabelTitulo();
        vistaBienvenida.setVisible(true);
        confButtonFertilizacionConLaboratorio();
        confButtonFertilizacionSinLaboratorio();
        confButtonConceptosBasicos();
        confButtonSalir();
    }

    public void confFrameBienvenida() {
        vistaBienvenida.setTitle("Recomendación de Fertilización de Hortalizas");
        vistaBienvenida.setLocationRelativeTo(null);
        Image icon = new ImageIcon(getClass().getResource("/img/icon1.png")).getImage();
        vistaBienvenida.setIconImage(icon);
    }

    public void confLabelTitulo() {
        //   vistaBienvenida.jPBienvenida.jLabelTitulo.setIcon(new ImageIcon(getClass().getResource("/img/tituloBienvenida6.gif")));
//        vistaBienvenida.jPBienvenida.jLabelTExto.setText("<html><body>Bienvenido al Sistema Experto desarrollado para recomendarte una adecuada fertilización de sus hortalizas</html></body>");  
    }

    public void confButtonFertilizacionConLaboratorio() {
        vistaBienvenida.bienvenidaPanel1.jButtonFertilizacionConLaboratorio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                ButtonFertilizacionConLabActionPerformed(evt);
            }
        });
    }

    public void confButtonFertilizacionSinLaboratorio() {
        vistaBienvenida.bienvenidaPanel1.jButtonFertilizacionSinLaboratorio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                ButtonFertilizacionSinLabActionPerformed(evt);
            }
        });
    }

    public void confButtonConceptosBasicos() {
        vistaBienvenida.bienvenidaPanel1.jButtonConceptosBasicos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                ButtonConceptosBasicosActionPerformed(evt);
            }
        });
    }

    public void confButtonSalir() {
        vistaBienvenida.bienvenidaPanel1.jButtonSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                buttonSalirActionPerformed(evt);
            }
        });
    }

    private void ButtonFertilizacionConLabActionPerformed(java.awt.event.ActionEvent evt) {
        FertilizacionConLabFrame fertilizacionConLabFrame = new FertilizacionConLabFrame();
        FertilizacionConLabFrameController fertilizacionConLabFrameController = new FertilizacionConLabFrameController(fertilizacionConLabFrame);

        ResultadosConLabPanel resultadosConLabPanel = fertilizacionConLabFrame.getResultadosConLabPanel1();
        ResultadosConLabPanelController resultadosConLabPanelController = new ResultadosConLabPanelController(resultadosConLabPanel);

        FertilizacionConLabPanel fertilizacionConLabPanel = fertilizacionConLabFrame.getFertilizacionConLabPanel1();
        FertilizacionConLabPanelController fertilizacionConLabPanelController = new FertilizacionConLabPanelController(fertilizacionConLabPanel, resultadosConLabPanelController, fertilizacionConLabFrame.getjTabbedPaneNavegacion());

    }

    private void ButtonFertilizacionSinLabActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("hola");
        FertilizacionSinLabFrame fertilizacionSinLabFrame = new FertilizacionSinLabFrame();
        FertilizacionSinLabFrameController fertilizacionSinLabFrameController = new FertilizacionSinLabFrameController(fertilizacionSinLabFrame);

        FertilizacionSinLabPanel fertilizacionSinLabPanel = fertilizacionSinLabFrame.getFertilizacionSinLabPanel1();
        FertilizacionSinLabPanelController fertilizacionSinLabPanelController = new FertilizacionSinLabPanelController(fertilizacionSinLabPanel);

    }

    private void ButtonConceptosBasicosActionPerformed(java.awt.event.ActionEvent evt) {
        //System.out.println("hola 333");
        ConceptosBasicosFrame jFConceptosBasicos = new ConceptosBasicosFrame();
        ConceptosBasicosFrameController controladorConceptosBasicos = new ConceptosBasicosFrameController(jFConceptosBasicos);
        controladorConceptosBasicos.mostrarVista();
    }

    private void buttonSalirActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    /*  public static void main(String[] args) {
        JFBienvenida jFBienvenida = new JFBienvenida();
        BienvenidaController controladorBienvenida = new BienvenidaController(jFBienvenida);

    }*/
}
