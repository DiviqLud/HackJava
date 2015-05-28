package matrixMultiplication;

import java.util.concurrent.ExecutorService;

public class Matrix {
	private int[][] matrix;
	private int size;
	private ExecutorService manager;
	
	public Matrix(int size, ExecutorService manager) {
		this.size = size;
		matrix =  new int[size][size];
		this.manager = manager;
	}
	
	public void initMatrix() {
		int counter = 1;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				matrix[i][j] = counter;
				counter++;
			}
			counter = 1;
		}
	}
	
	public void setElement(int i, int j, int x) {
		matrix[i][j] = x;
	}
	
	public int getElement(int i, int j) {
		return matrix[i][j];
	}
	
	public int getSize() {
		return matrix.length;
	}
	
	public Matrix multiplyMatrices(Matrix other) {
		int element = 0;
		Matrix newMatrix = new Matrix(size, manager);
		for (int i = 0; i < size; i++) {
			manager.execute(new MultiplyThread(this, other, newMatrix, i));
		}
		return newMatrix;
	}
	
//	public Matrix multiplyMatrices(Matrix other) {
//		int element = 0;
//		Matrix newMatrix = new Matrix(size);
//		for (int i = 0; i < size; i++) {
//			for (int j = 0; j < size; j++) {
//				for (int k = 0; k < size; k++) {
//					element += matrix[i][k]* other.getElement(k, j);
//				}
//				newMatrix.setElement(i, j, element);
//				element = 0;
//			}
//		}
//		return newMatrix;
//	}
	
	public void printMatrix() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	
}
