import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
HashMap<k,v>

HashMap<String,String>
HashMap<Integer,String>
HashMap<String,Student> POINT

put("kglim",new Student());

*/
class ArrayTest {
	ArrayList<String[]> al = new ArrayList<>();
}

class Student {
	int kor;
	int math;
	int eng;
	String name;
	public Student(int kor, int math, int eng, String name) {
		super();
		this.kor = kor;
		this.math = math;
		this.eng = eng;
		this.name = name;
	}
}
public class Ex13_Map_Generic {
	public static void main(String[] args) {
		HashMap<String, String> sts = new HashMap<>();
		sts.put("A", "AAA");
		System.out.println(sts.get("A"));
		
		//실무에서 Map
		//학생의 성적 데이터
		//key(학번), value[국어,영어,수학] >> Array , Collection(ArrayList)
		
		HashMap<String, Student> smap = new HashMap<>();
		smap.put("hong", new Student(100, 90, 50, "홍길동"));
		smap.put("kim", new Student(50, 30, 50, "김유신"));
		Student sd = smap.get("kim");
		System.out.println(sd.kor + " / " + sd.math + " / " + sd.eng + " / " + sd.name);
		
		ArrayTest at = new ArrayTest();
		String[] strarr = {"A","B","C"};
		at.al.add(strarr);
		
		//Tip
		//.entrySet() 가공된 데이터를 return
		Set set = smap.entrySet();	//Map (key, value) 가공 >> key+"="value 하나의 문자열로 return
		Iterator it = set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		//Tip
		//key, value 분리해서 보고 싶다면
		// class Entry { Object key, Object value }
		// Map { Entry[] elements } >> Map.Entry
		for(Map.Entry m : smap.entrySet()) {
			System.out.println(m.getKey() + " / " + ((Student)m.getValue()).name);
		}
		
	}

}
