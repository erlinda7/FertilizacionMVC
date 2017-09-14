package controller;

import java.awt.Desktop;
import java.awt.print.PrinterJob;

public class ImprimirResultados {

    public ImprimirResultados() {

    }

    public static void imprimir(String ruta) {
        PrinterJob job = PrinterJob.getPrinterJob();
        job.printDialog();
        java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
        java.io.File fichero = new java.io.File(ruta);
        if (desktop.isSupported(Desktop.Action.PRINT)) {
            try {
                desktop.print(fichero);
            } catch (Exception e) {
                System.out.print("El sistema no permite imprimir usando la clase Desktop");
                e.printStackTrace();
            }
        } else {
            System.out.print("El sistema no permite imprimir usando la clase Desktop");
        }
    }

}
