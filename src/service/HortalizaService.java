/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;
import model.Hortaliza;

/**
 *
 * @author Erlinda
 */
public class HortalizaService {

    private ArrayList<Hortaliza> listaHortalizas;

    public HortalizaService() {
        this.listaHortalizas = new ArrayList<Hortaliza>();
        llenarHortaliza();
    }

    public void llenarHortaliza() {
        this.listaHortalizas.add(new Hortaliza("Acelga", new String[]{"10", "13", "16", "20", "25", "30"}, "/img/acelga.jpg", "La acelga es hortaliza de climas fríos. Tolera heladas, aunque también responde bien a las temperaturas medias.<br><br> Se desarrolla en cualquier tipo de suelo, aunque se comporta mejor en suelos arcillo arenosos. El pH del suelo favorable para la acelga está entre 6.5 a 7.5."));
        this.listaHortalizas.add(new Hortaliza("Apio", new String[]{"6", "8", "10", "13", "16", "20"}, "/img/apio.jpg", "El apio se desarrolla bien en climas templados y frescos. Puede tolerar heladas ligeras, muy sensible al granizo. <br><br>Se desarrolla bien en suelos franco arcillosos con buen contenido de materia orgánica. Se adapta prácticamente a cualquier tipo de suelos controlando bien el riego. El pH favorable está entre 6.0 a 6.8. "));
        this.listaHortalizas.add(new Hortaliza("Arveja", new String[]{"2", "2.5", "3", "3.5", "4", "4.5"}, "/img/arveja.jpg", "La arveja también es conocida como chícharo o guisante, es una hortaliza que se desarrolla mejor en climas templados y que en sus primeras etapas de crecimiento, resiste las bajas temperaturas. Las temperaturas elevadas disminuyen la calidad de la arveja. <br><br>Se desarrolla mejor en suelos francos, con contenido de materia orgánica y buen manejo del riego. El pH favorable se encuentra en los rangos de 5.5 a 6.8."));
        this.listaHortalizas.add(new Hortaliza("Berenjena", new String[]{"10", "15", "20", "25", "30", "35"}, "/img/berenjena.jpg", "Las berenjenas son plantas de clima caliente tolerante a altas temperaturas. Su crecimiento se detiene cuando las temperaturas son muy bajas.<br><br> Crece bien en suelos francos con buen riego y materia orgánica, para las berenjenas no son convenientes suelos excesivamente húmedos. El pH favorable está entre 5.5 y 6.8."));
        this.listaHortalizas.add(new Hortaliza("Brocoli", new String[]{"3", "3.5", "4", "5", "6", "7"}, "/img/brocoli.jpg", "El brócoli es hortaliza de climas fríos, tolerante a las bajas temperaturas.<br><br> Se adapta bien a todo tipo de suelos, aunque prefiere los franco arenosos, con buen contenido de materia orgánica. El pH favorable está entre 6.0 y 7.0."));
        this.listaHortalizas.add(new Hortaliza("Cebolla", new String[]{"10", "15", "20", "23", "27", "30"}, "/img/cebolla.jpg", "Es un cultivo de climas templados. Muy tolerante a las bajas temperaturas. En la formación y maduración de las cebollas, requiere temperaturas elevadas.<br><br> La cebolla se desarrolla en terrenos con contenidos de materia orgánica, los suelos recomendados son los de texturas limosas o franco limosa. No se recomienda sembrar en suelos arcillosos. El pH favorable para la cebolla está entre 6.0 y 7.0."));
        this.listaHortalizas.add(new Hortaliza("Coliflor", new String[]{"10", "15", "20", "23", "26", "30"}, "/img/coliflor.jpg", "Planta de climas templados, tolerante a las bajas temperaturas. La cabeza de la coliflor resiste las heladas según el grado de protección que les den las hojas externas.<br><br> Se adapta a cualquier tipo de suelos, aunque prospera mejor en suelos arenosos que retienen bien la humedad. El pH favorable está entre 6.0 y 6.8. "));
        this.listaHortalizas.add(new Hortaliza("Espinaca", new String[]{"5", "6", "7", "8", "10", "12"}, "/img/espinaca.jpg", "Es una hortaliza de climas templados, resistente a las bajas temperaturas. No soporta los calores altos. <br><br>Aunque se puede sembrar casi en cualquier tipo de suelos, prospera mejor en terrenos francos. El pH favorable para la espinaca está entre 6.0 y 7.0."));
        this.listaHortalizas.add(new Hortaliza("Haba", new String[]{"4", "6", "8", "10", "12", "15"}, "/img/haba.jpg", "Es una hortaliza de climas templados. Las heladas afectan principalmente las flores y sus frutos. Es una planta sensible a las sequías.<br><br> El cultivo de las habas se desarrolla bien en suelos franco arenosos y franco arcillosos. El pH favorable está entre 5.0 y 8.0."));
        this.listaHortalizas.add(new Hortaliza("Lechuga", new String[]{"6", "8", "10", "13", "16", "20"}, "/img/lechuga.jpg", "La lechuga es una hortaliza que prospera en climas templados y tolera las bajas temperaturas. Los calores excesivos pueden producir un sabor desagradable en la hoja. <br><br>Se adapta a una gran variedad de suelos. Prospera mejor en los francos que no retengan mucha humedad. El pH favorable está entre 6.0 y 7.0. "));
        this.listaHortalizas.add(new Hortaliza("Papa", new String[]{"10", "15", "20", "25", "30", "40"}, "/img/papa.jpg", "Es un cultivo de climas templados - frios. Tolerante de las bajas temperaturas. Sensible a heladas en la estación de primavera. Es una planta exigente al agua.<br><br> La papa produce muy bien en suelos  francos y arenosos con buen contenido de materia orgánica y el riego debe ser bien manejado. El pH necesario está entre 5.0 y 6.8."));
        this.listaHortalizas.add(new Hortaliza("Pepino", new String[]{"8", "10", "13", "17", "20", "25"}, "/img/pepino.jpg", "El pepino es una planta de climas cálidos. Adaptada a las temperaturas altas. Se adapta a cualquier tipo de suelo.<br><br> Los mejores rendimientos se obtienen  en suelos franco  arenosos, con contenido de materia orgánica y buen manejo de riego. El pH favorable para el pepino está entre 5.5 y 6.8."));
        this.listaHortalizas.add(new Hortaliza("Pimenton", new String[]{"5", "6", "7", "8", "10", "12"}, "/img/pimenton.jpg", "El pimentón también es llamado chile dulce, es cultivo de clima caliente, adaptado a las altas temperaturas.<br><br> Esta hortaliza requiere de suelos de textura franco limosos o arenosos, también se tiene buenos rendimientos en suelos arcillosos. El pH favorable está entre 5.5 y 7.0. "));
        this.listaHortalizas.add(new Hortaliza("Rabano", new String[]{"8", "10", "13", "16", "20", "25"}, "/img/rabano.jpg", "Se desarrolla en climas fríos. Es una hortaliza muy tolerante a las bajas temperaturas. En periodos calurosos, los rábanos adquieren un sabor picante excesivo. <br><br>Aunque prosperan en cualquier tipo de suelos, los rendimientos más altos se obtienen en los suelos arenosos, bien regados y con materia orgánica. El pH necesario está entre 5.5 y 6.8. "));
        this.listaHortalizas.add(new Hortaliza("Remolacha", new String[]{"15", "20", "25", "30", "40", "50"}, "/img/remolacha.jpg", "La remolacha también es llamada como beterraga o betabel, es una hortaliza tolerante a las temperaturas. Se desarrolla bien en climas más frescos. Las primeras hojas son sensibles al frío. <br><br>Este tipo de cultivo requiere suelos de textura arenosa, en suelos arcillosos se deforman las beterragas. El pH favorable para este tipo de hortaliza se encuentra entre 6.0 y 7.0.  "));
        this.listaHortalizas.add(new Hortaliza("Repollo", new String[]{"15", "20", "25", "30", "40", "50"}, "/img/repollo.jpg", "Es un cultivo que se desarrolla mejor en climas templados y frescos, pero se adapta a una gran variedad de condiciones climáticas. Los repollos son sensibles a la sequía.<br><br> Aunque se siembra en una gran variedad de suelos, prefiere los suelos con buen riego y ricos en materia orgánica. El pH favorable para los repollos está entre 6.0 y 6.8. "));
        this.listaHortalizas.add(new Hortaliza("Tomate", new String[]{"15", "20", "25", "30", "40", "50"}, "/img/tomate.jpg", "Hortaliza de climas calientes, adaptada a las altas temperaturas. Sensible al frío.<br><br> El tomate produce bien en suelos bien regados con texturas arenosas y arcillosas. El pH favorable está entre 5.5 y 6.8. "));
        this.listaHortalizas.add(new Hortaliza("Vainita", new String[]{"2", "2.5", "3", "4", "5", "6"}, "/img/vainita.jpg", "Las vainitas requieren temperaturas entre 16 y 24 °C, se adapta a zonas tropicales y templadas.<br><br> Las vainitas se cultivan en gran variedad de suelo, de preferencia en suelos francos con buen manejo de riego y con contenido de materia orgánica. El pH óptimo está entre 5.4 y 6.0."));
        this.listaHortalizas.add(new Hortaliza("Zanahoria", new String[]{"10", "13", "16", "20", "25", "30"}, "/img/zanahoria.jpg", "La zanahoria es una hortaliza de climas templados. Tolerante a las bajas temperaturas. Las temperaturas altas disminuyen la coloración y el tamaño de las zanahorias.<br><br> Se adapta a una gran variedad de suelos, aunque se desarrolla mejor en suelos arenosos, con buen manejo de riego. En los suelos arcillosos las zanahorias son duras y pequeñas. El pH favorable está entre 5.5 y 6.8. "));
    }

    public ArrayList<Hortaliza> getListaHortalizas() {
        return listaHortalizas;
    }

    public Hortaliza buscarHortalizaNombre(String nombreHortaliza) {
        Hortaliza resp = null;
        int i = 0;
        while (i < this.listaHortalizas.size() && resp == null) {
            String nombreH = this.listaHortalizas.get(i).getNombreHortaliza();
            if (nombreH.equals(nombreHortaliza)) {
                resp = this.listaHortalizas.get(i);
            }
            i++;
        }
        return resp;

    }

    public ArrayList<String> listarNombresHortaliza() {
        ArrayList<String> arrayListNombresHortalizas = new ArrayList<String>();
        for (int i = 0; i < listaHortalizas.size(); i++) {
             arrayListNombresHortalizas.add(listaHortalizas.get(i).getNombreHortaliza());
        }
        return arrayListNombresHortalizas;
    }


    public static void main(String[] args) {
        HortalizaService hortalizaService = new HortalizaService();
        Hortaliza hortalizaPrueba= hortalizaService.buscarHortalizaNombre("Papa");
        System.out.println(hortalizaPrueba.getRutaImgHortaliza());
    }
}
