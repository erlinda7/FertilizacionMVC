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
import model.RecomendacionNuevoFertilizanteRegla;
import service.RecomendacionNuevoFertilizanteReglaService;

/**
 *
 * @author Erlinda
 */
public class RecomendacionNuevoFertilizantePanelController {

    RecomendacionNuevoFertilizantePanel recomendacionNuevoFertilizantePanel;
    RecomendacionNuevoFertilizanteReglaService recomendacionNuevoFertiReglaService;
    ArrayList<RecomendacionNuevoFertilizanteRegla> listaReglaRcomendacionNuevaFertilizante;
    String actionAceptar;

    public RecomendacionNuevoFertilizantePanelController(RecomendacionNuevoFertilizantePanel recomendacionNuevoFertilizantePanel) {
        this.recomendacionNuevoFertilizantePanel = recomendacionNuevoFertilizantePanel;
        recomendacionNuevoFertiReglaService = new RecomendacionNuevoFertilizanteReglaService();
        listaReglaRcomendacionNuevaFertilizante = recomendacionNuevoFertiReglaService.readAllRecomendacion();
        llenarJTable();
        confBotonesEdicion();
        buttonAceptar();
        actionAceptar = "";
    }

    public void llenarJTable() {
        DefaultTableModel dtm = (DefaultTableModel) recomendacionNuevoFertilizantePanel.jTableRecNuevoFertilizante.getModel();
        dtm.setRowCount(0);
        for (int i = 0; i < listaReglaRcomendacionNuevaFertilizante.size(); i++) {
            dtm.addRow(new Object[]{
                listaReglaRcomendacionNuevaFertilizante.get(i).getId_recomendacion_regla(),
                listaReglaRcomendacionNuevaFertilizante.get(i).getNombreFertilizanteNitrogenado(),
                listaReglaRcomendacionNuevaFertilizante.get(i).getFormulaFertilizanteNitrogenado(),
                listaReglaRcomendacionNuevaFertilizante.get(i).getNombreFertilizanteFosfatado(),
                listaReglaRcomendacionNuevaFertilizante.get(i).getFormulaFertilizanteFosfatado(),
                listaReglaRcomendacionNuevaFertilizante.get(i).getNombreFertilizantePotasico(),
                listaReglaRcomendacionNuevaFertilizante.get(i).getFormulaFertilizantePotasico(),});
        }
    }

