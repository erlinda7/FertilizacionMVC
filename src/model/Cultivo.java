package model;

import java.util.ArrayList;

import matriz.AcelgaMatriz;
import matriz.ApioMatriz;
import matriz.ArvejaMatriz;
import matriz.BerenjenaMatriz;
import matriz.BrocoliMatriz;
import matriz.CebollaMatriz;
import matriz.ColiflorMatriz;
import matriz.EspinacaMatriz;
import matriz.HabaMatriz;
import matriz.LechugaMatriz;
import matriz.PapaMatriz;
import matriz.PepinoMatriz;
import matriz.PimentonMatriz;
import matriz.RabanoMatriz;
import matriz.RemolachaMatriz;
import matriz.RepolloMatriz;
import matriz.TomateMatriz;
import matriz.VainitaMatriz;
import matriz.ZanahoriaMatriz;

public class Cultivo {

    private String hortaliza;
    private double rendimiento;

    private int nivelNitrogeno; //nivel de N en el suelo
    private int nivelFosforo;
    private int nivelPotasio;
    private double nivelpH;
    private double nivelMO;
    //rango: muy bajo,bajo,medio,alto y muy alto
    private String rangoNivelNitrogeno;
    private String rangoNivelFosforo;
    private String rangoNivelPotasio;
    private String rangoNivelMO;

    private String tipoSuelo; //segun el ph del suelo "suelo nuetro"

    //cantidad de NPK recomendable para cada hortaliza en Kg (tabla de recomendacion)
    private double cantKgN;
    private double cantKgP;
    private double cantKgK;

    //como aplicar el fertlizante al cultivo
    private String formaAplicar;

    private ArrayList<Recomendacion> recomendaciones;
    //private Recomendacion recomendaciones1;

    public Cultivo() {
        hortaliza = "";
        rendimiento = 0.0;

        nivelNitrogeno = 0;
        nivelFosforo = 0;
        nivelPotasio = 0;
        nivelpH = 0d;
        tipoSuelo = "";
        nivelMO = 0d;
        rangoNivelNitrogeno = "";
        rangoNivelFosforo = "";
        rangoNivelPotasio = "";
        rangoNivelMO = "";
        cantKgN = 0;
        cantKgP = 0;
        cantKgK = 0;
        recomendaciones = new ArrayList<Recomendacion>();
        formaAplicar = "";
    }

    public String getHortaliza() {
        return hortaliza;
    }

    public void setHortaliza(String hortaliza) {
        this.hortaliza = hortaliza;
    }

    public double getRendimiento() {
        return rendimiento;
    }

    public void setRendimiento(double rendimiento) {
        this.rendimiento = rendimiento;
    }

    public int getNivelNitrogeno() {
        return nivelNitrogeno;
    }

    public void setNivelNitrogeno(int nivelNitrogeno) {
        this.nivelNitrogeno = nivelNitrogeno;
    }

    public int getNivelFosforo() {
        return nivelFosforo;
    }

    public void setNivelFosforo(int nivelFosforo) {
        this.nivelFosforo = nivelFosforo;
    }

    public int getNivelPotasio() {
        return nivelPotasio;
    }

    public void setNivelPotasio(int nivelPotasio) {
        this.nivelPotasio = nivelPotasio;
    }

    public double getNivelpH() {
        return nivelpH;
    }

    public void setNivelpH(double nivelpH) {
        this.nivelpH = nivelpH;
    }

    public String getTipoSuelo() {
        return tipoSuelo;
    }

    public void setTipoSuelo(String tipoSuelo) {
        this.tipoSuelo = tipoSuelo;
    }

    public double getNivelMO() {
        return nivelMO;
    }

    public void setNivelMO(double nivelMO) {
        this.nivelMO = nivelMO;
    }

    public String getRangoNivelFosforo() {
        return rangoNivelFosforo;
    }

    public void setRangoNivelFosforo(String rangoNivelFosforo) {

        this.rangoNivelFosforo = rangoNivelFosforo;
    }

    public String getRangoNivelNitrogeno() {
        return rangoNivelNitrogeno;
    }

    public void setRangoNivelNitrogeno(String rangoNivelNitrogeno) {
        this.rangoNivelNitrogeno = rangoNivelNitrogeno;
    }

    public String getRangoNivelPotasio() {
        return rangoNivelPotasio;
    }

    public void setRangoNivelPotasio(String rangoNivelPotasio) {
        this.rangoNivelPotasio = rangoNivelPotasio;
    }

    public String getRangoNivelMO() {
        return rangoNivelMO;
    }

    public void setRangoNivelMO(String rangoNivelMO) {
        this.rangoNivelMO = rangoNivelMO;
    }

    public double getCantKgN() {
        return cantKgN;
    }

    public void setCantKgN(double cantKgN) {
        this.cantKgN = cantKgN;
    }

    public double getCantKgP() {
        return cantKgP;
    }

    public void setCantKgP(double cantKgP) {
        this.cantKgP = cantKgP;
    }

