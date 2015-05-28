package week1.Matrix;

public class Pixel {
	float red, green, blue;
	
	public Pixel() {
		this.red = 0;
		this.green = 0;
		this.blue = 0;
	}
	
	public Pixel(float red, float green, float blue) {
		this.red = red;
		this.green = green;
		this.blue = blue;
	}

	public float getRed() {
		return red;
	}

	public float getGreen() {
		return green;
	}

	public float getBlue() {
		return blue;
	}

	public void setRed(float red) {
		this.red = red;
	}

	public void setGreen(float green) {
		this.green = green;
	}

	public void setBlue(float blue) {
		this.blue = blue;
	}
	
	
}
