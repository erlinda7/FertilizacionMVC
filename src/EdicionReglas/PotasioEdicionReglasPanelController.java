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
import model.PotasioRegla;
import service.PotasioReglaService;

/**
 *
 * @author Erlinda
 */
public class PotasioEdicionReglasPanelController {

    PotasioEdicionReglasPanel potasioEdicionReglasPanel;
    PotasioReglaService potasioReglaService;
    ArrayList<PotasioRegla> listaReglaPotasio;

    String actionAceptar;

    public PotasioEdicionReglasPanelController(PotasioEdicionReglasPanel potasioEdicionReglasPanel) {
        this.potasioEdicionReglasPanel = potasioEdicionReglasPanel;
        potasioReglaService = new PotasioReglaService();
        //llenarReglasService();
        listaReglaPotasio = potasioReglaService.readAllPotasio();
        llenarJTable();
        confBotonesEdicion();
        buttonAceptar();
        actionAceptar = "";

        potasioEdicionReglasPanel.jTextFieldId.setEnabled(false);
        potasioEdicionReglasPanel.jTextFieldId.setText("");
        potasioEdicionReglasPanel.jTextFieldNombreRegla.setEnabled(false);
        potasioEdicionReglasPanel.jTextFieldNombreRegla.setText("");
        potasioEdicionReglasPanel.jTextFieldPremisa1.setEnabled(false);
        potasioEdicionReglasPanel.jTextFieldPremisa1.setText("");
        potasioEdicionReglasPanel.jTextFieldPremisa2.setEnabled(false);
        potasioEdicionReglasPanel.jTextFieldPremisa2.setText("");
        potasioEdicionReglasPanel.jTextFieldConclusion.setEnabled(false);
        potasioEdicionReglasPanel.jTextFieldConclusion.setText("");
    }

    public void llenarJTable() {
        DefaultTableModel dtm = (DefaultTableModel) potasioEdicionReglasPanel.jTablePotasio.getModel();
        dtm.setRowCount(0);
        for (int i = 0; i < listaReglaPotasio.size(); i++) {
            dtm.addRow(new Object[]{
                listaReglaPotasio.get(i).getIdPotasioRegla(),
                listaReglaPotasio.get(i).getNombreRegla(),
                listaReglaPotasio.get(i).getLimiteInferior(),
                listaReglaPotasio.get(i).getLimiteSuperior(),
                listaReglaPotasio.get(i).getConclusion()
            });
        }
    }

