import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/*
Map 인터페이스
(key, value) 쌍의 구조를 갖는 배열
ex) 지역번호(02,서울) (031,경기)

key 중복(X) >> Set와 성질이 비슷
value 중복(O) >> List와 성질이 비슷

Generic 지원

Map 인터페이스 구현하는 클래스 : 동기화(Thread : stack 여러개 사용하기)
구버전 : HashTable	(동기화) 보장 : 한강 화장실 (Lock) : 자원 보호 목적
신버전 : HashMap	(동기화) 보장하지 않음 : 한강 비빔밥 축제 (성능) : 성능 우선 *********

ArrayList , HashMap + Generic >> 기본적인 CRUD >> DB


*/
public class Ex11_Map_Interface {

	public static void main(String[] args) {
		HashMap map = new HashMap();
		map.put("Tiger", "1004");	//key : id / value : pwd
		map.put("scott", "1004");
		map.put("Superman", "1007");
		
		//.containKey(key) : 대소문자를 구별해 해당하는 key값을 가지고 있는지 여부를 확인
		System.out.println(map.containsKey("tiger"));	
		System.out.println(map.containsKey("scott"));
		System.out.println(map.containsValue("1004"));
		
		//.get(key)
		//key를 제공하면 해당하는 key에 따른 value값을 리턴
		System.out.println(map.get("Tiger"));	//1004
		System.out.println(map.get("hong"));	//null
		
		//만약에 기존 key값에 새로운 value로 put한다면 새로운 value값이 세팅 된다.
		map.put("Tiger", "1008");	//key가 동일하면 value (replace)
		System.out.println(map.size());
		System.out.println(map.get("Tiger"));	//1008
		System.out.println(map.toString());
		
		Object value = map.remove("Superman");
		System.out.println("삭제된 value : " + value);
		System.out.println(map.toString());
		
		//응용(이해)
		Set set = map.keySet();
		//keySet() 함수는 Set 인터페이스를 구현하고 있는 객체를 생성하고 데이터 담아서
		//그 주소를 리턴
		//부모타입인 Set 인터페이스를 통해서 자식객체의 주소를 받을 수 있다.
		Iterator it = set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		Collection clist = map.values();
		System.out.println(clist.toString());
		
	}

}
