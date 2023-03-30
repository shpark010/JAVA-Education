package kr.or.kosa.common;

import java.util.Scanner;

public class test4 {

	public static void main(String[] args) {
		// 최대한 짧게 가위, 바위, 보 게임을 생성

		 Scanner sc = new Scanner(System.in);

	        while (true) {
	            System.out.print("가위(1), 바위(2), 보(3) 중 하나를 입력하세요 : ");
	            int user = Integer.parseInt(sc.nextLine());

	            if (user < 1 || user > 3) {
	                System.out.println("게임을 종료합니다.");
	                break;
	            }
	            int com = (int)(Math.random()*3) + 1;
	            String result = (com == user) ? "비겼습니다." 
	                          : (com == 1 && user == 3 || com == 2 && user == 1 || com == 3 && user == 2) ? "컴퓨터가 이겼습니다!" 
	                          : "사용자가 이겼습니다!";
	            System.out.println(result);
	        }
		
		


	}

}
