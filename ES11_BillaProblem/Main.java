package BillaProblem;


import java.util.Scanner;



public class Main {
	
	public static persons addBack(persons head, String name) {
		persons newNode = new persons();
		newNode.name = name;
		newNode.next = null;

		
		if (head.name == null ) {// adding to empty list
			head.name=name;
			return head;
			}

		persons cur;
		for (cur = head; cur.next != null; cur = cur.next)
			;

		cur.next = newNode;
		return head;
		
		
	}
	
	public static void print(persons head) { 
		for (persons cur = head; cur != null &&cur.name!= null; cur = cur.next) {
			System.out.printf("%s ", cur.name);
		}
		System.out.printf("\n");

	}
	
	public static persons removeFront(persons head) {
		if (head == null)
			return null;
		persons tmp = head.next;
		head.next = null; // unlink
		return tmp;
	}


	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		persons head = new persons();
		persons head1 = new persons();
		persons head2 = new persons();

		int count=0;
		int count1=0;
		int count2=0;

		while (true) {
			String n;
			System.out.printf(": ");
			n = sc.next();

			if (n.equals("-"))
				break;

			addBack(head,n);
			count++;
		}

		boolean run = true;
		while (run) {
			System.out.printf("Personen: %d\n", count);
			if (head==null) {System.out.println();} else {print(head);}
			System.out.printf("Kassa 1: %d\n",count1);
			if (head1==null) {System.out.println();} else {print(head1);}
			System.out.printf("Kassa 2: %d\n",count2);
			if (head2==null) {System.out.println();} else {print(head2);}
			System.out.printf(": ");
			char c = sc.next().charAt(0);

			if (c==('-')) {

				break;
			}

			switch (c) {
			case '-':
				run = false;
				
				break;
			case 'a':
				if(count1<=count2) {
					if (head1 == null) {head1=new persons();}
						addBack(head1,head.name);
					count1++;
				}
				else {
					if (head2 == null) {head2=new persons();}
					addBack(head2,head.name);
					count2++;
				}
				head = removeFront(head);
				count--;
				break;
			case '1':
				head1=removeFront(head1);
				count1--;
				break;
			case '2':
				head2=removeFront(head2);
				count2--;
				break;
			}
		}

		sc.close();

	} 
}
