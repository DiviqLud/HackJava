package week1.Matrix;

public class Grayscale implements MatrixOperation{

	@Override
	public Pixel withPixel(int x, int y, Pixel[][] mtrx) {
		float average = mtrx[x][y].getBlue() + mtrx[x][y].getGreen() + mtrx[x][y].getRed();
		mtrx[x][y].setBlue(average);
		mtrx[x][y].setGreen(average);
		mtrx[x][y].setRed(average);
		return mtrx[x][y];
	}

}
