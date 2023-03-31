/*
게임 : 유닛(unit)

unit : 공통기능(이동좌표, 이동, 멈푼다) : 추상화, 일반화
unit : 이동방법은 다르다. (이동방법은 unit 마다 다르기 때문에 별도의 구현이 필요하다(반드시))

class Unit { void move(); }	//각각 유닛을 만드는데 반드시 move() 다른 형태로 구현
//강제성이 없다..
*/

//믿음이 없어서...
abstract class Unit {
	int x, y;

	void stop() {
		System.out.println("Unit stop");
	}

	// 이동 (서로 다르게) 강제 구현 ..다름을 구현
	abstract void move(int x, int y); // 실행블럭(X) -> 추상함수 -> 미완성 함수
}

class Tank extends Unit {

	@Override
	void move(int x, int y) {
		this.x = x;
		this.y = y;
		System.out.println("Tank는 소리내며 이동 : " + this.x + "," + this.y);
	}

	// 필요에 따라서 구체화, 특수화 구현(고유한 기능)
	void changeMode() {
		System.out.println("탱크모드 변환");
	}
}

class Marine extends Unit {

	@Override
	void move(int x, int y) {
		this.x = x;
		this.y = y;
		System.out.println("Marine 이동 : " + this.x + "," + this.y);
	}

	// 필요에 따라서 구체화, 특수화 구현(고유한 기능)
	void stimpack() {
		System.out.println("스팀팩기능");
	}
}

class DropShip extends Unit {

	@Override
	void move(int x, int y) {
		this.x = x;
		this.y = y;
		System.out.println("DropShip 하늘로 이동 : " + this.x + "," + this.y);
	}

	// 필요에 따라서 구체화, 특수화 구현(고유한 기능)
	void load() {
		System.out.println("Unit load");
	}

	void upload() {
		System.out.println("Unit upload");
	}
}

public class Ex02_abstract_class {

	public static void main(String[] args) {
		Tank tank = new Tank();
		tank.move(500, 200);
		tank.stop();
		tank.changeMode();

		Marine marin = new Marine();
		marin.move(200, 300);
		marin.stop();
		marin.stimpack();
		
		//Today Point
		//JAVA : instanceof (객체의 타입 비교하는 연산자 true, false)
		//JavaScript : typeof, instanceof
		
		if(tank instanceof Unit) {
			//객체			//타입
			System.out.println("true");
		}else {
			System.out.println("false");
		}
		
		if(tank instanceof Tank) {
			//객체			//타입
			System.out.println("true");
		}else {
			System.out.println("false");
		}
		
		//다형성 문제
		// 1. 탱크 3대를 만들고 같은 좌표(600, 800)으로 이동 시키세요.
		Tank[] tanklist = {new Tank(),new Tank(),new Tank()};
		for (Tank t : tanklist) {
			t.move(600, 800);
			t.stop();
		}

		// 2. 여러개의 Tank 1대, Marine 1사람, DropShip 1대를 생성하고 같은 좌표로 이동
		// (666,888)
		Unit[] unitlist = { new Tank(), new Marine(), new DropShip() };
		for (Unit unit : unitlist) {
			unit.move(666, 888);
			unit.stop();
		}
	}

}
