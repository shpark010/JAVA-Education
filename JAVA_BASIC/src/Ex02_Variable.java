import kr.or.kosa.Emp;

public class Ex02_Variable {

	public static void main(String[] args) {
		//변수선언
		int value;	//선언 (초기화 되지 않았다)
		value = 100;	//할당 (100 초기화)
		
		int age = 99;	//선언과 할당을 동시에 (99 초기화)
		
		//초기값 정의(초기화) : 변수의 초기화 : 변수가 처음 값을 갖는 것(할당을 통해서)
		
		int num = 0;
		System.out.println(num);	//The local variable num may not have been initialized
		
		//지역변수(local variable)는 사용 시 반드시 초기화를 해야한다.
		//그렇지 않으면 컴파일도 안된다.
		//지역변수(local variable)는 무조건 초기화 하고 사용한다.
		
		Emp emp;	//선언	emp : 지역변수
		//System.out.println(emp);
		emp = new Emp();	//new 연산자를 통해 메모리에 올리는 작업 >> 초기화 작업 >> heap에 생성된 객체의  주소값(x번지)
		//설계도와 똑같은 집을 짓는다(메모리에)
		System.out.println(emp);
		
		// . : 주소를 찾아가는 연산자
		System.out.println(emp.empno);
		
		
		int a, b, c;	//동일 타입 변수 다중 선언 > 개발자 생각 > 배열(Array) int[] a
		//초기화 되어 있지 않다
		//사용
		a = 100;
		b = 200;
		c = 300;
		
		int data = 100;
		//int data;	같은 지역 내에서 같은 변수명은 존재할 수 없다.
		
		int result = a + b;	//초기화
		System.out.println("result 값은 " + result);
		
		int k = 100;
		int y = k;
		y = 200;
	}

}

/*
블럭주석

클래스 == 설계도 == 데이터 타입

클래스 종류
1. class Car {} > main 함수를 가지고 있지 않은 클래스
- 독자적인 실행이 불가능
- 다른 클래스에 도움을 주는 클래스(lib)
2. class Car { public static void main(String[] args) {} }
- main 함수를 가지고 있는 클래스
- 독자적인 실행 가능
3. 현재는 main 함수를 가지고 있는 클래스가 있어야 결과를 확인할 수 있다.
4. public static void main(String[] args)
- static (new 없이도 메모리에 생성)
- 함수의 이름 (main : 시작점, 진입점)

TIP)
C# 코드 : class Car { public static void Main(String[] args) {} }\

변수 : variable
정의 : 데이터(자료)를 담을 수 있는 메모리(공간)의 이름
공간(크기) -> 데이터 타입(자료형) : 메모리 공간은 한정되어 있다.
(최소한의 공간으로 최대한의 데이터를 표현하기 위해 타입 사용)
ex) int data = 100;

변수가 선언되는 위치(scope : 유효범위)

변수의 종류
1. instance variable(객체 변수) : class가 가지는 변수
ex) class Car { public int door; }

2. local variavble(지역 변수) : 함수 안에 선언되는 변수
ex) class Car { public void run() { int data = 0; } }

3. static variable(정적 변수) : 객체간 공유자원
ex) class Car { public static int num; }

4. block variable(블럭 변수) : 함수안에 있는 제어블럭 안에 있는 변수(if, for) - 가장 작은 scope의 변수
ex) class Car { void run() { for(int i=0...){ } } }



*/
