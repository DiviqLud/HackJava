package pointsCalculation;

import java.util.List;
import java.util.Map;

public class Calculations {
	private Map<Point, Point> map;
	private List<Point> points;

	public Calculations(Map<Point, Point> map, List<Point> points) {
		this.map = map;
		this.points = points;
	}

	public Map<Point, Point> getMap() {
		return map;
	}

	public List<Point> getPoints() {
		return points;
	}

	public void setMap(Map<Point, Point> map) {
		this.map = map;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}

	public Point getNearest(Point a, List<Point> points) {
		Point neededPoint = new Point(0, 0);
		int minX = a.getX();
		int minY = a.getY();
		double dist = minX + minY;
		for (int j = 0; j < points.size(); j++) {
			if (!points.get(j).equals(a)) {
				int newX = (int) (a.getX() - points.get(j).getX());
				int newY = (int) (a.getY() - points.get(j).getY());
				double distance = Math.sqrt(newX * newX + newY * newY);
				if (distance < dist) {
					dist = distance;
					neededPoint = points.get(j);
				}
			}
		}
		return neededPoint;
	}

	public void doCalculations(List<Point> inPoints, int indexFrom,
			int indexTo, Map<Point, Point> outMap) {

		for (int i = indexFrom; i < indexTo; i++) {
			Point a = inPoints.get(i);
			outMap.put(a, getNearest(a, inPoints));
		}

	}
}
