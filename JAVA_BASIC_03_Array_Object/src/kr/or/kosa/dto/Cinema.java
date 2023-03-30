package kr.or.kosa.dto;

import java.util.Random;
import java.util.Scanner;

public class Cinema {
	private String[][] seat = new String[4][5];
	private int seatChoiceRow;
	private int seatChoiceCol;
	private int menuChoice;
	private int detailMenuChoice;
	private String[][] reservationNum = new String[4][5];
	private String inputNumber;

	

	Scanner sc = new Scanner(System.in);

	public Cinema() {
		for (int i = 0; i < seat.length; i++) {
			for (int j = 0; j < seat[i].length; j++) {
				seat[i][j] = "[" + (i + 1) + "-" + (j + 1) + "]";
			}
		}
	}

	// 영화 예매 실행
	public void run() {
		while (true) {
			start();
			menu();
			selecMenu();
		}
	}

	// 시작
	public void start() {
		System.out.println("*********************");
		System.out.println("*****영화 예매 시스템*****");
		System.out.println("*********************");
	}

	// 메뉴
	public int menu() {
		System.out.println("1. 예매하기");
		System.out.println("2. 조회하기");
		System.out.println("3. 취소하기");
		System.out.print("메뉴 선택 : ");
		this.menuChoice = Integer.parseInt(sc.nextLine());
		return menuChoice;
	}

	// 메뉴 선택시
	public void selecMenu() {
		switch (menuChoice) {
			//1. 예매하기
			case 1:
				boolean run = false;
				while (!run) {
					seatCondition();
					inputSeat();
					if (checkingReservation(seatChoiceRow, seatChoiceCol)) {
						continue;
					} else {
						switch(reservation()) {
						case 1 : 
							System.out.println("좌석을 다시 선택해 주세요.");
							continue;
						case 2 :
							System.out.println("초기화면으로 돌아갑니다.");
							run = true;
							break;
						default :
							run=!run;
							break;
						}
					}
				}
				break;
			//2. 조회하기
			case 2 : 
				reservationInquiry();
				break;
			//3. 취소하기
			case 3 :
				boolean cancelRun = false;
				while (!cancelRun) {
					switch(cancel()) {
					case 1 :
						System.out.println("예매가 취소되었습니다.");
						cancelRun=!cancelRun;
						break;
					case 0 :
						System.out.println("잘못된 입력값입니다. 다시 입력해 주세요.");
						continue;
					default :
						System.out.println("초기화면으로 돌아갑니다.");
						cancelRun=!cancelRun;
						break;
					}
				}
				
				

		}
	}

	// 좌석 현황
	public void seatCondition() {
		System.out.println("*******좌석 현황*******");
		for (String[] strings : seat) {
			for (String string : strings) {
				System.out.print(string);
			}
			System.out.println();
		}
	}

	// 좌석 입력
	public void inputSeat() {
		System.out.println("좌석을 선택해 주세요. 예)1-1");
		System.out.println("이미 예매된 좌석은 \"예매\"라고 표시됩니다.");
		System.out.print("좌석 입력 : ");
		String[] inputSeat = sc.nextLine().split("-");
		this.seatChoiceRow = Integer.parseInt(inputSeat[0]);
		this.seatChoiceCol = Integer.parseInt(inputSeat[1]);
	}

	// 예매
	public int reservation() {
		System.out.println("예매 가능한 좌석입니다. 예매하시겠습니까?");
		System.out.println("네(1), 아니오(2), 초기화면(0)중 하나를 입력해주세요.");
		System.out.print("예매 선택 : ");
		this.detailMenuChoice = Integer.parseInt(sc.nextLine());
		int reNum = 0;
		switch(detailMenuChoice) {
			case 1 :
				while(true) {
					int cNum = checkingRandom();
					if(cNum==0) {
						break;
					}
				}
				System.out.println("예매가 완료되었습니다.");
				seat[seatChoiceRow-1][seatChoiceCol-1] = "[예매]";
				System.out.printf("예매한 좌석번호 : [%d-%d]\n",seatChoiceRow,seatChoiceCol);
				break;
			case 2 :
				System.out.println("입력하신 좌석의 예매가 취소되었습니다.");
				reNum = 1;
				break;
			default :
				System.out.println("초기화면으로 돌아갑니다.");
				reNum = 2;
				break;
		}
		return reNum;
	}

