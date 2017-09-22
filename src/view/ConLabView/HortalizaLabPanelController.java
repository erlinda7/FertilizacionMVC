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
import java.util.ArrayList;
import javax.swing.ImageIcon;
import model.Cultivo;
import model.Hortaliza;
import service.HortalizaService;

/**
 *
 * @author Erlinda
 */
public class HortalizaLabPanelController {
    
    HortalizaLabPanel hortalizaLabPanel;
    private ArrayList<Hortaliza> arrayListHortalizas;
    private Cultivo cultivo;
    private HortalizaService hortalizaService = new HortalizaService();
    private String[] rendimientoActual;
    
    public HortalizaLabPanelController(HortalizaLabPanel hortalizaLabPanel, Cultivo cultivo) {
        this.hortalizaLabPanel = hortalizaLabPanel;
        this.cultivo = cultivo;
        confNombresHortalizasPanel(hortalizaService.listarNombresHortaliza());
        
    }

    public void confNombresHortalizasPanel(ArrayList<String> nombresHortalizas) {
        int n = nombresHortalizas.size() / 4;
        hortalizaLabPanel.nombresHortalizasPanel.setLayout(new GridLayout(n, 5, 40, 30));
        for (int i = 0; i < nombresHortalizas.size(); i++) {
            String nombresHort = nombresHortalizas.get(i);
            WebRadioButton radioButonNombresHort = new WebRadioButton(nombresHort);
            radioButonNombresHort.setFont(new java.awt.Font("Times New Roman", 1, 14));
            radioButonNombresHort.setActionCommand(nombresHort);
            if(nombresHortalizas.get(i).equals("Acelga")){
            radioButonNombresHort.setSelected(true);
            }
            hortalizaLabPanel.getButtonGroupNombresHortalizas().add(radioButonNombresHort);
            radioButonNombresHort.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Hortaliza hortalizaRecuperada = hortalizaService.buscarHortalizaNombre(e.getActionCommand());
                    String descripcionHortaliza = hortalizaRecuperada.getDescripcionHortaliza();
                    hortalizaLabPanel.jLabelDescripHortaliza.setText("<html><body><P ALIGN=\"justify\">" + descripcionHortaliza + "</html></body>");
                    String imgHortaliza= hortalizaRecuperada.getRutaImgHortaliza();
                    hortalizaLabPanel.jLabelImgHortaliza.setIcon(new ImageIcon(getClass().getResource(imgHortaliza)));
                    rendimientoActual=hortalizaRecuperada.getRendimientoHortaliza();
                }
            });
            hortalizaLabPanel.nombresHortalizasPanel.add(radioButonNombresHort);
        }
    }

    public String[] getRendimientoActual() {
        return rendimientoActual;
    }
    
    public void llenarDatosModelo() {
      String valorHortalizaLab = hortalizaLabPanel.getButtonGroupNombresHortalizas().getSelection().getActionCommand();
        //System.out.println(ValorHortalizaLab);
           cultivo.setHortaliza(valorHortalizaLab);
        
    }
}