    public double getCantKgK() {
        return cantKgK;
    }

    public void setCantKgK(double cantKgK) {
        this.cantKgK = cantKgK;
    }

    public ArrayList<Recomendacion> getRecomendaciones() {
        return recomendaciones;
    }

    public void addRecomendacion(Recomendacion recomendacion) {
        recomendaciones.add(recomendacion);
    }

    public String getFormaAplicar() {
        return formaAplicar;
    }

    public void setFormaAplicar(String formaAplicar) {
        this.formaAplicar = formaAplicar;
    }

    //metodos para calcular cantidad de fertilizante NPK para las hortalizas 
    public void calcularKgFertilizanteAcelga() {
        AcelgaMatriz acelga = new AcelgaMatriz();
        cantKgN = acelga.cantidadFertilizarN(nivelNitrogeno, rendimiento);
        cantKgP = acelga.cantidadFertilizarP(nivelFosforo, rendimiento, hortaliza);
        cantKgK = acelga.cantidadFertilizarK(nivelPotasio, rendimiento);
    }

    public void calcularKgFertilizanteApio() {
        ApioMatriz apio = new ApioMatriz();
        cantKgN = apio.cantidadFertilizarN(nivelNitrogeno, rendimiento);
        cantKgP = apio.cantidadFertilizarP(nivelFosforo, rendimiento, hortaliza);
        cantKgK = apio.cantidadFertilizarK(nivelPotasio, rendimiento);
    }

    public void calcularKgFertilizanteArveja() {
        ArvejaMatriz arveja = new ArvejaMatriz();
        cantKgN = arveja.cantidadFertilizarN(nivelNitrogeno, rendimiento);
        cantKgP = arveja.cantidadFertilizarP(nivelFosforo, rendimiento, hortaliza);
        cantKgK = arveja.cantidadFertilizarK(nivelPotasio, rendimiento);
    }

    public void calcularKgFertilizanteBerenjena() {
        BerenjenaMatriz berenjena = new BerenjenaMatriz();
        cantKgN = berenjena.cantidadFertilizarN(nivelNitrogeno, rendimiento);
        cantKgP = berenjena.cantidadFertilizarP(nivelFosforo, rendimiento, hortaliza);
        cantKgK = berenjena.cantidadFertilizarK(nivelPotasio, rendimiento);
    }

    public void calcularKgFertilizanteBrocoli() {
        BrocoliMatriz brocoli = new BrocoliMatriz();
        cantKgN = brocoli.cantidadFertilizarN(nivelNitrogeno, rendimiento);
        cantKgP = brocoli.cantidadFertilizarP(nivelFosforo, rendimiento, hortaliza);
        cantKgK = brocoli.cantidadFertilizarK(nivelPotasio, rendimiento);
    }

    public void calcularKgFertilizanteCebolla() {
        CebollaMatriz cebolla = new CebollaMatriz();
        cantKgN = cebolla.cantidadFertilizarN(nivelNitrogeno, rendimiento);
        cantKgP = cebolla.cantidadFertilizarP(nivelFosforo, rendimiento, hortaliza);
        cantKgK = cebolla.cantidadFertilizarK(nivelPotasio, rendimiento);
    }

    public void calcularKgFertilizanteColiflor() {
        ColiflorMatriz coliflor = new ColiflorMatriz();
        cantKgN = coliflor.cantidadFertilizarN(nivelNitrogeno, rendimiento);
        cantKgP = coliflor.cantidadFertilizarP(nivelFosforo, rendimiento, hortaliza);
        cantKgK = coliflor.cantidadFertilizarK(nivelPotasio, rendimiento);
    }

    public void calcularKgFertilizanteEspinaca() {
        EspinacaMatriz espinaca = new EspinacaMatriz();
        cantKgN = espinaca.cantidadFertilizarN(nivelNitrogeno, rendimiento);
        cantKgP = espinaca.cantidadFertilizarP(nivelFosforo, rendimiento, hortaliza);
        cantKgK = espinaca.cantidadFertilizarK(nivelPotasio, rendimiento);
    }

    public void calcularKgFertilizanteHaba() {
        HabaMatriz haba = new HabaMatriz();
        cantKgN = haba.cantidadFertilizarN(nivelNitrogeno, rendimiento);
        cantKgP = haba.cantidadFertilizarP(nivelFosforo, rendimiento, hortaliza);
        cantKgK = haba.cantidadFertilizarK(nivelPotasio, rendimiento);
    }

    public void calcularKgFertilizanteLechuga() {
        LechugaMatriz lechuga = new LechugaMatriz();
        cantKgN = lechuga.cantidadFertilizarN(nivelNitrogeno, rendimiento);
        cantKgP = lechuga.cantidadFertilizarP(nivelFosforo, rendimiento, hortaliza);
        cantKgK = lechuga.cantidadFertilizarK(nivelPotasio, rendimiento);
    }

