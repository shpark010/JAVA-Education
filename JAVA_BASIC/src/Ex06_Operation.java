
public class Ex06_Operation {

	public static void main(String[] args) {
		
		//대입 연산자
		//+=, -=, *=, /=
		
		int sum = 10;
		sum+=1;	//sum = sum + 1;
		sum-=1;	//sum = sum - 1;
		System.out.println("sum : " + sum);
		
		/*
		if(조건식) { 1 } : 조건식이 true라면 1
		
		if(조건식) { 1 } else { 2 } : 조건식이 true라면 1을, false라면 2
		
		if(조건식) { 1 } else if(조건식){ 2 } else if ... else { }
		
		간단한 학점 계산기
		
		학점 : A+, A-, B+, B-, ..., F
		
		판단기준 : 90점 이상 이고 95점 이상 이면
		//90 A (다시 판단 95 A+, A-), 80 B (다시 판단 85 B+, B-), 70... 나머지 F
		
		*/
		int score = 94;
		String grade = "";
		if(score >= 90) {
			grade = "A";
//			if(score >= 95) {
//				grade += "+";
//			}else {
//				grade += "-";		
//			}
			//삼항연산자
			grade = (score >= 95) ? (grade += "+") : (grade += "-");
		}else if(score >= 80) {
			grade = "B";
			if(score >= 85) {
				grade += "+";
			}else {
				grade += "-";		
			}
		}else if(score >= 70) {
			grade = "C";
			if(score >= 75) {
				grade += "+";
			}else {
				grade += "-";		
			}
		}else {
			grade = "F";
		}
		System.out.println("당신의 점수는 : " + score);
		System.out.println("당신의 학점은 : " + grade);
		
		
		for (char i = 'A' ; i <= 'Z' ; i++) {
			System.out.println(i);
		}
		
		for (int i = 65 ; i <= 90 ; i++) {
			System.out.println((char)i + " ");
		}
		
		System.out.println();	//엔터처리
		
		for (int i = 1 ; i <= 100 ; i++) {
			System.out.print(i + " ");
			if(i % 10 == 0) {
				System.out.println();
			}
		}
		
		//입사시험 (가장 많이 나오는 문제)
		//hint) 제어문 (반복문)
		//구구단	(행 & 열 개념)
		for (int i = 2; i <= 9 ; i++) {
			System.out.println(i + " 단");
			for (int j = 1; j <= 9 ; j++) {
				//System.out.println(i + " X " + j + " = " + i*j);
				System.out.printf("%d X %d = %d\t", i, j, i*j);
			}
			System.out.println();
		}
		
		
	}

}
