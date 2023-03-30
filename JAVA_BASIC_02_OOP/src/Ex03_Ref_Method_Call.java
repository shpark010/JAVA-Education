import kr.or.kosa.Tv;

public class Ex03_Ref_Method_Call {

	public static void main(String[] args) {
		//Tv 만드세요 : 메모리에 올려라 -> heap
		Tv lgtv = new Tv();
		lgtv.brand = "LG";
		lgtv.info();
		
		lgtv.up();
		lgtv.up();
		lgtv.up();
		lgtv.info();
		
		lgtv.down();
		lgtv.info();
		
		Tv sstv = new Tv();
		sstv.brand = "SS";
		
		Tv ktv = sstv;	//ktv와 sstv는 같은 주소를 갖는다(동거)
	}

}
