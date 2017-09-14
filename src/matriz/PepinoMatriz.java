package matriz;

import java.util.TreeMap;

public class PepinoMatriz extends HortalizaMatriz {

	public PepinoMatriz(){
		 nitrogeno=new int[][]{
			 					{46,61,83,113,135,172},
			 					{34,49,71,100,122,159},
			 					{21,36,58,88,110,147},
			 					{9,24,46,75,97,134},
			 					{-4,11,33,63,85,122},
			 					{-16,-1,21,50,72,109},
			 					{-46,-26,-4,25,47,84},
			 					{-66,-51,-29,0,22,59}
							  };
		fosforo=new int[][]{
								{47,66,95,133,161,208},
								{19,38,66,104,133,180},
								{-9,10,38,76,104,152},
								{-38,-19,10,48,76,123},
								{-66,-47,-19,19,48,95},
								{-94,-76,-47,-9,19,67},
								{-151,-132,-104,-66,-38,10},
								{-208,-189,-161,-123,-94,-47}
							};
		potasio=new int[][]{
								{54,75,107,149,181,233},
								{24,45,77,119,151,203},
								{-6,15,47,89,121,173},
								{-66,-45,-13,29,61,113},
								{-141,-120,-88,-46,-14,38},
								{-216,-195,-163,-121,-89,-37},
								{-366,-345,-313,-271,-239,-187},
								{-516,-495,-463,-421,-389,-337}
							};
							
		columnas=new TreeMap<Double, Integer>();
		columnas.put(8.0, 0);
		columnas.put(10.0, 1);
		columnas.put(13.0, 2);
		columnas.put(17.0, 3);
		columnas.put(20.0, 4);
		columnas.put(25.0, 5);
		
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

