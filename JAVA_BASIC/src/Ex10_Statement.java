import java.util.Scanner;

public class Ex10_Statement {

	public static void main(String[] args) {
		
		//반복문 (while, do ~ while)
		int i = 10;
		while(i >= 10) {
			//반드시
			//증가감을 통해서 true, false 판단
			//--i;
			System.out.println(i);
			--i;
		}
		
		//while을 이용한 1 ~ 100 까지의 합
		int sum = 0;
		int j = 1;
		while(j <= 100) {
			sum+=j;
			j++;
		}
		System.out.println(sum);
		
		
		//while문을 이용한 구구단 작성
		int a = 2;		
		int b= 1;
		while(a<=9) {
			System.out.printf("%d 단\n", a);
			b = 1;
			while(b<=9) {
				System.out.printf("%d * %d = %d\n",a,b,a*b);
				b++;				
			}
			System.out.println();
			a++;
		}

		
		int a2 = 2;		
		while(a2<=9) {
			int b2 = 1;
			System.out.printf("%d 단\n", a2);
			while(b2<=9) {
				System.out.printf("%d * %d = %d\n",a2,b2,a2*b2);
				b2++;				
			}
			System.out.println();
			a2++;
		}
		
		//for(;;) { if(조건) break; }
		//while(true) { if(조건) break; }
		//do ~ while : 일단 한번은 강제적으로 수행 ... 그리고 조건을 보고 판단한다.
		//do { 실행블럭 } while(조건판단) { }
		/*
		메뉴구성
		점심 메뉴를 선택하세요
		1. 짜장
		2. 짬뽕
		3번 입력값 하면 잘못된 입력입니다...
		다시 메뉴를 보여주기
		
		*/
		
		Scanner sc = new Scanner(System.in);
		int inputData = 0;
		do {
			System.out.println("숫자 입력해 (0~9)");
			inputData = Integer.parseInt(sc.nextLine());
		}while(inputData >= 10);	//while 조건 true : 계속해서 do 문을 실행
									//while 조건 false : do 실행 안함
		System.out.println("당신이 입력한 숫자는 : " + inputData);
		
		
		
		
	}

}
