/*
클래스 == 설계도 == 데이터 타입

 TIP)
 하나의 물리적인 java 파일에 여러개의 클래스 생성 가능 (연습할때만 .. 실무X)
 원칙적인 방법은 : 패키지 > kr.or.kosa.utils.Apt 또는 kr.or.kosa.model.Apt
 */

class Apt {	//설계도 == 데이터 타입(사용자 정의 타입) (작은 타입을 여러개 가지고 있는 큰 타입)
			//설계도는 구체화 되지 않으면 종이 한장 -> 의미 없다.
			//목적 : Apt 설계도를 가지고 같은 아파트 무한이 생성하겠다.
			//생성된 설계도는 필요시 재사용이 가능하다(독같은 아파트 무한이 생성 가능)
	String doorColor;
}

public class Ex04_Object_Variable {
	public static void main(String[] args) {
		Apt apt;	//apt변수는 Apt 객체의 주소를 담을 수 있는 변수
		apt = new Apt();	// heap(가비지 컬렉터가 관리하는 자유 영역) 메모리에 아파트가 한채 생성
							//아파트의 주소가 apt 변수에 할당
		//참조값 : 주소값
		System.out.println("apt 주소 : " + apt);
		//Apt@75a1cd57
		//Apt(클래스이름) + @(문자) + 주소값(16진수 값) 결합된 것이 return
		
		Apt apt2 = new Apt();
		System.out.println(apt == apt2);
		System.out.println(apt + " : " + apt2);
		
		Apt apt3 = apt2;	//주소값 할당
		System.out.println(apt2 == apt3);	//apt2와 apt3는 같은 주소와 집을 공유
		System.out.println(apt2 + " : " + apt3);
		
		int i = 10;
		int j = 10;	//값 할당
		j = 10000;
		//i값은 별개다
		
		apt2.doorColor = "red";
		System.out.println(apt3.doorColor);
		
		apt3.doorColor = "blue";
		System.out.println(apt2.doorColor);
		
		//동작 원리
		/*
		 Ex04_Object_Variable.java >> javac.exe >> Ex04_Object_Variable.class(실행파일)
		 >> java Ex04_Object_Variable 엔터 >> JVM 동작 >> OS에게 메모리 할당 요청
		 >> 메모리 할당 >> 메모리(용도) 구획정리 >> 각각의 땅에 (자원할당) 메모리 >> 프로그램 종료
		 >> 사용했던 메모리 OS에게 반환
		 
		 이클립스 >> ctrl + F11
		 1.main 함수 실행... 반드시 local variable(지역변수)은 초기화 해서 사용
		 2.main 함수는 시작점이다
		 */
		
	}

}
