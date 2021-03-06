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
import model.MateriaOrganicaRegla;

/**
 *
 * @author Erlinda
 */
public class MateriaOrganicaReglaService {

    ArrayList<MateriaOrganicaRegla> listMateriaOrganicaRegla;
    private final String tabla = "materia_organica_regla";

    public MateriaOrganicaReglaService() {

        listMateriaOrganicaRegla = recuperarListaMORegla();

    }

    public void createMateriaOrganicaRegla(MateriaOrganicaRegla newMateriaOrganicaRegla) {
        try {
            listMateriaOrganicaRegla.add(newMateriaOrganicaRegla);
            PreparedStatement consulta;
            Connection conexion = Conexion.obtener();
            consulta = conexion.prepareStatement("INSERT INTO " + this.tabla + "(nombre_regla, limite_inferior, limite_superior, conclusion) VALUES(?, ?, ?, ?)");
            consulta.setString(1, newMateriaOrganicaRegla.getNombreRegla());
            consulta.setInt(2, newMateriaOrganicaRegla.getLimiteInferior());
            consulta.setInt(3, newMateriaOrganicaRegla.getLimiteSuperior());
            consulta.setString(4, newMateriaOrganicaRegla.getConclusion());

            consulta.executeUpdate();
            
            listMateriaOrganicaRegla = recuperarListaMORegla();
            
        } catch (SQLException ex) {
            Logger.getLogger(MateriaOrganicaReglaService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public MateriaOrganicaRegla readMateriaOrganicaRegla(int idMateriaOrganicaRegla) {
        MateriaOrganicaRegla materiaOrganicaRecuperado = null;
        for (int i = 0; i < listMateriaOrganicaRegla.size(); i++) {
            if (idMateriaOrganicaRegla == listMateriaOrganicaRegla.get(i).getIdMateriaOrganicaRegla()) {
                materiaOrganicaRecuperado = listMateriaOrganicaRegla.get(i);
            }
        }
        return materiaOrganicaRecuperado;

    }

    public void updateMateriaOrganicaRegla(int idMateriaOrganicaRegla, MateriaOrganicaRegla newMateriaOrganicaRegla) {
        try {
            MateriaOrganicaRegla materiaOrganicaReglaParaActualizar = readMateriaOrganicaRegla(idMateriaOrganicaRegla);
            materiaOrganicaReglaParaActualizar.setNombreRegla(newMateriaOrganicaRegla.getNombreRegla());
            materiaOrganicaReglaParaActualizar.setLimiteInferior(newMateriaOrganicaRegla.getLimiteInferior());
            materiaOrganicaReglaParaActualizar.setLimiteSuperior(newMateriaOrganicaRegla.getLimiteSuperior());
            materiaOrganicaReglaParaActualizar.setConclusion(newMateriaOrganicaRegla.getConclusion());
            PreparedStatement consultaupdate;
            Connection conexion = Conexion.obtener();
            consultaupdate = conexion.prepareStatement("UPDATE " + this.tabla + " SET nombre_regla = ?, limite_inferior = ?, limite_superior = ?, conclusion = ? WHERE id_materia_organica_regla = ?");
            consultaupdate.setString(1, newMateriaOrganicaRegla.getNombreRegla());
            consultaupdate.setInt(2, newMateriaOrganicaRegla.getLimiteInferior());
            consultaupdate.setInt(3, newMateriaOrganicaRegla.getLimiteSuperior());
            consultaupdate.setString(4, newMateriaOrganicaRegla.getConclusion());
            consultaupdate.setInt(5, idMateriaOrganicaRegla);

            consultaupdate.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(MateriaOrganicaReglaService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteMateriaOrganicaRegla(int idMateriaOrganicaRegla) {
        try {
            MateriaOrganicaRegla materiaOrganicaReglaEliminar = readMateriaOrganicaRegla(idMateriaOrganicaRegla);
            listMateriaOrganicaRegla.remove(materiaOrganicaReglaEliminar);

            PreparedStatement consulta;
            Connection conexion = Conexion.obtener();
            consulta = conexion.prepareStatement("DELETE FROM " + this.tabla + " WHERE id_materia_organica_regla = " + idMateriaOrganicaRegla);
            consulta.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MateriaOrganicaReglaService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void mostrarReglas() {
        for (int i = 0; i < listMateriaOrganicaRegla.size(); i++) {
            //System.out.println(listNutrienteRegla.get(i).getNombreRegla());
            System.out.println(listMateriaOrganicaRegla.get(i).toString());
        }
    }

    public ArrayList<MateriaOrganicaRegla> readAllMateriaOrganica() {
        return listMateriaOrganicaRegla;

    }

    public void actualizarReglasMODrl() {

        File file = new File("./src/main/resources/rules/MateriaOrganica2.drl");
        try {
            FileOutputStream out = new FileOutputStream(file);
            String importPackage = "package rules \nimport model.Cultivo;\n";
            out.write(importPackage.getBytes());
            for (int i = 0; i < listMateriaOrganicaRegla.size(); i++) {

                String nombreRegla = "rule " + "\"" + listMateriaOrganicaRegla.get(i).getNombreRegla() + "\"\n";
                out.write(nombreRegla.getBytes());
                String when = "    when\n";
                out.write(when.getBytes());
                String condicion = "        $c : Cultivo( nivelMO >= " + listMateriaOrganicaRegla.get(i).getLimiteInferior() + " && <=" + listMateriaOrganicaRegla.get(i).getLimiteSuperior() + " )\n";
                out.write(condicion.getBytes());
                String then = "    then\n";
                out.write(then.getBytes());
                String conclusion = "        $c.setRangoNivelMO(\"" + listMateriaOrganicaRegla.get(i).getConclusion() + "\");\n";
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
     public ArrayList<MateriaOrganicaRegla> recuperarListaMORegla() {
        Connection conexion = Conexion.obtener();
        ArrayList<MateriaOrganicaRegla> moReglaLista = new ArrayList<MateriaOrganicaRegla>();
        try {
            PreparedStatement consulta = conexion.prepareStatement("SELECT id_materia_organica_regla, nombre_regla, limite_inferior, limite_superior, conclusion FROM " + this.tabla + " ORDER BY id_materia_organica_regla");
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                moReglaLista.add(new MateriaOrganicaRegla(resultado.getInt("id_materia_organica_regla"), resultado.getString("nombre_regla"), resultado.getInt("limite_inferior"), resultado.getInt("limite_superior"), resultado.getString("conclusion")));
            }
            //System.out.println("cantidad reglas: " + potasioReglaLista.size());
        } catch (SQLException ex) {
            Logger.getLogger(MateriaOrganicaReglaService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return moReglaLista;
    }
}
