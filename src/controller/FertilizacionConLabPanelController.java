/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.alee.extended.layout.VerticalFlowLayout;
import com.alee.extended.window.WebPopOver;
import com.alee.laf.label.WebLabel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.text.DefaultFormatter;
import model.Hortaliza;
import view.FertilizacionConLabPanel;

import model.Cultivo;
import model.Textura;

/**
 *
 * @author Erlinda
 */
public class FertilizacionConLabPanelController {

    private FertilizacionConLabPanel fertilizacionConLabPanel;
    private ArrayList<Hortaliza> arrayListHortalizas;
    private int sumaPorcentaje = 100;
    private Cultivo cultivo;
    private Textura textura;
    private ResultadosConLabPanelController resultadosConLabPanelController;
    private JTabbedPane tabbedNavegacion;
    /*PopOvers*/
    final WebPopOver popOverSumTextura = new WebPopOver();
    final WebPopOver popOverArena = new WebPopOver();
    final WebPopOver popOverLimo = new WebPopOver();
    final WebPopOver popOverArcilla = new WebPopOver();
    final WebPopOver popOverNitrogeno = new WebPopOver();
    final WebPopOver popOverFosforo = new WebPopOver();
    final WebPopOver popOverPotasio = new WebPopOver();
    final WebPopOver popOverpH = new WebPopOver();
    final WebPopOver popOverMO = new WebPopOver();

    public FertilizacionConLabPanelController(FertilizacionConLabPanel fertilizacionConLabPanel, ResultadosConLabPanelController resultadosConLabPanelController, JTabbedPane tabbedNavegacion) {
        this.fertilizacionConLabPanel = fertilizacionConLabPanel;
        this.resultadosConLabPanelController = resultadosConLabPanelController;
        this.tabbedNavegacion = tabbedNavegacion;
        cultivo = new Cultivo();
        textura = new Textura();
        llenarListaHortalizas();
        configuracionInicialVistaFertilizacion();
    }

    public void actualizarInformacionCultivo() {
        //cultivo
        String nombreHortaliza = (String) this.fertilizacionConLabPanel.comboBoxHortaliza.getSelectedItem();
        cultivo.setHortaliza(nombreHortaliza);

        Double rendimientoHortaliza = Double.parseDouble(this.fertilizacionConLabPanel.comboBoxRendimiento.getSelectedItem().toString());
        cultivo.setRendimiento(rendimientoHortaliza);

        Integer nitrogenoSuelo = Integer.parseInt(this.fertilizacionConLabPanel.spinnerNitrogeno.getValue().toString());
        cultivo.setNivelNitrogeno(nitrogenoSuelo);

        Integer fosforoSuelo = Integer.parseInt(this.fertilizacionConLabPanel.spinnerFosforo.getValue().toString());
        cultivo.setNivelFosforo(fosforoSuelo);

        Integer potasioSuelo = Integer.parseInt(this.fertilizacionConLabPanel.spinnerPotasio.getValue().toString());
        cultivo.setNivelPotasio(potasioSuelo);

        Double pHSuelo = Double.parseDouble(this.fertilizacionConLabPanel.spinnerpH.getValue().toString());
        cultivo.setNivelpH(pHSuelo);

        Double moSuelo = Double.parseDouble(this.fertilizacionConLabPanel.spinnerMO.getValue().toString());
        cultivo.setNivelMO(moSuelo);
    }

    public void actualizarInformacionTextura() {
        //textura
        Integer porcentajeTexturaArena = this.fertilizacionConLabPanel.sliderArena.getValue();
        textura.setTexturaArena(porcentajeTexturaArena);

        Integer porcentajeTexturaLimo = this.fertilizacionConLabPanel.sliderLimo.getValue();
        textura.setTexturaLimo(porcentajeTexturaLimo);

        Integer porcentajeTexturaArcilla = this.fertilizacionConLabPanel.sliderArcilla.getValue();
        textura.setTexturaArcilla(porcentajeTexturaArcilla);
    }

