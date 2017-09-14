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
import view.DocumentacionPanel;

/**
 *
 * @author Erlinda
 */
public class DocumentacionPanelController {

    DocumentacionPanel jPDocumentacion;

    public DocumentacionPanelController(DocumentacionPanel jPDocumentacion) {
        this.jPDocumentacion = jPDocumentacion;
        confInicial();
    }

    public void confInicial() {
        // jPDocumentacion.jButtonHortaliza.setContentAreaFilled(true);

        confHortaliza();
        confFertilizante();
        confPrincipio();
        confMO();
        confPH();
        confArena();
        confLimo();
        confArcilla();
        confNitrogeno();
        confFosforo();
        confPotasio();
    }

    public void confPrincipio() {
        this.jPDocumentacion.jLabelImagen.setIcon(new ImageIcon(getClass().getResource("/img/hortaliza.png")));
        String descripcion_t_hor = "<html><body><p align='justify'>Las hortalizas son plantas comestibles fáciles de producir. Las hortalizas son parte de la alimentación del hombre por aportar en la nutrición con vitaminas, proteínas y minerales que necesita el cuerpo para mantenerse sano y fuerte."
                + "<br><br>Las hortalizas proveen energía para trabajar, jugar, crecer y también proporcionan protección a cada uno de los órganos del cuerpo contra las enfermedades."
                + "<br><br>Para el cultivo de hortalizas es importante conocer las condiciones ambientales, clima, suelo, manejo de fertilizantes y la tolerancia del pH del suelo para obtener mejores rendimientos."
                + "</p></body></html>";
        this.jPDocumentacion.jLabelDescripcion.setText(descripcion_t_hor);
    }

