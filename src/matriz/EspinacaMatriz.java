package matriz;

import java.util.TreeMap;

public class EspinacaMatriz extends HortalizaMatriz {

    public EspinacaMatriz() {
        nitrogeno = new int[][]{
            {48, 60, 72, 84, 108, 132},
            {35, 47, 59, 71, 95, 119},
            {23, 35, 47, 59, 83, 107},
            {10, 22, 34, 46, 70, 94},
            {-3, 10, 22, 34, 58, 82},
            {-15, -3, 9, 21, 45, 69},
            {-40, -28, -16, -4, 20, 44},
            {-65, -53, -41, -29, -5, 19}
        };
        fosforo = new int[][]{
            {69, 85, 101, 117, 149, 181},
            {57, 73, 89, 105, 137, 169},
            {52, 68, 84, 100, 132, 164},
            {23, 39, 55, 71, 103, 135},
            {-5, 11, 27, 43, 75, 107},
            {-34, -18, -2, 15, 47, 79},
            {-90, -74, -58, -42, -10, 22},
            {-204, -188, -172, -156, -124, -92}
        };
        potasio = new int[][]{
            {60, 78, 96, 114, 150, 186},
            {30, 48, 66, 84, 120, 156},
            {0, 18, 36, 54, 90, 126},
            {-60, -42, -24, -6, 30, 66},
            {-135, -117, -99, -81, -45, -9},
            {-210, -192, -174, -156, -120, -84},
            {-360, -342, -324, -306, -270, -234},
            {-510, -492, -474, -456, -420, -384}
        };

        columnas = new TreeMap<Double, Integer>();
        columnas.put(5.0, 0);
        columnas.put(6.0, 1);
        columnas.put(7.0, 2);
        columnas.put(8.0, 3);
        columnas.put(10.0, 4);
        columnas.put(12.0, 5);

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
        filasP.put(2, 0);
        filasP.put(4, 1);
        filasP.put(5, 2);
        filasP.put(10, 3);
        filasP.put(15, 4);
        filasP.put(20, 5);
        filasP.put(30, 6);
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
