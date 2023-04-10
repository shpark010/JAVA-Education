import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Today Point(ArrayList)
*/
public class Ex02_ArrayList {

	public static void main(String[] args) {
		//ArrayList : List 인터페이스를 구현하고 있는 클래스 -> 순서 보장(index), 중복데이터 허용
		//식당 번호표, 은행 번호표
		ArrayList arraylist = new ArrayList();
		arraylist.add(100);
		arraylist.add(200);
		arraylist.add(300);
		
		for (int i = 0; i < arraylist.size() ; i++) {
			System.out.println(arraylist.get(i));
		}
		System.out.println(arraylist.toString());
		
		//add 함수는 데이터 순차적으로 넣기
		arraylist.add(400);	//index - 3번째
		System.out.println("400추가 : " + arraylist.toString());
		arraylist.add(0, 1111);
		System.out.println("0번째 방에 1111 추가 : " + arraylist.toString());
		//1. 비순차적인 데이터에 대한 추가, 삭제 시에는 성능이 좋지 않다. >> 순서가 있는 데이터 집합
		//2. 순차적인 데이터 추가, 삭제에 유리하다.
		
		System.out.println(arraylist.contains(200));	//해당 값이 있는지 확인
		System.out.println(arraylist.size());
		arraylist.clear();	//데이터 삭제 (size(값이 있는 방) 초기화 but capacity(공간)는 그대로
		System.out.println(arraylist.size());
		
		arraylist.add(101);
		arraylist.add(102);
		arraylist.add(103);
		
		System.out.println(arraylist.isEmpty());	//배열이 비어있는지 확인
		System.out.println(arraylist.size());
		
		Object value = arraylist.remove(0);	//지워지는 데이터에 대한 반환을 변수에 초기화
		System.out.println(value);	//배열에서 지워진 값을 출력
		System.out.println(arraylist.toString());
		
		//Point 다형성
		//인터페이스 부모 타입
		//다형성(확장성, 유연성)
		
		//ArrayList arraylist = new ArrayList();
		//습관적으로 다형성 코드를 작성해야 한다
		List li = new ArrayList();
		//부모타입의 참조변수 li는 자식객체의 주소값을 가질 수 있다. (다형성)
		//인터페이스는 구현코드가 없어요... 재정의...자식의 함수 실행
		li.add("가");
		li.add("나");
		li.add("다");
		li.add("라");
		System.out.println(li.toString());
		
		List li2 = li.subList(0, 2);	//0번째 부터 2번째 까지 순차적으로 배열을 생성
		System.out.println(li2);
		
		//ArrayList >> Array
		//정렬
		ArrayList alist = new ArrayList<>();
		alist.add(50);
		alist.add(1);
		alist.add(7);
		alist.add(40);
		alist.add(46);
		alist.add(3);
		alist.add(15);
		
		System.out.println(alist.toString());
		Collections.sort(alist);	//낮은 값부터 정렬
		System.out.println(alist.toString());
		
		Collections.reverse(alist);	//거꾸로 정렬
		System.out.println(alist.toString());
	}

}
