package CourseRegister.student;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import org.xml.sax.SAXNotRecognizedException;

import CourseRegister.common.Course;
import CourseRegister.common.FileIO;
import CourseRegister.common.Student;

public class StudentSystem {
	private String loginID; // 학생 정보
	FileIO course = new FileIO("CourseList.txt");
	FileIO student = new FileIO("StudentInfo.txt");
	private HashMap<String, Course> courseList;
	private HashMap<String, Student> studentList;
	
	Scanner sc = new Scanner(System.in);

	// 학생 시스템 생성자
	public StudentSystem(String loginID) {
		super();
		this.loginID = loginID;
		this.courseList = (HashMap<String, Course>) course.readObject();
		this.studentList = (HashMap<String, Student>) student.readObject();
	}

	// 학생 시스템 실행
	public void run() {
		boolean run = false;
		while(!run) {
			System.out.println("수강신청 시스템 입니다. 메뉴를 선택해주세요.");
			System.out.println("1.강의 검색 | 2.수강 신청 | 3.신청 취소 | 4.신청 내역 | 5.로그아웃");
			int choice = Integer.parseInt(sc.nextLine());
			switch (choice) {
				case 1:
					courseList();
					break;
				case 2:
					courseRegist();
					break;
				case 3:
					courseDrop();
					break;
				case 4:
					requestInquire();
					break;
				case 5:
					System.out.println("로그아웃 합니다.");
					loginID = null;
					return;
			}
		}
	}

	// 강의 검색
	public void courseList() {
		if(this.courseList == null) {
			System.out.println("등록된 강의가 없습니다.");
		}else {
			boolean run = false;
			while(!run) {
				System.out.println("강의 검색 메뉴입니다. 메뉴를 선택해주세요.");
				System.out.println("1.전체 검색 | 2.과목 검색 | 3.교수 검색 | 4.돌아가기");
				int choice = Integer.parseInt(sc.nextLine());
				SearchCourse search = new SearchCourse();
				switch (choice) {
				case 1:
					search.searchAll();
					break;
				case 2:
					search.searchByCourse();
					break;
				case 3:
					search.searchByName();
					break;
				case 4:
					System.out.println("이전 메뉴로 돌아갑니다.");
					run = !run;
					break;
				}
			}
		}
	}

	// 수강 신청
	public void courseRegist() {
		System.out.println("수강신청할 강의명을 입력해주세요.");
		System.out.print("입력란 : ");
		String courseName = sc.nextLine();
		List<Course> registCourse = studentList.get(loginID).getCourseList();	//학생 신청 목록 불러오기
		Course addCourse = courseList.get(courseName);	//강의 리스트에서 강의 정보 불러오기
		if(addCourse == null) {
			System.out.println("입력하신 강의가 존재하지 않습니다.");
		}else {
			for (Course c : registCourse) {
				if(c.getCourseName().equals(courseName)) {
					System.out.println("해당 강의는 이미 신청 완료된 강의 입니다.");
					return;				
				}
			}
			if(addCourse.getMaxStudent() == addCourse.getRegistNumber()) {
				System.out.println("수강 가능 인원이 가득 찼습니다.");
				System.out.println("현재 신청 인원 : " + courseList.get(courseName).getRegistNumber());
				return;
			}else if(studentList.get(loginID).getAvailableGrade() < addCourse.getCredit()) {
				System.out.println("이수 가능한 잔여 학점이 부족합니다.");
				System.out.println("잔여 신청 가능 학점 : " + studentList.get(loginID).getAvailableGrade());
				return;
			}
			addCourse.increaseRegistNumber();	//해당 과목의 현재 신청인원 증가
			addCourse.addStudent(studentList.get(loginID));
			registCourse.add(addCourse);	//학생 신청 목록에 추가
			studentList.get(loginID).setCourseList(registCourse);
			studentList.get(loginID).decreaseAvailableGrade(addCourse.getCredit());
			Course newCourse = courseList.get(courseName);
			System.out.println("[" + courseName + "] 강의 수강신청을 완료했습니다." );
			System.out.println("잔여 신청 가능 학점 : " + studentList.get(loginID).getAvailableGrade());
			course.writeObject(courseList);		//변경사항 작성
			student.writeObject(studentList);	//변경사항 작성
		}
	}

	// 신청 취소
	public void courseDrop() {
		System.out.println("수강취소할 강의명을 입력해주세요.");
		System.out.print("입력란 : ");
		String courseName = sc.nextLine();
		List<Course> registCourse = studentList.get(loginID).getCourseList();	//학생 신청 목록 불러오기
		if(registCourse.isEmpty()) {
			System.out.println("수강 신청한 강의가 없습니다.");
		}else {
			Course dropCourse = courseList.get(courseName);	//강의 리스트에서 강의 정보 불러오기
			if(dropCourse == null) {
				System.out.println("취소하려는 강의가 존재하지 않습니다.");
			}else {
				for (Course c : registCourse) {
					if(c.getCourseName().equals(courseName)) {
						System.out.println("[" + c.getCourseName() + "] 수강을 취소합니다.");
						registCourse.remove(c);
						break;			
					}
				}
				dropCourse.decreaseRegistNumber();	//해당 과목의 현재 신청인원 증가
				dropCourse.removeStudent(studentList.get(loginID));
				registCourse.remove(dropCourse);	//학새 신청 목록에 추가
				studentList.get(loginID).setCourseList(registCourse);
				studentList.get(loginID).increaseAvailableGrade(dropCourse.getCredit());
				System.out.println("[" + courseName + "] 강의 수강취소를 완료했습니다." );
				System.out.println("잔여 신청 가능 학점 : " + studentList.get(loginID).getAvailableGrade());
				course.writeObject(courseList);		//변경사항 작성
				student.writeObject(studentList);	//변경사항 작성			
			}
		}
	}

	// 신청 내역
	public void requestInquire() {
		List<Course> courselist = studentList.get(loginID).getCourseList();
		if(courselist.isEmpty()) {
			System.out.println("수강 신청한 강의가 없습니다.");
		}else {
			System.out.println("잔여 이수 가능 학점 : " + studentList.get(loginID).getAvailableGrade());
			System.out.println("신청내역");
			for (Course course : courselist) {
				Course cl = courseList.get(course.getCourseName());
				System.out.printf("강의명 : [%s] | 교수명 : [%s] | 강의 시간 : [%s] | 학점 : [%d] | 신청현황 : [%d/%d]\n",
						course.getCourseName(), course.getProfessor(), course.getTime(), course.getCredit(), cl.getRegistNumber(), cl.getMaxStudent());
			}
		}
	}
}
