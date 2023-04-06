import java.util.Scanner;

public class Machine {
	//고유정보
	private String model;	//모델
	private String company;	//제조사
	private String color;	//색상
	
	//부품정보		각각의 음료를 Drink 클래스를 이용해 객체 생성
	private Drink cola;	
	private Drink soda;	
	private Drink energy;
	private Drink pocari;
	
	//상태정보
	private int inputMoney;	//투입 금액
	private Drink selectDrink;	//선택된 음료 정보
	
	Scanner sc = new Scanner(System.in);
	

	//자판기 객체 생성시 고유정보 및 각 음료별 정보 초기화
	public Machine() {
		this.model = "캔음료 자판기";
		this.company = "더존자판기";
		this.color = "red";
		this.cola = new Drink("콜라", 1200, 15);
		this.soda = new Drink("사이다", 1000, 10);
		this.energy = new Drink("에너지드링크", 1500, 12);
		this.pocari = new Drink("포카리", 900, 5);
		this.inputMoney = 0;
		this.selectDrink = null;
		}
	
	//실행
	public void run() {
		System.out.println("****************");
		System.out.println("***캔 음료 자판기***");
		System.out.println("****************");
		while(true) {
			if(inputMoney == 0) {
				System.out.println("금액을 투입해 주세요");
				System.out.println("(종료를 원하시면 '종료'를 입력해 주세요)");
				System.out.print("입력란 : ");
				String input = sc.nextLine();
				//입력받은 금액정보 비교(금액 or 종료)
				int moneyCheck = insertMoney(input);	
				// 종료 입력시
				if(moneyCheck == 0) {
					System.exit(0);
				}else {	// 금액 입력시
					//투입 금액 출력
					System.out.println("투입한 금액: " + input);
					while (true) {
						System.out.println("음료를 선택하세요.");
						//사용자가 선택한 음료 정보를 설정
						int selectDrinkNum = choice();	//사용자가 선택한 음료의 번호를 저장
						Drink selectDrink = selectDrinkInfo(selectDrinkNum);	//음료 번호에 따른 음료 정보 설정
						if(selectDrink == null) {
							System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
							continue; // 다시 음료 선택 부분으로 돌아가도록 함
						}else {
							if(selectDrink.getAmount() > 0) {	//음료의 수량이 0개보다 많을 때
								notice();	//선택한 음료의 정보를 출력
								compare();	//투입 금액과 음료 가격을 비교
								break;
							}else {	//품절인 경우
								System.out.println("해당 상품은 품절입니다. 다른 상품을 골라주세요");
								continue;
							}
							
						}
					}					
				}
			}else {
				//투입 금액 출력
				System.out.println("투입한 금액: " + inputMoney);
				while (true) {
					System.out.println("음료를 선택하세요.");
					//사용자가 선택한 음료 정보를 설정
					int selectDrinkNum = choice();	//사용자가 선택한 음료의 번호를 저장
					Drink selectDrink = selectDrinkInfo(selectDrinkNum);	//음료 번호에 따른 음료 정보 설정
					if(selectDrink == null) {
						System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
						continue; // 다시 음료 선택 부분으로 돌아가도록 함
					}else {
						if(selectDrink.getAmount() > 0) {	//음료의 수량이 0개보다 많을 때
							notice();	//선택한 음료의 정보를 출력
							compare();	//투입 금액과 음료 가격을 비교
							break;
						}else {	//품절인 경우
							System.out.println("해당 상품은 품절입니다. 다른 상품을 골라주세요");
							continue;
						}
						
					}
				}					
			}
			
		}
	}

	//금액 입력 받기
	public int insertMoney(String input) {
		if(input.equals("종료")) {
			returnInputMoney();
			return 0;
		}else {
			this.inputMoney = Integer.parseInt(input);
			return 1;			
		}
	}
	
