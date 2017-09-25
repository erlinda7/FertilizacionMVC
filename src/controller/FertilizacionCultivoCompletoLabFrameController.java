/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Image;
import javax.swing.ImageIcon;
import view.FertilizacionCultivoCompletoLabFrame;

/**
 *
 * @author Erlinda
 */
public class FertilizacionCultivoCompletoLabFrameController {

    FertilizacionCultivoCompletoLabFrame fertilizacionConLabFrame;

    public FertilizacionCultivoCompletoLabFrameController(FertilizacionCultivoCompletoLabFrame fertilizacionConLabFrame) {
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
