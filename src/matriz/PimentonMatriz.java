package matriz;

import java.util.TreeMap;

public class PimentonMatriz extends HortalizaMatriz {

    public PimentonMatriz() {
        nitrogeno = new int[][]{
            {97, 118, 140, 162, 206, 249},
            {84, 106, 128, 150, 193, 237},
            {72, 93, 115, 137, 181, 224},
            {59, 81, 103, 125, 168, 212},
            {47, 68, 90, 112, 156, 199},
            {34, 56, 78, 100, 143, 187},
            {9, 31, 53, 75, 118, 162},
            {-16, 6, 28, 50, 93, 137}
        };
        fosforo = new int[][]{
            {53, 70, 86, 103, 135, 168},
            {25, 41, 58, 74, 107, 140},
            {-3, 13, 29, 46, 79, 111},
            {-32, -15, 1, 17, 50, 83},
            {-60, -44, -27, -11, 22, 54},
            {-88, -72, -56, -39, -7, 26},
            {-145, -129, -112, -96, -63, -31},
            {-202, -186, -169, -153, -120, -87}
        };
        potasio = new int[][]{
            {61, 79, 97, 115, 152, 188},
            {31, 49, 67, 85, 122, 158},
            {1, 19, 37, 55, 92, 128},
            {-59, -41, -23, -5, 32, 68},
            {-134, -116, -98, -80, -43, -7},
            {-209, -191, -173, -155, -118, -82},
            {-359, -341, -323, -305, -288, -232},
            {-509, -491, -473, -455, -418, -382}
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
