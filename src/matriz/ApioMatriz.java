package matriz;

import java.util.TreeMap;

public class ApioMatriz extends HortalizaMatriz {

	public ApioMatriz(){
		 nitrogeno=new int[][]{
			 					{38,54,71,96,121,154},
			 					{25,42,58,83,108,142},
			 					{13,29,46,71,96,129},
			 					{0,17,33,58,83,117},
			 					{-13,4,21,46,71,104},
			 					{-25,-8,8,33,58,92},
			 					{-50,-33,-17,8,33,67},
			 					{-75,-58,-42,-17,8,42}
							  };
		fosforo=new int[][]{
							{55,83,111,152,194,249},
							{27,54,82,124,165,221},
							{-2,26,54,95,137,193},
							{-30,-2,25,67,109,164},
							{-59,-31,-3,39,80,136},
							{-87,-59,-31,10,52,108},
							{-144,-116,-88,-46,-5,51},
							{-200,-173,-145,-103,-62,-6}
						   };
		potasio=new int[][]{
							{70,103,137,187,237,303},
							{40,73,107,157,207,273},
							{10,43,77,127,177,243},
							{-50,-17,17,67,117,183},
							{-125,-92,-58,-8,42,108},
							{-200,-167,-133,-83,-33,33},
							{-350,-317,-283,-233,-183,-117},
							{-500,-476,-433,-383,-333,-267}
						   };
							
		columnas=new TreeMap<Double, Integer>();
		columnas.put(6.0, 0);
		columnas.put(8.0, 1);
		columnas.put(10.0, 2);
		columnas.put(13.0, 3);
		columnas.put(16.0, 4);
		columnas.put(20.0, 5);
		
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

