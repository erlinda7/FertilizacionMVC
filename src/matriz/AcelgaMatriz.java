package matriz;

import java.util.TreeMap;

public class AcelgaMatriz extends HortalizaMatriz {

    public AcelgaMatriz() {
        nitrogeno = new int[][]{
            {38, 53, 68, 88, 113, 138},
            {25, 40, 55, 75, 100, 125},
            {13, 28, 43, 63, 88, 113},
            {0, 15, 30, 50, 75, 100},
            {-13, 3, 18, 38, 63, 88},
            {-25, -10, 5, 25, 50, 75},
            {-50, -35, -20, 0, 25, 50},
            {-75, -60, -45, -25, 0, 25}
        };
        fosforo = new int[][]{
            {10, 22, 33, 49, 68, 87},
            {-18, -7, 5, 20, 39, 59},
            {-47, -35, -24, -8, 11, 30},
            {-75, -64, -52, -37, -17, 2},
            {-103, -92, -80, -65, -46, -26},
            {-132, -120, -109, -93, -74, -55},
            {-189, -177, -165, -150, -131, -112},
            {-245, -234, -222, -207, -188, -168}
        };
        potasio = new int[][]{
            {66, 95, 124, 162, 210, 258},
            {36, 65, 94, 132, 180, 228},
            {6, 35, 64, 102, 150, 198},
            {-54, -25, 4, 42, 90, 138},
            {-129, -100, -71, -33, 15, 63},
            {-204, -175, -146, -108, -60, -12},
            {-354, -325, -296, -258, -210, -162},
            {-504, -475, -446, -408, -360, -312}
        };

        columnas = new TreeMap<Double, Integer>();
        columnas.put(10.0, 0);
        columnas.put(13.0, 1);
        columnas.put(16.0, 2);
        columnas.put(20.0, 3);
        columnas.put(25.0, 4);
        columnas.put(30.0, 5);

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
