import kr.or.kosa.common.Car;

/*
클래스 == 설계도 == 타입(사용자 정의)

클래스의 구성 요소 (설계도가 가지는 최소한의 자격)
[필드 + 메서드] + 생성자
[속성 + 함수(기능)]

필드 (member field) : 데이터, 자료 정보를 담고 있다. -> [고유정보], [상태정보], [부품정보] -> field == variable
함수 (method) : 기능(행위, 동작) -> 자동차 >> 달린다, 멈춘다, 소리가 난다, 문을 연다...
+ 추가적으로 생성자(함수) : 특수한 목적의 함수 -> 객체 생서이 member field 초기화 목적 생성 함수 / getter, setter를 읽고 쓰는
class 설계도 {
	고유정보
	상태정보
	부품정보
	
	기능(행위)
}

클래스, 필드, 생성자함수, 메서드 : 영역 (범위) -> 생성되는 장소(위치) or 접근자 (한정자, 수정자)


장소 (위치) : 폴더(package)를 기반으로 클래스 내부, 함수 내부, 제어문 내부
접근자 : public, private, default, protected

 kr.or.kosa.common 안에 생성한 Car 클래스 > public class Car {} >> 나 다 오픈할거야
 kr.or.kosa.common 안에 생성한 AirPlane 클래스 > class AirPlane {} >> 같은 폴더(package)에서만 사용
 
 >> default class : 같은 폴더(package)에서만 공유
 >> 연습용으로 또는 특정클래스의 도움을 주는 클래스 생성시
 
 연습용으로 빠르게 작업
 : 하나의 물리적 Java파일은 여러개의 클래스를 가질 수 있다.
 >> Ex01_Main.java 파일은 그 안에  public class Ex01_Main 클래스를 가지고 있다.
 1. 개발에서는 필요한 클래스는 package 생성하고 그 안에 만들어 사용합니다. Car 클래스 처럼
 2. 그냥 연슴... 굳이 폴더(package) 생성?... 물리적파일 여러개 만들 필요가 있을까?\
 3. 하나의 물리적 파일에 여러개의 클래스를 만들어 쓸 수 있게 해줄까 (연습...)
 3-1. 대신에 public 접근자는 한 놈...

 

*/
class Emp {		//연습할때나 공부할때만 사용
	
}

class Dept {	//컴파일러가 default clss Dept {} 로 해석
	int deptNo;	//컴파일러가 default int depNo 로 해석
	public String dname;	//에러는 아니지만 다른 폴더(package)에서 사용 불가 -> class가 defaul이기 때문에 public은 의미 없다.
	private int count;	//private : 캡슐화(은닉)
						//설계자의 의도 : 클래스 내부에서만 사용 목적
						//설계자의 의도 : 직접할당을 막고 간접할당 활동을 제어 하겠다.
	
	//특수한 함수
	//Getter(읽기 전용) & Setter(쓰기 전용)
	public int getCount() {
		return this.count;
	}
	
	public void setCount(int count) {
		if(count < 0) {
			this.count = 0;
		}else {
			this.count = count;			
		}
	}
	
}

//class Apt {
	
//}

/*
폴더(package)
kr.or.kosa.dto.Test

public class Test {
	private int i;
	
	public void setI(int i) {
		this.i = i;
	}
	
	public int getI() {
		return this.i;
	}
	
	public void print() {
	
	}

}

*/
//연습용
class Test {	//default
	int data;		//default	클래스가 가지는 변수 (member field) : instance variable(객체 변수)
	
	void print() {	//default
		int num = 0;	//local variable(지역 변수)
		
		for(int i = 0 ; i <= 100 ; i++) {	//int i = 0 제어문 안에서 block variable
			
		}
		for(int i = 0 ; i <= 100 ; i++) {	//int i = 0 제어문 안에서
			
		}
		int k = 0;
		for(k = 0 ; k <= 100 ; k++) {	//int i = 0 제어문 안에서
			
		}
		System.out.println(k);
	}
}

//data 변수는  : Test test = new Test(); 로 생성 했을 때 메모리에 생성
//print() 함수가 호출 되었을 때 num 변수 생성
//int i 변수는 for문 실행 될 때 생성

public class Ex01_Main {

	public static void main(String[] args) {
		//같은 폴더(package) 안에 있는 클래스
		Apt apt = new Apt();
		// kr.or.kosa.common.Car car = new  kr.or.kosa.common.Car();
		Car car = new Car();	// public class Car {} : 폴더의 구분없이 어디서나 사용가능하다.
		
		Dept dept = new Dept();
		//dept.count (캡슐화)
		dept.deptNo = 100;	//파란삼각형 : default class
		System.out.println(dept.deptNo);
		
		dept.dname = "IT";
		System.out.println(dept.dname);
		
		dept.setCount(-100);
		System.out.println(dept.getCount());
		
		Test test = new Test();
		test.print();
	}

}
