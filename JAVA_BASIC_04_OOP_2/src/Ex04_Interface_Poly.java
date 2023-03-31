
class Unit2 {
	int hitpoint;	//기본 에너지
	final int MAX_HP; //최대 에너지
	Unit2(int hp) {
		this.MAX_HP = hp;
	}
}
//인터페이스
//~ 할 수 있는 (수리할 수 있는)
interface Irepairable {}

//지상유닛, 공중유닛, 건물
//지상유닛
class GroundUnit extends Unit2 {

	GroundUnit(int hp) {
		super(hp);
	}
}
//공중유닛
class AirUnit extends Unit2 {

	AirUnit(int hp) {
		super(hp);
	}
}
//건물
class CommandCenter implements Irepairable {}
//유닛
class Tank2 extends GroundUnit implements Irepairable {

	Tank2() {
		super(50);
		this.hitpoint = this.MAX_HP;
	}

	@Override
	public String toString() {
		return "Tank2";
	}
}
//마린
class Marine2 extends GroundUnit {

	Marine2() {
		super(50);
		this.hitpoint = this.MAX_HP;
	}
	@Override
	public String toString() {
		return "Marine2";
	}
}
//scv
class Scv extends GroundUnit implements Irepairable {

	Scv() {
		super(50);
		this.hitpoint = this.MAX_HP;
	}
	@Override
	public String toString() {
		return "Scv";
	}
	
	//Scv 구체화, 특수화된 고유한 기능 구현
	//수리하다 (repair)
	//Tank2, Scv, CommandCenter
	
	//전자제품 매장 : 제품 1000개 -> buy() -> 1000개의 buy함수를 만드는것이 아니다
	//[다형성]을 이용해 buy(Product n)
	/*
	void repair(Tank2 tank) {
		
	}
	void repair(Scv scv) {
		
	}
	*/
	//GroundUnit 부모 -> (Tank2, Marine2, Scv) 자식
	//void repair(Unit2 unit) -> GroundUnit의 Marine뿐만 아니라 AirUnit도 포함됨
	//void repair(GroundUnit unit) -> Marine 때문에 안됨.
	
	//CommandCenter repair 서로의 공통점 (연결고리 -> 부모가 같지 않다)
	
	//제가 한번 해볼게요
	//interface Irepairable{}
	
	//class CommandCenter implements Irepairable {}
	//class Tank2 extends GroundUnit implements Irepairable {}
	//class Scv extends GroundUnit implements Irepairable {}
	
	//부모로서 Irepairable 서로 연관성이 없는 자원에 대해서 같은 부모를 제공
	
	//다형성
	void repair(Irepairable repairunit) {
		//repairunit로 받을 수 있는 타입 : Tank2, Scv, CommandCenter
		//수리하는 방법이 다르다.
		//Tank2, Scv -> HP 가지고 올려주면 된다.
		//다른 방법으로 repair
		
		//repairunit 일반 Unit2 아니냐 판단해서 적용
		//instanceof 연산자를 활용
		if(repairunit instanceof Unit2) {
			//Tank2 or Scv
			Unit2 unit2 = (Unit2)repairunit;	
			//Irepairable repairunit는 최상위 타입이므로 한단계 아래인 Unit2로 캐스팅
			if(unit2.hitpoint != unit2.MAX_HP) {
				unit2.hitpoint = unit2.MAX_HP;
			}
		}else {
			//건물
			System.out.println("다른 충전 방식을 통해서 repair 합니다.");
		}
	}
}

public class Ex04_Interface_Poly {

	public static void main(String[] args) {
		Tank2 tank = new Tank2();
		Marine2 marine2 = new Marine2();
		Scv scv = new Scv();
		CommandCenter center = new CommandCenter();
		
		//전투
		tank.hitpoint -= 20;
		System.out.println("탱크 : " + tank.hitpoint);
		System.out.println("Scv 수리 요청");
		scv.repair(tank);
		scv.repair(center);
		System.out.println("탱크 수리 완료 : " + tank.hitpoint);
	}

}
