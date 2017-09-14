package matriz;

import java.util.TreeMap;

public class TomateMatriz extends HortalizaMatriz {

	public TomateMatriz(){
		 nitrogeno=new int[][]{
			 					{81,113,144,175,238,300},
			 					{69,100,131,163,225,288},
			 					{56,88,119,150,213,275},
			 					{44,75,106,138,200,263},
			 					{31,63,94,125,188,250},
			 					{19,50,81,113,175,238},
			 					{-6,25,56,88,150,213},
			 					{-31,0,31,63,125,188}
							  };
		fosforo=new int[][]{
								{32,52,72,92,132,172},
								{3,23,43,63,103,143},
								{-25,-5,15,35,75,115},
								{-54,-34,-14,7,47,87},
								{-82,-62,-42,-22,18,58},
								{-110,-90,-70,-50,-10,30},
								{-167,-147,-127,-107,-67,-27},
								{-224,-204,-184,-164,-124,-84}
							};
		potasio=new int[][]{
								{45,70,95,120,170,220},
								{15,40,65,90,140,190},
								{-15,10,35,60,110,160},
								{-75,-50,-25,0,50,100},
								{-150,-125,-100,-75,-25,25},
								{-225,-200,-175,-150,-100,-50},
								{-375,-350,-325,-300,-250,-200},
								{-525,-500,-475,-450,-400,-350}
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

