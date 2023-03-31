/*
추상 클래스
>> 미완성 클래스 (미완성 설계도)
1. 완성된 코드 + 미완성 코드
2. 미완성 -> 함수 : 실행블럭이 없는 함수 >> public void run(); -> 추상 함수
3. 미완성 클래스는 (스스로 객체 생성이 불가능)

설계도를 만드는 입장에서 
>>미완성 설계도 제작(미완성 함수) -> 의도 : 믿지 못하니까 -> 강제적 구현을 목적

*/
class Car {
	void run() {}	//{ 블럭만 있으며9ㄴ 객체 생성하고 사용하는 데 문제 없다. }
	//재정의 했으면 좋겠어 ... 강제성이 없다.
}

class Hcar extends Car {
	//믿음
	@Override
	void run() {
		System.out.println("재정의 했어요.");
	}
}

//강제성이 없다. (의무 사항이 아니다)
//반드시 (설계도)를 통해 재정의 해라
abstract class Abclass {	//이 클래스 안에는 최소 1개 이상의 추상함수를 가지고 있겠다.
	int pos;
	void run() {
		pos++;
		System.out.println("pos : " + pos);
	}
	
	//재정의가 필요한 함수를 추상함수로 설계
	abstract void stop();	//실행블럭이 없다. -> 사용할 때 반드시 [상속]을 통해서만 구현 가능 -> 반드시 [재정의]를 해라
}

//상속을 통해서 구현
class Child extends Abclass {
	@Override
	void stop() {
		this.pos = 0;
		System.out.println("stop1 : " + this.pos);
	}
}

class Child2 extends Abclass {
	@Override
	void stop() {
		this.pos = -1;
		System.out.println("stop2 : " + this.pos);
	}
}

public class Ex01_abstract_class {

	public static void main(String[] args) {
		Hcar hc = new Hcar();
		hc.run();
		
		//Abclass ab = new Abclass();
		
		Child child = new Child();
		child.run();
		child.run();
		child.stop();
		
		Child2 child2 = new Child2();
		child2.run();
		child2.run();
		child2.stop();
		/////////////////////////////////////
		//다형성
		Abclass ab = child;
		//상속관계에서 부모타입의 참조변수가 자식타입객체들의 주소를 받을 수 있다.
		//단, 부모는 자신의 것만 볼 수 있다.
		//단, 재정의는 자식의 자원을 본다.
		ab.run();
		ab.stop();	//재정의 된 자식 함수 호출
		
	}

}
