package kr.or.kosa.common;

import java.util.Scanner;

public class test3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("금액 : ");
		int MONEY = Integer.parseInt(sc.nextLine());	//데이터 입력
		
		int UNIT = 10000;	//화폐 단위
		int NUM = 0;		//화폐 매수
		int SW = 0;			//스위칭 변수
		
		//반복문(while)
		while(true) {
			NUM = MONEY / UNIT;	//입력받은 금액을 화폐 단위로 나누어 단위당 매수를 측정
			System.out.printf("[화폐 단위]  %d원 : [화폐 매수] %d개\n",UNIT, NUM);
			
			if(UNIT <= 1) {	//화폐 단위가 1보다 아래면 멈춤
				break;
			}
			MONEY = MONEY - (NUM*UNIT);	//계산된 화폐 단위별 금액을 총액에서 제외
			//스위칭 변수를 활용한 다음 화폐 단위 설정
			if(SW == 0) {
				UNIT = UNIT / 2;
				SW = 1;
			}else {
				UNIT = UNIT / 5;
				SW = 0;
			}
			
		}		
	}

}
