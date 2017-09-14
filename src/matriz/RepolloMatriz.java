package matriz;

import java.util.TreeMap;

public class RepolloMatriz extends HortalizaMatriz {

	public RepolloMatriz(){
		 nitrogeno=new int[][]{
			 					{52,74,96,117,161,204},
			 					{40,62,83,105,148,191},
			 					{27,49,71,92,136,179},
			 					{15,37,58,80,123,166},
			 					{2,24,46,67,111,154},
			 					{-10,12,33,55,98,141},
			 					{-35,-14,8,30,73,116},
			 					{-60,-39,-17,5,48,91}
							  };
		fosforo=new int[][]{
								{11,24,37,50,77,103},
								{-17,-4,9,22,48,75},
								{-46,-33,-20,-6,20,46},
								{-74,-61,-48,-35,-9,18},
								{-103,-89,-76,-63,-37,-11},
								{-131,-118,-105,-92,-65,-39},
								{-188,-175,-161,-148,-122,-96},
								{-244,-231,-218,-205,-179,-153}
							};
		potasio=new int[][]{
								{38,61,84,107,152,198},
								{8,31,54,77,122,168},
								{-22,1,24,47,92,138},
								{-82,-59,-36,-14,32,78},
								{-157,-134,-111,-89,-43,3},
								{-232,-209,-186,-164,-118,-73},
								{-382,-359,-336,-314,-268,-223},
								{-532,-509,-486,-464,-418,-373}
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

