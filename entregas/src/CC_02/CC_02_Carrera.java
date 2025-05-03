package CC_02;

import java.util.ArrayDeque;

public class CC_02_Carrera {

  private static final int NDATOS = 1000;
  
  // declara e inicializa aquí la variable con la cola
  // compartida
  public volatile static ArrayDeque<Integer> cola = new ArrayDeque<>(NDATOS);
  
  private static class Productor extends Thread {
    private int inicial;
    
    public Productor(int inicial) {
      this.inicial = inicial;
    }
    
    public void run() {
      // generamos NDATOS desde inicial, los guardarmos en la cola,
      // cada dato es el anterior + 2
    	for (int i = inicial; i< NDATOS; i = i+2) {
    		cola.add(i);
    	}
    }
  }
  
  private static class Consumidor extends Thread {
    public void run() {
      // extraemos e imprimimos uno a uno todos los datos de la
      // cola, qué pasa si la cola está vacia
    	for (int i = 0; i< NDATOS; i++) {
    		Integer salida = cola.pollFirst();
    		// segun pollfirst() si cola vacia devuelve null
    		if (salida != null) {
    			System.out.println(salida);
    		}
    	}
    }
  }
  
  public static void main(String[] args)
    throws InterruptedException {
    
    Thread par = new Productor(0);
    Thread impar = new Productor(1);
    Thread c = new Consumidor();
    
    par.start();
    impar.start();
    c.start();
    
    par.join();
    impar.join();
    c.join();
    
    // todos los procesos terminan e imprimimos el numero de
    // elementos en la cola
    System.out.println("Numero de elementos en la cola: " + cola.size());
    // La condicion de carrera se detecta aqui 
  }
}