/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.ConLabView;

import com.alee.laf.radiobutton.WebRadioButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Erlinda
 */
public class ValoresRendHortalizaPanelController {
    ValoresRendHortalizaPanel valoresRendHortalizasPanel;

    public ValoresRendHortalizaPanelController(ValoresRendHortalizaPanel valoresRendHortalizasPanel) {
        this.valoresRendHortalizasPanel = valoresRendHortalizasPanel;
        confValoresRendHortalizasPanel(new String[]{"10", "13", "16", "20","25","30"});
    }

    
    
    public void confValoresRendHortalizasPanel(String[] valoresRendHortalizas){
        //int n=valoresRendHortalizas.length/2;
        valoresRendHortalizasPanel.setLayout(new GridLayout(2, 3,150,40));
        for (int i = 0; i < valoresRendHortalizas.length; i++) {
            String valoresRendHortaliza = valoresRendHortalizas[i];
            WebRadioButton radioButonRendHort=new WebRadioButton(valoresRendHortaliza);
            radioButonRendHort.setFont(new java.awt.Font("Times New Roman", 1, 14));
            radioButonRendHort.setActionCommand(valoresRendHortaliza);
            valoresRendHortalizasPanel.getButtonGroupRendimiento().add(radioButonRendHort);
            radioButonRendHort.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println(".actionPerformed(): "+ e.getActionCommand());
                }
            });
            valoresRendHortalizasPanel.add(radioButonRendHort);
        }
    }
}
