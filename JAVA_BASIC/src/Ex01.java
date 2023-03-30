import kr.or.kosa.Car;

public class Ex01 {

	public static void main(String[] args) {
		System.out.println("hello");	//Ctrl+F11 (저장 > 컴파일 > 실행)
		
		//A >> Car.class
		//B >> Car.class
		//C >> 하나의 장소 >> 어떤 문제
		
		//자동차 생산
		Car mycar = new Car();
		mycar.setDoor(2);
		mycar.setCarColor("red");
		mycar.run();
	}
}