    public void confHortaliza() {
        link(this.jPDocumentacion.jButtonHortaliza);
        this.jPDocumentacion.jButtonHortaliza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHortalizaActionPerformed(evt);
            }
        });
    }

    public void confFertilizante() {
        link(this.jPDocumentacion.jButtonFetilizante);
        this.jPDocumentacion.jButtonFetilizante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFertilizantesActionPerformed(evt);
            }
        });
    }

    public void confMO() {
        link(this.jPDocumentacion.jButtonMO);
        this.jPDocumentacion.jButtonMO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMateriaOrganicaActionPerformed(evt);
            }
        });
    }

    public void confPH() {
        link(this.jPDocumentacion.jButtonPH);
        this.jPDocumentacion.jButtonPH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPHActionPerformed(evt);
            }
        });
    }

    public void confArena() {
        link(this.jPDocumentacion.jButtonArena);
        this.jPDocumentacion.jButtonArena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTArenosoActionPerformed(evt);
            }
        });
    }

    public void confLimo() {
        link(this.jPDocumentacion.jButtonLimo);
        this.jPDocumentacion.jButtonLimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTLimosoActionPerformed(evt);
            }
        });
    }

    public void confArcilla() {
        link(this.jPDocumentacion.jButtonArcilla);
        this.jPDocumentacion.jButtonArcilla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTArcillosoActionPerformed(evt);
            }
        });
    }

    public void confNitrogeno() {
        link(this.jPDocumentacion.jButtonNitrogeno);
        this.jPDocumentacion.jButtonNitrogeno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNNitrogenoActionPerformed(evt);
            }
        });
    }

    public void confFosforo() {
        link(this.jPDocumentacion.jButtonFosforo);
        this.jPDocumentacion.jButtonFosforo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNFosforoActionPerformed(evt);
            }
        });
    }

    public void confPotasio() {
        link(this.jPDocumentacion.jButtonPotasio);
        this.jPDocumentacion.jButtonPotasio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNPotasioActionPerformed(evt);
            }
        });
    }

    private void buttonHortalizaActionPerformed(java.awt.event.ActionEvent evt) {
        this.jPDocumentacion.jLabelImagen.setIcon(new ImageIcon(getClass().getResource("/img/hortaliza.png")));
        String descripcion_t_hor = "<html><body><p align='justify'>Las hortalizas son plantas comestibles fáciles de producir. Las hortalizas son parte de la alimentación del hombre por aportar en la nutrición con vitaminas, proteínas y minerales que necesita el cuerpo para mantenerse sano y fuerte."
                + "<br><br>Las hortalizas proveen energía para trabajar, jugar, crecer y también proporcionan protección a cada uno de los órganos del cuerpo contra las enfermedades."
                + "<br><br>Para el cultivo de hortalizas es importante conocer las condiciones ambientales, clima, suelo, manejo de fertilizantes y la tolerancia del pH del suelo para obtener mejores rendimientos."
                + "</p></body></html>";
        this.jPDocumentacion.jLabelDescripcion.setText(descripcion_t_hor);
        // this.jPDocumentacion.jButtonHortaliza.setForeground(Color.blue);
    }

    private void buttonFertilizantesActionPerformed(java.awt.event.ActionEvent evt) {
        this.jPDocumentacion.jLabelImagen.setIcon(new ImageIcon(getClass().getResource("/img/fertilizante.jpg")));
        String descripcion_t_Fer = "<html><body><p align='justify'>Un fertilizante es una sustancia natural o industrializada que mejora la calidad de la tierra y facilita el crecimiento de las plantas. "
                + "<br><br>Los fertilizantes proveen nutrientes que los cultivos necesitan. "
                + "<br><br>Con los fertilizantes se pueden producir más alimentos y cultivos comerciales, y de mejor calidad. "
                + "<br><br>Además de  mejorar la baja fertilidad de los suelos que han sido sobreexplotados."
                + "<br><br><br><br>"
                + "</p></body></html>";
        this.jPDocumentacion.jLabelDescripcion.setText(descripcion_t_Fer);

    }

    private void buttonMateriaOrganicaActionPerformed(java.awt.event.ActionEvent evt) {
        this.jPDocumentacion.jLabelImagen.setIcon(new ImageIcon(getClass().getResource("/img/materiaorganica.jpg")));
        String descripcion_t_MO = "<html><body><p align='justify'>Es la descomposición de los residuos de plantas y animales. "
                + "<br><br>La materia orgánica contribuye al suelo aportando nutrientes y mejorando sus características físicas"
                + "<br><br><br><br><br><br><br><br>"
                + "</p></body></html>";
        this.jPDocumentacion.jLabelDescripcion.setText(descripcion_t_MO);

    }

    private void buttonPHActionPerformed(java.awt.event.ActionEvent evt) {
        this.jPDocumentacion.jLabelImagen.setIcon(new ImageIcon(getClass().getResource("/img/ph.jpg")));
        String descripcion_t_ph = "<html><body><p align='justify'>El pH es una medida de la acidez o basicidad de los suelos. "
                + "<br><br>Los suelos fuertemente ácidos tienen poca cantidad de nutrientes como calcio, magnesio y potasio lo cual ocasiona disminución del crecimiento de la planta."
                + "<br><br> En suelos con fuerte basicidad tienen un elevado contenido de calcio lo cual dificulta la absorción de los micronutrientes."
                + "<br><br>Las plantas tienen necesidades específicas del pH del suelo, en algunos casos es necesario alterar el pH del suelo para poder cultivar con éxito. "
                + "</p></body></html>";
        this.jPDocumentacion.jLabelDescripcion.setText(descripcion_t_ph);

    }

    private void buttonTArenosoActionPerformed(java.awt.event.ActionEvent evt) {
        this.jPDocumentacion.jLabelImagen.setIcon(new ImageIcon(getClass().getResource("/img/arenosa.jpg")));
        String descripcion_t_arenoso = "<html><body><p align='justify'>Los suelos arenosos tienen un tamaño de partícula entre los 0,05 y 2,00 mm, contienen las partículas más grandes que el resto de los suelos. "
                + "<br><br>Estos suelos  no son los de mejor calidad para agricultura ya que no son ricos en nutrientes y no retienen el agua por mucho tiempo."
                + "<br><br><br>"
                + "<br><br><br>"
                + "<br><br><br>"
                + "</p></body></html>";
        this.jPDocumentacion.jLabelDescripcion.setText(descripcion_t_arenoso);

    }

    private void buttonTLimosoActionPerformed(java.awt.event.ActionEvent evt) {
        this.jPDocumentacion.jLabelImagen.setIcon(new ImageIcon(getClass().getResource("/img/limoso.jpg")));
        String descripcion_t_limoso = "<html><body><p align='justify'>Los suelos limosos están compuestas de partículas más pequeñas que varían entre los 0,002 y 0,05 mm."
                + "<br><br>Son terrenos muy fértiles donde se puede se cultivar la mayoría de las plantas ya que retienen por más tiempo el agua y los nutrientes."
                + "<br><br><br><br><br><br><br><br><br>"
                + "</p></body></html>";
        this.jPDocumentacion.jLabelDescripcion.setText(descripcion_t_limoso);

    }

    private void buttonTArcillosoActionPerformed(java.awt.event.ActionEvent evt) {
        this.jPDocumentacion.jLabelImagen.setIcon(new ImageIcon(getClass().getResource("/img/arcilloso.jpg")));
        String descripcion_t_arcilloso = "<html><body><p align='justify'>Los suelos arcillosos están formadas por partículas muy finas de tamaño menor a 0,002 mm, estos suelos retienen gran cantidad de agua y nutrientes por lo cual son muy fértiles."
                + "<br><br>Estos suelos son difíciles de trabajar cuando están mojados y cuando se secan se vuelven muy duros que llegan a dañar las raíces de las plantas, por lo cual no se puede plantar cualquier tipo de planta, funcionan bien para plantas de raíces profundas."
                + "<br><br>Estos terrenos son muy buenas si se manejan bien el riego y se agregan abonos."
                + "<br><br><br>"
                + "</p></body></html>";
        this.jPDocumentacion.jLabelDescripcion.setText(descripcion_t_arcilloso);

    }

    private void buttonNNitrogenoActionPerformed(java.awt.event.ActionEvent evt) {
        this.jPDocumentacion.jLabelImagen.setIcon(new ImageIcon(getClass().getResource("/img/nitrogeno.gif")));
        String descripcion_t_N = "<html><body><p align='justify'>El nitrógeno favorece el crecimiento, da color verde a las hojas. "
                + "<br><br>Un exceso de este elemento retarda la maduración, debilita la planta, esto puede bajar la calidad del cultivo y puede provocar menor resistencia a enfermedades. "
                + "<br><br><br><br><br><br><br>"
                + "</p></body></html>";
        this.jPDocumentacion.jLabelDescripcion.setText(descripcion_t_N);

    }

    private void buttonNFosforoActionPerformed(java.awt.event.ActionEvent evt) {
        this.jPDocumentacion.jLabelImagen.setIcon(new ImageIcon(getClass().getResource("/img/fosforo.gif")));
        String descripcion_t_P = "<html><body><p align='justify'>El fósforo acelera la madurez más que otros nutrientes. "
                + "<br><br>Los efectos de la cantidad de fósforo sobre el crecimiento de las plantas son menos notables."
                + "<br><br>Por la falta de fósforo la planta toma un aspecto raquítico, crece lentamente y se produce un retraso en la fase de maduración."
                + "<br><br><br><br><br><br><br><br><br>"
                + "</p></body></html>";
        this.jPDocumentacion.jLabelDescripcion.setText(descripcion_t_P);

    }

    private void buttonNPotasioActionPerformed(java.awt.event.ActionEvent evt) {
        this.jPDocumentacion.jLabelImagen.setIcon(new ImageIcon(getClass().getResource("/img/potasio.png")));
        String descripcion_t_K = "<html><body><p align='justify'>El potasio ayuda el desarrollo de las raíces y mejora su resistencia a las bajas temperaturas y enfermedades. "
                + "<br><br>La carencia de potasio disminuye la calidad del fruto, ya que este elemento tiene influencia directa sobre la calidad del fruto"
                + "<br><br><br><br><br><br><br><br>"
                + "</p></body></html>";
        this.jPDocumentacion.jLabelDescripcion.setText(descripcion_t_K);

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
