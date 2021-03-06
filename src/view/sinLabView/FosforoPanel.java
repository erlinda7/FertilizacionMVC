/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.sinLabView;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

/**
 *
 * @author Erlinda
 */
public class FosforoPanel extends javax.swing.JPanel {

    /**
     * Creates new form JPPreguntaFosforoNA
     */
    public FosforoPanel() {
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

        buttonGroupFosforo = new javax.swing.ButtonGroup();
        jLabelPreguntaFosforo = new javax.swing.JLabel();
        jRadioButtonFosfoHigh = new javax.swing.JRadioButton();
        jRadioButtonFosfoMedium = new javax.swing.JRadioButton();
        jRadioButtonFosfoLow = new javax.swing.JRadioButton();
        jRadioButtonFosfoTrace = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        memoriaTrabajosinLABPanel1 = new view.sinLabView.MemoriaTrabajosinLABPanel();
        fosforoInformacionPanel2 = new view.sinLabView.FosforoInformacionPanel();

        jLabelPreguntaFosforo.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabelPreguntaFosforo.setText("Elija el color de fosforo encontrado en el Suelo");

        buttonGroupFosforo.add(jRadioButtonFosfoHigh);
        jRadioButtonFosfoHigh.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jRadioButtonFosfoHigh.setText("High");
        jRadioButtonFosfoHigh.setOpaque(false);
        jRadioButtonFosfoHigh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonFosfoHighActionPerformed(evt);
            }
        });

        buttonGroupFosforo.add(jRadioButtonFosfoMedium);
        jRadioButtonFosfoMedium.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jRadioButtonFosfoMedium.setText("Medium");
        jRadioButtonFosfoMedium.setOpaque(false);

        buttonGroupFosforo.add(jRadioButtonFosfoLow);
        jRadioButtonFosfoLow.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jRadioButtonFosfoLow.setText("Low");
        jRadioButtonFosfoLow.setOpaque(false);

        buttonGroupFosforo.add(jRadioButtonFosfoTrace);
        jRadioButtonFosfoTrace.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jRadioButtonFosfoTrace.setText("Trace");
        jRadioButtonFosfoTrace.setOpaque(false);
        jRadioButtonFosfoTrace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonFosfoTraceActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(92, 136, 218));
        jLabel2.setOpaque(true);

        jLabel3.setBackground(new java.awt.Color(220, 240, 240));
        jLabel3.setOpaque(true);

        jLabel4.setBackground(new java.awt.Color(167, 198, 237));
        jLabel4.setOpaque(true);

        jLabel5.setBackground(new java.awt.Color(16, 6, 159));
        jLabel5.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButtonFosfoTrace)
                            .addComponent(jRadioButtonFosfoHigh)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jRadioButtonFosfoMedium, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jRadioButtonFosfoLow)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelPreguntaFosforo, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(memoriaTrabajosinLABPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fosforoInformacionPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jLabelPreguntaFosforo)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButtonFosfoTrace, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButtonFosfoLow, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButtonFosfoMedium, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButtonFosfoHigh, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(memoriaTrabajosinLABPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(fosforoInformacionPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButtonFosfoHighActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonFosfoHighActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonFosfoHighActionPerformed

    private void jRadioButtonFosfoTraceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonFosfoTraceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonFosfoTraceActionPerformed

    public ButtonGroup getButtonGroupFosforo() {
        return buttonGroupFosforo;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupFosforo;
    private view.sinLabView.FosforoInformacionPanel fosforoInformacionPanel2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabelPreguntaFosforo;
    public javax.swing.JRadioButton jRadioButtonFosfoHigh;
    public javax.swing.JRadioButton jRadioButtonFosfoLow;
    public javax.swing.JRadioButton jRadioButtonFosfoMedium;
    public javax.swing.JRadioButton jRadioButtonFosfoTrace;
    public view.sinLabView.MemoriaTrabajosinLABPanel memoriaTrabajosinLABPanel1;
    // End of variables declaration//GEN-END:variables
}