    public void confBotonesEdicion() {

        potasioEdicionReglasPanel.jButtonEditarRegla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditarReglaActionPerformed(evt);
            }
        });

        potasioEdicionReglasPanel.jButtonAnadirRegla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAnadirReglaActionPerformed(evt);
            }
        });

        potasioEdicionReglasPanel.jButtonEliminarRegla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEliminarReglaActionPerformed(evt);
            }
        });
    }

    private void buttonEditarReglaActionPerformed(java.awt.event.ActionEvent evt) {
        int filaSeleccionada = potasioEdicionReglasPanel.jTablePotasio.getSelectedRow();
        if (filaSeleccionada >= 0) {
            PotasioRegla potasioReglaEditar = listaReglaPotasio.get(filaSeleccionada);
            potasioEdicionReglasPanel.jTextFieldId.setText(potasioReglaEditar.getIdPotasioRegla() + "");
            potasioEdicionReglasPanel.jTextFieldNombreRegla.setText(potasioReglaEditar.getNombreRegla() + "");
            potasioEdicionReglasPanel.jTextFieldPremisa1.setText(potasioReglaEditar.getLimiteInferior() + "");
            potasioEdicionReglasPanel.jTextFieldPremisa2.setText(potasioReglaEditar.getLimiteSuperior() + "");
            potasioEdicionReglasPanel.jTextFieldConclusion.setText(potasioReglaEditar.getConclusion() + "");
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un Regla para la edicion", "Falta seleccionar", JOptionPane.ERROR_MESSAGE);
        }
        actionAceptar = "EDIT";

        potasioEdicionReglasPanel.jTextFieldId.setEnabled(false);
        potasioEdicionReglasPanel.jTextFieldId.setDisabledTextColor(Color.gray);
        potasioEdicionReglasPanel.jTextFieldNombreRegla.setEnabled(true);
        potasioEdicionReglasPanel.jTextFieldNombreRegla.setDisabledTextColor(Color.white);
        potasioEdicionReglasPanel.jTextFieldPremisa1.setEnabled(true);
        potasioEdicionReglasPanel.jTextFieldPremisa1.setDisabledTextColor(Color.white);
        potasioEdicionReglasPanel.jTextFieldPremisa2.setEnabled(true);
        potasioEdicionReglasPanel.jTextFieldPremisa2.setDisabledTextColor(Color.white);
        potasioEdicionReglasPanel.jTextFieldConclusion.setEnabled(true);
        potasioEdicionReglasPanel.jTextFieldConclusion.setDisabledTextColor(Color.white);
    }

    private void buttonAnadirReglaActionPerformed(java.awt.event.ActionEvent evt) {
        potasioEdicionReglasPanel.jTextFieldId.setText("");
        potasioEdicionReglasPanel.jTextFieldNombreRegla.setText("");
        potasioEdicionReglasPanel.jTextFieldPremisa1.setText("");
        potasioEdicionReglasPanel.jTextFieldPremisa2.setText("");
        potasioEdicionReglasPanel.jTextFieldConclusion.setText("");

        actionAceptar = "ADD";

        potasioEdicionReglasPanel.jTextFieldId.setEnabled(false);
        potasioEdicionReglasPanel.jTextFieldId.setDisabledTextColor(Color.gray);
        potasioEdicionReglasPanel.jTextFieldNombreRegla.setEnabled(true);
        potasioEdicionReglasPanel.jTextFieldNombreRegla.setDisabledTextColor(Color.white);
        potasioEdicionReglasPanel.jTextFieldPremisa1.setEnabled(true);
        potasioEdicionReglasPanel.jTextFieldPremisa1.setDisabledTextColor(Color.white);
        potasioEdicionReglasPanel.jTextFieldPremisa2.setEnabled(true);
        potasioEdicionReglasPanel.jTextFieldPremisa2.setDisabledTextColor(Color.white);
        potasioEdicionReglasPanel.jTextFieldConclusion.setEnabled(true);
        potasioEdicionReglasPanel.jTextFieldConclusion.setDisabledTextColor(Color.white);
    }

    private void buttonEliminarReglaActionPerformed(java.awt.event.ActionEvent evt) {
        int filaSeleccionada = potasioEdicionReglasPanel.jTablePotasio.getSelectedRow();
        if (filaSeleccionada >= 0) {
            PotasioRegla potasioReglaEditar = listaReglaPotasio.get(filaSeleccionada);
            potasioEdicionReglasPanel.jTextFieldId.setText(potasioReglaEditar.getIdPotasioRegla() + "");
            potasioEdicionReglasPanel.jTextFieldNombreRegla.setText(potasioReglaEditar.getNombreRegla() + "");
            potasioEdicionReglasPanel.jTextFieldPremisa1.setText(potasioReglaEditar.getLimiteInferior() + "");
            potasioEdicionReglasPanel.jTextFieldPremisa2.setText(potasioReglaEditar.getLimiteSuperior() + "");
            potasioEdicionReglasPanel.jTextFieldConclusion.setText(potasioReglaEditar.getConclusion() + "");
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un Regla para la edicion", "Falta seleccionar", JOptionPane.ERROR_MESSAGE);
        }

        actionAceptar = "DELETE";

        potasioEdicionReglasPanel.jTextFieldId.setEnabled(false);
        potasioEdicionReglasPanel.jTextFieldId.setDisabledTextColor(Color.gray);
        potasioEdicionReglasPanel.jTextFieldNombreRegla.setEnabled(false);
        potasioEdicionReglasPanel.jTextFieldNombreRegla.setDisabledTextColor(Color.gray);
        potasioEdicionReglasPanel.jTextFieldPremisa1.setEnabled(false);
        potasioEdicionReglasPanel.jTextFieldPremisa1.setDisabledTextColor(Color.gray);
        potasioEdicionReglasPanel.jTextFieldPremisa2.setEnabled(false);
        potasioEdicionReglasPanel.jTextFieldPremisa2.setDisabledTextColor(Color.gray);
        potasioEdicionReglasPanel.jTextFieldConclusion.setEnabled(false);
        potasioEdicionReglasPanel.jTextFieldConclusion.setDisabledTextColor(Color.gray);
    }

    public void buttonAceptar() {
        potasioEdicionReglasPanel.jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAceptarActionPerformed(evt);
            }
        });
    }

    private void buttonAceptarActionPerformed(java.awt.event.ActionEvent evt) {
        switch (actionAceptar) {
            case "EDIT":
                int idReglaEdit = Integer.parseInt(potasioEdicionReglasPanel.jTextFieldId.getText());
                PotasioRegla potasioReglaEditar = new PotasioRegla();
                potasioReglaEditar.setNombreRegla(potasioEdicionReglasPanel.jTextFieldNombreRegla.getText());
                potasioReglaEditar.setLimiteInferior(Integer.parseInt(potasioEdicionReglasPanel.jTextFieldPremisa1.getText()));
                potasioReglaEditar.setLimiteSuperior(Integer.parseInt(potasioEdicionReglasPanel.jTextFieldPremisa2.getText()));
                potasioReglaEditar.setConclusion(potasioEdicionReglasPanel.jTextFieldConclusion.getText());

                potasioReglaService.updatePotasioRegla(idReglaEdit, potasioReglaEditar);
                llenarJTable();

                //para guardar en archivo drl en formato drools
                potasioReglaService.actualizarReglasPotasioDrl();

                break;
            case "ADD":
                int idReglaAdd = Integer.parseInt(potasioEdicionReglasPanel.jTextFieldId.getText());
                PotasioRegla potasioReglaAnadir = new PotasioRegla();
                potasioReglaAnadir.setNombreRegla(potasioEdicionReglasPanel.jTextFieldNombreRegla.getText());
                potasioReglaAnadir.setLimiteInferior(Integer.parseInt(potasioEdicionReglasPanel.jTextFieldPremisa1.getText()));
                potasioReglaAnadir.setLimiteSuperior(Integer.parseInt(potasioEdicionReglasPanel.jTextFieldPremisa2.getText()));
                potasioReglaAnadir.setConclusion(potasioEdicionReglasPanel.jTextFieldConclusion.getText());

                potasioReglaService.createPotasioRegla(potasioReglaAnadir);
                llenarJTable();

                //para guardar en archivo drl en formato drools descomentar
                potasioReglaService.actualizarReglasPotasioDrl();
                break;
            case "DELETE":
                int idReglaDelete = Integer.parseInt(potasioEdicionReglasPanel.jTextFieldId.getText());

                potasioReglaService.deletePotasioRegla(idReglaDelete);
                llenarJTable();
                //para guardar en archivo drl en formato drools descomentar
                potasioReglaService.actualizarReglasPotasioDrl();
                break;
            default:
                System.out.println("No hay Valores");
                break;
        }
        potasioEdicionReglasPanel.jTextFieldId.setEnabled(false);
        potasioEdicionReglasPanel.jTextFieldId.setText("");
        potasioEdicionReglasPanel.jTextFieldNombreRegla.setEnabled(false);
        potasioEdicionReglasPanel.jTextFieldNombreRegla.setText("");
        potasioEdicionReglasPanel.jTextFieldPremisa1.setEnabled(false);
        potasioEdicionReglasPanel.jTextFieldPremisa1.setText("");
        potasioEdicionReglasPanel.jTextFieldPremisa2.setEnabled(false);
        potasioEdicionReglasPanel.jTextFieldPremisa2.setText("");
        potasioEdicionReglasPanel.jTextFieldConclusion.setEnabled(false);
        potasioEdicionReglasPanel.jTextFieldConclusion.setText("");
    }

