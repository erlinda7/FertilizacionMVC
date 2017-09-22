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
import view.FertilizacionLabFrame;
import view.CultivoCompletoLabPanel;
import view.ResultadosConLabPanel;
import view.sinLabView.FertilizacionSinLabFrame;
import controller.SinLabController.FertilizacionSinLabFrameController;
import view.sinLabView.FertilizacionSinLabPanel;
import controller.SinLabController.FertilizacionSinLabPanelController;

public class BienvenidaFrameController {

    BienvenidaFrame vistaBienvenida;

    public BienvenidaFrameController(BienvenidaFrame vistaBienvenida) {
        this.vistaBienvenida = vistaBienvenida;

        confFrameBienvenida();
        vistaBienvenida.setVisible(true);
        confButtonFertilizacionConLaboratorio();
        confButtonFertilizacionSinLaboratorio();
        confButtonConceptosBasicos();
        confButtonSalir();
        conflabelMensaje();
        confPanelFertiConLab();
        confPanelFertiSinLab();
    }

    public void confFrameBienvenida() {
        vistaBienvenida.setTitle("Recomendación de Fertilización de Hortalizas");
        vistaBienvenida.setLocationRelativeTo(null);
        Image icon = new ImageIcon(getClass().getResource("/img/icon1.png")).getImage();
        vistaBienvenida.setIconImage(icon);
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
        FertilizacionLabFrame fertilizacionConLabFrame = new FertilizacionLabFrame();
        FertilizacionLabFrameController fertilizacionConLabFrameController = new FertilizacionLabFrameController(fertilizacionConLabFrame);

        ResultadosConLabPanel resultadosConLabPanel = fertilizacionConLabFrame.getResultadosConLabPanel1();
        ResultadosConLabPanelController resultadosConLabPanelController = new ResultadosConLabPanelController(resultadosConLabPanel);

        CultivoCompletoLabPanel fertilizacionConLabPanel = fertilizacionConLabFrame.getFertilizacionConLabPanel1();
        CultivoCompletoLabPanelController fertilizacionConLabPanelController = new CultivoCompletoLabPanelController(fertilizacionConLabPanel, resultadosConLabPanelController, fertilizacionConLabFrame.getjTabbedPaneNavegacion());

    }

    private void ButtonFertilizacionSinLabActionPerformed(java.awt.event.ActionEvent evt) {
        FertilizacionSinLabFrame fertilizacionSinLabFrame = new FertilizacionSinLabFrame();
        FertilizacionSinLabFrameController fertilizacionSinLabFrameController = new FertilizacionSinLabFrameController(fertilizacionSinLabFrame);

        FertilizacionSinLabPanel fertilizacionSinLabPanel = fertilizacionSinLabFrame.getFertilizacionSinLabPanel1();
        FertilizacionSinLabPanelController fertilizacionSinLabPanelController = new FertilizacionSinLabPanelController(fertilizacionSinLabPanel);

    }

    private void ButtonConceptosBasicosActionPerformed(java.awt.event.ActionEvent evt) {
        ConceptosBasicosFrame jFConceptosBasicos = new ConceptosBasicosFrame();
        ConceptosBasicosFrameController controladorConceptosBasicos = new ConceptosBasicosFrameController(jFConceptosBasicos);
        controladorConceptosBasicos.mostrarVista();
    }

    private void buttonSalirActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    ////configurar panel bienvenida
    public void conflabelMensaje() {
        vistaBienvenida.bienvenidaPanel1.jLabelMensaje.setText("<html><body><center>El manejo de los fertilizantes corrige deficiencias de nitrógeno, fósforo y potasio de manera eficaz, contribuyendo \t  para una adecuada producción, calidad y rentabilidad del cultivo.</center></html></body>");
    }

    public void confPanelFertiConLab() {
        vistaBienvenida.bienvenidaPanel1.getjLabelfertiConLabImg().setIcon(new ImageIcon(getClass().getResource("/img/muestrasuelo.jpg")));
        vistaBienvenida.bienvenidaPanel1.getjLabelfertiConLabDescripcion().setText("<html><body><b>Fertilizacion con Analisis de Suelo</b><br>  Debe extraer muestras de suelo de varias partes del terreno a 20 cm profundidad. <br> Mezclar de manera homogenea la muestra. <br> Envie 1 hilo de muestra de suelo al laboratorio de suelos. <br> Con los resultados del laboratorio de suelos<b> inicie con la fertilizacion en el Boton Izquierdo.</b> </body></html>");
    }

    public void confPanelFertiSinLab() {
        vistaBienvenida.bienvenidaPanel1.getjLabelfertiSinLabImg().setIcon(new ImageIcon(getClass().getResource("/img/kitsanalisis.jpg")));
        vistaBienvenida.bienvenidaPanel1.getjLabelfertiSinLabDescripcion().setText("<html><body><b>Fertilizacion sin Analisis de Suelo</b> <br>Tome varias muestras de suelo del terreno y mezclar de manera homogenea. <br> Compre los <b>kits de analisis de suelo</b> <br> Con la muestra de suelo y los kits de analisis <b>inicie con la fertilizacion en el Boton Izquierdo.</b></body></html>");
    }
}
