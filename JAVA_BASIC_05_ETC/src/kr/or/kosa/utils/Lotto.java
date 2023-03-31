package kr.or.kosa.utils;

import java.util.Scanner;

public class Lotto {

	int[] lotto;
	int[] lowProbabilityNum;
	Scanner sc = new Scanner(System.in);

	public Lotto() {
		this.lotto = new int[6];
		this.lowProbabilityNum = new int[] { 9, 19, 22, 32, 41 };
	}

	// 실행
	public void run() {
		boolean run = false;
		System.out.println("============================");
		System.out.println("========로또 번호 생성기========");
		System.out.println("============================");
		while (!run) {
			int choice = menu();
			if(choice == 2) {
				run = !run;
			}
		}
	}
	
	public int menu() {
		System.out.println("1. 로또 번호 생성 2. 프로그램 종료");
		System.out.print("입력란 : ");
		int selectMenu = Integer.parseInt(sc.nextLine());
		int result = 0;
		switch(selectMenu) {
			case 1 : 
				boolean run = false;
				while(!run) {
					System.out.println("로또 번호 생성중...");
					generateNumbers(lotto);
					System.out.println("로또 번호 정렬중...");
					sortLotto(lotto);
					System.out.println("로또 번호 검사중...");
					if(containsNumbers(lotto, lowProbabilityNum)) {
						continue;
					}
					System.out.println("추출된 로또 번호 : ");
					for (int i = 0; i < lotto.length; i++) {
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
				int random = (int) (Math.random() * 45) + 1;
				boolean checking = false;
				for (int j = 0; j < i; j++) {
					if (lotto[j] == random) {
						checking = true;
						break;
					}
				}
				if (checking) {
					i--;
				} else {
					lotto[i] = random;
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
		for (int i = 0; i < lowProbabilityNum.length; i++) {
			if (lotto[i] == lowProbabilityNum[i]) {
				System.out.println("낮은 당첨 확률의 번호가 포함되어 다시 생성합니다.");
				checkingNum = true;
				break;
			} else {
				checkingNum = false;
			}
		}
		return checkingNum;
	}
}