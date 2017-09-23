/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.ConLabView;

/**
 *
 * @author Erlinda
 */
public class MemoriaTrabajoPanelController {

    MemoriaTrabajoPanel memoriaTrabajoPanel;

    public MemoriaTrabajoPanelController(MemoriaTrabajoPanel memoriaTrabajoPanel) {
        this.memoriaTrabajoPanel = memoriaTrabajoPanel;
        confMemoriaTrabajo();
    }

    public void confMemoriaTrabajo() {
        memoriaTrabajoPanel.hortalizaLabel.setForeground(new java.awt.Color(255, 255, 255));
        memoriaTrabajoPanel.hortalizaValor.setForeground(new java.awt.Color(255, 255, 255));

        memoriaTrabajoPanel.rendimientoLabel.setForeground(new java.awt.Color(255, 255, 255));
        memoriaTrabajoPanel.rendimientoValor.setForeground(new java.awt.Color(255, 255, 255));

        memoriaTrabajoPanel.arenaLabel.setForeground(new java.awt.Color(255, 255, 255));
        memoriaTrabajoPanel.arenaValor.setForeground(new java.awt.Color(255, 255, 255));

        memoriaTrabajoPanel.limoLabel.setForeground(new java.awt.Color(255, 255, 255));
        memoriaTrabajoPanel.limoValor.setForeground(new java.awt.Color(255, 255, 255));

        memoriaTrabajoPanel.arcillaLabel.setForeground(new java.awt.Color(255, 255, 255));
        memoriaTrabajoPanel.arcillaValor.setForeground(new java.awt.Color(255, 255, 255));

        memoriaTrabajoPanel.nitrogenoLabel.setForeground(new java.awt.Color(255, 255, 255));
        memoriaTrabajoPanel.nitrogenoValor.setForeground(new java.awt.Color(255, 255, 255));

        memoriaTrabajoPanel.fosforoLabel.setForeground(new java.awt.Color(255, 255, 255));
        memoriaTrabajoPanel.fosforoValor.setForeground(new java.awt.Color(255, 255, 255));

        memoriaTrabajoPanel.potasioLabel.setForeground(new java.awt.Color(255, 255, 255));
        memoriaTrabajoPanel.potasioValor.setForeground(new java.awt.Color(255, 255, 255));

        memoriaTrabajoPanel.phLabel.setForeground(new java.awt.Color(255, 255, 255));
        memoriaTrabajoPanel.phValor.setForeground(new java.awt.Color(255, 255, 255));

        memoriaTrabajoPanel.materiaOrganicaLabel.setForeground(new java.awt.Color(255, 255, 255));
        memoriaTrabajoPanel.materiaOrganicaValor.setForeground(new java.awt.Color(255, 255, 255));
    }

    public void mostrarHortaliza(String nombreHortaliza) {
        memoriaTrabajoPanel.hortalizaLabel.setForeground(new java.awt.Color(0, 0, 0));
        memoriaTrabajoPanel.hortalizaValor.setForeground(new java.awt.Color(0, 0, 0));
        memoriaTrabajoPanel.hortalizaValor.setText(nombreHortaliza);
    }

    public void mostrarRendimiento(String rendimiento) {
        memoriaTrabajoPanel.rendimientoLabel.setForeground(new java.awt.Color(0, 255, 255));
        memoriaTrabajoPanel.rendimientoValor.setForeground(new java.awt.Color(255, 255, 255));
        memoriaTrabajoPanel.rendimientoValor.setText(rendimiento);
    }

    public void mostrarTextura(String arena, String limo, String arcilla) {
        memoriaTrabajoPanel.arenaLabel.setForeground(new java.awt.Color(255, 255, 255));
        memoriaTrabajoPanel.arenaValor.setForeground(new java.awt.Color(255, 255, 255));
        memoriaTrabajoPanel.arenaLabel.setText(arena);

        memoriaTrabajoPanel.limoLabel.setForeground(new java.awt.Color(255, 255, 255));
        memoriaTrabajoPanel.limoValor.setForeground(new java.awt.Color(255, 255, 255));
        memoriaTrabajoPanel.limoLabel.setText(limo);

        memoriaTrabajoPanel.arcillaLabel.setForeground(new java.awt.Color(255, 255, 255));
        memoriaTrabajoPanel.arcillaValor.setForeground(new java.awt.Color(255, 255, 255));
        memoriaTrabajoPanel.arcillaLabel.setText(arcilla);
    }

    public void mostrarNutrientes(String nitrogeno, String fosforo, String potasio) {
        memoriaTrabajoPanel.nitrogenoLabel.setForeground(new java.awt.Color(255, 255, 255));
        memoriaTrabajoPanel.nitrogenoValor.setForeground(new java.awt.Color(255, 255, 255));
        memoriaTrabajoPanel.nitrogenoLabel.setText(nitrogeno);

        memoriaTrabajoPanel.fosforoLabel.setForeground(new java.awt.Color(255, 255, 255));
        memoriaTrabajoPanel.fosforoValor.setForeground(new java.awt.Color(255, 255, 255));
        memoriaTrabajoPanel.nitrogenoLabel.setText(fosforo);

        memoriaTrabajoPanel.potasioLabel.setForeground(new java.awt.Color(255, 255, 255));
        memoriaTrabajoPanel.potasioValor.setForeground(new java.awt.Color(255, 255, 255));
        memoriaTrabajoPanel.nitrogenoLabel.setText(potasio);
    }

    public void mostrarPh(String ph) {
        memoriaTrabajoPanel.phLabel.setForeground(new java.awt.Color(255, 255, 255));
        memoriaTrabajoPanel.phValor.setForeground(new java.awt.Color(255, 255, 255));
        memoriaTrabajoPanel.phValor.setText(ph);
    }

    public void mostrarMateriaOrganica(String materiaOrganica) {
        memoriaTrabajoPanel.materiaOrganicaLabel.setForeground(new java.awt.Color(255, 255, 255));
        memoriaTrabajoPanel.materiaOrganicaValor.setForeground(new java.awt.Color(255, 255, 255));
        memoriaTrabajoPanel.materiaOrganicaLabel.setText(materiaOrganica);
    }

}
