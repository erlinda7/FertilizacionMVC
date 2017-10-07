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
import model.MateriaOrganicaRegla;
import service.MateriaOrganicaReglaService;

/**
 *
 * @author Erlinda
 */
public class MOEdicionReglasPanelController {

    MOEdicionReglasPanel MOEdicionReglasPanel;
    MateriaOrganicaReglaService MateriaOrganicaReglaService;
    ArrayList<MateriaOrganicaRegla> listaReglaMateriaOrganica;

    String actionAceptar;

    public MOEdicionReglasPanelController(MOEdicionReglasPanel MOEdicionReglasPanel) {
        this.MOEdicionReglasPanel = MOEdicionReglasPanel;
        MateriaOrganicaReglaService = new MateriaOrganicaReglaService();
        //llenarReglasService();
        listaReglaMateriaOrganica = MateriaOrganicaReglaService.readAllMateriaOrganica();
        llenarJTable();
        confBotonesEdicion();
        buttonAceptar();

        actionAceptar = "";

        MOEdicionReglasPanel.jTextFieldId.setEnabled(false);
        MOEdicionReglasPanel.jTextFieldId.setText("");
        MOEdicionReglasPanel.jTextFieldNombreRegla.setEnabled(false);
        MOEdicionReglasPanel.jTextFieldNombreRegla.setText("");
        MOEdicionReglasPanel.jTextFieldPremisa1.setEnabled(false);
        MOEdicionReglasPanel.jTextFieldPremisa1.setText("");
        MOEdicionReglasPanel.jTextFieldPremisa2.setEnabled(false);
        MOEdicionReglasPanel.jTextFieldPremisa2.setText("");
        MOEdicionReglasPanel.jTextFieldConclusion.setEnabled(false);
        MOEdicionReglasPanel.jTextFieldConclusion.setText("");
    }

    public void llenarJTable() {
        DefaultTableModel dtm = (DefaultTableModel) MOEdicionReglasPanel.jTableMateriaOrganica.getModel();
        dtm.setRowCount(0);
        for (int i = 0; i < listaReglaMateriaOrganica.size(); i++) {
            dtm.addRow(new Object[]{
                listaReglaMateriaOrganica.get(i).getIdMateriaOrganicaRegla(),
                listaReglaMateriaOrganica.get(i).getNombreRegla(),
                listaReglaMateriaOrganica.get(i).getLimiteInferior(),
                listaReglaMateriaOrganica.get(i).getLimiteSuperior(),
                listaReglaMateriaOrganica.get(i).getConclusion()
            });
        }
    }

