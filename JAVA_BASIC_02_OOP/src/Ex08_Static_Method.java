/*
static member field : 객체간 공유자원
static method : >> public static void main (첫시간에...)

1. 객체 생성 없이 사용
2. 편하게 빠르게 ...
3. 많이 사용하니까
4. 설계도 : 자원은 많이 사용할 것 같아 ... new ... 참조변수 ...
-> 자원을 많이 사용 >> 편하게 쓰게 하자 >> new 없이 사용 >> 기능 (static 설계)

*/
class StaticClass {
	//instance variable
	int iv;
	//static variable
	static int cv;
	//static method
	static void print() {
		System.out.println("static print");
		//static 함수
		//일반자원 int iv; -> 생성 시점 (static 자원은 일반 자원보다 우선한다)
		//일반자원인 iv는 new를 통해 객체를 생성하기 전에는 memory에 올라가지 않기 때문에 사용 불가
	}
	//method
	void printIv() {
		//일반함수
		//static int cv;
		//why : static 자원은 객체 생성 이전에 memory 로드 
		//-> static 자원은 이미 메모리에 있기 때문에 사용 가능
		
		cv = 100;
	}
}
//공존의 관계 : 생성시점에 대한 해결 제시
//에러를 안내려면... -> 끼리끼리 놀아라(static끼리 일반 끼리) 때로는 같이 놀 수 있다.

public class Ex08_Static_Method {

	public static void main(String[] args) {
		StaticClass.print();
		
		StaticClass sc = new StaticClass();
		System.out.println(sc.cv);
		//일반함수를 통한 static 변수 제어
		sc.printIv();
		System.out.println(sc.cv);
	}

}