	// 난수 중복 확인 및 설정
	public int checkingRandom() {
		Random random = new Random();
		//0부터 999999999까지의 난수를 생성하고 빈 부분을 0으로 채우는 format
	    String randomStr = String.format("%09d", random.nextInt(1000000000));
		int number = 0;
		for (int i = 0; i < reservationNum.length; i++) {
			for (int j = 0; j < reservationNum[i].length; j++) {
				if (reservationNum[i][j] == randomStr) {
					number = 1;
					break;
				}
				else {
					number = 0;
				}
			}
		}
		if(number==0) {
			this.reservationNum[seatChoiceRow-1][seatChoiceCol-1] = randomStr;			
		}
		System.out.println("난수배열" + reservationNum[seatChoiceRow-1][seatChoiceCol-1]);
		System.out.println("예매 번호는 " + randomStr + "입니다.");
		return number;
	}

	// 예매 가능 여부 확인
	public boolean checkingReservation(int row, int col) {
		if (seat[row-1][col-1].equals("[예매]")) {
			System.out.println("이미 예매된 좌석입니다. 다른 좌석을 선택해 주세요");
			return true;
		} else {
			return false;
		}

	}
	
	// 예매 내역 조회하기
	public void reservationInquiry() {
		System.out.println("예매조회를 위해 예매번호를 입력해주세요.");
		System.out.print("예매번호 : ");
		this.inputNumber = sc.nextLine();
		int inquiryNum = 0;
		int row = 0;
		int col = 0;
		for (int i = 0; i < reservationNum.length; i++) {
			for (int j = 0; j < reservationNum.length; j++) {
				if(inputNumber.equals(reservationNum[i][j])) {
//					System.out.println("예매하신 좌석은 " + seat[i][j] + "입니다.");
					row = i;
					col = j;
					inquiryNum = 1;
				}else {
					
				}
			}
		}
		if(inquiryNum == 1) {
			System.out.println("예매하신 좌석은 [" + (row+1) + "-"+ (col+1) + "] 입니다.");
		}else {
			System.out.println("예매번호와 일치하는 정보가 없습니다.");
		}
		
	}
	
	// 예매 취소하기
	public int cancel() {
		System.out.println("예매취소를 위해 예매번호를 입력해주세요.");
		System.out.print("예매번호 : ");
		this.inputNumber = sc.nextLine();
		int cancelNum = 0;
		int row = 0;
		int col = 0;
		for (int i = 0; i < reservationNum.length; i++) {
			for (int j = 0; j < reservationNum.length; j++) {
				if(inputNumber.equals(reservationNum[i][j])) {
					System.out.println("예매하신 좌석은 [" + (i+1) + "-"+ (j+1) + "] 입니다.");
					cancelNum = reconfirm();
					if(cancelNum == 1) {
						row = i;
						col = j;
						
					}
				}else {
					
				}
			}
		}
		if(cancelNum == 1) {
			reservationNum[row][col] = null;
			seat[row][col] = "[" + (row+1) + "-" + (col+1) + "]";
		}
		return cancelNum;
	}
	
	// 취소 여부 재확인
	public int reconfirm() {
		System.out.println("예매를 취소하시겠습니까?");
		System.out.println("네(1), 아니오(2) 중 하나를 입력해 주세요.");
		System.out.print("취소 여부 확인 : ");
		int cancelNum = Integer.parseInt(sc.nextLine());
		return cancelNum;
	}
}
