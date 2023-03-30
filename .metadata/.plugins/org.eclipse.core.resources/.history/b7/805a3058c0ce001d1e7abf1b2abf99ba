package kr.or.kosa.utils;

import java.util.Arrays;

public class Lotto {
    public static void main(String[] args) {
        int[] lotto = new int[6];

        // 로또 번호 생성
        generateNumbers(lotto);

        // 9, 19, 22, 32, 41 포함 여부 체크
        while (containsNumbers(lotto, 9, 19, 22, 32, 41)) {
            generateNumbers(lotto);
        }

        // 정렬 및 출력
        Arrays.sort(lotto);
        for (int number : lotto) {
            System.out.print(number + " ");
        }
    }

    // 로또 번호 생성 메소드
    public static void generateNumbers(int[] lotto) {
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

    // 배열에 숫자들이 포함되어 있는지 체크하는 메소드
    public static boolean containsNumbers(int[] lotto, int... numbers) {
        for (int number : numbers) {
            if (Arrays.binarySearch(lotto, number) >= 0) {
                return true;
            }
        }
        return false;
    }
}