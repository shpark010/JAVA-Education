
public class Ex02_Exception {

	public static void main(String[] args) {
		System.out.println("main start");
		int num = 100;
		int result = 0;
		
		
		//개발자가 의심되면
		try {
			for(int i = 0 ; i < 10 ; i++) {
				result = num / (int)(Math.random() * 10);	//0~9 난수
				System.out.println("result : " + result + " i : " + i);
			}
		} catch (ArithmeticException e) {	//Exception e : 유지보수가 힘들다. (가독성 떨어짐)
			System.out.println("문제가 발생했습니다. 관리자에게 알려주시기 바랍니다.");
			System.out.println("원인 : " + e.getMessage());
		}
		System.out.println("main end");

	}

}