    public void confBotonesEdicion() {

        MOEdicionReglasPanel.jButtonEditarRegla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditarReglaActionPerformed(evt);
            }
        });

        MOEdicionReglasPanel.jButtonAnadirRegla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAnadirReglaActionPerformed(evt);
            }
        });

        MOEdicionReglasPanel.jButtonEliminarRegla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEliminarReglaActionPerformed(evt);
            }
        });
    }

    private void buttonEditarReglaActionPerformed(java.awt.event.ActionEvent evt) {
        int filaSeleccionada = MOEdicionReglasPanel.jTableMateriaOrganica.getSelectedRow();
        if (filaSeleccionada >= 0) {
            MateriaOrganicaRegla MOReglaEditar = listaReglaMateriaOrganica.get(filaSeleccionada);
            MOEdicionReglasPanel.jTextFieldId.setText(MOReglaEditar.getIdMateriaOrganicaRegla() + "");
            MOEdicionReglasPanel.jTextFieldNombreRegla.setText(MOReglaEditar.getNombreRegla() + "");
            MOEdicionReglasPanel.jTextFieldPremisa1.setText(MOReglaEditar.getLimiteInferior() + "");
            MOEdicionReglasPanel.jTextFieldPremisa2.setText(MOReglaEditar.getLimiteSuperior() + "");
            MOEdicionReglasPanel.jTextFieldConclusion.setText(MOReglaEditar.getConclusion() + "");
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un Regla para la edicion", "Falta seleccionar", JOptionPane.ERROR_MESSAGE);
        }
        actionAceptar = "EDIT";

        MOEdicionReglasPanel.jTextFieldId.setEnabled(false);
        MOEdicionReglasPanel.jTextFieldId.setDisabledTextColor(Color.gray);
        MOEdicionReglasPanel.jTextFieldNombreRegla.setEnabled(true);
        MOEdicionReglasPanel.jTextFieldNombreRegla.setDisabledTextColor(Color.white);
        MOEdicionReglasPanel.jTextFieldPremisa1.setEnabled(true);
        MOEdicionReglasPanel.jTextFieldPremisa1.setDisabledTextColor(Color.white);
        MOEdicionReglasPanel.jTextFieldPremisa2.setEnabled(true);
        MOEdicionReglasPanel.jTextFieldPremisa2.setDisabledTextColor(Color.white);
        MOEdicionReglasPanel.jTextFieldConclusion.setEnabled(true);
        MOEdicionReglasPanel.jTextFieldConclusion.setDisabledTextColor(Color.white);
    }

    private void buttonAnadirReglaActionPerformed(java.awt.event.ActionEvent evt) {
        MOEdicionReglasPanel.jTextFieldId.setText("");
        MOEdicionReglasPanel.jTextFieldNombreRegla.setText("");
        MOEdicionReglasPanel.jTextFieldPremisa1.setText("");
        MOEdicionReglasPanel.jTextFieldPremisa2.setText("");
        MOEdicionReglasPanel.jTextFieldConclusion.setText("");

        actionAceptar = "ADD";

        MOEdicionReglasPanel.jTextFieldId.setEnabled(false);
        MOEdicionReglasPanel.jTextFieldId.setDisabledTextColor(Color.gray);
        MOEdicionReglasPanel.jTextFieldNombreRegla.setEnabled(true);
        MOEdicionReglasPanel.jTextFieldNombreRegla.setDisabledTextColor(Color.white);
        MOEdicionReglasPanel.jTextFieldPremisa1.setEnabled(true);
        MOEdicionReglasPanel.jTextFieldPremisa1.setDisabledTextColor(Color.white);
        MOEdicionReglasPanel.jTextFieldPremisa2.setEnabled(true);
        MOEdicionReglasPanel.jTextFieldPremisa2.setDisabledTextColor(Color.white);
        MOEdicionReglasPanel.jTextFieldConclusion.setEnabled(true);
        MOEdicionReglasPanel.jTextFieldConclusion.setDisabledTextColor(Color.white);
    }

    private void buttonEliminarReglaActionPerformed(java.awt.event.ActionEvent evt) {
        int filaSeleccionada = MOEdicionReglasPanel.jTableMateriaOrganica.getSelectedRow();
        if (filaSeleccionada >= 0) {
            MateriaOrganicaRegla MOReglaEditar = listaReglaMateriaOrganica.get(filaSeleccionada);
            MOEdicionReglasPanel.jTextFieldId.setText(MOReglaEditar.getIdMateriaOrganicaRegla() + "");
            MOEdicionReglasPanel.jTextFieldNombreRegla.setText(MOReglaEditar.getNombreRegla() + "");
            MOEdicionReglasPanel.jTextFieldPremisa1.setText(MOReglaEditar.getLimiteInferior() + "");
            MOEdicionReglasPanel.jTextFieldPremisa2.setText(MOReglaEditar.getLimiteSuperior() + "");
            MOEdicionReglasPanel.jTextFieldConclusion.setText(MOReglaEditar.getConclusion() + "");
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un Regla para la edicion", "Falta seleccionar", JOptionPane.ERROR_MESSAGE);
        }

        actionAceptar = "DELETE";
        
        MOEdicionReglasPanel.jTextFieldId.setEnabled(false);
        MOEdicionReglasPanel.jTextFieldId.setDisabledTextColor(Color.gray);
        MOEdicionReglasPanel.jTextFieldNombreRegla.setEnabled(false);
        MOEdicionReglasPanel.jTextFieldNombreRegla.setDisabledTextColor(Color.gray);
        MOEdicionReglasPanel.jTextFieldPremisa1.setEnabled(false);
        MOEdicionReglasPanel.jTextFieldPremisa1.setDisabledTextColor(Color.gray);
        MOEdicionReglasPanel.jTextFieldPremisa2.setEnabled(false);
        MOEdicionReglasPanel.jTextFieldPremisa2.setDisabledTextColor(Color.gray);
        MOEdicionReglasPanel.jTextFieldConclusion.setEnabled(false);
        MOEdicionReglasPanel.jTextFieldConclusion.setDisabledTextColor(Color.gray);
    }

    public void buttonAceptar() {
        MOEdicionReglasPanel.jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAceptarActionPerformed(evt);
            }
        });
    }

    private void buttonAceptarActionPerformed(java.awt.event.ActionEvent evt) {
        switch (actionAceptar) {
            case "EDIT":
                int idReglaEdit = Integer.parseInt(MOEdicionReglasPanel.jTextFieldId.getText());
                MateriaOrganicaRegla MOReglaEditar = new MateriaOrganicaRegla();
                MOReglaEditar.setNombreRegla(MOEdicionReglasPanel.jTextFieldNombreRegla.getText());
                MOReglaEditar.setLimiteInferior(Integer.parseInt(MOEdicionReglasPanel.jTextFieldPremisa1.getText()));
                MOReglaEditar.setLimiteSuperior(Integer.parseInt(MOEdicionReglasPanel.jTextFieldPremisa2.getText()));
                MOReglaEditar.setConclusion(MOEdicionReglasPanel.jTextFieldConclusion.getText());

                MateriaOrganicaReglaService.updateMateriaOrganicaRegla(idReglaEdit, MOReglaEditar);
                llenarJTable();

                //para guardar en archivo drl en formato drools
                MateriaOrganicaReglaService.actualizarReglasMODrl();

                break;
            case "ADD":
                int idReglaAdd = Integer.parseInt(MOEdicionReglasPanel.jTextFieldId.getText());
                MateriaOrganicaRegla MOReglaAnadir = new MateriaOrganicaRegla();
                MOReglaAnadir.setNombreRegla(MOEdicionReglasPanel.jTextFieldNombreRegla.getText());
                MOReglaAnadir.setLimiteInferior(Integer.parseInt(MOEdicionReglasPanel.jTextFieldPremisa1.getText()));
                MOReglaAnadir.setLimiteSuperior(Integer.parseInt(MOEdicionReglasPanel.jTextFieldPremisa2.getText()));
                MOReglaAnadir.setConclusion(MOEdicionReglasPanel.jTextFieldConclusion.getText());

                MateriaOrganicaReglaService.createMateriaOrganicaRegla(MOReglaAnadir);
                llenarJTable();

                //para guardar en archivo drl en formato drools descomentar
                MateriaOrganicaReglaService.actualizarReglasMODrl();
                break;
            case "DELETE":
                int idReglaDelete = Integer.parseInt(MOEdicionReglasPanel.jTextFieldId.getText());

                MateriaOrganicaReglaService.deleteMateriaOrganicaRegla(idReglaDelete);
                llenarJTable();
                //para guardar en archivo drl en formato drools descomentar
                MateriaOrganicaReglaService.actualizarReglasMODrl();
                break;
            default:
                System.out.println("No hay Valores");
                break;
        }
 MOEdicionReglasPanel.jTextFieldId.setEnabled(false);
        MOEdicionReglasPanel.jTextFieldId.setText("");
        MOEdicionReglasPanel.jTextFieldNombreRegla.setEnabled(false);
        MOEdicionReglasPanel.jTextFieldNombreRegla.setText("");
        MOEdicionReglasPanel.jTextFieldPremisa1.setEnabled(false);
        MOEdicionReglasPanel.jTextFieldPremisa1.setText("");
        MOEdicionReglasPanel.jTextFieldPremisa2.setEnabled(false);
        MOEdicionReglasPanel.jTextFieldPremisa2.setText("");
        MOEdicionReglasPanel.jTextFieldConclusion.setEnabled(false);
        MOEdicionReglasPanel.jTextFieldConclusion.setText("");
    }

