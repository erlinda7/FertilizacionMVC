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
import model.FosforoRegla;

/**
 *
 * @author Erlinda
 */
public class FosforoReglaService {

    ArrayList<FosforoRegla> listFosforoRegla;
    private final String tabla = "fosforo_regla";

    public FosforoReglaService() {

        listFosforoRegla = recuperarListaFosforoRegla();

    }

    public void createFosforoRegla(FosforoRegla newFosforoRegla) {
        try {
            listFosforoRegla.add(newFosforoRegla);
            PreparedStatement consulta;
            Connection conexion = Conexion.obtener();
            consulta = conexion.prepareStatement("INSERT INTO " + this.tabla + "(nombre_regla, limite_inferior, limite_superior, conclusion) VALUES(?, ?, ?, ?)");
            consulta.setString(1, newFosforoRegla.getNombreRegla());
            consulta.setInt(2, newFosforoRegla.getLimiteInferior());
            consulta.setInt(3, newFosforoRegla.getLimiteSuperior());
            consulta.setString(4, newFosforoRegla.getConclusion());

            consulta.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FosforoReglaService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public FosforoRegla readFosforoRegla(int idFosforoRegla) {
        FosforoRegla fosforoReglaRecuperado = null;
        for (int i = 0; i < listFosforoRegla.size(); i++) {
            if (idFosforoRegla == listFosforoRegla.get(i).getIdFosforoRegla()) {
                fosforoReglaRecuperado = listFosforoRegla.get(i);
            }
        }
        return fosforoReglaRecuperado;

    }

    public void updateFosforoRegla(int idFosforoRegla, FosforoRegla newFosforoRegla) {
        try {
            FosforoRegla fosforoReglaParaActualizar = readFosforoRegla(idFosforoRegla);
            fosforoReglaParaActualizar.setNombreRegla(newFosforoRegla.getNombreRegla());
            fosforoReglaParaActualizar.setLimiteInferior(newFosforoRegla.getLimiteInferior());
            fosforoReglaParaActualizar.setLimiteSuperior(newFosforoRegla.getLimiteSuperior());
            fosforoReglaParaActualizar.setConclusion(newFosforoRegla.getConclusion());

            PreparedStatement consultaupdate;
            Connection conexion = Conexion.obtener();
            consultaupdate = conexion.prepareStatement("UPDATE " + this.tabla + " SET nombre_regla = ?, limite_inferior = ?, limite_superior = ?, conclusion = ? WHERE id_regla_fosforo = ?");
            consultaupdate.setString(1, newFosforoRegla.getNombreRegla());
            consultaupdate.setInt(2, newFosforoRegla.getLimiteInferior());
            consultaupdate.setInt(3, newFosforoRegla.getLimiteSuperior());
            consultaupdate.setString(4, newFosforoRegla.getConclusion());
            consultaupdate.setInt(5, idFosforoRegla);

            consultaupdate.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(FosforoReglaService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteFosforoRegla(int idfosforoRegla) {
        try {
            FosforoRegla fosforoReglaEliminar = readFosforoRegla(idfosforoRegla);
            listFosforoRegla.remove(fosforoReglaEliminar);

            PreparedStatement consulta;
            Connection conexion = Conexion.obtener();
            consulta = conexion.prepareStatement("DELETE FROM " + this.tabla + " WHERE id_regla_fosforo = " + idfosforoRegla);
            consulta.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FosforoReglaService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void mostrarReglas() {
        for (int i = 0; i < listFosforoRegla.size(); i++) {
            //System.out.println(listNutrienteRegla.get(i).getNombreRegla());
            System.out.println(listFosforoRegla.get(i).toString());
        }
    }

    public ArrayList<FosforoRegla> readAllFosforo() {
        return listFosforoRegla;

    }

    public void actualizarReglasFosforoDrl() {

        File file = new File("./src/main/resources/rules/NutrienteFosforo.drl");
        try {
            FileOutputStream out = new FileOutputStream(file);
            String importPackage = "package rules \nimport model.Cultivo;\n";
            out.write(importPackage.getBytes());
            for (int i = 0; i < listFosforoRegla.size(); i++) {

                String nombreRegla = "rule " + "\"" + listFosforoRegla.get(i).getNombreRegla() + "\"\n";
                out.write(nombreRegla.getBytes());
                String when = "    when\n";
                out.write(when.getBytes());
                String condicion = "        $c : Cultivo( nivelFosforo >= " + listFosforoRegla.get(i).getLimiteInferior() + " && <=" + listFosforoRegla.get(i).getLimiteSuperior() + " )\n";
                out.write(condicion.getBytes());
                String then = "    then\n";
                out.write(then.getBytes());
                String conclusion = "        $c.setRangoNivelFosforo(\"" + listFosforoRegla.get(i).getConclusion() + "\");\n";
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

    public ArrayList<FosforoRegla> recuperarListaFosforoRegla() {
        Connection conexion = Conexion.obtener();
        ArrayList<FosforoRegla> fosforoReglaLista = new ArrayList<FosforoRegla>();
        try {
            PreparedStatement consulta = conexion.prepareStatement("SELECT id_regla_fosforo, nombre_regla, limite_inferior, limite_superior, conclusion FROM " + this.tabla + " ORDER BY id_regla_fosforo");
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                fosforoReglaLista.add(new FosforoRegla(resultado.getInt("id_regla_fosforo"), resultado.getString("nombre_regla"), resultado.getInt("limite_inferior"), resultado.getInt("limite_superior"), resultado.getString("conclusion")));
            }
            System.out.println("cantidad reglas: " + fosforoReglaLista.size());
        } catch (SQLException ex) {
            Logger.getLogger(FosforoReglaService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fosforoReglaLista;
    }
}
