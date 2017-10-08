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
import view.FertilizacionCultivoCompletoLabFrame;
import view.CultivoCompletoLabPanel;
import view.ResultadosConLabPanel;
import view.sinLabView.FertilizacionSinLabFrame;
import controller.SinLabController.FertilizacionSinLabFrameController;
import view.sinLabView.FertilizacionSinLabPanel;
import controller.SinLabController.FertilizacionSinLabPanelController;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import view.ConLabView.FertilizacionLabFrameController;
import view.ConLabView.FertilizacionLabFrame;
import view.ConLabView.FertilizacionLabPanel;
import view.ConLabView.FertilizacionLabPanelController;

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
        confButtonFertilizacionConLab();
        
        confButtonOpcionesAvanzadas();

        vistaBienvenida.bienvenidaPanel1.jButtonFertilizacionConLaboratorio.setVisible(false);
        vistaBienvenida.setResizable(false);
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
                ButtonFertilizacionConLaboratorioActionPerformed(evt);
            }
        });
    }
    //

    public void confButtonFertilizacionConLab() {
        vistaBienvenida.bienvenidaPanel1.jButtonIniciarFertilizacionConLab.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                ButtonFertilizacionConLabActionPerformed(evt);
            }
        });

        vistaBienvenida.bienvenidaPanel1.jButtonIniciarFertilizacionConLab.setToolTipText("<html><body><p align='justify'>Si cuenta con los resultados del <br>laboratorio del analisis del suelo <br><b>Haga clic Aqui</b></html></body>");
        vistaBienvenida.bienvenidaPanel1.jButtonIniciarFertilizacionConLab.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jButtonIniciarFertilizacionConLabMouseEntered(evt);
            }
        });
    }

    public void jButtonIniciarFertilizacionConLabMouseEntered(MouseEvent evt) {
        vistaBienvenida.bienvenidaPanel1.jButtonIniciarFertilizacionConLab.getToolTipText();
    }
    ///

    public void confButtonFertilizacionSinLaboratorio() {
        vistaBienvenida.bienvenidaPanel1.jButtonFertilizacionSinLaboratorio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                ButtonFertilizacionSinLabActionPerformed(evt);
            }
        });
        vistaBienvenida.bienvenidaPanel1.jButtonFertilizacionSinLaboratorio.setToolTipText("<html><body><p align='justify'>Si NO cuenta con los resultados del <br>laboratorio del analisis del suelo <br><b>Haga clic Aqui</b></html></body>");
        vistaBienvenida.bienvenidaPanel1.jButtonFertilizacionSinLaboratorio.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jButtonFertilizacionSinLaboratorioMouseEntered(evt);
            }
        });
    }

    public void jButtonFertilizacionSinLaboratorioMouseEntered(MouseEvent evt) {
        vistaBienvenida.bienvenidaPanel1.jButtonFertilizacionSinLaboratorio.getToolTipText();
    }

    public void confButtonConceptosBasicos() {
        vistaBienvenida.bienvenidaPanel1.jButtonConceptosBasicos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                ButtonConceptosBasicosActionPerformed(evt);
            }
        });
        vistaBienvenida.bienvenidaPanel1.jButtonConceptosBasicos.setToolTipText("<html><body><p align='justify'>Conceptos sobre hortalizas, textura, <br>nutrientes y muestreo de suelos </html></body>");
        vistaBienvenida.bienvenidaPanel1.jButtonConceptosBasicos.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jButtonConceptosBasicosMouseEntered(evt);
            }
        });
    }

    public void jButtonConceptosBasicosMouseEntered(MouseEvent evt) {
        vistaBienvenida.bienvenidaPanel1.jButtonConceptosBasicos.getToolTipText();
    }

    public void confButtonSalir() {
        vistaBienvenida.bienvenidaPanel1.jButtonSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                buttonSalirActionPerformed(evt);
            }
        });
    }

    private void ButtonFertilizacionConLaboratorioActionPerformed(java.awt.event.ActionEvent evt) {
        FertilizacionCultivoCompletoLabFrame fertilizacionConLabFrame = new FertilizacionCultivoCompletoLabFrame();
        FertilizacionCultivoCompletoLabFrameController fertilizacionConLabFrameController = new FertilizacionCultivoCompletoLabFrameController(fertilizacionConLabFrame);

        ResultadosConLabPanel resultadosConLabPanel = fertilizacionConLabFrame.getResultadosConLabPanel1();
        ResultadosConLabPanelController resultadosConLabPanelController = new ResultadosConLabPanelController(resultadosConLabPanel);

        CultivoCompletoLabPanel fertilizacionConLabPanel = fertilizacionConLabFrame.getFertilizacionConLabPanel1();
        CultivoCompletoLabPanelController fertilizacionConLabPanelController = new CultivoCompletoLabPanelController(fertilizacionConLabPanel, resultadosConLabPanelController, fertilizacionConLabFrame.getjTabbedPaneNavegacion());

    }
    ////

    private void ButtonFertilizacionConLabActionPerformed(java.awt.event.ActionEvent evt) {
        FertilizacionLabFrame fertilizacionLabFrame = new FertilizacionLabFrame();
        FertilizacionLabFrameController fertilizacionLabFrameController = new FertilizacionLabFrameController(fertilizacionLabFrame);

        //fertilizacionLabFrame.getFertilizacionLabPanel1();
        FertilizacionLabPanel fertilizacionLabPanel = fertilizacionLabFrame.getFertilizacionLabPanel1();
        FertilizacionLabPanelController fertilizacionLabPanelController = new FertilizacionLabPanelController(fertilizacionLabPanel);
    }
    ///

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
        vistaBienvenida.bienvenidaPanel1.getjLabelfertiConLabDescripcion().setText("<html><body><b>Fertilizacion de Hortalizas</b><br> <br><b>SI cuenta</b> con los resultados de laboratorio de suelos del analisis de suelo de su terreno <b> Inicie con la fertilizacion en el Boton Izquierdo.</b> </body></html>");

        vistaBienvenida.bienvenidaPanel1.getjLabelfertiConLabImg().setToolTipText("<html><body><p align='justify'>Debe mandar su muestra de suelo a un<br> laboratorio de suelos para realizar la <br>fertilizacion con los resultados<br><br>Si no sabe sacar una muestra de suelo<br> vaya al boton <b>Conceptos Basicos y luego a la<br> pestaña Muestreo de Suelo</b></html></body>");
        vistaBienvenida.bienvenidaPanel1.getjLabelfertiConLabImg().addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jLabelfertiConLabImgMouseEntered(evt);
            }
        });
    }

    public void confPanelFertiSinLab() {
        vistaBienvenida.bienvenidaPanel1.getjLabelfertiSinLabImg().setIcon(new ImageIcon(getClass().getResource("/img/kitsanalisis.jpg")));
        vistaBienvenida.bienvenidaPanel1.getjLabelfertiSinLabDescripcion().setText("<html><body><b>Fertilizacion de Hortalizas</b><br> <br>Si<b> NO cuenta </b>con los resultados de laboratorio de suelos del analisis de suelo de su terreno <b> Inicie con la fertilizacion en el Boton Izquierdo.</b> </body></html>");

        vistaBienvenida.bienvenidaPanel1.getjLabelfertiSinLabImg().setToolTipText("<html><body><p align='justify'>Para realizar la fertilizacion sin datos <br>de laboratorio debe contar con la <b>muestra de suelo</b> <br>y los <b> Kits para analisis de suelos</b><br><br>Sino sabe sacar una muestra de suelo <br> vaya al boton <b>Conceptos Basicos y luego a la<br> pestaña Muestreo de Suelo</b></html></body>");
        vistaBienvenida.bienvenidaPanel1.getjLabelfertiSinLabImg().addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jLabelfertiSinLabImgMouseEntered(evt);
            }
        });
    }

    public void jLabelfertiConLabImgMouseEntered(MouseEvent evt) {
        vistaBienvenida.bienvenidaPanel1.getjLabelfertiConLabImg().getToolTipText();
    }

    public void jLabelfertiSinLabImgMouseEntered(MouseEvent evt) {
        vistaBienvenida.bienvenidaPanel1.getjLabelfertiSinLabImg().getToolTipText();
    }

    public void confButtonOpcionesAvanzadas() {
        vistaBienvenida.bienvenidaPanel1.jButtonOpcionesAvanzadas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                ButtonOpcionesAvanzadasActionPerformed(evt);
            }
        });
    }

    private void ButtonOpcionesAvanzadasActionPerformed(java.awt.event.ActionEvent evt) {
       LoginJFrame loginJFrame= new LoginJFrame();
       LoginJFrameController loginJFrameController = new LoginJFrameController(loginJFrame);
    }
}
