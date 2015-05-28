package matrixMultiplication;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
	public static void main(String[] args) {
		int size = 1000;
		double start = System.currentTimeMillis();
		ExecutorService manager = Executors.newFixedThreadPool(10);
		Matrix matrix1 = new Matrix(size, manager);
		matrix1.initMatrix();
		Matrix matrix2 = new Matrix(size, manager);
		matrix2.initMatrix();
		
		Matrix matrix = matrix1.multiplyMatrices(matrix2);
		
		matrix.printMatrix();
		
		manager.shutdown();
		
		double end = System.currentTimeMillis();
		System.out.println(end - start);
		
		// size = 1000, threads = 1000 , time = 10636 ( 10.5 sec)
		// size = 1000, threads = 10, time = 9424 (9.5 sec)
		// size = 1000, threads = 1, time = 13450 (13.5 sec)
		// size = 1000, threads = 8, time = 9191 (9 sec)
		// size = 1000, threads = 4, time = 8434 (8.4 sec)
	}
}
