/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.ConLabView;

import java.awt.Color;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import model.Textura;

/**
 *
 * @author Erlinda
 */
public class TexturaLabPanelController {

    TexturaLabPanel texturaLabPanel;
    Textura textura;
    private int sumaPorcentaje = 100;

    public TexturaLabPanelController(TexturaLabPanel texturaLabPanel, Textura textura) {
        this.texturaLabPanel = texturaLabPanel;
        this.textura = textura;
        confSliderArenaLab();
        confSliderLimoLab();
        confSliderArcilla();
        
        //buton test
        
        texturaLabPanel.jButtonTestTextura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                llenarDatosModelo();
            }
        });
        //
    }

    public void confSliderArenaLab() {
        JSlider sliderArena = this.texturaLabPanel.jSliderArenaLab;
        sliderArena.setOpaque(false);
        sliderArena.setMinimum(0);
        sliderArena.setMaximum(100);
        sliderArena.setMajorTickSpacing(5);
        sliderArena.setMinorTickSpacing(1);
        sliderArena.setPaintLabels(true);
        sliderArena.setPaintTicks(true);
        sliderArena.setValue(50);

        sliderArena.addChangeListener(new javax.swing.event.ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent evt) {
                jSliderArenaLabChanged(evt);
            }
        });
    }

    public void confSliderLimoLab() {
        JSlider sliderLimo = this.texturaLabPanel.jSliderLimoLab;
        sliderLimo.setOpaque(false);
        sliderLimo.setMinimum(0);
        sliderLimo.setMaximum(100);
        sliderLimo.setMajorTickSpacing(5);
        sliderLimo.setMinorTickSpacing(1);
        sliderLimo.setPaintLabels(true);
        sliderLimo.setPaintTicks(true);
        sliderLimo.setValue(30);

        sliderLimo.addChangeListener(new javax.swing.event.ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent evt) {
                jSliderLimoLabChanged(evt);
            }
        });
    }

    public void confSliderArcilla() {
        JSlider sliderArcilla = this.texturaLabPanel.jSliderArcillaLab;
        sliderArcilla.setOpaque(false);
        sliderArcilla.setMinimum(0);
        sliderArcilla.setMaximum(100);
        sliderArcilla.setMajorTickSpacing(5);
        sliderArcilla.setMinorTickSpacing(1);
        sliderArcilla.setPaintLabels(true);
        sliderArcilla.setPaintTicks(true);
        sliderArcilla.setValue(20);

        sliderArcilla.addChangeListener(new javax.swing.event.ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent evt) {
                jSliderArcillaLabChanged(evt);
            }
        });
    }

    private void jSliderArenaLabChanged(javax.swing.event.ChangeEvent evt) {
        sumarSlider();

    }

    private void jSliderLimoLabChanged(javax.swing.event.ChangeEvent evt) {
        sumarSlider();
    }

    private void jSliderArcillaLabChanged(javax.swing.event.ChangeEvent evt) {
        sumarSlider();
    }

    private void sumarSlider() {

        sumaPorcentaje = this.texturaLabPanel.jSliderArenaLab.getValue() + this.texturaLabPanel.jSliderLimoLab.getValue() + this.texturaLabPanel.jSliderArcillaLab.getValue();
        this.texturaLabPanel.jLabelPorctTextura.setText(sumaPorcentaje + "%");
        if (sumaPorcentaje > 100) {
            this.texturaLabPanel.jLabelPorctTextura.setBackground(Color.RED);
        } else {
            if (sumaPorcentaje < 100) {
                this.texturaLabPanel.jLabelPorctTextura.setBackground(Color.yellow);
            } else {
                this.texturaLabPanel.jLabelPorctTextura.setBackground(Color.green);
            }
        }
    }

    public void llenarDatosModelo() {
        Integer porcentajeTexturaArena = this.texturaLabPanel.jSliderArenaLab.getValue();
        textura.setTexturaArena(porcentajeTexturaArena);
      //    System.out.println(porcentajeTexturaArena);
        
          Integer porcentajeTexturaLimo = this.texturaLabPanel.jSliderLimoLab.getValue();
        textura.setTexturaLimo(porcentajeTexturaLimo);
        //System.out.println(porcentajeTexturaLimo);
        
        Integer porcentajeTexturaArcilla = this.texturaLabPanel.jSliderArcillaLab.getValue();
       textura.setTexturaArcilla(porcentajeTexturaArcilla);
       // System.out.println(porcentajeTexturaArcilla);
    }

}
