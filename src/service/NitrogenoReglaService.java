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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.NitrogenoRegla;

/**
 *
 * @author Erlinda
 */
public class NitrogenoReglaService {

    ArrayList<NitrogenoRegla> listNitrogenoRegla;
    private final String tabla = "nitrogeno_regla";

    public NitrogenoReglaService() {

        listNitrogenoRegla = new ArrayList<NitrogenoRegla>();

    }

    public void createNitrogenoRegla(NitrogenoRegla newNitrogenoRegla) {
        try {
            listNitrogenoRegla.add(newNitrogenoRegla);
            PreparedStatement consulta;
            Connection conexion = Conexion.obtener();
            consulta = conexion.prepareStatement("INSERT INTO " + this.tabla + "(nombre_regla, limite_inferior, limite_superior, conclusion) VALUES(?, ?, ?, ?)");
            consulta.setString(1, newNitrogenoRegla.getNombreRegla());
            consulta.setInt(2, newNitrogenoRegla.getLimiteInferior());
            consulta.setInt(3, newNitrogenoRegla.getLimiteSuperior());
            consulta.setString(4, newNitrogenoRegla.getConclusion());

            consulta.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NitrogenoReglaService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public NitrogenoRegla readNitrogenoRegla(int idNitrogenoRegla) {
        NitrogenoRegla nitrogenoReglaRecuperado = null;
        for (int i = 0; i < listNitrogenoRegla.size(); i++) {
            if (idNitrogenoRegla == listNitrogenoRegla.get(i).getIdNitrogenoRegla()) {
                nitrogenoReglaRecuperado = listNitrogenoRegla.get(i);
            }
        }
        return nitrogenoReglaRecuperado;

    }

    public void updateNitrogenoRegla(int idNitrogenoRegla, NitrogenoRegla newNitrogenoRegla) {
        NitrogenoRegla nitrogenoReglaParaActualizar = readNitrogenoRegla(idNitrogenoRegla);
        nitrogenoReglaParaActualizar.setNombreRegla(newNitrogenoRegla.getNombreRegla());
        nitrogenoReglaParaActualizar.setLimiteInferior(newNitrogenoRegla.getLimiteInferior());
        nitrogenoReglaParaActualizar.setLimiteSuperior(newNitrogenoRegla.getLimiteSuperior());
        nitrogenoReglaParaActualizar.setConclusion(newNitrogenoRegla.getConclusion());
    }

    public void deleteNitrogenoRegla(int idNitrogenoRegla) {
        //try {
            NitrogenoRegla nitrogenoReglaEliminar = readNitrogenoRegla(idNitrogenoRegla);
            listNitrogenoRegla.remove(nitrogenoReglaEliminar);
//            PreparedStatement consulta;
//            Connection conexion = Conexion.obtener();
//            consulta = conexion.prepareStatement(" DELETE FROM" + this.tabla + "WHERE id_nitrogeno_regla= " + idNitrogenoRegla );
//            consulta.execute();
//        } catch (SQLException ex) {
//            Logger.getLogger(NitrogenoReglaService.class.getName()).log(Level.SEVERE, null, ex);
//        }

    }

    public void mostrarReglas() {
        for (int i = 0; i < listNitrogenoRegla.size(); i++) {
            //System.out.println(listNutrienteRegla.get(i).getNombreRegla());
            System.out.println(listNitrogenoRegla.get(i).toString());
        }
    }

    public ArrayList<NitrogenoRegla> readAllNitrogeno() {
        return listNitrogenoRegla;

    }

    public void actualizarReglasNitrogenoDrl() {
        File file = new File("./src/main/resources/rules/NutrienteNitrogeno.drl");
        try {
            FileOutputStream out = new FileOutputStream(file);
            String importPackage = "package rules \nimport model.Cultivo;\n";
            out.write(importPackage.getBytes());
            for (int i = 0; i < listNitrogenoRegla.size(); i++) {

                String nombreRegla = "rule " + "\"" + listNitrogenoRegla.get(i).getNombreRegla() + "\"\n";
                out.write(nombreRegla.getBytes());
                String when = "    when\n";
                out.write(when.getBytes());
                String condicion = "        $c : Cultivo( nivelNitrogeno >= " + listNitrogenoRegla.get(i).getLimiteInferior() + " && <=" + listNitrogenoRegla.get(i).getLimiteSuperior() + " )\n";
                out.write(condicion.getBytes());
                String then = "    then\n";
                out.write(then.getBytes());
                String conclusion = "        $c.setRangoNivelNitrogeno(\"" + listNitrogenoRegla.get(i).getConclusion() + "\");\n";
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

//    public static void main(String[] args) {
//
//        NitrogenoReglaService nitrogenoReglaService = new NitrogenoReglaService();
//        NitrogenoRegla nitrogenoRegla = new NitrogenoRegla();
//
//        nitrogenoRegla.setNombreRegla("regla nitrogeno baaajoo");
//        nitrogenoRegla.setLimiteInferior(12);
//        nitrogenoRegla.setLimiteSuperior(15);
//        nitrogenoRegla.setConclusion("dsgdgdfhfhdhfd");
//
//        nitrogenoReglaService.createNitrogenoRegla(nitrogenoRegla);
//    }
}
