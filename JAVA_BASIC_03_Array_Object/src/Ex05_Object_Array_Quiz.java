import kr.or.kosa.dto.Emp;

public class Ex05_Object_Array_Quiz {
	public static void main(String[] args) {
		/*
		문제 1.
		사원 3명을 만드세요
		단 Array 사용
		사원의 정보
		1000, 홍길동
		2000, 김유신
		3000, 유관순
		
		문제 2.
		개선된 for문으로 사번, 이름 모두 출력하세요
		*/
		
		//문제1
		Emp[] emps = {new Emp(1000,"홍길동"),new Emp(2000,"김유신"),new Emp(3000,"유관순")};
		
		//문제2
		for(Emp emp : emps) {
			emp.empInfoPrint();
		}
	}

}
