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
import java.util.ArrayList;
import model.PotasioRegla;

/**
 *
 * @author Erlinda
 */
public class PotasioReglaService {

    ArrayList<PotasioRegla> listPotasioRegla;

    public PotasioReglaService() {

        listPotasioRegla = new ArrayList<PotasioRegla>();

    }

    public void createPotasioRegla(PotasioRegla newPotasioRegla) {
        listPotasioRegla.add(newPotasioRegla);
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
        PotasioRegla potasioReglaParaActualizar = readPotasioRegla(idPotasioRegla);
        potasioReglaParaActualizar.setNombreRegla(newPotasioRegla.getNombreRegla());
        potasioReglaParaActualizar.setLimiteInferior(newPotasioRegla.getLimiteInferior());
        potasioReglaParaActualizar.setLimiteSuperior(newPotasioRegla.getLimiteSuperior());
        potasioReglaParaActualizar.setConclusion(newPotasioRegla.getConclusion());
    }

    public void deletePotasioRegla(int idPotasioRegla) {
        PotasioRegla potasioReglaEliminar = readPotasioRegla(idPotasioRegla);
        listPotasioRegla.remove(potasioReglaEliminar);
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

    public void mostrarReglasDroolsFormat() {

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
}
