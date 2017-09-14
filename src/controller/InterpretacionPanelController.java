/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.ImageIcon;
import view.InterpretacionEPanel;
import view.InterpretacionPanel;

/**
 *
 * @author Erlinda
 */
public class InterpretacionPanelController {

    InterpretacionPanel jPInterpretacion;
    InterpretacionEPanel jEPInterpretacion;

    public InterpretacionPanelController(InterpretacionPanel jPInterpretacion) {
        this.jPInterpretacion = jPInterpretacion;
        this.jEPInterpretacion = jPInterpretacion.getInterpretacionEPanel1();
        contenidoEPInterpretacion();
    }

    public void contenidoEPInterpretacion() {
        jEPInterpretacion.setEditable(false);
        jEPInterpretacion.setContentType("text/html");
        // jEPInterpretacion.set
        ImageIcon pigIcon = createImageIcon("/img/TexturaTransparente.gif");
        jEPInterpretacion.setText(" <DIV ALIGN=center><h1><b> Interpretación de Datos </h1></b></DIV>"
                + "<blockquote><b><h2><i>Textura: </i></h2></b></blockquote>"
                + "<blockquote><blockquote><p align='justify'>El triangulo textural muestra los porcentajes relativos de arena, limo y arcilla en los lados del triangulo"
                + "y las 12 clases texturales en su Interior. "
                + "Cualquier punto dentro del triangulo determina el porcentaje proporción de arena, limo y arcilla cuya sumatoria"
                + "es el 100%.</p></blockquote></blockquote>"
                + "<html><div align=center><img src='" + pigIcon + "' width=529 height=475></img></div>"
                + "<blockquote><blockquote><p align='justify'>La interseccion de las lineas de un suelo en el cuadro textural con una composición de 30% de Arena, 10% de Limo ,"
                + " y 60% de Arcilla definen al suelo como un suelo Arcilloso.</p></blockquote></blockquote>  "
                + "<hr align=center>"
                //pH
                + "<blockquote><b><h2>Reacción del Suelo (pH): </b></h2><blockquote>Definen si un suelo es ácido, alcalino o neutro.</blockquote></blockquote>"
                + " <blockquote><blockquote><blockquote> "
                + "<Pre>mayor a 9.00  = extremadamente alcalino<br> "
                + "8.01 - 9.00  = fuertemente alcalino <br>"
                + " 7.51 - 8.00  = ligeramente alcalino <br>"
                + " 6.51 - 7.50  = neutro <br>"
                + " 6.01 - 6.50  = ligeramente ácido <br>"
                + " 5.01 - 6.00  = moderadamente ácido <br>"
                + " 4.01 - 5.00  = fuertemente ácido <br>"
                + " 3.01 - 4.00  = muy fuertemente ácido <br>"
                + "menor a 3.00  = extremadamente ácido </pre></blockquote></blockquote></blockquote>"
                + "<hr align=center>"
                //Nitrogeno
                + "<blockquote><b><h2>Nitrogeno: </b></h2><blockquote>Define si el nivel de Nitrogeno en el suelo es alto, medio, bajo o muy bajo</blockquote></blockquote>"
                + "<blockquote><blockquote><blockquote><pre>"
                + "    Alto : Mayor a 48 ppm <br>"
                + "   Medio : 38 - 48 ppm <br>"
                + "    Bajo : 25 - 37 ppm <br>"
                + "Muy Bajo : Menor a 25 ppm </pre></blockquote></blockquote></blockquote>"
                + "<hr align=center>"
                //FÃ³sforo
                + "<blockquote><b><h2>Fósforo: </b></h2><blockquote>Define si el nivel de Fósforo en el suelo es alto, medio o bajo </blockquote></blockquote>"
                + "<blockquote><blockquote><blockquote><pre>"
                + "    Alto : Mayor a 29 ppm <br>"
                + "   Medio : 18 - 29 ppm <br>"
                + "    Bajo : 10 - 17 ppm <br>"
                + "Muy Bajo : Menor a 10 ppm </pre></blockquote></blockquote></blockquote>"
                + "<hr align=center>"
                //Potasio
                + "<blockquote><b><h2>Potasio: </b></h2><blockquote>Define si el nivel de Potasio en el suelo es muy alto, alto, medio o bajo </blockquote></blockquote>"
                + "<blockquote><blockquote><blockquote><pre>"
                + "Muy Alto : Mayor a 160 ppm <br>"
                + "    Alto : 131 - 160 ppm <br>"
                + "   Medio : 81 - 130 ppm <br>"
                + "    Bajo : Menor a 80 ppm </pre></blockquote></blockquote></blockquote>"
                + "<hr align=center>"
                //Materia Organica
                + "<blockquote><b><h2>Materia Orgánica: </b></h2><blockquote>Define si el nivel de Materia Orgánica en el suelo es muy alto, alto, medio, bajo o muy bajo </blockquote></blockquote>"
                + "<blockquote><blockquote><blockquote><pre>"
                + "Muy Alto : Mayor a 8.0  <br>"
                + "    Alto : 4.1 - 8.0  <br>"
                + "   Medio : 2.1 - 4.0  <br>"
                + "    Bajo : 1.1 - 2.0  <br>"
                + "Muy Bajo : Menor a 1.0  </pre></blockquote></blockquote></blockquote>"
                + "<hr align=center>"
        );
    }

    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = InterpretacionPanelController.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("No encontrado" + path);
            return null;
        }
    }
}
