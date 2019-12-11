package Postfix;


import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		CustomStack<Integer> numbers = new CustomStack<>();

		while (sc.hasNext()==true) {
			String input=sc.next();
			if (input.equals("+")) {
				numbers.push(numbers.pop()+numbers.pop());
			} else if (input.equals("-")) {
				numbers.push((numbers.pop()-numbers.pop())*-1);
			} else if (input.equals("*")) {
				numbers.push(numbers.pop()*numbers.pop());
			} else if (input.equals("/")) {
				int tmp=numbers.pop();
				numbers.push(numbers.pop()/tmp);
			} else if (input.equals("%")) {
				int tmp=numbers.pop();
				numbers.push(numbers.pop()%tmp);
			} else if (input.equals("=")) {
				break;
			} else {
				numbers.push(Integer.parseInt(input));
			}
			}
		System.out.println(numbers.pop());			
		sc.close();
	}
}
