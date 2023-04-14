package CourseRegister.common;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import CourseRegister.admin.AdminSystem;
import CourseRegister.student.StudentSystem;

public class CourseRegister {
	private HashMap<String, Student> studentList; // 학생 리스트
	private String loginID;
	Scanner sc = new Scanner(System.in);

	// 생성자
	public CourseRegister() {
		this.loginID = null;
		this.studentList = null;
	}


	// 실행
	public void run() {
		boolean run = false;
		System.out.println("수강신청 프로그램");
		while(!run) {
			int result = login();
			switch(result) {
			case 0:
				continue;
			case 1:
				studentMenu();
				break;
			case 2:
				adminMenu();
				break;
			}
		}
	}

	// 로그인
	public int login() {
		int result = 0;
		System.out.println("1.로그인\t2.회원가입");
		System.out.print("입력란 : ");
		int select = 0;
		try {
			select = Integer.parseInt(sc.nextLine());	
		} catch (Exception e) {
			System.out.println("잘못된 입력 형식입니다. 다시 입력해주세요.");
		}
		switch (select) {
		case 1:
			System.out.println("아이디와 비밀번호를 입력해주세요.");
			System.out.print("아이디 : ");
			String inputID = sc.nextLine();
			System.out.print("비밀번호 : ");
			String inputPWD = sc.nextLine();
			if(inputID.equals("admin")) {
				FileIO admin = new FileIO("Admin.txt");
				String[] adminInfo = ((String)admin.readFile()).split(":");
				String adminID = adminInfo[0];
				String adminPWD = adminInfo[1];
				if(inputID.equals(adminID) && inputPWD.equals(adminPWD)) {
					result = 2;
				}
			}else {
				HashMap<String, Student> students = null;
				try {
					FileIO get = new FileIO("StudentInfo.txt");
					studentList = (HashMap<String, Student>)get.readObject();
					if(inputPWD.equals(studentList.get(inputID).getPwd())) {
						this.loginID = studentList.get(inputID).getStudentID();
						result = 1;
					}
				} catch (Exception e) {
					System.out.println("입력하신 정보가 없습니다. 초기 화면으로 돌아갑니다.");
					login();
				}				
			}
			break;
		case 2:
			 System.out.println("회원가입 정보를 입력해주세요.");
			    System.out.print("이름 : ");
			    String newName = sc.nextLine();

			    // 아이디 입력 검사
			    String newID;
			    Pattern idPattern = Pattern.compile("^[a-zA-Z0-9]{5,15}$"); // 알파벳이나 숫자로 이루어진 5~15자리 문자열 검사
			    while (true) {
			        System.out.print("아이디 : ");
			        newID = sc.nextLine().trim();
			        Matcher idMatcher = idPattern.matcher(newID);
			        if (idMatcher.matches()) {
			            break; // 검사를 통과한 경우 while 루프를 종료
			        }
			        System.out.println("아이디는 5~15자리의 알파벳이나 숫자만 입력 가능합니다. 다시 입력해주세요.");
			    }

			    // 비밀번호 입력 검사
			    String newPWD;
			    Pattern pwdPattern = Pattern.compile("^(?=.*[a-zA-Z0-9])(?=.*[!@#$%^&+=])(?=\\S+$).{8,}$"); // 알파벳이나 숫자와 특수문자가 결합된 8자리 이상의 문자열 검사
			    while (true) {
			        System.out.print("비밀번호 : ");
			        newPWD = sc.nextLine().trim();
			        Matcher pwdMatcher = pwdPattern.matcher(newPWD);
			        if (pwdMatcher.matches()) {
			            break; // 검사를 통과한 경우 while 루프를 종료
			        }
			        System.out.println("비밀번호는 알파벳이나 숫자와 특수문자가 결합된 8자리 이상의 문자열만 입력 가능합니다. 다시 입력해주세요.");
			    }

			    Student newStudent = new Student(newName, newID, newPWD);
			    FileIO get = new FileIO("StudentInfo.txt");
			    studentList = (HashMap<String,Student>)get.readObject();
			    if(studentList == null) {
			        studentList = new HashMap<String, Student>();
			    }
			    if(studentList.containsKey(newID)) {
			        System.out.println("이미 가입된 회원입니다.");
			        break;
			    }
			    studentList.put(newID, newStudent);
			    FileIO add = new FileIO("StudentInfo.txt");
			    add.writeObject(studentList);
			    System.out.println(newName + "님 회원가입 완료되었습니다. 다시 로그인 해주세요.");
			    break;
			/*
			System.out.println("회원가입 정보를 입력해주세요.");
			System.out.print("이름 : ");
			String newName = sc.nextLine();
			System.out.println("아이디는 알파벳이나 숫자로 이루어진 5~15자리");
			System.out.print("아이디 : ");
			String newID = sc.nextLine();
			System.out.println("비밀번호는 알파벳이나 숫자와 특수문자가 결합된 8자리 이상의 문자");
			System.out.print("비밀번호 : ");
			String newPWD = sc.nextLine();
			Student newStudent = new Student(newName, newID, newPWD);
			FileIO get = new FileIO("StudentInfo.txt");
			studentList = (HashMap<String,Student>)get.readObject();
			if(studentList == null) {
				studentList = new HashMap<String, Student>();
			}
			if(studentList.containsKey(newID)) {
				System.out.println("이미 가입된 회원입니다.");
				break;
			}
			studentList.put(newID, newStudent);
			FileIO add = new FileIO("StudentInfo.txt");
			add.writeObject(studentList);
			System.out.println(newName + "님 회원가입 완료되었습니다. 다시 로그인 해주세요.");
			break;
			*/
		}
		return result;
	}

	// 학생 메뉴
	public void studentMenu() {
		System.out.println("학생 메뉴 입니다.");
		StudentSystem ss = new StudentSystem(loginID);
		ss.run();
	}

	// 관리자 메뉴
	public void adminMenu() {
		AdminSystem as = new AdminSystem();
		as.run();
	}
}
