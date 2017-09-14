/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.questionView;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.DefaultFormatter;
//import model.Cultivo;
import model.Textura;
import static org.dmg.pmml.pmml_4_2.descr.LINKFUNCTION.LOG;

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
    }

    public void confTexturaPanel() {
        confTexturaLabel();
        confSpinnerArena();
        confSpinnerLimo();
        confSpinnerArcilla();
        confSpinnerTotalTextura();
    }

    public void confTexturaLabel() {
        texturaPanel.jLabelTextura.setIcon(new ImageIcon(getClass().getResource("/img/fondoLabelTextura.jpg")));
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
        editorArcilla.getTextField().setHorizontalAlignment(SwingConstants.CENTER);

        JComponent comp = spinnerArcilla.getEditor();
        JFormattedTextField field = (JFormattedTextField) comp.getComponent(0);
        DefaultFormatter formatter = (DefaultFormatter) field.getFormatter();
        formatter.setCommitsOnValidEdit(true);
        spinnerArcilla.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                System.out.println(".stateChanged()"+spinnerArcilla.getValue());
                
            }

            
        });
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
    
}
