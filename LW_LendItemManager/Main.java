package LendItemManager;

import java.util.Scanner;


public class Main {
	
	static Scanner sc;
	
	public static String lendItemString(LendItem it, int format) {
		if (it.description==null) {return "";}
		else {
		if (format==1) {			
			return String.format("%1$-15.15s %2$-10.10s %3$s %4$s %5$-10.10s", it.description, it.lender, String.format("%1$4d.%2$02d.%3$02d",it.lendDate.year,it.lendDate.month,it.lendDate.day), String.format("%1$4d.%2$02d.%3$02d",it.returnDate.year,it.returnDate.month,it.returnDate.day), it.owner);
		} else if (format==2) {			
			return String.format("%1$-15.15s %2$-10.10s", it.description, it.lender);
		} else {			
			return String.format("\"%1$s\",\"%2$s\",\"%3$s\",\"%4$s\",\"%5$s\"", it.description, it.lender, String.format("%1$4d.%2$02d.%3$02d",it.lendDate.year,it.lendDate.month,it.lendDate.day), String.format("%1$4d.%2$02d.%3$02d",it.returnDate.year,it.returnDate.month,it.returnDate.day), it.owner);
		}
		}
	}
	
	private static String dateString(Date d) {
		if (d==null) {return "";}
		else return String.format("%1$4d.%2$02d.%3$02d",d.year,d.month,d.day);
	}
	
	public static int compare(LendItem it1, LendItem it2, int method) {
		if (method==1) {return compareByLendDate(it1,it2);}
		if (method==2) {return compareByReturnDate(it1,it2);}
		if (method==3) {return compareByLender(it1,it2);}
		if (method==4) {return compareByOwner(it1,it2);}
		else {return compareByDescription(it1,it2);}
	}
	
	public static int compareByLendDate(LendItem it1, LendItem it2) {
		//System.out.printf("it1: %s, it2: %s\n", dateString(it1.lendDate),dateString(it2.lendDate));
		if (dateString(it1.lendDate).compareTo(dateString(it2.lendDate))<0) {
			return -1;
		} else if (dateString(it1.lendDate).compareTo(dateString(it2.lendDate))==0) {
			return 0;
		} else if (dateString(it1.lendDate).compareTo(dateString(it2.lendDate))>0) {
			return 1;
		}
		return -1;
	}
	
	public static int compareByReturnDate(LendItem it1, LendItem it2) {
		if (dateString(it1.returnDate).compareTo(dateString(it2.returnDate))<0) {
			return -1;
		} else if (dateString(it1.returnDate).compareTo(dateString(it2.returnDate))==0) {
			return 0;
		} else if (dateString(it1.returnDate).compareTo(dateString(it2.returnDate))>0) {
			return 1;
		}
		return -1;	}
	
	public static int compareByDescription(LendItem it1, LendItem it2) {
		if (it1.description.compareTo(it2.description)<0) {
			return -1;
		} else if ((it1.description.compareTo(it2.description))==0) {
			return 0;
		} else if ((it1.description.compareTo(it2.description))>0) {
			return 1;
		}
		return -1;	}
	
	public static int compare(Date d1, Date d2) {
		if (dateString(d1).compareTo(dateString(d2))<0) {
			return -1;
		} else if (dateString(d1).compareTo(dateString(d2))==0) {
			return 0;
		} else if (dateString(d1).compareTo(dateString(d2))>0) {
			return 1;
		}
		return -1;	}
	
	public static int compareByLender(LendItem it1, LendItem it2) {
		if (it1.lender.compareTo(it2.lender)<0) {
			return -1;
		} else if ((it1.lender.compareTo(it2.lender))==0) {
			return 0;
		} else if ((it1.lender.compareTo(it2.lender))>0) {
			return 1;
		}
		return -1;	}	
	
	public static int compareByOwner(LendItem it1, LendItem it2) {
		if (it1.owner.compareTo(it2.owner)<0) {
			return -1;
		} else if ((it1.owner.compareTo(it2.owner))==0) {
			return 0;
		} else if ((it1.owner.compareTo(it2.owner))>0) {
			return 1;
		}
		return -1;	}	
	
