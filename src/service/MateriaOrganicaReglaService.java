package service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import model.MateriaOrganicaRegla;
import model.NutrienteRegla;

public class MateriaOrganicaReglaService {

	ArrayList<MateriaOrganicaRegla> listMateriaOrganicaRegla;

	public MateriaOrganicaReglaService() {

		listMateriaOrganicaRegla = new ArrayList<MateriaOrganicaRegla>();

	}

	public void createMateriaOrganicaRegla(MateriaOrganicaRegla newMateriaOrganicaRegla) {
		listMateriaOrganicaRegla.add(newMateriaOrganicaRegla);
	}

	public MateriaOrganicaRegla readMateriaOrganicaRegla(int idNutrienteReglaMO) {
		MateriaOrganicaRegla materiaOrganicaReglaRecuperado = null;
		for (int i = 0; i < listMateriaOrganicaRegla.size(); i++) {
			if (idNutrienteReglaMO == listMateriaOrganicaRegla.get(i).getIdMoRegla()) {
				materiaOrganicaReglaRecuperado = listMateriaOrganicaRegla.get(i);
			}
		}
		return materiaOrganicaReglaRecuperado;

	}

	public void updateMateriaOrganicaRegla(int idNutrienteReglaMO, MateriaOrganicaRegla newMateriaOrganicaRegla) {
		MateriaOrganicaRegla MOReglaParaActualizar = readMateriaOrganicaRegla(idNutrienteReglaMO);
		MOReglaParaActualizar.setNombreReglaMO(newMateriaOrganicaRegla.getNombreReglaMO());
		MOReglaParaActualizar.setLimiteInferiorMO(newMateriaOrganicaRegla.getLimiteInferiorMO());
		MOReglaParaActualizar.setLimiteSuperiorMO(newMateriaOrganicaRegla.getLimiteSuperiorMO());
		MOReglaParaActualizar.setConclusionMO(newMateriaOrganicaRegla.getConclusionMO());
	}

	public void deleteMateriaOrganicaRegla(int idNutrienteReglaMO) {
		MateriaOrganicaRegla MOReglaEliminar = readMateriaOrganicaRegla(idNutrienteReglaMO);
		listMateriaOrganicaRegla.remove(MOReglaEliminar);
	}

	public void mostrarReglasDroolsFormat() {
		File file = new File("./src/main/resources/rules/MateriaOrganica2.drl");
		try {
			FileOutputStream out = new FileOutputStream(file);
			String importPackage = "package rules \nimport model.Cultivo;\n";
			out.write(importPackage.getBytes());
			for (int i = 0; i < listMateriaOrganicaRegla.size(); i++) {

				String nombreRegla = "rule " + "\"" + listMateriaOrganicaRegla.get(i).getNombreReglaMO() + "\"\n";
				out.write(nombreRegla.getBytes());
				String when = "    when\n";
				out.write(when.getBytes());
				String condicion = "        $c : Cultivo( nivelMO >= "
						+ listMateriaOrganicaRegla.get(i).getLimiteInferiorMO() + " && <="
						+ listMateriaOrganicaRegla.get(i).getLimiteSuperiorMO() + " )\n";
				out.write(condicion.getBytes());
				String then = "    then\n";
				out.write(then.getBytes());
				String conclusion = "        $c.setRangoNivelMO(\"" + listMateriaOrganicaRegla.get(i).getConclusionMO()
						+ "\");\n";
				out.write(conclusion.getBytes());
				String end = "end\n\n";
				out.write(end.getBytes());
			}
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
