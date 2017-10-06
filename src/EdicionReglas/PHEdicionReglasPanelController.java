/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EdicionReglas;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.PhRegla;
import service.PhReglaService;

/**
 *
 * @author Erlinda
 */
public class PHEdicionReglasPanelController {

    PHEdicionReglasPanel phEdicionReglasPanel;
    PhReglaService phReglaService;
    ArrayList<PhRegla> listaReglaPh;

    String actionAceptar;

    public PHEdicionReglasPanelController(PHEdicionReglasPanel phEdicionReglasPanel) {
        this.phEdicionReglasPanel = phEdicionReglasPanel;
        phReglaService = new PhReglaService();
        llenarReglasService();
        listaReglaPh = phReglaService.readAllPh();
        llenarJTable();
        confBotonesEdicion();
        buttonAceptar();
    }

    public void llenarJTable() {
        DefaultTableModel dtm = (DefaultTableModel) phEdicionReglasPanel.jTablePH.getModel();
        dtm.setRowCount(0);
        for (int i = 0; i < listaReglaPh.size(); i++) {
            dtm.addRow(new Object[]{
                listaReglaPh.get(i).getIdPhRegla(),
                listaReglaPh.get(i).getNombreRegla(),
                listaReglaPh.get(i).getLimiteInferior(),
                listaReglaPh.get(i).getLimiteSuperior(),
                listaReglaPh.get(i).getConclusion()
            });
        }
    }

