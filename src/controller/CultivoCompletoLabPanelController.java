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
import view.CultivoCompletoLabPanel;

import model.Cultivo;
import model.Textura;
import service.HortalizaService;

/**
 *
 * @author Erlinda
 */
public class CultivoCompletoLabPanelController {

    private CultivoCompletoLabPanel fertilizacionConLabPanel;
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

    public CultivoCompletoLabPanelController(CultivoCompletoLabPanel fertilizacionConLabPanel, ResultadosConLabPanelController resultadosConLabPanelController, JTabbedPane tabbedNavegacion) {
        this.fertilizacionConLabPanel = fertilizacionConLabPanel;
        this.resultadosConLabPanelController = resultadosConLabPanelController;
        this.tabbedNavegacion = tabbedNavegacion;
        cultivo = new Cultivo();
        textura = new Textura();
        arrayListHortalizas=hortalizaService.getListaHortalizas();
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
        Hortaliza hortalizaSeleccionada = hortalizaService.buscarHortalizaNombre(nombreHortaliza);
        this.fertilizacionConLabPanel.comboBoxRendimiento.setModel(new DefaultComboBoxModel<>(hortalizaSeleccionada.getRendimientoHortaliza()));
    }

    public void confLabelImagen() {
        String nombreHortaliza = (String) fertilizacionConLabPanel.comboBoxHortaliza.getSelectedItem();
        Hortaliza hortalizaSeleccionada = hortalizaService.buscarHortalizaNombre(nombreHortaliza);
        this.fertilizacionConLabPanel.labelImagen.setIcon(new ImageIcon(getClass().getResource(hortalizaSeleccionada.getRutaImgHortaliza())));
    }

    public void confLabelDescripcion() {
        String nombreHortaliza = (String) fertilizacionConLabPanel.comboBoxHortaliza.getSelectedItem();
        Hortaliza hortalizaSeleccionada = hortalizaService.buscarHortalizaNombre(nombreHortaliza);
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
        Hortaliza hortalizaSelecionada = hortalizaService.buscarHortalizaNombre(nombreHortalizaSelectionado);
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
