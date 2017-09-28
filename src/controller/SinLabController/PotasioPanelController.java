/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.SinLabController;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import model.Cultivo;
import view.sinLabView.PotasioPanel;

/**
 *
 * @author Erlinda
 */
public class PotasioPanelController {

    PotasioPanel potasioPanel;
    Cultivo cultivo;

    public PotasioPanelController(PotasioPanel potasioPanel, Cultivo cultivo) {
        this.potasioPanel = potasioPanel;
        this.cultivo = cultivo;
        confRadiobutonPotasio();
        mostrarExplicacionPotasio();
        mostrarExplicacionMedirPotasio();
    }

    public void confRadiobutonPotasio() {
        potasioPanel.jRadioButtonPotTrace.setSelected(true);
        potasioPanel.jRadioButtonPotTrace.setActionCommand("25");
        potasioPanel.jRadioButtonPotLow.setActionCommand("40");
        potasioPanel.jRadioButtonPotMedium.setActionCommand("55");
        potasioPanel.jRadioButtonPotHigh.setActionCommand("85");
    }

    public void llenarDatosModelo() {
        Integer valorpotasio = Integer.parseInt(potasioPanel.getButtonGroupPotasio().getSelection().getActionCommand());
        cultivo.setNivelPotasio(valorpotasio);
    }
     public void mostrarExplicacionPotasio() {
        potasioPanel.jLabelPreguntaPotasio.setToolTipText("<html><body><p align='justify'>Elija el nivel de Potasio obtenido con el kit de analisis de potasio <br>para realizar una correcta Recomendación de Fertilización</html></body>");
        potasioPanel.jLabelPreguntaPotasio.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jLabelPreguntaPotasioMouseEntered(evt);
            }
        });
    }

    public void jLabelPreguntaPotasioMouseEntered(MouseEvent evt) {
        potasioPanel.jLabelPreguntaPotasio.getToolTipText();
    }
    
       public void mostrarExplicacionMedirPotasio() {
        potasioPanel.potasioInformacionPanel1.jLabelMedirPotasio.setToolTipText("<html><body><p align='justify'>Ponga el tubo con la prueba de potasio encima<br>la tarjeta de comparacion del potasio y <br> observe si en Trace, Low, Medium o High se ve con claridad<br> la linea blanca entre los cuadros de la tarjeta.</html></body>");
        potasioPanel.potasioInformacionPanel1.jLabelMedirPotasio.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jLabelMedirPotasioMouseEntered(evt);
            }
        });
    }

    public void jLabelMedirPotasioMouseEntered(MouseEvent evt) {
      potasioPanel.potasioInformacionPanel1.jLabelMedirPotasio.getToolTipText();
    }
}