	//음료 선택
	public int choice() {
		System.out.println("==========================");
        System.out.println("1. " + cola.getDrinkName() +" : " + cola.getPrice() + "원");
        System.out.println("2. " + soda.getDrinkName() + " : " + soda.getPrice() + "원");
        System.out.println("3. " + energy.getDrinkName() + " : " + energy.getPrice() + "원");
        System.out.println("4. " + pocari.getDrinkName() + " : " + pocari.getPrice() + "원");
        System.out.println("종료를 원하시면 \"종료\"를 입력해 주세요");
        System.out.println("==========================");
        System.out.print("음료 선택 : ");
        String choice = sc.nextLine();
        int choiceNum=0;
        if(choice.equals("종료")) {
        	returnInputMoney();
        	return 0;
        }else {
        	choiceNum = Integer.parseInt(choice);
        	System.out.println("==========================");
        	return choiceNum;        	
        }
	}
	
	//선택된 음료 정보 담기
	public Drink selectDrinkInfo(int selectDrinkNum) {
	        switch (selectDrinkNum) {
		        case 1:
		        	selectDrink = cola;
		            break;
		        case 2:
		        	selectDrink = soda;
		            break;
		        case 3:
		        	selectDrink = energy;
		            break;
		        case 4:
		        	selectDrink = pocari;
		            break;
		        default:
		            System.out.println("잘못된 입력입니다. 다시 선택해 주세요");
		            selectDrink = null;
		            break;
	        }
        return selectDrink;
	}
	
	//진행상황 알려주기
	public void notice() {
		System.out.println("==========================");
		System.out.println("선택하신 음료는 " + selectDrink.getDrinkName() + "입니다.");
		System.out.println("선택하신 음료의 재고 수량은 " + selectDrink.getAmount() + "입니다.");		
		System.out.println("가격은 " + selectDrink.getPrice() + "원입니다.");
		System.out.println("현재 투입된 금액은 " + this.inputMoney + "원입니다.");
		System.out.println("==========================");
	}
	

	//투입 금액과 음료 가격 비교
	public void compare() {
		if(this.inputMoney >= selectDrink.getPrice()) {	//투입 금액이 음료 가격보다 클 경우
			buyDrink();	// 음료 구매 함수
		}else {
			confirm();	// 추가 투입 여부 확인
		}
	}
	
	//음료 구매
	public void buyDrink() {
		System.out.println("구매하시겠습니까? (Y/N)");
		String answer = sc.nextLine();
		if (answer.equals("Y") || answer.equals("y")) {	//구매 확정
			selectDrink.decreaseAmount();
			this.inputMoney -= selectDrink.getPrice();	// 잔돈 계산
			System.out.println(selectDrink.getDrinkName() + " 음료를 구매하셨습니다.");
//			System.out.println("거스름돈 " + change + "원을 반환합니다.");
//			System.out.println("저희 자판기를 이용해 주셔서 감사합니다.");
//			System.out.println("=============================");
		} else if (answer.equals("N") || answer.equals("n")) {//구매 취소
			returnInputMoney();
		} else {
			System.out.println("잘못된 입력입니다. 다시 시도해주세요.");	//다른 값 입력
			buyDrink();	//재귀호출
		}
	}
	//투입 금액 반환
	public void returnInputMoney() {
		System.out.println("투입하신 금액 " + inputMoney + "원을 반환합니다.");
		inputMoney = 0;	//투입금액 0으로 초기화
		selectDrink = null;	//선택 음료 정보 null로 초기화
		System.out.println("저희 자판기를 이용해 주셔서 감사합니다.");
		System.out.println("=============================");
		System.exit(0);
	}
	
	//부족 금액 투입 여부
	public void confirm() {
		int shortageMoney = selectDrink.getPrice() - inputMoney;	//부족한 금액 계산
		System.out.println(shortageMoney + "원이 부족합니다.");
		System.out.println("1. 추가 투입 / 2. 취소");
		int selectMenu = Integer.parseInt(sc.nextLine());	
        if (selectMenu == 1) {
            System.out.println("추가로 투입할 금액을 입력하세요:");
            inputMoney += Integer.parseInt(sc.nextLine());	//추가 투입 금액 합산
            compare();
        } else if (selectMenu == 2) {
        	returnInputMoney();	//잔돈 반환 및 초기화
        } else {
            System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
            confirm();	// 재귀호출
        }
	}
	
	
	
	
}
