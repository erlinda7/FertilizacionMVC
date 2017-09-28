/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.sinLabView;

import java.awt.Color;

/**
 *
 * @author Erlinda
 */
public class MemoriaTrabajosinLABPanelController {

    MemoriaTrabajosinLABPanel memoriaTrabajosinLABPanel;

    public MemoriaTrabajosinLABPanelController(MemoriaTrabajosinLABPanel memoriaTrabajosinLABPanel) {
        this.memoriaTrabajosinLABPanel = memoriaTrabajosinLABPanel;
        confMemoriaTrabajo();
    }

    public void confMemoriaTrabajo() {
        memoriaTrabajosinLABPanel.hortalizaLabel.setForeground(Color.WHITE);
        memoriaTrabajosinLABPanel.hortalizaValor.setForeground(Color.WHITE);

        memoriaTrabajosinLABPanel.rendimientoLabel.setForeground(Color.WHITE);
        memoriaTrabajosinLABPanel.rendimientoValor.setForeground(Color.WHITE);

        memoriaTrabajosinLABPanel.arenaLabel.setForeground(Color.WHITE);
        memoriaTrabajosinLABPanel.arenaValor.setForeground(Color.WHITE);

        memoriaTrabajosinLABPanel.limoLabel.setForeground(Color.WHITE);
        memoriaTrabajosinLABPanel.limoValor.setForeground(Color.WHITE);

        memoriaTrabajosinLABPanel.arcillaLabel.setForeground(Color.WHITE);
        memoriaTrabajosinLABPanel.arcillaValor.setForeground(Color.WHITE);

        memoriaTrabajosinLABPanel.nitrogenoLabel.setForeground(Color.WHITE);
        memoriaTrabajosinLABPanel.nitrogenoValor.setForeground(Color.WHITE);

        memoriaTrabajosinLABPanel.fosforoLabel.setForeground(Color.WHITE);
        memoriaTrabajosinLABPanel.fosforoValor.setForeground(Color.WHITE);

        memoriaTrabajosinLABPanel.potasioLabel.setForeground(Color.WHITE);
        memoriaTrabajosinLABPanel.potasioValor.setForeground(Color.WHITE);

        memoriaTrabajosinLABPanel.phLabel.setForeground(Color.WHITE);
        memoriaTrabajosinLABPanel.phValor.setForeground(Color.WHITE);

        memoriaTrabajosinLABPanel.materiaOrganicaLabel.setForeground(Color.WHITE);
        memoriaTrabajosinLABPanel.materiaOrganicaValor.setForeground(Color.WHITE);
    }

    public void mostrarCultivo(String nombreHortaliza, String rendimiento) {
        memoriaTrabajosinLABPanel.hortalizaLabel.setForeground(Color.BLACK);
        memoriaTrabajosinLABPanel.hortalizaValor.setForeground(Color.BLACK);
        memoriaTrabajosinLABPanel.hortalizaValor.setText(nombreHortaliza);

        memoriaTrabajosinLABPanel.rendimientoLabel.setForeground(Color.BLACK);
        memoriaTrabajosinLABPanel.rendimientoValor.setForeground(Color.BLACK);
        memoriaTrabajosinLABPanel.rendimientoValor.setText(rendimiento);
    }

    public void mostrarTextura(String arena, String limo, String arcilla) {
        memoriaTrabajosinLABPanel.arenaLabel.setForeground(Color.BLACK);
        memoriaTrabajosinLABPanel.arenaValor.setForeground(Color.BLACK);
        memoriaTrabajosinLABPanel.arenaValor.setText(arena);

        memoriaTrabajosinLABPanel.limoLabel.setForeground(Color.BLACK);
        memoriaTrabajosinLABPanel.limoValor.setForeground(Color.BLACK);
        memoriaTrabajosinLABPanel.limoValor.setText(limo);

        memoriaTrabajosinLABPanel.arcillaLabel.setForeground(Color.BLACK);
        memoriaTrabajosinLABPanel.arcillaValor.setForeground(Color.BLACK);
        memoriaTrabajosinLABPanel.arcillaValor.setText(arcilla);
    }

    public void mostrarNitrogeno(String nitrogeno) {

        switch (nitrogeno) {
            case "24":
                memoriaTrabajosinLABPanel.nitrogenoValor.setText("Muy bajo");
                break;
            case "31":
                memoriaTrabajosinLABPanel.nitrogenoValor.setText("Bajo");
                break;
            case "43":
                memoriaTrabajosinLABPanel.nitrogenoValor.setText("Medio");
                break;
            case "49":
                memoriaTrabajosinLABPanel.nitrogenoValor.setText("Alto");
                break;
            default:
                System.out.println("No hay Valores");
                break;
        }
        memoriaTrabajosinLABPanel.nitrogenoLabel.setForeground(Color.BLACK);
        memoriaTrabajosinLABPanel.nitrogenoValor.setForeground(Color.BLACK);

    }

    public void mostrarFosforo(String fosforo) {
         switch (fosforo) {
            case "9":
                memoriaTrabajosinLABPanel.fosforoValor.setText("Muy bajo");
                break;
            case "14":
                memoriaTrabajosinLABPanel.fosforoValor.setText("Bajo");
                break;
            case "24":
                memoriaTrabajosinLABPanel.fosforoValor.setText("Medio");
                break;
            case "30":
                memoriaTrabajosinLABPanel.fosforoValor.setText("Alto");
                break;
            default:
                System.out.println("No hay Valores");
                break;
        }
        memoriaTrabajosinLABPanel.fosforoLabel.setForeground(Color.BLACK);
        memoriaTrabajosinLABPanel.fosforoValor.setForeground(Color.BLACK);
        
    }

    public void mostrarPotasio(String potasio) {
         switch (potasio) {
            case "25":
                memoriaTrabajosinLABPanel.potasioValor.setText("Muy bajo");
                break;
            case "40":
                memoriaTrabajosinLABPanel.potasioValor.setText("Bajo");
                break;
            case "55":
                memoriaTrabajosinLABPanel.potasioValor.setText("Medio");
                break;
            case "85":
                memoriaTrabajosinLABPanel.potasioValor.setText("Alto");
                break;
            default:
                System.out.println("No hay Valores");
                break;
        }
        memoriaTrabajosinLABPanel.potasioLabel.setForeground(Color.BLACK);
        memoriaTrabajosinLABPanel.potasioValor.setForeground(Color.BLACK);
        //memoriaTrabajosinLABPanel.potasioValor.setText(potasio);
    }

    public void mostrarPh(String ph) {
        memoriaTrabajosinLABPanel.phLabel.setForeground(Color.BLACK);
        memoriaTrabajosinLABPanel.phValor.setForeground(Color.BLACK);
        memoriaTrabajosinLABPanel.phValor.setText(ph);
    }

    public void mostrarMateriaOrganica(String materiaOrganica) {
        memoriaTrabajosinLABPanel.materiaOrganicaLabel.setForeground(Color.BLACK);
        memoriaTrabajosinLABPanel.materiaOrganicaValor.setForeground(Color.BLACK);
        memoriaTrabajosinLABPanel.materiaOrganicaValor.setText(materiaOrganica);
    }
}
