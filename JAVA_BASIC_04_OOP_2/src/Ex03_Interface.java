/*
인터페이스 : 약속, 규칙, 규약, 표준을 만드는 것
설계 최상위 단계....
초급개발자 : 인터페이스 사용 방법...

-----------------------------------------
추상 클래스와 인터페이스
1. 스스로 객체 생성 불가능 (new 연산자를 사용 불가)
1.1 두놈의 차이점 : 추상 클래스(완성 + 미완성) , 인터페이스(모든 것이 미완성)

2. 사용
추상클래스 extends
인터페이스 implements

class Car extends AbClass { }
class Car implements Ia { }

둘다 추상자원을 가지고 있다 -> 강제적 구현이 목적 (재정의)

추상클래스 인터페이스 다른점
3. 추상클래스 (완성부 & 코드 일부} 그러나 인터페이스는 전체가 미완성 코드(상수, default 함수 제외)
3.1 원칙적으로 클래스는 다중상속이 불가능 -> 계층적 상속 또는 포함 관계로 가능
->인터페이스는 [다중 구현]이 가능 >> 여러개의 작은 인터페이스 모아서 구현
->너무 큰 인터페이스를 만들면 재사용성이 떨어진다.
ex) Ia, Ib, Ic 인터페이스
Class Test extends Object implements Ia, Ib, Ic;
Tip) 인터페이스와 인터페이스는 서로간 상속이 가능
작은 약속 -> 상속 -> 큰 약속

4. 인터페이스 (상수를 제외한 나머지는 미완성 추상 함수 ) -> JDKB ( default, static )

초급개발자 시선으로
1. 인터페이스를 다형성 입장으로 접근 (인터페이스 모든 타입 부모)
2. 서로 연관성이 없는 클래스를 하나로 묶어주는 역할 (같은 부모를 가지게 함으로써)
3. JAVA API : 수 많은 인터페이스를 생성해 놓았다. (생성보다는 사용)
4. 인터페이스 (~able) : ~할 수 있는
5. 객체간 연결 고리 (객체간 소통) 다형성

interface

1. 실제 구현부를 가지고 있지 않다 -> 실행블럭이 없다 -> 약속만 있다.
2. interface Ia { void move(int x, int y); } >> 구현은 알아서... 재정의
3. JAVA API >> Collection >> 시작 인터페이스 >> List, Set, Map

생성방법
1. 상수 구현 가능
public static final 생략( 컴파일러가 알아서 붙여줌 )
public static final int VERSION = 1; -> int VERSION = 1;

2.추상함수
public abstract void run(); -> void run();

종류
interface Aable{ } //아무 자원도 없어요 (같은 가족으로 묶어 줄때)
interface Aable{ int NUM=10; }
interface Aable{ void run(); }

*/

interface Ia {
	int AGE = 100;	//public static final 
	String GENDER = "남";	//public static final 
	
	String print();	//public abstract 
	void message(String str);	//public abstract 
}

interface Ib {
	int AGE = 10;
	void info();
	String val(String s);
}

class Test2 extends Object implements Ia {
	@Override
	public String print() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void message(String str) {
		// TODO Auto-generated method stub
		
	}
}

class Test3 extends Object implements Ia, Ib {

	@Override
	public void info() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String val(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String print() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void message(String str) {
		// TODO Auto-generated method stub
		
	}
	
}

public class Ex03_Interface {

	public static void main(String[] args) {
		Test2 t2 = new Test2();
		/////////////////////////////////////////
		Ia ia = t2;	//부모는 자식객체의 주소를 가질 수 있다.
		ia.message("재정의");	//인터페이스가 재정의된 자원을 호출
		System.out.println(ia.GENDER);
		
		Test3 t3 = new Test3();
		
		Ia ia2 = t3;
		Ib ib2 = t3;
		System.out.println(ia2.GENDER);
		
	}

}
