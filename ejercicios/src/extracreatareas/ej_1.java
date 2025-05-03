package extracreatareas;

public class ej_1 extends Thread {
	public static int number;

    public ej_1(int number) {
        this.number = number;
    }

    private static void sleep(int ms) {
        try { Thread.sleep(ms); } catch (Exception e) {}
    }
    public void run() {
    	ej_1.sleep(this.number*(int)Math.random()); // Duerme durante un tiempo proporcional al número
        System.out.println(this.number); // Imprime el número después de la espera
 
    }

    public static void main(String[] args) {
        int[] vector = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3}; // Array de números a ordenar

        // Creamos un hilo para cada número en el array y lo iniciamos
        for (int i = 0; i < vector.length; i++) {
            new ej_1(vector[i]).start();
        }
    }
}

