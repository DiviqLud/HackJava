package pointsCalculation;


public class Point {
	private int x;
	private int y;

	public Point(int x, int y) {
		setX(x);
		setY(y);
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x2) {
		this.x = x2;
	}

	public int getY() {
		return y;
	}

	public void setY(int y2) {
		this.y = y2;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
	
	
	

}
