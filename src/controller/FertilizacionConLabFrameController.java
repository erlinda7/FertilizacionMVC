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

    FertilizacionConLabFrame fertilizacionConLabFrame;

    public FertilizacionConLabFrameController(FertilizacionConLabFrame fertilizacionConLabFrame) {
        this.fertilizacionConLabFrame = fertilizacionConLabFrame;
        confFramePrincipal();
        this.fertilizacionConLabFrame.setVisible(true);
        this.fertilizacionConLabFrame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        this.fertilizacionConLabFrame.setLocationRelativeTo(null);
    }

    public void confFramePrincipal() {
        fertilizacionConLabFrame.setTitle("Recomendación de Fertilización de Hortalizas");
        fertilizacionConLabFrame.setLocationRelativeTo(null);
        Image icon = new ImageIcon(getClass().getResource("/img/icon1.png")).getImage();
        fertilizacionConLabFrame.setIconImage(icon);
    }
}
