package RaupeFlitzi;

import java.util.Scanner;


public class Main {

	public static Segment addBack(Segment head, String type) {
		Segment newNode = new Segment();
		newNode.type = type;
		newNode.next = null;

		if (head == null) // adding to empty list
			return newNode;

		Segment cur;
		for (cur = head; cur.next != null; cur = cur.next)
			;

		cur.next = newNode;
		return head;
	}
	
	public static void print(Segment head) {
		for (Segment cur = head; cur != null; cur = cur.next) {
			System.out.printf("(%s)\n", cur.type);
		}
	}
	
	public static void print(Segment head, int idx) {
		int count=0;
		for (Segment cur = head; cur != null; cur = cur.next) {
			if (count==idx) {
				System.out.printf("(%s)\n", cur.type);
			}			
			count++;
		}
		if (idx>count) {System.out.printf("Invalid index\n");}
	}
	
	public static void print(Segment head, String t) {
		boolean show=false;
		for (Segment cur = head; cur != null; cur = cur.next) {
			if (t.equals(cur.type)) {show=true;}
			if (show==true) {System.out.printf("(%s)\n", cur.type);} 
		}
	}
	
	public static Segment removeFront(Segment head) {
		if (head == null)
			return null;
		Segment tmp = head.next;
		head.next = null; // unlink
		head=tmp;
		return tmp;
	}
	
	public static Segment remove(Segment head, String t) {

		Segment prev=head;
		if (t.equals(head.type)) {
			head=removeFront(head);
		}

		for (Segment cur = head; cur != null; cur = cur.next) {
			if (t.equals(cur.type)) {
				prev.next = cur.next;
				return head;
				}
			prev=cur;
		}
		return head;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Segment head = new Segment();
		System.out.printf("Create:\n");
		System.out.printf(": ");
		head.type=sc.next();
		
		while (true) {
			System.out.printf(": ");
			String t = sc.next();

			if (t.equals("x"))
				break;
			else {
				addBack(head,t);
			}

		}

		System.out.printf("Action (p|g|d|s): ");
		char action = sc.next().charAt(0);
		String t;

		switch (action) {
		case 'p': /// Print
			print(head);
			break;
		case 'g': /// GetAt
			System.out.printf("Index: ");
			int idx = sc.nextInt();
			print(head,idx);
			break;
		case 'd': /// Delete
			System.out.printf("Type: ");
			t = sc.next();
			head=remove(head, t);
			break;
		case 's': /// Sublist
			System.out.printf("Type: ");
			t = sc.next();
			print(head,t);
			break;
		}

		check(head);

		/// ...

		sc.close();

	}

	/* Don't touch this */
	public static void check(Segment t) {
		Segment v = t;
		for (int c = 0; v != null; System.out.printf("\n%d.%d", c++, v.type.charAt(0) - 65), v = v.next)
			;
	}

}
