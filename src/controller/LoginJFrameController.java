/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import EdicionReglas.OpcionesAvanzadasFrame;
import EdicionReglas.OpcionesAvanzadasFrameController;
import EdicionReglas.OpcionesAvanzadasPanel;
import EdicionReglas.OpcionesAvanzadasPanelController;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Erlinda
 */
public class LoginJFrameController {
    
    LoginJFrame loginJFrame;
    String usuarioAdmin = "admin";
    String contrasenaAdmin = "admin";
    
    public LoginJFrameController(LoginJFrame loginJFrame) {
        this.loginJFrame = loginJFrame;
        confButtonLoginAceptar();
        confButtonLoginCancelar();
        loginJFrame.setVisible(true);
        confJFrameLogin();
    }
    
    public void confJFrameLogin() {
        loginJFrame.setTitle("");
        loginJFrame.setLocationRelativeTo(null);
        Image icon = new ImageIcon(getClass().getResource("/img/icon1.png")).getImage();
        loginJFrame.setIconImage(icon);
        // loginJFrame.jPanel1.setForeground(new Color(145,226,182));
    }
    
    public void confButtonLoginAceptar() {
        loginJFrame.jButtonAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                ButtonLoginAceptarActionPerformed(evt);
            }
        });
    }
    
    private void ButtonLoginAceptarActionPerformed(java.awt.event.ActionEvent evt) {
        // System.out.println("hola soy el boton aceptar");
        String usuario = loginJFrame.jTextFieldUsuario.getText();
        String contrasena = loginJFrame.jPasswordFieldContrasena.getText();
        if (usuarioAdmin.equals(usuario) && contrasenaAdmin.equals(contrasena)) {
            System.out.println("Usuario Coreccto");
            OpcionesAvanzadasFrame opcionesAvanzadasFrame = new OpcionesAvanzadasFrame();
            OpcionesAvanzadasFrameController opcionesAvanzadasFrameController = new OpcionesAvanzadasFrameController(opcionesAvanzadasFrame);
            
            OpcionesAvanzadasPanel opcionesAvanzadasPanel = opcionesAvanzadasFrame.opcionesAvanzadasPanel1;
            OpcionesAvanzadasPanelController opcionesAvanzadasPanelController = new OpcionesAvanzadasPanelController(opcionesAvanzadasPanel);
            
            loginJFrame.setVisible(false);
        } else {
            loginJFrame.jTextFieldUsuario.setText("");
            loginJFrame.jPasswordFieldContrasena.setText("");
            JOptionPane.showMessageDialog(null, "Ingrese nuevamente el Nombre Usuario y Contraseña", "Usuario Incorrecto", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public void confButtonLoginCancelar() {
        loginJFrame.jButtonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                ButtonLoginCancelarActionPerformed(evt);
            }
        });
    }
    
    private void ButtonLoginCancelarActionPerformed(java.awt.event.ActionEvent evt) {
        loginJFrame.setVisible(false);
    }
}
