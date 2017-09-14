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
public class DocumentacionPanel extends javax.swing.JPanel {

    /**
     * Creates new form JPDocumentacion
     */
    public DocumentacionPanel() {
        initComponents();
    }
    public void paint(Graphics g) {
        Image imagen = new ImageIcon(getClass().getResource("/img/fondo2.jpg")).getImage();
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

        jButtonHortaliza = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButtonArena = new javax.swing.JButton();
        jButtonLimo = new javax.swing.JButton();
        jButtonArcilla = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButtonNitrogeno = new javax.swing.JButton();
        jButtonFosforo = new javax.swing.JButton();
        jButtonPotasio = new javax.swing.JButton();
        jButtonMO = new javax.swing.JButton();
        jButtonPH = new javax.swing.JButton();
        jButtonFetilizante = new javax.swing.JButton();
        jLabelImagen = new javax.swing.JLabel();
        jLabelDescripcion = new javax.swing.JLabel();

        jButtonHortaliza.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButtonHortaliza.setText("Hortaliza");
        jButtonHortaliza.setContentAreaFilled(false);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText(" Propiedades del suelo");

        jButton2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton2.setText("Textura : ");
        jButton2.setContentAreaFilled(false);

        jButtonArena.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButtonArena.setText("Arenosa");
        jButtonArena.setContentAreaFilled(false);
        jButtonArena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonArenaActionPerformed(evt);
            }
        });

        jButtonLimo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButtonLimo.setText("Limosa");
        jButtonLimo.setContentAreaFilled(false);

        jButtonArcilla.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButtonArcilla.setText(" Arcillosa");
        jButtonArcilla.setContentAreaFilled(false);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("    Nutrientes del Suelo :");

        jButtonNitrogeno.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButtonNitrogeno.setText("Nitrogeno");
        jButtonNitrogeno.setContentAreaFilled(false);

        jButtonFosforo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButtonFosforo.setText("Fosforo");
        jButtonFosforo.setContentAreaFilled(false);

        jButtonPotasio.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButtonPotasio.setText("Potasio");
        jButtonPotasio.setContentAreaFilled(false);
        jButtonPotasio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPotasioActionPerformed(evt);
            }
        });

        jButtonMO.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButtonMO.setText("Materia Organica");
        jButtonMO.setContentAreaFilled(false);

        jButtonPH.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButtonPH.setText("pH del suelo");
        jButtonPH.setContentAreaFilled(false);

        jButtonFetilizante.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButtonFetilizante.setText("Fertilizantes");
        jButtonFetilizante.setContentAreaFilled(false);

        jLabelImagen.setText("jLabel3");

        jLabelDescripcion.setText("sdszz");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonFetilizante)
                            .addComponent(jButtonHortaliza)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonPH)
                            .addComponent(jButtonMO)
                            .addComponent(jButton2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonFosforo, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                            .addComponent(jButtonPotasio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(jButtonNitrogeno))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jButtonArcilla, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(99, 99, 99)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButtonArena, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(jButtonLimo))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(209, 209, 209))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonHortaliza)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonFetilizante)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonMO)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonPH)
                        .addGap(3, 3, 3)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonArena)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonLimo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonArcilla)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonNitrogeno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonFosforo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonPotasio)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonArenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonArenaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonArenaActionPerformed

    private void jButtonPotasioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPotasioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonPotasioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    public javax.swing.JButton jButtonArcilla;
    public javax.swing.JButton jButtonArena;
    public javax.swing.JButton jButtonFetilizante;
    public javax.swing.JButton jButtonFosforo;
    public javax.swing.JButton jButtonHortaliza;
    public javax.swing.JButton jButtonLimo;
    public javax.swing.JButton jButtonMO;
    public javax.swing.JButton jButtonNitrogeno;
    public javax.swing.JButton jButtonPH;
    public javax.swing.JButton jButtonPotasio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabelDescripcion;
    public javax.swing.JLabel jLabelImagen;
    // End of variables declaration//GEN-END:variables
}
