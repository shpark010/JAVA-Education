
public class Ex09_Statement {

	public static void main(String[] args) {
		/*
		제어문
		조건문 : if(3가지), switch(조건) { case 값 ... break }
		반복문 : for(){}, while(){}, do{} ~ while()
		분기문 : break(블럭탈출), continue(아래 구문은 skip)
		*/
		int count = 0;
		if(count < 1) System.out.println("true");	//단일 if문 : {}생략 가능
		
		if(count < 1) {
			System.out.println("{ true }");
		}
		
		char data = 'A';
		switch (data) {
		case 'A' :
			System.out.println("문자 비교 같아요");
			break;
		case 'B' :
			System.out.println("...");
			break;
		default :
			System.out.println("나머지 처리");
		}
		
		//for문
		//1~100까지 합
		int sum = 0;
		for (int i = 0 ; i <= 100 ; i++) {
			//System.out.println(i);
			sum+=i;	//sum = sum + i;
		}
		System.out.printf("1~100까지 누적 합 : %d \n", sum);
		
		
		//1~5까지의 합
		//for문과 while 쓰지 말고
		sum = 5 * (5+1) /2;
		System.out.println("sum : " + sum);
		
		int sum2 = 0;
		//1~10가지의 홀수 합
		for (int i = 1; i <= 10 ; i+=2) {	//i=i+2
			sum2+=i;
		}
		System.out.println("sum2 : " + sum2);
		
		
		//for문에ㅓ if문 사용해서 1~1000까지 짝수의 합을 구하세요
		int sum3 = 0;
		for (int i = 1; i <= 1000; i++) {
			if(i % 2 == 0) {
				sum3+=i;
			}
		}
		System.out.println("sum3 : " + sum3);
		
		//구구단
		for (int i = 2; i <= 9; i++) {
			System.out.printf("%d 단\n", i);
			for (int j = 1; j <= 9 ; j++) {
				System.out.printf("%d X %d = %d\n", i, j, i*j);
			}
			System.out.println();
		}
		
		//for문 + 분기문 (continue, break)
		//초급자 Today Point (continue(아래 구문 skip), break(for, while 블럭 탈출))
		
		for (int i = 2; i <= 9; i++) {
			for (int j = 1; j <= 9 ; j++) {
				if(i == j) {
					break;	//for 블럭 탈출
				}
				System.out.printf("%s","*");
			}
			System.out.println();
		}
		
		for (int i = 2; i <= 9; i++) {
			for (int j = 1; j <= 9 ; j++) {
				if(i == j) {
					continue; //continue 아래 구문 skip : System.out.printf("%d X %d = %d\n", i, j, i*j); 
				}
				System.out.printf("%d X %d = %d\n", i, j, i*j);
			}
			System.out.println();
		}
		
		for (int i = 2; i <= 9; i++) {
			for (int j = 1; j <= i ; j++) {
				System.out.printf("%s","*");
			}
			System.out.println();
		}
		
		//100부터 0까지의 출력
		for (int i = 100 ; i >= 0 ; i--) {
			System.out.println(i);
		}
		
		//초보가 아닌 사람 : 피보나치 수열
		int a = 0 , b = 1, c = 0;
		for(int i = 0 ; i < 10 ; i++) {
			a = b;
			b = c;
			c = a + b;
			System.out.printf("%d * %d = %d", a, b, c);
			System.out.println("  " + c);
		}
	}

}
