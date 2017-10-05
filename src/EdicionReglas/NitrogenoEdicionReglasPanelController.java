/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EdicionReglas;

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

    public NitrogenoEdicionReglasPanelController(NitrogenoEdicionReglasPanel nitrogenoedicionReglasPanel) {
        this.nitrogenoedicionReglasPanel = nitrogenoedicionReglasPanel;
        nitrogenoReglaService = new NitrogenoReglaService();
        llenarReglasService();
        listaReglaNitrogeno = nitrogenoReglaService.readAllNitrogeno();
        llenarTabla();
        confBotonesEdicion();
    }

    public void llenarTabla() {
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
            //System.out.println("Editando reglas posicion: "+ filaSeleccionada);
            NitrogenoRegla nutrienteReglaEditar = listaReglaNitrogeno.get(filaSeleccionada);
//            System.out.println(nutrienteReglaEditar.getNombreRegla());
//            System.out.println(nutrienteReglaEditar.getIdNutrienteRegla());
            nitrogenoedicionReglasPanel.jTextFieldId.setText(nutrienteReglaEditar.getIdNitrogenoRegla() + "");
            nitrogenoedicionReglasPanel.jTextFieldNombreRegla.setText(nutrienteReglaEditar.getNombreRegla() + "");
            nitrogenoedicionReglasPanel.jTextFieldPremisa1.setText(nutrienteReglaEditar.getLimiteInferior() + "");
            nitrogenoedicionReglasPanel.jTextFieldPremisa2.setText(nutrienteReglaEditar.getLimiteSuperior() + "");
            nitrogenoedicionReglasPanel.jTextFieldConclusion.setText(nutrienteReglaEditar.getConclusion() + "");
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un Regla para la edicion", "Falta seleccionar", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void buttonAnadirReglaActionPerformed(java.awt.event.ActionEvent evt) {
        nitrogenoedicionReglasPanel.jTextFieldId.setText("");
        nitrogenoedicionReglasPanel.jTextFieldNombreRegla.setText("");
        nitrogenoedicionReglasPanel.jTextFieldPremisa1.setText("");
        nitrogenoedicionReglasPanel.jTextFieldPremisa2.setText("");
        nitrogenoedicionReglasPanel.jTextFieldConclusion.setText("");

    }

    private void buttonEliminarReglaActionPerformed(java.awt.event.ActionEvent evt) {
        int filaSeleccionada = nitrogenoedicionReglasPanel.jTableNitrogeno.getSelectedRow();
        if (filaSeleccionada >= 0) {
            //System.out.println("Editando reglas posicion: "+ filaSeleccionada);
            NitrogenoRegla nutrienteReglaEditar = listaReglaNitrogeno.get(filaSeleccionada);
//            System.out.println(nutrienteReglaEditar.getNombreRegla());
//            System.out.println(nutrienteReglaEditar.getIdNutrienteRegla());
            nitrogenoedicionReglasPanel.jTextFieldId.setText(nutrienteReglaEditar.getIdNitrogenoRegla() + "");
            nitrogenoedicionReglasPanel.jTextFieldNombreRegla.setText(nutrienteReglaEditar.getNombreRegla() + "");
            nitrogenoedicionReglasPanel.jTextFieldPremisa1.setText(nutrienteReglaEditar.getLimiteInferior() + "");
            nitrogenoedicionReglasPanel.jTextFieldPremisa2.setText(nutrienteReglaEditar.getLimiteSuperior() + "");
            nitrogenoedicionReglasPanel.jTextFieldConclusion.setText(nutrienteReglaEditar.getConclusion() + "");
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un Regla para la edicion", "Falta seleccionar", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void llenarReglasService() {

        NitrogenoRegla nitrogenoRegla = new NitrogenoRegla();
        nitrogenoRegla.setIdNitrogenoRegla(1);
        nitrogenoRegla.setNombreRegla("Nivel de Nitrogeno Muy Alto");
        nitrogenoRegla.setLimiteInferior(110);
        nitrogenoRegla.setLimiteSuperior(120);
        nitrogenoRegla.setConclusion("Muy Alto");

        NitrogenoRegla nitrogenoRegla2 = new NitrogenoRegla();
        nitrogenoRegla2.setIdNitrogenoRegla(2);
        nitrogenoRegla2.setNombreRegla("Nivel de Nitrogeno Super bajo");
        nitrogenoRegla2.setLimiteInferior(0);
        nitrogenoRegla2.setLimiteSuperior(10);
        nitrogenoRegla2.setConclusion("Super Bajo");

        NitrogenoRegla nitrogenoRegla3 = new NitrogenoRegla();
        nitrogenoRegla3.setIdNitrogenoRegla(3);
        nitrogenoRegla3.setNombreRegla("Nivel de Nitrogeno Regular");
        nitrogenoRegla3.setLimiteInferior(30);
        nitrogenoRegla3.setLimiteSuperior(50);
        nitrogenoRegla3.setConclusion("Regular");

        nitrogenoReglaService.createNitrogenoRegla(nitrogenoRegla);
        nitrogenoReglaService.createNitrogenoRegla(nitrogenoRegla2);
        nitrogenoReglaService.createNitrogenoRegla(nitrogenoRegla3);
    }
}
