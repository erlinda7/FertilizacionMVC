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
import model.Cultivo;
import model.Textura;
import service.HortalizaService;
import view.CultivoConfiguradoLabPanel;

/**
 *
 * @author Erlinda
 */
public class CultivoConfiguradoLabPanelController {

    private CultivoConfiguradoLabPanel cultivoConfiguradoLabPanel;
    private ArrayList<Hortaliza> arrayListHortalizas;
    private HortalizaService hortalizaService=new HortalizaService();
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

    public CultivoConfiguradoLabPanelController(CultivoConfiguradoLabPanel cultivoConfiguradoLabPanel) {
        this.cultivoConfiguradoLabPanel = cultivoConfiguradoLabPanel;
        cultivo = new Cultivo();
        textura = new Textura();
        arrayListHortalizas=hortalizaService.getListaHortalizas();
        configuracionInicialVistaFertilizacion();
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
//    public void actualizarInformacionCultivo() {
//        //cultivo
//        String nombreHortaliza = (String) this.cultivoConfiguradoLabPanel.comboBoxHortaliza.getSelectedItem();
//        cultivo.setHortaliza(nombreHortaliza);
//
//        Double rendimientoHortaliza = Double.parseDouble(this.cultivoConfiguradoLabPanel.comboBoxRendimiento.getSelectedItem().toString());
//        cultivo.setRendimiento(rendimientoHortaliza);
//
//        Integer nitrogenoSuelo = Integer.parseInt(this.cultivoConfiguradoLabPanel.spinnerNitrogeno.getValue().toString());
//        cultivo.setNivelNitrogeno(nitrogenoSuelo);
//
//        Integer fosforoSuelo = Integer.parseInt(this.cultivoConfiguradoLabPanel.spinnerFosforo.getValue().toString());
//        cultivo.setNivelFosforo(fosforoSuelo);
//
//        Integer potasioSuelo = Integer.parseInt(this.cultivoConfiguradoLabPanel.spinnerPotasio.getValue().toString());
//        cultivo.setNivelPotasio(potasioSuelo);
//
//        Double pHSuelo = Double.parseDouble(this.cultivoConfiguradoLabPanel.spinnerpH.getValue().toString());
//        cultivo.setNivelpH(pHSuelo);
//
//        Double moSuelo = Double.parseDouble(this.cultivoConfiguradoLabPanel.spinnerMO.getValue().toString());
//        cultivo.setNivelMO(moSuelo);
//    }

//    public void actualizarInformacionTextura() {
//        //textura
//        Integer porcentajeTexturaArena = this.cultivoConfiguradoLabPanel.sliderArena.getValue();
//        textura.setTexturaArena(porcentajeTexturaArena);
//
//        Integer porcentajeTexturaLimo = this.cultivoConfiguradoLabPanel.sliderLimo.getValue();
//        textura.setTexturaLimo(porcentajeTexturaLimo);
//
//        Integer porcentajeTexturaArcilla = this.cultivoConfiguradoLabPanel.sliderArcilla.getValue();
//        textura.setTexturaArcilla(porcentajeTexturaArcilla);
//    }
   
    public void confComboBoxHortaliza() {
        String[] arregloNombreHortalizas = new String[arrayListHortalizas.size()];
        for (int i = 0; i < arregloNombreHortalizas.length; i++) {
            arregloNombreHortalizas[i] = arrayListHortalizas.get(i).getNombreHortaliza();
        }
        this.cultivoConfiguradoLabPanel.comboBoxHortaliza.setModel(new DefaultComboBoxModel<>(arregloNombreHortalizas));
        this.cultivoConfiguradoLabPanel.comboBoxHortaliza.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent evt) {
                comboBoxHortalizaItemStateChanged(evt);
            }
        });
        cultivoConfiguradoLabPanel.comboBoxHortaliza.setEnabled(false);
    }

    public void confComboBoxRendimiento() {
        String nombreHortaliza = (String) cultivoConfiguradoLabPanel.comboBoxHortaliza.getSelectedItem();
        Hortaliza hortalizaSeleccionada = hortalizaService.buscarHortalizaNombre(nombreHortaliza);
        this.cultivoConfiguradoLabPanel.comboBoxRendimiento.setModel(new DefaultComboBoxModel<>(hortalizaSeleccionada.getRendimientoHortaliza()));
        cultivoConfiguradoLabPanel.comboBoxRendimiento.setEnabled(false);
    }

    public void confLabelImagen() {
        String nombreHortaliza = (String) cultivoConfiguradoLabPanel.comboBoxHortaliza.getSelectedItem();
        Hortaliza hortalizaSeleccionada = hortalizaService.buscarHortalizaNombre(nombreHortaliza);
        this.cultivoConfiguradoLabPanel.labelImagen.setIcon(new ImageIcon(getClass().getResource(hortalizaSeleccionada.getRutaImgHortaliza())));
    }

    public void confLabelDescripcion() {
        String nombreHortaliza = (String) cultivoConfiguradoLabPanel.comboBoxHortaliza.getSelectedItem();
        Hortaliza hortalizaSeleccionada = hortalizaService.buscarHortalizaNombre(nombreHortaliza);
        this.cultivoConfiguradoLabPanel.labelInformacion.setText("<html><body><P ALIGN=\"justify\">" + hortalizaSeleccionada.getDescripcionHortaliza() + "</html></body>");
    }

    public void confLabelPorcentaje() {
        this.cultivoConfiguradoLabPanel.jLabelPorcentaje.setOpaque(true);
        this.cultivoConfiguradoLabPanel.jLabelPorcentaje.setText("100 %");
        this.cultivoConfiguradoLabPanel.jLabelPorcentaje.setHorizontalAlignment(cultivoConfiguradoLabPanel.jLabelPorcentaje.CENTER);
        this.cultivoConfiguradoLabPanel.jLabelPorcentaje.setBackground(Color.green);
        cultivoConfiguradoLabPanel.jLabelPorcentaje.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jlabelPorcentajeMouseEntered(evt);
            }
        });
    }

    public void confLabelArena() {
        cultivoConfiguradoLabPanel.jLabelArena.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jlabelArenaMouseEntered(evt);
            }
        });
    }

    public void confSliderArena() {
        JSlider sliderArena = this.cultivoConfiguradoLabPanel.sliderArena;
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
        sliderArena.setEnabled(false);
    }

    public void confLabelLimo() {
        cultivoConfiguradoLabPanel.jLabelLimo.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jlabelLimoMouseEntered(evt);
            }
        });
    }

    public void confSliderLimo() {
        JSlider sliderLimo = this.cultivoConfiguradoLabPanel.sliderLimo;
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
        sliderLimo.setEnabled(false);
    }

    public void confLabelArcilla() {
        cultivoConfiguradoLabPanel.jLabelArcilla.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jlabelArcillaMouseEntered(evt);
            }
        });
    }

    public void confSliderArcilla() {
        JSlider sliderArcilla = this.cultivoConfiguradoLabPanel.sliderArcilla;
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
        sliderArcilla.setEnabled(false);
    }

    public void confLabelNitrogeno() {
        cultivoConfiguradoLabPanel.jLabelNitrogeno.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jlabelNitrogenoMouseEntered(evt);
            }
        });
    }

    public void confSpinnerNitrogeno() {
        JSpinner spinnerNitrogeno = this.cultivoConfiguradoLabPanel.spinnerNitrogeno;
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
        spinnerNitrogeno.setEnabled(false);
    }

    public void confLabelFosforo() {
        cultivoConfiguradoLabPanel.jLabelfosforo.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jlabelFosforoMouseEntered(evt);
            }
        });
    }

    public void confSpinerFosforo() {
        JSpinner spinnerFosforo = this.cultivoConfiguradoLabPanel.spinnerFosforo;
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
        spinnerFosforo.setEnabled(false);
    }

    public void confLabelPotasio() {
        cultivoConfiguradoLabPanel.jLabelPotasio.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jlabelPotasioMouseEntered(evt);
            }
        });
    }

    public void confSpinnerPotasio() {
        JSpinner spinnerPotasio = this.cultivoConfiguradoLabPanel.spinnerPotasio;
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
        spinnerPotasio.setEnabled(false);
    }

    public void confLabelpH() {
        cultivoConfiguradoLabPanel.jLabelPH.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jlabelpHMouseEntered(evt);
            }
        });
    }

    public void confSpinnerpH() {
        JSpinner spinnerpH = this.cultivoConfiguradoLabPanel.spinnerpH;
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
        spinnerpH.setEnabled(false);
    }

    public void confLabelMO() {
        cultivoConfiguradoLabPanel.jLabelMO.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                jlabelMOMouseEntered(evt);
            }
        });
    }

    public void confSpinnerMO() {
        JSpinner spinnerMO = this.cultivoConfiguradoLabPanel.spinnerMO;
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
        spinnerMO.setEnabled(false);
    }

    
    private void sumarSlider() {

        sumaPorcentaje = this.cultivoConfiguradoLabPanel.sliderArena.getValue() + this.cultivoConfiguradoLabPanel.sliderLimo.getValue() + this.cultivoConfiguradoLabPanel.sliderArcilla.getValue();
        this.cultivoConfiguradoLabPanel.jLabelPorcentaje.setText(sumaPorcentaje + "%");
        if (sumaPorcentaje > 100) {
            this.cultivoConfiguradoLabPanel.jLabelPorcentaje.setBackground(Color.RED);
        } else {
            if (sumaPorcentaje < 100) {
                this.cultivoConfiguradoLabPanel.jLabelPorcentaje.setBackground(Color.yellow);
            } else {
                this.cultivoConfiguradoLabPanel.jLabelPorcentaje.setBackground(Color.green);
            }
        }
    }



    public void comboBoxHortalizaItemStateChanged(ItemEvent evt) {
        String nombreHortalizaSelectionado = (String) cultivoConfiguradoLabPanel.comboBoxHortaliza.getSelectedItem();
        Hortaliza hortalizaSelecionada = hortalizaService.buscarHortalizaNombre(nombreHortalizaSelectionado);
        this.cultivoConfiguradoLabPanel.labelInformacion.setText("<html><body><P ALIGN=\"justify\">" + hortalizaSelecionada.getDescripcionHortaliza() + "</html></body>");
        this.cultivoConfiguradoLabPanel.labelImagen.setIcon(new ImageIcon(getClass().getResource(hortalizaSelecionada.getRutaImgHortaliza())));
        this.cultivoConfiguradoLabPanel.comboBoxRendimiento.setModel(new DefaultComboBoxModel<>(hortalizaSelecionada.getRendimientoHortaliza()));
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
        popOverSumTextura.show(cultivoConfiguradoLabPanel.jLabelPorcentaje, 50, cultivoConfiguradoLabPanel.jLabelPorcentaje.getHeight());
    }

    public void jlabelArenaMouseEntered(MouseEvent evt) {
        popOverArena.show(cultivoConfiguradoLabPanel.jLabelArena, 50, cultivoConfiguradoLabPanel.jLabelArena.getHeight());
    }

    public void jlabelLimoMouseEntered(MouseEvent evt) {
        popOverLimo.show(cultivoConfiguradoLabPanel.jLabelLimo, 50, cultivoConfiguradoLabPanel.jLabelLimo.getHeight());
    }

    public void jlabelArcillaMouseEntered(MouseEvent evt) {
        popOverArcilla.show(cultivoConfiguradoLabPanel.jLabelArcilla, 50, cultivoConfiguradoLabPanel.jLabelArcilla.getHeight());
    }

    public void jlabelNitrogenoMouseEntered(MouseEvent evt) {
        popOverNitrogeno.show(cultivoConfiguradoLabPanel.jLabelNitrogeno, 50, cultivoConfiguradoLabPanel.jLabelNitrogeno.getHeight());
    }

    public void jlabelFosforoMouseEntered(MouseEvent evt) {
        popOverFosforo.show(cultivoConfiguradoLabPanel.jLabelfosforo, 50, cultivoConfiguradoLabPanel.jLabelfosforo.getHeight());
    }

    public void jlabelPotasioMouseEntered(MouseEvent evt) {
        popOverPotasio.show(cultivoConfiguradoLabPanel.jLabelPotasio, 50, cultivoConfiguradoLabPanel.jLabelPotasio.getHeight());
    }

    public void jlabelpHMouseEntered(MouseEvent evt) {
        popOverpH.show(cultivoConfiguradoLabPanel.jLabelPH, 50, cultivoConfiguradoLabPanel.jLabelPH.getHeight());
    }

    public void jlabelMOMouseEntered(MouseEvent evt) {
        popOverMO.show(cultivoConfiguradoLabPanel.jLabelMO, 50, cultivoConfiguradoLabPanel.jLabelMO.getHeight());
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