    public void configuracionInicialVistaFertilizacion() {
        confComboBoxHortaliza();
        confComboBoxRendimiento();
        confLabelImagen();
        confLabelDescripcion();
        confLabelPorcentaje();
        confLabelArena();
        confSliderArena();
        confLabelLimo();
        confSliderLimo();
        confLabelArcilla();
        confSliderArcilla();
        confLabelNitrogeno();
        confSpinnerNitrogeno();
        confLabelFosforo();
        confSpinerFosforo();
        confLabelPotasio();
        confSpinnerPotasio();
        confLabelpH();
        confSpinnerpH();
        confLabelMO();
        confSpinnerMO();
        confButtomGenerarResultados();
        ///popOver
        confPopOverArena();
        confPopOverLimo();
        confPopOverArcilla();
        confPopOverSumatoriaTextura();
        confPopOverNitrogeno();
        confPopOverFosforo();
        confPopOverPotasio();
        confPopOverpH();
        confPopOverMO();
    }

    public void llenarListaHortalizas() {
        this.arrayListHortalizas = new ArrayList<>();
        this.arrayListHortalizas.add(new Hortaliza("Acelga", new String[]{"10", "13", "16", "20", "25", "30"}, "/img/acelga.jpg", "La acelga es hortaliza de climas fríos. Tolera heladas, aunque también responde bien a las temperaturas medias.<br><br> Se desarrolla en cualquier tipo de suelo, aunque se comporta mejor en suelos arcillo arenosos. El pH del suelo favorable para la acelga está entre 6.5 a 7.5."));
        this.arrayListHortalizas.add(new Hortaliza("Apio", new String[]{"6", "8", "10", "13", "16", "20"}, "/img/apio.jpg", "El apio se desarrolla bien en climas templados y frescos. Puede tolerar heladas ligeras, muy sensible al granizo. <br><br>Se desarrolla bien en suelos franco arcillosos con buen contenido de materia orgánica. Se adapta prácticamente a cualquier tipo de suelos controlando bien el riego. El pH favorable está entre 6.0 a 6.8. "));
        this.arrayListHortalizas.add(new Hortaliza("Arveja", new String[]{"2", "2.5", "3", "3.5", "4", "4.5"}, "/img/arveja.jpg", "La arveja también es conocida como chícharo o guisante, es una hortaliza que se desarrolla mejor en climas templados y que en sus primeras etapas de crecimiento, resiste las bajas temperaturas. Las temperaturas elevadas disminuyen la calidad de la arveja. <br><br>Se desarrolla mejor en suelos francos, con contenido de materia orgánica y buen manejo del riego. El pH favorable se encuentra en los rangos de 5.5 a 6.8."));
        this.arrayListHortalizas.add(new Hortaliza("Berenjena", new String[]{"10", "15", "20", "25", "30", "35"}, "/img/berenjena.jpg", "Las berenjenas son plantas de clima caliente tolerante a altas temperaturas. Su crecimiento se detiene cuando las temperaturas son muy bajas.<br><br> Crece bien en suelos francos con buen riego y materia orgánica, para las berenjenas no son convenientes suelos excesivamente húmedos. El pH favorable está entre 5.5 y 6.8."));
        this.arrayListHortalizas.add(new Hortaliza("Brocoli", new String[]{"3", "3.5", "4", "5", "6", "7"}, "/img/brocoli.jpg", "El brócoli es hortaliza de climas fríos, tolerante a las bajas temperaturas.<br><br> Se adapta bien a todo tipo de suelos, aunque prefiere los franco arenosos, con buen contenido de materia orgánica. El pH favorable está entre 6.0 y 7.0."));
        this.arrayListHortalizas.add(new Hortaliza("Cebolla", new String[]{"10", "15", "20", "23", "27", "30"}, "/img/cebolla.jpg", "Es un cultivo de climas templados. Muy tolerante a las bajas temperaturas. En la formación y maduración de las cebollas, requiere temperaturas elevadas.<br><br> La cebolla se desarrolla en terrenos con contenidos de materia orgánica, los suelos recomendados son los de texturas limosas o franco limosa. No se recomienda sembrar en suelos arcillosos. El pH favorable para la cebolla está entre 6.0 y 7.0."));
        this.arrayListHortalizas.add(new Hortaliza("Coliflor", new String[]{"10", "15", "20", "23", "26", "30"}, "/img/coliflor.jpg", "Planta de climas templados, tolerante a las bajas temperaturas. La cabeza de la coliflor resiste las heladas según el grado de protección que les den las hojas externas.<br><br> Se adapta a cualquier tipo de suelos, aunque prospera mejor en suelos arenosos que retienen bien la humedad. El pH favorable está entre 6.0 y 6.8. "));
        this.arrayListHortalizas.add(new Hortaliza("Espinaca", new String[]{"5", "6", "7", "8", "10", "12"}, "/img/espinaca.jpg", "Es una hortaliza de climas templados, resistente a las bajas temperaturas. No soporta los calores altos. <br><br>Aunque se puede sembrar casi en cualquier tipo de suelos, prospera mejor en terrenos francos. El pH favorable para la espinaca está entre 6.0 y 7.0."));
        this.arrayListHortalizas.add(new Hortaliza("Haba", new String[]{"4", "6", "8", "10", "12", "15"}, "/img/haba.jpg", "Es una hortaliza de climas templados. Las heladas afectan principalmente las flores y sus frutos. Es una planta sensible a las sequías.<br><br> El cultivo de las habas se desarrolla bien en suelos franco arenosos y franco arcillosos. El pH favorable está entre 5.0 y 8.0."));
        this.arrayListHortalizas.add(new Hortaliza("Lechuga", new String[]{"6", "8", "10", "13", "16", "20"}, "/img/lechuga.jpg", "La lechuga es una hortaliza que prospera en climas templados y tolera las bajas temperaturas. Los calores excesivos pueden producir un sabor desagradable en la hoja. <br><br>Se adapta a una gran variedad de suelos. Prospera mejor en los francos que no retengan mucha humedad. El pH favorable está entre 6.0 y 7.0. "));
        this.arrayListHortalizas.add(new Hortaliza("Papa", new String[]{"10", "15", "20", "25", "30", "40"}, "/img/papa.jpg", "Es un cultivo de climas templados - frios. Tolerante de las bajas temperaturas. Sensible a heladas en la estación de primavera. Es una planta exigente al agua.<br><br> La papa produce muy bien en suelos  francos y arenosos con buen contenido de materia orgánica y el riego debe ser bien manejado. El pH necesario está entre 5.0 y 6.8."));
        this.arrayListHortalizas.add(new Hortaliza("Pepino", new String[]{"8", "10", "13", "17", "20", "25"}, "/img/pepino.jpg", "El pepino es una planta de climas cálidos. Adaptada a las temperaturas altas. Se adapta a cualquier tipo de suelo.<br><br> Los mejores rendimientos se obtienen  en suelos franco  arenosos, con contenido de materia orgánica y buen manejo de riego. El pH favorable para el pepino está entre 5.5 y 6.8."));
        this.arrayListHortalizas.add(new Hortaliza("Pimenton", new String[]{"5", "6", "7", "8", "10", "12"}, "/img/pimenton.jpg", "El pimentón también es llamado chile dulce, es cultivo de clima caliente, adaptado a las altas temperaturas.<br><br> Esta hortaliza requiere de suelos de textura franco limosos o arenosos, también se tiene buenos rendimientos en suelos arcillosos. El pH favorable está entre 5.5 y 7.0. "));
        this.arrayListHortalizas.add(new Hortaliza("Rabano", new String[]{"8", "10", "13", "16", "20", "25"}, "/img/rabano.jpg", "Se desarrolla en climas fríos. Es una hortaliza muy tolerante a las bajas temperaturas. En periodos calurosos, los rábanos adquieren un sabor picante excesivo. <br><br>Aunque prosperan en cualquier tipo de suelos, los rendimientos más altos se obtienen en los suelos arenosos, bien regados y con materia orgánica. El pH necesario está entre 5.5 y 6.8. "));
        this.arrayListHortalizas.add(new Hortaliza("Remolacha", new String[]{"15", "20", "25", "30", "40", "50"}, "/img/remolacha.jpg", "La remolacha también es llamada como beterraga o betabel, es una hortaliza tolerante a las temperaturas. Se desarrolla bien en climas más frescos. Las primeras hojas son sensibles al frío. <br><br>Este tipo de cultivo requiere suelos de textura arenosa, en suelos arcillosos se deforman las beterragas. El pH favorable para este tipo de hortaliza se encuentra entre 6.0 y 7.0.  "));
        this.arrayListHortalizas.add(new Hortaliza("Repollo", new String[]{"15", "20", "25", "30", "40", "50"}, "/img/repollo.jpg", "Es un cultivo que se desarrolla mejor en climas templados y frescos, pero se adapta a una gran variedad de condiciones climáticas. Los repollos son sensibles a la sequía.<br><br> Aunque se siembra en una gran variedad de suelos, prefiere los suelos con buen riego y ricos en materia orgánica. El pH favorable para los repollos está entre 6.0 y 6.8. "));
        this.arrayListHortalizas.add(new Hortaliza("Tomate", new String[]{"15", "20", "25", "30", "40", "50"}, "/img/tomate.jpg", "Hortaliza de climas calientes, adaptada a las altas temperaturas. Sensible al frío.<br><br> El tomate produce bien en suelos bien regados con texturas arenosas y arcillosas. El pH favorable está entre 5.5 y 6.8. "));
        this.arrayListHortalizas.add(new Hortaliza("Vainita", new String[]{"2", "2.5", "3", "4", "5", "6"}, "/img/vainita.jpg", "Las vainitas requieren temperaturas entre 16 y 24 °C, se adapta a zonas tropicales y templadas.<br><br> Las vainitas se cultivan en gran variedad de suelo, de preferencia en suelos francos con buen manejo de riego y con contenido de materia orgánica. El pH óptimo está entre 5.4 y 6.0."));
        this.arrayListHortalizas.add(new Hortaliza("Zanahoria", new String[]{"10", "13", "16", "20", "25", "30"}, "/img/zanahoria.jpg", "La zanahoria es una hortaliza de climas templados. Tolerante a las bajas temperaturas. Las temperaturas altas disminuyen la coloración y el tamaño de las zanahorias.<br><br> Se adapta a una gran variedad de suelos, aunque se desarrolla mejor en suelos arenosos, con buen manejo de riego. En los suelos arcillosos las zanahorias son duras y pequeñas. El pH favorable está entre 5.5 y 6.8. "));
    }

