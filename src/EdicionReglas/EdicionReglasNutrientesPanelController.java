/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EdicionReglas;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.NutrienteRegla;
import service.NutrienteReglaService;

/**
 *
 * @author Erlinda
 */
public class EdicionReglasNutrientesPanelController {

    EdicionReglasNutrientesPanel edicionReglasNutrientesPanel;
    NutrienteReglaService nutrienteReglaService;
    ArrayList<NutrienteRegla> listaReglaNutrientes;

    public EdicionReglasNutrientesPanelController(EdicionReglasNutrientesPanel edicionReglasNutrientesPanel) {
        this.edicionReglasNutrientesPanel = edicionReglasNutrientesPanel;
        nutrienteReglaService = new NutrienteReglaService();
        llenarReglasService();
        listaReglaNutrientes = nutrienteReglaService.readAllNutrientes();
        llenarTabla();
        confBotonesEdicion();
    }

    public void llenarTabla() {
        DefaultTableModel dtm = (DefaultTableModel) edicionReglasNutrientesPanel.jTableNutrientes.getModel();
        dtm.setRowCount(0);
        for (int i = 0; i < listaReglaNutrientes.size(); i++) {
            dtm.addRow(new Object[]{
                listaReglaNutrientes.get(i).getIdNutrienteRegla(),
                listaReglaNutrientes.get(i).getNombreRegla(),
                listaReglaNutrientes.get(i).getLimiteInferior(),
                listaReglaNutrientes.get(i).getLimiteSuperior(),
                listaReglaNutrientes.get(i).getConclusion(),
                listaReglaNutrientes.get(i).getNombreNutriente()
            });
        }
    }

    public void confBotonesEdicion() {

        edicionReglasNutrientesPanel.jButtonEditarRegla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditarReglaActionPerformed(evt);
            }
        });

        edicionReglasNutrientesPanel.jButtonAnadirRegla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAnadirReglaActionPerformed(evt);
            }
        });

        edicionReglasNutrientesPanel.jButtonEliminarRegla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEliminarReglaActionPerformed(evt);
            }
        });
    }

    private void buttonEditarReglaActionPerformed(java.awt.event.ActionEvent evt) {
        int filaSeleccionada = edicionReglasNutrientesPanel.jTableNutrientes.getSelectedRow();
        if (filaSeleccionada >= 0) {
            //System.out.println("Editando reglas posicion: "+ filaSeleccionada);
            NutrienteRegla nutrienteReglaEditar = listaReglaNutrientes.get(filaSeleccionada);
//            System.out.println(nutrienteReglaEditar.getNombreRegla());
//            System.out.println(nutrienteReglaEditar.getIdNutrienteRegla());
                edicionReglasNutrientesPanel.jTextFieldId.setText(nutrienteReglaEditar.getIdNutrienteRegla() + "");
                edicionReglasNutrientesPanel.jTextFieldNombreRegla.setText(nutrienteReglaEditar.getNombreRegla()+ "");
                edicionReglasNutrientesPanel.jTextFieldPremisa1.setText(nutrienteReglaEditar.getLimiteInferior() + "");
                edicionReglasNutrientesPanel.jTextFieldPremisa2.setText(nutrienteReglaEditar.getLimiteSuperior() + "");
                edicionReglasNutrientesPanel.jTextFieldConclusion.setText(nutrienteReglaEditar.getConclusion() + "");
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un Regla para la edicion", "Falta seleccionar", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void buttonAnadirReglaActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("Añadiendo nuevas reglas");
    }

    private void buttonEliminarReglaActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("Eliminando reglas");
    }

    public void llenarReglasService() {

        NutrienteRegla nutrienteRegla = new NutrienteRegla();
        nutrienteRegla.setIdNutrienteRegla(1);
        nutrienteRegla.setNombreRegla("Nivel de Nitrogeno Muy Alto");
        nutrienteRegla.setLimiteInferior(110);
        nutrienteRegla.setLimiteSuperior(120);
        nutrienteRegla.setConclusion("Muy Alto");
        nutrienteRegla.setNombreNutriente("Nitrogeno");

        NutrienteRegla nutrienteRegla2 = new NutrienteRegla();
        nutrienteRegla2.setIdNutrienteRegla(2);
        nutrienteRegla2.setNombreRegla("Nivel de Fosforo Super bajo");
        nutrienteRegla2.setLimiteInferior(0);
        nutrienteRegla2.setLimiteSuperior(10);
        nutrienteRegla2.setConclusion("Super Bajo");
        nutrienteRegla2.setNombreNutriente("Fosforo");

        NutrienteRegla nutrienteRegla3 = new NutrienteRegla();
        nutrienteRegla3.setIdNutrienteRegla(3);
        nutrienteRegla3.setNombreRegla("Nivel de Potasio Regular");
        nutrienteRegla3.setLimiteInferior(30);
        nutrienteRegla3.setLimiteSuperior(50);
        nutrienteRegla3.setConclusion("Regular");
        nutrienteRegla3.setNombreNutriente("Potasio");

        nutrienteReglaService.createNutrienteRegla(nutrienteRegla);
        nutrienteReglaService.createNutrienteRegla(nutrienteRegla2);
        nutrienteReglaService.createNutrienteRegla(nutrienteRegla3);
    }
}
