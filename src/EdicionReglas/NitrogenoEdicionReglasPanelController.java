/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EdicionReglas;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.NitrogenoRegla;
import service.NitrogenoReglaService;

/**
 *
 * @author Erlinda
 */
public class NitrogenoEdicionReglasPanelController {

    NitrogenoEdicionReglasPanel nitrogenoedicionReglasPanel;
    NitrogenoReglaService nitrogenoReglaService;
    ArrayList<NitrogenoRegla> listaReglaNitrogeno;

    String actionAceptar;

    public NitrogenoEdicionReglasPanelController(NitrogenoEdicionReglasPanel nitrogenoedicionReglasPanel) {
        this.nitrogenoedicionReglasPanel = nitrogenoedicionReglasPanel;
        nitrogenoReglaService = new NitrogenoReglaService();
        //llenarReglasService();
        listaReglaNitrogeno = nitrogenoReglaService.readAllNitrogeno();
        llenarJTable();
        confBotonesEdicion();
        buttonAceptar();
        actionAceptar = "";

        nitrogenoedicionReglasPanel.jTextFieldId.setEnabled(false);
        nitrogenoedicionReglasPanel.jTextFieldId.setText("");
        nitrogenoedicionReglasPanel.jTextFieldNombreRegla.setEnabled(false);
        nitrogenoedicionReglasPanel.jTextFieldNombreRegla.setText("");
        nitrogenoedicionReglasPanel.jTextFieldPremisa1.setEnabled(false);
        nitrogenoedicionReglasPanel.jTextFieldPremisa1.setText("");
        nitrogenoedicionReglasPanel.jTextFieldPremisa2.setEnabled(false);
        nitrogenoedicionReglasPanel.jTextFieldPremisa2.setText("");
        nitrogenoedicionReglasPanel.jTextFieldConclusion.setEnabled(false);
        nitrogenoedicionReglasPanel.jTextFieldConclusion.setText("");

        //nitrogenoedicionReglasPanel.jPanelEdicion.setVisible(false);
    }

    public void llenarJTable() {
        DefaultTableModel dtm = (DefaultTableModel) nitrogenoedicionReglasPanel.jTableNitrogeno.getModel();
        dtm.setRowCount(0);
        for (int i = 0; i < listaReglaNitrogeno.size(); i++) {
            dtm.addRow(new Object[]{
                listaReglaNitrogeno.get(i).getIdNitrogenoRegla(),
                listaReglaNitrogeno.get(i).getNombreRegla(),
                listaReglaNitrogeno.get(i).getLimiteInferior(),
                listaReglaNitrogeno.get(i).getLimiteSuperior(),
                listaReglaNitrogeno.get(i).getConclusion()
            });
        }
    }

