package WeekdaysFunctions;

import java.util.Scanner;

public class Main {
	
	public static boolean validate(int year) {
		boolean a;
		if (year > 1582 & year <2200) {
			a = true;
		} else {
			a = false;
		}
		return a;
	}
	public static boolean validate(int year, int month) {
		boolean a;
		
		if (validate(year) & month > 0 & month < 13)  {
			a = true;
		} else if (year == 1582 & month >10 & month < 13){
			a = true;
		} else {
			a = false;
		}
		return a;
	}
	public static boolean validate (int year, int month, int day) {
		boolean a;
		if (validate(year, month) & day > 0 & day <= nDays(month, year))  {
			a = true;
		} else if (year == 1582 & month == 10 & day > 15 & day < 32){
			a = true;
		} else {
			a = false;
		}
		return a;
	}
	public static boolean isLeap(int inYear) {
		return (((inYear % 4 == 0) && (inYear % 400 == 0 || inYear % 100 != 0)));
	}
	public static int nDays(int month, int year) {


		if ((((year % 4 == 0) && (year % 400 == 0 || year % 100 != 0) ))) {

			if (month == 2) {
				return 29;
			}
			else if ((month == 4) || (month == 6) || (month == 9) || (month == 11)) {
				return 30;
			}
			else {
				return 31;
			}

		}

		else if (year == 1582 && month == 10) {
			return 16;
		}
		else {

			if (month == 2) {
				return 28;
			}
			else if ((month == 4) || (month == 6) || (month == 9) || (month == 11)) {
				return 30;
			}
			else {
				return 31;
			}

		}

	
	}
	public static int weekday(int inDay, int inMonth, int inYear) {
		int W;
		int A;
		int d = inDay;
		int m = inMonth;
		
		if (m < 3) {
			inYear--;
			m = m +10;
		}
		else {
			m = m -2;
		}
		
		int c = inYear / 100;
		int y = inYear % 100;
		
		A = d + (int)(2.6*m - 0.2) + y + (int)(y/4) + (int)(c/4) - 2*c; 
		W = A % 7;
		
		if (W < 0) {
			W=W+7;
		}
		
		return W;
		
		}
	
	public static String dayName(int W) {
		String a;
		if (W == 0) {
			a = "Sunday"; 
		} else if (W == 1) {
			a = "Monday";
		} else if (W == 2) {
			a = "Tuesday";
		} else if (W == 3) {
			a = "Wednesday";
		} else if (W == 4) {
			a = "Thursday";
		} else if (W == 5) {
			a = "Friday";
		} else {
			a = "Saturday";
		}
		return a;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("enter date (yyyymmdd): ");
		int date = sc.nextInt();
		
		int inDay = date % 100, inMonth = date % 10000 / 100, inYear = date / 10000;
		
		if(validate(inYear, inMonth, inDay)){
			int W = weekday(inDay, inMonth, inYear);
			String weekday = dayName(W);
			
			System.out.printf("%s",  weekday);
			
		}else {
			System.out.printf("invalid date (%d)\n", date);
		}
		sc.close();
	}
}
