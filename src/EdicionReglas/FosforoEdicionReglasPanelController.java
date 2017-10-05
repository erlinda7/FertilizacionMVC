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

    public FosforoEdicionReglasPanelController(FosforoEdicionReglasPanel fosforoEdicionReglasPanel) {
        this.fosforoEdicionReglasPanel = fosforoEdicionReglasPanel;
        fosforoReglaService = new FosforoReglaService();
        llenarReglasService();
        listaReglaFosforo = fosforoReglaService.readAllFosforo();
        llenarTabla();
        confBotonesEdicion();
    }

    public void llenarTabla() {
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
            FosforoRegla nutrienteReglaEditar = listaReglaFosforo.get(filaSeleccionada);
            fosforoEdicionReglasPanel.jTextFieldId.setText(nutrienteReglaEditar.getIdFosforoRegla() + "");
            fosforoEdicionReglasPanel.jTextFieldNombreRegla.setText(nutrienteReglaEditar.getNombreRegla() + "");
            fosforoEdicionReglasPanel.jTextFieldPremisa1.setText(nutrienteReglaEditar.getLimiteInferior() + "");
            fosforoEdicionReglasPanel.jTextFieldPremisa2.setText(nutrienteReglaEditar.getLimiteSuperior() + "");
            fosforoEdicionReglasPanel.jTextFieldConclusion.setText(nutrienteReglaEditar.getConclusion() + "");
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un Regla para la edicion", "Falta seleccionar", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void buttonAnadirReglaActionPerformed(java.awt.event.ActionEvent evt) {
        fosforoEdicionReglasPanel.jTextFieldId.setText("");
        fosforoEdicionReglasPanel.jTextFieldNombreRegla.setText("");
        fosforoEdicionReglasPanel.jTextFieldPremisa1.setText("");
        fosforoEdicionReglasPanel.jTextFieldPremisa2.setText("");
        fosforoEdicionReglasPanel.jTextFieldConclusion.setText("");
    }

    private void buttonEliminarReglaActionPerformed(java.awt.event.ActionEvent evt) {
         int filaSeleccionada = fosforoEdicionReglasPanel.jTableFosforo.getSelectedRow();
        if (filaSeleccionada >= 0) {
            FosforoRegla nutrienteReglaEditar = listaReglaFosforo.get(filaSeleccionada);
            fosforoEdicionReglasPanel.jTextFieldId.setText(nutrienteReglaEditar.getIdFosforoRegla() + "");
            fosforoEdicionReglasPanel.jTextFieldNombreRegla.setText(nutrienteReglaEditar.getNombreRegla() + "");
            fosforoEdicionReglasPanel.jTextFieldPremisa1.setText(nutrienteReglaEditar.getLimiteInferior() + "");
            fosforoEdicionReglasPanel.jTextFieldPremisa2.setText(nutrienteReglaEditar.getLimiteSuperior() + "");
            fosforoEdicionReglasPanel.jTextFieldConclusion.setText(nutrienteReglaEditar.getConclusion() + "");
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un Regla para la edicion", "Falta seleccionar", JOptionPane.ERROR_MESSAGE);
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
