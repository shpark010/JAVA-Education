/*
OOP : 객체 지향 프로그래밍 (객체 : 어러개의 작은 조각(작은 설계도)을 만들어서 조합(큰 설계도)하는 행위)
>> 설계도를 재사용

1. 상속 (재사용성)
2. 캡슐화 (은닉화) : private : 직접 할당을 막기 때문에 setter&getter를 이용한 간접 할당을 통해 데이터 보호)
3. 다형성 : 하나의 타입으로 여러개 객체의 주소를 가질 수 있는 것

>>method >> overloading (오버로딩) method
>>하나의 이름으로 여러가지 기능을 하는 함수
>>System.out.print(); 이름은 1개, 기능은 여러개 (함수 parameter 개수, 타입을 다르게)
오버로딩은 메서드나 연산자의 이름을 재사용하면서도 다양한 매개변수의 타입, 개수, 순서를 지원함으로써
 코드의 유연성을 높이고 가독성을 향상시킬 수 있다
1. 오버로딩을 사용하면 성능 향상(X) -> 유연성 증대
2. 편하게 사용하기 위해 -> 개발자가 편하게 -> 설계자가 배려(개발자)
3. 오버로딩을 사용하지 않아도 문제 되지 않는다 

문법)
1. 함수의 이름은 같고 parameter [개수]와 [타입]을 달리
1.1 함수의 이름 동일
1.2 parameter의 개수, 타입을 달리한다.
1.3 return type 오버로딩의 판단 기준이 아니다.(개발자 원하는대로)
1.4 parameter의 순서가 다름을 인정
ex) m(int i, String s), m(String s, int i)

*/

class Human {
	String name;
	int age;
}

class OverT {	//설계도
	int add(int i) {
		return 100 + i;
	}
	
	//void add(int i) {	동일한 이름과 동일한 parameter는 충돌
		
	//}
	int add(int i, int j) {
		return i + j;
	}
	String add(String str) {
		return str;
	}
	String add(String s, int i) {
		return "hello" + s;
	}
	String add(int i, String s) {	//순서가 다름을 인정
		return "hello" + s;
	}
	//POINT
	void add(Human human) {	//인정 오버로딩
		human.age = 100;
		human.name = "홍길동";
	}
	
}

public class Ex11_Method_Overloading {

	public static void main(String[] args) {
		System.out.println();
		
		OverT overt = new OverT();
		overt.add(10,10);	//parameter 정의가 일치하는 함수가 자동 호출
		//overt.add(10.1f,10);
		overt.add("A");
		
		Human human = new Human();
		overt.add(human);
		//POINT
		overt.add(new Human());
		
	}

}
