package matriz;

import java.util.TreeMap;

public class ArvejaMatriz extends HortalizaMatriz {

    public ArvejaMatriz() {
        nitrogeno = new int[][]{
            {54, 71, 88, 104, 121, 138},
            {42, 58, 75, 92, 108, 125},
            {29, 46, 63, 79, 96, 113},
            {17, 33, 50, 67, 83, 100},
            {4, 21, 38, 54, 71, 88},
            {-8, 8, 25, 42, 58, 75},
            {-33, -17, 0, 17, 33, 50},
            {-58, -42, -25, -8, 8, 25}
        };
        fosforo = new int[][]{
            {52, 72, 92, 112, 132, 152},
            {23, 43, 63, 83, 103, 123},
            {-5, 15, 35, 55, 75, 95},
            {-34, -14, 7, 27, 47, 67},
            {-62, -42, -22, -2, 18, 38},
            {-90, -70, -50, -30, -10, 10},
            {-147, -127, -107, -87, -67, -47},
            {-204, -184, -164, -144, -124, -104}
        };
        potasio = new int[][]{
            {57, 78, 100, 122, 143, 165},
            {27, 48, 70, 92, 113, 135},
            {-3, 18, 40, 62, 83, 105},
            {-63, -42, -20, 2, 23, 45},
            {-138, -117, -95, -73, -52, -30},
            {-213, -192, -170, -148, -127, -105},
            {-363, -342, -320, -298, -277, -255},
            {-513, -492, -470, -448, -427, -405}
        };

        columnas = new TreeMap<Double, Integer>();
        columnas.put(2.0, 0);
        columnas.put(2.5, 1);
        columnas.put(3.0, 2);
        columnas.put(3.5, 3);
        columnas.put(4.0, 4);
        columnas.put(4.5, 5);

        filasN = new TreeMap<Integer, Integer>();
        filasN.put(5, 0);
        filasN.put(10, 1);
        filasN.put(15, 2);
        filasN.put(20, 3);
        filasN.put(25, 4);
        filasN.put(30, 5);
        filasN.put(40, 6);
        filasN.put(50, 7);

        filasP = new TreeMap<Integer, Integer>();
        filasP.put(5, 0);
        filasP.put(10, 1);
        filasP.put(15, 2);
        filasP.put(20, 3);
        filasP.put(25, 4);
        filasP.put(30, 5);
        filasP.put(40, 6);
        filasP.put(50, 7);

        filasK = new TreeMap<Integer, Integer>();
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
