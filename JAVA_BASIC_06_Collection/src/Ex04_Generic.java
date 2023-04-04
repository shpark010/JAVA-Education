import java.util.ArrayList;
import java.util.List;

//교재 13장
/*
Today Point
jdk 1.5버전 이상

C#, JAVA (필수기능)

1. 타입을 처음 부터 강제
2. 타입의 안정성 확보(타입 강제)
3. 강제 형변환(casting) 필요 없다. ex) (Car)Object 필요 없어짐

*/
//설계도를 만들때 
class MyGeneric<T> {	//Type parameter
	T obj;
	
	void add(T obj) {
		this.obj = obj;
	}
	
	T get() {
		return this.obj;
	}
}

class Person {
	int age = 100;
}
public class Ex04_Generic {

	public static void main(String[] args) {
		MyGeneric<String> mygen = new MyGeneric<String>();
		
		
		mygen.add("문자열");
		String str = mygen.get();
		System.out.println(str);
		
		ArrayList list = new ArrayList();
		list.add(10);
		list.add("홍길동");
		list.add(new Person());
		
		for (Object obj : list) {
			if(obj instanceof Person) {
				Person p = (Person)obj;
				System.out.println(p.age);
			}else {
				System.out.println(obj);				
			}
		}
		
		List<Person> plist = new ArrayList<>();
		plist.add(new Person());
		plist.add(new Person());
		plist.add(new Person());
		for (Person p : plist) {
			System.out.println(p.age);
		}
	}

}
