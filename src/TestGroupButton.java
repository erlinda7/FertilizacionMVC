import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class TestGroupButton {
  public static void main(String[] args) {
    JFrame frame = new JFrame();

    JPanel entreePanel = new JPanel();
    final ButtonGroup buttonGroup = new ButtonGroup();
    JRadioButton radioButton;
    String opcionA = "Akjhkjhkj";
    entreePanel.add(radioButton = new JRadioButton(opcionA));
    radioButton.setActionCommand(opcionA);
    buttonGroup.add(radioButton);
    entreePanel.add(radioButton = new JRadioButton("B"));
    radioButton.setActionCommand("B");
    buttonGroup.add(radioButton);
    entreePanel.add(radioButton = new JRadioButton("C", true));
    radioButton.setActionCommand("C");
    buttonGroup.add(radioButton);

    final JPanel condimentsPanel = new JPanel();
    condimentsPanel.add(new JCheckBox("Ketchup"));
    condimentsPanel.add(new JCheckBox("Mustard"));
    condimentsPanel.add(new JCheckBox("Pickles"));

    JPanel orderPanel = new JPanel();
    JButton orderButton = new JButton("Place Order");
    orderPanel.add(orderButton);

    frame.setLayout(new GridLayout(3, 1));
    frame.add(entreePanel);
    frame.add(condimentsPanel);
    frame.add(orderPanel);

    orderButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        String entree = buttonGroup.getSelection().getActionCommand();
        System.out.println(entree + " sandwich");
        Component[] components = condimentsPanel.getComponents();
        for (Component c : components) {
          JCheckBox cb = (JCheckBox) c;
          if (cb.isSelected())
            System.out.println("With " + cb.getText());
        }
      }
    });

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 150);
    frame.setVisible(true);
  }
}