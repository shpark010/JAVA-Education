/*
원칙 : 객체를 생성할때 생성자는 1개만 호출 가능 ( new Zcar() or new Zcar(10) )

this >> 객체 자신

Zcar(){} >> this(){}

*/
/*
class Zcar {
	String color;
	String gearType;
	int door;
	
	Zcar() {	//기본 설정
		this.color = "red";
		this.gearType = "auto";
		this.door = 2;
	}
	
	Zcar(String color, String gearType, int door) {
		this.color = color;
		this.gearType = gearType;
		this.door = door;
	}
	void socarPrint() {
		System.out.println(this.color + " , " +  this.gearType + " , " + this.door);
	}
}
*/
class Zcar {
	String color;
	String gearType;
	int door;
	
	Zcar() {	//기본 설정
		this("red","auto",2);	//나를 다시 부르네 .... 오버라이딩 생성자 호출
		/*
		this.color = color;
		this.gearType = gearType;
		this.door = door;
		*/
	}
	
	Zcar(String color, String gearType, int door) {
		this.color = color;
		this.gearType = gearType;
		this.door = door;
	}
	void zcarPrint() {
		System.out.println(this.color + " , " +  this.gearType + " , " + this.door);
	}
}

class Zcar2 {
	String color;
	String gearType;
	int door;
	
	//기본 설정
	Zcar2() {
		this("red",2);	
		// 옵션 1의 오버라이딩 생성자에서 color, door 초기화 
		//-> 옵션 2의 오버라이딩 생성자에서 gearType 초기화
		//기본옵션(red,auto,2)
		System.out.println("default....");
	}
	
	//옵션 1 : 색상과 문 개수 변경
	Zcar2(String color, int door) {
		this(color,"auto",door);
		//옵션 2의 오버라이딩 생성자에서 gearType 초기화
		//옵션 color, door 만 변경 가능 (gearType은 auto로 설정)
		System.out.println("overloading parameter call 2개");
	}
	
	//옵션 2 : 전체 변경
	Zcar2(String color, String gearType, int door) {
		this.color = color;
		this.gearType = gearType;
		this.door = door;
		System.out.println("overloading parameter call 3개");
		//옵션 : color, gearType, door
	}
	
	//정보 찍는 메서드
	void socarPrint() {
		System.out.println(this.color + " , " +  this.gearType + " , " + this.door);
	}
}

public class Ex16_this {

	public static void main(String[] args) {
		Zcar zcar = new Zcar();
		zcar.zcarPrint();
		
		Zcar zcar2 = new Zcar("yellow", "auto", 10);
		zcar2.zcarPrint();
		
		Zcar2 car = new Zcar2();	//기본옵션
		
		Zcar2 car2 = new Zcar2("gold",10);	//옵션1(parameter 2개 - 색상, 개수)
		
		Zcar2 car3 = new Zcar2("gold","auto",20);	//옵션2(parameter 3개 - 색상, 기어, 개수)
		
	}

}
