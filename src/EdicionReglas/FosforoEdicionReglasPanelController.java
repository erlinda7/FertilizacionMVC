/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EdicionReglas;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.FosforoRegla;
import service.FosforoReglaService;

/**
 *
 * @author Erlinda
 */
public class FosforoEdicionReglasPanelController {

    FosforoEdicionReglasPanel fosforoEdicionReglasPanel;
    FosforoReglaService fosforoReglaService;
    ArrayList<FosforoRegla> listaReglaFosforo;

    String actionAceptar;

    public FosforoEdicionReglasPanelController(FosforoEdicionReglasPanel fosforoEdicionReglasPanel) {
        this.fosforoEdicionReglasPanel = fosforoEdicionReglasPanel;
        fosforoReglaService = new FosforoReglaService();
        llenarReglasService();
        listaReglaFosforo = fosforoReglaService.readAllFosforo();
        llenarJTable();
        confBotonesEdicion();
        buttonAceptar();
    }

    public void llenarJTable() {
        DefaultTableModel dtm = (DefaultTableModel) fosforoEdicionReglasPanel.jTableFosforo.getModel();
        dtm.setRowCount(0);
        for (int i = 0; i < listaReglaFosforo.size(); i++) {
            dtm.addRow(new Object[]{
                listaReglaFosforo.get(i).getIdFosforoRegla(),
                listaReglaFosforo.get(i).getNombreRegla(),
                listaReglaFosforo.get(i).getLimiteInferior(),
                listaReglaFosforo.get(i).getLimiteSuperior(),
                listaReglaFosforo.get(i).getConclusion()
            });
        }
    }

