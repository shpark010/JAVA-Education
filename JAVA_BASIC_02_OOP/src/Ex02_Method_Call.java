import kr.or.kosa.Fclass;
import kr.or.kosa.Tv;

public class Ex02_Method_Call {

	public static void main(String[] args) {
		Fclass fclass = new Fclass();
		fclass.m();
		
		fclass.m2(1234);
		
		int result = fclass.m3();
		System.out.println("return value : " + result);
		
		result = fclass.m4(10);
		System.out.println("return value : " + result);
		
		result = fclass.opSum(-500);
		System.out.println("return value : " + result);
		
		result = fclass.max(10, 6);
		System.out.println("return value : " + result);
		
		
	}

}