	public static boolean equals(LendItem it1, LendItem it2) {
		//return it1.equals(it2);
		if (it1==null&&it2==null) {return true;}
		else if (it1==null^it2==null) {return false;}
		else if (compareByOwner(it1,it2)==0 && compareByLender(it1,it2)==0 && compareByDescription(it1,it2)==0 &&compareByReturnDate(it1,it2)==0 &&compareByLendDate(it1,it2)==0) {
			return true;
		} else return false;
	}	
	
	public static boolean equals(Date d1, Date d2) {
		//return d1.equals(d2);
		if (d1==null&&d2==null) {return true;}
		else if (d1==null^d2==null) {return false;}
		else if (dateString(d1).compareTo(dateString(d2))==0) {return true;}	
		else return false;
	}
	
	public static LendItem scanLendItem(Scanner sc) {
		LendItem LI=new LendItem();
		boolean done=false;
		while (done==false) {

			LI.description=sc.nextLine();
			
			LI.lender=sc.nextLine();
			
			LI.owner=sc.nextLine();

			if (LI.description.isEmpty()) {
				System.out.println("description can not be empty!");
				continue;
			}
			if (LI.lender.isEmpty()) {
				System.out.println("lender can not be empty!");
				continue;
			}
			done=true;
		} 

		LI.lendDate=scanDate(sc);
		LI.returnDate=scanDate(sc);
		return LI;
	}
	
	public static Date scanDate(Scanner sc) {
		Date DT=new Date();
		boolean done=false;
		while (done==false) {
			DT.year=sc.nextInt();
			if (DT.year<=1581) {
				continue;
			}
			DT.month=sc.nextInt();
			if (DT.month<1||DT.month>12) {
				continue;
			}
			DT.day=sc.nextInt();
			if (DT.day<1||DT.day>31) {
				continue;
			}
			done=true;
		}
		return DT;
	}	
	
	public static boolean isOut(LendItem li)  {
		if (li.returnDate==null) return true;
		else return false;
	}
	
	
	
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		LendItem it1 = new LendItem(), it2 = new LendItem();
		System.out.printf("Welcome to LendApp\n");
		int mode=0, format = 1;

		int input = 0;
		do {
			System.out.printf("enter opcode (9 for usage): ");
			input = sc.nextInt();
			switch (input) {
			case 1:
				it1 = scanLendItem(sc);
				continue;
			case 2:
				it2 = scanLendItem(sc);
				continue;
			case 3:
				System.out.printf("%s\n", lendItemString(it1, format));
				System.out.printf("%s\n", lendItemString(it2, format));
				continue;
			case 4:
				System.out.printf("set compare mode ("
						+ "1=by lend date, "
						+ "2=by return date, "
						+ "3=by lender, "
						+ "4=by owner, "
						+ "all other=by description: ");
				mode = sc.nextInt();
				continue;
			case 5:
				int cmp=compare(it1, it2, mode);
				if(cmp<0)
					System.out.printf("LendItem1 is before LendItem2.\n");
				else if(cmp>0)
					System.out.printf("LendItem1 is after LendItem2.\n");
				else 
					System.out.printf("LendItems are equal.\n");
				continue;
			case 6:
				System.out.printf("LendItem1 and LendItem2 are %s equal.\n", equals(it1, it2)?"":"not");
				continue;
			case 9:
				System.out.printf(  "1 enter LendItem1\n"
							+ "2 enter LendItem2\n"
							+ "3 print LendItem1 and 2\n"
							+ "4 set compare mode\n"
							+ "5 compare the LendItems\n"
							+ "6 check equality\n"
							+ "9 display this message\n"
							+ "0 exit\n");
				continue;
			case 0:
				continue;
			default:
				System.out.println("invalid op code");
			}

		} while (input != 0);
		sc.close();
		System.out.printf("Thank you for using LendApp.\n");
	}

	











}






