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
import model.NitrogenoRegla;

/**
 *
 * @author Erlinda
 */
public class NitrogenoReglaService {

    ArrayList<NitrogenoRegla> listNitrogenoRegla;

    public NitrogenoReglaService() {

        listNitrogenoRegla = new ArrayList<NitrogenoRegla>();

    }

    public void createNitrogenoRegla(NitrogenoRegla newNitrogenoRegla) {
        listNitrogenoRegla.add(newNitrogenoRegla);
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
        NitrogenoRegla nitrogenoReglaEliminar = readNitrogenoRegla(idNitrogenoRegla);
        listNitrogenoRegla.remove(nitrogenoReglaEliminar);
    }

    public void mostrarReglas() {
        for (int i = 0; i < listNitrogenoRegla.size(); i++) {
            //System.out.println(listNutrienteRegla.get(i).getNombreRegla());
            System.out.println(listNitrogenoRegla.get(i).toString());
        }
    }

    public ArrayList<NitrogenoRegla> readAllNutrientes() {
        return listNitrogenoRegla;

    }

    public void mostrarReglasDroolsFormat() {

//        for (int i = 0; i < listNutrienteRegla.size(); i++) {
//        	
//        	String nombreRegla="Rule "+"\""+listNutrienteRegla.get(i).getNombreRegla()+"\"\n";
//            System.out.print(nombreRegla);
//            String when="    when\n";
//            System.out.print(when);
//            String condicion="        $c : Cultivo( nivelNitrogeno >= "+listNutrienteRegla.get(i).getLimiteInferior()+" && <="+listNutrienteRegla.get(i).getLimiteSuperior()+" )\n";
//            System.out.print(condicion);
//            String then="    then\n";
//            System.out.print(then);
//            String conclusion="        $c.setRangoNivelNitrogeno(\""+listNutrienteRegla.get(i).getConclusion()+"\");\n";
//            System.out.print(conclusion);
//            String end="end\n";
//            System.out.print(end);
//            System.out.print("\n");
//        }
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
}
