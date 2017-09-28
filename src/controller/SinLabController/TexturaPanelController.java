/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.SinLabController;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.text.DefaultFormatter;
import model.Textura;
import view.sinLabView.TexturaPanel;

/**
 *
 * @author Erlinda
 */
public class TexturaPanelController {

    TexturaPanel texturaPanel;
    Textura textura;

    public TexturaPanelController(TexturaPanel texturaPanel, Textura textura) {
        this.texturaPanel = texturaPanel;
        this.textura = textura;
        confTexturaPanel();
        mostrarExplicacionTextura();
        mostrarExplicacionProfundArena();
        mostrarExplicacionProfundLimo();
        mostrarExplicacionProfundArcilla();
        mostrarExplicacionProfundTotal();
    }

    public void confTexturaPanel() {
        confSpinnerArena();
        confSpinnerLimo();
        confSpinnerArcilla();
        confSpinnerTotalTextura();
    }

    public void confSpinnerArena() {
        JSpinner spinnerArena = this.texturaPanel.jSpinnerArena;
        SpinnerNumberModel modelArena = new SpinnerNumberModel();
        modelArena.setMinimum(0.00);
        modelArena.setMaximum(5.00);
        modelArena.setValue(2.50);
        modelArena.setStepSize(((double) 0.1));
        spinnerArena.setModel(modelArena);
        JSpinner.NumberEditor editorArena = (JSpinner.NumberEditor) spinnerArena.getEditor();
        DecimalFormat formatArena = editorArena.getFormat();
        formatArena.setMinimumFractionDigits(1);
        DefaultFormatter formatter = (DefaultFormatter) editorArena.getTextField().getFormatter();
        formatter.setAllowsInvalid(false);
        editorArena.getTextField().setHorizontalAlignment(SwingConstants.CENTER);
    }

    public void confSpinnerLimo() {
        JSpinner spinnerLimo = this.texturaPanel.jSpinnerLimo;
        SpinnerNumberModel modelLimo = new SpinnerNumberModel();
        modelLimo.setMinimum(0.00);
        modelLimo.setMaximum(5.00);
        modelLimo.setValue(1.50);
        modelLimo.setStepSize(((double) 0.1));
        spinnerLimo.setModel(modelLimo);
        JSpinner.NumberEditor editorLimo = (JSpinner.NumberEditor) spinnerLimo.getEditor();
        DecimalFormat formatLimo = editorLimo.getFormat();
        formatLimo.setMinimumFractionDigits(1);
        DefaultFormatter formatter = (DefaultFormatter) editorLimo.getTextField().getFormatter();
        formatter.setAllowsInvalid(false);
        editorLimo.getTextField().setHorizontalAlignment(SwingConstants.CENTER);
    }

    public void confSpinnerArcilla() {
        JSpinner spinnerArcilla = this.texturaPanel.jSpinnerArcilla;
        SpinnerNumberModel modelArcilla = new SpinnerNumberModel();
        modelArcilla.setMinimum(0.00);
        modelArcilla.setMaximum(5.00);
        modelArcilla.setValue(1.00);
        modelArcilla.setStepSize(((double) 0.1));
        spinnerArcilla.setModel(modelArcilla);
        JSpinner.NumberEditor editorArcilla = (JSpinner.NumberEditor) spinnerArcilla.getEditor();
        DecimalFormat formatArcilla = editorArcilla.getFormat();
        formatArcilla.setMinimumFractionDigits(1);
        DefaultFormatter formatter = (DefaultFormatter) editorArcilla.getTextField().getFormatter();
        formatter.setAllowsInvalid(false);
        editorArcilla.getTextField().setHorizontalAlignment(SwingConstants.CENTER);
    }

    public void confSpinnerTotalTextura() {
        JSpinner spinnerTotalTextura = this.texturaPanel.jSpinnerTexturaTotal;
        SpinnerNumberModel modelTotalTextura = new SpinnerNumberModel();
        modelTotalTextura.setMinimum(0.00);
        modelTotalTextura.setMaximum(15.00);
        modelTotalTextura.setValue(5.00);
        modelTotalTextura.setStepSize(((double) 0.1));
        spinnerTotalTextura.setModel(modelTotalTextura);
        JSpinner.NumberEditor editorTotalTextura = (JSpinner.NumberEditor) spinnerTotalTextura.getEditor();
        DecimalFormat formatTotalTextura = editorTotalTextura.getFormat();
        formatTotalTextura.setMinimumFractionDigits(1);
        DefaultFormatter formatter = (DefaultFormatter) editorTotalTextura.getTextField().getFormatter();
        formatter.setAllowsInvalid(false);
        editorTotalTextura.getTextField().setHorizontalAlignment(SwingConstants.CENTER);
    }

