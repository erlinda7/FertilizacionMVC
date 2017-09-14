package matriz;

import java.util.TreeMap;

public class ZanahoriaMatriz extends HortalizaMatriz {

	public ZanahoriaMatriz(){
		 nitrogeno=new int[][]{
			 					{88,118,148,188,238,288},
			 					{75,105,135,175,225,275},
			 					{63,93,123,163,213,263},
			 					{50,80,110,150,200,250},
			 					{38,68,98,138,188,238},
			 					{25,55,85,125,175,225},
			 					{0,30,60,100,150,200},
			 					{-25,5,35,75,125,175}
							  };
		fosforo=new int[][]{
								{52,76,100,132,172,212},
								{23,47,71,103,143,183},
								{-5,19,43,75,115,155},
								{-34,-10,15,47,87,127},
								{-62,-38,-14,18,58,98},
								{-90,-66,-42,-10,30,70},
								{-147,-123,-99,-67,-27,13},
								{-204,-180,-156,-124,-84,-44}
							};
		potasio=new int[][]{
								{110,152,194,250,320,390},
								{80,122,164,220,290,360},
								{50,92,134,190,260,330},
								{-10,32,74,130,200,270},
								{-85,-43,-1,55,125,195},
								{-160,-118,-76,-20,50,120},
								{-310,-268,-226,-170,-100,-30},
								{-460,-418,-376,-320,-250,-180}
							};
							
		columnas=new TreeMap<Double, Integer>();
		columnas.put(10.0, 0);
		columnas.put(13.0, 1);
		columnas.put(16.0, 2);
		columnas.put(20.0, 3);
		columnas.put(25.0, 4);
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

