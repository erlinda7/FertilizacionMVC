/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.questionView;
import view.questionView.FertilizacionSinLabPanel;
import model.Cultivo;
/**
 *
 * @author Erlinda
 */
public class FertilizacionSinLabFrameController {

    FertilizacionSinLabFrame fertilizacionSinLabFrame;
    Cultivo cultivo;

    public FertilizacionSinLabFrameController(FertilizacionSinLabFrame fertilizacionSinLabFrame) {
        this.fertilizacionSinLabFrame = fertilizacionSinLabFrame;
        this.fertilizacionSinLabFrame.setVisible(true);
        this.fertilizacionSinLabFrame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        this.fertilizacionSinLabFrame.setLocationRelativeTo(null);
     }
   /* public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FertilizacionSinLabFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FertilizacionSinLabFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FertilizacionSinLabFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FertilizacionSinLabFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FertilizacionSinLabFrame fertilizacionSinLabFrame = new FertilizacionSinLabFrame();
                FertilizacionSinLabFrameController fertilizacionSinLabFrameController = new FertilizacionSinLabFrameController(fertilizacionSinLabFrame);
                
                FertilizacionSinLabPanel fertilizacionSinLabPanel=fertilizacionSinLabFrame.getFertilizacionSinLabPanel1();
                FertilizacionSinLabPanelController fertilizacionSinLabPanelController=new FertilizacionSinLabPanelController(fertilizacionSinLabPanel);
                
               
                
            }
        });
    }*/
}
   
