import java.util.Scanner;

public class Ex11_Statement_Quiz {

	public static void main(String[] args) {
		//메뉴를 보여주고 사용자에게 선택
		//원하시는 메뉴를 선택하지 않으면 강제로 다시 메뉴를 보여주세요
		
		//1.예금 2.출금 3.잔고 4.종료
		
		//예금 처리
		//잔액 변수 생성(balance)
		//예금 처리 : + 누적
		//출금 처리 : - 누적
		//잔고 처리 : balance 출력
		//종료 처리 : 종료
		
		int balance = 50000;
		boolean run = true;
		Scanner sc = new Scanner(System.in);
		while(run) {
			System.out.println("원하시는 기능을 선택하세요.");
			System.out.println("========================");
			System.out.println("1.예금 2.출금 3.잔고 4.종료");
			System.out.println("========================");
			int num = Integer.parseInt(sc.nextLine());
			switch(num) {
				case 1 :
					System.out.println("예금을 선택하셨습니다.");
					System.out.println("예금하실 금액을 입력해 주세요.");
					System.out.print("예금액 : ");
					int deposit = Integer.parseInt(sc.nextLine());
					balance += deposit;
					System.out.println(deposit + "원이 예금되었습니다.\n");
					break;
				case 2 :
					System.out.println("출금을 선택하셨습니다.");
					System.out.println("출금하실 금액을 입력해 주세요.");
					System.out.print("출금액 : ");
					int withdraw = Integer.parseInt(sc.nextLine());
					if(balance-withdraw < 0 ) {
						System.out.println("잔액이 부족합니다.");
					}else {
						balance -= withdraw;
						System.out.println(withdraw + "원이 출금되었습니다.\n");						
					}
					break;
				case 3 :
					System.out.println("잔고확인을 선택하셨습니다.");
					System.out.println(balance + "원\n");
					break;
				case 4 :
					System.out.println("종료를 선택하셨습니다.");
					run =false;
					break;
				default :
					System.out.println("다시 선택해 주세요");
			}
		
		}
	}

}
