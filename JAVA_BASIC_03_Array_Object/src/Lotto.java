
public class Lotto {

	public static void main(String[] args) {
		int[] lotto = new int[6];

		// 1. 1~45 까지의 난수를 발생시켜서 6개의 정수값을 배열에 담기
		for (int i = 0; i < lotto.length; i++) {
			//Math.ramdom()의 값이 0과 1사이이기 때문에 45를 곱하면 0~44 사이가 나오게 됩니다.
			//0~45 의 전체 범위에 +1을 하게 되면 범위가 1~45로 변
			int random = (int) (Math.random() * 45) + 1;
			// 2. 배열에 담긴 6개의 배열값은 중복값이 나오면 안됨 (중복값 검증)
			// 중복값 검증을 for문으로 수행
			boolean checking = false;
			//배열의 처음부터 값을 설정한 곳 까지 같은 값을 가지는지 비교
			for (int j = 0; j < i; j++) {
				if (lotto[j] == random) {
//					checking = true;
					i--;
					break;
				}
			}
			//같은 값을 가진다면 반복문 실행 전으로 돌아가 난수 재생성 및 재검증
//			if (checking) {
//				i--;
//			} else {	//같은 값을 가지지 않는다면 난수값 설정
				lotto[i] = random;
//			}
		}

		

		// 3. 배열에 있는 6개의 값은 낮은 순으로 정렬 시키기 (정렬 : 자리바꿈(swap))
		for (int i = 0; i < lotto.length - 1; i++) {
			for (int j = i + 1; j < lotto.length; j++) {
				if (lotto[i] > lotto[j]) {
					int temp = lotto[i];
					lotto[i] = lotto[j];
					lotto[j] = temp;
				}
			}
		}

		// 4. 결과를 담고있는 배열을 출력하기
		for (int number : lotto) {
			System.out.print(number + " ");
		}
	}
}
