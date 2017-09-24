/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.ConLabView;

import java.awt.Color;

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
        memoriaTrabajoPanel.hortalizaLabel.setForeground(Color.WHITE);
        memoriaTrabajoPanel.hortalizaValor.setForeground(Color.WHITE);

        memoriaTrabajoPanel.rendimientoLabel.setForeground(Color.WHITE);
        memoriaTrabajoPanel.rendimientoValor.setForeground(Color.WHITE);

        memoriaTrabajoPanel.arenaLabel.setForeground(Color.WHITE);
        memoriaTrabajoPanel.arenaValor.setForeground(Color.WHITE);

        memoriaTrabajoPanel.limoLabel.setForeground(Color.WHITE);
        memoriaTrabajoPanel.limoValor.setForeground(Color.WHITE);

        memoriaTrabajoPanel.arcillaLabel.setForeground(Color.WHITE);
        memoriaTrabajoPanel.arcillaValor.setForeground(Color.WHITE);

        memoriaTrabajoPanel.nitrogenoLabel.setForeground(Color.WHITE);
        memoriaTrabajoPanel.nitrogenoValor.setForeground(Color.WHITE);

        memoriaTrabajoPanel.fosforoLabel.setForeground(Color.WHITE);
        memoriaTrabajoPanel.fosforoValor.setForeground(Color.WHITE);

        memoriaTrabajoPanel.potasioLabel.setForeground(Color.WHITE);
        memoriaTrabajoPanel.potasioValor.setForeground(Color.WHITE);

        memoriaTrabajoPanel.phLabel.setForeground(Color.WHITE);
        memoriaTrabajoPanel.phValor.setForeground(Color.WHITE);

        memoriaTrabajoPanel.materiaOrganicaLabel.setForeground(Color.WHITE);
        memoriaTrabajoPanel.materiaOrganicaValor.setForeground(Color.WHITE);
    }

    public void mostrarHortaliza(String nombreHortaliza) {
        memoriaTrabajoPanel.hortalizaLabel.setForeground(Color.BLACK);
        memoriaTrabajoPanel.hortalizaValor.setForeground(Color.BLACK);
        memoriaTrabajoPanel.hortalizaValor.setText(nombreHortaliza);
    }

    public void mostrarRendimiento(String rendimiento) {
        memoriaTrabajoPanel.rendimientoLabel.setForeground(Color.BLACK);
        memoriaTrabajoPanel.rendimientoValor.setForeground(Color.BLACK);
        memoriaTrabajoPanel.rendimientoValor.setText(rendimiento);
    }

    public void mostrarTextura(String arena, String limo, String arcilla) {
        memoriaTrabajoPanel.arenaLabel.setForeground(Color.BLACK);
        memoriaTrabajoPanel.arenaValor.setForeground(Color.BLACK);
        memoriaTrabajoPanel.arenaLabel.setText(arena);

        memoriaTrabajoPanel.limoLabel.setForeground(Color.BLACK);
        memoriaTrabajoPanel.limoValor.setForeground(Color.BLACK);
        memoriaTrabajoPanel.limoLabel.setText(limo);

        memoriaTrabajoPanel.arcillaLabel.setForeground(Color.BLACK);
        memoriaTrabajoPanel.arcillaValor.setForeground(Color.BLACK);
        memoriaTrabajoPanel.arcillaLabel.setText(arcilla);
    }

    public void mostrarNutrientes(String nitrogeno, String fosforo, String potasio) {
        memoriaTrabajoPanel.nitrogenoLabel.setForeground(Color.BLACK);
        memoriaTrabajoPanel.nitrogenoValor.setForeground(Color.BLACK);
        memoriaTrabajoPanel.nitrogenoLabel.setText(nitrogeno);

        memoriaTrabajoPanel.fosforoLabel.setForeground(Color.BLACK);
        memoriaTrabajoPanel.fosforoValor.setForeground(Color.BLACK);
        memoriaTrabajoPanel.nitrogenoLabel.setText(fosforo);

        memoriaTrabajoPanel.potasioLabel.setForeground(Color.BLACK);
        memoriaTrabajoPanel.potasioValor.setForeground(Color.BLACK);
        memoriaTrabajoPanel.nitrogenoLabel.setText(potasio);
    }

    public void mostrarPh(String ph) {
        memoriaTrabajoPanel.phLabel.setForeground(Color.BLACK);
        memoriaTrabajoPanel.phValor.setForeground(Color.BLACK);
        memoriaTrabajoPanel.phValor.setText(ph);
    }

    public void mostrarMateriaOrganica(String materiaOrganica) {
        memoriaTrabajoPanel.materiaOrganicaLabel.setForeground(Color.BLACK);
        memoriaTrabajoPanel.materiaOrganicaValor.setForeground(Color.BLACK);
        memoriaTrabajoPanel.materiaOrganicaLabel.setText(materiaOrganica);
    }

}