    public void confBotonesEdicion() {

        nitrogenoedicionReglasPanel.jButtonEditarRegla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditarReglaActionPerformed(evt);
            }
        });

        nitrogenoedicionReglasPanel.jButtonAnadirRegla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAnadirReglaActionPerformed(evt);
            }
        });

        nitrogenoedicionReglasPanel.jButtonEliminarRegla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEliminarReglaActionPerformed(evt);
            }
        });
    }

    private void buttonEditarReglaActionPerformed(java.awt.event.ActionEvent evt) {
        int filaSeleccionada = nitrogenoedicionReglasPanel.jTableNitrogeno.getSelectedRow();
        if (filaSeleccionada >= 0) {
            NitrogenoRegla nitrogenoReglaEditar = listaReglaNitrogeno.get(filaSeleccionada);
            nitrogenoedicionReglasPanel.jTextFieldId.setText(nitrogenoReglaEditar.getIdNitrogenoRegla() + "");
            nitrogenoedicionReglasPanel.jTextFieldNombreRegla.setText(nitrogenoReglaEditar.getNombreRegla() + "");
            nitrogenoedicionReglasPanel.jTextFieldPremisa1.setText(nitrogenoReglaEditar.getLimiteInferior() + "");
            nitrogenoedicionReglasPanel.jTextFieldPremisa2.setText(nitrogenoReglaEditar.getLimiteSuperior() + "");
            nitrogenoedicionReglasPanel.jTextFieldConclusion.setText(nitrogenoReglaEditar.getConclusion() + "");
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un Regla para la edicion", "Falta seleccionar", JOptionPane.ERROR_MESSAGE);
        }
        actionAceptar = "EDIT";

        nitrogenoedicionReglasPanel.jTextFieldId.setEnabled(false);
        nitrogenoedicionReglasPanel.jTextFieldId.setDisabledTextColor(Color.gray);
        nitrogenoedicionReglasPanel.jTextFieldNombreRegla.setEnabled(true);
        nitrogenoedicionReglasPanel.jTextFieldNombreRegla.setDisabledTextColor(Color.white);
        nitrogenoedicionReglasPanel.jTextFieldPremisa1.setEnabled(true);
        nitrogenoedicionReglasPanel.jTextFieldPremisa1.setDisabledTextColor(Color.white);
        nitrogenoedicionReglasPanel.jTextFieldPremisa2.setEnabled(true);
        nitrogenoedicionReglasPanel.jTextFieldPremisa2.setDisabledTextColor(Color.white);
        nitrogenoedicionReglasPanel.jTextFieldConclusion.setEnabled(true);
        nitrogenoedicionReglasPanel.jTextFieldConclusion.setDisabledTextColor(Color.white);

        //nitrogenoedicionReglasPanel.jPanelEdicion.setVisible(true);
    }

    private void buttonAnadirReglaActionPerformed(java.awt.event.ActionEvent evt) {
        nitrogenoedicionReglasPanel.jTextFieldId.setText("");
        nitrogenoedicionReglasPanel.jTextFieldNombreRegla.setText("");
        nitrogenoedicionReglasPanel.jTextFieldPremisa1.setText("");
        nitrogenoedicionReglasPanel.jTextFieldPremisa2.setText("");
        nitrogenoedicionReglasPanel.jTextFieldConclusion.setText("");

        actionAceptar = "ADD";

        nitrogenoedicionReglasPanel.jTextFieldId.setEnabled(false);
        nitrogenoedicionReglasPanel.jTextFieldId.setDisabledTextColor(Color.gray);
        nitrogenoedicionReglasPanel.jTextFieldNombreRegla.setEnabled(true);
        nitrogenoedicionReglasPanel.jTextFieldNombreRegla.setDisabledTextColor(Color.white);
        nitrogenoedicionReglasPanel.jTextFieldPremisa1.setEnabled(true);
        nitrogenoedicionReglasPanel.jTextFieldPremisa1.setDisabledTextColor(Color.white);
        nitrogenoedicionReglasPanel.jTextFieldPremisa2.setEnabled(true);
        nitrogenoedicionReglasPanel.jTextFieldPremisa2.setDisabledTextColor(Color.white);
        nitrogenoedicionReglasPanel.jTextFieldConclusion.setEnabled(true);
        nitrogenoedicionReglasPanel.jTextFieldConclusion.setDisabledTextColor(Color.white);

        //nitrogenoedicionReglasPanel.jPanelEdicion.setVisible(true);
    }

    private void buttonEliminarReglaActionPerformed(java.awt.event.ActionEvent evt) {
        int filaSeleccionada = nitrogenoedicionReglasPanel.jTableNitrogeno.getSelectedRow();
        if (filaSeleccionada >= 0) {
            NitrogenoRegla nitrogenoReglaEditar = listaReglaNitrogeno.get(filaSeleccionada);
            nitrogenoedicionReglasPanel.jTextFieldId.setText(nitrogenoReglaEditar.getIdNitrogenoRegla() + "");
            nitrogenoedicionReglasPanel.jTextFieldNombreRegla.setText(nitrogenoReglaEditar.getNombreRegla() + "");
            nitrogenoedicionReglasPanel.jTextFieldPremisa1.setText(nitrogenoReglaEditar.getLimiteInferior() + "");
            nitrogenoedicionReglasPanel.jTextFieldPremisa2.setText(nitrogenoReglaEditar.getLimiteSuperior() + "");
            nitrogenoedicionReglasPanel.jTextFieldConclusion.setText(nitrogenoReglaEditar.getConclusion() + "");
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un Regla para la edicion", "Falta seleccionar", JOptionPane.ERROR_MESSAGE);
        }

        actionAceptar = "DELETE";

        nitrogenoedicionReglasPanel.jTextFieldId.setEnabled(false);
        nitrogenoedicionReglasPanel.jTextFieldId.setDisabledTextColor(Color.gray);
        nitrogenoedicionReglasPanel.jTextFieldNombreRegla.setEnabled(false);
        nitrogenoedicionReglasPanel.jTextFieldNombreRegla.setDisabledTextColor(Color.gray);
        nitrogenoedicionReglasPanel.jTextFieldPremisa1.setEnabled(false);
        nitrogenoedicionReglasPanel.jTextFieldPremisa1.setDisabledTextColor(Color.gray);
        nitrogenoedicionReglasPanel.jTextFieldPremisa2.setEnabled(false);
        nitrogenoedicionReglasPanel.jTextFieldPremisa2.setDisabledTextColor(Color.gray);
        nitrogenoedicionReglasPanel.jTextFieldConclusion.setEnabled(false);
        nitrogenoedicionReglasPanel.jTextFieldConclusion.setDisabledTextColor(Color.gray);

        //nitrogenoedicionReglasPanel.jPanelEdicion.setVisible(true);
    }

    public void buttonAceptar() {
        nitrogenoedicionReglasPanel.jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAceptarActionPerformed(evt);
            }
        });
    }

    private void buttonAceptarActionPerformed(java.awt.event.ActionEvent evt) {
        // System.out.println(actionAceptar);
        switch (actionAceptar) {
            case "EDIT":
                int idReglaEdit = Integer.parseInt(nitrogenoedicionReglasPanel.jTextFieldId.getText());
                NitrogenoRegla nitrogenoReglaEditar = new NitrogenoRegla();
                nitrogenoReglaEditar.setNombreRegla(nitrogenoedicionReglasPanel.jTextFieldNombreRegla.getText());
                nitrogenoReglaEditar.setLimiteInferior(Integer.parseInt(nitrogenoedicionReglasPanel.jTextFieldPremisa1.getText()));
                nitrogenoReglaEditar.setLimiteSuperior(Integer.parseInt(nitrogenoedicionReglasPanel.jTextFieldPremisa2.getText()));
                nitrogenoReglaEditar.setConclusion(nitrogenoedicionReglasPanel.jTextFieldConclusion.getText());

                nitrogenoReglaService.updateNitrogenoRegla(idReglaEdit, nitrogenoReglaEditar);
                llenarJTable();

                //para guardar en archivo drl en formato drools
                nitrogenoReglaService.actualizarReglasNitrogenoDrl();
                //nitrogenoedicionReglasPanel.jPanelEdicion.setVisible(false);
                break;
            case "ADD":
                //int idReglaAdd = Integer.parseInt(nitrogenoedicionReglasPanel.jTextFieldId.getText());
                NitrogenoRegla nitrogenoReglaAnadir = new NitrogenoRegla();
                nitrogenoReglaAnadir.setNombreRegla(nitrogenoedicionReglasPanel.jTextFieldNombreRegla.getText());
                nitrogenoReglaAnadir.setLimiteInferior(Integer.parseInt(nitrogenoedicionReglasPanel.jTextFieldPremisa1.getText()));
                nitrogenoReglaAnadir.setLimiteSuperior(Integer.parseInt(nitrogenoedicionReglasPanel.jTextFieldPremisa2.getText()));
                nitrogenoReglaAnadir.setConclusion(nitrogenoedicionReglasPanel.jTextFieldConclusion.getText());

                nitrogenoReglaService.createNitrogenoRegla(nitrogenoReglaAnadir);
                
                listaReglaNitrogeno = nitrogenoReglaService.readAllNitrogeno();
                
                llenarJTable();

                //para guardar en archivo drl en formato drools descomentar
                nitrogenoReglaService.actualizarReglasNitrogenoDrl();
                //nitrogenoedicionReglasPanel.jPanelEdicion.setVisible(false);
                break;
            case "DELETE":
                int idReglaDelete = Integer.parseInt(nitrogenoedicionReglasPanel.jTextFieldId.getText());
                //NitrogenoRegla nitrogenoRegla = listaReglaNitrogeno.get(idReglaAdd);
                nitrogenoReglaService.deleteNitrogenoRegla(idReglaDelete);
                llenarJTable();
                //para guardar en archivo drl en formato drools descomentar
                nitrogenoReglaService.actualizarReglasNitrogenoDrl();
                //nitrogenoedicionReglasPanel.jPanelEdicion.setVisible(false);
                break;
            default:
                System.out.println("No hay Valores");
                break;
        }
        nitrogenoedicionReglasPanel.jTextFieldId.setEnabled(false);
        nitrogenoedicionReglasPanel.jTextFieldId.setText("");
        nitrogenoedicionReglasPanel.jTextFieldNombreRegla.setEnabled(false);
        nitrogenoedicionReglasPanel.jTextFieldNombreRegla.setText("");
        nitrogenoedicionReglasPanel.jTextFieldPremisa1.setEnabled(false);
        nitrogenoedicionReglasPanel.jTextFieldPremisa1.setText("");
        nitrogenoedicionReglasPanel.jTextFieldPremisa2.setEnabled(false);
        nitrogenoedicionReglasPanel.jTextFieldPremisa2.setText("");
        nitrogenoedicionReglasPanel.jTextFieldConclusion.setEnabled(false);
        nitrogenoedicionReglasPanel.jTextFieldConclusion.setText("");
    }

