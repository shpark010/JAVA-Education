package kr.or.kosa.utils;

import java.util.Scanner;

public class Lotto {

	int[] lotto;	//로또 번호
	int[] lowProbabilityNum;	//통계상 낮은 당첨 확률의 번호
	Scanner sc = new Scanner(System.in);

	public Lotto() {
		this.lotto = new int[6];	//로또 번호 배열의 초기화
		this.lowProbabilityNum = new int[] { 9, 19, 22, 32, 41 };	//통계상 낮은 당첨 확률의 번호 배열 초기화
	}

	// 실행
	public void run() {
		boolean run = false;	//토글 변수
		System.out.println("============================");
		System.out.println("========로또 번호 생성기========");
		System.out.println("============================");
		while (!run) {
			int choice = menu();	//메뉴 선택
			if(choice == 2) {	//사용자가 2 입력 시 종료
				run = !run;
			}
		}
	}
	
	//메뉴 선택 및 선택에 따른 로또 생성
	public int menu() {
		System.out.println("1. 로또 번호 생성 2. 프로그램 종료");
		System.out.print("입력란 : ");
		int selectMenu = Integer.parseInt(sc.nextLine());
		int result = 0;	//리턴 변수
		switch(selectMenu) {
			case 1 : 
				boolean run = false;	//토글 변수
				while(!run) {
					System.out.println("로또 번호 생성중...");
					generateNumbers(lotto);	//로또 번호 생성 함수
					System.out.println("로또 번호 정렬중...");
					sortLotto(lotto);	//로또 번호 정렬 함수
					System.out.println("로또 번호 검사중...");
					if(containsNumbers(lotto, lowProbabilityNum)) {
						continue;	//로또 번호에 낮은 확률의 당첨 번호가 포함되어 있다면 continue
					}
					System.out.println("추출된 로또 번호 : ");
					for (int i = 0; i < lotto.length; i++) {	//로또 번호 출력
						System.out.print("[" + lotto[i] + "]");
					}
					System.out.println();
					run = !run;
				}
				result = 1;
				break;
			case 2 :
				System.out.println("로또 번호 생성기를 종료합니다.");
				result = 2;
				break;
		}
		return result;
	}
	
	// 로또 번호 생성 메소드
		public void generateNumbers(int[] lotto) {
			for (int i = 0; i < lotto.length; i++) {
				int random = (int) (Math.random() * 45) + 1;	//1~45의 난수를 생성한 변수
				boolean checking = false;
				for (int j = 0; j < i; j++) {
					if (lotto[j] == random) {	//기존에 생성된 로또 번호와 새로 생성된 난수가 일치하는지 여부 확인
						checking = true;
						break;
					}
				}
				if (checking) {	//일치하는 숫자가 있다면
					i--;	//전단계로 돌아가서 다시 실행
				} else {	//아니라면
					lotto[i] = random;	//로또 배열에 난수값 할당
				}
			}
		}
	
	// 정렬 및 출력
	public void sortLotto(int[] lotto) {
		// 로또 번호 오름차순 정렬
		for (int i = 0; i < lotto.length; i++) {
			for (int j = i + 1; j < lotto.length; j++) {
				if (lotto[i] > lotto[j]) {
					int temp = lotto[i];
					lotto[i] = lotto[j];
					lotto[j] = temp;
				}
			}
		}
	}

	

	// 배열에 숫자들이 포함되어 있는지 체크하는 메소드
	public boolean containsNumbers(int[] lotto, int[] lowProbabilityNum) {
		boolean checkingNum = false;
		for (int i = 0; i < lotto.length; i++) {
			for (int j = 0; j < lowProbabilityNum.length; j++) {
				if (lotto[i] == lowProbabilityNum[j]) {	//낮은 당첨 확률의 번호가 포함되어 있는지 확인
					System.out.println("낮은 당첨 확률의 번호가 포함되어 다시 생성합니다.");
					checkingNum = true;	//있다면 true
					break;
				} 
			}
			if(checkingNum) {
				break;	//있다면 멈춤
			}
		}
		return checkingNum;
	}
}