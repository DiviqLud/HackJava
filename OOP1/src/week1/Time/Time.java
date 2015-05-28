package week1.Time;

import java.util.Calendar;

public class Time {
	public int sec, min, hours, day, month, year;

	public Time() {
		
	}
	
	public Time(int sec, int min, int hours, int day, int month, int year) {
		super();
		this.sec = sec;
		this.min = min;
		this.hours = hours;
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public int getSec() {
		return sec;
	}

	public void setSec(int sec) {
		this.sec = sec;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String toString() {
		return String.format("%d:%d:%d:%d:%d:%d", sec, min, hours, day, month, year);
	}
	
	public static Time now() {
		Calendar cal = Calendar.getInstance();
		int min = cal.get(Calendar.MINUTE);
		int sec = cal.get(Calendar.SECOND);
		int hour = cal.get(Calendar.HOUR);
		int day = cal.get(Calendar.DATE);
		int month = cal.get(Calendar.MONTH);
		int year = cal.get(Calendar.YEAR);
		return new Time(sec, min, hour, day, month, year);
	}
	
}
