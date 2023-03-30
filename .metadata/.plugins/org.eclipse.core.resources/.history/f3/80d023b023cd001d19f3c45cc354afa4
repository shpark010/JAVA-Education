import java.util.Scanner; //v1.0
							//v1.1 재고기능

import kr.or.kosa.*;

public class FakeFlower_Quiz {

	public static void main(String[] args) {
		FakeFlower flower1 = new FakeFlower("장미", 10000, true);
		FakeFlower flower2 = new FakeFlower("카네이션", 20000, true);
		FakeFlower flower3 = new FakeFlower("무궁화", 30000, true);
		FakeFlower flower4 = new FakeFlower("국화", 40000, true);

		DoWhileMenu menu = new DoWhileMenu();
		FakeFlowerVendingMachine vm = new FakeFlowerVendingMachine(123456789, "삼성", 12);

		while (true) {
			try {
				int inputValue = menu.displayMenu(flower1, flower2, flower3, flower4);
				FakeFlower selectedFlower = new FakeFlower(null, 0, false);
				switch (inputValue) {
				case 1: {
					selectedFlower = flower1;
					break;
				}
				case 2: {
					selectedFlower = flower2;
					break;
				}
				case 3: {
					selectedFlower = flower3;
					break;
				}
				case 4: {
					selectedFlower = flower4;
				}
				}
				if (vm.isConfirmed(selectedFlower)) {
					vm.buyProduct(selectedFlower);
				}
			} catch (Exception e) {
				System.out.println("오류가 발생했습니다");
				System.out.println("초기화면으로 돌아갑니다");
				System.out.println("=====================================================================");
			}

		}

	}

}
