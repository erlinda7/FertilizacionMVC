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
import model.FormaAplicarFertilizanteRegla;

/**
 *
 * @author Erlinda
 */
public class FormaApliFertilizReglaService {

    ArrayList<FormaAplicarFertilizanteRegla> listaFormaAplicarFertilizante;
    private final String tabla = "forma_aplicar_fertilizante";

    public FormaApliFertilizReglaService() {

        listaFormaAplicarFertilizante = recuperarListaFormaApliFertiRegla();
    }

    public void createFormaApliFertiRegla(FormaAplicarFertilizanteRegla newformaAplicarFertilizanteRegla) {
        try {
            listaFormaAplicarFertilizante.add(newformaAplicarFertilizanteRegla);
            PreparedStatement consulta;
            Connection conexion = Conexion.obtener();
            consulta = conexion.prepareStatement("INSERT INTO " + this.tabla + "(nombre_regla, hortaliza_a_fertilizar, conclusion) VALUES(?, ?, ?)");
            consulta.setString(1, newformaAplicarFertilizanteRegla.getNombreRegla());
            consulta.setString(2, newformaAplicarFertilizanteRegla.getHortalizaAFertilizar());
            consulta.setString(3, newformaAplicarFertilizanteRegla.getConclusion());

            consulta.executeUpdate();

            listaFormaAplicarFertilizante = recuperarListaFormaApliFertiRegla();

        } catch (SQLException ex) {
            Logger.getLogger(FormaApliFertilizReglaService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public FormaAplicarFertilizanteRegla readFormaApliFertiRegla(int idFormaApliFertiRegla) {
        FormaAplicarFertilizanteRegla formaApliFertiReglaRecuperado = null;
        for (int i = 0; i < listaFormaAplicarFertilizante.size(); i++) {
            if (idFormaApliFertiRegla == listaFormaAplicarFertilizante.get(i).getIdFormaAplicFertilizante()) {
                formaApliFertiReglaRecuperado = listaFormaAplicarFertilizante.get(i);
            }
        }
        return formaApliFertiReglaRecuperado;

    }

    public void updateFormaApliFertiRegla(int idFormaApliFertiRegla, FormaAplicarFertilizanteRegla newFormaApliFertiRegla) {
        try {
            FormaAplicarFertilizanteRegla formaApliFertiReglaParaActualizar = readFormaApliFertiRegla(idFormaApliFertiRegla);
            formaApliFertiReglaParaActualizar.setNombreRegla(newFormaApliFertiRegla.getNombreRegla());
            formaApliFertiReglaParaActualizar.setHortalizaAFertilizar(newFormaApliFertiRegla.getHortalizaAFertilizar());
            formaApliFertiReglaParaActualizar.setConclusion(newFormaApliFertiRegla.getConclusion());

            PreparedStatement consultaupdate;
            Connection conexion = Conexion.obtener();
            consultaupdate = conexion.prepareStatement("UPDATE " + this.tabla + " SET nombre_regla = ?, hortaliza_a_fertilizar = ?, conclusion = ? WHERE id_forma_apli_fertiliz = ?");
            consultaupdate.setString(1, newFormaApliFertiRegla.getNombreRegla());
            consultaupdate.setString(2, newFormaApliFertiRegla.getHortalizaAFertilizar());
            consultaupdate.setString(3, newFormaApliFertiRegla.getConclusion());
            consultaupdate.setInt(4, idFormaApliFertiRegla);

            consultaupdate.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(FormaApliFertilizReglaService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void deleteFormaApliFertiRegla(int idformaApliFertiRegla) {
        try {
            FormaAplicarFertilizanteRegla formaApliFertiReglaEliminar = readFormaApliFertiRegla(idformaApliFertiRegla);
            listaFormaAplicarFertilizante.remove(formaApliFertiReglaEliminar);
            PreparedStatement consulta;
            Connection conexion = Conexion.obtener();
            consulta = conexion.prepareStatement("DELETE FROM " + this.tabla + " WHERE id_forma_apli_fertiliz = " + idformaApliFertiRegla);
            consulta.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FormaApliFertilizReglaService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void mostrarReglas() {
        for (int i = 0; i < listaFormaAplicarFertilizante.size(); i++) {
            //System.out.println(listNutrienteRegla.get(i).getNombreRegla());
            System.out.println(listaFormaAplicarFertilizante.get(i).toString());
        }
    }

    public ArrayList<FormaAplicarFertilizanteRegla> readAllFormaApliFerti() {
        return listaFormaAplicarFertilizante;

    }

    public void actualizarReglasFormaApliFertiDrl() {
        File file = new File("./src/main/resources/rules/FormaAplicarFertilizante2.drl");
        try {
            FileOutputStream out = new FileOutputStream(file);
            String importPackage = "package rules \nimport model.Cultivo;\n";
            out.write(importPackage.getBytes());
            for (int i = 0; i < listaFormaAplicarFertilizante.size(); i++) {

                String nombreRegla = "rule " + "\"" + listaFormaAplicarFertilizante.get(i).getNombreRegla() + "\"\n";
                out.write(nombreRegla.getBytes());
                String when = "    when\n";
                out.write(when.getBytes());
                String condicion = "        $c : Cultivo( hortaliza== \"" + listaFormaAplicarFertilizante.get(i).getHortalizaAFertilizar() + "\" )\n";
                out.write(condicion.getBytes());
                String then = "    then\n";
                out.write(then.getBytes());
                String conclusion = "        $c.setFormaAplicar(\"" + listaFormaAplicarFertilizante.get(i).getConclusion() + "\");\n";
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

    public ArrayList<FormaAplicarFertilizanteRegla> recuperarListaFormaApliFertiRegla() {
        Connection conexion = Conexion.obtener();
        ArrayList<FormaAplicarFertilizanteRegla> formaApliFertiReglaLista = new ArrayList<FormaAplicarFertilizanteRegla>();
        try {
            PreparedStatement consulta = conexion.prepareStatement("SELECT id_forma_apli_fertiliz, nombre_regla, hortaliza_a_fertilizar,  conclusion FROM " + this.tabla + " ORDER BY id_forma_apli_fertiliz");
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                formaApliFertiReglaLista.add(new FormaAplicarFertilizanteRegla(resultado.getInt("id_forma_apli_fertiliz"), resultado.getString("nombre_regla"), resultado.getString("hortaliza_a_fertilizar"), resultado.getString("conclusion")));
            }
            System.out.println("cantidad reglas: " + formaApliFertiReglaLista.size());
        } catch (SQLException ex) {
            Logger.getLogger(FormaApliFertilizReglaService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return formaApliFertiReglaLista;
    }

    public static void main(String[] args) {

        //inicio test para forma aplicar fertilizante
        FormaApliFertilizReglaService formaApliFertilizReglaService = new FormaApliFertilizReglaService();

        FormaAplicarFertilizanteRegla formaApliFertiRegla = new FormaAplicarFertilizanteRegla();
        formaApliFertiRegla.setIdFormaAplicFertilizante(1);
        formaApliFertiRegla.setNombreRegla("fertilizar a acelga");
        formaApliFertiRegla.setHortalizaAFertilizar("Acelga");
        formaApliFertiRegla.setConclusion("poner a sus raiscessvvvvvvvvvvvvvvvvvvvvvvv de la acelga");

        FormaAplicarFertilizanteRegla formaApliFertiRegla2 = new FormaAplicarFertilizanteRegla();
        formaApliFertiRegla2.setIdFormaAplicFertilizante(2);
        formaApliFertiRegla2.setNombreRegla("fertilizar a papa");
        formaApliFertiRegla2.setHortalizaAFertilizar("Papa");
        formaApliFertiRegla2.setConclusion("poner a sus raiscessvvvvvvvvvvvvvvvvvvvvvvv de la papa");
        
        FormaAplicarFertilizanteRegla formaApliFertiRegla3 = new FormaAplicarFertilizanteRegla();
        formaApliFertiRegla3.setIdFormaAplicFertilizante(3);
        formaApliFertiRegla3.setNombreRegla("fertilizar a Cebolla");
        formaApliFertiRegla3.setHortalizaAFertilizar("Cebolla");
        formaApliFertiRegla3.setConclusion("poner a sus raiscessvvvvvvvvvvvvvvvvvvvvvvv de la cebolla");
        //crear
        formaApliFertilizReglaService.createFormaApliFertiRegla(formaApliFertiRegla);
        formaApliFertilizReglaService.createFormaApliFertiRegla(formaApliFertiRegla2);
        formaApliFertilizReglaService.createFormaApliFertiRegla(formaApliFertiRegla3);

        //update
        FormaAplicarFertilizanteRegla formaApliFertiReglaactualizar = new FormaAplicarFertilizanteRegla();
        formaApliFertiReglaactualizar.setIdFormaAplicFertilizante(26);
        formaApliFertiReglaactualizar.setNombreRegla("Forma de aplicar fertilizante berenjena");
        formaApliFertiReglaactualizar.setHortalizaAFertilizar("Berenjena");
        formaApliFertiReglaactualizar.setConclusion("APLICAR A LAS .FFFFFFFFFFFF.....BERENJENA");
        formaApliFertilizReglaService.updateFormaApliFertiRegla(41, formaApliFertiReglaactualizar);

        //delete
        formaApliFertilizReglaService.deleteFormaApliFertiRegla(42);

        formaApliFertilizReglaService.actualizarReglasFormaApliFertiDrl();

        //fin test para forma aplicar fertilizante
    }
}
