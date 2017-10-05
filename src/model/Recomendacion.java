package model;

import java.util.ArrayList;

public class Recomendacion {
	private ArrayList<String> fertilizanteN;
	private ArrayList<String> fertilizanteP;
	private ArrayList<String> fertilizanteK;
	
	public Recomendacion(){
		fertilizanteN= new ArrayList<String>();
		fertilizanteP= new ArrayList<String>();
		fertilizanteK= new ArrayList<String>();
	}
	public void addFertilizanteN(String fertilizantN){
		fertilizanteN.add(fertilizantN);
	}
	public void addFertilizanteP(String fertilizantP){
		fertilizanteP.add(fertilizantP);
	}
	public void addFertilizanteK(String fertilizantK){
		fertilizanteK.add(fertilizantK);
	}		
	
	public ArrayList<String> getFertilizanteN() {
		return fertilizanteN;
	}
	public ArrayList<String> getFertilizanteP() {
		return fertilizanteP;
	}
	public ArrayList<String> getFertilizanteK() {
		return fertilizanteK;
	}
	@Override
	public String toString() {
		String res = "";
		res = res +"\tFertilizantes nitrogenados:\n";
		for (int i = 0; i < fertilizanteN.size(); i++) {
			res = res +"\t\t"+"Opcion "+(i+1)+":  "+fertilizanteN.get(i)+"\n";
		}
		res = res +"\tFertilizantes fosfatados:\n";
		for (int i = 0; i < fertilizanteP.size(); i++) {
			res = res +"\t\t"+"Opcion "+(i+1)+":  "+fertilizanteP.get(i)+"\n";
		}
		res = res +"\tFertilizantes potasicos:\n";
		for (int i = 0; i < fertilizanteK.size(); i++) {
			res = res +"\t\t"+"Opcion "+(i+1)+":  "+fertilizanteK.get(i)+"\n";
		}
		return res;
	}
}
