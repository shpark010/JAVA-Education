
class Human {
	String name;
}

class OverClass {
	int add(int i, int j) {
		return i+j;
	}
	
	void add(Human human) {	//Human 타입의 주소값을 갖는다.
		System.out.println(human.name);
	}
	//1. add(new Human());
	//2. Human h = new Human(); add(h);
	//반드시 해야 합니다.
	
	//배열은 객체다 == 배열도 타입이다
	int add(int param) {
		return param + 100;
	}
	
	int[] add(int[] params) {	//add(String....values) >> add(1,2,3), add(1,2)
		//int[] arr = {1,2}  add(arr)	//배열 타입의 주소값
		//안의 코드는 개발자 마음
		int[] target = new int[params.length];
		for (int i = 0; i < target.length; i++) {
			target[i] = params[i] + 1;
		}
		return target;	//return 을 정의하고 코딩 (객체, 배열 null)
	}
}

public class Ex06_Array_Method {
	public static void main(String[] args) {
		OverClass overt = new OverClass();
		int[] source = {10,20,30,40,50};
		int[] ta = overt.add(source);
		for (int value : ta) {
			System.out.println(value);
		}
	}

}
