import java.io.IOException;

import kr.or.kosa.utils.ExClass;

public class Ex04_thorws {

	public static void main(String[] args) {
		
		try {
			ExClass ex = new ExClass("Temp");
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
