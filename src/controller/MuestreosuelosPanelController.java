/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.Hashtable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import view.MuestreoSuelosPanel;

/**
 *
 * @author Erlinda
 */
public class MuestreosuelosPanelController {

    MuestreoSuelosPanel muestreoSuelosPanel;

    public MuestreosuelosPanelController(MuestreoSuelosPanel muestreoSuelosPanel) {
        this.muestreoSuelosPanel = muestreoSuelosPanel;
        confPrincipio();
        confMuestreoSuelo();
        confComoMuestrear();
        confDondeNoMuestrear();
        confMateriales();
        confMuestreoBarreno();
        confMuestreoPala();
        confCuarteoMuestra();
    }

    public void confPrincipio() {
        this.muestreoSuelosPanel.jLabelImagen.setIcon(new ImageIcon(getClass().getResource("/img/recomendacionesSecundarias/muestreoSuelo.jpg")));
        String descripcion_t_hor = "<html><body><p align='justify'>La toma de muestras de suelo es sin duda una de las etapas críticas en el proceso para\n"
                + "obtener una recomendación de fertilización en base al análisis de suelo. <br><br>Es necesario tener\n"
                + "presente que cuando se envía al laboratorio una muestra de suelo para análisis , apenas unos\n"
                + "pocos gramos del total serán sometidos a los análisis químicos. <br><br>Estos pocos gramos sin\n"
                + "embargo, deben representar las condiciones promedio de varias toneladas de suelo. Por lo tanto si esa\n"
                + "muestra no es realmente representativa del terreno, la decisión que se tome a partir de los\n"
                + "datos de análisis de suelo no servirá y el objetivo por el cual se hizo el análisis no se habrá\n"
                + "cumplido.</p></body></html>";
        this.muestreoSuelosPanel.jLabelDescripcion.setText(descripcion_t_hor);
    }