    public void calcularKgFertilizantePapa() {
        PapaMatriz papa = new PapaMatriz();
        cantKgN = papa.cantidadFertilizarN(nivelNitrogeno, rendimiento);
        cantKgP = papa.cantidadFertilizarP(nivelFosforo, rendimiento, hortaliza);
        cantKgK = papa.cantidadFertilizarK(nivelPotasio, rendimiento);
    }

    public void calcularKgFertilizantePepino() {
        PepinoMatriz pepino = new PepinoMatriz();
        cantKgN = pepino.cantidadFertilizarN(nivelNitrogeno, rendimiento);
        cantKgP = pepino.cantidadFertilizarP(nivelFosforo, rendimiento, hortaliza);
        cantKgK = pepino.cantidadFertilizarK(nivelPotasio, rendimiento);
    }

    public void calcularKgFertilizantePimenton() {
        PimentonMatriz pimenton = new PimentonMatriz();
        cantKgN = pimenton.cantidadFertilizarN(nivelNitrogeno, rendimiento);
        cantKgP = pimenton.cantidadFertilizarP(nivelFosforo, rendimiento, hortaliza);
        cantKgK = pimenton.cantidadFertilizarK(nivelPotasio, rendimiento);
    }

    public void calcularKgFertilizanteRabano() {
        RabanoMatriz rabano = new RabanoMatriz();
        cantKgN = rabano.cantidadFertilizarN(nivelNitrogeno, rendimiento);
        cantKgP = rabano.cantidadFertilizarP(nivelFosforo, rendimiento, hortaliza);
        cantKgK = rabano.cantidadFertilizarK(nivelPotasio, rendimiento);
    }

    public void calcularKgFertilizanteRemolacha() {
        RemolachaMatriz remolacha = new RemolachaMatriz();
        cantKgN = remolacha.cantidadFertilizarN(nivelNitrogeno, rendimiento);
        cantKgP = remolacha.cantidadFertilizarP(nivelFosforo, rendimiento, hortaliza);
        cantKgK = remolacha.cantidadFertilizarK(nivelPotasio, rendimiento);
    }

    public void calcularKgFertilizanteRepollo() {
        RepolloMatriz repollo = new RepolloMatriz();
        cantKgN = repollo.cantidadFertilizarN(nivelNitrogeno, rendimiento);
        cantKgP = repollo.cantidadFertilizarP(nivelFosforo, rendimiento, hortaliza);
        cantKgK = repollo.cantidadFertilizarK(nivelPotasio, rendimiento);
    }

    public void calcularKgFertilizanteTomate() {
        TomateMatriz tomate = new TomateMatriz();
        cantKgN = tomate.cantidadFertilizarN(nivelNitrogeno, rendimiento);
        cantKgP = tomate.cantidadFertilizarP(nivelFosforo, rendimiento, hortaliza);
        cantKgK = tomate.cantidadFertilizarK(nivelPotasio, rendimiento);
    }

    public void calcularKgFertilizanteVainita() {
        VainitaMatriz vainita = new VainitaMatriz();
        cantKgN = vainita.cantidadFertilizarN(nivelNitrogeno, rendimiento);
        cantKgP = vainita.cantidadFertilizarP(nivelFosforo, rendimiento, hortaliza);
        cantKgK = vainita.cantidadFertilizarK(nivelPotasio, rendimiento);
    }

    public void calcularKgFertilizanteZanahoria() {
        ZanahoriaMatriz zanahoria = new ZanahoriaMatriz();
        cantKgN = zanahoria.cantidadFertilizarN(nivelNitrogeno, rendimiento);
        cantKgP = zanahoria.cantidadFertilizarP(nivelFosforo, rendimiento, hortaliza);
        cantKgK = zanahoria.cantidadFertilizarK(nivelPotasio, rendimiento);
    }

    public String getRecomendacionesString() {
        String res = "";
        int contador = 1;
        for (Recomendacion rec : recomendaciones) {
            res = res + "\nRecomendacion " + contador + ":" + "\n";
            res = res + "\n" + rec.toString();
            contador++;
        }
        return res;
    }

    @Override
    public String toString() {
        return "Cultivo{" + "hortaliza=" + hortaliza + ", rendimiento=" + rendimiento + ", nivelNitrogeno=" + nivelNitrogeno + ", nivelFosforo=" + nivelFosforo + ", nivelPotasio=" + nivelPotasio + ", nivelpH=" + nivelpH + ", nivelMO=" + nivelMO + ", rangoNivelNitrogeno=" + rangoNivelNitrogeno + ", rangoNivelFosforo=" + rangoNivelFosforo + ", rangoNivelPotasio=" + rangoNivelPotasio + ", rangoNivelMO=" + rangoNivelMO + ", tipoSuelo=" + tipoSuelo + ", cantKgN=" + cantKgN + ", cantKgP=" + cantKgP + ", cantKgK=" + cantKgK + ", formaAplicar=" + formaAplicar + ", recomendaciones=" + recomendaciones + '}';
    }

}
