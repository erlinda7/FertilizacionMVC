package matriz;

import java.util.TreeMap;

public class HabaMatriz extends HortalizaMatriz {

	public HabaMatriz(){
		 nitrogeno=new int[][]{
			 					{20,36,52,68,84,108},
			 					{7,23,39,55,71,95},
			 					{-6,11,27,43,59,83},
			 					{-18,-2,14,30,46,70},
			 					{-31,-15,2,18,34,58},
			 					{-43,-27,-11,5,21,45},
			 					{-68,-52,-36,-20,-4,20},
			 					{-93,-77,-61,-45,-29,-5}
							  };
		fosforo=new int[][]{
								{12,32,52,72,92,122},
								{-17,3,23,43,63,93},
								{-45,-25,-5,15,35,65},
								{-74,-54,-34,-14,7,37},
								{-102,-82,-62,-42,-22,8},
								{-130,-110,-90,-70,-50,-20},
								{-187,-167,-147,-127,-107,-77},
								{-244,-224,-204,-184,-164,-134}
						   };
		potasio=new int[][]{
								{58,102,146,190,234,300},
								{28,72,116,160,204,270},
								{-2,42,86,130,174,240},
								{-62,-18,26,70,114,180},
								{-137,-93,-49,-5,39,105},
								{-212,-168,-124,-80,-36,30},
								{-362,-318,-274,-230,-186,-120},
								{-512,-468,-424,-380,-336,-270}
						   };
							
		columnas=new TreeMap<Double, Integer>();
		columnas.put(4.0, 0);
		columnas.put(6.0, 1);
		columnas.put(8.0, 2);
		columnas.put(10.0, 3);
		columnas.put(12.0, 4);
		columnas.put(15.0, 5);
		
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

