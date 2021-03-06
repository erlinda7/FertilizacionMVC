/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.ConLabView;

import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;

/**
 *
 * @author Erlinda
 */
public class MemoriaTrabajoPanel extends javax.swing.JPanel {

    /**
     * Creates new form MemoriaTrabajoPanel
     */
    Timer timer = new Timer();
    ImageIcon[] imagenesA;

    public MemoriaTrabajoPanel() {
        initComponents();
        
        imagenesA= new ImageIcon[5];
        imagenesA[0] = new ImageIcon(getClass().getResource("/img/imgAnimate/apio.jpg"));
        imagenesA[1] = new ImageIcon(getClass().getResource("/img/imgAnimate/berenjena.jpg"));
        imagenesA[2] = new ImageIcon(getClass().getResource("/img/imgAnimate/lechuga2.jpg"));
        imagenesA[3] = new ImageIcon(getClass().getResource("/img/imgAnimate/pimenton.jpg"));
        imagenesA[4] = new ImageIcon(getClass().getResource("/img/imgAnimate/repollo2.jpg"));
        
        TimerTask myTask = new TimerTask() {
            int i = 0;

            @Override
            public void run() {
                // whatever you need to do every 2 seconds 
                //new ImageIcon(getClass().getResource("/img/arcilloso.jpg"))
                jLabelImagenTimer.setIcon(imagenesA[i]);
                System.out.println("contador: " + i);
                if (i < 4) {
                    i++;
                } else {
                    i = 0;
                }

            }
        };

        timer.schedule(myTask, 2000, 2000);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        hechosInicialesLabel = new javax.swing.JLabel();
        hortalizaLabel = new javax.swing.JLabel();
        rendimientoLabel = new javax.swing.JLabel();
        arenaLabel = new javax.swing.JLabel();
        limoLabel = new javax.swing.JLabel();
        arcillaLabel = new javax.swing.JLabel();
        nitrogenoLabel = new javax.swing.JLabel();
        fosforoLabel = new javax.swing.JLabel();
        potasioLabel = new javax.swing.JLabel();
        phLabel = new javax.swing.JLabel();
        materiaOrganicaLabel = new javax.swing.JLabel();
        hortalizaValor = new javax.swing.JLabel();
        rendimientoValor = new javax.swing.JLabel();
        arenaValor = new javax.swing.JLabel();
        limoValor = new javax.swing.JLabel();
        arcillaValor = new javax.swing.JLabel();
        nitrogenoValor = new javax.swing.JLabel();
        fosforoValor = new javax.swing.JLabel();
        potasioValor = new javax.swing.JLabel();
        phValor = new javax.swing.JLabel();
        materiaOrganicaValor = new javax.swing.JLabel();
        jLabelImagenTimer = new javax.swing.JLabel();

        setOpaque(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Memoria de Trabajo", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel1.setMinimumSize(new java.awt.Dimension(303, 304));

        hechosInicialesLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        hechosInicialesLabel.setText("Hechos Iniciales:");

        hortalizaLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        hortalizaLabel.setText("Hortaliza:");

        rendimientoLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rendimientoLabel.setText("Rendimiento:");

        arenaLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        arenaLabel.setText("Porcentaje Arena:");

        limoLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        limoLabel.setText("Porcentaje Limo:");

        arcillaLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        arcillaLabel.setText("Porcentaje Arcilla:");

        nitrogenoLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        nitrogenoLabel.setText("Nivel de Nitrogeno Suelo:");

        fosforoLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        fosforoLabel.setText("Nivel de Fosforo Suelo:");

        potasioLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        potasioLabel.setText("Nivel de Potasio Suelo:");

        phLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        phLabel.setText("Nivel de pH Suelo:");

        materiaOrganicaLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        materiaOrganicaLabel.setText("Nivel de Materia Organica:");

        hortalizaValor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        hortalizaValor.setText("Acelga");

        rendimientoValor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rendimientoValor.setText("10");

        arenaValor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        arenaValor.setText("50");

        limoValor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        limoValor.setText("30");

        arcillaValor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        arcillaValor.setText("20");

        nitrogenoValor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        nitrogenoValor.setText("5");

        fosforoValor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        fosforoValor.setText("5");

        potasioValor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        potasioValor.setText("7");

        phValor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        phValor.setText("6.5");

        materiaOrganicaValor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        materiaOrganicaValor.setText("2.3");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phLabel)
                    .addComponent(potasioLabel)
                    .addComponent(fosforoLabel)
                    .addComponent(nitrogenoLabel)
                    .addComponent(arcillaLabel)
                    .addComponent(limoLabel)
                    .addComponent(arenaLabel)
                    .addComponent(materiaOrganicaLabel)
                    .addComponent(rendimientoLabel)
                    .addComponent(hortalizaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(hortalizaValor, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                    .addComponent(rendimientoValor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(arenaValor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(limoValor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(arcillaValor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nitrogenoValor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fosforoValor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(potasioValor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phValor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(materiaOrganicaValor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(hechosInicialesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(hechosInicialesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hortalizaLabel)
                    .addComponent(hortalizaValor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rendimientoLabel)
                    .addComponent(rendimientoValor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(arenaLabel)
                    .addComponent(arenaValor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(limoLabel)
                    .addComponent(limoValor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(arcillaLabel)
                    .addComponent(arcillaValor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nitrogenoLabel)
                    .addComponent(nitrogenoValor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fosforoLabel)
                    .addComponent(fosforoValor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(potasioLabel)
                    .addComponent(potasioValor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phLabel)
                    .addComponent(phValor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(materiaOrganicaLabel)
                    .addComponent(materiaOrganicaValor))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelImagenTimer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabelImagenTimer, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel arcillaLabel;
    public javax.swing.JLabel arcillaValor;
    public javax.swing.JLabel arenaLabel;
    public javax.swing.JLabel arenaValor;
    public javax.swing.JLabel fosforoLabel;
    public javax.swing.JLabel fosforoValor;
    public javax.swing.JLabel hechosInicialesLabel;
    public javax.swing.JLabel hortalizaLabel;
    public javax.swing.JLabel hortalizaValor;
    private javax.swing.JLabel jLabelImagenTimer;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel limoLabel;
    public javax.swing.JLabel limoValor;
    public javax.swing.JLabel materiaOrganicaLabel;
    public javax.swing.JLabel materiaOrganicaValor;
    public javax.swing.JLabel nitrogenoLabel;
    public javax.swing.JLabel nitrogenoValor;
    public javax.swing.JLabel phLabel;
    public javax.swing.JLabel phValor;
    public javax.swing.JLabel potasioLabel;
    public javax.swing.JLabel potasioValor;
    public javax.swing.JLabel rendimientoLabel;
    public javax.swing.JLabel rendimientoValor;
    // End of variables declaration//GEN-END:variables
}
