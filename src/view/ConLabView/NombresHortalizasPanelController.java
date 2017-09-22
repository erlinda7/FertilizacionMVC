/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.ConLabView;

import com.alee.laf.radiobutton.WebRadioButton;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Erlinda
 */
public class NombresHortalizasPanelController {
    NombresHortalizasPanel nombresHortalizasPanel;

    public NombresHortalizasPanelController(NombresHortalizasPanel nombresHortalizasPanel) {
        this.nombresHortalizasPanel = nombresHortalizasPanel;
        confNombresHortalizasPanel(new String[]{"Acelga", "Apio", "Arveja", "Berenjena","Cebolla","Coliflor","Espinaca","Haba", "Lechuga","Papa","Pepino","Pimneton","Rabano","Remolacha","Repollo","Tomate","Vainita","Zanahoria"});
       
    }
    
    public void confNombresHortalizasPanel(String[] nombresHortalizas){
        int n=nombresHortalizas.length/4;
        nombresHortalizasPanel.setLayout(new GridLayout(n, 5,40,30));
        for (int i = 0; i < nombresHortalizas.length; i++) {
            String nombresHort = nombresHortalizas[i];
            WebRadioButton radioButonNombresHort=new WebRadioButton(nombresHort);
            radioButonNombresHort.setFont(new java.awt.Font("Times New Roman", 1, 14));
            radioButonNombresHort.setActionCommand(nombresHort);
            nombresHortalizasPanel.getButtonGroupNombresHort().add(radioButonNombresHort);
            radioButonNombresHort.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println(".actionPerformed(): "+ e.getActionCommand());
                }
            });
            nombresHortalizasPanel.add(radioButonNombresHort);
        }
    }
}
