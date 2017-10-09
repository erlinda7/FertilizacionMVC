
import javax.swing.DefaultComboBoxModel;
import service.HortalizaService;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Erlinda
 */
public class TestJFrameController {

    TestJFrame testJFrame;
    HortalizaService hortalizaService = new HortalizaService();

    public TestJFrameController(TestJFrame testJFrame) {
        this.testJFrame = testJFrame;
        configurarCombobox();

    }

    public void configurarCombobox() {
        //this.testJFrame.jComboBox1;
        String[] arregloNombreHortalizas = new String[hortalizaService.getListaHortalizas().size()];
        for (int i = 0; i < arregloNombreHortalizas.length; i++) {
            arregloNombreHortalizas[i] = hortalizaService.getListaHortalizas().get(i).getNombreHortaliza();
        }
        this.testJFrame.jComboBox1.setModel(new DefaultComboBoxModel<>(arregloNombreHortalizas));
        //testJFrame.jComboBox1.setSelectedItem("Zanahoria");
    }
}
