package matriz;

import java.util.TreeMap;

public class BrocoliMatriz extends HortalizaMatriz {

    public BrocoliMatriz() {
        nitrogeno = new int[][]{
            {90, 107, 124, 158, 192, 226},
            {77, 94, 111, 145, 179, 213},
            {65, 82, 99, 133, 167, 201},
            {52, 69, 86, 120, 154, 188},
            {40, 57, 74, 108, 142, 176},
            {27, 44, 61, 95, 129, 163},
            {2, 19, 36, 70, 104, 138},
            {-23, -6, 11, 45, 79, 113}
        };
        fosforo = new int[][]{
            {92, 112, 132, 172, 212, 252},
            {63, 83, 103, 143, 183, 223},
            {35, 55, 75, 115, 155, 195},
            {7, 27, 47, 87, 127, 167},
            {-22, -2, 18, 58, 98, 138},
            {-50, -30, -10, 30, 70, 110},
            {-107, -87, -67, -27, 13, 53},
            {-164, -144, -124, -84, -44, -4}
        };
        potasio = new int[][]{
            {108, 131, 154, 200, 246, 292},
            {78, 101, 124, 170, 216, 262},
            {48, 71, 94, 140, 186, 232},
            {-12, 11, 34, 80, 126, 172},
            {-87, -64, -41, 5, 51, 97},
            {-162, -139, -116, -70, -24, 22},
            {-312, -289, -266, -220, -174, -128},
            {-462, -439, -416, -370, -324, -278}
        };

        columnas = new TreeMap<Double, Integer>();
        columnas.put(3.0, 0);
        columnas.put(3.5, 1);
        columnas.put(4.0, 2);
        columnas.put(5.0, 3);
        columnas.put(6.0, 4);
        columnas.put(7.0, 5);

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