    public void confMuestreoSuelo() {
        link(this.muestreoSuelosPanel.jButtonMuestreoSuelo);
        this.muestreoSuelosPanel.jButtonMuestreoSuelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMuestreoSueloActionPerformed(evt);
            }
        });
    }

    private void buttonMuestreoSueloActionPerformed(java.awt.event.ActionEvent evt) {
        this.muestreoSuelosPanel.jLabelImagen.setIcon(new ImageIcon(getClass().getResource("/img/recomendacionesSecundarias/muestreoSuelo.jpg")));
        String descripcion_t_hor = "<html><body><p align='justify'>La toma de muestras de suelo es sin duda una de las etapas críticas en el proceso para\n"
                + "obtener una recomendación de fertilización en base al análisis de suelo. <br><br>Es necesario tener\n"
                + "presente que cuando se envía al laboratorio una muestra de suelo para análisis , apenas unos\n"
                + "pocos gramos del total serán sometidos a los análisis químicos. <br><br>Estos pocos gramos sin\n"
                + "embargo, deben representar las condiciones promedio de varias toneladas de suelo. Por lo tanto si esa\n"
                + "muestra no es realmente representativa del terreno, la decisión que se tome a partir de los\n"
                + "datos de análisis de suelo no servirá y el objetivo por el cual se hizo el análisis no se habrá\n"
                + "cumplido.</p></body></html>";
        this.muestreoSuelosPanel.jLabelDescripcion.setText(descripcion_t_hor);
    }

    public void confComoMuestrear() {
        link(this.muestreoSuelosPanel.jButtonComoMuestrear);
        this.muestreoSuelosPanel.jButtonComoMuestrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonComoMuestrearActionPerformed(evt);
            }
        });
    }

    private void buttonComoMuestrearActionPerformed(java.awt.event.ActionEvent evt) {
        this.muestreoSuelosPanel.jLabelImagen.setIcon(new ImageIcon(getClass().getResource("/img/recomendacionesSecundarias/muestreoZigZag.jpg")));
        String descripcion_t_hor = "<html><body><p align='justify'>El muestreo consiste en realizar un recorrido en zig-zag tomando en cada punto una muestra simple (submuestra)."
                + "<br><br> Posteriormente se mezclará con las muestras de los puntos sucesivos a cada profundidad, formando una muestra compuesta la cual se llevará para su análisis.</p></body></html>";
        this.muestreoSuelosPanel.jLabelDescripcion.setText(descripcion_t_hor);
    }

    public void confDondeNoMuestrear() {
        link(this.muestreoSuelosPanel.jButtonNoMuestrear);
        this.muestreoSuelosPanel.jButtonNoMuestrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDondeNoMuestrearActionPerformed(evt);
            }
        });
    }

    private void buttonDondeNoMuestrearActionPerformed(java.awt.event.ActionEvent evt) {
        this.muestreoSuelosPanel.jLabelImagen.setIcon(new ImageIcon(getClass().getResource("/img/recomendacionesSecundarias/noMuestrear.jpg")));
        String descripcion_t_hor = "<html><body><p align='justify'>Durante el muestreo evite\n"
                + "fumar, comer, o manipular otros productos para evitar la contaminación\n"
                + "de la muestra y obtener resultados falsos. <br><br>No tome\n"
                + "muestras cerca de los caminos, canales, viviendas,\n"
                + "linderos, establos, saladeros, estiércol, estanques o\n"
                + "lugares donde se almacenen productos químicos,\n"
                + "materiales orgánicos, o en lugares donde hubo quemas\n"
                + "recientes. Lávese bien las manos antes de hacer el\n"
                + "muestreo. <br><br>No utilice bolsas o costales donde se hayan\n"
                + "empacado productos químicos, fertilizantes, cal o\n"
                + "plaguicidas</p></body></html>";
        this.muestreoSuelosPanel.jLabelDescripcion.setText(descripcion_t_hor);
    }

    public void confMateriales() {
        link(this.muestreoSuelosPanel.jButtonMateriales);
        this.muestreoSuelosPanel.jButtonMateriales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMaterialesActionPerformed(evt);
            }
        });
    }

    private void buttonMaterialesActionPerformed(java.awt.event.ActionEvent evt) {
        this.muestreoSuelosPanel.jLabelImagen.setIcon(new ImageIcon(getClass().getResource("/img/recomendacionesSecundarias/materialesMuestreo.jpg")));
        String descripcion_t_hor = "<html><body><p align='justify'>Para la toma de muestras se pueden utilizar diferentes herramientas, "
                + "como una pala plana, barreno, una huincha de medir, un cuchillo, un cilindro,bolsas plásticas limpias, lápiz de identificación"
                + " y un balde limpio (para juntar las sub-muestras y mezclar). <br><br>Como el objetivo será determinar la fertilidad del suelo, "
                + "todos los materiales y herramientas deben estar limpios, de modo de evitar la contaminación de la muestra.</p></body></html>";
        this.muestreoSuelosPanel.jLabelDescripcion.setText(descripcion_t_hor);
    }

    public void confMuestreoBarreno() {
        link(this.muestreoSuelosPanel.jButtonMuestrearBarreno);
        this.muestreoSuelosPanel.jButtonMuestrearBarreno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMuestreoBarrenoActionPerformed(evt);
            }
        });
    }

    private void buttonMuestreoBarrenoActionPerformed(java.awt.event.ActionEvent evt) {
        this.muestreoSuelosPanel.jLabelImagen.setIcon(new ImageIcon(getClass().getResource("/img/recomendacionesSecundarias/muestreoBarreno.jpg")));
        String descripcion_t_hor = "<html><body><p align='justify'>Para sacar las sub-muestras con el barreno o instrumentos parecidos se debe limpiar hojas y otros restos de la superficie a muestrear."
                + "<br><br>Debe extraer las submuestras de los puntos marcados en zig zag y juntarlas en un balde limpio<br><br><br><br></p></body></html>";
        this.muestreoSuelosPanel.jLabelDescripcion.setText(descripcion_t_hor);
    }

    public void confMuestreoPala() {
        link(this.muestreoSuelosPanel.jButtonMuestreoPala);
        this.muestreoSuelosPanel.jButtonMuestreoPala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMuestreoPalaActionPerformed(evt);
            }
        });
    }

    private void buttonMuestreoPalaActionPerformed(java.awt.event.ActionEvent evt) {
        this.muestreoSuelosPanel.jLabelImagen.setIcon(new ImageIcon(getClass().getResource("/img/recomendacionesSecundarias/muestreoPala.jpg")));
        String descripcion_t_hor = "<html><body><p align='justify'>Para sacar las sub-muestras con pala se debe limpiar hojas y otros restos de la superficie a muestrear. Cabar 20 cm de profundidad en forma de V y extraer una submuestra con la pala"
                + "<br><br> La sub-muestra de suelo en la pala se debe cortar los extremos del suelo extraido"
                + "<br><br>Debe extraer las submuestras de los puntos marcados en zig zag y juntarlas en un balde limpio<br><br><br><br></p></body></html>";
        this.muestreoSuelosPanel.jLabelDescripcion.setText(descripcion_t_hor);
    }

    public void confCuarteoMuestra() {
        link(this.muestreoSuelosPanel.jButtonCuarteoMuestreo);
        this.muestreoSuelosPanel.jButtonCuarteoMuestreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCuarteoMuestraActionPerformed(evt);
            }
        });
    }

    private void buttonCuarteoMuestraActionPerformed(java.awt.event.ActionEvent evt) {
        this.muestreoSuelosPanel.jLabelImagen.setIcon(new ImageIcon(getClass().getResource("/img/recomendacionesSecundarias/cuarteoMuestreo.jpg")));
        String descripcion_t_hor = "<html><body><p align='justify'>Una vez extraida todas las sub-muestras de los puntos marcados en zig zag se debe mezclar la muestra de suelo homogeneamente y partir en cuatro partes iguales, 2 cuartas partes de la muestra se tira y las otras 2 cuartas partes se conserva"
                + "<br><br>Las dos partes de la muestra obtenida se puede mandar a laboratorio en una bolsa de plastico limpio para su respectivo analisis o utilizar para realizar analisis de suelo utilizando Kits para analisis de suelo.<br><br><br><br></p></body></html>";
        this.muestreoSuelosPanel.jLabelDescripcion.setText(descripcion_t_hor);
    }

    public void link(JButton jButtonlink) {
        Font font = jButtonlink.getFont();
        Hashtable<TextAttribute, Object> map = new Hashtable<TextAttribute, Object>();
        map.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        font = font.deriveFont(map);
        jButtonlink.setFont(font);
        jButtonlink.setForeground(Color.blue);
    }
}
