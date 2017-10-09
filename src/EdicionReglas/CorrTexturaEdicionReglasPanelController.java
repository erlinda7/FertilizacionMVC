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
import model.CorreccionTexturaRegla;
import service.CorreccionTexturaReglaService;

/**
 *
 * @author Erlinda
 */
public class CorrTexturaEdicionReglasPanelController {

    CorrTexturaEdicionReglasPanel corrTexturaEdicionReglasPanel;
    CorreccionTexturaReglaService correcionTexturaReglaService;
    ArrayList<CorreccionTexturaRegla> listaReglCorreccionTextura;
    String actionAceptar;

    public CorrTexturaEdicionReglasPanelController(CorrTexturaEdicionReglasPanel corrTexturaEdicionReglasPanel) {
        this.corrTexturaEdicionReglasPanel = corrTexturaEdicionReglasPanel;
        correcionTexturaReglaService = new CorreccionTexturaReglaService();
        //llenarReglasService();
        listaReglCorreccionTextura = correcionTexturaReglaService.readAllCorreccionTextura();
        llenarJTable();
        confBotonCorregirTextura();
        confBotonAceptar();
 
        actionAceptar = "";
    }

    public void llenarJTable() {
        DefaultTableModel dtm = (DefaultTableModel) corrTexturaEdicionReglasPanel.jTableCorrTextura.getModel();
        dtm.setRowCount(0);
        for (int i = 0; i < listaReglCorreccionTextura.size(); i++) {
            dtm.addRow(new Object[]{
                listaReglCorreccionTextura.get(i).getIdCorreccionTextura(),
                listaReglCorreccionTextura.get(i).getNombreRegla(),
                listaReglCorreccionTextura.get(i).getTexturaACorregir(),
                listaReglCorreccionTextura.get(i).getConclusionPorcACorregir(),});
        }
    }



    public void confBotonCorregirTextura() {

        corrTexturaEdicionReglasPanel.jButtonCorregirTextura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCorregirTexturaActionPerformed(evt);
            }
        });
    }

    private void buttonCorregirTexturaActionPerformed(java.awt.event.ActionEvent evt) {
        //System.out.println("hola soy el boton corregir textura");
        int filaSeleccionada = corrTexturaEdicionReglasPanel.jTableCorrTextura.getSelectedRow();
        if (filaSeleccionada >= 0) {
            CorreccionTexturaRegla correccionTexturaReglaEditar = listaReglCorreccionTextura.get(filaSeleccionada);
            corrTexturaEdicionReglasPanel.jTextFieldId.setText(correccionTexturaReglaEditar.getIdCorreccionTextura() + "");
            corrTexturaEdicionReglasPanel.jTextFieldNombreRegla.setText(correccionTexturaReglaEditar.getNombreRegla() + "");
            corrTexturaEdicionReglasPanel.jTextFieldPremisa.setText(correccionTexturaReglaEditar.getTexturaACorregir()+"");
            corrTexturaEdicionReglasPanel.jTextFieldConclusion.setText(correccionTexturaReglaEditar.getConclusionPorcACorregir() + "");
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un Regla para la edicion", "Falta seleccionar", JOptionPane.ERROR_MESSAGE);
        }
        actionAceptar = "EDIT";

        corrTexturaEdicionReglasPanel.jTextFieldId.setEnabled(false);
        corrTexturaEdicionReglasPanel.jTextFieldId.setDisabledTextColor(Color.gray);
        corrTexturaEdicionReglasPanel.jTextFieldNombreRegla.setEnabled(false);
        corrTexturaEdicionReglasPanel.jTextFieldNombreRegla.setDisabledTextColor(Color.white);
        corrTexturaEdicionReglasPanel.jTextFieldPremisa.setEnabled(false);
        corrTexturaEdicionReglasPanel.jTextFieldConclusion.setEnabled(true);
        corrTexturaEdicionReglasPanel.jTextFieldConclusion.setDisabledTextColor(Color.white);
    }

    public void confBotonAceptar() {

        corrTexturaEdicionReglasPanel.jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAceptarActionPerformed(evt);
            }
        });
    }

    private void buttonAceptarActionPerformed(java.awt.event.ActionEvent evt) {
        //System.out.println("hola soy el boton aceptar");
        int idReglaEdit = Integer.parseInt(corrTexturaEdicionReglasPanel.jTextFieldId.getText());
        CorreccionTexturaRegla correccionTexturaReglaEditar = new CorreccionTexturaRegla();
        correccionTexturaReglaEditar.setNombreRegla(corrTexturaEdicionReglasPanel.jTextFieldNombreRegla.getText());
        correccionTexturaReglaEditar.setTexturaACorregir(corrTexturaEdicionReglasPanel.jTextFieldPremisa.getText());
        correccionTexturaReglaEditar.setConclusionPorcACorregir(Integer.parseInt(corrTexturaEdicionReglasPanel.jTextFieldConclusion.getText()));

        correcionTexturaReglaService.updateCorreccionTexturaRegla(idReglaEdit, correccionTexturaReglaEditar);
        llenarJTable();

        //para guardar en archivo drl en formato drools
        correcionTexturaReglaService.actualizarReglasCorrTexturaDrl();
        //nitrogenoedicionReglasPanel.jPanelEdicion.setVisible(false);
    }
}
