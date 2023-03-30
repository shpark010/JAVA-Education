/*

	this(이것)
	1. 객체 자신을 가르키는 this (앞으로 생성될 객체의 주소를 담을 곳이라고 가정)
	>>인스턴스 자신을 가르키는 참조변수 , 인스턴스의 주소가 저장되어있다
	
	2. this 객체 자신 (주소) : 생성자 호출 (원칙적으로 생성자 객체 생성시 한개 호출)
	그런데 this 활용하면 예외적으로 this 통해서 여러개의 생성자를 호출할 수 있다.
 
*/
class Test5 { //extends Object가 생략
	int i;
	int j;
	
	Test5() {	//생성자
		
	}
	Test5(int i, int j) {	//
		this.i=i;
		this.j=j;
	}
	
}

class Book2 {
	String bookName;
	/*
	public Book2(String name) {
		bookName = name;	//코드좀 이쁘게 -> 가독성
	}
	*/
	public Book2(String name) {
		this.bookName = name;	//가독성
	}
}

//Today Point
//생성자를 호출하는 this (중복코드의 감소)

class Socar {
	String color;
	String gearType;
	int door;
	
	Socar() {	//기본 설정
		this.color = "red";
		this.gearType = "auto";
		this.door = 2;
	}
	
	Socar(String color, String gearType, int door) {
		this.color = color;
		this.gearType = gearType;
		this.door = door;
	}
	void socarPrint() {
		System.out.println(this.color + " , " +  this.gearType + " , " + this.door);
	}
}

public class Ex15_this {
	public static void main(String[] args) {
		Test5 test5 = new Test5(1, 2);
		
		Socar socar = new Socar();
		socar.socarPrint();
		
		Socar socar2 = new Socar("gold", "auto", 6);
		socar2.socarPrint();
		
	}

}
