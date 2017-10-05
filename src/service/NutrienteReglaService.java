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
import model.NutrienteRegla;

/**
 *
 * @author Erlinda
 */
public class NutrienteReglaService {

    ArrayList<NutrienteRegla> listNutrienteRegla;

    public NutrienteReglaService() {

        listNutrienteRegla = new ArrayList<NutrienteRegla>();

    }

    public void createNutrienteRegla(NutrienteRegla newNutrienteRegla) {
        listNutrienteRegla.add(newNutrienteRegla);
    }

    public NutrienteRegla readNutrienteRegla(int idNutrienteRegla) {
        NutrienteRegla nutrienteReglaRecuperado = null;
        for (int i = 0; i < listNutrienteRegla.size(); i++) {
            if (idNutrienteRegla == listNutrienteRegla.get(i).getIdNutrienteRegla()) {
                nutrienteReglaRecuperado = listNutrienteRegla.get(i);
            }
        }
        return nutrienteReglaRecuperado;

    }

    public void updateNutrienteRegla(int idNutrienteRegla, NutrienteRegla newNutrienteRegla) {
        NutrienteRegla nutrienteReglaParaActualizar=readNutrienteRegla(idNutrienteRegla);
        nutrienteReglaParaActualizar.setNombreRegla(newNutrienteRegla.getNombreRegla());
        nutrienteReglaParaActualizar.setLimiteInferior(newNutrienteRegla.getLimiteInferior());
        nutrienteReglaParaActualizar.setLimiteSuperior(newNutrienteRegla.getLimiteSuperior());
        nutrienteReglaParaActualizar.setConclusion(newNutrienteRegla.getConclusion());
    }

    public void deleteNutrienteRegla(int idNutrienteRegla) {
        NutrienteRegla nutrienteReglaEliminar=readNutrienteRegla(idNutrienteRegla);
        listNutrienteRegla.remove(nutrienteReglaEliminar);
    }

    public void mostrarReglas() {
        for (int i = 0; i < listNutrienteRegla.size(); i++) {
            //System.out.println(listNutrienteRegla.get(i).getNombreRegla());
            System.out.println(listNutrienteRegla.get(i).toString());
        }
    }
    
    public ArrayList<NutrienteRegla> readAllNutrientes(){
    	return listNutrienteRegla;
    	
    }
    
    public void mostrarReglasDroolsFormat(){
    
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
    	File file= new File("./src/main/resources/rules/Nutrientes.drl");
    	try {
			FileOutputStream out= new FileOutputStream(file);
			String importPackage="package rules \nimport model.Cultivo;\n";
			out.write(importPackage.getBytes());
	        for (int i = 0; i < listNutrienteRegla.size(); i++) {
        	
        	String nombreRegla="rule "+"\""+listNutrienteRegla.get(i).getNombreRegla()+"\"\n";
        	out.write(nombreRegla.getBytes());
            String when="    when\n";
            out.write(when.getBytes());
            String condicion="        $c : Cultivo( nivelNitrogeno >= "+listNutrienteRegla.get(i).getLimiteInferior()+" && <="+listNutrienteRegla.get(i).getLimiteSuperior()+" )\n";
            out.write(condicion.getBytes());
            String then="    then\n";
            out.write(then.getBytes());
            String conclusion="        $c.setRangoNivelNitrogeno(\""+listNutrienteRegla.get(i).getConclusion()+"\");\n";
            out.write(conclusion.getBytes());
            String end="end\n\n";
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
