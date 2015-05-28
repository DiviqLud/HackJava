package Exceptions;

import java.util.Calendar;

public class Time {
	public int sec, min, hours, day, month, year;

	public Time(int sec, int min, int hours, int day, int month, int year) {
		setSec(sec);
		setMin(min);
		setHours(hours);
		setDay(day);
		setMonth(month);
		setYear(year);
	}

	public int getSec() {
		return sec;
	}

	public void setSec(int sec) {
		if (sec < 0 || sec > 60) {
			throw new IllegalArgumentException("This is not valid!");
		}
		this.sec = sec;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		if (min < 0 || min > 60) {
			throw new IllegalArgumentException("This is not valid!");
		}
		this.min = min;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		if (hours < 0 || hours > 24) {
			throw new IllegalArgumentException("This is not valid!");
		}
		this.hours = hours;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		if (day < 0 || day > 31) {
			throw new IllegalArgumentException("This is not valid!");
		}
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		if (month < 0 || month > 12) {
			throw new IllegalArgumentException("This is not valid!");
		}
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		if (year < 0 || year > 9999) {
			throw new IllegalArgumentException("This is not valid!");
		}
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
