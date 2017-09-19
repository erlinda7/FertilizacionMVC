package matriz;

import java.util.TreeMap;

public class RabanoMatriz extends HortalizaMatriz {

    public RabanoMatriz() {
        nitrogeno = new int[][]{
            {38, 51, 70, 89, 114, 145},
            {26, 38, 57, 76, 101, 133},
            {13, 26, 45, 64, 89, 120},
            {1, 13, 32, 51, 76, 108},
            {-12, 1, 20, 39, 64, 95},
            {-24, -12, 7, 26, 51, 83},
            {-49, -37, -18, 1, 26, 58},
            {-74, -62, -43, -24, 1, 33}
        };
        fosforo = new int[][]{
            {14, 24, 40, 56, 77, 103},
            {-15, -4, 12, 27, 49, 75},
            {-43, -32, -17, -1, 20, 46},
            {-71, -61, -45, -29, -8, 18},
            {-100, -89, -73, -58, -37, -10},
            {-128, -118, -102, -86, -65, -39},
            {-185, -174, -159, -143, -122, -95},
            {-242, -231, -215, -200, -178, -152}
        };
        potasio = new int[][]{
            {65, 88, 124, 159, 207, 266},
            {35, 58, 94, 129, 177, 236},
            {5, 28, 64, 99, 147, 206},
            {-55, -32, 4, 39, 87, 146},
            {-130, -107, -71, -36, 12, 71},
            {-205, -182, -146, -111, -63, -4},
            {-355, -332, -296, -261, -213, -154},
            {-505, -482, -446, -411, -363, -304}
        };

        columnas = new TreeMap<Double, Integer>();
        columnas.put(8.0, 0);
        columnas.put(10.0, 1);
        columnas.put(13.0, 2);
        columnas.put(16.0, 3);
        columnas.put(20.0, 4);
        columnas.put(25.0, 5);

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
