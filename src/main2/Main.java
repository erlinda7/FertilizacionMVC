/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.alee.laf.WebLookAndFeel;
import java.util.Properties;
import javax.swing.UIManager;
import com.jtattoo.plaf.mcwin.McWinLookAndFeel;
import controller.BienvenidaFrameController;
import javax.swing.UnsupportedLookAndFeelException;
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
            WebLookAndFeel.initializeManagers();
        } catch (Exception e) {
            e.printStackTrace();
        }

        BienvenidaFrame jFBienvenida = new BienvenidaFrame();
        BienvenidaFrameController controladorBienvenida = new BienvenidaFrameController(jFBienvenida);

    }

}
