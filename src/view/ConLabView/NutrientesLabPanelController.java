/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.ConLabView;

import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.text.DefaultFormatter;
import model.Cultivo;

/**
 *
 * @author Erlinda
 */
public class NutrientesLabPanelController {

    NutrientesLabPanel nutrientesLabPanel;
    Cultivo cultivo;

    public NutrientesLabPanelController(NutrientesLabPanel nutrientesLabPanel, Cultivo cultivo) {
        this.nutrientesLabPanel = nutrientesLabPanel;
        this.cultivo = cultivo;
        confSpinnerNitrogenoLab();
        confSpinerFosforoLab();
        confSpinnerPotasioLab();
        confPanelGaleria();

    }

    public void confSpinnerNitrogenoLab() {
        JSpinner spinnerNitrogeno = this.nutrientesLabPanel.jSpinnerNitrogenoLab;
        SpinnerNumberModel modelNitrogeno = new SpinnerNumberModel(10, 1, 100, 1);
        modelNitrogeno.setMinimum(0);
        modelNitrogeno.setMaximum(100);
        modelNitrogeno.setValue(5);
        modelNitrogeno.setStepSize(((int) 1));
        spinnerNitrogeno.setModel(modelNitrogeno);
        JSpinner.NumberEditor editorNitrogeno = (JSpinner.NumberEditor) spinnerNitrogeno.getEditor();
        DefaultFormatter formatter = (DefaultFormatter) editorNitrogeno.getTextField().getFormatter();
        formatter.setAllowsInvalid(false);
        editorNitrogeno.getTextField().setHorizontalAlignment(SwingConstants.CENTER);
    }

    public void confSpinerFosforoLab() {
        JSpinner spinnerFosforo = this.nutrientesLabPanel.jSpinnerFosforoLab;
        SpinnerNumberModel modelFosforo = new SpinnerNumberModel();
        modelFosforo.setMinimum(0);
        modelFosforo.setMaximum(100);
        modelFosforo.setValue(5);
        modelFosforo.setStepSize(((int) 1));
        spinnerFosforo.setModel(modelFosforo);
        JSpinner.NumberEditor editorFosforo = (JSpinner.NumberEditor) spinnerFosforo.getEditor();
        DefaultFormatter formatter = (DefaultFormatter) editorFosforo.getTextField().getFormatter();
        formatter.setAllowsInvalid(false);
        editorFosforo.getTextField().setHorizontalAlignment(SwingConstants.CENTER);
    }

    public void confSpinnerPotasioLab() {
        JSpinner spinnerPotasio = this.nutrientesLabPanel.jSpinnerPotasioLab;
        SpinnerNumberModel modelPotasio = new SpinnerNumberModel();
        modelPotasio.setMinimum(0);
        modelPotasio.setMaximum(250);
        modelPotasio.setValue(10);
        modelPotasio.setStepSize(((int) 1));
        spinnerPotasio.setModel(modelPotasio);
        JSpinner.NumberEditor editorPotasio = (JSpinner.NumberEditor) spinnerPotasio.getEditor();
        DefaultFormatter formatter = (DefaultFormatter) editorPotasio.getTextField().getFormatter();
        formatter.setAllowsInvalid(false);
        editorPotasio.getTextField().setHorizontalAlignment(SwingConstants.CENTER);
    }

    public void llenarDatosModelo() {
        Integer nitrogenoSuelo = Integer.parseInt(this.nutrientesLabPanel.jSpinnerNitrogenoLab.getValue().toString());
        cultivo.setNivelNitrogeno(nitrogenoSuelo);
        //System.out.println(nitrogenoSuelo);

        Integer fosforoSuelo = Integer.parseInt(this.nutrientesLabPanel.jSpinnerFosforoLab.getValue().toString());
        cultivo.setNivelFosforo(fosforoSuelo);
        //System.out.println(fosforoSuelo);

        Integer potasioSuelo = Integer.parseInt(this.nutrientesLabPanel.jSpinnerPotasioLab.getValue().toString());
        cultivo.setNivelPotasio(potasioSuelo);
        //System.out.println(potasioSuelo);

    }

