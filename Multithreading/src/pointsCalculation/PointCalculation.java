package pointsCalculation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;

public class PointCalculation {
	public static List<Point> generatePoints() {
		List<Point> generatedPoints = new ArrayList<Point>();
		for (int i = 0; i < 100_000; i++) {
			int x = ThreadLocalRandom.current().nextInt(0, 10_000);
			int y = ThreadLocalRandom.current().nextInt(0, 10_000);
			generatedPoints.add(new Point(x, y));
		}
		return generatedPoints;
	}

	public static Map<Point, Point> getNearestPoints(List<Point> points)
			throws InterruptedException {
		Map<Point, Point> resultMap = new ConcurrentHashMap<Point, Point>();

		Calculations calc1 = new Calculations(resultMap, points);

		Thread calculator1 = new Thread(new CalculationThread(calc1, 0, points.size()/2));
		Thread calculator2 = new Thread(new CalculationThread(calc1, points.size()/2+1, points.size()));

		calculator1.start();
		calculator2.start();

		calculator1.join();
		calculator2.join();

		return resultMap;
	}

	public static void main(String[] args) throws InterruptedException {
		List<Point> points = generatePoints();

		double startTime = System.currentTimeMillis();
		Map<Point, Point> resultMap = getNearestPoints(points);
		double endTime = System.currentTimeMillis();
		System.out.println("Time needed:" + (endTime - startTime));

		System.out.println("Size of resultMap: " + resultMap.size());
	}
}
