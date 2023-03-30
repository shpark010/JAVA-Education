
public class Ex09_Static_Method {
	
	void method() {
		System.out.println("나 일반 함수야");
	}
	
	static void smethod() {
		System.out.println("나 static 함수야");
	}
	
	public static void main(String[] args) {
		//Ex09_Static_Method.smethod();
		smethod();
		Ex09_Static_Method ex09 = new Ex09_Static_Method();
		ex09.method();
		
		ex09.smethod();
	}

}
