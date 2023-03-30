/*
현업 개발
한 개의 클래스로 설계한 경우는 없다.

설계도 1장에 모든 업무를 구현 -> 현실적으로 불가능(유지보수 어렵다)
설계도를 여러개로 나눈다. -> 문제 발생 (어떤 기준, 논리로 나누고 묶을 것인가?)

ex) 쇼핑몰
결제관리, 배송관리, 재고관리, 회원관리, 상품관리, 판매처관리, 카드관리.... -> 각각의 업무별 설계도

*************** 기준 **************
여러개의 설계도가 있을 때 관계를 만들어주는 기준

1. [상속] : is	~ a	: ?은(는) ~ 이다.	-> [상속]의 관계 (부모를 뒤에)
2. [포함] : has	~ a	: ?은(는) ~을 가지고 있다. -> [포함]의 관계

원은 도형이다 -> 1번(상속)
경찰은 권총이다 -> X ->
경찰은 권총을 가지고 있다 -> 2번(포함)

원은 도형이다.
원 extends 도형
삼각형은 도형이다.
삼각형 extends 도형


원 , 점 관계
원은 점이다. (X)

원은 점을 가지고 있다. (O)
has ~ a (부품정보)
>> class 원 { 점이라는 부품이 member field로 구현 -> 점 원의점; }
>> class 점 { x,y }

경찰 권총
경찰은 권총이다. (X)
경찰은 권총을 가지고 있다. (O)
class 권총 {}
class 경찰 { 권총 member field }

원은 도형이다.
삼각형은 도형이다.
사각형은 도형이다.

도형  분모 (공통적) 자원을 가진다 : 추상화, 일반화 -> 그리다, 색상
원 : 구체와, 특수화(자신만이 가지는 특징) >> 반지름, 한 점

점 : 좌표값(x,y)
원은 점을 가지고 있다.
삼각형은 점을 가지고 있다.
사각형은 점을 가지고 있다.

-----------------------------------
class Shape{ 그리다, 색상 } -> 상속관계에서 부모 역할 -> 원, 삼각형, 사각형의 부모일 것이다.
class Point{ 좌표값 } -> 포함관계 -> (부품)

구체화, 특수화 할 자원 -> Circle, Triangle

 */
class Shape {
	String color = "gold";
	void draw() {
		System.out.println("도형을 그리다.");
	}
}

class Point {
	int x;
	int y;
	
	public Point() {
		//this.x = 1;
		//this.y = 1;
		this(1,1);
	}
	
	public Point(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	
}

//문제)
/*
원을 만드세요 (원의 정의 : 원은 한점과 반지름을 가지고 있다)
1. 원은 도형이다 (is ~ a) : Shape
2. 원은 점을 가지고 있다 (has ~ a) : Point
3. 원은 특수화되고 구체화된 내용은 : 반지름

원의 반지름은 초기값 10을 가진다
점의 좌표는 초기값 (10,15)를 가진다
초기값을 설정하지 않으면 반지름과 점의 값을 입력 받을 수 있다.
 */

/*
문제2)
삼각형 클래스를 만드세요
삼각형은 3개의 점과 색상과 그리고 그리다 기능을 가지고 있다.
hint) Shape, Point 제공 받아서 설계도를 작성 하세요
hint) (x,y), (x,y), (x,y)
default 삼각형을 만들 수 있고 3개의 좌표값을 받아서 그릴 수 있다.
 */
class Triangle extends Shape{
	Point[] points;
	
	public Triangle() {
		this(new Point[] {new Point(1,2),new Point(3,4),new Point(5,6)});
	}
	
	public Triangle(Point[] points) {
		this.points = points;
	}
	
	void trianglePoint() {
		for(Point point : this.points) {
			System.out.printf("(%d,%d)\t",point.x , point.y);
		}
	}
}

class Circle extends Shape{
	Point point;	//포함 [부품]
	int r;	//구체화, 특수성
	
	public Circle() {
		//this.r = 10;
		//this.point = new Point(10,15);
		this(10,new Point(10,15));
	}
	
	public Circle(int r, Point point) {	//point는 Point 객체의 주소값을 받는다.
		this.r = r;
		this.point = point;
	}
}

public class Ex02_Inherit_Composition {

	public static void main(String[] args) {
		Circle circle = new Circle();
		System.out.println(circle.r);
		System.out.println(circle.color);
		System.out.println(circle.point.x);	//주소값.주소값.주소값.field
		System.out.println(circle.point.y);
		circle.draw();
		
		//반지름, 점의 값을 자유롭게
		//Point point = new Point(10,20);
		//Circle circle2 = new Circle(100,point);
		Circle circle2 = new Circle(100, new Point(10,14));	//이런 식의 코드가 더 많다.
		
		
		Triangle tri = new Triangle();
		tri.trianglePoint();
		
		//Triangle tri2 = new Triangle(new Point(1,2), new Point(3,4),new Point(5,6));
		//tri2.trianglePoint();
		
		
		Point[] parray = new Point[] {new Point(11,22),new Point(33,44),new Point(55,66)};
		Triangle tri3 = new Triangle(parray);
		tri3.trianglePoint();
		
		
		
	}

}
