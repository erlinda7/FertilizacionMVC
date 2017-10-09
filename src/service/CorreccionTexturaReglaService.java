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
import model.CorreccionTexturaRegla;


/**
 *
 * @author Erlinda
 */
public class CorreccionTexturaReglaService {
    
    ArrayList<CorreccionTexturaRegla> listaCorreccionTexturaRegla;
    private final String tabla = "correccion_textura_regla";

    public CorreccionTexturaReglaService() {

        listaCorreccionTexturaRegla = recuperarListaCorrTexturaRegla();
    }

    public void createCorreccionTexturaRegla(CorreccionTexturaRegla newCorrecionTexturaRegla) {
        try {
            listaCorreccionTexturaRegla.add(newCorrecionTexturaRegla);
            PreparedStatement consulta;
            Connection conexion = Conexion.obtener();
            consulta = conexion.prepareStatement("INSERT INTO " + this.tabla + "(nombre_regla, textura_corregir, porcentaje_corregir) VALUES(?, ?, ?)");
            consulta.setString(1, newCorrecionTexturaRegla.getNombreRegla());
            consulta.setString(2, newCorrecionTexturaRegla.getTexturaACorregir());
            consulta.setInt(3, newCorrecionTexturaRegla.getConclusionPorcACorregir());

            consulta.executeUpdate();

            listaCorreccionTexturaRegla = recuperarListaCorrTexturaRegla();

        } catch (SQLException ex) {
            Logger.getLogger(CorreccionTexturaReglaService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public CorreccionTexturaRegla readCorreccionTexturaRegla(int idCorreccionTexturaRegla) {
        CorreccionTexturaRegla correccionTexturaReglaRecuperado = null;
        for (int i = 0; i < listaCorreccionTexturaRegla.size(); i++) {
            if (idCorreccionTexturaRegla == listaCorreccionTexturaRegla.get(i).getIdCorreccionTextura()) {
                correccionTexturaReglaRecuperado = listaCorreccionTexturaRegla.get(i);
            }
        }
        return correccionTexturaReglaRecuperado;

    }

    public void updateCorreccionTexturaRegla(int idCorreccionTexturaRegla, CorreccionTexturaRegla newCorrecionTexturaRegla) {
        try {
            CorreccionTexturaRegla correccionTexturaReglaParaActualizar = readCorreccionTexturaRegla(idCorreccionTexturaRegla);
            correccionTexturaReglaParaActualizar.setNombreRegla(newCorrecionTexturaRegla.getNombreRegla());
            correccionTexturaReglaParaActualizar.setTexturaACorregir(newCorrecionTexturaRegla.getTexturaACorregir());
            correccionTexturaReglaParaActualizar.setConclusionPorcACorregir(newCorrecionTexturaRegla.getConclusionPorcACorregir());

            PreparedStatement consultaupdate;
            Connection conexion = Conexion.obtener();
            consultaupdate = conexion.prepareStatement("UPDATE " + this.tabla + " SET nombre_regla = ?, textura_corregir = ?, porcentaje_corregir = ? WHERE id_corr_textura_regla = ?");
            consultaupdate.setString(1, newCorrecionTexturaRegla.getNombreRegla());
            consultaupdate.setString(2, newCorrecionTexturaRegla.getTexturaACorregir());
            consultaupdate.setInt(3, newCorrecionTexturaRegla.getConclusionPorcACorregir());
            consultaupdate.setInt(4, idCorreccionTexturaRegla);

            consultaupdate.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CorreccionTexturaReglaService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void deleteCorreccionTexturaRegla(int idCorreccionTexturaRegla) {
        try {
            CorreccionTexturaRegla correccionTexturaReglaEliminar = readCorreccionTexturaRegla(idCorreccionTexturaRegla);
            listaCorreccionTexturaRegla.remove(correccionTexturaReglaEliminar);
            PreparedStatement consulta;
            Connection conexion = Conexion.obtener();
            consulta = conexion.prepareStatement("DELETE FROM " + this.tabla + " WHERE id_corr_textura_regla = " + idCorreccionTexturaRegla);
            consulta.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CorreccionTexturaReglaService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void mostrarReglas() {
        for (int i = 0; i < listaCorreccionTexturaRegla.size(); i++) {
            //System.out.println(listNutrienteRegla.get(i).getNombreRegla());
            System.out.println(listaCorreccionTexturaRegla.get(i).toString());
        }
    }

    public ArrayList<CorreccionTexturaRegla> readAllCorreccionTextura() {
        return listaCorreccionTexturaRegla;

    }

    public void actualizarReglasCorrTexturaDrl() {
        File file = new File("./src/main/resources/rules/CorreccionTextura2.drl");
        try {
            FileOutputStream out = new FileOutputStream(file);
            String importPackageCultivo = "package rules \nimport model.Cultivo;\n";
            String importPackageTextura = "import model.Textura;\n";
           
            out.write(importPackageCultivo.getBytes());
            out.write(importPackageTextura.getBytes());
            for (int i = 0; i < listaCorreccionTexturaRegla.size(); i++) {

                String nombreRegla = "rule " + "\"" + listaCorreccionTexturaRegla.get(i).getNombreRegla() + "\"\n";
                out.write(nombreRegla.getBytes());
                String when = "    when\n";
                out.write(when.getBytes());
                String condicionCultivo = "        $t : Textura(tipoTextura== \"" + listaCorreccionTexturaRegla.get(i).getTexturaACorregir() + "\" )\n";
                out.write(condicionCultivo.getBytes());
                String condicionTextura = "        $c : Cultivo()\n";
                out.write(condicionTextura.getBytes());
                String then = "    then\n";
                out.write(then.getBytes());
                String conclusioncantKgN = "        double cantKgN=Math.rint(($c.getCantKgN()*"+ ((listaCorreccionTexturaRegla.get(i).getConclusionPorcACorregir()/100.0)+1) + ")*10)/10;\n";
                out.write(conclusioncantKgN.getBytes());
                String conclusioncantKgP = "        double cantKgP=Math.rint(($c.getCantKgP()*"+ ((listaCorreccionTexturaRegla.get(i).getConclusionPorcACorregir()/100.0)+1) + ")*10)/10;\n";
                out.write(conclusioncantKgP.getBytes());
                String conclusioncantKgK = "        double cantKgK=Math.rint(($c.getCantKgK()*"+ ((listaCorreccionTexturaRegla.get(i).getConclusionPorcACorregir()/100.0)+1) + ")*10)/10;\n";
                
                //System.out.println(((listaCorreccionTexturaRegla.get(i).getConclusionPorcACorregir()/100.0)+1));
                out.write(conclusioncantKgK.getBytes());
                String conclusionSetcantKgN = "        $c.setCantKgN(cantKgN);\n"; 
                out.write(conclusionSetcantKgN.getBytes());
                String conclusionSetcantKgP = "        $c.setCantKgP(cantKgP);\n";
                out.write(conclusionSetcantKgP.getBytes());
                String conclusionSetcantKgK = "        $c.setCantKgK(cantKgK);\n";
                out.write(conclusionSetcantKgK.getBytes());
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

    public ArrayList<CorreccionTexturaRegla> recuperarListaCorrTexturaRegla() {
        Connection conexion = Conexion.obtener();
        ArrayList<CorreccionTexturaRegla> correccionTexturaReglaLista = new ArrayList<CorreccionTexturaRegla>();
        try {
            PreparedStatement consulta = conexion.prepareStatement("SELECT id_corr_textura_regla, nombre_regla, textura_corregir,  porcentaje_corregir FROM " + this.tabla + " ORDER BY id_corr_textura_regla");
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                correccionTexturaReglaLista.add(new CorreccionTexturaRegla(resultado.getInt("id_corr_textura_regla"), resultado.getString("nombre_regla"), resultado.getString("textura_corregir"), resultado.getInt("porcentaje_corregir")));
            }
            System.out.println("cantidad reglas: " + correccionTexturaReglaLista.size());
        } catch (SQLException ex) {
            Logger.getLogger(CorreccionTexturaReglaService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return correccionTexturaReglaLista;
    }

    public static void main(String[] args) {

        //inicio test para forma aplicar fertilizante
        CorreccionTexturaReglaService correcionTexturaReglaService = new CorreccionTexturaReglaService();

        CorreccionTexturaRegla correccionTexturaRegla = new CorreccionTexturaRegla();
        correccionTexturaRegla.setIdCorreccionTextura(1);
        correccionTexturaRegla.setNombreRegla("arenosa corregir");
        correccionTexturaRegla.setTexturaACorregir("Arenosa");
        correccionTexturaRegla.setConclusionPorcACorregir(10);

        CorreccionTexturaRegla correccionTexturaRegla2 = new CorreccionTexturaRegla();
        correccionTexturaRegla2.setIdCorreccionTextura(1);
        correccionTexturaRegla2.setNombreRegla("arenosa2 corregir");
        correccionTexturaRegla2.setTexturaACorregir("Arenosa2");
        correccionTexturaRegla2.setConclusionPorcACorregir(10);
        
        CorreccionTexturaRegla correccionTexturaRegla3 = new CorreccionTexturaRegla();
        correccionTexturaRegla3.setIdCorreccionTextura(1);
        correccionTexturaRegla3.setNombreRegla("arenosa3 corregir");
        correccionTexturaRegla3.setTexturaACorregir("Arenosa3");
        correccionTexturaRegla3.setConclusionPorcACorregir(10);
        
        //crear
        correcionTexturaReglaService.createCorreccionTexturaRegla(correccionTexturaRegla);
        correcionTexturaReglaService.createCorreccionTexturaRegla(correccionTexturaRegla2);
        correcionTexturaReglaService.createCorreccionTexturaRegla(correccionTexturaRegla3);

//        //update
//        CorreccionTexturaRegla correccionTexturaReglaactualizar = new CorreccionTexturaRegla();
//        correccionTexturaReglaactualizar.setIdCorreccionTextura(26);
//        correccionTexturaReglaactualizar.setNombreRegla("arenosa 4 corregir");
//        correccionTexturaReglaactualizar.setTexturaACorregir("arenosa4");
//        correccionTexturaReglaactualizar.setConclusionPorcACorregir(20);
//        correcionTexturaReglaService.updateCorreccionTexturaRegla(41, correccionTexturaReglaactualizar);
//
//        //delete
//        correcionTexturaReglaService.deleteCorreccionTexturaRegla(42);

        correcionTexturaReglaService.actualizarReglasCorrTexturaDrl();

        //fin test para forma aplicar fertilizante
    }
}
