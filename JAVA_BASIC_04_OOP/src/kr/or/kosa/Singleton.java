package kr.or.kosa;
/*
디자인 패턴 (생성에 관련된 이야기) -> new

싱글톤 : 객체 하나를 만들어 공유
의도 : 하나의 객체를 공유하는 보장성 코드를 만들어라

공유 프린터
공유 IP

Singleton s = new Singleton();
Singleton s2 = new Singleton();
Singleton s3 = new Singleton();

*/
public class Singleton {
	private static Singleton p;
	private Singleton() {	//private로 생성자를 감춤
		//생성자(constructor)의 접근자를 private -> 생성자 호출하지 못해서 객체를 new 하지 못하게 막음
	}
	public static Singleton getInstance() {
		if(p == null) {
			p = new Singleton();	//POINT 같은 클래스 내부에서는 public, private를 구분하지 않는다.
		}
		return p;	//항상 같은 주소(메모리) 보장
	}
}








