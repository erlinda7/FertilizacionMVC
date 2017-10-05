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
public class EdicionReglaNitrogenoPanelController {

    EdicionReglasNitrogenoPanel edicionReglasNitrogenoPanel;
    NitrogenoReglaService nitrogenoReglaService;
    ArrayList<NitrogenoRegla> listaReglaNitrogeno;

    public EdicionReglaNitrogenoPanelController(EdicionReglasNitrogenoPanel edicionReglasNitrogenoPanel) {
        this.edicionReglasNitrogenoPanel = edicionReglasNitrogenoPanel;
        nitrogenoReglaService = new NitrogenoReglaService();
        llenarReglasService();
        listaReglaNitrogeno = nitrogenoReglaService.readAllNutrientes();
        llenarTabla();
        confBotonesEdicion();
    }

    public void llenarTabla() {
        DefaultTableModel dtm = (DefaultTableModel) edicionReglasNitrogenoPanel.jTableNitrogeno.getModel();
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

        edicionReglasNitrogenoPanel.jButtonEditarRegla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditarReglaActionPerformed(evt);
            }
        });

        edicionReglasNitrogenoPanel.jButtonAnadirRegla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAnadirReglaActionPerformed(evt);
            }
        });

        edicionReglasNitrogenoPanel.jButtonEliminarRegla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEliminarReglaActionPerformed(evt);
            }
        });
    }

    private void buttonEditarReglaActionPerformed(java.awt.event.ActionEvent evt) {
        int filaSeleccionada = edicionReglasNitrogenoPanel.jTableNitrogeno.getSelectedRow();
        if (filaSeleccionada >= 0) {
            //System.out.println("Editando reglas posicion: "+ filaSeleccionada);
            NitrogenoRegla nutrienteReglaEditar = listaReglaNitrogeno.get(filaSeleccionada);
//            System.out.println(nutrienteReglaEditar.getNombreRegla());
//            System.out.println(nutrienteReglaEditar.getIdNutrienteRegla());
                edicionReglasNitrogenoPanel.jTextFieldId.setText(nutrienteReglaEditar.getIdNitrogenoRegla() + "");
                edicionReglasNitrogenoPanel.jTextFieldNombreRegla.setText(nutrienteReglaEditar.getNombreRegla()+ "");
                edicionReglasNitrogenoPanel.jTextFieldPremisa1.setText(nutrienteReglaEditar.getLimiteInferior() + "");
                edicionReglasNitrogenoPanel.jTextFieldPremisa2.setText(nutrienteReglaEditar.getLimiteSuperior() + "");
                edicionReglasNitrogenoPanel.jTextFieldConclusion.setText(nutrienteReglaEditar.getConclusion() + "");
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

        NitrogenoRegla nitrogenoRegla = new NitrogenoRegla();
        nitrogenoRegla.setIdNitrogenoRegla(1);
        nitrogenoRegla.setNombreRegla("Nivel de Nitrogeno Muy Alto");
        nitrogenoRegla.setLimiteInferior(110);
        nitrogenoRegla.setLimiteSuperior(120);
        nitrogenoRegla.setConclusion("Muy Alto");


        NitrogenoRegla nitrogenoRegla2 = new NitrogenoRegla();
        nitrogenoRegla2.setIdNitrogenoRegla(2);
        nitrogenoRegla2.setNombreRegla("Nivel de Fosforo Super bajo");
        nitrogenoRegla2.setLimiteInferior(0);
        nitrogenoRegla2.setLimiteSuperior(10);
        nitrogenoRegla2.setConclusion("Super Bajo");
        

        NitrogenoRegla nitrogenoRegla3 = new NitrogenoRegla();
        nitrogenoRegla3.setIdNitrogenoRegla(3);
        nitrogenoRegla3.setNombreRegla("Nivel de Potasio Regular");
        nitrogenoRegla3.setLimiteInferior(30);
        nitrogenoRegla3.setLimiteSuperior(50);
        nitrogenoRegla3.setConclusion("Regular");
   

        nitrogenoReglaService.createNitrogenoRegla(nitrogenoRegla);
        nitrogenoReglaService.createNitrogenoRegla(nitrogenoRegla2);
        nitrogenoReglaService.createNitrogenoRegla(nitrogenoRegla3);
    }
}
