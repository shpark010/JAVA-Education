import java.util.Properties;

/*
Map 인터페이스를 구현한 클래스
특수한 설정 : <String,String> : [key]와 [value]의 [타입]이 [String]으로 [고정]

사용 목적
1. Application 전체에 사용되는 자원관리
2. 환경변수 (전역의 의미)
3. 프로그램의 버전
4. 로그인ID, 비번
5. 공통변수

*/
public class Ex14_Properties {

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.setProperty("admin", "kosa@or.kr");
		prop.setProperty("version", "1.x.x.x");
		prop.setProperty("downpath", "C:\\Temp\\images");
		//각각의 개발 페이지에서... 가정
		System.out.println(prop.getProperty("admin"));
		System.out.println(prop.getProperty("version"));
		System.out.println(prop.getProperty("downpath"));
	}

}
