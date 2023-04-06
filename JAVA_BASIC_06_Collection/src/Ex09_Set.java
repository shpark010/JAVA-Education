import java.util.HashSet;
import java.util.Iterator;

/*
Set 인터페이스
(원 안에 들어가세요) : 순서를 보장하지 않음 , 중복을 허락하지 않음
언제 사용? : 순서가 없고 중복을 허락하지 않는 데이터 집합을 다룰 때 사용
구현하는 클래스
HashSet, TreeSet (자료규조)


*/
public class Ex09_Set {

	public static void main(String[] args) {
		HashSet<Integer> hs = new HashSet<>();
		hs.add(1);
		hs.add(100);
		boolean bo = hs.add(55);
		System.out.println("정상 : " + bo);

		bo = hs.add(1);
		System.out.println("결과 : " + bo); // false 나오면 같은 데이터가 있다는 뜻

		System.out.println(hs.toString());

		// 로또, 차량번호, 회원id .....
		HashSet<String> hs2 = new HashSet<>();
		hs2.add("b");
		hs2.add("A");
		hs2.add("F");
		hs2.add("C");
		hs2.add("Z");
		hs2.add("A");
		hs2.add("H");
		hs2.add("b");
		hs2.add("b");
		System.out.println(hs2.toString());

		String[] strobj = { "A", "B", "C", "D", "B", "A" }; // 10000건
		HashSet<String> hs3 = new HashSet<>();
		for (int i = 0; i < strobj.length; i++) {
			hs3.add(strobj[i]); // 중복 데이터는 add 하지 않는다.
		}
		System.out.println(hs3.toString());

		// Quiz
		// 아래 코드를 HashSet으로 만들고 식사
		/*
		 for (int i = 0; i < lotto.length; i++) { lotto[i] = (int)(Math.random() * 45) + 1;
		 	// 중복된 숫자가 있으면 다시 생성 
		 	for (int j = 0; j < i; j++) {
		 		if(lotto[j] == lotto[i]) {
		 			i--; break; 
		 		}
		 	}
		 }
		 */
		int[] lotto = new int[6];
		HashSet<Integer> hs4 = new HashSet<>();
		while(hs4.size() <= 5) {
			hs4.add((int)(Math.random()*45)+1);
		}
		for (Integer i : hs4) {
			System.out.println(i);			
		}
	}

}
