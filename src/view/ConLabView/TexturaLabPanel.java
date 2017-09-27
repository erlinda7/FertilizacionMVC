/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.ConLabView;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Erlinda
 */
public class TexturaLabPanel extends javax.swing.JPanel {

    /**
     * Creates new form TexturaLabPanel
     */
    public TexturaLabPanel() {
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
        jSliderArenaLab = new javax.swing.JSlider();
        jSliderLimoLab = new javax.swing.JSlider();
        jSliderArcillaLab = new javax.swing.JSlider();
        jLabelPorctTextura = new javax.swing.JLabel();
        jLabelPorcArena = new javax.swing.JLabel();
        jLabelPorcLimo = new javax.swing.JLabel();
        jLabelPorcArcilla = new javax.swing.JLabel();
        jPanelTexturaImg = new javax.swing.JPanel();
        jLabelImgTexturaLab2 = new javax.swing.JLabel();
        jLabelImgTexturaLab1 = new javax.swing.JLabel();
        jLabelImgTexturaLab3 = new javax.swing.JLabel();
        contenedorMemoriaTrabajo = new javax.swing.JPanel();
        memoriaTrabajoPanel1 = new view.ConLabView.MemoriaTrabajoPanel();

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("Cual es el Porcentaje de Arena en el Suelo ?");

        jLabelPorctTextura.setBackground(new java.awt.Color(0, 255, 0));
        jLabelPorctTextura.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPorctTextura.setText("100 %");
        jLabelPorctTextura.setOpaque(true);

        jLabelPorcArena.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelPorcArena.setText("Porcentaje de Arena:");

        jLabelPorcLimo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelPorcLimo.setText("Porcentaje de Limo:");

        jLabelPorcArcilla.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelPorcArcilla.setText("Porcentaje de Arcilla:");

        jPanelTexturaImg.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Suelos Arenosos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 11))); // NOI18N
        jPanelTexturaImg.setOpaque(false);

        jLabelImgTexturaLab2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/imgLab/arenaP2.jpg"))); // NOI18N

        jLabelImgTexturaLab1.setBackground(new java.awt.Color(102, 255, 102));
        jLabelImgTexturaLab1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/imgLab/arenaP1.jpg"))); // NOI18N

        jLabelImgTexturaLab3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/imgLab/arenaP3.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanelTexturaImgLayout = new javax.swing.GroupLayout(jPanelTexturaImg);
        jPanelTexturaImg.setLayout(jPanelTexturaImgLayout);
        jPanelTexturaImgLayout.setHorizontalGroup(
            jPanelTexturaImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTexturaImgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelImgTexturaLab1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelImgTexturaLab2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelImgTexturaLab3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelTexturaImgLayout.setVerticalGroup(
            jPanelTexturaImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTexturaImgLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelTexturaImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelImgTexturaLab3, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelImgTexturaLab1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelImgTexturaLab2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        contenedorMemoriaTrabajo.setOpaque(false);

        javax.swing.GroupLayout contenedorMemoriaTrabajoLayout = new javax.swing.GroupLayout(contenedorMemoriaTrabajo);
        contenedorMemoriaTrabajo.setLayout(contenedorMemoriaTrabajoLayout);
        contenedorMemoriaTrabajoLayout.setHorizontalGroup(
            contenedorMemoriaTrabajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenedorMemoriaTrabajoLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(memoriaTrabajoPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        contenedorMemoriaTrabajoLayout.setVerticalGroup(
            contenedorMemoriaTrabajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenedorMemoriaTrabajoLayout.createSequentialGroup()
                .addGap(0, 43, Short.MAX_VALUE)
                .addComponent(memoriaTrabajoPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSliderLimoLab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSliderArcillaLab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSliderArenaLab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53)
                                .addComponent(jLabelPorctTextura, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabelPorcArena)
                            .addComponent(jLabelPorcLimo)
                            .addComponent(jLabelPorcArcilla)
                            .addComponent(jPanelTexturaImg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(contenedorMemoriaTrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(contenedorMemoriaTrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelPorctTextura, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabelPorcArena)
                        .addGap(18, 18, 18)
                        .addComponent(jSliderArenaLab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jLabelPorcLimo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSliderLimoLab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelPorcArcilla)
                        .addGap(18, 18, 18)
                        .addComponent(jSliderArcillaLab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                        .addComponent(jPanelTexturaImg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel contenedorMemoriaTrabajo;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabelImgTexturaLab1;
    public javax.swing.JLabel jLabelImgTexturaLab2;
    public javax.swing.JLabel jLabelImgTexturaLab3;
    public javax.swing.JLabel jLabelPorcArcilla;
    public javax.swing.JLabel jLabelPorcArena;
    public javax.swing.JLabel jLabelPorcLimo;
    public javax.swing.JLabel jLabelPorctTextura;
    public javax.swing.JPanel jPanelTexturaImg;
    public javax.swing.JSlider jSliderArcillaLab;
    public javax.swing.JSlider jSliderArenaLab;
    public javax.swing.JSlider jSliderLimoLab;
    public view.ConLabView.MemoriaTrabajoPanel memoriaTrabajoPanel1;
    // End of variables declaration//GEN-END:variables
}