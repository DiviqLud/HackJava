package matrixMultiplication;

public class MultiplyThread implements Runnable {
	private Matrix matrix;
	private Matrix other;
	private Matrix newMatrix;
	private int row;
	
	public MultiplyThread (Matrix matrix, Matrix other, Matrix newMatrix, int row) {
		this.matrix = matrix;
		this.other = other;
		this.newMatrix = newMatrix;
		this.row = row;
	}
	
	@Override
	public void run() {
		int element = 0;
		for (int j = 0; j < matrix.getSize(); j++) {
			for (int k = 0; k < matrix.getSize(); k++) {
				element += matrix.getElement(row, k) * other.getElement(k, j);
			}
			newMatrix.setElement(row, j, element);
			element = 0;
		}
	}

}
