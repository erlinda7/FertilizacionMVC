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
import model.RecomendacionRegla;

/**
 *
 * @author Erlinda
 */
public class RecomendacionReglaService {

    ArrayList<RecomendacionRegla> listRecomendacionRegla;
    private final String tabla = "recomendacion_regla";

    public RecomendacionReglaService() {

        listRecomendacionRegla = recuperarListaRecomendacionRegla();
    }
        public void createRecomendacionRegla(RecomendacionRegla newRecomendacionRegla) {
        try {
            listRecomendacionRegla.add(newRecomendacionRegla);
            PreparedStatement consulta;
            Connection conexion = Conexion.obtener();
            consulta = conexion.prepareStatement("INSERT INTO " + this.tabla + "(nombre_fertilizante_nitrogenado, nombre_fertilizante_fosfatado, nombre_fertilizante_potasico, formula_fertilizante_nitrogenado, formula_fertilizante_fosfatado, formula_fertilizante_potasico) VALUES(?, ?, ?, ?, ?, ?)");
            consulta.setString(1, newRecomendacionRegla.getNombreFertilizanteNitrogenado());
            consulta.setString(2, newRecomendacionRegla.getNombreFertilizanteFosfatado());
            consulta.setString(3, newRecomendacionRegla.getNombreFertilizantePotasico());
            consulta.setInt(4, newRecomendacionRegla.getFormulaFertilizanteNitrogenado());
            consulta.setInt(4, newRecomendacionRegla.getFormulaFertilizanteFosfatado());
            consulta.setInt(4, newRecomendacionRegla.getFormulaFertilizantePotasico());

            consulta.executeUpdate();
            
            listRecomendacionRegla = recuperarListaRecomendacionRegla();
            
        } catch (SQLException ex) {
            Logger.getLogger(RecomendacionReglaService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public RecomendacionRegla readRecomendacionRegla(int idRecomendacionRegla) {
        RecomendacionRegla recomendacionReglaRecuperado = null;
        for (int i = 0; i < listRecomendacionRegla.size(); i++) {
            if (idRecomendacionRegla == listRecomendacionRegla.get(i).getId_recomendacion_regla()) {
                recomendacionReglaRecuperado = listRecomendacionRegla.get(i);
            }
        }
        return recomendacionReglaRecuperado;

    }

    public void updateRecomendacionRegla(int idRecomendacionRegla, RecomendacionRegla newRecomendacionRegla) {
        try {
            RecomendacionRegla recomendacionReglaParaActualizar = readRecomendacionRegla(idRecomendacionRegla);
            recomendacionReglaParaActualizar.setNombreFertilizanteNitrogenado(newRecomendacionRegla.getNombreFertilizanteNitrogenado());
            recomendacionReglaParaActualizar.setNombreFertilizanteFosfatado(newRecomendacionRegla.getNombreFertilizanteFosfatado());
            recomendacionReglaParaActualizar.setNombreFertilizantePotasico(newRecomendacionRegla.getNombreFertilizantePotasico());
            recomendacionReglaParaActualizar.setFormulaFertilizanteNitrogenado(newRecomendacionRegla.getFormulaFertilizanteNitrogenado());
            recomendacionReglaParaActualizar.setFormulaFertilizanteFosfatado(newRecomendacionRegla.getFormulaFertilizanteFosfatado());
            recomendacionReglaParaActualizar.setFormulaFertilizantePotasico(newRecomendacionRegla.getFormulaFertilizantePotasico());

            PreparedStatement consultaupdate;
            Connection conexion = Conexion.obtener();
            consultaupdate = conexion.prepareStatement("UPDATE " + this.tabla + " SET nombre_fertilizante_nitrogenado = ?, nombre_fertilizante_fosfatado = ?, nombre_fertilizante_potasico = ?, formula_fertilizante_nitrogenado = ?, formula_fertilizante_fosfatado = ?, formula_fertilizante_potasico = ? WHERE id_recomendacion_regla = ?");
            consultaupdate.setString(1, newRecomendacionRegla.getNombreFertilizanteNitrogenado());
            consultaupdate.setString(2, newRecomendacionRegla.getNombreFertilizanteFosfatado());
            consultaupdate.setString(3, newRecomendacionRegla.getNombreFertilizantePotasico());
            consultaupdate.setInt(4, newRecomendacionRegla.getFormulaFertilizanteNitrogenado());
            consultaupdate.setInt(4, newRecomendacionRegla.getFormulaFertilizanteFosfatado());
            consultaupdate.setInt(4, newRecomendacionRegla.getFormulaFertilizantePotasico());
            consultaupdate.setInt(5, idRecomendacionRegla);
            
            consultaupdate.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(RecomendacionReglaService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void deleteRecomendacionRegla(int idRecomendacionRegla) {
        try {
            RecomendacionRegla recomendacionReglaEliminar = readRecomendacionRegla(idRecomendacionRegla);
            listRecomendacionRegla.remove(recomendacionReglaEliminar);
            PreparedStatement consulta;
            Connection conexion = Conexion.obtener();
            consulta = conexion.prepareStatement("DELETE FROM " + this.tabla + " WHERE id_recomendacion_regla = " + idRecomendacionRegla);
            consulta.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RecomendacionReglaService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void mostrarReglas() {
        for (int i = 0; i < listRecomendacionRegla.size(); i++) {
            //System.out.println(listNutrienteRegla.get(i).getNombreRegla());
            System.out.println(listRecomendacionRegla.get(i).toString());
        }
    }

    public ArrayList<RecomendacionRegla> readAllRecomendacion() {
        return listRecomendacionRegla;

    }

    public void actualizarReglasNitrogenoDrl() {
        File file = new File("./src/main/resources/rules/RecomendacionNueva.drl");
        try {
            FileOutputStream out = new FileOutputStream(file);
            String importPackage = "package rules \nimport model.Cultivo;\n";
            out.write(importPackage.getBytes());
            for (int i = 0; i < listRecomendacionRegla.size(); i++) {
                String nombreRegla = "rule " + "\" Recomendacion de fertilizacion N P K " + listRecomendacionRegla.get(i).getId_recomendacion_regla() + "\"\n";
                out.write(nombreRegla.getBytes());
                String when = "    when\n";
                out.write(when.getBytes());
                String condicion = "        $c : Cultivo( cantKgN >0, cantKgP >0, cantKgK >0 )\n";
                out.write(condicion.getBytes());
                String then = "    then\n";
                out.write(then.getBytes());
                String conclusionN1 = "        double cantFertilizanteN = (cantKgN*100)/" + listRecomendacionRegla.get(i).getFormulaFertilizanteNitrogenado();
                out.write(conclusionN1.getBytes());
                String conclusionN11 = "        double cantFertilizanteN = (cantKgN*100)/" + listRecomendacionRegla.get(i).getFormulaFertilizanteNitrogenado();
                out.write(conclusionN11.getBytes());
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
    public ArrayList<RecomendacionRegla> recuperarListaRecomendacionRegla(){
        Connection conexion = Conexion.obtener();
        ArrayList<RecomendacionRegla> recomendacionReglaLista= new ArrayList<RecomendacionRegla>();
        try {
            PreparedStatement consulta = conexion.prepareStatement("SELECT id_recomendacion_regla, nombre_fertilizante_nitrogenado, nombre_fertilizante_fosfatado, nombre_fertilizante_potasico, formula_fertilizante_nitrogenado, formula_fertilizante_fosfatado, formula_fertilizante_potasico FROM "+this.tabla+" ORDER BY id_recomendacion_regla");                                                   
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {                
                recomendacionReglaLista.add(new RecomendacionRegla(resultado.getInt("id_recomendacion_regla"), resultado.getString("nombre_fertilizante_nitrogenado"), resultado.getString("nombre_fertilizante_fosfatado"), resultado.getString("nombre_fertilizante_potasico"), resultado.getInt("formula_fertilizante_nitrogenado"), resultado.getInt("formula_fertilizante_fosfatado"), resultado.getInt("formula_fertilizante_potasico")));
            }
            System.out.println("cantidad reglas: "+recomendacionReglaLista.size());
        } catch (SQLException ex) {
            Logger.getLogger(RecomendacionReglaService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return recomendacionReglaLista;
    }
}
