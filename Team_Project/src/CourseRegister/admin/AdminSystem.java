package CourseRegister.admin;

import java.util.Scanner;

public class AdminSystem {
	Scanner sc = new Scanner(System.in);
	
	public void run() {
		boolean run = false;
		while(!run) {
			try {
				System.out.println("관리자 메뉴 입니다.");
				System.out.println("1.신청 내역 조회 | 2.강의 관리 | 3.로그아웃");
				System.out.print("입력란 : ");
				int choice = Integer.parseInt(sc.nextLine());
				switch(choice) {
				case 1:
					viewRegistList();
					break;
				case 2:
					courseManagement();
					break;
				case 3:
					System.out.println("로그아웃 합니다.");
					run = !run;
					break;
				}	
			} catch (Exception e) {
				System.out.println("올바르지 않은 입력 형식입니다. 다시 선택해주세요.");
			}
		}
	}
	
	//신청 내역 조회
	public void viewRegistList() {
		boolean run = false;
		while(!run) {
			ViewRegistList vrl = new ViewRegistList();
			System.out.println("강의 관리 메뉴");
			System.out.println("1.전체 목록 | 2.과목별 신청 내역 | 3.학생별 신청 내역 | 4.돌아가기");
			System.out.print("입력란 : ");
			try {
				int choice = Integer.parseInt(sc.nextLine());
				switch(choice) {
				case 1:
					vrl.searchAll();
					break;
				case 2:
					vrl.searchByCourse();
					break;
				case 3:
					vrl.searchByName();
					break;
				case 4:
					System.out.println("이전 메뉴로 돌아갑니다.");
					run = !run;
					break;
				}
			} catch (Exception e) {
				System.out.println("잘못된 입력 형식입니다. 다시 입력해주세요.");
				courseManagement();
			}
		}
	}
	
	//강의 관리
	public void courseManagement() {
		CourseManagement cm = new CourseManagement();
		boolean run = false;
		while(!run) {
			System.out.println("강의 관리 메뉴");
			System.out.println("1.강의 추가 | 2.강의 정보 수정 | 3.강의 제거 | 4.돌아가기");
			System.out.print("입력란 : ");
			try {
				int choice = Integer.parseInt(sc.nextLine());
				switch(choice) {
					case 1:
						cm.addCourse();
						break;
					case 2:
						cm.modifyCourse();
						break;
					case 3:
						cm.removeCourse();
						break;
					case 4:
						System.out.println("이전 메뉴로 돌아갑니다.");
						return;
				}
			} catch (Exception e) {
				System.out.println("잘못된 입력 형식입니다. 다시 입력해주세요.");
				courseManagement();
			}
		}
	}
}