    public void llenarDatosModelo() {
        Double texturaArena = Double.parseDouble(this.texturaPanel.jSpinnerArena.getValue().toString());
        Double texturaLimo = Double.parseDouble(this.texturaPanel.jSpinnerLimo.getValue().toString());
        Double texturaArcilla = Double.parseDouble(this.texturaPanel.jSpinnerArcilla.getValue().toString());
        double sumaPorcentaje = texturaArena + texturaLimo + texturaArcilla;

        double porcentajeArena = (texturaArena * 100) / sumaPorcentaje;
        textura.setTexturaArena(porcentajeArena);
        double porcentajeLimo = (texturaLimo * 100) / sumaPorcentaje;
        textura.setTexturaLimo(porcentajeLimo);
        double porcentajeArcilla = (texturaArcilla * 100) / sumaPorcentaje;
        textura.setTexturaArcilla(porcentajeArcilla);

    }

    public void mostrarExplicacionTextura() {
        texturaPanel.jLabelPreguntaTextura.setToolTipText("<html><body><p align='justify'>Ingrese los valores calculados con la prueba de la botella  <br>para realizar una correcta Recomendación de Fertilización</html></body>");
        texturaPanel.jLabelPreguntaTextura.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jLabelPreguntaTexturaMouseEntered(evt);
            }
        });
    }

    public void jLabelPreguntaTexturaMouseEntered(MouseEvent evt) {
        texturaPanel.jLabelPreguntaTextura.getToolTipText();
    }
    public void mostrarExplicacionProfundArena() {
        texturaPanel.jLabelProfundidadArena.setToolTipText("<html><body><p align='justify'>Ingrese el valor medido de la profundidad de la Arena <br>de las particulas grandes de la parte inferior de la botella</html></body>");
        texturaPanel.jLabelProfundidadArena.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jLabelProfundidadArenaMouseEntered(evt);
            }
        });
    }

    public void jLabelProfundidadArenaMouseEntered(MouseEvent evt) {
        texturaPanel.jLabelProfundidadArena.getToolTipText();
    }
    public void mostrarExplicacionProfundLimo() {
        texturaPanel.jLabelProfundidadLimo.setToolTipText("<html><body><p align='justify'>Ingrese el valor medido de la profundidad de Limo <br>de las particulas medianas de la parte central de la botella</html></body>");
        texturaPanel.jLabelProfundidadLimo.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jLabelProfundidadLimoMouseEntered(evt);
            }
        });
    }

    public void jLabelProfundidadLimoMouseEntered(MouseEvent evt) {
        texturaPanel.jLabelProfundidadLimo.getToolTipText();
    }
    public void mostrarExplicacionProfundArcilla() {
        texturaPanel.jLabelProfundidadArcilla.setToolTipText("<html><body><p align='justify'>Ingrese el valor medido de la profundidad de la Arcilla <br>de las particulas mas finas de la parte superior de la botella</html></body>");
        texturaPanel.jLabelProfundidadArcilla.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jLabelProfundidadArcillaMouseEntered(evt);
            }
        });
    }

    public void jLabelProfundidadArcillaMouseEntered(MouseEvent evt) {
        texturaPanel.jLabelProfundidadArcilla.getToolTipText();
    }
    public void mostrarExplicacionProfundTotal() {
        texturaPanel.jLabelTexturaTotal.setToolTipText("<html><body><p align='justify'>Ingrese el valor medido de la profundidad total de la botella</html></body>");
        texturaPanel.jLabelTexturaTotal.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jLabelTexturaTotalMouseEntered(evt);
            }
        });
    }

    public void jLabelTexturaTotalMouseEntered(MouseEvent evt) {
        texturaPanel.jLabelTexturaTotal.getToolTipText();
    }
}