//    public void llenarReglasService() {
//
//        MateriaOrganicaRegla materiaOrganicaRegla = new MateriaOrganicaRegla();
//        materiaOrganicaRegla.setIdMateriaOrganicaRegla(1);
//        materiaOrganicaRegla.setNombreRegla("Nivel de MO Muy Alto");
//        materiaOrganicaRegla.setLimiteInferior(110);
//        materiaOrganicaRegla.setLimiteSuperior(120);
//        materiaOrganicaRegla.setConclusion("Muy Alto");
//
//        MateriaOrganicaRegla materiaOrganicaRegla2 = new MateriaOrganicaRegla();
//        materiaOrganicaRegla2.setIdMateriaOrganicaRegla(2);
//        materiaOrganicaRegla2.setNombreRegla("Nivel de MO Super bajo");
//        materiaOrganicaRegla2.setLimiteInferior(0);
//        materiaOrganicaRegla2.setLimiteSuperior(10);
//        materiaOrganicaRegla2.setConclusion("Super Bajo");
//
//        MateriaOrganicaRegla materiaOrganicaRegla3 = new MateriaOrganicaRegla();
//        materiaOrganicaRegla3.setIdMateriaOrganicaRegla(3);
//        materiaOrganicaRegla3.setNombreRegla("Nivel de MO Regular");
//        materiaOrganicaRegla3.setLimiteInferior(30);
//        materiaOrganicaRegla3.setLimiteSuperior(50);
//        materiaOrganicaRegla3.setConclusion("Regular");
//
//        MateriaOrganicaReglaService.createMateriaOrganicaRegla(materiaOrganicaRegla);
//        MateriaOrganicaReglaService.createMateriaOrganicaRegla(materiaOrganicaRegla2);
//        MateriaOrganicaReglaService.createMateriaOrganicaRegla(materiaOrganicaRegla3);
//    }
}
