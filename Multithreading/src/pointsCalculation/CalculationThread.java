package pointsCalculation;


public class CalculationThread implements Runnable {
	private Calculations calc;
	private int indexFrom;
	private int indexTo;

	public CalculationThread(Calculations calc, int indexFrom, int indexTo) {
		this.calc = calc;
		this.indexFrom = indexFrom;
		this.indexTo = indexTo;
	}

	@Override
	public void run() {
		System.out.println("Thread: " + Thread.currentThread().getName()
				+ " is working");
		calc.doCalculations(calc.getPoints(), indexFrom, indexTo, calc.getMap());

	}

}
