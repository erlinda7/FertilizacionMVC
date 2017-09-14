package matriz;

import java.util.TreeMap;

public class CebollaMatriz extends HortalizaMatriz {

	public CebollaMatriz(){
		 nitrogeno=new int[][]{
			 					{48,78,108,126,150,168},
			 					{35,65,95,113,137,155},
			 					{23,53,83,101,125,143},
			 					{10,40,70,88,112,130},
			 					{-3,28,58,76,100,118},
			 					{-15,15,45,63,87,105},
			 					{-40,-10,20,38,62,80},
			 					{-65,-35,-5,13,37,55}
							  };
		fosforo=new int[][]{
								{57,99,142,167,201,227},
								{28,71,113,139,173,198},
								{0,42,85,110,144,170},
								{-29,14,57,82,116,142},
								{-57,-14,28,54,88,113},
								{-85,-43,0,25,59,85},
								{-142,-100,-57,-32,3,28},
								{-199,-156,-144,-88,-54,-29}
						   };
		potasio=new int[][]{
								{70,120,170,200,240,270},
								{40,90,140,170,210,240},
								{10,60,110,140,180,210},
								{-50,0,50,80,120,150},
								{-125,-75,-25,5,45,75},
								{-200,-150,-100,-70,-30,0},
								{-350,-300,-250,-220,-180,-150},
								{-500,-450,-400,-370,-330,-300}
						   };
							
		columnas=new TreeMap<Double, Integer>();
		columnas.put(10.0, 0);
		columnas.put(15.0, 1);
		columnas.put(20.0, 2);
		columnas.put(23.0, 3);
		columnas.put(27.0, 4);
		columnas.put(30.0, 5);
		
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