    public void confBotonesEdicion() {

        recomendacionNuevoFertilizantePanel.jButtonAnadirNuevoFertilizante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAnadirNuevoFertilizanteActionPerformed(evt);
            }
        });

        recomendacionNuevoFertilizantePanel.jButtonEditarNuevoFertilizante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditarNuevoFertilizanteActionPerformed(evt);
            }
        });

        recomendacionNuevoFertilizantePanel.jButtonEliminarNuevoFertilizante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEliminarNuevoFertilizanteActionPerformed(evt);
            }
        });
    }

    private void buttonAnadirNuevoFertilizanteActionPerformed(java.awt.event.ActionEvent evt) {
        // System.out.println("soy el boton anadir");
        recomendacionNuevoFertilizantePanel.jTextFieldId.setText("");
        recomendacionNuevoFertilizantePanel.jTextFieldNombreFertilizanteN.setText("");
        recomendacionNuevoFertilizantePanel.jTextFieldNombreFertilizanteP.setText("");
        recomendacionNuevoFertilizantePanel.jTextFieldNombreFertilizanteK.setText("");
        recomendacionNuevoFertilizantePanel.jTextFieldFormulaFertilizanteN.setText("");
        recomendacionNuevoFertilizantePanel.jTextFieldFormulaFertilizanteP.setText("");
        recomendacionNuevoFertilizantePanel.jTextFieldFormulaFertilizanteK.setText("");

        actionAceptar = "ADD";

        recomendacionNuevoFertilizantePanel.jTextFieldId.setEnabled(false);
        recomendacionNuevoFertilizantePanel.jTextFieldId.setDisabledTextColor(Color.gray);
        recomendacionNuevoFertilizantePanel.jTextFieldNombreFertilizanteN.setEnabled(true);
        recomendacionNuevoFertilizantePanel.jTextFieldNombreFertilizanteN.setDisabledTextColor(Color.white);
        recomendacionNuevoFertilizantePanel.jTextFieldNombreFertilizanteP.setEnabled(true);
        recomendacionNuevoFertilizantePanel.jTextFieldNombreFertilizanteP.setDisabledTextColor(Color.white);
        recomendacionNuevoFertilizantePanel.jTextFieldNombreFertilizanteK.setEnabled(true);
        recomendacionNuevoFertilizantePanel.jTextFieldNombreFertilizanteK.setDisabledTextColor(Color.white);
        recomendacionNuevoFertilizantePanel.jTextFieldFormulaFertilizanteN.setEnabled(true);
        recomendacionNuevoFertilizantePanel.jTextFieldFormulaFertilizanteN.setDisabledTextColor(Color.white);
        recomendacionNuevoFertilizantePanel.jTextFieldFormulaFertilizanteP.setEnabled(true);
        recomendacionNuevoFertilizantePanel.jTextFieldFormulaFertilizanteP.setDisabledTextColor(Color.white);
        recomendacionNuevoFertilizantePanel.jTextFieldFormulaFertilizanteK.setEnabled(true);
        recomendacionNuevoFertilizantePanel.jTextFieldFormulaFertilizanteK.setDisabledTextColor(Color.white);
    }

    private void buttonEditarNuevoFertilizanteActionPerformed(java.awt.event.ActionEvent evt) {
        //System.out.println("soy el boton editar");
        int filaSeleccionada = recomendacionNuevoFertilizantePanel.jTableRecNuevoFertilizante.getSelectedRow();
        if (filaSeleccionada >= 0) {
            RecomendacionNuevoFertilizanteRegla recNuevoFertilizanteReglaEditar = listaReglaRcomendacionNuevaFertilizante.get(filaSeleccionada);
            recomendacionNuevoFertilizantePanel.jTextFieldId.setText(recNuevoFertilizanteReglaEditar.getId_recomendacion_regla() + "");
            recomendacionNuevoFertilizantePanel.jTextFieldNombreFertilizanteN.setText(recNuevoFertilizanteReglaEditar.getNombreFertilizanteNitrogenado() + "");
            recomendacionNuevoFertilizantePanel.jTextFieldNombreFertilizanteP.setText(recNuevoFertilizanteReglaEditar.getNombreFertilizanteFosfatado() + "");
            recomendacionNuevoFertilizantePanel.jTextFieldNombreFertilizanteK.setText(recNuevoFertilizanteReglaEditar.getNombreFertilizantePotasico() + "");
           recomendacionNuevoFertilizantePanel.jTextFieldFormulaFertilizanteN.setText(recNuevoFertilizanteReglaEditar.getFormulaFertilizanteNitrogenado()+ "");
           recomendacionNuevoFertilizantePanel.jTextFieldFormulaFertilizanteP.setText(recNuevoFertilizanteReglaEditar.getFormulaFertilizanteFosfatado()+ "");
           recomendacionNuevoFertilizantePanel.jTextFieldFormulaFertilizanteK.setText(recNuevoFertilizanteReglaEditar.getFormulaFertilizantePotasico()+ "");
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un Regla para la edicion", "Falta seleccionar", JOptionPane.ERROR_MESSAGE);
        }
        actionAceptar = "EDIT";

        recomendacionNuevoFertilizantePanel.jTextFieldId.setEnabled(false);
        recomendacionNuevoFertilizantePanel.jTextFieldId.setDisabledTextColor(Color.gray);
        recomendacionNuevoFertilizantePanel.jTextFieldNombreFertilizanteN.setEnabled(true);
        recomendacionNuevoFertilizantePanel.jTextFieldNombreFertilizanteN.setDisabledTextColor(Color.white);
        recomendacionNuevoFertilizantePanel.jTextFieldNombreFertilizanteP.setEnabled(true);
        recomendacionNuevoFertilizantePanel.jTextFieldNombreFertilizanteP.setDisabledTextColor(Color.white);
        recomendacionNuevoFertilizantePanel.jTextFieldNombreFertilizanteK.setEnabled(true);
        recomendacionNuevoFertilizantePanel.jTextFieldNombreFertilizanteK.setDisabledTextColor(Color.white);
        recomendacionNuevoFertilizantePanel.jTextFieldFormulaFertilizanteN.setEnabled(true);
        recomendacionNuevoFertilizantePanel.jTextFieldFormulaFertilizanteN.setDisabledTextColor(Color.white);
        recomendacionNuevoFertilizantePanel.jTextFieldFormulaFertilizanteP.setEnabled(true);
        recomendacionNuevoFertilizantePanel.jTextFieldFormulaFertilizanteP.setDisabledTextColor(Color.white);
        recomendacionNuevoFertilizantePanel.jTextFieldFormulaFertilizanteK.setEnabled(true);
        recomendacionNuevoFertilizantePanel.jTextFieldFormulaFertilizanteK.setDisabledTextColor(Color.white);

    }

    private void buttonEliminarNuevoFertilizanteActionPerformed(java.awt.event.ActionEvent evt) {
        //System.out.println("soy el boton eliminar");
        int filaSeleccionada = recomendacionNuevoFertilizantePanel.jTableRecNuevoFertilizante.getSelectedRow();
        if (filaSeleccionada >= 0) {
            RecomendacionNuevoFertilizanteRegla recNuevoFertilizanteReglaEditar = listaReglaRcomendacionNuevaFertilizante.get(filaSeleccionada);
            recomendacionNuevoFertilizantePanel.jTextFieldId.setText(recNuevoFertilizanteReglaEditar.getId_recomendacion_regla() + "");
            recomendacionNuevoFertilizantePanel.jTextFieldNombreFertilizanteN.setText(recNuevoFertilizanteReglaEditar.getNombreFertilizanteNitrogenado() + "");
            recomendacionNuevoFertilizantePanel.jTextFieldNombreFertilizanteP.setText(recNuevoFertilizanteReglaEditar.getNombreFertilizanteFosfatado() + "");
            recomendacionNuevoFertilizantePanel.jTextFieldNombreFertilizanteK.setText(recNuevoFertilizanteReglaEditar.getNombreFertilizantePotasico() + "");
            recomendacionNuevoFertilizantePanel.jTextFieldFormulaFertilizanteN.setText(recNuevoFertilizanteReglaEditar.getFormulaFertilizanteNitrogenado()+"");
            recomendacionNuevoFertilizantePanel.jTextFieldFormulaFertilizanteP.setText(recNuevoFertilizanteReglaEditar.getFormulaFertilizanteFosfatado()+"");
            recomendacionNuevoFertilizantePanel.jTextFieldFormulaFertilizanteK.setText(recNuevoFertilizanteReglaEditar.getFormulaFertilizantePotasico()+"");
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un Regla para la edicion", "Falta seleccionar", JOptionPane.ERROR_MESSAGE);
        }

        actionAceptar = "DELETE";

        recomendacionNuevoFertilizantePanel.jTextFieldId.setEnabled(false);
        recomendacionNuevoFertilizantePanel.jTextFieldId.setDisabledTextColor(Color.gray);
        recomendacionNuevoFertilizantePanel.jTextFieldNombreFertilizanteN.setEnabled(false);
        recomendacionNuevoFertilizantePanel.jTextFieldNombreFertilizanteN.setDisabledTextColor(Color.gray);
       recomendacionNuevoFertilizantePanel.jTextFieldNombreFertilizanteP.setEnabled(false);
        recomendacionNuevoFertilizantePanel.jTextFieldNombreFertilizanteP.setDisabledTextColor(Color.gray);
        recomendacionNuevoFertilizantePanel.jTextFieldNombreFertilizanteK.setEnabled(false);
        recomendacionNuevoFertilizantePanel.jTextFieldNombreFertilizanteK.setDisabledTextColor(Color.gray);
        recomendacionNuevoFertilizantePanel.jTextFieldFormulaFertilizanteN.setEnabled(false);
        recomendacionNuevoFertilizantePanel.jTextFieldFormulaFertilizanteN.setDisabledTextColor(Color.gray);
        recomendacionNuevoFertilizantePanel.jTextFieldFormulaFertilizanteP.setEnabled(false);
        recomendacionNuevoFertilizantePanel.jTextFieldFormulaFertilizanteP.setDisabledTextColor(Color.gray);
        recomendacionNuevoFertilizantePanel.jTextFieldFormulaFertilizanteK.setEnabled(false);
        recomendacionNuevoFertilizantePanel.jTextFieldFormulaFertilizanteK.setDisabledTextColor(Color.gray);
    }

    public void buttonAceptar() {
        recomendacionNuevoFertilizantePanel.jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAceptarActionPerformed(evt);
            }
        });
    }

    private void buttonAceptarActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("soy el boton aceptar");
        switch (actionAceptar) {
            case "EDIT":
                int idReglaEdit = Integer.parseInt(recomendacionNuevoFertilizantePanel.jTextFieldId.getText());
                RecomendacionNuevoFertilizanteRegla recNuevoFertilizanteReglaEditar = new RecomendacionNuevoFertilizanteRegla();
                recNuevoFertilizanteReglaEditar.setNombreFertilizanteNitrogenado(recomendacionNuevoFertilizantePanel.jTextFieldNombreFertilizanteN.getText());
                recNuevoFertilizanteReglaEditar.setNombreFertilizanteFosfatado(recomendacionNuevoFertilizantePanel.jTextFieldNombreFertilizanteP.getText());
                recNuevoFertilizanteReglaEditar.setNombreFertilizantePotasico(recomendacionNuevoFertilizantePanel.jTextFieldNombreFertilizanteK.getText());
                recNuevoFertilizanteReglaEditar.setFormulaFertilizanteNitrogenado(Integer.parseInt(recomendacionNuevoFertilizantePanel.jTextFieldFormulaFertilizanteN.getText()));
                recNuevoFertilizanteReglaEditar.setFormulaFertilizanteFosfatado(Integer.parseInt(recomendacionNuevoFertilizantePanel.jTextFieldFormulaFertilizanteP.getText()));
                recNuevoFertilizanteReglaEditar.setFormulaFertilizantePotasico(Integer.parseInt(recomendacionNuevoFertilizantePanel.jTextFieldFormulaFertilizanteK.getText()));

                recomendacionNuevoFertiReglaService.updateRecomendacionRegla(idReglaEdit, recNuevoFertilizanteReglaEditar);
                llenarJTable();

                //para guardar en archivo drl en formato drools
                recomendacionNuevoFertiReglaService.actualizarReglasRecomendacionDrl();

                break;
            case "ADD":
                RecomendacionNuevoFertilizanteRegla RecNuevoFertilizanteReglaAnadir = new RecomendacionNuevoFertilizanteRegla();
                RecNuevoFertilizanteReglaAnadir.setNombreFertilizanteNitrogenado(recomendacionNuevoFertilizantePanel.jTextFieldNombreFertilizanteN.getText());
                RecNuevoFertilizanteReglaAnadir.setNombreFertilizanteFosfatado(recomendacionNuevoFertilizantePanel.jTextFieldNombreFertilizanteP.getText());
                RecNuevoFertilizanteReglaAnadir.setNombreFertilizantePotasico(recomendacionNuevoFertilizantePanel.jTextFieldNombreFertilizanteK.getText());
                RecNuevoFertilizanteReglaAnadir.setFormulaFertilizanteNitrogenado(Integer.parseInt(recomendacionNuevoFertilizantePanel.jTextFieldFormulaFertilizanteN.getText()));
                RecNuevoFertilizanteReglaAnadir.setFormulaFertilizanteFosfatado(Integer.parseInt(recomendacionNuevoFertilizantePanel.jTextFieldFormulaFertilizanteP.getText()));
                RecNuevoFertilizanteReglaAnadir.setFormulaFertilizantePotasico(Integer.parseInt(recomendacionNuevoFertilizantePanel.jTextFieldFormulaFertilizanteK.getText()));
                recomendacionNuevoFertiReglaService.createRecomendacionRegla(RecNuevoFertilizanteReglaAnadir);

                listaReglaRcomendacionNuevaFertilizante = recomendacionNuevoFertiReglaService.readAllRecomendacion();

                llenarJTable();

                //para guardar en archivo drl en formato drools descomentar
                recomendacionNuevoFertiReglaService.actualizarReglasRecomendacionDrl();
                //nitrogenoedicionReglasPanel.jPanelEdicion.setVisible(false);
                break;
            case "DELETE":
                int idReglaDelete = Integer.parseInt(recomendacionNuevoFertilizantePanel.jTextFieldId.getText());
                recomendacionNuevoFertiReglaService.deleteRecomendacionRegla(idReglaDelete);
                llenarJTable();
                //para guardar en archivo drl en formato drools descomentar
                recomendacionNuevoFertiReglaService.actualizarReglasRecomendacionDrl();

                break;
            default:
                System.out.println("No hay Valores");
                break;
        }
    }

}
