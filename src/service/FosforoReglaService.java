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
import model.FosforoRegla;

/**
 *
 * @author Erlinda
 */
public class FosforoReglaService {

    ArrayList<FosforoRegla> listFosforoRegla;

    public FosforoReglaService() {

        listFosforoRegla = new ArrayList<FosforoRegla>();

    }

    public void createFosforoRegla(FosforoRegla newFosforoRegla) {
        listFosforoRegla.add(newFosforoRegla);
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
        FosforoRegla fosforoReglaParaActualizar = readFosforoRegla(idFosforoRegla);
        fosforoReglaParaActualizar.setNombreRegla(newFosforoRegla.getNombreRegla());
        fosforoReglaParaActualizar.setLimiteInferior(newFosforoRegla.getLimiteInferior());
        fosforoReglaParaActualizar.setLimiteSuperior(newFosforoRegla.getLimiteSuperior());
        fosforoReglaParaActualizar.setConclusion(newFosforoRegla.getConclusion());
    }

    public void deleteFosforoRegla(int idfosforoRegla) {
        FosforoRegla fosforoReglaEliminar = readFosforoRegla(idfosforoRegla);
        listFosforoRegla.remove(fosforoReglaEliminar);
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

    public void mostrarReglasDroolsFormat() {

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
}
