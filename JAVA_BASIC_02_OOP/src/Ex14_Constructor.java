/*
자동차 영업소 입니다.
영업사원은 고객에게 자동차를 팔려고 합니다.
고객은 자동차의 기본 사양을 살 수 도 있고 ....  여러가지 선택 옵션을 선택 할 수 있습니다.
자동차의 기본은
문의 개수 4개 , 자동차의 색상 기본은 red  4개가 기본 입니다
그런데 고객은
문의 개수만 변경 가능하고  자동차의 색상 기본은 red  으로 할 수 있고
문의 개수는 기본으로 하고 자동차의 색상 변경 가능하고
문의 개수와 자동차의 색상 모든 변경 하여 차를 구매할 수 있습니다

자동차 구매
1. 기본 사양  
2. 옵션 : 문 변경 , 자동차의 색상 기본
3. 옵션 : 자동차의 색상 변경 , 문 기본
4. 옵션 : 자동차의 색상 변경 , 문 변경
*/


class CarOption {
	int door;		//문 개수
	String color;	//차 색상
	
	//기본 사양
	public CarOption() {
		door = 4;
		color = "red";
	}
	//옵션1 : 문 개수만 변경
	public CarOption(int num) {
		door = num;
		color = "red";
	}
	//옵션2 : 차 색상만 변경
	public CarOption(String col){
		door = 4;
		color = col;
	}
	//옵션3 : 문 개수와 차 색상 모두 변경
	public CarOption(int num, String col) {
		door = num;
		color = col;
	}
}

public class Ex14_Constructor {

	public static void main(String[] args) {
		
		CarOption car1 = new CarOption(); //원칙적인 방법은 객체 생성시 한번에 하나씩 
		
	}

}