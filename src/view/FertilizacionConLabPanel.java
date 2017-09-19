/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Erlinda
 */
public class FertilizacionConLabPanel extends javax.swing.JPanel {

    /**
     * Creates new form JPFertilizacion
     */
    public FertilizacionConLabPanel() {
        initComponents();
    }

    public void paint(Graphics g) {
        Image imagen = new ImageIcon(getClass().getResource("/img/fondo1.jpg")).getImage();
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        setOpaque(false);
        super.paint(g);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        comboBoxHortaliza = new javax.swing.JComboBox<>();
        labelImagen = new javax.swing.JLabel();
        labelInformacion = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        comboBoxRendimiento = new javax.swing.JComboBox<>();
        sliderLimo = new javax.swing.JSlider();
        sliderArcilla = new javax.swing.JSlider();
        jLabel4 = new javax.swing.JLabel();
        sliderArena = new javax.swing.JSlider();
        jLabel5 = new javax.swing.JLabel();
        jLabelNitrogeno = new javax.swing.JLabel();
        jLabelfosforo = new javax.swing.JLabel();
        jLabelPotasio = new javax.swing.JLabel();
        spinnerNitrogeno = new javax.swing.JSpinner();
        spinnerFosforo = new javax.swing.JSpinner();
        spinnerPotasio = new javax.swing.JSpinner();
        jLabelPH = new javax.swing.JLabel();
        spinnerpH = new javax.swing.JSpinner();
        jLabelMO = new javax.swing.JLabel();
        spinnerMO = new javax.swing.JSpinner();
        buttonGenerarResultados = new javax.swing.JButton();
        jLabelPorcentaje = new javax.swing.JLabel();
        jLabelArena = new javax.swing.JLabel();
        jLabelLimo = new javax.swing.JLabel();
        jLabelArcilla = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Wide Latin", 1, 18)); // NOI18N
        jLabel1.setText("Fertilizacion de hortalizas");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("Cultivo : ");

        comboBoxHortaliza.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        labelImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/hortalizaDefault.jpg"))); // NOI18N
        labelImagen.setText("jLabel3");

        labelInformacion.setText("Descripcion por defecto");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("Rendimiento (ton/ha) :");

        comboBoxRendimiento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setText("Textura del suelo : ");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText("Nutrientes del suelo : ");

        jLabelNitrogeno.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabelNitrogeno.setText("Nitrogeno :");

        jLabelfosforo.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabelfosforo.setText("Fosforo : ");

        jLabelPotasio.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabelPotasio.setText("Potasio :");

        jLabelPH.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabelPH.setText("Nivel de pH en el Suelo : ");

        jLabelMO.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabelMO.setText("Nivel de Materia Organica en el Suelo : ");

        buttonGenerarResultados.setText("Generar resultados");
        buttonGenerarResultados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGenerarResultadosActionPerformed(evt);
            }
        });

        jLabelArena.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabelArena.setText("Arena :");

        jLabelLimo.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabelLimo.setText("Limo :");

        jLabelArcilla.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabelArcilla.setText("Arcilla :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelLimo)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelArena, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabelArcilla)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(sliderLimo, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                                    .addComponent(sliderArena, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(sliderArcilla, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabelPorcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(comboBoxHortaliza, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 207, Short.MAX_VALUE)
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(comboBoxRendimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(13, 13, 13)))))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(188, 188, 188)
                            .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelNitrogeno)
                                        .addGap(18, 18, 18)
                                        .addComponent(spinnerNitrogeno, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(103, 103, 103)
                                        .addComponent(jLabelfosforo)
                                        .addGap(18, 18, 18)
                                        .addComponent(spinnerFosforo, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(105, 105, 105)
                                        .addComponent(jLabelPotasio)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(spinnerPotasio, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelPH)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(spinnerpH, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(49, 49, 49)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(buttonGenerarResultados, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabelMO)
                                                .addGap(18, 18, 18)
                                                .addComponent(spinnerMO, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelImagen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelInformacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1)
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(comboBoxHortaliza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboBoxRendimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelPorcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelArena)
                            .addComponent(sliderArena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelLimo, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sliderLimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelArcilla)
                            .addComponent(sliderArcilla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addComponent(jLabel5)
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelNitrogeno)
                            .addComponent(spinnerNitrogeno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelfosforo)
                            .addComponent(spinnerFosforo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelPotasio)
                            .addComponent(spinnerPotasio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelMO)
                            .addComponent(spinnerMO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spinnerpH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelPH)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(labelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(labelInformacion, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(buttonGenerarResultados, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonGenerarResultadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGenerarResultadosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonGenerarResultadosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton buttonGenerarResultados;
    public javax.swing.JComboBox<String> comboBoxHortaliza;
    public javax.swing.JComboBox<String> comboBoxRendimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabelArcilla;
    public javax.swing.JLabel jLabelArena;
    public javax.swing.JLabel jLabelLimo;
    public javax.swing.JLabel jLabelMO;
    public javax.swing.JLabel jLabelNitrogeno;
    public javax.swing.JLabel jLabelPH;
    public javax.swing.JLabel jLabelPorcentaje;
    public javax.swing.JLabel jLabelPotasio;
    public javax.swing.JLabel jLabelfosforo;
    public javax.swing.JLabel labelImagen;
    public javax.swing.JLabel labelInformacion;
    public javax.swing.JSlider sliderArcilla;
    public javax.swing.JSlider sliderArena;
    public javax.swing.JSlider sliderLimo;
    public javax.swing.JSpinner spinnerFosforo;
    public javax.swing.JSpinner spinnerMO;
    public javax.swing.JSpinner spinnerNitrogeno;
    public javax.swing.JSpinner spinnerPotasio;
    public javax.swing.JSpinner spinnerpH;
    // End of variables declaration//GEN-END:variables
}
