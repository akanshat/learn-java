package com.rakuten.training.basics;

public class DowFinder {
	public void findDOW(int day, int month, int year) {
		int totalDays = 0;
		for (int y = 1990; y <= year; y++) {
			for (int m = 1; m <= 12; m++) {
				if(y==year && m == month)
					break;
				switch (m) {
				case 1:
					totalDays += 31;
					break;
				case 2:
					if (y % 4 == 0 && y % 100 == 0 && y % 400 == 0)
						totalDays += 29;
					else
						totalDays += 28;
					break;
				case 3:
					totalDays += 31;
					break;
				case 4:
					totalDays += 30;
					break;
				case 5:
					totalDays += 31;
					break;
				case 6:
					totalDays += 30;
					break;
				case 7:
					totalDays += 31;
					break;
				case 8:
					totalDays += 31;
					break;
				case 9:
					totalDays += 30;
					break;
				case 10:
					totalDays += 31;
					break;
				case 11:
					totalDays += 30;
					break;
				case 12:
					totalDays += 31;
					break;
				}
			}
			totalDays+=day;
		}
		
		int remainder = totalDays%7;
		String dayOfWeek = "";
		switch(remainder) {
		case 0:
			dayOfWeek="sunday";
			break;
		case 1:
			dayOfWeek="monday";
			break;
		case 2:
			dayOfWeek="tuesday";
			break;
		case 3:
			dayOfWeek="wednesday";
			break;
		case 4:
			dayOfWeek="thursday";
			break;
		case 5:
			dayOfWeek="friday";
			break;
		case 6:
			dayOfWeek="saturday";
			break;
		}
		
		System.out.println(dayOfWeek);
	}
	

	
	public static void main(String[] args) {
		DowFinder finder = new DowFinder();
		finder.findDOW(4, 2, 2021);
	}
}
