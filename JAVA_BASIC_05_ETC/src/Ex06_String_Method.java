import java.util.StringTokenizer;

public class Ex06_String_Method {

	public static void main(String[] args) {
		String str = "hello";
		//concat() : ()안의 문자열과 결합
		String concatstr = str.concat(" world");
		System.out.println(concatstr);
		
		//.contains() : ()안의 문자열이 포함되어있는지 여부 확인
		boolean bo = str.contains("ello");
		System.out.println(bo);
		
		String str2 = "a b c d";	//[a][ ][b][ ][c][ ][d] -> 공백도 인정한다.
		System.out.println(str2.length());
		
		String filename = "hello java world";
		System.out.println(filename.indexOf("e"));	//1
		System.out.println(filename.indexOf("java"));	//6
		System.out.println(filename.indexOf("개폭망"));	//-1
		//값이 없으면 -1리턴 -> 배열에 원하는 단어가 없다.
		//신문사설 원하는 검색 -> 내가 원하는 단어가 있는지를 확인
		if(filename.indexOf("wo") != -1) {
			System.out.println("wo 단어가 하나라도 있다.");
		}
			
		System.out.println(filename.lastIndexOf("a"));	//9
		
		//length(), indexOf(), substring(), replace(), split() 암기
		
		String result = "superman";
		System.out.println(result.substring(0));	//superman
		System.out.println(result.substring(1));	//uperman
		System.out.println(result.substring(1,2));	//u
		//.substring(index) : ()안의 index 뒤의 문자열만 가져옴
		//.substring(index1,index2) : ()안의 index1(포함) 부터 index2(미포함) 앞 까지 문자열만 가져옴
		
		//Quiz
		String filename2 = "home.jpg";	//또는 h.jpeg, aaaaa.hwp 올 수 있다.
		//파일명과 확장자를 분리해서 출력
		System.out.println("파일명 : " +  filename2.substring(0,filename2.indexOf(".")));
		System.out.println("확장자 : " +  filename2.substring(filename2.indexOf(".")+1));
		
		
		//replace
		String str3 = "ABCDADDDDDDA";
		String result3 = str3.replace("DDDDD", "오늘은 화요일");
		System.out.println(result3);
		
		result3 = str3.replace("A", "a");
		System.out.println(result3);
		
		//ETC
		System.out.println(str3.charAt(0));
		System.out.println(str3.charAt(3));
		System.out.println(str3.endsWith("DDDA"));	//문자열의 마지막 부분부터 ()안의 문자열과 비교
		System.out.println(str3.equalsIgnoreCase("aBCDAdDDDDDA"));	//대소문자 구별 없이 비교
		
		//Today Point
		String str4 = "슈퍼맨,팬티,노랑색,우하하,우하하";
		String[] namearray = str4.split(",");
		for (String string : namearray) {
			System.out.println(string);
		}
		
		/*
		IP 주소를 .(dot) 기주능로 나누는 예제
		구분자를 지정하는 파라미터는 정규표현식이라서 .만 넣으면 원하시는대로 나오지 않습니다.
		정규표현식의 예약어라서 .(dot) 앞에 역슬래시(\)를 2개 넣어야 인식됩니다.
		 */
		String str5 = "슈퍼맨\\.팬티\\.노랑색\\.우하하\\.우하하";
		namearray = str5.split("\\.");
		for (String string : namearray) {
			System.out.println(string);
		}
		
		//정규표현식 (문자들을 조합해서 규칙을 만들고 : 그 규칙하고 데이터 비교해서 판단)
		//우편번호 : {\d3}-{\d3} >> 12-123(false) , 123*123(false), 111-111(true)
		//https://cafe.naver.com/erpzone
		
		//정규표현식 일단 내일 시간상...
		
		//
		
		String str6 = "a/b,c-d.f";
		StringTokenizer sto = new StringTokenizer(str6, "/,-.");
		while(sto.hasMoreElements()) {
			System.out.println(sto.nextToken());
		}
		
		//넌센스
		String str7 = "홍       길           동";
		//저장 >> 공백제거
		System.out.println(str7.replace(" ", ""));	//홍길동
		
		String str8 = "           홍길동         ";
		System.out.println(str8.trim());
		
		String str9 = "      홍      길       동          ";
		System.out.println(str9.trim().replace(" ", ""));
		
		//hint
		int sum = 0;
		String[] numarr = {"1","2","3","4"};
		for (String s : numarr) {
			sum+=Integer.parseInt(s);
		}
		System.out.println(sum);
		
		
		//주민번호의 각 자리 합 구하기
		String jumin = "123456-1234567";
		int sum1 = 0;
		for (int i = 0; i < jumin.length(); i++) {
		    String change = jumin.substring(i, i+1);
		    if (change.equals("-")) continue;
		    sum1 += Integer.parseInt(change);
		}
		System.out.println(sum1);
	}

}
