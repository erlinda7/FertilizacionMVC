/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EdicionReglas;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.FormaAplicarFertilizanteRegla;
import service.FormaApliFertilizReglaService;
import service.HortalizaService;

/**
 *
 * @author Erlinda
 */
public class FormaApliFertiEdicionReglasPanelController {

    FormaApliFertiEdicionReglasPanel formaApliFertiEdicionReglasPanel;
    FormaApliFertilizReglaService formaApliFertiReglaService;
    ArrayList<FormaAplicarFertilizanteRegla> listaReglaFormaAplicarFertilizante;

    HortalizaService hortalizaService = new HortalizaService();

    String actionAceptar;

    public FormaApliFertiEdicionReglasPanelController(FormaApliFertiEdicionReglasPanel formaApliFertiEdicionReglasPanel) {
        this.formaApliFertiEdicionReglasPanel = formaApliFertiEdicionReglasPanel;
        formaApliFertiReglaService = new FormaApliFertilizReglaService();
        listaReglaFormaAplicarFertilizante = formaApliFertiReglaService.readAllFormaApliFerti();
        llenarJTable();
        confBotonesEdicion();
        confbuttonAceptar();
        confComboBoxPremisa();
        actionAceptar = "";
    }

    public void llenarJTable() {
        DefaultTableModel dtm = (DefaultTableModel) formaApliFertiEdicionReglasPanel.jTableFormaAplicarFertilizante.getModel();
        dtm.setRowCount(0);
        for (int i = 0; i < listaReglaFormaAplicarFertilizante.size(); i++) {
            dtm.addRow(new Object[]{
                listaReglaFormaAplicarFertilizante.get(i).getIdFormaAplicFertilizante(),
                listaReglaFormaAplicarFertilizante.get(i).getNombreRegla(),
                listaReglaFormaAplicarFertilizante.get(i).getHortalizaAFertilizar(),
                listaReglaFormaAplicarFertilizante.get(i).getConclusion()
            });
        }
    }

    public void confComboBoxPremisa() {
        String[] arregloNombreHortalizas = new String[hortalizaService.getListaHortalizas().size()];
        for (int i = 0; i < arregloNombreHortalizas.length; i++) {
            arregloNombreHortalizas[i] = hortalizaService.getListaHortalizas().get(i).getNombreHortaliza();
        }
        formaApliFertiEdicionReglasPanel.jComboBoxPremisa.setModel(new DefaultComboBoxModel<>(arregloNombreHortalizas));

    }

