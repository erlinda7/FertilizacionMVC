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
import model.RecomendacionNuevoFertilizanteRegla;

/**
 *
 * @author Erlinda
 */
public class RecomendacionNuevoFertilizanteReglaService {

    ArrayList<RecomendacionNuevoFertilizanteRegla> listRecomendacionRegla;
    private final String tabla = "recomendacion_regla";

    public RecomendacionNuevoFertilizanteReglaService() {

        listRecomendacionRegla = recuperarListaRecomendacionRegla();
    }

    public void createRecomendacionRegla(RecomendacionNuevoFertilizanteRegla newRecomendacionRegla) {
        try {
            listRecomendacionRegla.add(newRecomendacionRegla);
            PreparedStatement consulta;
            Connection conexion = Conexion.obtener();
            consulta = conexion.prepareStatement("INSERT INTO " + this.tabla + "(nombre_fertilizante_nitrogenado, nombre_fertilizante_fosfatado, nombre_fertilizante_potasico, formula_fertilizante_nitrogenado, formula_fertilizante_fosfatado, formula_fertilizante_potasico) VALUES(?, ?, ?, ?, ?, ?)");
            consulta.setString(1, newRecomendacionRegla.getNombreFertilizanteNitrogenado());
            consulta.setString(2, newRecomendacionRegla.getNombreFertilizanteFosfatado());
            consulta.setString(3, newRecomendacionRegla.getNombreFertilizantePotasico());
            consulta.setInt(4, newRecomendacionRegla.getFormulaFertilizanteNitrogenado());
            consulta.setInt(5, newRecomendacionRegla.getFormulaFertilizanteFosfatado());
            consulta.setInt(6, newRecomendacionRegla.getFormulaFertilizantePotasico());

            consulta.executeUpdate();

            listRecomendacionRegla = recuperarListaRecomendacionRegla();

        } catch (SQLException ex) {
            Logger.getLogger(RecomendacionNuevoFertilizanteReglaService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public RecomendacionNuevoFertilizanteRegla readRecomendacionRegla(int idRecomendacionRegla) {
        RecomendacionNuevoFertilizanteRegla recomendacionReglaRecuperado = null;
        for (int i = 0; i < listRecomendacionRegla.size(); i++) {
            if (idRecomendacionRegla == listRecomendacionRegla.get(i).getId_recomendacion_regla()) {
                recomendacionReglaRecuperado = listRecomendacionRegla.get(i);
            }
        }
        return recomendacionReglaRecuperado;

    }

    public void updateRecomendacionRegla(int idRecomendacionRegla, RecomendacionNuevoFertilizanteRegla newRecomendacionRegla) {
        try {
            RecomendacionNuevoFertilizanteRegla recomendacionReglaParaActualizar = readRecomendacionRegla(idRecomendacionRegla);
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
            consultaupdate.setInt(5, newRecomendacionRegla.getFormulaFertilizanteFosfatado());
            consultaupdate.setInt(6, newRecomendacionRegla.getFormulaFertilizantePotasico());
            consultaupdate.setInt(7, idRecomendacionRegla);

            consultaupdate.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(RecomendacionNuevoFertilizanteReglaService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void deleteRecomendacionRegla(int idRecomendacionRegla) {
        try {
            RecomendacionNuevoFertilizanteRegla recomendacionReglaEliminar = readRecomendacionRegla(idRecomendacionRegla);
            listRecomendacionRegla.remove(recomendacionReglaEliminar);
            PreparedStatement consulta;
            Connection conexion = Conexion.obtener();
            consulta = conexion.prepareStatement("DELETE FROM " + this.tabla + " WHERE id_recomendacion_regla = " + idRecomendacionRegla);
            consulta.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RecomendacionNuevoFertilizanteReglaService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void mostrarReglas() {
        for (int i = 0; i < listRecomendacionRegla.size(); i++) {
            //System.out.println(listNutrienteRegla.get(i).getNombreRegla());
            System.out.println(listRecomendacionRegla.get(i).toString());
        }
    }

    public ArrayList<RecomendacionNuevoFertilizanteRegla> readAllRecomendacion() {
        return listRecomendacionRegla;

    }

    public void actualizarReglasRecomendacionDrl() {
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
                String conclusionN = "        Recomendacion rec = new Recomendacion();\n";
                out.write(conclusionN.getBytes());
                //nitrogeno
                String conclusionN1 = "        double cantFertilizanteN = (cantKgN*100)/" + listRecomendacionRegla.get(i).getFormulaFertilizanteNitrogenado() + ";\n";
                out.write(conclusionN1.getBytes());
                String conclusionN11 = "        cantFertilizanteN = Math.rint(cantFertilizanteN*10)/10;\n";
                out.write(conclusionN11.getBytes());
                String conclusionN12 = "        rec.addFertilizanteN(cantFertilizanteN + " + listRecomendacionRegla.get(i).getNombreFertilizanteNitrogenado() + ");\n";
                out.write(conclusionN12.getBytes());
                //fosforo
                String conclusionP1 = "        double cantFertilizanteP = (cantKgP*100)/" + listRecomendacionRegla.get(i).getFormulaFertilizanteFosfatado() + ";\n";
                out.write(conclusionP1.getBytes());
                String conclusionP11 = "        cantFertilizanteP = Math.rint(cantFertilizanteP*10)/10;\n";
                out.write(conclusionP11.getBytes());
                String conclusionP12 = "        rec.addFertilizanteP(cantFertilizanteP + " + listRecomendacionRegla.get(i).getNombreFertilizanteFosfatado() + ");\n";
                out.write(conclusionP12.getBytes());
                //potasio
                String conclusionK1 = "        double cantFertilizanteK = (cantKgK*100)/" + listRecomendacionRegla.get(i).getFormulaFertilizantePotasico() + ";\n";
                out.write(conclusionK1.getBytes());
                String conclusionK11 = "        cantFertilizanteK = Math.rint(cantFertilizanteK*10)/10;\n";
                out.write(conclusionK11.getBytes());
                String conclusionK12 = "        rec.addFertilizanteK(cantFertilizanteK + " + listRecomendacionRegla.get(i).getNombreFertilizantePotasico() + ");\n";
                out.write(conclusionK12.getBytes());
                //
                String conclusion = "        $c.addRecomendacion(rec);\n";
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

    public ArrayList<RecomendacionNuevoFertilizanteRegla> recuperarListaRecomendacionRegla() {
        Connection conexion = Conexion.obtener();
        ArrayList<RecomendacionNuevoFertilizanteRegla> recomendacionReglaLista = new ArrayList<RecomendacionNuevoFertilizanteRegla>();
        try {
            PreparedStatement consulta = conexion.prepareStatement("SELECT id_recomendacion_regla, nombre_fertilizante_nitrogenado, nombre_fertilizante_fosfatado, nombre_fertilizante_potasico, formula_fertilizante_nitrogenado, formula_fertilizante_fosfatado, formula_fertilizante_potasico FROM " + this.tabla + " ORDER BY id_recomendacion_regla");
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                recomendacionReglaLista.add(new RecomendacionNuevoFertilizanteRegla(resultado.getInt("id_recomendacion_regla"), resultado.getString("nombre_fertilizante_nitrogenado"), resultado.getString("nombre_fertilizante_fosfatado"), resultado.getString("nombre_fertilizante_potasico"), resultado.getInt("formula_fertilizante_nitrogenado"), resultado.getInt("formula_fertilizante_fosfatado"), resultado.getInt("formula_fertilizante_potasico")));
            }
            System.out.println("cantidad reglas: " + recomendacionReglaLista.size());
        } catch (SQLException ex) {
            Logger.getLogger(RecomendacionNuevoFertilizanteReglaService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return recomendacionReglaLista;
    }

    public static void main(String[] args) {

        //inicio test para forma aplicar fertilizante
        RecomendacionNuevoFertilizanteReglaService recomendacionReglaService = new RecomendacionNuevoFertilizanteReglaService();

        RecomendacionNuevoFertilizanteRegla recomendacionRegla = new RecomendacionNuevoFertilizanteRegla();
        recomendacionRegla.setId_recomendacion_regla(1);
        recomendacionRegla.setNombreFertilizanteNitrogenado("ureados");
        recomendacionRegla.setNombreFertilizanteFosfatado("fosforado");
        recomendacionRegla.setNombreFertilizantePotasico("potasa");
        recomendacionRegla.setFormulaFertilizanteNitrogenado(24);
        recomendacionRegla.setFormulaFertilizanteFosfatado(35);
        recomendacionRegla.setFormulaFertilizantePotasico(12);

        RecomendacionNuevoFertilizanteRegla recomendacionRegla1 = new RecomendacionNuevoFertilizanteRegla();
        recomendacionRegla1.setId_recomendacion_regla(1);
        recomendacionRegla1.setNombreFertilizanteNitrogenado("ureados1");
        recomendacionRegla1.setNombreFertilizanteFosfatado("fosforado1");
        recomendacionRegla1.setNombreFertilizantePotasico("potasa1");
        recomendacionRegla1.setFormulaFertilizanteNitrogenado(4);
        recomendacionRegla1.setFormulaFertilizanteFosfatado(5);
        recomendacionRegla1.setFormulaFertilizantePotasico(2);

        RecomendacionNuevoFertilizanteRegla recomendacionRegla2 = new RecomendacionNuevoFertilizanteRegla();
        recomendacionRegla2.setId_recomendacion_regla(1);
        recomendacionRegla2.setNombreFertilizanteNitrogenado("ureados1");
        recomendacionRegla2.setNombreFertilizanteFosfatado("fosforado1");
        recomendacionRegla2.setNombreFertilizantePotasico("potasa1");
        recomendacionRegla2.setFormulaFertilizanteNitrogenado(14);
        recomendacionRegla2.setFormulaFertilizanteFosfatado(15);
        recomendacionRegla2.setFormulaFertilizantePotasico(22);

        //crear
//        recomendacionReglaService.createRecomendacionRegla(recomendacionRegla);
//        recomendacionReglaService.createRecomendacionRegla(recomendacionRegla1);
//        recomendacionReglaService.createRecomendacionRegla(recomendacionRegla2);

//        //update
//        RecomendacionRegla correccionTexturaReglaactualizar = new RecomendacionRegla();
//        correccionTexturaReglaactualizar.setId_recomendacion_regla(1);
//        correccionTexturaReglaactualizar.setNombreFertilizanteNitrogenado("xxxxxx");
//        correccionTexturaReglaactualizar.setNombreFertilizanteFosfatado("yyyyyyyyyy");
//        correccionTexturaReglaactualizar.setNombreFertilizantePotasico("zzzzzzzzzz");
//        correccionTexturaReglaactualizar.setFormulaFertilizanteNitrogenado(14);
//        correccionTexturaReglaactualizar.setFormulaFertilizanteFosfatado(15);
//        correccionTexturaReglaactualizar.setFormulaFertilizantePotasico(22);
//        
//        recomendacionReglaService.updateRecomendacionRegla(3, correccionTexturaReglaactualizar);
//
        //delete
//       recomendacionReglaService.deleteRecomendacionRegla(4);
//       recomendacionReglaService.deleteRecomendacionRegla(5);
//       recomendacionReglaService.deleteRecomendacionRegla(6);

        recomendacionReglaService.actualizarReglasRecomendacionDrl();

        //fin test para forma aplicar fertilizante
    }
}
