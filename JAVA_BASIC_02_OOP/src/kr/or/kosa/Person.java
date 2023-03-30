package kr.or.kosa;

/*
클래스 == 설계도 == 데이터 타입(큰 타입, 사용자 정의 타입)

설계도는 구체화 하지 않으면 종이에 불과
구체화? : 메모리에 올리는 행위
객체(Object), instance : 구체화를 통해 메모리에 올라간 것

설계도 : field(고유, 상태, 부품(더 나누어 질 수 있다)) + method(기능, 행위) + constructor(생성자 함수)

*/
public class Person {
	public String name;	//default 값 (자동)으로 할당 : null	//생성되는 객체마다 다른 값을 가질 수 있다.
	public int age;	//default 값 (자동)으로 할당 : 0
	public boolean power;	//default 값 (자동)으로 할당 : false
	
	public void personPrint() {
		System.out.printf("이름은 %s 나이는 %d 파워는 %s 입니다.\n", name, age, power);
	}
	
	//member field, instance variable : 객체변수 : 주소값을 갖는 변수
	
	/*
	1. instance variable : 초기화 하지 않아도 된다 -> default 값
	초기화 : 변수가 처음으로 값을 할당 받는 것
	
	2. age member field 초기화 가능? : public int age = 1;
	필요하다면 당근 초기화 가능 : public int age = 1; 모든 객체는 age가 1
	
	Today Point : 왜 초기화 잘 하지 않을까?
	생성되는 객체 마다 다른 필드값을 가질 수 있기 때문에
	
	
	
	
	
	
	
	
	
	*/
	
	
	
	
	
	
	
	
	
	
}
