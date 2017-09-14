/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Image;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import model.Hortaliza;
//import model.InformacionProyecto;
import view.FertilizacionConLabFrame;

/**
 *
 * @author Erlinda
 */
public class FertilizacionConLabFrameController {

    FertilizacionConLabFrame vistaPrincipal;

    public FertilizacionConLabFrameController(FertilizacionConLabFrame vistaPrincipal) {
        this.vistaPrincipal = vistaPrincipal;
        confFramePrincipal();
        this.vistaPrincipal.setVisible(true);
        this.vistaPrincipal.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        this.vistaPrincipal.setLocationRelativeTo(null);
    }

    public void confFramePrincipal() {
        vistaPrincipal.setTitle("Recomendación de Fertilización de Hortalizas");
        vistaPrincipal.setLocationRelativeTo(null);
        Image icon = new ImageIcon(getClass().getResource("/img/icon1.png")).getImage();
        vistaPrincipal.setIconImage(icon);
    }
}
