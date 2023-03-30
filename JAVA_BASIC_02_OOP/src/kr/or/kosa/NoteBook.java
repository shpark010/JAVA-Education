package kr.or.kosa;

/*
노트북은 마우스를 가지고 있다 -> 설계도 추가 -> class Mouse { } -> 새로운 데이터 타입
-마우스는 휠 1개, 버튼 2개, 좌표값을 가진다.

고유데이터(정보), 상태데이터(정보), 부품데이터(정보)

Class Mouse {
	int x;
	int y;
	
}

노트북은 색상을 가지고 있다.
노트북은 생산년도를 가지고 있다.

*/
public class NoteBook {
	//public Mouse mouse = new Mouse();	-> 통합 제품 생성 ( 라이프 사이클이 같다 = 노트북이 사라지면 같이 사라짐 )
	
	//노트북은 [ 필요에 따라서 ] 마우스를 가질 수 있다.
	//가진다 : 생성된 마우스의 주소값을 가질 수 있다 (heap에 생성된)
	
	public void handleMouse(Mouse mouse) {
		mouse.setX(100);
		mouse.setY(100);
		mouse.getReadMouseData();
	}
	
	private String color;
	private int year;
	
	public String getColor() {
		return color + " 색상 ";
	}
	public void setColor(String data) {
		color = data;
	}
	
	//함수 생성 (특수한 목적의 함수 : private member field 간접적으로 read, write)
	public int getYear() {	//읽기 전용
		return year;
	}
	public void setYear(int data) {	//쓰기 전용
		if(data < 0) {
			year = 1999;			
		}else {
			year = data;
		}
	}
	
	public void noteBookInfo() {
		System.out.printf("노트북 색상 : [%s] , 노트북 출시 년도 : [%d]\n", color, year);
	}
	
	/*
	객체지향언어 : 캡슐화(은닉화) -> 직접할당을 막고 간접할당을 제어(정보보호)
	방법 : private 한정자 사용 (참조변수 입장에서 객체에 접근 했을때 자원이 보이지 않으면...)
	
	1. 모든 member field 캡슐화
	2. 직접 할당을 막고 간접 할당을 통해서 원하는 값으로 제어
	3. 간접 : 개발자가 직접 논리| 제어
	4. 간접적으로 접근할 수 있는 함수 생성 (write 함수, read 함수)
	
	*/
	
	
}