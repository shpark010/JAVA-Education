class Human2 {
	String name;
	int age;
}

class Test3 {
	Human2 add(Human2 h) {
		//return h;
		
		Human2 man = h;
		man.name = "아무개";
		man.age= 100;
		return man;
		
		//return null;
	}
	
	Human2 add(Human2 h, Human2 h2) {
		//return null;
		h2.name = h.name;
		h2.age = h.age;
		return h2;
	}
}


public class Ex12_Method_Overloading {

	public static void main(String[] args) {
		Test3 t3 = new Test3();
		
		Human2 man = new Human2();
		Human2 man2 = t3.add(man);
		System.out.println(man==man2);
		
	}

}
