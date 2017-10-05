/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import model.NutrienteRegla;

/**
 *
 * @author Erlinda
 */
public class MainPruebaReglas {
    
      public static void main(String[] args) {
          
          NutrienteReglaService nutrienteReglaService=new NutrienteReglaService();
          
          NutrienteRegla nutrienteRegla=new NutrienteRegla();          
          nutrienteRegla.setIdNutrienteRegla(1);
          nutrienteRegla.setNombreRegla("Nivel de Nitrogeno Muy Alto");
          nutrienteRegla.setLimiteInferior(110);
          nutrienteRegla.setLimiteSuperior(120);
          nutrienteRegla.setConclusion("Muy Alto");
          nutrienteRegla.setNombreNutriente("Nitrogeno");
          
          
          
          NutrienteRegla nutrienteRegla2=new NutrienteRegla();          
          nutrienteRegla2.setIdNutrienteRegla(2);
          nutrienteRegla2.setNombreRegla("Nivel de Nitrogeno Super bajo");
          nutrienteRegla2.setLimiteInferior(0);
          nutrienteRegla2.setLimiteSuperior(10);
          nutrienteRegla2.setConclusion("Super Bajo");
          nutrienteRegla2.setNombreNutriente("Nitrogeno");
          
          NutrienteRegla nutrienteRegla3=new NutrienteRegla();          
          nutrienteRegla3.setIdNutrienteRegla(3);
          nutrienteRegla3.setNombreRegla("Nivel de Nitrogeno Regular");
          nutrienteRegla3.setLimiteInferior(30);
          nutrienteRegla3.setLimiteSuperior(50);
          nutrienteRegla3.setConclusion("Regular");
          nutrienteRegla3.setNombreNutriente("Nitrogeno");
          
          nutrienteReglaService.createNutrienteRegla(nutrienteRegla);
          nutrienteReglaService.createNutrienteRegla(nutrienteRegla2);
          nutrienteReglaService.createNutrienteRegla(nutrienteRegla3);
          ///test para create
         // nutrienteReglaService.mostrarReglas();
         //test para read
//         NutrienteRegla resultadoLeer=nutrienteReglaService.readNutrienteRegla(1);
//         System.out.println(resultadoLeer.getNombreRegla());

            //test para actualizar
//            NutrienteRegla nutrienteReglaActualizar=new NutrienteRegla();
//            nutrienteReglaActualizar.setNombreRegla("XYZ");
//            nutrienteReglaActualizar.setLimiteInferior(00);
//            nutrienteReglaActualizar.setLimiteSuperior(1111);
//            nutrienteReglaActualizar.setConclusion("Actualizando regla XYZ");
//            
//            nutrienteReglaService.updateNutrienteRegla(1, nutrienteReglaActualizar);
//            nutrienteReglaService.mostrarReglas();

            //test para eliminar
//            nutrienteReglaService.deleteNutrienteRegla(2);
//            nutrienteReglaService.deleteNutrienteRegla(1);
//            nutrienteReglaService.mostrarReglas();
      

              nutrienteReglaService.mostrarReglasDroolsFormat();
      }
}
