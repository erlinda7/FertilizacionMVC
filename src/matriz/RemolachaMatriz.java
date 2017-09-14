package matriz;

import java.util.TreeMap;

public class RemolachaMatriz extends HortalizaMatriz {

	public RemolachaMatriz(){
		 nitrogeno=new int[][]{
			 					{63,88,113,138,188,238},
			 					{50,75,100,125,175,225},
			 					{38,63,88,113,163,213},
			 					{25,50,75,100,150,200},
			 					{13,38,63,88,138,188},
			 					{0,25,50,75,125,175},
			 					{-25,0,25,50,100,150},
			 					{-50,-25,0,25,75,125}
							  };
		fosforo=new int[][]{
								{20,36,52,68,100,132},
								{-9,7,23,39,71,103},
								{-37,-21,-5,11,43,75},
								{-66,-50,-34,-18,15,47},
								{-94,-78,-62,-46,-14,18},
								{-122,-106,-90,-74,-42,-10},
								{-179,-163,-147,-131,-99,-67},
								{-236,-220,-204,-188,-156,-124}
							};
		potasio=new int[][]{
								{60,90,120,150,210,270},
								{30,60,90,120,180,240},
								{0,30,60,90,150,210},
								{-60,-30,0,30,90,150},
								{-135,-105,-75,-45,15,75},
								{-210,-180,-150,-120,-60,0},
								{-360,-330,-300,-270,-210,-150},
								{-510,-480,-450,-420,-360,-300}
							};
							
		columnas=new TreeMap<Double, Integer>();
		columnas.put(15.0, 0);
		columnas.put(20.0, 1);
		columnas.put(25.0, 2);
		columnas.put(30.0, 3);
		columnas.put(40.0, 4);
		columnas.put(50.0, 5);
		
		filasN=new TreeMap<Integer, Integer>();
		filasN.put(5, 0);
		filasN.put(10, 1);
		filasN.put(15, 2);
		filasN.put(20, 3);
		filasN.put(25, 4);
		filasN.put(30, 5);
		filasN.put(40, 6);
		filasN.put(50, 7);
		
		filasP=new TreeMap<Integer, Integer>();
		filasP.put(5, 0);
		filasP.put(10, 1);
		filasP.put(15, 2);
		filasP.put(20, 3);
		filasP.put(25, 4);
		filasP.put(30, 5);
		filasP.put(40, 6);
		filasP.put(50, 7);
		
		filasK=new TreeMap<Integer, Integer>();
		filasK.put(10, 0);
		filasK.put(20, 1);
		filasK.put(30, 2);
		filasK.put(50, 3);
		filasK.put(75, 4);
		filasK.put(100, 5);
		filasK.put(150, 6);
		filasK.put(200, 7);
	}
	
	
	
	
}

