/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.SinLabController;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import model.Cultivo;
import model.Hortaliza;
import service.HortalizaService;
import view.sinLabView.CultivoPanel;

/**
 *
 * @author Erlinda
 */
public class CultivoPanelController {

    private CultivoPanel cultivoPanel;
    private ArrayList<Hortaliza> arrayListHortalizas;
    private Cultivo cultivo;
    private HortalizaService hortalizaService = new HortalizaService();

    public CultivoPanelController(CultivoPanel cultivoPanel, Cultivo cultivo) {
        this.cultivoPanel = cultivoPanel;
        this.cultivo = cultivo;
        //hortalizas();
        arrayListHortalizas = hortalizaService.getListaHortalizas();
        configCultivo();

        mostrarExplicacionHortaliza();
    }

    public void llenarDatosModelo() {
        String nombreHortaliza = (String) cultivoPanel.jComboBoxHortaliza.getSelectedItem();
        cultivo.setHortaliza(nombreHortaliza);
        Double rendimientoHortaliza = Double.parseDouble(cultivoPanel.jComboBoxRendimiento.getSelectedItem().toString());
        cultivo.setRendimiento(rendimientoHortaliza);
    }

    public void configCultivo() {

        confComboBoxHortaliza();
        confComboBoxRendimiento();
        confLabelImagen();
        confLabelDescripcion();
    }

    public void confComboBoxHortaliza() {
        String[] arregloNombreHortalizas = new String[arrayListHortalizas.size()];
        for (int i = 0; i < arregloNombreHortalizas.length; i++) {
            arregloNombreHortalizas[i] = arrayListHortalizas.get(i).getNombreHortaliza();
        }
        this.cultivoPanel.jComboBoxHortaliza.setModel(new DefaultComboBoxModel<>(arregloNombreHortalizas));
        this.cultivoPanel.jComboBoxHortaliza.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent evt) {
                comboBoxHortalizaItemStateChanged(evt);

            }
        });
    }

    public void confComboBoxRendimiento() {
        String nombreHortaliza = (String) cultivoPanel.jComboBoxHortaliza.getSelectedItem();
        Hortaliza hortalizaSeleccionada = hortalizaService.buscarHortalizaNombre(nombreHortaliza);
        this.cultivoPanel.jComboBoxRendimiento.setModel(new DefaultComboBoxModel<>(hortalizaSeleccionada.getRendimientoHortaliza()));
    }

    public void confLabelImagen() {
        String nombreHortaliza = (String) cultivoPanel.jComboBoxHortaliza.getSelectedItem();
        Hortaliza hortalizaSeleccionada = hortalizaService.buscarHortalizaNombre(nombreHortaliza);
        this.cultivoPanel.jLabelImagen.setIcon(new ImageIcon(getClass().getResource(hortalizaSeleccionada.getRutaImgHortaliza())));
    }

    public void confLabelDescripcion() {
        String nombreHortaliza = (String) cultivoPanel.jComboBoxHortaliza.getSelectedItem();
        Hortaliza hortalizaSeleccionada = hortalizaService.buscarHortalizaNombre(nombreHortaliza);
        this.cultivoPanel.jLabelDescripcion.setText("<html><body><P ALIGN=\"justify\">" + hortalizaSeleccionada.getDescripcionHortaliza() + "</html></body>");
    }

    public void comboBoxHortalizaItemStateChanged(ItemEvent evt) {
        String nombreHortalizaSelectionado = (String) cultivoPanel.jComboBoxHortaliza.getSelectedItem();
        Hortaliza hortalizaSelecionada = hortalizaService.buscarHortalizaNombre(nombreHortalizaSelectionado);
        this.cultivoPanel.jLabelDescripcion.setText("<html><body><P ALIGN=\"justify\">" + hortalizaSelecionada.getDescripcionHortaliza() + "</html></body>");
        this.cultivoPanel.jLabelImagen.setIcon(new ImageIcon(getClass().getResource(hortalizaSelecionada.getRutaImgHortaliza())));
        this.cultivoPanel.jComboBoxRendimiento.setModel(new DefaultComboBoxModel<>(hortalizaSelecionada.getRendimientoHortaliza()));
    }

    public void mostrarExplicacionHortaliza() {
        cultivoPanel.jLabelPreguntaCultivo.setToolTipText("<html><body><p align='justify'>Seleccione una hortaliza y el rendimiento en toneladas por hectarea <br>que espera tener al aplicar la fertilizacion para realizar <br>una correcta Recomendación de Fertilización</html></body>");
        cultivoPanel.jLabelPreguntaCultivo.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jLabelPreguntaCultivoMouseEntered(evt);
            }
        });
    }

    public void jLabelPreguntaCultivoMouseEntered(MouseEvent evt) {
        cultivoPanel.jLabelPreguntaCultivo.getToolTipText();
    }
}
