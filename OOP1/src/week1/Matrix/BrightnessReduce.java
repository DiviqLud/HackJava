package week1.Matrix;

public class BrightnessReduce implements MatrixOperation{

	@Override
	public Pixel withPixel(int x, int y, Pixel[][] mtrx) {
		mtrx[x][y].setBlue(mtrx[x][y].getBlue() - 5);
		mtrx[x][y].setGreen(mtrx[x][y].getGreen() - 5);		
		mtrx[x][y].setRed(mtrx[x][y].getRed() - 5);
		return mtrx[x][y];

	}
}
