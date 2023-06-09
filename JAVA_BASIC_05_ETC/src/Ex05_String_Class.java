/*
String 클래스 (문자를 여러개 담을 수 있는 클래스)
String은 수 많은 함수를 가지고 있다. why? : 우리가 다루는 대부분의 데이터는 문자열이기 때문이다. 
String이 가지고 있는 일반함수 + static 함수 활용 : 15 ~ 20개 함수 공부
 
 
 */
public class Ex05_String_Class {

	public static void main(String[] args) {
		String str = "";
		String[] strarr = {"abc", "bbb", "ccc"};
		
		for(String s : strarr) {
			System.out.println(s);
		}
		//사용방법 : int, double 값타입 처럼 부담없이 사용
		
		/////////////////////////////////////////////////
		
		String st = "홍길동";
		System.out.println(st.length());
		//[홍][길][동] >> char[]로 관리
		System.out.println(st);	//클래스라 주소라 예상하겠지만 실제로는 값 (toString()이 생략되어있다.) / 안써도 컴파일러가 알아서 붙여버린다.
		System.out.println(st.toString());
		//String 클래스는 Object라는 부모 클래스를 가지고 있다. 부모가 가지는 메서드중 toString()이 있다.
		//상속관계 String extends Object >> 재정의 (오버라이드(Override)) >> 주소에 가서 값을 read해서 그 값을 return하도록
		
		//정식 표기
		String sdata = new String("김유신");
		System.out.println(sdata);
		
		String name = "가나다라마";
		//String 내부적으로 char[] member field >> 배열 [가][나][다][라][마]
		//class String extends Object {private char[] str ......setter.......@Override toString()}
		
		String str1 = "AAA";
		String str2 = "AAA";
		
		//문자열의 비교
		System.out.println(str1);	//toString()이 생략되어있다.
		System.out.println(str2.toString());	//toString() 재정의 주소값이 아니고 값이 나오도록
		
		System.out.println(str1 == str2);
		//== 연산자는 값을 비교 str1 주소값 str2주소값
		//같은 주소 판명
		//**메모리에 실제로 같은 문자열이 있으면 재사용
		//str1과 str2 같은 메모리를 참조
		
		//Point
		//문자열의 비교는 무조건 .equals()
		System.out.println(str1.equals(str2));	//toString() 재정의 주소값이 아니고 값이 나오도록
		
		String str3 = new String("BBB");	//새로운 객체 생성
		String str4 = new String("BBB");	//새로운 객체 생성
		System.out.println(str3==str4);	//false : 가지고 있는 객체의 주소값을 비교
		System.out.println(str3.equals(str4));	//true : 실제 값을 비교
		
		String s = "A";
		s += "B";
		s += "C";
		System.out.println(s);
		s = "A";
		System.out.println(s);
		//그래서 String 누적쓰면 바보
		//Stringbuilder or Stringbuffer
		
	}

}
