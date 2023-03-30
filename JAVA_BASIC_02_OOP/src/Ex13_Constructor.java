/*
생성자 함수(constructor)
1. 특수한 목적 함수
2. 목적( member field 초기화 ) >> static {}, {초기자 블럭}

3. 생성자가 일반 함수와 다른점
3.1 함수 이름 = 클래스 이름
3.2 return type이 없다 ( 객체 생성과 동시에 호출 ) -> return을 받을 대상이 없다.
3.3 실행 시점 >> new를 통해 객체 생성 >> heap영역에 객체 생성 >> member field 자리 잡음
 			>> 자동으로 생성자 함수 호출
3.4 return type(x) >> void >> public void(생략) 클래스이름 >> public 클래스 이름() {}
4. 왜 만들까? : 생성되는 객체마다 [강제적]으로 member field를 초기화 하고 싶다.

class Car {String color;}
>> 설계도를 만든 이 : 자동차 색상은 니가 알아서 해 (안해도 어쩔 수 없다)

class Car {String color="blue";}
>>객체를 생성하면 무조건 자동차의 색상 blue

문제) 자동차의 색상을 정하지 않고 출고시
설계도를 사용하는 사람이 자동차를 만들때 색상을 넣지 않으면 출고 안되게 하고 싶어요.
>> 생성자 설계 강제하지 않으면 객체 안 만들어 져요

5. 생성자 함수 1개 만들까?
6. 생성자 함수는 overloading 가능 ( 강제 구현 )
생성자 함수를 가장 중요한 목적은 member field의 [강제적 초기화] 이다.

*/

class Car {
	String carname = "포니";
	
	//생성자 (default constructor : 기본 생성자)
	public Car() {
		System.out.println("기본 생성자");
		carname = "내마음";
	}
}

class School {
	String schoolName = "강남";
	
	//public School() {}
	//컴파일러가 객체 생성할때 생성자 함수가 없다면 자동으로 default 생성자를 만들어서 실행
}

////////////////////////////////////////////////////////////////////////
class Car2 {
	String carname;
	//default 생성자 생략되어있다.
	//컴파일러가 자동으로 생성한다
	//public Car2() { }
}

class Car3 {
	String carname;	// null
	public Car3() {	//default constructor
		carname = "포니";
	}
}

//Car4설계도 : 자동차를 만드는 데 있어서 2가지 선택
class Car4 {
	String carname;
	//1번재
	public Car4() {
		carname = "기본이름";
	}
	//2번째
	//overloading (함수) >> 생성자 함수(특수한) >> 생성자 >> overloading 가능
	public Car4(String name) {
		carname = name;
	}
}
//설계의도
class Car5 {
	String carname;
	public Car5(String name) {
		carname = name;
	}
}

class Car6 {
	String carcolor;
	int door;
	public Car6() {
		carcolor= "blue";
		door = 4;
	}
	public Car6(int num) {
		carcolor= "blue";
		door = num;
	}
	public Car6(String color) {
		carcolor= color;
		door = 4;
	}
	public Car6(String color, int num) {
		carcolor = color;
		door = num;
	}
}


////////////////////////////////////////////////////////////////////////
public class Ex13_Constructor {

	public static void main(String[] args) {
		Car car = new Car();
		System.out.println(car.carname);
		
		School school = new School();
		
		Car4 car4 = new Car4();
		Car4 car41 = new Car4("홍길동카");
		
		System.out.println(car4.carname);
		System.out.println(car41.carname);
		
	}

}
