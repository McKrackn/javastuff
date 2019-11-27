package AnnaOrElsa;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Question questions[];
		questions=new Question[6];
		int nextQ=0;
		
		extracted(questions);
		
		while (nextQ<6) {
		System.out.printf("%s?: ",questions[nextQ].text);
		char input = sc.next().charAt(0);
		if (input=='+') {
			nextQ=questions[nextQ].on_yes;
		} else if (input=='-') {
			nextQ=questions[nextQ].on_no;
		}
		//System.out.printf(input);

		
		}
		if (nextQ==6) {
			System.out.printf("ELSA");
		} if (nextQ==7) {
			System.out.printf("ANNA");
		}
		
		sc.close();
	
	}

	private static void extracted(Question[] questions) {

		
		questions[0]=new Question();
		questions[0].text="Winter";
		questions[0].on_no=1;
		questions[0].on_yes=2;
		
		questions[1]=new Question();
		questions[1].text="Mutig";
		questions[1].on_no=4;
		questions[1].on_yes=5;
		
		questions[2]=new Question();
		questions[2].text="Allein";
		questions[2].on_no=4;
		questions[2].on_yes=3;
		
		questions[3]=new Question();
		questions[3].text="Abenteuer";
		questions[3].on_no=6;
		questions[3].on_yes=4;
		
		questions[4]=new Question();
		questions[4].text="Rentiere";
		questions[4].on_no=6;
		questions[4].on_yes=7;
		
		questions[5]=new Question();
		questions[5].text="Gehemnis";
		questions[5].on_no=7;
		questions[5].on_yes=4;
	}
}
