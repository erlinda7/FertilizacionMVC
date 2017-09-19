package matriz;

import java.util.TreeMap;

public class BerenjenaMatriz extends HortalizaMatriz {

    public BerenjenaMatriz() {
        nitrogeno = new int[][]{
            {18, 33, 49, 64, 79, 95},
            {6, 21, 36, 52, 67, 82},
            {-7, 8, 24, 39, 54, 70},
            {-19, -4, 11, 27, 42, 57},
            {-32, -17, -1, 14, 29, 45},
            {-44, -29, -14, 2, 17, 32},
            {-69, -54, -39, -23, -8, 7},
            {-94, -79, -64, -48, -33, -18}
        };
        fosforo = new int[][]{
            {33, 64, 94, 125, 155, 186},
            {5, 35, 66, 96, 127, 158},
            {-24, 7, 37, 68, 99, 129},
            {-52, -22, 9, 40, 70, 101},
            {-81, -50, -19, 11, 42, 73},
            {-109, -78, -48, -17, 14, 44},
            {-166, -135, -105, -74, -43, -13},
            {-223, -192, -161, -131, -100, -69}
        };
        potasio = new int[][]{
            {39, 73, 108, 142, 176, 211},
            {9, 43, 78, 112, 146, 181},
            {-21, 13, 48, 82, 116, 151},
            {-81, -47, -13, 22, 56, 91},
            {-156, -122, -88, -53, -19, 16},
            {-231, -197, -163, -128, -94, -59},
            {-381, -347, -313, -278, -244, -209},
            {-531, -497, -463, -428, -394, -359}
        };

        columnas = new TreeMap<Double, Integer>();
        columnas.put(10.0, 0);
        columnas.put(15.0, 1);
        columnas.put(20.0, 2);
        columnas.put(25.0, 3);
        columnas.put(30.0, 4);
        columnas.put(35.0, 5);

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
