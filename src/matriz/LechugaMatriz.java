package matriz;

import java.util.TreeMap;

public class LechugaMatriz extends HortalizaMatriz {

    public LechugaMatriz() {
        nitrogeno = new int[][]{
            {28, 41, 54, 74, 94, 121},
            {15, 28, 42, 62, 82, 108},
            {3, 16, 29, 49, 69, 96},
            {-10, 3, 17, 37, 57, 83},
            {-23, -9, 4, 24, 44, 71},
            {-35, -22, -8, 12, 32, 58},
            {-60, -47, -33, -13, 7, 33},
            {-85, -72, -58, -38, -18, 8}
        };
        fosforo = new int[][]{
            {22, 33, 44, 61, 78, 100},
            {11, 22, 33, 50, 66, 88},
            {5, 16, 27, 44, 61, 83},
            {-23, -12, -1, 15, 32, 54},
            {-52, -41, -30, -13, 4, 26},
            {-80, -69, -58, -41, -25, -2},
            {-137, -126, -115, -98, -81, -59},
            {-250, -239, -228, -212, -195, -173}
        };
        potasio = new int[][]{
            {30, 50, 70, 100, 130, 170},
            {0, 20, 40, 70, 100, 140},
            {-30, -10, 10, 40, 70, 110},
            {-90, -70, -50, -20, 10, 50},
            {-165, -145, -125, -95, -65, -25},
            {-240, -220, -200, -170, -140, -100},
            {-390, -370, -350, -320, -290, -250},
            {-540, -520, -500, -470, -440, -400}
        };

        columnas = new TreeMap<Double, Integer>();
        columnas.put(6.0, 0);
        columnas.put(8.0, 1);
        columnas.put(10.0, 2);
        columnas.put(13.0, 3);
        columnas.put(16.0, 4);
        columnas.put(20.0, 5);

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
