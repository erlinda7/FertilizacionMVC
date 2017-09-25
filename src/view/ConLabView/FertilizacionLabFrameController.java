/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.ConLabView;

import com.alee.laf.WebLookAndFeel;
import com.jtattoo.plaf.mcwin.McWinLookAndFeel;
import java.util.Properties;
import javax.swing.UIManager;
import model.Cultivo;

/**
 *
 * @author Erlinda
 */
public class FertilizacionLabFrameController {

    FertilizacionLabFrame fertilizacionLabFrame;

    public FertilizacionLabFrameController(FertilizacionLabFrame fertilizacionLabFrame) {
        this.fertilizacionLabFrame = fertilizacionLabFrame;
        this.fertilizacionLabFrame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        fertilizacionLabFrame.setVisible(true);
    }

//    public static void main(String args[]) {
//       //look and feel
//        try {
//            Properties props = new Properties();
//
//            props.put("selectionBackgroundColor", "184 241 200");
//            props.put("windowTitleForegroundColor", "255 255 255");
//            props.put("windowTitleColorLight", "20 147 101");
//            props.put("windowTitleColorDark", "52 211 154");
//            props.put("windowBorderColor", "20 147 101");
//            props.put("frameColor", "20 147 101");
//            props.put("controlColorLight", "52 211 154");
//            props.put("controlColorDark", "20 147 101");
//
//            McWinLookAndFeel.setCurrentTheme(props);
//            UIManager.setLookAndFeel(new McWinLookAndFeel());
//            WebLookAndFeel.initializeManagers();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        
//        FertilizacionLabFrame fertilizacionLabFrame = new FertilizacionLabFrame();
//        FertilizacionLabFrameController fertilizacionLabFrameController = new FertilizacionLabFrameController(fertilizacionLabFrame);
//
//        FertilizacionLabPanel fertilizacionLabPanel = fertilizacionLabFrame.fertilizacionLabPanel1;
//        FertilizacionLabPanelController fertilizacionLabPanelController1 = new FertilizacionLabPanelController(fertilizacionLabPanel);
//    }
}
