/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JTabbedPane;

/**
 *
 * @author Erlinda
 */
public class FertilizacionConLabFrame extends javax.swing.JFrame {

    /**
     * Creates new form FertilizacionConLabFrame
     */
    public FertilizacionConLabFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPaneNavegacion = new javax.swing.JTabbedPane();
        fertilizacionConLabPanel1 = new view.FertilizacionConLabPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultadosConLabPanel1 = new view.ResultadosConLabPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPaneNavegacion.addTab("Fertilizacion", fertilizacionConLabPanel1);

        jScrollPane1.setViewportView(resultadosConLabPanel1);

        jTabbedPaneNavegacion.addTab("Resultados", jScrollPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneNavegacion, javax.swing.GroupLayout.DEFAULT_SIZE, 952, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneNavegacion, javax.swing.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    public FertilizacionConLabPanel getFertilizacionConLabPanel1() {
        return fertilizacionConLabPanel1;
    }

    /**
     * @param args the command line arguments
     */
    
    public ResultadosConLabPanel getResultadosConLabPanel1() {
        return resultadosConLabPanel1;
    }

    public JTabbedPane getjTabbedPaneNavegacion() {
        return jTabbedPaneNavegacion;
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private view.FertilizacionConLabPanel fertilizacionConLabPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPaneNavegacion;
    private view.ResultadosConLabPanel resultadosConLabPanel1;
    // End of variables declaration//GEN-END:variables
}
