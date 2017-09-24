/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.ConLabView;

import com.alee.laf.button.WebButton;
import com.alee.laf.radiobutton.WebRadioButton;
import java.awt.FlowLayout;
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
public class RendimientoLabPanelController {

    RendimientoLabPanel rendimientoLabPanel;
    Cultivo cultivo;
    ArrayList<WebRadioButton> listaWButonRendimiento = new ArrayList<WebRadioButton>();
    private HortalizaService hortalizaService = new HortalizaService();

    public RendimientoLabPanelController(RendimientoLabPanel rendimientoLabPanel, Cultivo cultivo) {
        this.rendimientoLabPanel = rendimientoLabPanel;
        this.cultivo = cultivo;

        //ValoresRendHortalizaPanel valoresRendHortalizaPanel=rendimientoLabPanel.valoresRendHortalizaPanel1;
        //ValoresRendHortalizaPanelController valoresRendHortalizaPanelController=new ValoresRendHortalizaPanelController(valoresRendHortalizaPanel);
        crearRadioButtonRendimiento(new String[]{"10", "13", "16", "20", "25", "30"});
    }

    public void crearRadioButtonRendimiento(String[] valoresRendHortalizas) {
        //int n=valoresRendHortalizas.length/2;
        rendimientoLabPanel.valoresRendimientoPanel.setLayout(new GridLayout(2, 3, 150, 30));
        for (int i = 0; i < valoresRendHortalizas.length; i++) {
            String valoresRendHortaliza = valoresRendHortalizas[i];
            WebRadioButton radioButonRendHort = new WebRadioButton(valoresRendHortaliza);
            radioButonRendHort.setFont(new java.awt.Font("Times New Roman", 1, 14));
            radioButonRendHort.setActionCommand(valoresRendHortaliza);
            rendimientoLabPanel.getButtonGroupValoresRend().add(radioButonRendHort);
            radioButonRendHort.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //   System.out.println(".actionPerformed(): "+ e.getActionCommand());
                }
            });
            rendimientoLabPanel.valoresRendimientoPanel.add(radioButonRendHort);
            listaWButonRendimiento.add(radioButonRendHort);
        }
    }

    public void actualizaValorRadioButtonRendimiento(String[] valorRendimiento) {
        for (int i = 0; i < valorRendimiento.length; i++) {
            WebRadioButton webRadioButonRend = listaWButonRendimiento.get(i);
            webRadioButonRend.setActionCommand(valorRendimiento[i]);
            webRadioButonRend.setText(valorRendimiento[i]);

        }

    }

    public void actualizarVistaRendimiento() {
        rendimientoLabPanel.jLabelNombreHortaliza.setText(cultivo.getHortaliza() + "  (ton/ha): ");
        Hortaliza hortalizaRecuperada=hortalizaService.buscarHortalizaNombre(cultivo.getHortaliza());
        //System.out.println("ruta img para label"+hortalizaRecuperada.getRutaImgHortaliza());
        rendimientoLabPanel.jLabelImgHortRend.setIcon(new ImageIcon(getClass().getResource(hortalizaRecuperada.getRutaImgHortaliza())));
        rendimientoLabPanel.jLabelDescripHortRend.setText("<html><body><P ALIGN=\"justify\">" + hortalizaRecuperada.getDescripcionHortaliza()+"</body></html>");
    }

    public void llenarDatosModelo() {
        Double valorRendLab = Double.parseDouble(rendimientoLabPanel.getButtonGroupValoresRend().getSelection().getActionCommand());
        cultivo.setRendimiento(valorRendLab);
        //System.out.println(valorRendLab);
    }

}
