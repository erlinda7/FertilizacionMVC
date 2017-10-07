/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.PotasioRegla;

/**
 *
 * @author Erlinda
 */
public class PotasioReglaService {

    ArrayList<PotasioRegla> listPotasioRegla;
    private final String tabla = "potasio_regla";

    public PotasioReglaService() {

        listPotasioRegla = recuperarListaPotasioRegla();

    }

    public void createPotasioRegla(PotasioRegla newPotasioRegla) {
        try {
            listPotasioRegla.add(newPotasioRegla);
            PreparedStatement consulta;
            Connection conexion = Conexion.obtener();
            consulta = conexion.prepareStatement("INSERT INTO " + this.tabla + "(nombre_regla, limite_inferior, limite_superior, conclusion) VALUES(?, ?, ?, ?)");
            consulta.setString(1, newPotasioRegla.getNombreRegla());
            consulta.setInt(2, newPotasioRegla.getLimiteInferior());
            consulta.setInt(3, newPotasioRegla.getLimiteSuperior());
            consulta.setString(4, newPotasioRegla.getConclusion());

            consulta.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PotasioReglaService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public PotasioRegla readPotasioRegla(int idPotasioRegla) {
        PotasioRegla potasioReglaRecuperado = null;
        for (int i = 0; i < listPotasioRegla.size(); i++) {
            if (idPotasioRegla == listPotasioRegla.get(i).getIdPotasioRegla()) {
                potasioReglaRecuperado = listPotasioRegla.get(i);
            }
        }
        return potasioReglaRecuperado;

    }

    public void updatePotasioRegla(int idPotasioRegla, PotasioRegla newPotasioRegla) {
        try {
            PotasioRegla potasioReglaParaActualizar = readPotasioRegla(idPotasioRegla);
            potasioReglaParaActualizar.setNombreRegla(newPotasioRegla.getNombreRegla());
            potasioReglaParaActualizar.setLimiteInferior(newPotasioRegla.getLimiteInferior());
            potasioReglaParaActualizar.setLimiteSuperior(newPotasioRegla.getLimiteSuperior());
            potasioReglaParaActualizar.setConclusion(newPotasioRegla.getConclusion());

            PreparedStatement consultaupdate;
            Connection conexion = Conexion.obtener();
            consultaupdate = conexion.prepareStatement("UPDATE " + this.tabla + " SET nombre_regla = ?, limite_inferior = ?, limite_superior = ?, conclusion = ? WHERE id_regla_potasio = ?");
            consultaupdate.setString(1, newPotasioRegla.getNombreRegla());
            consultaupdate.setInt(2, newPotasioRegla.getLimiteInferior());
            consultaupdate.setInt(3, newPotasioRegla.getLimiteSuperior());
            consultaupdate.setString(4, newPotasioRegla.getConclusion());
            consultaupdate.setInt(5, idPotasioRegla);

            consultaupdate.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(PotasioReglaService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deletePotasioRegla(int idPotasioRegla) {
        try {
            PotasioRegla potasioReglaEliminar = readPotasioRegla(idPotasioRegla);
            listPotasioRegla.remove(potasioReglaEliminar);

            PreparedStatement consulta;
            Connection conexion = Conexion.obtener();
            consulta = conexion.prepareStatement("DELETE FROM " + this.tabla + " WHERE id_regla_potasio = " + idPotasioRegla);
            consulta.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PotasioReglaService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void mostrarReglas() {
        for (int i = 0; i < listPotasioRegla.size(); i++) {
            //System.out.println(listNutrienteRegla.get(i).getNombreRegla());
            System.out.println(listPotasioRegla.get(i).toString());
        }
    }

    public ArrayList<PotasioRegla> readAllPotasio() {
        return listPotasioRegla;

    }

    public void actualizarReglasPotasioDrl() {

        File file = new File("./src/main/resources/rules/NutrientePotasio.drl");
        try {
            FileOutputStream out = new FileOutputStream(file);
            String importPackage = "package rules \nimport model.Cultivo;\n";
            out.write(importPackage.getBytes());
            for (int i = 0; i < listPotasioRegla.size(); i++) {

                String nombreRegla = "rule " + "\"" + listPotasioRegla.get(i).getNombreRegla() + "\"\n";
                out.write(nombreRegla.getBytes());
                String when = "    when\n";
                out.write(when.getBytes());
                String condicion = "        $c : Cultivo( nivelPotasio >= " + listPotasioRegla.get(i).getLimiteInferior() + " && <=" + listPotasioRegla.get(i).getLimiteSuperior() + " )\n";
                out.write(condicion.getBytes());
                String then = "    then\n";
                out.write(then.getBytes());
                String conclusion = "        $c.setRangoNivelPotasio(\"" + listPotasioRegla.get(i).getConclusion() + "\");\n";
                out.write(conclusion.getBytes());
                String end = "end\n\n";
                out.write(end.getBytes());
            }
            out.close();
//			out.write(textoPrueba.getBytes());
//			out.write("hola erlinda".getBytes());
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    public ArrayList<PotasioRegla> recuperarListaPotasioRegla() {
        Connection conexion = Conexion.obtener();
        ArrayList<PotasioRegla> potasioReglaLista = new ArrayList<PotasioRegla>();
        try {
            PreparedStatement consulta = conexion.prepareStatement("SELECT id_regla_potasio, nombre_regla, limite_inferior, limite_superior, conclusion FROM " + this.tabla + " ORDER BY id_regla_potasio");
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                potasioReglaLista.add(new PotasioRegla(resultado.getInt("id_regla_potasio"), resultado.getString("nombre_regla"), resultado.getInt("limite_inferior"), resultado.getInt("limite_superior"), resultado.getString("conclusion")));
            }
            //System.out.println("cantidad reglas: " + potasioReglaLista.size());
        } catch (SQLException ex) {
            Logger.getLogger(PotasioReglaService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return potasioReglaLista;
    }
}
