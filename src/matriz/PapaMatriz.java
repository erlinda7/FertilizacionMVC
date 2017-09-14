package matriz;


import java.util.TreeMap;

public class PapaMatriz extends HortalizaMatriz {


	public PapaMatriz(){
		super();
		 nitrogeno=new int[][]{
				 		{30,51,73,94,115,158},
				 		{18,39,60,81,103,145},
				 		{5,26,48,69,90,133},
				 		{-8,14,35,56,78,120},
				 		{-20,1,23,44,65,108},
				 		{-33,-11,10,31,53,95},
				 		{-58,-36,-15,6,28,70},
				 		{-83,-61,-40,-19,3,45}
						};
		fosforo=new int[][]{
							{-6,5,17,28,39,62},
							{-34,-23,-12,-1,11,33},
							{-63,-51,-40,-29,-18,5},
							{-91,-80,-69,-57,-46,-24},
							{-119,-108,-97,-86,-74,-52},
							{-148,-137,-125,-114,-103,-80},
							{-205,-193,-182,-171,-160,-137},
							{-261,-250,-239,-228,-216,-194}
							};
		potasio=new int[][]{
							{33,64,95,126,158,220},
							{3,34,65,96,128,190},
							{-28,4,35,66,98,160},
							{-88,-56,-25,6,38,100},
							{-163,-131,-100,-69,-38,25},
							{-238,-206,-175,-144,-113,-50},
							{-388,-356,-325,-294,-263,-200},
							{-538,-506,-475,-444,-413,-350}
							};
							
		columnas=new TreeMap<Double, Integer>();
		columnas.put(10.0,0);
		columnas.put(15.0,1);
		columnas.put(20.0, 2);
		columnas.put(25.0, 3);
		columnas.put(30.0, 4);
		columnas.put(40.0, 5);
		
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