    public void confComboBoxHortaliza() {
        String[] arregloNombreHortalizas = new String[arrayListHortalizas.size()];
        for (int i = 0; i < arregloNombreHortalizas.length; i++) {
            arregloNombreHortalizas[i] = arrayListHortalizas.get(i).getNombreHortaliza();
        }
        this.fertilizacionConLabPanel.comboBoxHortaliza.setModel(new DefaultComboBoxModel<>(arregloNombreHortalizas));
        this.fertilizacionConLabPanel.comboBoxHortaliza.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent evt) {
                comboBoxHortalizaItemStateChanged(evt);
            }
        });
    }

    public void confComboBoxRendimiento() {
        String nombreHortaliza = (String) fertilizacionConLabPanel.comboBoxHortaliza.getSelectedItem();
        Hortaliza hortalizaSeleccionada = buscarHortalizaPorNombre(nombreHortaliza);
        this.fertilizacionConLabPanel.comboBoxRendimiento.setModel(new DefaultComboBoxModel<>(hortalizaSeleccionada.getRendimientoHortaliza()));
    }

    public void confLabelImagen() {
        String nombreHortaliza = (String) fertilizacionConLabPanel.comboBoxHortaliza.getSelectedItem();
        Hortaliza hortalizaSeleccionada = buscarHortalizaPorNombre(nombreHortaliza);
        this.fertilizacionConLabPanel.labelImagen.setIcon(new ImageIcon(getClass().getResource(hortalizaSeleccionada.getRutaImgHortaliza())));
    }

    public void confLabelDescripcion() {
        String nombreHortaliza = (String) fertilizacionConLabPanel.comboBoxHortaliza.getSelectedItem();
        Hortaliza hortalizaSeleccionada = buscarHortalizaPorNombre(nombreHortaliza);
        this.fertilizacionConLabPanel.labelInformacion.setText("<html><body><P ALIGN=\"justify\">" + hortalizaSeleccionada.getDescripcionHortaliza() + "</html></body>");
    }

    public void confLabelPorcentaje() {
        this.fertilizacionConLabPanel.jLabelPorcentaje.setOpaque(true);
        this.fertilizacionConLabPanel.jLabelPorcentaje.setText("100 %");
        this.fertilizacionConLabPanel.jLabelPorcentaje.setHorizontalAlignment(fertilizacionConLabPanel.jLabelPorcentaje.CENTER);
        this.fertilizacionConLabPanel.jLabelPorcentaje.setBackground(Color.green);
        fertilizacionConLabPanel.jLabelPorcentaje.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jlabelPorcentajeMouseEntered(evt);
            }
        });
    }

    public void confLabelArena() {
        fertilizacionConLabPanel.jLabelArena.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jlabelArenaMouseEntered(evt);
            }
        });
    }

    public void confSliderArena() {
        JSlider sliderArena = this.fertilizacionConLabPanel.sliderArena;
        sliderArena.setOpaque(false);
        sliderArena.setMinimum(0);
        sliderArena.setMaximum(100);
        sliderArena.setMajorTickSpacing(5);
        sliderArena.setMinorTickSpacing(1);
        sliderArena.setPaintLabels(true);
        sliderArena.setPaintTicks(true);
        sliderArena.setValue(50);

        sliderArena.addChangeListener(new javax.swing.event.ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent evt) {
                jSliderArenaChanged(evt);
            }
        });
    }

    public void confLabelLimo() {
        fertilizacionConLabPanel.jLabelLimo.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jlabelLimoMouseEntered(evt);
            }
        });
    }

    public void confSliderLimo() {
        JSlider sliderLimo = this.fertilizacionConLabPanel.sliderLimo;
        sliderLimo.setOpaque(false);
        sliderLimo.setMinimum(0);
        sliderLimo.setMaximum(100);
        sliderLimo.setMajorTickSpacing(5);
        sliderLimo.setMinorTickSpacing(1);
        sliderLimo.setPaintLabels(true);
        sliderLimo.setPaintTicks(true);
        sliderLimo.setValue(30);

        sliderLimo.addChangeListener(new javax.swing.event.ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent evt) {
                jSliderLimoChanged(evt);
            }
        });
    }

    public void confLabelArcilla() {
        fertilizacionConLabPanel.jLabelArcilla.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jlabelArcillaMouseEntered(evt);
            }
        });
    }

    public void confSliderArcilla() {
        JSlider sliderArcilla = this.fertilizacionConLabPanel.sliderArcilla;
        sliderArcilla.setOpaque(false);
        sliderArcilla.setMinimum(0);
        sliderArcilla.setMaximum(100);
        sliderArcilla.setMajorTickSpacing(5);
        sliderArcilla.setMinorTickSpacing(1);
        sliderArcilla.setPaintLabels(true);
        sliderArcilla.setPaintTicks(true);
        sliderArcilla.setValue(20);

        sliderArcilla.addChangeListener(new javax.swing.event.ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent evt) {
                jSliderArcillaChanged(evt);
            }
        });
    }

    public void confLabelNitrogeno() {
        fertilizacionConLabPanel.jLabelNitrogeno.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jlabelNitrogenoMouseEntered(evt);
            }
        });
    }

    public void confSpinnerNitrogeno() {
        JSpinner spinnerNitrogeno = this.fertilizacionConLabPanel.spinnerNitrogeno;
        SpinnerNumberModel modelNitrogeno = new SpinnerNumberModel(10, 1, 100, 1);
        modelNitrogeno.setMinimum(0);
        modelNitrogeno.setMaximum(100);
        modelNitrogeno.setValue(5);
        modelNitrogeno.setStepSize(((int) 1));
        spinnerNitrogeno.setModel(modelNitrogeno);
        JSpinner.NumberEditor editorNitrogeno = (JSpinner.NumberEditor) spinnerNitrogeno.getEditor();
        DefaultFormatter formatter = (DefaultFormatter) editorNitrogeno.getTextField().getFormatter();
        formatter.setAllowsInvalid(false);
        editorNitrogeno.getTextField().setHorizontalAlignment(SwingConstants.CENTER);
    }

    public void confLabelFosforo() {
        fertilizacionConLabPanel.jLabelfosforo.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jlabelFosforoMouseEntered(evt);
            }
        });
    }

    public void confSpinerFosforo() {
        JSpinner spinnerFosforo = this.fertilizacionConLabPanel.spinnerFosforo;
        SpinnerNumberModel modelFosforo = new SpinnerNumberModel();
        modelFosforo.setMinimum(0);
        modelFosforo.setMaximum(100);
        modelFosforo.setValue(5);
        modelFosforo.setStepSize(((int) 1));
        spinnerFosforo.setModel(modelFosforo);
        JSpinner.NumberEditor editorFosforo = (JSpinner.NumberEditor) spinnerFosforo.getEditor();
        DefaultFormatter formatter = (DefaultFormatter) editorFosforo.getTextField().getFormatter();
        formatter.setAllowsInvalid(false);
        editorFosforo.getTextField().setHorizontalAlignment(SwingConstants.CENTER);
    }

    public void confLabelPotasio() {
        fertilizacionConLabPanel.jLabelPotasio.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jlabelPotasioMouseEntered(evt);
            }
        });
    }

    public void confSpinnerPotasio() {
        JSpinner spinnerPotasio = this.fertilizacionConLabPanel.spinnerPotasio;
        SpinnerNumberModel modelPotasio = new SpinnerNumberModel();
        modelPotasio.setMinimum(0);
        modelPotasio.setMaximum(250);
        modelPotasio.setValue(10);
        modelPotasio.setStepSize(((int) 1));
        spinnerPotasio.setModel(modelPotasio);
        JSpinner.NumberEditor editorPotasio = (JSpinner.NumberEditor) spinnerPotasio.getEditor();
        DefaultFormatter formatter = (DefaultFormatter) editorPotasio.getTextField().getFormatter();
        formatter.setAllowsInvalid(false);
        editorPotasio.getTextField().setHorizontalAlignment(SwingConstants.CENTER);
    }

    public void confLabelpH() {
        fertilizacionConLabPanel.jLabelPH.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jlabelpHMouseEntered(evt);
            }
        });
    }

    public void confSpinnerpH() {
        JSpinner spinnerpH = this.fertilizacionConLabPanel.spinnerpH;
        SpinnerNumberModel modelpH = new SpinnerNumberModel();
        modelpH.setMinimum(3.00);
        modelpH.setMaximum(10.00);
        modelpH.setValue(5.00);
        modelpH.setStepSize(((double) 0.01));
        spinnerpH.setModel(modelpH);
        JSpinner.NumberEditor editorpH = (JSpinner.NumberEditor) spinnerpH.getEditor();
        DecimalFormat formatpH = editorpH.getFormat();
        formatpH.setMinimumFractionDigits(2);
        DefaultFormatter formatter = (DefaultFormatter) editorpH.getTextField().getFormatter();
        formatter.setAllowsInvalid(false);
        editorpH.getTextField().setHorizontalAlignment(SwingConstants.CENTER);
    }

    public void confLabelMO() {
        fertilizacionConLabPanel.jLabelMO.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jlabelMOMouseEntered(evt);
            }
        });
    }

    public void confSpinnerMO() {
        JSpinner spinnerMO = this.fertilizacionConLabPanel.spinnerMO;
        SpinnerNumberModel modelMO = new SpinnerNumberModel();
        modelMO.setMinimum(0.00);
        modelMO.setMaximum(10.00);
        modelMO.setValue(5.00);
        modelMO.setStepSize(((double) 0.01));
        spinnerMO.setModel(modelMO);
        JSpinner.NumberEditor editorMO = (JSpinner.NumberEditor) spinnerMO.getEditor();
        DecimalFormat format = editorMO.getFormat();
        format.setMinimumFractionDigits(2);
        DefaultFormatter formatter = (DefaultFormatter) editorMO.getTextField().getFormatter();
        formatter.setAllowsInvalid(false);
        editorMO.getTextField().setHorizontalAlignment(SwingConstants.CENTER);
    }

    public void confButtomGenerarResultados() {
        this.fertilizacionConLabPanel.buttonGenerarResultados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                buttonGenerarResultaodsActionPerformed(evt);
            }
        });
    }

    private Hortaliza buscarHortalizaPorNombre(String nombreHortaliza) {
        Hortaliza resp = null;
        int i = 0;
        while (i < this.arrayListHortalizas.size() && resp == null) {
            String nombreH = this.arrayListHortalizas.get(i).getNombreHortaliza();
            if (nombreH.equals(nombreHortaliza)) {
                resp = this.arrayListHortalizas.get(i);
            }
            i++;
        }
        return resp;
    }

    private void sumarSlider() {

        sumaPorcentaje = this.fertilizacionConLabPanel.sliderArena.getValue() + this.fertilizacionConLabPanel.sliderLimo.getValue() + this.fertilizacionConLabPanel.sliderArcilla.getValue();
        this.fertilizacionConLabPanel.jLabelPorcentaje.setText(sumaPorcentaje + "%");
        if (sumaPorcentaje > 100) {
            this.fertilizacionConLabPanel.jLabelPorcentaje.setBackground(Color.RED);
        } else {
            if (sumaPorcentaje < 100) {
                this.fertilizacionConLabPanel.jLabelPorcentaje.setBackground(Color.yellow);
            } else {
                this.fertilizacionConLabPanel.jLabelPorcentaje.setBackground(Color.green);
            }
        }
    }

    private void buttonGenerarResultaodsActionPerformed(java.awt.event.ActionEvent evt) {
        if (sumaPorcentaje == 100) {
            actualizarInformacionCultivo();
            actualizarInformacionTextura();
            resultadosConLabPanelController.llenarPanelInformacion(cultivo, textura);
            tabbedNavegacion.setSelectedIndex(1);
        } else {
            JOptionPane.showMessageDialog(null, "La sumatoria de las texturas debe ser 100 % \n Por favor intente nuevamente", "Error de texturas", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void comboBoxHortalizaItemStateChanged(ItemEvent evt) {
        String nombreHortalizaSelectionado = (String) fertilizacionConLabPanel.comboBoxHortaliza.getSelectedItem();
        Hortaliza hortalizaSelecionada = buscarHortalizaPorNombre(nombreHortalizaSelectionado);
        this.fertilizacionConLabPanel.labelInformacion.setText("<html><body><P ALIGN=\"justify\">" + hortalizaSelecionada.getDescripcionHortaliza() + "</html></body>");
        this.fertilizacionConLabPanel.labelImagen.setIcon(new ImageIcon(getClass().getResource(hortalizaSelecionada.getRutaImgHortaliza())));
        this.fertilizacionConLabPanel.comboBoxRendimiento.setModel(new DefaultComboBoxModel<>(hortalizaSelecionada.getRendimientoHortaliza()));
    }

    private void jSliderArenaChanged(javax.swing.event.ChangeEvent evt) {
        sumarSlider();

    }

    private void jSliderLimoChanged(javax.swing.event.ChangeEvent evt) {
        sumarSlider();
    }

    private void jSliderArcillaChanged(javax.swing.event.ChangeEvent evt) {
        sumarSlider();
    }

    public void jlabelPorcentajeMouseEntered(MouseEvent evt) {
        popOverSumTextura.show(fertilizacionConLabPanel.jLabelPorcentaje, 50, fertilizacionConLabPanel.jLabelPorcentaje.getHeight());
    }

    public void jlabelArenaMouseEntered(MouseEvent evt) {
        popOverArena.show(fertilizacionConLabPanel.jLabelArena, 50, fertilizacionConLabPanel.jLabelArena.getHeight());
    }

    public void jlabelLimoMouseEntered(MouseEvent evt) {
        popOverLimo.show(fertilizacionConLabPanel.jLabelLimo, 50, fertilizacionConLabPanel.jLabelLimo.getHeight());
    }

    public void jlabelArcillaMouseEntered(MouseEvent evt) {
        popOverArcilla.show(fertilizacionConLabPanel.jLabelArcilla, 50, fertilizacionConLabPanel.jLabelArcilla.getHeight());
    }

    public void jlabelNitrogenoMouseEntered(MouseEvent evt) {
        popOverNitrogeno.show(fertilizacionConLabPanel.jLabelNitrogeno, 50, fertilizacionConLabPanel.jLabelNitrogeno.getHeight());
    }

    public void jlabelFosforoMouseEntered(MouseEvent evt) {
        popOverFosforo.show(fertilizacionConLabPanel.jLabelfosforo, 50, fertilizacionConLabPanel.jLabelfosforo.getHeight());
    }

    public void jlabelPotasioMouseEntered(MouseEvent evt) {
        popOverPotasio.show(fertilizacionConLabPanel.jLabelPotasio, 50, fertilizacionConLabPanel.jLabelPotasio.getHeight());
    }

    public void jlabelpHMouseEntered(MouseEvent evt) {
        popOverpH.show(fertilizacionConLabPanel.jLabelPH, 50, fertilizacionConLabPanel.jLabelPH.getHeight());
    }

    public void jlabelMOMouseEntered(MouseEvent evt) {
        popOverMO.show(fertilizacionConLabPanel.jLabelMO, 50, fertilizacionConLabPanel.jLabelMO.getHeight());
    }

    /*metodos popover*/
    public void confPopOverSumatoriaTextura() {
        popOverSumTextura.setCloseOnFocusLoss(true);
        popOverSumTextura.setMargin(10);
        popOverSumTextura.setLayout(new VerticalFlowLayout());
        popOverSumTextura.add(new WebLabel("La sumatoria del porcentaje de Textura Arena, Limo y arcilla debe ser igual a 100"));
        popOverSumTextura.add(new WebLabel("El cuadro es Verde si la sumatoria es igual a 100, si es menor cambia a color amarillo"));
        popOverSumTextura.add(new WebLabel("si es mayor a 100 cambia a Rojo"));
    }

    public void confPopOverArena() {
        popOverArena.setCloseOnFocusLoss(true);
        popOverArena.setMargin(10);
        popOverArena.setLayout(new VerticalFlowLayout());
        popOverArena.add(new WebLabel("El porcentaje de Arena en el suelo puede ser variable de 0 a 100,"));
        popOverArena.add(new WebLabel("a mayor porcentaje de arena el suelo filtra el agua rapidamente"));
        JLabel jlabelImgArena = new JLabel();
        jlabelImgArena.setIcon(new ImageIcon(getClass().getResource("/img/arenosaTex.png")));
        popOverArena.add(jlabelImgArena);
    }

    public void confPopOverLimo() {
        popOverLimo.setCloseOnFocusLoss(true);
        popOverLimo.setMargin(10);
        popOverLimo.setLayout(new VerticalFlowLayout());
        popOverLimo.add(new WebLabel("El porcentaje de Limo en el suelo puede ser variable de 0 a 100,"));
        popOverLimo.add(new WebLabel("a mayor porcentaje de limo el suelo filtra el agua con normalidad"));
        JLabel jlabelImgArena = new JLabel();
        jlabelImgArena.setIcon(new ImageIcon(getClass().getResource("/img/limosaTex.png")));
        popOverLimo.add(jlabelImgArena);
    }

    public void confPopOverArcilla() {
        popOverArcilla.setCloseOnFocusLoss(true);
        popOverArcilla.setMargin(10);
        popOverArcilla.setLayout(new VerticalFlowLayout());
        popOverArcilla.add(new WebLabel("El contenido de Arcilla en el suelo puede ser variable de 0 a 100,"));
        popOverArcilla.add(new WebLabel("a mayor porcentaje de arcilla el suelo  no filtra casi el agua"));
        JLabel jlabelImgArena = new JLabel();
        jlabelImgArena.setIcon(new ImageIcon(getClass().getResource("/img/arcillosaTex.png")));
        popOverArcilla.add(jlabelImgArena);
    }

    public void confPopOverNitrogeno() {
        popOverNitrogeno.setCloseOnFocusLoss(true);
        popOverNitrogeno.setMargin(10);
        popOverNitrogeno.setLayout(new VerticalFlowLayout());
        popOverNitrogeno.add(new WebLabel("Los valores de Nitrogeno"));
        popOverNitrogeno.add(new WebLabel("en un suelo agricola varia"));
        popOverNitrogeno.add(new WebLabel(" entre 0 y 100"));
    }

    public void confPopOverFosforo() {
        popOverFosforo.setCloseOnFocusLoss(true);
        popOverFosforo.setMargin(10);
        popOverFosforo.setLayout(new VerticalFlowLayout());
        popOverFosforo.add(new WebLabel("Los valores de Fosforo"));
        popOverFosforo.add(new WebLabel("en un suelo agricola varia"));
        popOverFosforo.add(new WebLabel(" entre 0 y 100"));
    }

    public void confPopOverPotasio() {
        popOverPotasio.setCloseOnFocusLoss(true);
        popOverPotasio.setMargin(10);
        popOverPotasio.setLayout(new VerticalFlowLayout());
        popOverPotasio.add(new WebLabel("Los valores de Potasio"));
        popOverPotasio.add(new WebLabel("en un suelo agricola varia"));
        popOverPotasio.add(new WebLabel(" entre 0 y 250"));
    }

    public void confPopOverpH() {
        popOverpH.setCloseOnFocusLoss(true);
        popOverpH.setMargin(10);
        popOverpH.setLayout(new VerticalFlowLayout());
        popOverpH.add(new WebLabel("Los valores de pH"));
        popOverpH.add(new WebLabel("en un suelo agricola varia"));
        popOverpH.add(new WebLabel(" entre 3.00 y 10.00"));
    }

    public void confPopOverMO() {
        popOverMO.setCloseOnFocusLoss(true);
        popOverMO.setMargin(10);
        popOverMO.setLayout(new VerticalFlowLayout());
        popOverMO.add(new WebLabel("Los valores de Materia Organica"));
        popOverMO.add(new WebLabel("en un suelo agricola varia"));
        popOverMO.add(new WebLabel(" entre 1.00 y 10.00"));
    }
    /*fin popOver*/
}
