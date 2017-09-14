package matriz;

import java.util.TreeMap;

public class ColiflorMatriz extends HortalizaMatriz {

	public ColiflorMatriz(){
		 nitrogeno=new int[][]{
			 					{64,103,141,164,188,218},
			 					{52,90,129,152,175,206},
			 					{39,78,116,139,163,193},
			 					{27,65,104,127,150,181},
			 					{14,53,91,114,138,168},
			 					{2,40,79,102,125,156},
			 					{-23,15,54,77,100,131},
			 					{-48,-10,29,52,75,106}
							  };
		fosforo=new int[][]{
								{46,75,104,121,139,162},
								{35,64,93,110,127,150},
								{29,58,87,104,122,145},
								{1,30,59,76,93,116},
								{-27,1,30,48,65,88},
								{-56,-27,2,19,37,60},
								{-113,-84,-55,-38,-20,3},
								{-226,-197,-168,-151,-134,-111}
						   };
		potasio=new int[][]{
								{66,114,162,191,220,258},
								{36,84,132,161,190,228},
								{6,54,102,131,160,198},
								{-54,-6,42,71,100,138},
								{-129,-81,-33,-4,25,63},
								{-204,-156,-108,-79,-50,-12},
								{-354,-306,-258,-229,-200,-162},
								{-504,-456,-408,-379,-350,-312}
						   };
							
		columnas=new TreeMap<Double, Integer>();
		columnas.put(10.0, 0);
		columnas.put(15.0, 1);
		columnas.put(20.0, 2);
		columnas.put(23.0, 3);
		columnas.put(26.0, 4);
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
		filasP.put(2, 0);
		filasP.put(4, 1);
		filasP.put(5, 2);
		filasP.put(10, 3);
		filasP.put(15, 4);
		filasP.put(20, 5);
		filasP.put(30, 6);
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

