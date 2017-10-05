/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import model.NitrogenoRegla;

/**
 *
 * @author Erlinda
 */
public class MainPruebaReglas {
    
      public static void main(String[] args) {
          
          NitrogenoReglaService nitrogenoReglaService=new NitrogenoReglaService();
          
          NitrogenoRegla nitrogenoRegla=new NitrogenoRegla();          
          nitrogenoRegla.setIdNitrogenoRegla(1);
          nitrogenoRegla.setNombreRegla("Nivel de Nitrogeno Muy Alto");
          nitrogenoRegla.setLimiteInferior(110);
          nitrogenoRegla.setLimiteSuperior(120);
          nitrogenoRegla.setConclusion("Muy Alto");
          
          
          
          NitrogenoRegla nitrogenoRegla2=new NitrogenoRegla();          
          nitrogenoRegla2.setIdNitrogenoRegla(2);
          nitrogenoRegla2.setNombreRegla("Nivel de Nitrogeno Super bajo");
          nitrogenoRegla2.setLimiteInferior(0);
          nitrogenoRegla2.setLimiteSuperior(10);
          nitrogenoRegla2.setConclusion("Super Bajo");
          
          NitrogenoRegla nitrogenoRegla3=new NitrogenoRegla();          
          nitrogenoRegla3.setIdNitrogenoRegla(3);
          nitrogenoRegla3.setNombreRegla("Nivel de Nitrogeno Regular");
          nitrogenoRegla3.setLimiteInferior(30);
          nitrogenoRegla3.setLimiteSuperior(50);
          nitrogenoRegla3.setConclusion("Regular");
          
          nitrogenoReglaService.createNitrogenoRegla(nitrogenoRegla);
          nitrogenoReglaService.createNitrogenoRegla(nitrogenoRegla2);
          nitrogenoReglaService.createNitrogenoRegla(nitrogenoRegla3);
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
      

              nitrogenoReglaService.mostrarReglasDroolsFormat();
      }
}
