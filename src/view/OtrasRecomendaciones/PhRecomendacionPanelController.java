/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.OtrasRecomendaciones;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
        mosrtrarExplicacion();
    }

    public void mostrarRecomendacionPh(Cultivo cultivo) {
        //capturar de cultivo nivelPh, tiposuelo
        double nivelpH = cultivo.getNivelpH();
        String tipoSuelo = cultivo.getTipoSuelo();
        if (nivelpH < 6.5) {
            phRecomendacionPanel.nivelPhLabel.setText("<html><body><p align='justify'>" + "El nivel de pH en el suelo es ' " + nivelpH + " ' por lo cual el suelo es considerada  ' " + tipoSuelo + " ' </body></html>");
            phRecomendacionPanel.explicacionPhLabel.setText("<html><body><p align='justify'>Para subir el nivel de pH de su suelo puede aplicar cal al suelo.</body></html>");
            phRecomendacionPanel.correcionPhDescripcionLabel.setText("<html><body><p align='justify'>La cal agrícola es conocida por su determinante función de <b>reducir la acidez</b>, modifica eficientemente las propiedades físicas y químicas del suelo. <br>Las bondades del encalado se ven recién después del primer año de uso y llega a su plenitud al tercer y cuarto años."
                    + " La cal agrícola se presenta en forma de polvo de diferentes granulaciones."
                    + " <br>Lo ideal es aplicar con tres meses de anticipacion a la siembra. La cal agrícola puede aplicarse al voleo con herramientas manuales que tenga el productor, luego pasando una rastra para facilitar su mezcla y acción correctora. </body></html>");
            phRecomendacionPanel.correcionPhImgLabel.setIcon(new ImageIcon(getClass().getResource("/img/recomendacionesSecundarias/encalado1.jpg")));
            phRecomendacionPanel.ImgProductoLabel.setIcon(new ImageIcon(getClass().getResource("/img/recomendacionesSecundarias/cal2.jpg")));
        }
        if (nivelpH > 7.5) {
            phRecomendacionPanel.nivelPhLabel.setText("<html><body><p align='justify'>" + "El nivel de pH en el suelo es ' " + nivelpH + " ' por lo cual el suelo es considerada  ' " + tipoSuelo + " ' </body></html>");
            phRecomendacionPanel.explicacionPhLabel.setText("<html><body><p align='justify'>Para bajar el nivel de pH de su suelo puede aplicar azufre al suelo.</body></html>");
            phRecomendacionPanel.correcionPhDescripcionLabel.setText("<html><body><p align='justify'>El azufre en polvo es conocida por su determinante función <b>de reducir la alcalinidad</b>, aunque su influencia puede llegar a modificar eficientemente las propiedades físicas y químicas del suelo."
                    + " Las bondades del azufrado se ven recién después del primer año de uso"
                    + " Lo ideal es aplicar con cuatro meses de anticipacion a la siembra. El azufre en polvo se aplica al voleo con herramientas manuales que tenga el productor. Conviene incorporarlo al suelo, pasando una rastra para facilitar su mezcla y acción correctora.</body></html>");
            phRecomendacionPanel.ImgProductoLabel.setIcon(new ImageIcon(getClass().getResource("/img/recomendacionesSecundarias/azufre.jpg")));
            phRecomendacionPanel.correcionPhImgLabel.setIcon(new ImageIcon(getClass().getResource("/img/recomendacionesSecundarias/azufrado2.jpg")));
        }
        if (nivelpH >= 6.5 && nivelpH <= 7.5) {
            phRecomendacionPanel.nivelPhLabel.setText("<html><body><p align='justify'>" + "El nivel de pH en el suelo es ' " + nivelpH + " ' por lo cual el suelo es considerada  ' " + tipoSuelo + " ' </body></html>");
            phRecomendacionPanel.explicacionPhLabel.setText("<html><body><p align='justify'>No necesita realizar correcciones de pH de su suelo.</body></html>");
            phRecomendacionPanel.correcionPhDescripcionLabel.setText("<html><body><p align='justify'>Un suelo neutro es bondadoso con los nutrientes necesarios para la producción de hortalizas</body></html>");
            phRecomendacionPanel.ImgProductoLabel.setIcon(new ImageIcon(getClass().getResource("/img/recomendacionesSecundarias/ph1.jpg")));
            phRecomendacionPanel.correcionPhImgLabel.setIcon(new ImageIcon(getClass().getResource("/img/recomendacionesSecundarias/phImagen.jpg")));
        }

    }

    public void mosrtrarExplicacion() {
        phRecomendacionPanel.correcionPhImgLabel.setToolTipText("<html><body><p align='justify'>Se debe aplicar sobre el terreno , y debe ser <br>mesclado con la tierra a 15 cm de profundidad ya sea <br>a traves del arado o manualmente</html></body>");
        phRecomendacionPanel.correcionPhImgLabel.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                correcionPhImgLabelMouseEntered(evt);
            }
        });
    }

    public void correcionPhImgLabelMouseEntered(MouseEvent evt) {
        phRecomendacionPanel.correcionPhImgLabel.getToolTipText();
    }
}
