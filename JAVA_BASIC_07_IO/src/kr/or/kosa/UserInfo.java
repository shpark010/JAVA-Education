package kr.or.kosa;

import java.io.Serializable;

/*
객체 통신
객체(Car, Tv, Tank) >> 프로세스, 네트워크, 파일 간에 통신 >>  통신을 위해서 직렬화 or 역직렬화

직렬화 : 객체를 분해해서 줄을 세워 보내는 과정
역직렬화 : 객체를 다시 조립하는 과정

모든 자원(class) 직렬화 가능? : NO!!
직렬화 가능한 제품 설계 (마치 레고 블럭 처럼)
설계 방법 : implements Serializable(직렬화 인터페이스를 상속 받아야 한다)

*/
public class UserInfo implements Serializable {
	private String name;
	private String pwd;
	private int age;
	
	public UserInfo(String name, String pwd, int age) {
		super();
		this.name = name;
		this.pwd = pwd;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public String getPwd() {
		return pwd;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "UserInfo [name=" + name + ", pwd=" + pwd + ", age=" + age + "]";
	}
	
	
}
