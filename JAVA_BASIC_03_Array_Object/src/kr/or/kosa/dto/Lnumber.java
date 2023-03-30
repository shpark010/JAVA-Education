package kr.or.kosa.dto;

public class Lnumber {

    public static void main(String[] args) {
        int[] lotto = new int[6];

        // 로또 번호에 특정 숫자가 포함되어 있는 동안 반복
        boolean contains = true;
        while (contains) {
            // 로또 번호 생성
            for (int i = 0; i < lotto.length; i++) {
                lotto[i] = (int)(Math.random() * 45) + 1;

                // 중복된 숫자가 있으면 다시 생성
                for (int j = 0; j < i; j++) {
                    if (lotto[j] == lotto[i]) {
                        i--;
                        break;
                    }
                }
            }

            // 로또 번호 오름차순 정렬
            for (int i = 0; i < lotto.length; i++) {
            	for (int j = i+1; j < lotto.length; j++) {
            		if(lotto[i] > lotto[j]) {
            			int temp = lotto[i];
            			lotto[i] = lotto[j];
            			lotto[j] = temp;
            		}
            	}
            }

            // 특정 숫자가 포함되어 있는지 검사
            contains = false;
            for (int num : lotto) {
                if (num == 9 || num == 19 || num == 22 || num == 32 || num == 41) {
                    contains = true;
                    break;
                }
            }
        }

        // 생성된 로또 번호 출력
        for (int num : lotto) {
            System.out.print(num + " ");
        }
    }
}
/*
for (int i = 0; i < lotto.length; i++) {
	for (int j = i+1; j < lotto.length; j++) {
		if(lotto[i] > lotto[j]) {
			int temp = lotto[i];
			lotto[i] = lotto[j];
			lotto[j] = temp;
		}
	}
}
*/