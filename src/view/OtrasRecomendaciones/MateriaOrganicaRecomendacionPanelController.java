/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.OtrasRecomendaciones;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import model.Cultivo;

/**
 *
 * @author Erlinda
 */
public class MateriaOrganicaRecomendacionPanelController {

    MateriaOrganicaRecomendacionPanel materiaOrganicaRecPanel;

    public MateriaOrganicaRecomendacionPanelController(MateriaOrganicaRecomendacionPanel aumentarMateriaOrganicaPanel) {
        this.materiaOrganicaRecPanel = aumentarMateriaOrganicaPanel;
        //mostrarExplicacionMO();
        mostrarExplicacion();
    }

    public void mostrarExplicacionMO(Cultivo cultivo) {
        ///capturar desde cultivo nivelMO, rangoMO
        double nivelMO = cultivo.getNivelMO();
        String rangoMO = cultivo.getRangoNivelMO();

        if (nivelMO <= 4.0) {
            materiaOrganicaRecPanel.nivelMOlabel.setText("<html><body><p align='justify'>" + "El nivel de  Materia Organica en el suelo es ' " + nivelMO + " ' por lo cual se considera que el contenido de materia organica en el suelo es ' " + rangoMO + " '</body></html>");
            materiaOrganicaRecPanel.explicacionMOLabel.setText("<html><body><p align='justify'>La Materia Organica del suelo se mejora aplicando esteriecol, abono verde o compostaje.</body></html>");
        } else {
            materiaOrganicaRecPanel.nivelMOlabel.setText("<html><body><p align='justify'>" + "El nivel de  Materia Organica en el suelo es ' " + nivelMO + " ' por lo cual se considera que el contenido de materia organica en el suelo ' " + rangoMO + " '</body></html>");
            materiaOrganicaRecPanel.explicacionMOLabel.setText("<html><body><p align='justify'>La Materia Organica del suelo es adecuada no necesita agregar materia organica.</body></html>");
        }

    }

    public void mostrarExplicacion() {
        materiaOrganicaRecPanel.jLabelRecMO1.setToolTipText("<html><body><p align='justify'>Escoger un sito libre de lluvias <br>y agrege paja de maiz</html></body>");
        materiaOrganicaRecPanel.jLabelRecMO1.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jLabelRecMO1MouseEntered(evt);
            }
        });

        materiaOrganicaRecPanel.jLabelRecMO2.setToolTipText("<html><body><p align='justify'>Agrege desechos vegetales, agua, <br>cal, tierra y ceniza</html></body>");
        materiaOrganicaRecPanel.jLabelRecMO2.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jLabelRecMO2MouseEntered(evt);
            }
        });

        materiaOrganicaRecPanel.jLabelRecMO3.setToolTipText("<html><body><p align='justify'>Agrege estiercol de animal y <br>encima agrege una capa delgada de tierra</html></body>");
        materiaOrganicaRecPanel.jLabelRecMO3.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jLabelRecMO3MouseEntered(evt);
            }
        });

        materiaOrganicaRecPanel.jLabelRecMO4.setToolTipText("<html><body><p align='justify'>Coloque respiraderos <br>de caña de bambu</html></body>");
        materiaOrganicaRecPanel.jLabelRecMO4.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jLabelRecMO4MouseEntered(evt);
            }
        });

        materiaOrganicaRecPanel.jLabelRecMO5.setToolTipText("<html><body><p align='justify'>O haga respiraderos haciendo <br>hoyos en el monton</html></body>");
        materiaOrganicaRecPanel.jLabelRecMO5.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jLabelRecMO5MouseEntered(evt);
            }
        });

        materiaOrganicaRecPanel.jLabelRecMO6.setToolTipText("<html><body><p align='justify'>Dele vuelta al monton de tal forma forma que quede una mezcla uniforme<br> y luego voltee nuevamente la mezcla dentro de 5 semanas<br>El compost estará listo en 4 meses<br>Agrege el compost un mes antes del arado<html><body>");
        materiaOrganicaRecPanel.jLabelRecMO6.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jLabelRecMO6MouseEntered(evt);
            }
        });

        materiaOrganicaRecPanel.jLabelRecMO7.setToolTipText("<html><body><p align='justify'>El estiercol debe estar bien seco</html></body>");
        materiaOrganicaRecPanel.jLabelRecMO7.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jLabelRecMO7MouseEntered(evt);
            }
        });

        materiaOrganicaRecPanel.jLabelRecMO8.setToolTipText("<html><body><p align='justify'>Extender el estiercol sobre el terreno <br>un mes antes del arado<html><body>");
        materiaOrganicaRecPanel.jLabelRecMO8.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jLabelRecMO8MouseEntered(evt);
            }
        });

        materiaOrganicaRecPanel.jLabelRecMO9.setToolTipText("<html><body><p align='justify'>Cortar restos de leguminosas<br> verdes o avena</html></body>");
        materiaOrganicaRecPanel.jLabelRecMO9.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jLabelRecMO9MouseEntered(evt);
            }
        });

        materiaOrganicaRecPanel.jLabelRecMO10.setToolTipText("<html><body><p align='justify'>Extender sobre el terreno los restos vegetales <br>verdes faltando 2 semanas para el arado</html></body>");
        materiaOrganicaRecPanel.jLabelRecMO10.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jLabelRecMO10MouseEntered(evt);
            }
        });
    }

    public void jLabelRecMO1MouseEntered(MouseEvent evt) {
        materiaOrganicaRecPanel.jLabelRecMO1.getToolTipText();
    }

    public void jLabelRecMO2MouseEntered(MouseEvent evt) {
        materiaOrganicaRecPanel.jLabelRecMO2.getToolTipText();
    }

    public void jLabelRecMO3MouseEntered(MouseEvent evt) {
        materiaOrganicaRecPanel.jLabelRecMO3.getToolTipText();
    }

    public void jLabelRecMO4MouseEntered(MouseEvent evt) {
        materiaOrganicaRecPanel.jLabelRecMO4.getToolTipText();
    }

    public void jLabelRecMO5MouseEntered(MouseEvent evt) {
        materiaOrganicaRecPanel.jLabelRecMO5.getToolTipText();
    }

    public void jLabelRecMO6MouseEntered(MouseEvent evt) {
        materiaOrganicaRecPanel.jLabelRecMO6.getToolTipText();
    }

    public void jLabelRecMO7MouseEntered(MouseEvent evt) {
        materiaOrganicaRecPanel.jLabelRecMO7.getToolTipText();
    }

    public void jLabelRecMO8MouseEntered(MouseEvent evt) {
        materiaOrganicaRecPanel.jLabelRecMO8.getToolTipText();
    }

    public void jLabelRecMO9MouseEntered(MouseEvent evt) {
        materiaOrganicaRecPanel.jLabelRecMO9.getToolTipText();
    }

    public void jLabelRecMO10MouseEntered(MouseEvent evt) {
        materiaOrganicaRecPanel.jLabelRecMO10.getToolTipText();
    }
}
