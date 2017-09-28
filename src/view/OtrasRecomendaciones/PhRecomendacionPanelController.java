/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.OtrasRecomendaciones;

import javax.swing.ImageIcon;
import model.Cultivo;

/**
 *
 * @author Erlinda
 */
public class PhRecomendacionPanelController {

    PhRecomendacionPanel phRecomendacionPanel;

    public PhRecomendacionPanelController(PhRecomendacionPanel phRecomendacionPanel) {
        this.phRecomendacionPanel = phRecomendacionPanel;
       // mostrarRecomendacionPh();
    }

    public void mostrarRecomendacionPh(Cultivo cultivo) {
        //capturar de cultivo nivelPh, tiposuelo
        double nivelpH = cultivo.getNivelpH();
        String tipoSuelo = cultivo.getTipoSuelo();
        if (nivelpH < 6.5) {
            phRecomendacionPanel.nivelPhLabel.setText("<html><body><p align='justify'>" + "El nivel de pH en el suelo es ' " + nivelpH + " ' es considerada  ' " + tipoSuelo + " ' </body></html>");
            phRecomendacionPanel.explicacionPhLabel.setText("<html><body><p align='justify'>Para subir el nivel de pH de su suelo puede aplicar cal al suelo</body></html>");
            phRecomendacionPanel.correcionPhDescripcionLabel.setText("Cal");
            phRecomendacionPanel.correcionPhImgLabel.setIcon(new ImageIcon(getClass().getResource("/img/recomendacionesSecundarias/encalado1.jpg")));
            phRecomendacionPanel.ImgProductoLabel.setIcon(new ImageIcon(getClass().getResource("/img/recomendacionesSecundarias/cal2.jpg")));
        }
        if (nivelpH > 7.5) {
            phRecomendacionPanel.nivelPhLabel.setText("<html><body><p align='justify'>" + "El nivel de pH en el suelo es ' " + nivelpH + " ' es considerada  ' " + tipoSuelo + " ' </body></html>");
            phRecomendacionPanel.explicacionPhLabel.setText("<html><body><p align='justify'>Para bajar el nivel de pH de su suelo puede aplicar azufre al suelo</body></html>");
            phRecomendacionPanel.correcionPhDescripcionLabel.setText("<html><body><p align='justify'>El azufre se aplica esparce sobre el suelo antes de arar.....</body></html>");
            phRecomendacionPanel.ImgProductoLabel.setIcon(new ImageIcon(getClass().getResource("/img/recomendacionesSecundarias/azufre.jpg")));
            phRecomendacionPanel.correcionPhImgLabel.setIcon(new ImageIcon(getClass().getResource("/img/recomendacionesSecundarias/azufrado2.jpg")));
        }
        if (nivelpH >= 6.5 && nivelpH <= 7.5) {
            phRecomendacionPanel.nivelPhLabel.setText("<html><body><p align='justify'>" + "El nivel de pH en el suelo es ' " + nivelpH + " ' es considerada  ' " + tipoSuelo + " ' </body></html>");
            phRecomendacionPanel.explicacionPhLabel.setText("<html><body><p align='justify'>No necesita realizar correcciones de pH de su suelo</body></html>");
            phRecomendacionPanel.correcionPhDescripcionLabel.setText("<html><body><p align='justify'>Un suelo neutro es muy bueno......</body></html>");
            phRecomendacionPanel.ImgProductoLabel.setIcon(new ImageIcon(getClass().getResource("/img/recomendacionesSecundarias/ph1.jpg")));
            phRecomendacionPanel.correcionPhImgLabel.setIcon(new ImageIcon(getClass().getResource("/img/recomendacionesSecundarias/phImagen.jpg")));
        }

    }
}
