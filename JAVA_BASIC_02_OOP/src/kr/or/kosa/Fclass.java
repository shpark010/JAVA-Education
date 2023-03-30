package kr.or.kosa;
/*
기능(행위) 만드는 방업
method 만드는 방법(문법)
method : 행위 또는 기능의 최소단위 구현 : 하나의 함수는 하나의 기능만 구현
ex) 먹는 기능, 자는 기능

ex) 롯데월드 : 게임방 : 동전 (농구), 동전 뽑기 (포케몬)

** 모든 함수는 호출에 의해서만 동작한다 **
누군가 이름을 부르지 않으면 동작하지 않는다.

JAVA)
1. void , parameter(O) : public void print(String str) { 실행구문 }
2. void , parameter(X) : public void print() { 실행구문 }
3. return type, parameter(O) : public int print(int data) { 실행구문 return 100; }
4. return type, parameter(X) : public int print() { 실행구문 return 100; }

void : 돌려주는 것이 없다. -> return type 없다.
return type : 8가지 기본 타입 + 1(String), Array, class, interface, Collection
이 중에서 8가지 + String + class 학습


public boolean print() { return true/false; }
Car print() { return Car주소값 }
Car print() { return new Car(); }
Car print() { Car car = new Car(); return car; }	목표 : 자유롭게 가지고 놀기

String print() { return ""; }

parameter type : void print(String 변수) { }
parameter type : 8가지 기본 타입 + 1(String), Array, class, interface, Collection

void print(int i) { }	ex) 호출 print(100);
void print(String str) { }	ex) 호출 print("이예진"):
void print(Car c) { }	ex) 호출 Car c1 = new Car() print(c1); / print(new Car());

void print2(int a, int b, int c) { 나는 무조건 실행할 때 3개의 parameter 받겠다 }
ex) 호출 print2(10,10,12);

함수의 이름 : 관용적
class Car , class Person

메서드 : getNumber();

사원테이블에서 사원의 모든 정보를 가지고 오는 함수를 만들어라
void getEmpAllList();

사원테이블에서 사원의 번호를 가지고 사원의 모든 정보를 가지고 오는 함수를 만들어라
void getEmpListByEmpNo

*/
public class Fclass {
	//멤버 필드(member field) / 인스턴스 변수(instance variable)
	public int data;
	
	// void m() : 컴파일러가 자동으로 default void m(); -> 같은 폴더(package) 내에서만 사용
	
	
	//함수의 접근자(수정자) : 70%가 public
	//함수의 30%는 privatte : class 내부에서는 public과 private 의미가 없다.
	
	//클래스 내부에서 사용해라 -> 다른 함수를 도와주는 함수(공통함수)
	
	public void m() {	//void, parameter(X)
		//기능 구현
		System.out.println("일반함수 : void, parameter(X)");
	}
	
	public void m2(int i) {
		System.out.println("일반함수 : void, paramenter(O)");
		System.out.println("paramter 값을 활용 : " + i);
	}
	
	public int m3() {
		//강제로 return을 구현
		return 10000;
	}
	
	public int m4(int data) {
		return 100 + data;
	}
	//여기까지가 가장 기본적인 함수 4가지
	
	//확장
	
	//return type(O), parameter (O) 갯수 늘리기
	public int sum(int i, int j, int k) {
		return i + j + k;
	}
	
	//함수의 접근자(수정자), 한정자
	// int sum(); -> 컴파일러 -> default int sum();
	// private int sum(); -> 객체입장에서 접근 불가 -> 같은 클래스 안에서 접근 가능
	// 클래스 내부에서 다른 함수를 도와주는 공통함수
	
	private int subSum(int i) {
		return i+ 100;
	}
	//Fclass fclass = new Fclass();
	//fclass.보이지 않음
	
	public void callSubSum() {
		int result = subSum(100);	//private 함수의 활용
		System.out.println("call result : " + result);
	}
	
	public int opSum(int data) {
		//다양한 로직 (제어문)
		int result = subSum(data);
		//제어
		if(result > 0) {
			return 1;
		}else {
			return -1;
		}
	}
	
	//Quiz
	/*
	함수를 생성
	정수 타입의 parameter a와 b 두개를 받아서 둘 중에 큰 값을 리턴하는 함수를 만드세요
	*/
	public int max(int a, int b) {
		return (a > b) ? a : b;
	}
	
	

	
	
	
	
}