//    public void llenarReglasService() {
//
//        NitrogenoRegla nitrogenoRegla = new NitrogenoRegla();
//        nitrogenoRegla.setIdNitrogenoRegla(40);
//        nitrogenoRegla.setNombreRegla("Nivel de Nitrogeno Muy Alto");
//        nitrogenoRegla.setLimiteInferior(110);
//        nitrogenoRegla.setLimiteSuperior(120);
//        nitrogenoRegla.setConclusion("Muy Alto");
//
//        NitrogenoRegla nitrogenoRegla2 = new NitrogenoRegla();
//        nitrogenoRegla2.setIdNitrogenoRegla(41);
//        nitrogenoRegla2.setNombreRegla("Nivel de Nitrogeno Super bajo");
//        nitrogenoRegla2.setLimiteInferior(0);
//        nitrogenoRegla2.setLimiteSuperior(10);
//        nitrogenoRegla2.setConclusion("Super Bajo");
//
//        NitrogenoRegla nitrogenoRegla3 = new NitrogenoRegla();
//        nitrogenoRegla3.setIdNitrogenoRegla(42);
//        nitrogenoRegla3.setNombreRegla("Nivel de Nitrogeno Regular");
//        nitrogenoRegla3.setLimiteInferior(30);
//        nitrogenoRegla3.setLimiteSuperior(50);
//        nitrogenoRegla3.setConclusion("Regular");
//
//        nitrogenoReglaService.createNitrogenoRegla(nitrogenoRegla);
//        nitrogenoReglaService.createNitrogenoRegla(nitrogenoRegla2);
//        nitrogenoReglaService.createNitrogenoRegla(nitrogenoRegla3);
//    }
}
