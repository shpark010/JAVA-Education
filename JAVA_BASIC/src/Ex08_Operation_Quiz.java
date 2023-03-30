import java.util.Scanner;

public class Ex08_Operation_Quiz {

	public static void main(String[] args) {
		/*
		간단한 사칙 연산기 (+ , - , * , /)
		입력값 3개 (입력값은 nextLine() 받아서 필요하다면 숫자 변환)
		목적 : Integer.parseInt() , ** 구글 java equals() 활용 문자열의 비교** 
		
		화면
		>입력값:숫자
		>입력값(기호): +
		>입력값:숫자 
		>연산결과 :200

		-------------

		>입력값:100
		>입력값(기호): -
		>입력값:100
		>연산결과 :0

		hint)

		■ if문은 조건값이 boolean형, 
		■ switch문은 정수형(byte, short, int)과 문자형(char), 문자열(String)
		■ long, boolean, float, double형 사용 불가
	
		Scanner sc = new Scanner(System.in);
		String ch = sv.nextLine();
		switch(ch) {
			case "+" :
				System.out.println(
		}
		*/
		Scanner sc = new Scanner(System.in);
		System.out.print("입력값 : ");
		int score1 = Integer.parseInt(sc.nextLine());
		System.out.print("입력값(기호) : ");
		String op = sc.nextLine();
		System.out.print("입력값 : ");
		int score2 = Integer.parseInt(sc.nextLine());
		int result = 0;
		
		/*
		switch(op) {
		case "+":
			result = score1 + score2;
			break;
		case "-" :
			result = score1 - score2;
			break;
		case "*" :
			result = score1 * score2;
			break;
		case "/" :
			result = score1 / score2;
			break;
		default :
			System.out.println("잘못된 연산입니다.");
		}
		*/
		
		if(op.equals("+")) {
			result = score1 + score2;
		}else if(op.equals("-")) {
			result = score1 - score2;
		}else if(op.equals("*")) {
			result = score1 * score2;
		}else if(op.equals("/")) {
			result = score1 / score2;
		}else {
			System.out.println("잘못된 연산자 입니다.");
		}

		System.out.printf("연산결과 : %d", result);
	}

}
