package kr.or.kosa.common;

import java.util.Iterator;

public class test {

	public static void main(String[] args) {
		
		/*
		1번
		문제 : 알파벳(A~Z)까지 출력하는 프로그램 작성
		조건 : (for 문을 사용하세요)
		*/
		for (char i = 'A'; i <= 'Z'; i++) {
			System.out.print(i);
		}
		
		/*
		2번
		문제 : 1~100까지 10행 10열로 출력하는 프로그램을 작성하세요.
		조건 : (for문을 사용하세요)
		예시) 1 2 3 4 5 6 7 8 9 10
			 11 12 13 ...........
			 91 92 93 94 95 96 ..... 100
		*/
		for (int i = 0; i <= 100 ;i++) {
			System.out.print(i + " ");
			if(i % 10 == 0) {
				System.out.println();
			}
		}
		
		/*
		3번
		문제 : 두개의 주사위를 던졌을 때 눈의 합이 6이 되는 모든 경우의 수를 출력하는 프로그램을 작성하세요
		*/
		for (int i = 1 ; i <= 6 ; i++) {
			for (int j = 1 ; j <= 6 ; j++) {
				if(i + j == 6) {
					System.out.printf("%d : %d\n", i, j);
				}
			}
		}
		
		
		
		
		
	}

}
