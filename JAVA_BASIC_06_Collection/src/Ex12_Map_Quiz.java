import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Ex12_Map_Quiz {

	public static void main(String[] args) {
		/*
		Map 사용하는 데이터 집합
		지역번호, 우편번호, 회원가입(id, pwd)
		*/
		HashMap loginmap = new HashMap();	//메모리에는 회원 id, pwd 저장
		loginmap.put("kim", "kim1004");
		loginmap.put("scott", "tiger");
		loginmap.put("lee", "kim1004");
		/*
		우리 시스템은 회원가입한 회원의 id, pwd를 관리하고 있다.
		로그인시 아이디와 비번을 확인해서 회원이라면 사이트 접속을 가능하게 해라.
		
		id(O), pwd(O) >> 회원님 방가	1.
		id(O), pwd(X) >> 비밀번호 입력 추가	2.
		
		id(X), pwd(O) >> 회원가입 유도 
		id(X), pwd(X) >> 회원가입 유도
		
		사용자로 부터 id, pwd 입력 받으세요
		id는 공백제거, 소문자로 변환 후 String 변수에 담아서 사용
		pwd는 공백만 제거
		d(O), pwd(O) >> "회원님 방가 방가" 출력 후 while문 탈출
		id(O), pwd(X) >> "비밀번호 확인하세요" 출력

		id(X), pwd(O) >> "id가 맞지 않습니다. 재입력하세요"
		id(X), pwd(X) >> "id가 맞지 않습니다. 재입력하세요"
		*/
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("아이디와 비밀번호를 입력해주세요.");
			System.out.print("아이디 : ");
			String id = sc.nextLine().replace(" ", "").toLowerCase();
			System.out.print("비밀번호 : ");
			String pwd = sc.nextLine().replace(" ", "");
			if(!loginmap.containsKey(id)) {
				System.out.println("id가 맞지 않습니다. 재입력하세요");
				continue;
			}else {
				if(loginmap.get(id) == pwd) {
					System.out.println("회원님 방가 방가");
					break;
				}else{
					System.out.println("비밀번호 확인하세요");
					continue;
				}
			}
			
		}
		
		
	}

}
