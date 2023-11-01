
package fisi.tareaPI;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PiFuturoParalela {
    
    public static void main(String[] args) {
        int K = 100000 ;
        Callable<Double> tarea1 = new PiSumaFuturo(0, K /4);
        Callable<Double> tarea2 = new PiSumaFuturo(K /4, K /2);
        Callable<Double> tarea3 = new PiSumaFuturo(K /2, 3* K /4);
        Callable<Double> tarea4 = new PiSumaFuturo(3* K /4, K);

        ExecutorService hilos = Executors.newFixedThreadPool(4);

        Future<Double> sum1 = hilos.submit(tarea1);
        Future<Double> sum2 = hilos.submit(tarea2);
        Future<Double> sum3 = hilos.submit(tarea3);
        Future<Double> sum4 = hilos.submit(tarea4);   
        
        Double suma = 0.0;
        try {
            suma = sum1.get() + sum2.get() + sum3.get() + sum4.get();
            System.out.println("El valor de pi por el metodo Leipniz es: "+suma);
        } catch (InterruptedException ex) {
            Logger.getLogger(PiFuturoParalela.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(PiFuturoParalela.class.getName()).log(Level.SEVERE, null, ex);
        }
        hilos.shutdown();
    }
}