//    public void llenarReglasService() {
//
//        PotasioRegla potasioRegla = new PotasioRegla();
//        potasioRegla.setIdPotasioRegla(1);
//        potasioRegla.setNombreRegla("Nivel de Potasio Muy Alto");
//        potasioRegla.setLimiteInferior(110);
//        potasioRegla.setLimiteSuperior(120);
//        potasioRegla.setConclusion("Muy Alto");
//
//        PotasioRegla potasioRegla2 = new PotasioRegla();
//        potasioRegla2.setIdPotasioRegla(2);
//        potasioRegla2.setNombreRegla("Nivel de potasio Super bajo");
//        potasioRegla2.setLimiteInferior(0);
//        potasioRegla2.setLimiteSuperior(10);
//        potasioRegla2.setConclusion("Super Bajo");
//
//        PotasioRegla potasioRegla3 = new PotasioRegla();
//        potasioRegla3.setIdPotasioRegla(3);
//        potasioRegla3.setNombreRegla("Nivel de potasio Regular");
//        potasioRegla3.setLimiteInferior(30);
//        potasioRegla3.setLimiteSuperior(50);
//        potasioRegla3.setConclusion("Regular");
//
//        potasioReglaService.createPotasioRegla(potasioRegla);
//        potasioReglaService.createPotasioRegla(potasioRegla2);
//        potasioReglaService.createPotasioRegla(potasioRegla3);
//    }
}
