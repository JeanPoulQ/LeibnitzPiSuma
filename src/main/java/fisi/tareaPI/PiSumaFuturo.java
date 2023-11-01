package fisi.tareaPI;
import java.util.concurrent.Callable;


public class PiSumaFuturo implements Callable<Double>{
    private int inicio,fin;
    
    public PiSumaFuturo(int inicio, int fin) {
        this.inicio = inicio;
        this.fin = fin;
    }
    public double Leibniz(Double n){
        double f = Math.pow (-1,n) / (2*n+1);
        return f;
    }
    @Override
    public Double call() throws Exception {
        double pi = 0.0;
        for(int i = inicio; i<fin; i++){
            pi = pi+ Leibniz((double)i);
        }
        return 4*pi;
    }
}
