package matriz;

import java.util.TreeMap;

public class VainitaMatriz extends HortalizaMatriz {

	public VainitaMatriz(){
		 nitrogeno=new int[][]{
			 					{28,38,48,68,88,108},
			 					{15,25,35,55,75,95},
			 					{3,13,23,43,63,83},
			 					{-10,0,10,30,50,70},
			 					{-23,-13,-3,18,38,58},
			 					{-35,-25,-15,5,25,45},
			 					{-60,-50,-40,-20,0,20},
			 					{-85,-75,-65,-45,-25,-5}
							  };
		fosforo=new int[][]{
								{20,32,44,68,92,116},
								{-9,3,15,39,63,87},
								{-37,-25,-13,11,35,59},
								{-66,-54,-42,-18,7,31},
								{-94,-82,-70,-46,-22,2},
								{-122,-110,-98,-74,-50,-26},
								{-179,-167,-155,-131,-107,-83},
								{-236,-224,-212,-188,-164,-140}
							};
		potasio=new int[][]{
								{18,30,42,66,90,114},
								{-12,0,12,36,60,84},
								{-42,-30,-18,6,30,54},
								{-102,-90,-78,-54,-30,-6},
								{-177,-165,-153,-129,-105,-81},
								{-252,-240,-228,-204,-180,-156},
								{-402,-390,-378,-354,-330,-306},
								{-552,-540,-528,-504,-480,-456}
							};
							
		columnas=new TreeMap<Double, Integer>();
		columnas.put(2.0, 0);
		columnas.put(2.5, 1);
		columnas.put(3.0, 2);
		columnas.put(4.0, 3);
		columnas.put(5.0, 4);
		columnas.put(6.0, 5);
		
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

