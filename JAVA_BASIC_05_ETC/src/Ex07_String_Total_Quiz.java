import java.util.Scanner;

/*
//주민번호 : 뒷번호 첫자리 : 1,3 남자 , 2,4 여자 라고 출력 ... 하는 문제
//main 함수 Scanner  사용 주민번호 입력받고
//앞:6자리     뒷:7자리

//입력값 : 123456-1234567 

//static 
//1. 자리수 체크 (기능)함수 (14 ok)  return true , false 
//2. 뒷번호 첫번째 자리값 1~4까지의 값만 허용 기능함수  return true, false
//3. 뒷번호 첫번째 자리값을 가지고 1,3 남자 , 2,4 여자 출력 기능함수  void  출력
*/
public class Ex07_String_Total_Quiz {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		boolean run = false;
		while(!run) {
			System.out.print("주민번호를 입력하세요 (예시: 123456-1234567): ");
			String jumin = sc.nextLine();
			//주민번호 형식 검증
			if (!formCheck(jumin)) {
				System.out.println("잘못된 주민번호 형식입니다.");
				continue;
			}else {
				System.out.println("올바른 주민번호 형식입니다.");
			}			
			//주민번호 성별 검증
			int gender = Integer.parseInt(jumin.substring(7, 8));
			if (!check(gender)) {
				System.out.println("잘못된 주민번호입니다. 뒷번호 첫번째 자리값은 1~4까지만 가능합니다.");
				continue;
			}else {
				printGender(gender);	
				run=!run;
			}
		}
		

	}

	// 입력받은 주민번호가 올바른 형식인지 체크하는 함수
	private static boolean formCheck(String jumin) {
		//"-"를 제외한 주민번호의 길이가 맞는지 체크
		if (jumin.replace("-","").length() != 13) {
	        return false;
	    }
		//반복문을 통한 검증
	    for (int i = 0; i < jumin.length(); i++) {
	        char ch = jumin.charAt(i);
	        //배열의 6번째에 "-"가 오는지 확인
	        if (i == 6 && ch == '-') {
	            continue;
	        }
	        //각 번호가 0~9의 범위를 벗어나는지 확인
	        if (ch < '0' || ch > '9') {
	            return false;
	        }
	    }
	    //모든 조건을 충족하면 true
	    return true;
	}

	// 뒷번호 첫번째 자리값이 올바른지 체크하는 함수
	private static boolean check(int gender) {
		return gender >= 1 && gender <= 4;
	}

	// 뒷번호 첫번째 자리값을 가지고 성별을 판단하여 출력하는 함수
	private static void printGender(int gender) {
		if (gender == 1 || gender == 3) {
			System.out.println("남자");
		} else {
			System.out.println("여자");
		}
	}

}