    public void confBotonesEdicion() {

        phEdicionReglasPanel.jButtonEditarRegla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditarReglaActionPerformed(evt);
            }
        });

        phEdicionReglasPanel.jButtonAnadirRegla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAnadirReglaActionPerformed(evt);
            }
        });

        phEdicionReglasPanel.jButtonEliminarRegla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEliminarReglaActionPerformed(evt);
            }
        });
    }

    private void buttonEditarReglaActionPerformed(java.awt.event.ActionEvent evt) {
        int filaSeleccionada = phEdicionReglasPanel.jTablePH.getSelectedRow();
        if (filaSeleccionada >= 0) {
            PhRegla phReglaEditar = listaReglaPh.get(filaSeleccionada);
            phEdicionReglasPanel.jTextFieldId.setText(phReglaEditar.getIdPhRegla()+ "");
            phEdicionReglasPanel.jTextFieldNombreRegla.setText(phReglaEditar.getNombreRegla() + "");
            phEdicionReglasPanel.jTextFieldPremisa1.setText(phReglaEditar.getLimiteInferior() + "");
            phEdicionReglasPanel.jTextFieldPremisa2.setText(phReglaEditar.getLimiteSuperior() + "");
            phEdicionReglasPanel.jTextFieldConclusion.setText(phReglaEditar.getConclusion() + "");
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un Regla para la edicion", "Falta seleccionar", JOptionPane.ERROR_MESSAGE);
        }
        actionAceptar = "EDIT";
    }

    private void buttonAnadirReglaActionPerformed(java.awt.event.ActionEvent evt) {
        phEdicionReglasPanel.jTextFieldId.setText("");
        phEdicionReglasPanel.jTextFieldNombreRegla.setText("");
        phEdicionReglasPanel.jTextFieldPremisa1.setText("");
        phEdicionReglasPanel.jTextFieldPremisa2.setText("");
        phEdicionReglasPanel.jTextFieldConclusion.setText("");

        actionAceptar = "ADD";
    }

    private void buttonEliminarReglaActionPerformed(java.awt.event.ActionEvent evt) {
        int filaSeleccionada = phEdicionReglasPanel.jTablePH.getSelectedRow();
        if (filaSeleccionada >= 0) {
            PhRegla phReglaEditar = listaReglaPh.get(filaSeleccionada);
            phEdicionReglasPanel.jTextFieldId.setText(phReglaEditar.getIdPhRegla() + "");
            phEdicionReglasPanel.jTextFieldNombreRegla.setText(phReglaEditar.getNombreRegla() + "");
            phEdicionReglasPanel.jTextFieldPremisa1.setText(phReglaEditar.getLimiteInferior() + "");
            phEdicionReglasPanel.jTextFieldPremisa2.setText(phReglaEditar.getLimiteSuperior() + "");
            phEdicionReglasPanel.jTextFieldConclusion.setText(phReglaEditar.getConclusion() + "");
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un Regla para la edicion", "Falta seleccionar", JOptionPane.ERROR_MESSAGE);
        }

        actionAceptar = "DELETE";
    }

    public void buttonAceptar() {
        phEdicionReglasPanel.jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAceptarActionPerformed(evt);
            }
        });
    }

    private void buttonAceptarActionPerformed(java.awt.event.ActionEvent evt) {
        switch (actionAceptar) {
            case "EDIT":
                int idReglaEdit = Integer.parseInt(phEdicionReglasPanel.jTextFieldId.getText());
                PhRegla phReglaEditar = new PhRegla();
                phReglaEditar.setNombreRegla(phEdicionReglasPanel.jTextFieldNombreRegla.getText());
                phReglaEditar.setLimiteInferior(Integer.parseInt(phEdicionReglasPanel.jTextFieldPremisa1.getText()));
                phReglaEditar.setLimiteSuperior(Integer.parseInt(phEdicionReglasPanel.jTextFieldPremisa2.getText()));
                phReglaEditar.setConclusion(phEdicionReglasPanel.jTextFieldConclusion.getText());

                phReglaService.updatePhRegla(idReglaEdit, phReglaEditar);
                llenarJTable();

                //para guardar en archivo drl en formato drools
                phReglaService.actualizarReglasPHDrl();

                break;
            case "ADD":
                int idReglaAdd = Integer.parseInt(phEdicionReglasPanel.jTextFieldId.getText());
                PhRegla phReglaAnadir = new PhRegla();
                phReglaAnadir.setNombreRegla(phEdicionReglasPanel.jTextFieldNombreRegla.getText());
                phReglaAnadir.setLimiteInferior(Integer.parseInt(phEdicionReglasPanel.jTextFieldPremisa1.getText()));
                phReglaAnadir.setLimiteSuperior(Integer.parseInt(phEdicionReglasPanel.jTextFieldPremisa2.getText()));
                phReglaAnadir.setConclusion(phEdicionReglasPanel.jTextFieldConclusion.getText());

                phReglaService.createPhRegla(phReglaAnadir);
                llenarJTable();

                //para guardar en archivo drl en formato drools descomentar
                phReglaService.actualizarReglasPHDrl();
                break;
            case "DELETE":
                int idReglaDelete = Integer.parseInt(phEdicionReglasPanel.jTextFieldId.getText());

                phReglaService.deletePhRegla(idReglaDelete);
                llenarJTable();
                //para guardar en archivo drl en formato drools descomentar
                phReglaService.actualizarReglasPHDrl();
                break;
            default:
                System.out.println("No hay Valores");
                break;
        }

    }

    public void llenarReglasService() {

        PhRegla phRegla = new PhRegla();
        phRegla.setIdPhRegla(1);
        phRegla.setNombreRegla("Nivel de ph Muy Alto");
        phRegla.setLimiteInferior(110);
        phRegla.setLimiteSuperior(120);
        phRegla.setConclusion("Muy Alto");

        PhRegla phRegla2 = new PhRegla();
        phRegla2.setIdPhRegla(2);
        phRegla2.setNombreRegla("Nivel de ph Super bajo");
        phRegla2.setLimiteInferior(0);
        phRegla2.setLimiteSuperior(10);
        phRegla2.setConclusion("Super Bajo");

        PhRegla phRegla3 = new PhRegla();
        phRegla3.setIdPhRegla(3);
        phRegla3.setNombreRegla("Nivel de ph Regular");
        phRegla3.setLimiteInferior(30);
        phRegla3.setLimiteSuperior(50);
        phRegla3.setConclusion("Regular");

        phReglaService.createPhRegla(phRegla);
        phReglaService.createPhRegla(phRegla2);
        phReglaService.createPhRegla(phRegla3);
    }
}
