/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.ConLabView;

import com.alee.extended.layout.VerticalFlowLayout;
import com.alee.extended.window.WebPopOver;
import com.alee.laf.label.WebLabel;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
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
    /*PopOvers*/
    final WebPopOver popOverSumTextura = new WebPopOver();
    final WebPopOver popOverArena = new WebPopOver();
    final WebPopOver popOverLimo = new WebPopOver();
    final WebPopOver popOverArcilla = new WebPopOver();

    public TexturaLabPanelController(TexturaLabPanel texturaLabPanel, Textura textura) {
        this.texturaLabPanel = texturaLabPanel;
        this.textura = textura;
        confLabelPorcentaje();
        confLabelArena();
        confSliderArenaLab();
        confLabelLimo();
        confSliderLimoLab();
        confLabelArcilla();
        confSliderArcilla();
        //popover
        confPopOverSumatoriaTextura();
        confPopOverArena();
        confPopOverLimo();
        confPopOverArcilla();
    }

    public void confLabelPorcentaje() {
        this.texturaLabPanel.jLabelPorctTextura.setOpaque(true);
        this.texturaLabPanel.jLabelPorctTextura.setText("100 %");
        this.texturaLabPanel.jLabelPorctTextura.setHorizontalAlignment(texturaLabPanel.jLabelPorctTextura.CENTER);
        this.texturaLabPanel.jLabelPorctTextura.setBackground(Color.green);
        texturaLabPanel.jLabelPorctTextura.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jlabelPorcentajeTexturaMouseEntered(evt);
            }
        });
    }

    public void confLabelArena() {
        texturaLabPanel.jLabelPorcArena.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jlabelArenaMouseEntered(evt);
            }
        });
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

    public void confLabelLimo() {
        texturaLabPanel.jLabelPorcLimo.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jlabelLimoMouseEntered(evt);
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

    public void confLabelArcilla() {
        texturaLabPanel.jLabelPorcArcilla.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jlabelArcillaMouseEntered(evt);
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
        texturaLabPanel.jPanelTexturaImg.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Suelos Arenosos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 11))); 
        texturaLabPanel.jLabelImgTexturaLab1.setIcon(new ImageIcon(getClass().getResource("/img/imgLab/arenaP1.jpg")));
        texturaLabPanel.jLabelImgTexturaLab2.setIcon(new ImageIcon(getClass().getResource("/img/imgLab/arenaP2.jpg")));
        texturaLabPanel.jLabelImgTexturaLab3.setIcon(new ImageIcon(getClass().getResource("/img/imgLab/arenaP3.jpg")));
    }

    private void jSliderLimoLabChanged(javax.swing.event.ChangeEvent evt) {
        sumarSlider();
        texturaLabPanel.jPanelTexturaImg.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Suelos Limosos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 11)));
        texturaLabPanel.jLabelImgTexturaLab1.setIcon(new ImageIcon(getClass().getResource("/img/imgLab/limosoP1.jpg")));
        texturaLabPanel.jLabelImgTexturaLab2.setIcon(new ImageIcon(getClass().getResource("/img/imgLab/limosoP2.jpg")));
        texturaLabPanel.jLabelImgTexturaLab3.setIcon(new ImageIcon(getClass().getResource("/img/imgLab/limosoP3.jpg")));
    }

    private void jSliderArcillaLabChanged(javax.swing.event.ChangeEvent evt) {
        sumarSlider();
        texturaLabPanel.jPanelTexturaImg.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Suelos Arcillosos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 11)));
        texturaLabPanel.jLabelImgTexturaLab1.setIcon(new ImageIcon(getClass().getResource("/img/imgLab/arcillosoP1.jpg")));
        texturaLabPanel.jLabelImgTexturaLab2.setIcon(new ImageIcon(getClass().getResource("/img/imgLab/arcillosoP2.jpg")));
        texturaLabPanel.jLabelImgTexturaLab3.setIcon(new ImageIcon(getClass().getResource("/img/imgLab/arcillosoP3.jpg")));

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

    public void jlabelPorcentajeTexturaMouseEntered(MouseEvent evt) {
        popOverSumTextura.show(texturaLabPanel.jLabelPorctTextura, 50, texturaLabPanel.jLabelPorctTextura.getHeight());
    }

    public void jlabelArenaMouseEntered(MouseEvent evt) {
        popOverArena.show(texturaLabPanel.jLabelPorcArena, 50, texturaLabPanel.jLabelPorcArena.getHeight());
    }

    public void jlabelLimoMouseEntered(MouseEvent evt) {
        popOverLimo.show(texturaLabPanel.jLabelPorcLimo, 50, texturaLabPanel.jLabelPorcLimo.getHeight());
    }

    public void jlabelArcillaMouseEntered(MouseEvent evt) {
        popOverArcilla.show(texturaLabPanel.jLabelPorcArcilla, 50, texturaLabPanel.jLabelPorcArcilla.getHeight());
    }

    ///Popoper
    public void confPopOverSumatoriaTextura() {
        popOverSumTextura.setCloseOnFocusLoss(true);
        popOverSumTextura.setMargin(10);
        popOverSumTextura.setLayout(new VerticalFlowLayout());
        popOverSumTextura.add(new WebLabel("La sumatoria del porcentaje de Textura Arena, Limo y arcilla debe ser igual a 100"));
        popOverSumTextura.add(new WebLabel("El cuadro es Verde si la sumatoria es igual a 100, si es menor cambia a color amarillo"));
        popOverSumTextura.add(new WebLabel("si es mayor a 100 cambia a Rojo"));
    }

    public void confPopOverArena() {
        popOverArena.setCloseOnFocusLoss(true);
        popOverArena.setMargin(10);
        popOverArena.setLayout(new VerticalFlowLayout());
        popOverArena.add(new WebLabel("El porcentaje de Arena en el suelo puede ser variable de 0 a 100,"));
        popOverArena.add(new WebLabel("a mayor porcentaje de arena el suelo filtra el agua rapidamente"));
        JLabel jlabelImgArena = new JLabel();
        jlabelImgArena.setIcon(new ImageIcon(getClass().getResource("/img/arenosaTex.png")));
        popOverArena.add(jlabelImgArena);
    }

    public void confPopOverLimo() {
        popOverLimo.setCloseOnFocusLoss(true);
        popOverLimo.setMargin(10);
        popOverLimo.setLayout(new VerticalFlowLayout());
        popOverLimo.add(new WebLabel("El porcentaje de Limo en el suelo puede ser variable de 0 a 100,"));
        popOverLimo.add(new WebLabel("a mayor porcentaje de limo el suelo filtra el agua con normalidad"));
        JLabel jlabelImgArena = new JLabel();
        jlabelImgArena.setIcon(new ImageIcon(getClass().getResource("/img/limosaTex.png")));
        popOverLimo.add(jlabelImgArena);
    }

    public void confPopOverArcilla() {
        popOverArcilla.setCloseOnFocusLoss(true);
        popOverArcilla.setMargin(10);
        popOverArcilla.setLayout(new VerticalFlowLayout());
        popOverArcilla.add(new WebLabel("El contenido de Arcilla en el suelo puede ser variable de 0 a 100,"));
        popOverArcilla.add(new WebLabel("a mayor porcentaje de arcilla el suelo  no filtra casi el agua"));
        JLabel jlabelImgArena = new JLabel();
        jlabelImgArena.setIcon(new ImageIcon(getClass().getResource("/img/arcillosaTex.png")));
        popOverArcilla.add(jlabelImgArena);
    }
    //
    
}
