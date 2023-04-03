import java.util.Vector;

/*
Collection Framework
[다수의 데이터]를 다루는 [표준화된 인터페이스]를 구현하고 있는 [클래스의 집합]

Collection 인터페이스 -> 상속 List -> 구현 ArrayList
Collection 인터페이스 -> 상속 Set -> 구현 HashSet

* ArrayList 의 부모타입은 List 이다. * : (O) >> 다형성
* Collection 인터페이스는 ArrayList의 부모타입이다. * : (O) >> 다형성
* instanceof 검증

Map 인터페이스 (key, value) 쌍의 배열 >> 구현 HashMap

1. List (줄을 서시오)
순서가 있는 데이터의 집합(번호표) : 중복허용 -> 순서(O), 중복(O) 데이터 집합
>>Tip) Array 관리 >> 정적 배열이기 때문에 배열의 길이를 변형시키지 못한다는 단점이 있다.

1.1 Vector (구버전) -> 동기화 보장 (O) >> Lock default
			Vector (화장실) -> 멀티 스레드 환경(Lock) -> 성능(X) 보안(O)
1.2 ArrayList (신버전) -> 동기화 보장 (X) >> Lock option
			ArrayList (비빔밥) -> 멀티 스레드 환경() -> 성능(O) 보안(X)
Vector 유지보수, 학습용
ArrayList 활용

-----------------------------------------------------------------------
다수의 데이터를 다루는 방법 (Array >> 정적, 고정)
*******방의 개수가 한번 정해지면 방의 크기는 변경 불가 ********
정수 배열 만드는 방법
1.int[] arr = new int[5];
2.int[] arr2 = new int[]{10,20,30,40,50};
3.int[] arr3 = {10,20,30,40,50};
arr3 놀고 있는데 데이터가 100건이 추가
int[] arr4 = new int[100];
******새로운 배열 생성하고 데이터 이동을 코드로 직접 개발자가 구현해야 한다.******

Array
1. 배열의 크기가 고정 : Car[] cars = {new Car(), new Car()}; 2개
2. 접근방법 (index) >> cars[0] ,,,n(length-1)

List 인터페이스를 구현하고 있는 ArrayList, Vector는 
1. 배열의 크기가 동적으로 확장 or 축소 가능 >> **진실은 커마일러가 새로운 배열을 만들고 데이터 이동 **
2. 순서를 유지 (내부적으로 Array) 사용, 중복값 허용
3. 중복값 허용 (index를 통해서 제어)
*/
public class Ex01_Vector {

	public static void main(String[] args) {
		Vector v = new Vector();
		System.out.println("초기 용량 : " + v.capacity());
		System.out.println("size : 값의 크기(개수) : " + v.size());
		
		v.add("AA");	//순서[0]
		v.add("AA");	//순서[1]
		v.add("AA");	//순서[2]
		v.add(10);
		System.out.println("size : " + v.size());
		System.out.println(v.toString());	//[AA, AA, AA, 10]
		//Array >> 배열의 개수 >> length() -> 방의 개수를 셈 >> Car[0]
		//Collection >> size() -> 값의 개수를 셈 >> get(0)
		for (int i = 0; i < v.size(); i++) {
			System.out.println(v.get(i));	//get(index) return 배열 값
		}
		//개선된 for문 출력
		for (Object object : v) {
			System.out.println(object);
		}
		
		//단점 : 작은 데이터 (같은 타입의 데이터) >>> 가장 큰 타입을 사용해서 얻는 것이 불합리
		//제너릭 >> 타입을 강제 >> Point
		Vector<String> v2 = new Vector<String>();
		v2.add("hello");
		v2.add("world");
		for(String str : v2) {
			System.out.println(str);
		}
		
		Vector v3 = new Vector<>();
		System.out.println(v3.capacity());	//Object[] obj = new Object[10];
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");	//11번째
		
		System.out.println(v3.toString());
		System.out.println(v3.capacity());	//20개
		System.out.println(v3.size());
		
		//그냥 펀하게 쓰세요 (동적 늘어나고 줄어요)
		//실질적으로는 2배 길이의 배열을 만들어서 해당 배열로 값과 주소를 옮김
		
	}

}
