/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import model.FosforoRegla;
import model.MateriaOrganicaRegla;
import model.NitrogenoRegla;
import model.PhRegla;
import model.PotasioRegla;

/**
 *
 * @author Erlinda
 */
public class MainPruebaReglas {

    public static void main(String[] args) {

        // inicio test para materia organica
        PhReglaService phReglaService = new PhReglaService();

        PhRegla phRegla = new PhRegla();
        phRegla.setIdPhRegla(1);
        phRegla.setNombreRegla("Nivel de ph Muy Alto");
        phRegla.setLimiteInferior(110);
        phRegla.setLimiteSuperior(120);
        phRegla.setConclusion("Muy Alto");

        PhRegla phRegla2 = new PhRegla();
        phRegla2.setIdPhRegla(2);
        phRegla2.setNombreRegla("Nivel de ph Super bajo");
        phRegla2.setLimiteInferior(0);
        phRegla2.setLimiteSuperior(10);
        phRegla2.setConclusion("Super Bajo");

        PhRegla phRegla3 = new PhRegla();
        phRegla3.setIdPhRegla(3);
        phRegla3.setNombreRegla("Nivel de ph Regular");
        phRegla3.setLimiteInferior(30);
        phRegla3.setLimiteSuperior(50);
        phRegla3.setConclusion("Regular");

        phReglaService.createPhRegla(phRegla);
        phReglaService.createPhRegla(phRegla2);
        phReglaService.createPhRegla(phRegla3);

        // update
        PhRegla phReglaactualizar = new PhRegla();
        phReglaactualizar.setIdPhRegla(4);
        phReglaactualizar.setNombreRegla("Nivel de ph xxxxxxxxx");
        phReglaactualizar.setLimiteInferior(30);
        phReglaactualizar.setLimiteSuperior(50);
        phReglaactualizar.setConclusion("xxxxxxxxxxx");

        phReglaService.updatePhRegla(1, phReglaactualizar);

        // delete
        phReglaService.deletePhRegla(3);

        phReglaService.actualizarReglasPHDrl();

        // fin test para MO
    }
}