    public void confBotonesEdicion() {

        formaApliFertiEdicionReglasPanel.jButtonEditarRegla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditarReglaActionPerformed(evt);
            }
        });

        formaApliFertiEdicionReglasPanel.jButtonAnadirRegla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAnadirReglaActionPerformed(evt);
            }
        });

        formaApliFertiEdicionReglasPanel.jButtonEliminarRegla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEliminarReglaActionPerformed(evt);
            }
        });
    }

    private void buttonEditarReglaActionPerformed(java.awt.event.ActionEvent evt) {

        int filaSeleccionada = formaApliFertiEdicionReglasPanel.jTableFormaAplicarFertilizante.getSelectedRow();
        if (filaSeleccionada >= 0) {
            FormaAplicarFertilizanteRegla formaApliFertiReglaEditar = listaReglaFormaAplicarFertilizante.get(filaSeleccionada);
            formaApliFertiEdicionReglasPanel.jTextFieldId.setText(formaApliFertiReglaEditar.getIdFormaAplicFertilizante() + "");
            formaApliFertiEdicionReglasPanel.jTextFieldNombreRegla.setText(formaApliFertiReglaEditar.getNombreRegla() + "");
            formaApliFertiEdicionReglasPanel.jComboBoxPremisa.setSelectedItem(formaApliFertiReglaEditar.getHortalizaAFertilizar());
            formaApliFertiEdicionReglasPanel.jTextAreaConclusion.setText(formaApliFertiReglaEditar.getConclusion() + "");
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un Regla para la edicion", "Falta seleccionar", JOptionPane.ERROR_MESSAGE);
        }
        actionAceptar = "EDIT";

        formaApliFertiEdicionReglasPanel.jTextFieldId.setEnabled(false);
        formaApliFertiEdicionReglasPanel.jTextFieldId.setDisabledTextColor(Color.gray);
        formaApliFertiEdicionReglasPanel.jTextFieldNombreRegla.setEnabled(true);
        formaApliFertiEdicionReglasPanel.jTextFieldNombreRegla.setDisabledTextColor(Color.white);
        formaApliFertiEdicionReglasPanel.jComboBoxPremisa.setEnabled(true);
        formaApliFertiEdicionReglasPanel.jTextAreaConclusion.setEnabled(true);
        formaApliFertiEdicionReglasPanel.jTextAreaConclusion.setDisabledTextColor(Color.white);

    }

    private void buttonAnadirReglaActionPerformed(java.awt.event.ActionEvent evt) {
        // System.out.println("hola soy el botun añadir");
        formaApliFertiEdicionReglasPanel.jTextFieldId.setText("");
        formaApliFertiEdicionReglasPanel.jTextFieldNombreRegla.setText("");
        //formaApliFertiEdicionReglasPanel.jTextFieldPremisa.setText("");
        formaApliFertiEdicionReglasPanel.jTextAreaConclusion.setText("");

        actionAceptar = "ADD";

        formaApliFertiEdicionReglasPanel.jTextFieldId.setEnabled(false);
        formaApliFertiEdicionReglasPanel.jTextFieldId.setDisabledTextColor(Color.gray);
        formaApliFertiEdicionReglasPanel.jTextFieldNombreRegla.setEnabled(true);
        formaApliFertiEdicionReglasPanel.jTextFieldNombreRegla.setDisabledTextColor(Color.white);
        formaApliFertiEdicionReglasPanel.jComboBoxPremisa.setEnabled(true);
        formaApliFertiEdicionReglasPanel.jTextAreaConclusion.setEnabled(true);
        formaApliFertiEdicionReglasPanel.jTextAreaConclusion.setDisabledTextColor(Color.white);

    }

    private void buttonEliminarReglaActionPerformed(java.awt.event.ActionEvent evt) {
        int filaSeleccionada = formaApliFertiEdicionReglasPanel.jTableFormaAplicarFertilizante.getSelectedRow();
        if (filaSeleccionada >= 0) {
            FormaAplicarFertilizanteRegla formaApliFertiReglaEditar = listaReglaFormaAplicarFertilizante.get(filaSeleccionada);
            formaApliFertiEdicionReglasPanel.jTextFieldId.setText(formaApliFertiReglaEditar.getIdFormaAplicFertilizante() + "");
            formaApliFertiEdicionReglasPanel.jTextFieldNombreRegla.setText(formaApliFertiReglaEditar.getNombreRegla() + "");
            formaApliFertiEdicionReglasPanel.jComboBoxPremisa.setSelectedItem(formaApliFertiReglaEditar.getHortalizaAFertilizar());
            formaApliFertiEdicionReglasPanel.jTextAreaConclusion.setText(formaApliFertiReglaEditar.getConclusion() + "");
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un Regla para la edicion", "Falta seleccionar", JOptionPane.ERROR_MESSAGE);
        }

        actionAceptar = "DELETE";

        formaApliFertiEdicionReglasPanel.jTextFieldId.setEnabled(false);
        formaApliFertiEdicionReglasPanel.jTextFieldId.setDisabledTextColor(Color.gray);
        formaApliFertiEdicionReglasPanel.jTextFieldNombreRegla.setEnabled(false);
        formaApliFertiEdicionReglasPanel.jTextFieldNombreRegla.setDisabledTextColor(Color.gray);
        formaApliFertiEdicionReglasPanel.jComboBoxPremisa.setEnabled(false);
        formaApliFertiEdicionReglasPanel.jTextAreaConclusion.setEnabled(false);
        formaApliFertiEdicionReglasPanel.jTextAreaConclusion.setDisabledTextColor(Color.gray);
    }

    public void confbuttonAceptar() {
        formaApliFertiEdicionReglasPanel.jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAceptarActionPerformed(evt);
            }
        });
    }

    private void buttonAceptarActionPerformed(java.awt.event.ActionEvent evt) {
        //System.out.println("hola soy el botun aceptar");
        switch (actionAceptar) {
            case "EDIT":
                int idReglaEdit = Integer.parseInt(formaApliFertiEdicionReglasPanel.jTextFieldId.getText());
                FormaAplicarFertilizanteRegla formaApliFertiReglaEditar = new FormaAplicarFertilizanteRegla();
                formaApliFertiReglaEditar.setNombreRegla(formaApliFertiEdicionReglasPanel.jTextFieldNombreRegla.getText());
                formaApliFertiReglaEditar.setHortalizaAFertilizar((String) formaApliFertiEdicionReglasPanel.jComboBoxPremisa.getSelectedItem());
                formaApliFertiReglaEditar.setConclusion(formaApliFertiEdicionReglasPanel.jTextAreaConclusion.getText());

                formaApliFertiReglaService.updateFormaApliFertiRegla(idReglaEdit, formaApliFertiReglaEditar);
                llenarJTable();

                //para guardar en archivo drl en formato drools
                formaApliFertiReglaService.actualizarReglasFormaApliFertiDrl();
                //nitrogenoedicionReglasPanel.jPanelEdicion.setVisible(false);

                break;
            case "ADD":
                // System.out.println("hola estoy anadiendo");
                //int idReglaAdd = Integer.parseInt(formaApliFertiEdicionReglasPanel.jTextFieldId.getText());
                FormaAplicarFertilizanteRegla formaApliFertiReglaAnadir = new FormaAplicarFertilizanteRegla();
                formaApliFertiReglaAnadir.setNombreRegla(formaApliFertiEdicionReglasPanel.jTextFieldNombreRegla.getText());
                formaApliFertiReglaAnadir.setHortalizaAFertilizar((String) formaApliFertiEdicionReglasPanel.jComboBoxPremisa.getSelectedItem());
                formaApliFertiReglaAnadir.setConclusion(formaApliFertiEdicionReglasPanel.jTextAreaConclusion.getText());

                formaApliFertiReglaService.createFormaApliFertiRegla(formaApliFertiReglaAnadir);

                listaReglaFormaAplicarFertilizante = formaApliFertiReglaService.readAllFormaApliFerti();
                llenarJTable();

                //para guardar en archivo drl en formato drools descomentar
                formaApliFertiReglaService.actualizarReglasFormaApliFertiDrl();
                break;
            case "DELETE":
                int idReglaDelete = Integer.parseInt(formaApliFertiEdicionReglasPanel.jTextFieldId.getText());
                //NitrogenoRegla nitrogenoRegla = listaReglaNitrogeno.get(idReglaAdd);
                formaApliFertiReglaService.deleteFormaApliFertiRegla(idReglaDelete);
                llenarJTable();
                //para guardar en archivo drl en formato drools descomentar
                formaApliFertiReglaService.actualizarReglasFormaApliFertiDrl();
                //nitrogenoedicionReglasPanel.jPanelEdicion.setVisible(false);
                break;
            default:
                System.out.println("No hay Valores");
                break;
        }

    }

}
