/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EdicionReglas;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import org.apache.tools.ant.taskdefs.Nice;

/**
 *
 * @author Erlinda
 */
public class OpcionesAvanzadasPanelController {

    OpcionesAvanzadasPanel opcionesAvanzadasPanel;
    NitrogenoEdicionReglasPanel nitrogenoEdicionReglasPanel;
    NitrogenoEdicionReglasPanelController nitrogenoEdicionReglasPanelController;
    FosforoEdicionReglasPanel fosforoEdicionReglasPanel;
    FosforoEdicionReglasPanelController fosforoEdicionReglasPanelController;
    PotasioEdicionReglasPanel potasioEdicionReglasPanel;
    PotasioEdicionReglasPanelController potasioEdicionReglasPanelController;
    MOEdicionReglasPanel mOEdicionReglasPanel;
    MOEdicionReglasPanelController mOEdicionReglasPanelController;
    PHEdicionReglasPanel pHEdicionReglasPanel;
    PHEdicionReglasPanelController pHEdicionReglasPanelController;

    public OpcionesAvanzadasPanelController(OpcionesAvanzadasPanel opcionesAvanzadasPanel) {
        this.opcionesAvanzadasPanel = opcionesAvanzadasPanel;

        confButtonEdicionNitrogeno();
        confButtonEdicionFosforo();
        confButtonEdicionPotasio();
        confButtonEdicionMO();
        confButtonEdicionPH();
        inicializarPanelesEdicion();

        // opcionesAvanzadasPanel.jPanelContenedorEdicion.setBackground(Color.red);
    }

    public void inicializarPanelesEdicion() {
        nitrogenoEdicionReglasPanel = new NitrogenoEdicionReglasPanel();
        nitrogenoEdicionReglasPanelController = new NitrogenoEdicionReglasPanelController(nitrogenoEdicionReglasPanel);
        fosforoEdicionReglasPanel = new FosforoEdicionReglasPanel();
        fosforoEdicionReglasPanelController = new FosforoEdicionReglasPanelController(fosforoEdicionReglasPanel);
        potasioEdicionReglasPanel = new PotasioEdicionReglasPanel();
        potasioEdicionReglasPanelController = new PotasioEdicionReglasPanelController(potasioEdicionReglasPanel);
        mOEdicionReglasPanel = new MOEdicionReglasPanel();
        mOEdicionReglasPanelController = new MOEdicionReglasPanelController(mOEdicionReglasPanel);
        pHEdicionReglasPanel = new PHEdicionReglasPanel();
        pHEdicionReglasPanelController = new PHEdicionReglasPanelController(pHEdicionReglasPanel);
    }

    public void confButtonEdicionNitrogeno() {
        opcionesAvanzadasPanel.jButtonEdicionNitrogeno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                ButtonEdicionNitrogenoActionPerformed(evt);
            }
        });
    }

    private void ButtonEdicionNitrogenoActionPerformed(java.awt.event.ActionEvent evt) {
        // System.out.println("Soy el boton edicion nitrogeno"); NM,.

        opcionesAvanzadasPanel.jTabbedPaneContenedor.add("Editar Nitrogeno Regla", nitrogenoEdicionReglasPanel);

    }

    public void confButtonEdicionFosforo() {
        opcionesAvanzadasPanel.jButtonEdicionFosforo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                ButtonEdicionFosforoActionPerformed(evt);
            }
        });
    }

    private void ButtonEdicionFosforoActionPerformed(java.awt.event.ActionEvent evt) {
        //System.out.println("Soy el boton edicion fosforo");
        opcionesAvanzadasPanel.jTabbedPaneContenedor.remove(0);
        opcionesAvanzadasPanel.jTabbedPaneContenedor.add("Editar Fosforo Regla", fosforoEdicionReglasPanel);
    }

    public void confButtonEdicionPotasio() {
        opcionesAvanzadasPanel.jButtonEdicionPotasio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                ButtonEdicionPotasioActionPerformed(evt);
            }
        });
    }

    private void ButtonEdicionPotasioActionPerformed(java.awt.event.ActionEvent evt) {
        //System.out.println("Soy el boton edicion potasio");
        opcionesAvanzadasPanel.jTabbedPaneContenedor.remove(0);
        opcionesAvanzadasPanel.jTabbedPaneContenedor.add("Editar Potasio Regla", potasioEdicionReglasPanel);

    }

    public void confButtonEdicionMO() {
        opcionesAvanzadasPanel.jButtonEdicionMO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                ButtonEdicionMOActionPerformed(evt);
            }
        });
    }

    private void ButtonEdicionMOActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("Soy el boton edicion MO");
        opcionesAvanzadasPanel.jTabbedPaneContenedor.remove(0);
        opcionesAvanzadasPanel.jTabbedPaneContenedor.add("Editar Materia Organica Regla", mOEdicionReglasPanel);

    }

    public void confButtonEdicionPH() {
        opcionesAvanzadasPanel.jButtonEdicionPH.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                ButtonEdicionPHActionPerformed(evt);
            }
        });
    }

    private void ButtonEdicionPHActionPerformed(java.awt.event.ActionEvent evt) {
        //System.out.println("Soy el boton edicion PH");
        opcionesAvanzadasPanel.jTabbedPaneContenedor.remove(0);
        opcionesAvanzadasPanel.jTabbedPaneContenedor.add("Editar pH Regla", pHEdicionReglasPanel);

    }
}
