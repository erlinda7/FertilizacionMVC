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
import model.MateriaOrganicaRegla;

/**
 *
 * @author Erlinda
 */
public class MateriaOrganicaReglaService {

    ArrayList<MateriaOrganicaRegla> listMateriaOrganicaRegla;

    public MateriaOrganicaReglaService() {

        listMateriaOrganicaRegla = new ArrayList<MateriaOrganicaRegla>();

    }

    public void createMateriaOrganicaRegla(MateriaOrganicaRegla newMateriaOrganicaRegla) {
        listMateriaOrganicaRegla.add(newMateriaOrganicaRegla);
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
        MateriaOrganicaRegla materiaOrganicaReglaParaActualizar = readMateriaOrganicaRegla(idMateriaOrganicaRegla);
        materiaOrganicaReglaParaActualizar.setNombreRegla(newMateriaOrganicaRegla.getNombreRegla());
        materiaOrganicaReglaParaActualizar.setLimiteInferior(newMateriaOrganicaRegla.getLimiteInferior());
        materiaOrganicaReglaParaActualizar.setLimiteSuperior(newMateriaOrganicaRegla.getLimiteSuperior());
        materiaOrganicaReglaParaActualizar.setConclusion(newMateriaOrganicaRegla.getConclusion());
    }

    public void deleteMateriaOrganicaRegla(int idMateriaOrganicaRegla) {
        MateriaOrganicaRegla materiaOrganicaReglaEliminar = readMateriaOrganicaRegla(idMateriaOrganicaRegla);
        listMateriaOrganicaRegla.remove(materiaOrganicaReglaEliminar);
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

    public void mostrarReglasDroolsFormat() {

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
}
