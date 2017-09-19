package matriz;

import java.util.Iterator;
import java.util.TreeMap;

public class HortalizaMatriz {
    //public TreeMap<K, V>

    protected TreeMap<Double, Integer> columnas;
    protected TreeMap<Integer, Integer> filasP;
    protected TreeMap<Integer, Integer> filasK;
    protected TreeMap<Integer, Integer> filasN;
    protected int[][] nitrogeno;
    protected int[][] fosforo;
    protected int[][] potasio;

    int ant, sig, pos;
    double resAnt, resSig, constSumativa, resN, resP, resK;

    public HortalizaMatriz() {
    }

    public double cantidadFertilizarN(int filaN, double columnaN) {
        resN = 0;
        double res5, res10, res40, res50;
        try {
            resN = nitrogeno[filasN.get(filaN)][columnas.get(columnaN)];
        } catch (Exception e) {
            if (filaN < 5) {
                res5 = nitrogeno[filasN.get(5)][columnas.get(columnaN)];
                res10 = nitrogeno[filasN.get(10)][columnas.get(columnaN)];
                pos = 5 - filaN;
                constSumativa = (res5 - res10) / 5.0;
                resN = (constSumativa * (double) pos) + res5;
                resN = Math.rint(resN * 10) / 10;
            } else {
                if (filaN > 50) {
                    res40 = nitrogeno[filasN.get(40)][columnas.get(columnaN)];
                    res50 = nitrogeno[filasN.get(50)][columnas.get(columnaN)];
                    pos = filaN - 50;
                    constSumativa = (res50 - res40) / 10.0;
                    resN = (constSumativa * (double) pos) + res50;
                    resN = Math.rint(resN * 10) / 10;
                } else {
                    resN = cantidadFertilizarNNoExacto(filaN, columnaN);
                }
            }
        }
        return resN;
    }

    public double cantidadFertilizarP(int filaP, double columnaP, String nombreHortaliza) {
        resP = 0;
        double res5, res10, res2, res4;
        try {
            resP = fosforo[filasP.get(filaP)][columnas.get(columnaP)];
        } catch (Exception e) {
            if ((nombreHortaliza.equals("Coliflor") || nombreHortaliza.equals("Espinaca") || nombreHortaliza.equals("Lechuga"))) {

                if (filaP < 2) {
                    res2 = fosforo[filasP.get(2)][columnas.get(columnaP)];
                    res4 = fosforo[filasP.get(4)][columnas.get(columnaP)];
                    pos = 2 - filaP;
                    constSumativa = (res2 - res4) / 2.0;
                    resP = (constSumativa * (double) pos) + res2;
                    resP = Math.rint(resP * 10) / 10;
                } else {
                    if (filaP > 50) {
                        resP = -1.0;
                    } else {
                        resP = cantidadFertilizarPNoExacto(filaP, columnaP);
                    }
                }
            } else {
                if (filaP < 5) {
                    res5 = fosforo[filasP.get(5)][columnas.get(columnaP)];
                    res10 = fosforo[filasP.get(10)][columnas.get(columnaP)];
                    pos = 5 - filaP;
                    constSumativa = (res5 - res10) / 5.0;
                    resP = (constSumativa * (double) pos) + res5;
                    resP = Math.rint(resP * 10) / 10;
                } else {
                    if (filaP > 50) {
                        resP = -1.0;
                    } else {
                        resP = cantidadFertilizarPNoExacto(filaP, columnaP);
                    }
                }
            }
        }
        return resP;
    }

    public double cantidadFertilizarK(int filaK, double columnaK) {
        resK = 0;
        double res10, res20;
        try {
            resK = potasio[filasK.get(filaK)][columnas.get(columnaK)];
        } catch (Exception e) {
            if (filaK < 10) {
                res10 = potasio[filasK.get(10)][columnas.get(columnaK)];
                res20 = potasio[filasK.get(20)][columnas.get(columnaK)];
                pos = 10 - filaK;
                constSumativa = (res10 - res20) / 10.0;
                resK = (constSumativa * (double) pos) + res10;
                resK = Math.rint(resK * 10) / 10;
            } else {
                if (filaK > 200) {
                    resK = -1.0;
                } else {
                    resK = cantidadFertilizarKNoExacto(filaK, columnaK);
                }
            }
        }
        return resK;
    }

    ///*valor que no se encuentra en las filas de nitrogeno en el suelo y luego calcular*/
    private double cantidadFertilizarNNoExacto(int filaN, double columnaN) {
        Iterator<Integer> it = filasN.keySet().iterator();
        resN = 0;
        boolean encontrado = false;
        ant = it.next();
        sig = 0;
        pos = 0;
        while (it.hasNext() && !encontrado) {
            Integer key = it.next();
            sig = key;
            if (ant < filaN && filaN < sig) {
                encontrado = true;
            } else {
                ant = sig;
            }
        }
        pos = filaN - ant;
        resAnt = nitrogeno[filasN.get(ant)][columnas.get(columnaN)];
        resSig = nitrogeno[filasN.get(sig)][columnas.get(columnaN)];
        constSumativa = (resSig - resAnt) / (double) (sig - ant);
        resN = (constSumativa * (double) pos) + resAnt;
        resN = Math.rint(resN * 10) / 10;
        return resN;

    }

    private double cantidadFertilizarPNoExacto(int filaP, double columnaP) {

        Iterator<Integer> it = filasP.keySet().iterator();
        resP = 0;
        boolean encontrado = false;
        ant = it.next();
        sig = 0;
        while (it.hasNext() && !encontrado) {
            Integer key = it.next();
            sig = key;
            if (ant < filaP && filaP < sig) {
                encontrado = true;
            } else {
                ant = sig;
            }
        }
        pos = filaP - ant;
        resAnt = fosforo[filasP.get(ant)][columnas.get(columnaP)];
        resSig = fosforo[filasP.get(sig)][columnas.get(columnaP)];
        constSumativa = (resSig - resAnt) / (double) (sig - ant);
        resP = (constSumativa * (double) pos) + resAnt;
        resP = Math.rint(resP * 10) / 10;
        return resP;
    }

    private double cantidadFertilizarKNoExacto(int filaK, double columnaK) {

        Iterator<Integer> it = filasK.keySet().iterator();
        resK = 0;
        boolean encontrado = false;
        ant = it.next();
        sig = 0;
        while (it.hasNext() && !encontrado) {
            Integer key = it.next();
            sig = key;
            if (ant < filaK && filaK < sig) {
                encontrado = true;
            } else {
                ant = sig;
            }
        }
        pos = filaK - ant;
        resAnt = potasio[filasK.get(ant)][columnas.get(columnaK)];
        resSig = potasio[filasK.get(sig)][columnas.get(columnaK)];
        constSumativa = (resSig - resAnt) / (double) (sig - ant);
        resK = (constSumativa * (double) pos) + resAnt;
        resK = Math.rint(resK * 10) / 10;

        return resK;
    }
}
