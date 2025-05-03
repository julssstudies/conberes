package CC_01;

public class CC_01_Threads{
	public static int n = 4;
    public static int t;
    
	  public static class A extends Thread {
	    private int x;
	    
	    public A(int n) {
	    	x = n;
	    	t = (int) Math.random();
	    }

	    private static void sleep(int ms) {
	        try { Thread.sleep(ms); } catch (Exception e) {}
	    }
	    
	    public void run() {
	      System.out.println("Hola soy hilo " + x);
	      A.sleep(t);
	      System.out.println("Adios soy hilo " + x);
	    }
	  }

	  public static void main(String args[]) throws Exception {
		int c = 0;
		A[] hilos = new A[n];
		while (c<n) { // Mejor crear los objetos y luego, lanzarlos en otro bucle
	    	hilos[c] = new A(c+1);
	    	hilos[c].start();
	    	c++;
	    }
		c = 0;
		while (c<n) {
	    	hilos[c].join();
	    	c++;
	    }
	    System.out.println("----------Ya he terminado----------");
	  }
	}
