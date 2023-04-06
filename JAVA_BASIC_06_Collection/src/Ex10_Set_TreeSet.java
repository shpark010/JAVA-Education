import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Ex10_Set_TreeSet {

	public static void main(String[] args) {
		//set : 순서가 없고, 중복을 허락하지 않는다.
		
		/*
		TreeSet : 순서를 보장하지 않고, 중복 데이터를 허락하지 않지만 [정렬 기능]이 있다.
		언제 사용? : 검색하거나 정렬 필요할 경우에 사용하는 자료구조
		로또 >> 
		
		이진트리 : root > leaf
		데이터 저장시 정렬기능 제공
		*/
		
		HashSet<String> hs = new HashSet<>();
		hs.add("B");
		hs.add("A");
		hs.add("F");
		hs.add("K");
		hs.add("G");
		hs.add("D");
		hs.add("P");
		System.out.println(hs.toString());
		//[P, A, B, D, F, G, K] 순서를 유지하지 않고 중복 데이터 없다.
		
		System.out.println();
		
		Set<Integer> lotto = new TreeSet<>();
		for (int i = 0; lotto.size() < 6; i++) {
			int num = (int)(Math.random()*45+1);
			lotto.add(num);
			System.out.println("num : " + num);
		}
		System.out.println(lotto.toString());
	}

}
