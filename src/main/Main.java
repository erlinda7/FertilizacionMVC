/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Properties;

import javax.swing.UIManager;

import com.jtattoo.plaf.mcwin.McWinLookAndFeel;
import controller.BienvenidaFrameController;
import view.BienvenidaFrame;

/**
 *
 * @author Erlinda
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
 /* try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }*/
        try {
            Properties props = new Properties();

            props.put("selectionBackgroundColor", "184 241 200");
            props.put("windowTitleForegroundColor", "255 255 255");
            props.put("windowTitleColorLight", "20 147 101");
            props.put("windowTitleColorDark", "52 211 154");
            props.put("windowBorderColor", "20 147 101");
            props.put("frameColor", "20 147 101");
            props.put("controlColorLight", "52 211 154");
            props.put("controlColorDark", "20 147 101");

            McWinLookAndFeel.setCurrentTheme(props);
            UIManager.setLookAndFeel(new McWinLookAndFeel());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //</editor-fold>

        /* Create and display the form */
        //java.awt.EventQueue.invokeLater(new Runnable() {
        //    public void run() {
        BienvenidaFrame jFBienvenida = new BienvenidaFrame();
        BienvenidaFrameController controladorBienvenida = new BienvenidaFrameController(jFBienvenida);

    }

}