    public void confBotonesEdicion() {

        fosforoEdicionReglasPanel.jButtonEditarRegla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditarReglaActionPerformed(evt);
            }
        });

        fosforoEdicionReglasPanel.jButtonAnadirRegla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAnadirReglaActionPerformed(evt);
            }
        });

        fosforoEdicionReglasPanel.jButtonEliminarRegla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEliminarReglaActionPerformed(evt);
            }
        });
    }

    private void buttonEditarReglaActionPerformed(java.awt.event.ActionEvent evt) {
        int filaSeleccionada = fosforoEdicionReglasPanel.jTableFosforo.getSelectedRow();
        if (filaSeleccionada >= 0) {
            FosforoRegla fosforoReglaEditar = listaReglaFosforo.get(filaSeleccionada);
            fosforoEdicionReglasPanel.jTextFieldId.setText(fosforoReglaEditar.getIdFosforoRegla() + "");
            fosforoEdicionReglasPanel.jTextFieldNombreRegla.setText(fosforoReglaEditar.getNombreRegla() + "");
            fosforoEdicionReglasPanel.jTextFieldPremisa1.setText(fosforoReglaEditar.getLimiteInferior() + "");
            fosforoEdicionReglasPanel.jTextFieldPremisa2.setText(fosforoReglaEditar.getLimiteSuperior() + "");
            fosforoEdicionReglasPanel.jTextFieldConclusion.setText(fosforoReglaEditar.getConclusion() + "");
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un Regla para la edicion", "Falta seleccionar", JOptionPane.ERROR_MESSAGE);
        }
        actionAceptar="EDIT";
    }

    private void buttonAnadirReglaActionPerformed(java.awt.event.ActionEvent evt) {
        fosforoEdicionReglasPanel.jTextFieldId.setText("");
        fosforoEdicionReglasPanel.jTextFieldNombreRegla.setText("");
        fosforoEdicionReglasPanel.jTextFieldPremisa1.setText("");
        fosforoEdicionReglasPanel.jTextFieldPremisa2.setText("");
        fosforoEdicionReglasPanel.jTextFieldConclusion.setText("");
        
        actionAceptar="ADD";
    }

    private void buttonEliminarReglaActionPerformed(java.awt.event.ActionEvent evt) {
        int filaSeleccionada = fosforoEdicionReglasPanel.jTableFosforo.getSelectedRow();
        if (filaSeleccionada >= 0) {
            FosforoRegla fosforoReglaEditar = listaReglaFosforo.get(filaSeleccionada);
            fosforoEdicionReglasPanel.jTextFieldId.setText(fosforoReglaEditar.getIdFosforoRegla() + "");
            fosforoEdicionReglasPanel.jTextFieldNombreRegla.setText(fosforoReglaEditar.getNombreRegla() + "");
            fosforoEdicionReglasPanel.jTextFieldPremisa1.setText(fosforoReglaEditar.getLimiteInferior() + "");
            fosforoEdicionReglasPanel.jTextFieldPremisa2.setText(fosforoReglaEditar.getLimiteSuperior() + "");
            fosforoEdicionReglasPanel.jTextFieldConclusion.setText(fosforoReglaEditar.getConclusion() + "");
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un Regla para la edicion", "Falta seleccionar", JOptionPane.ERROR_MESSAGE);
        }
        actionAceptar="DELETE";
    }

    public void buttonAceptar() {
        fosforoEdicionReglasPanel.jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAceptarActionPerformed(evt);
            }
        });
    }

    private void buttonAceptarActionPerformed(java.awt.event.ActionEvent evt) {
        switch (actionAceptar) {
            case "EDIT":
                int idReglaEdit = Integer.parseInt(fosforoEdicionReglasPanel.jTextFieldId.getText());
                FosforoRegla fosforoReglaEditar = new FosforoRegla();
                fosforoReglaEditar.setNombreRegla(fosforoEdicionReglasPanel.jTextFieldNombreRegla.getText());
                fosforoReglaEditar.setLimiteInferior(Integer.parseInt(fosforoEdicionReglasPanel.jTextFieldPremisa1.getText()));
                fosforoReglaEditar.setLimiteSuperior(Integer.parseInt(fosforoEdicionReglasPanel.jTextFieldPremisa2.getText()));
                fosforoReglaEditar.setConclusion(fosforoEdicionReglasPanel.jTextFieldConclusion.getText());

                fosforoReglaService.updateFosforoRegla(idReglaEdit, fosforoReglaEditar);
                llenarJTable();

                //para guardar en archivo drl en formato drools
                fosforoReglaService.actualizarReglasFosforoDrl();

                break;
            case "ADD":
                int idReglaAdd = Integer.parseInt(fosforoEdicionReglasPanel.jTextFieldId.getText());
                FosforoRegla fosforoReglaAnadir = new FosforoRegla();
                fosforoReglaAnadir.setNombreRegla(fosforoEdicionReglasPanel.jTextFieldNombreRegla.getText());
                fosforoReglaAnadir.setLimiteInferior(Integer.parseInt(fosforoEdicionReglasPanel.jTextFieldPremisa1.getText()));
                fosforoReglaAnadir.setLimiteSuperior(Integer.parseInt(fosforoEdicionReglasPanel.jTextFieldPremisa2.getText()));
                fosforoReglaAnadir.setConclusion(fosforoEdicionReglasPanel.jTextFieldConclusion.getText());

                fosforoReglaService.createFosforoRegla(fosforoReglaAnadir);
                llenarJTable();

                //para guardar en archivo drl en formato drools descomentar
                fosforoReglaService.actualizarReglasFosforoDrl();
                break;
            case "DELETE":
                int idReglaDelete = Integer.parseInt(fosforoEdicionReglasPanel.jTextFieldId.getText());

                fosforoReglaService.deleteFosforoRegla(idReglaDelete);
                llenarJTable();
                //para guardar en archivo drl en formato drools descomentar
                fosforoReglaService.actualizarReglasFosforoDrl();
                break;
            default:
                System.out.println("No hay Valores");
                break;
        }

    }

    public void llenarReglasService() {

        FosforoRegla fosforoRegla = new FosforoRegla();
        fosforoRegla.setIdFosforoRegla(1);
        fosforoRegla.setNombreRegla("Nivel de Fosforo Muy Alto");
        fosforoRegla.setLimiteInferior(110);
        fosforoRegla.setLimiteSuperior(120);
        fosforoRegla.setConclusion("Muy Alto");

        FosforoRegla fosforoRegla2 = new FosforoRegla();
        fosforoRegla2.setIdFosforoRegla(2);
        fosforoRegla2.setNombreRegla("Nivel de Fosforo Super bajo");
        fosforoRegla2.setLimiteInferior(0);
        fosforoRegla2.setLimiteSuperior(10);
        fosforoRegla2.setConclusion("Super Bajo");

        FosforoRegla fosforoRegla3 = new FosforoRegla();
        fosforoRegla3.setIdFosforoRegla(3);
        fosforoRegla3.setNombreRegla("Nivel de Fosforo Regular");
        fosforoRegla3.setLimiteInferior(30);
        fosforoRegla3.setLimiteSuperior(50);
        fosforoRegla3.setConclusion("Regular");

        fosforoReglaService.createFosforoRegla(fosforoRegla);
        fosforoReglaService.createFosforoRegla(fosforoRegla2);
        fosforoReglaService.createFosforoRegla(fosforoRegla3);
    }
}
