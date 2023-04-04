import java.util.ArrayList;
import java.util.Iterator;

import kr.or.kosa.Emp;

/*
객체 배열
*/
public class Ex03_ArrayList_Object {

	public static void main(String[] args) {
		//1. 사원 1명을 만드세요
		Emp emp = new Emp(1000, "김유신", "장군");
		System.out.println(emp.toString());
		
		//2. 사원 2명을 만드세요 (Array)
		Emp[] emplist = {new Emp(100, "김씨", "영업"),new Emp(200, "박씨", "IT")};
		for (Emp e : emplist) {
			System.out.println(e.toString());
		}
		
		//3. ArrayList 사용
		ArrayList elist = new ArrayList();
		elist.add(new Emp(100, "김씨", "영업"));
		elist.add(new Emp(200, "박씨", "IT"));
		//추가 입사
		elist.add(new Emp(300, "이씨", "IT"));
		for (int i = 0; i < elist.size() ; i++) {
			System.out.println(elist.get(i).toString());
		}
		
		//toString() 사용하지 말고 3명의 사원 정보를 출력하세요.
		//hint) getter
		//ArrayList 는 내부적으로 Object[]로 관리
		for (int i = 0; i < elist.size() ; i++) {
			Object obj = elist.get(i);
			System.out.println(obj);	//재정의된 toString()
			//obj.getEmpno() 부모타입의 참조변수는 자식타입의 자원에 접근하지 못한다. (재정의 제외)
			//자식타입으로 down casting
			Emp e = (Emp)obj;
			System.out.println(e.getEmpno() + "/ " + e.getEname() + "/ " + e.getJob());
		}
		
		//현업 개발자 불편(Object >> DownCasting을 통한 자식 접근)
		//Object 쓰지 말자
		//타입 강제 (그 타입을 쓰게 하자) -> 테이터의 관리는 하나의 타입으로 -> 타입은 필요시에 사용
		//Generic (제너릭)
		ArrayList<Emp> list2 = new ArrayList<Emp>();
		list2.add(new Emp(1,"A","IT"));
		for(Emp e : list2) {
			System.out.println(e.getEmpno());
		}
	}

}
