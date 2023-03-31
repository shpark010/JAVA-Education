import kr.or.kosa.Singleton;

public class Ex15_Singleton_main {

	public static void main(String[] args) {
		Singleton s = Singleton.getInstance();
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		System.out.println(s == s1);
		System.out.println(s1 == s2);
		
	}

}
