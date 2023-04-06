import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/*
Collection FrameWork
>>다수의 데이터를 다루는 표준화된 방법을 학습 >> 인터페이스와 클래스로 구현
>>수 많은 인터페이스를 가지고 있다. (목적 : 다수의 데이터를 효율적으로 다루기 위해)

Iterator 인터페이스
나열된 자원에 대해서 순차적으로 접근해서 값의 유무를 판단하고 값을 리턴하는 표준을 정의
추상자원을 가지고 있다. >> 어떤 클래스는 Iterator 인터페이스를 구현해서 표준화된 접근 방법을 제공

Iterator 인터페이스가 가지고 있는 추상자원
hasNext(), Next(), remove() 추상자원
ArrayList implements Iterator { 3개의 추상자원 함수를 재정의 하고 있다. }

*/
public class Ex08_Collection_Iterator {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(100);
		list.add(200);
		list.add(300);
		
		for (int i = 0 ; i < list.size() ; i++) {
			System.out.println(list.get(i));
		}
		
		//Collection FrameWork이 제공하는 표준화된 접근 방식
		Iterator it =  list.iterator();	//호출하면 함수 안에서 인터페이스를 구현하는 객체가 생성되고, 그 주소를 리턴
		//iterator()를 사용하면 자원을 Iterator 인터페이스가 구현하고 있는 함수를 통해서 제어 가능
		while(it.hasNext()) {	//값을 가지고 있는지 여부를 확인 //현업에서 권장 (표준화된 출력)
			System.out.println(it.next());
		}
		
		ArrayList<Integer> intlist = new ArrayList<Integer>();
		intlist.add(1);
		intlist.add(2);
		intlist.add(3);
		
		//인터페이스 generic 명시
		Iterator<Integer> it2 = intlist.iterator();
		while(it2.hasNext()) {
			System.out.println(it2.next());
		}
		
		System.out.println();
		
		for(int i = intlist.size()-1 ; i >= 0 ; i--) {
			System.out.println(intlist.get(i));
		}
		
		//////////////////////////////////////////////////
		// Iterator는 기본적으로 순방향 출력
		// 역방향 조회
		ListIterator<Integer> it3 = intlist.listIterator();
		
		//순방향
		while(it3.hasNext()) {
			System.out.println(it3.next());
		}
		//역방향
		while(it3.hasPrevious()) {
			System.out.println(it3.previous());
		}
		
		//참고
		while(it3.hasNext()) {
			int i = it3.next();
			if(i == 3) { 
				it3.remove();
			}
		}
		
		
	}

}
