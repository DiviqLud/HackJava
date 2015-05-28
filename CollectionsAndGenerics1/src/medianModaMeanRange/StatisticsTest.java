package medianModaMeanRange;

public class StatisticsTest {
	
	public static void main(String[] args) {
		StatisticsImpl stat = new StatisticsImpl(10);
		stat.add(5);
		stat.add(2);
		stat.add(12);
		stat.add(12);
		stat.add(1);
		stat.add(24);
		stat.add(4);
		stat.add(4);
		stat.add(4);
		
		stat.printElements();
		System.out.println();
		System.out.println("Mean: " + stat.getMean());
		System.out.println("Moda: " + stat.getModa());
		System.out.println("Median: " + stat.getMedian());
		System.out.println("Range: " + stat.getRange());
	}	
}