    public void confPanelGaleria() {

        nutrientesLabPanel.jLabelExNitrogeno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelExNitrogenoMouseClicked(evt);
            }
        });
        nutrientesLabPanel.jLabelDefNitrogeno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelDefNitrogenoMouseClicked(evt);
            }
        });
        nutrientesLabPanel.jLabelExFosforo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelExFosforoMouseClicked(evt);
            }
        });
        nutrientesLabPanel.jLabelDefFosforo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelDefFosforoMouseClicked(evt);
            }
        });
        nutrientesLabPanel.jLabelExPotasio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelExPotasioMouseClicked(evt);
            }
        });
        nutrientesLabPanel.jLabelDefPotasio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelDefPotasioMouseClicked(evt);
            }
        });

    }

    private void jLabelExNitrogenoMouseClicked(java.awt.event.MouseEvent evt) {
        nutrientesLabPanel.jLabelImagenGrande.setIcon(new ImageIcon(getClass().getResource("/img/imgLab/nitrogenoexceso.jpg")));
        nutrientesLabPanel.jPanelImagenGrande.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Exceso de Nitrogeno en el Suelo", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        nutrientesLabPanel.jLabelExplicacion.setText("<html><body><P ALIGN=\"justify\"> Las hojas se tornan verde oscuro.<br><br>El ramillete floral puede presentar hojas, lo que es característico de exceso de vigor de la planta. <br><br>Retrasa en mayor o menor grado la floración. </body></html>");
    }

    private void jLabelDefNitrogenoMouseClicked(java.awt.event.MouseEvent evt) {
        nutrientesLabPanel.jLabelImagenGrande.setIcon(new ImageIcon(getClass().getResource("/img/imgLab/nitrogenoDefG.jpg")));
        nutrientesLabPanel.jPanelImagenGrande.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Deficiencia de Nitrogeno en el Suelo", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        nutrientesLabPanel.jLabelExplicacion.setText("<html><body><P ALIGN=\"justify\"> Cuando existe una deficiencia de N en la planta, se detiene o disminuye el crecimiento de sus órganos.<br><br>Con la deficiencia de este elemento se asocia una coloración verde pálida, que aparece, en primer lugar, en las hojas inferiores, para luego moverse hacia las superiores.</body></html>");
    }

    private void jLabelExFosforoMouseClicked(java.awt.event.MouseEvent evt) {
        nutrientesLabPanel.jLabelImagenGrande.setIcon(new ImageIcon(getClass().getResource("/img/imgLab/fosforo.jpg")));
        nutrientesLabPanel.jPanelImagenGrande.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Exceso de Fosforo en el Suelo", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        nutrientesLabPanel.jLabelExplicacion.setText("<html><body><P ALIGN=\"justify\">El exceso de Fosforo en el suelo bloquea elementos como el zinc, hierro o magnesio.</body></html>");
    }

    private void jLabelDefFosforoMouseClicked(java.awt.event.MouseEvent evt) {
        nutrientesLabPanel.jLabelImagenGrande.setIcon(new ImageIcon(getClass().getResource("/img/imgLab/fosforoDeficiente.jpg")));
        nutrientesLabPanel.jPanelImagenGrande.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Deficiencia de Fosforo en el Suelo", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        nutrientesLabPanel.jLabelExplicacion.setText("<html><body><P ALIGN=\"justify\"> Las hojas superiores muestran decoloraciones irregulares color marrón negruzco o una coloración purpúrea en el envés, debido a la formación de pigmentos antociánicos.\n"
                + "El crecimiento de la planta disminuye drásticamente y la coloración de las hojas oscurece. </body></html>");
    }

    private void jLabelExPotasioMouseClicked(java.awt.event.MouseEvent evt) {
        nutrientesLabPanel.jLabelImagenGrande.setIcon(new ImageIcon(getClass().getResource("/img/imgLab/potasio2.jpg")));
        nutrientesLabPanel.jPanelImagenGrande.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Exceso de Potasio en el Suelo", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        nutrientesLabPanel.jLabelExplicacion.setText("<html><body><P ALIGN=\"justify\">De igual modo que el Fosforo, bloquea elementos tales como el hierro, zinc magnesio o manganeso. </body></html>");
    }

    private void jLabelDefPotasioMouseClicked(java.awt.event.MouseEvent evt) {
        nutrientesLabPanel.jLabelImagenGrande.setIcon(new ImageIcon(getClass().getResource("/img/imgLab/potasioDeficiente.jpg")));
        nutrientesLabPanel.jPanelImagenGrande.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Deficiencia de Potasio en el Suelo", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        nutrientesLabPanel.jLabelExplicacion.setText("<html><body><P ALIGN=\"justify\">Los síntomas se muestran en las hojas inferiores, que en sus bordes muestran un amarillamiento  y una posterior desecación conforme avanza la deficiencia </body></html>");
    }
}
