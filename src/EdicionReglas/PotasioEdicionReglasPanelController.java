/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EdicionReglas;

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

    public PotasioEdicionReglasPanelController(PotasioEdicionReglasPanel potasioEdicionReglasPanel) {
        this.potasioEdicionReglasPanel = potasioEdicionReglasPanel;
        potasioReglaService = new PotasioReglaService();
        llenarReglasService();
        listaReglaPotasio = potasioReglaService.readAllPotasio();
        llenarTabla();
        confBotonesEdicion();
    }

    public void llenarTabla() {
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
            PotasioRegla nutrienteReglaEditar = listaReglaPotasio.get(filaSeleccionada);
            potasioEdicionReglasPanel.jTextFieldId.setText(nutrienteReglaEditar.getIdPotasioRegla() + "");
            potasioEdicionReglasPanel.jTextFieldNombreRegla.setText(nutrienteReglaEditar.getNombreRegla() + "");
            potasioEdicionReglasPanel.jTextFieldPremisa1.setText(nutrienteReglaEditar.getLimiteInferior() + "");
            potasioEdicionReglasPanel.jTextFieldPremisa2.setText(nutrienteReglaEditar.getLimiteSuperior() + "");
            potasioEdicionReglasPanel.jTextFieldConclusion.setText(nutrienteReglaEditar.getConclusion() + "");
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un Regla para la edicion", "Falta seleccionar", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void buttonAnadirReglaActionPerformed(java.awt.event.ActionEvent evt) {
        potasioEdicionReglasPanel.jTextFieldId.setText("");
        potasioEdicionReglasPanel.jTextFieldNombreRegla.setText("");
        potasioEdicionReglasPanel.jTextFieldPremisa1.setText("");
        potasioEdicionReglasPanel.jTextFieldPremisa2.setText("");
        potasioEdicionReglasPanel.jTextFieldConclusion.setText("");
    }

    private void buttonEliminarReglaActionPerformed(java.awt.event.ActionEvent evt) {
         int filaSeleccionada = potasioEdicionReglasPanel.jTablePotasio.getSelectedRow();
        if (filaSeleccionada >= 0) {
            PotasioRegla nutrienteReglaEditar = listaReglaPotasio.get(filaSeleccionada);
            potasioEdicionReglasPanel.jTextFieldId.setText(nutrienteReglaEditar.getIdPotasioRegla() + "");
            potasioEdicionReglasPanel.jTextFieldNombreRegla.setText(nutrienteReglaEditar.getNombreRegla() + "");
            potasioEdicionReglasPanel.jTextFieldPremisa1.setText(nutrienteReglaEditar.getLimiteInferior() + "");
            potasioEdicionReglasPanel.jTextFieldPremisa2.setText(nutrienteReglaEditar.getLimiteSuperior() + "");
            potasioEdicionReglasPanel.jTextFieldConclusion.setText(nutrienteReglaEditar.getConclusion() + "");
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un Regla para la edicion", "Falta seleccionar", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void llenarReglasService() {

        PotasioRegla potasioRegla = new PotasioRegla();
        potasioRegla.setIdPotasioRegla(1);
        potasioRegla.setNombreRegla("Nivel de Fosforo Muy Alto");
        potasioRegla.setLimiteInferior(110);
        potasioRegla.setLimiteSuperior(120);
        potasioRegla.setConclusion("Muy Alto");

        PotasioRegla potasioRegla2 = new PotasioRegla();
        potasioRegla2.setIdPotasioRegla(2);
        potasioRegla2.setNombreRegla("Nivel de Fosforo Super bajo");
        potasioRegla2.setLimiteInferior(0);
        potasioRegla2.setLimiteSuperior(10);
        potasioRegla2.setConclusion("Super Bajo");

        PotasioRegla potasioRegla3 = new PotasioRegla();
        potasioRegla3.setIdPotasioRegla(3);
        potasioRegla3.setNombreRegla("Nivel de Fosforo Regular");
        potasioRegla3.setLimiteInferior(30);
        potasioRegla3.setLimiteSuperior(50);
        potasioRegla3.setConclusion("Regular");

        potasioReglaService.createPotasioRegla(potasioRegla);
        potasioReglaService.createPotasioRegla(potasioRegla2);
        potasioReglaService.createPotasioRegla(potasioRegla3);
    }
}
