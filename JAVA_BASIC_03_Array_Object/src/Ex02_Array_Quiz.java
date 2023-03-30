
public class Ex02_Array_Quiz {

	public static void main(String[] args) {
		//문제1
		//국문과 학생들의 기말고사 시험점수입니다.
		int[] score = new int[] {79,88,97,54,56,95};
		int max = score[0];	//max < 79
		int min = score[0];	//min < 79
		/*
		[제어문]을 통해서 
		1. max 라는 변수에 시험점수중에 최대값을 담고
		2. min 변수에 시험점수중에 최소값을 담으세요
		출력결과 : max >> 97, min >> 54
		단) for문을 한번만 사용하세요
		*/
		for (int i = 0 ; i < score.length ; i++) {
			max = (score[i] > max) ? score[i] : max;
			min = (score[i] < min) ? score[i] : min;
		}
		System.out.printf("최소값 : [%d]\n",max);
		System.out.printf("최소값 : [%d]\n",min);
		
		
		//문제2
		//10개의 방의 값을 1 ~ 10까지로 초기화하고 출력하세요
		int[] numbers = new int[10];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = i+1;
			System.out.println(numbers[i]);
		}
		
		//문제3
		//어느 학생의 기말고사 시험점수 (5과목)
		int[] jumsu = {100,55,90,60,78};
		int sum = 0;
		float avg = 0f;
		
		for (int i = 0; i < jumsu.length; i++) {
			sum += jumsu[i];			
			if(i == jumsu.length - 1) {
				avg = (float)sum/jumsu.length;
			}
		}
		
		//1. 총과목의 수
		System.out.println("총과목의 수 : " + jumsu.length + "과목");
		//2. 과목의 합
		System.out.println("과목의 합 : " + sum + "점");
		//3. 과목의 평균
		System.out.printf("과목의 평균 : %f점", avg);
		
		//단, 2,3 문제는 하나의 for문으로 해결
	}

}
