package week1.Matrix;

import java.util.Arrays;

public class Matrix {
	Pixel[][] mtrx;
	
	public Matrix(int n, int m) {
		this.mtrx = new Pixel[n][m];
	}

	public Pixel[][] getMtrx() {
		return mtrx;
	}

	public void setMtrx(Pixel[][] mtrx) {
		this.mtrx = mtrx;
	}
	
	public void operate(BrightnessReduce op) {
		for (int i = 0; i < mtrx.length; i++) {
			for (int j = 0; j < mtrx[0].length; j++) {
				op.withPixel(i, j, mtrx);
			}
		}
	}

	@Override
	public String toString() {
		return "Matrix [mtrx=" + Arrays.toString(mtrx) + "]";
	}
	
	
	
}
