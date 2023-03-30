package kr.or.kosa;

//한건의 데이터를 담을 수 있는 클래스
//데이터베이스의 테이블과 1:1로 매핑 하는 클래스
//create table emp( empno number, ename varchar2(30)); >> 1건의
//select * from emp where empno=7902
//DTO(Data Transfer Object), VO(Value Object), DOMAIN
public class Emp {
	private int empno;
	private String ename;
	
	//default constructor
	//public Emp() {}
	
	//overloading constructor
	public Emp(int empno, String ename) {
		super();
		this.empno = empno;
		this.ename = ename;
	}
	
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	
	public void empInfoPrint() {
		System.out.println(this.empno + " - " + this.ename);
	}
	
	//Object toString() 주소값 반환
	//재정의를 통해서 member field들의 값을 확인하는 용도로 자주 쓰임
	//개발자가 재정의를 하는 데 그 중에 하나가 toString()
	@Override
	public String toString() {
		return "Emp [empno=" + empno + ", ename=" + ename + "]";
	}
	
}
