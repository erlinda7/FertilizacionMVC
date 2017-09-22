/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testRadioButton;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JRadioButton;

/**
 *
 * @author Erlinda
 */
public class NewJPanelController {

    NewJPanel newJPanel;

    public NewJPanelController(NewJPanel newJPanel) {
        this.newJPanel = newJPanel;
        configNewJPanel(new String[]{"angel", "erlinda", "luis", "ana","juan","pedro", "nelson"});
    }

    public void configNewJPanel(String[] nombres) {
        newJPanel.setLayout(new GridLayout(3, 3, 20, 10));
        for (int i = 0; i < nombres.length; i++) {
            String nombre = nombres[i];
            JRadioButton jrb = new JRadioButton(nombre);
            jrb.setActionCommand(nombre);
            newJPanel.getButtonGroupNombres().add(jrb);
            jrb.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println(".actionPerformed(): "+ e.getActionCommand());
                }
            });
            newJPanel.add(jrb);
            
        }
    }
    
    public String buscarImagenHortalizaPorNOmbre(String nombreHortaliza){
        
     return "/acelga.jpg";   
    }

}
