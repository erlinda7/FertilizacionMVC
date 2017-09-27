/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.SinLabController;

import java.awt.Image;
import javax.swing.ImageIcon;
import model.Cultivo;
import view.sinLabView.FertilizacionSinLabFrame;

/**
 *
 * @author Erlinda
 */
public class FertilizacionSinLabFrameController {

    FertilizacionSinLabFrame fertilizacionSinLabFrame;
    Cultivo cultivo;

    public FertilizacionSinLabFrameController(FertilizacionSinLabFrame fertilizacionSinLabFrame) {
        this.fertilizacionSinLabFrame = fertilizacionSinLabFrame;
        this.fertilizacionSinLabFrame.setVisible(true);
        this.fertilizacionSinLabFrame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        this.fertilizacionSinLabFrame.setLocationRelativeTo(null);
        fertilizacionSinLabFrame.setResizable(false);
        confFrameFertiSinLab();
    }

    public void confFrameFertiSinLab() {
        fertilizacionSinLabFrame.setTitle("Recomendación de Fertilización de Hortalizas");
        fertilizacionSinLabFrame.setLocationRelativeTo(null);
        Image icon = new ImageIcon(getClass().getResource("/img/icon1.png")).getImage();
        fertilizacionSinLabFrame.setIconImage(icon);
    }

}
