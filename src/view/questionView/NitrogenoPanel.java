/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.questionView;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

/**
 *
 * @author Erlinda
 */
public class NitrogenoPanel extends javax.swing.JPanel {

    /**
     * Creates new form JPPreguntaNitrogenoNA
     */
    public NitrogenoPanel() {
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

        buttonGroupNitrogeno = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jRadioButtonHigh = new javax.swing.JRadioButton();
        jRadioButtonMedium = new javax.swing.JRadioButton();
        jRadioButtonLow = new javax.swing.JRadioButton();
        jRadioButtonTrace = new javax.swing.JRadioButton();
        jRadioButtonTraceLow = new javax.swing.JRadioButton();
        jRadioButtonLowMedium = new javax.swing.JRadioButton();
        jRadioButtonMediumHigh = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        nitrogenoInformacionPanel1 = new view.questionView.NitrogenoInformacionPanel();

        setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("Elija el color de nitrogeno encontrado en la prueba");

        buttonGroupNitrogeno.add(jRadioButtonHigh);
        jRadioButtonHigh.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jRadioButtonHigh.setText("High");
        jRadioButtonHigh.setOpaque(false);
        jRadioButtonHigh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonHighActionPerformed(evt);
            }
        });

        buttonGroupNitrogeno.add(jRadioButtonMedium);
        jRadioButtonMedium.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jRadioButtonMedium.setText("Medium");
        jRadioButtonMedium.setOpaque(false);

        buttonGroupNitrogeno.add(jRadioButtonLow);
        jRadioButtonLow.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jRadioButtonLow.setText("Low");
        jRadioButtonLow.setOpaque(false);

        buttonGroupNitrogeno.add(jRadioButtonTrace);
        jRadioButtonTrace.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jRadioButtonTrace.setText("Trace");
        jRadioButtonTrace.setOpaque(false);

        buttonGroupNitrogeno.add(jRadioButtonTraceLow);
        jRadioButtonTraceLow.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jRadioButtonTraceLow.setText("Entre Low - Trace ");
        jRadioButtonTraceLow.setOpaque(false);

        buttonGroupNitrogeno.add(jRadioButtonLowMedium);
        jRadioButtonLowMedium.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jRadioButtonLowMedium.setText("Entre Medium - Low");
        jRadioButtonLowMedium.setOpaque(false);

        buttonGroupNitrogeno.add(jRadioButtonMediumHigh);
        jRadioButtonMediumHigh.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jRadioButtonMediumHigh.setText("Entre High - Medium");
        jRadioButtonMediumHigh.setOpaque(false);
        jRadioButtonMediumHigh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMediumHighActionPerformed(evt);
            }
        });

        jLabel2.setText("jLabel2");

        jLabel3.setText("jLabel2");

        jLabel4.setText("jLabel2");

        jLabel5.setText("jLabel2");

        jLabel6.setText("jLabel2");

        jLabel7.setText("jLabel2");

        jLabel8.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRadioButtonMedium)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRadioButtonHigh)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRadioButtonLowMedium)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRadioButtonTraceLow)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButtonTrace)
                            .addComponent(jRadioButtonLow))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRadioButtonMediumHigh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(nitrogenoInformacionPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 522, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButtonTrace)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButtonLow)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButtonMedium)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButtonHigh)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButtonTraceLow)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButtonLowMedium)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButtonMediumHigh)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nitrogenoInformacionPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButtonHighActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonHighActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonHighActionPerformed

    private void jRadioButtonMediumHighActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMediumHighActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonMediumHighActionPerformed

    public ButtonGroup getButtonGroupNitrogeno() {
        return buttonGroupNitrogeno;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupNitrogeno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    public javax.swing.JRadioButton jRadioButtonHigh;
    public javax.swing.JRadioButton jRadioButtonLow;
    public javax.swing.JRadioButton jRadioButtonLowMedium;
    public javax.swing.JRadioButton jRadioButtonMedium;
    public javax.swing.JRadioButton jRadioButtonMediumHigh;
    public javax.swing.JRadioButton jRadioButtonTrace;
    public javax.swing.JRadioButton jRadioButtonTraceLow;
    private view.questionView.NitrogenoInformacionPanel nitrogenoInformacionPanel1;
    // End of variables declaration//GEN-END:variables
}
