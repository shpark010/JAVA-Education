/*
OOP 특징 : 여러개의 (작은)조각(클래스)들을 조립해서 하나의 큰 그림(제품)을 만드는 행위
설계도 : 메인 설계도의 부분 설계도, 메인 설계도의 하위 설계도, 별도 독립적인 설계도 등등...

1. 상속
2. 캡슐화(은닉화) >> private
3. 다형성 (상속관계에서 부모타입이 자식타입의 주소를 가질 수 있다)

상속
JAVA : child(자식) extends Base(부모)
C# : child : Base

특징
1. 다중 상속 불가 (단일 상속 원칙) : 계층적 상속을 통한 다중 상속가능
2. 계층적 상속 : 여러개의 클래스를 상속
3. 다중 상속 지원(단, 인터페이스만) interface : 표준, 약속, 규칙, 규약을 정하는 클래스

상속
1. 진정한 의미 : 재사용성
2. 단점 : 비용이 많이듬(기업입장 : 초기 설계 비용이 많이 듬)
부모와 자식의 관계가 너무 끈끈하다(커플링) >> 요즘 코드는 느슨한 관계를 좋아한다.(유지보수에 용이하기 때문)
3. 재사용성 때문에 처음에는 시간이 많이 걸리지만 나중에는 본전을 뽑는다.(재사용성이 높아져서 언젠가는 힘을 발휘한다)

모든 클래스는 메모리에 올라가야 사용 가능하다.

Child child = new Child();를 통해 객체 생성 후 메모리 올라가는 순서
(계층적 관계에서 가장 상위 부모 클래스가 먼저 생성된다) -> 조상이 있어야 내가 있는것 처럼...
Object -> GrandFather -> Father -> Child

사용자가 만드는 모든 클래스는 default로(명시하지 않아도) Object를 상속한다.
class Car extends Object 생략
Object 클래스 -> Root 클래스 -> 모든 클래스의 부모 클래스 -> 모든 클래스의 뿌리

 */

class GrandFather {
	public int gmoney=5000;
	private int pmoney = 10000;	//상속관계에서 접근 불가(무덤까지 가져가겠다)
								//public 함수를 생성해서 간접적으로 접근하면 가능
	//객체 생성과 동시에 호출되는 함수 : 생성자
	public GrandFather() {
		System.out.println("GrandFather 생성자");
	}
}

class Father extends GrandFather {
	public int fmoney=3000;
	
	public Father() {
		System.out.println("Father 생성자");
	}
}

class Child extends Father {
	public int cmoney=100;
	
	public Child() {
		System.out.println("Child 생성자");
	}
}
public class Ex01_Inherit {

	public static void main(String[] args) {
		
		Child child = new Child();
		System.out.println(child.gmoney);
		System.out.println(child.fmoney);
		System.out.println(child.cmoney);
		
		//child.pmoney;	상속관계여도 접근 불가
	}

}
