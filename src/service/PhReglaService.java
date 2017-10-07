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
import model.PhRegla;

public class PhReglaService {

    ArrayList<PhRegla> listPhRegla;
    private final String tabla = "ph_regla";

    public PhReglaService() {

        listPhRegla = recuperarListaPHRegla();
    }

    public void createPhRegla(PhRegla newPhRegla) {
        try {
            listPhRegla.add(newPhRegla);
            PreparedStatement consulta;
            Connection conexion = Conexion.obtener();
            consulta = conexion.prepareStatement("INSERT INTO " + this.tabla + "(nombre_regla, limite_inferior, limite_superior, conclusion) VALUES(?, ?, ?, ?)");
            consulta.setString(1, newPhRegla.getNombreRegla());
            consulta.setInt(2, newPhRegla.getLimiteInferior());
            consulta.setInt(3, newPhRegla.getLimiteSuperior());
            consulta.setString(4, newPhRegla.getConclusion());

            consulta.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PhReglaService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public PhRegla readPhRegla(int idPhRegla) {
        PhRegla phReglaRecuperado = null;
        for (int i = 0; i < listPhRegla.size(); i++) {
            if (idPhRegla == listPhRegla.get(i).getIdPhRegla()) {
                phReglaRecuperado = listPhRegla.get(i);
            }
        }
        return phReglaRecuperado;

    }

    public void updatePhRegla(int idPhRegla, PhRegla newPhRegla) {
        try {
        PhRegla phReglaParaActualizar = readPhRegla(idPhRegla);
        phReglaParaActualizar.setNombreRegla(newPhRegla.getNombreRegla());
        phReglaParaActualizar.setLimiteInferior(newPhRegla.getLimiteInferior());
        phReglaParaActualizar.setLimiteSuperior(newPhRegla.getLimiteSuperior());
        phReglaParaActualizar.setConclusion(newPhRegla.getConclusion());
        
        PreparedStatement consultaupdate;
            Connection conexion = Conexion.obtener();
            consultaupdate = conexion.prepareStatement("UPDATE " + this.tabla + " SET nombre_regla = ?, limite_inferior = ?, limite_superior = ?, conclusion = ? WHERE id_ph_regla = ?");
            consultaupdate.setString(1, newPhRegla.getNombreRegla());
            consultaupdate.setInt(2, newPhRegla.getLimiteInferior());
            consultaupdate.setInt(3, newPhRegla.getLimiteSuperior());
            consultaupdate.setString(4, newPhRegla.getConclusion());
            consultaupdate.setInt(5, idPhRegla);

            consultaupdate.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(PhReglaService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deletePhRegla(int idPhRegla) {
        try {
        PhRegla phReglaEliminar = readPhRegla(idPhRegla);
        listPhRegla.remove(phReglaEliminar);
        PreparedStatement consulta;
            Connection conexion = Conexion.obtener();
            consulta = conexion.prepareStatement("DELETE FROM " + this.tabla + " WHERE id_ph_regla = " + idPhRegla);
            consulta.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PhReglaService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void mostrarReglas() {
        for (int i = 0; i < listPhRegla.size(); i++) {
            //System.out.println(listNutrienteRegla.get(i).getNombreRegla());
            System.out.println(listPhRegla.get(i).toString());
        }
    }

    public ArrayList<PhRegla> readAllPh() {
        return listPhRegla;

    }

    public void actualizarReglasPHDrl() {

        File file = new File("./src/main/resources/rules/Ph2.drl");
        try {
            FileOutputStream out = new FileOutputStream(file);
            String importPackage = "package rules \nimport model.Cultivo;\n";
            out.write(importPackage.getBytes());
            for (int i = 0; i < listPhRegla.size(); i++) {

                String nombreRegla = "rule " + "\"" + listPhRegla.get(i).getNombreRegla() + "\"\n";
                out.write(nombreRegla.getBytes());
                String when = "    when\n";
                out.write(when.getBytes());
                String condicion = "        $c : Cultivo( nivelpH >= " + listPhRegla.get(i).getLimiteInferior() + " && <=" + listPhRegla.get(i).getLimiteSuperior() + " )\n";
                out.write(condicion.getBytes());
                String then = "    then\n";
                out.write(then.getBytes());
                String conclusion = "        $c.setTipoSuelo(\"" + listPhRegla.get(i).getConclusion() + "\");\n";
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
      public ArrayList<PhRegla> recuperarListaPHRegla() {
        Connection conexion = Conexion.obtener();
        ArrayList<PhRegla> phReglaLista = new ArrayList<PhRegla>();
        try {
            PreparedStatement consulta = conexion.prepareStatement("SELECT id_ph_regla, nombre_regla, limite_inferior, limite_superior, conclusion FROM " + this.tabla + " ORDER BY id_ph_regla");
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                phReglaLista.add(new PhRegla(resultado.getInt("id_ph_regla"), resultado.getString("nombre_regla"), resultado.getInt("limite_inferior"), resultado.getInt("limite_superior"), resultado.getString("conclusion")));
            }
            //System.out.println("cantidad reglas: " + potasioReglaLista.size());
        } catch (SQLException ex) {
            Logger.getLogger(PhReglaService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return phReglaLista;
    }
}
