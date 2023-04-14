package CourseRegister.admin;

import java.util.HashMap;
import java.util.Scanner;

import CourseRegister.common.Course;
import CourseRegister.common.FileIO;
import CourseRegister.common.Student;

public class CourseManagement {
	private HashMap<String, Course> courseList;	//강의 리스트
	Scanner sc = new Scanner(System.in);
	
	//강의 관리 생성잔
	public CourseManagement() {
		this.courseList = null;
	}
	
	//강의 생성
	public void addCourse() {
		try {
			System.out.println("새로운 강의 생성을 위한 정보를 입력해주세요.");
			System.out.print("강의명 : ");
			String courseName = sc.nextLine();
			System.out.print("교수명 : ");
			String professor = sc.nextLine();
			System.out.print("강의시간(ex. 13:00~13:50) : ");
			String time = sc.nextLine();
			System.out.print("최대 수강 인원 : ");
			int maxStudent = Integer.parseInt(sc.nextLine());
			System.out.print("학점 : ");
			int credit = Integer.parseInt(sc.nextLine());
			FileIO add = new FileIO("CourseList.txt");
			courseList = (HashMap<String, Course>)add.readObject();
			if(courseList == null) {
				courseList = new HashMap<String, Course>();
			}
			courseList.put(courseName ,new Course(courseName, professor, time, maxStudent, credit));
			add.writeObject(courseList);
			System.out.println("[" + courseName + "]강의를 추가했습니다.");
		} catch (Exception e) {
			System.out.println("잘못된 입력 형식입니다. 이전 메뉴로 돌아갑니다.");
		}
	}
	
	//강의 정보 수정
	public void modifyCourse() {
		try {
			System.out.println("수정할 강의명을 입력해주세요.");
			System.out.print("강의명 : ");
			String courseName = sc.nextLine();
			FileIO modify = new FileIO("CourseList.txt");
			courseList = (HashMap<String, Course>)modify.readObject();
			Course modifyCourse = courseList.get(courseName);
			System.out.print("수정할 강의명 : ");
			String fixcourseName = sc.nextLine();
			System.out.print("교수명 : ");
			String fixprofessor = sc.nextLine();
			System.out.print("강의시간(ex. 13:00~13:50) : ");
			String fixtime = sc.nextLine();
			System.out.print("최대 수강 인원 : ");
			int fixmaxStudent = Integer.parseInt(sc.nextLine());
			System.out.print("학점 : ");
			int fixCredit = Integer.parseInt(sc.nextLine());
			if(courseList == null) {
				courseList = new HashMap<String, Course>();
			}
			courseList.put(fixcourseName ,new Course(fixcourseName, fixprofessor, fixtime, fixmaxStudent, fixCredit));
			modify.writeObject(courseList);
			System.out.println("[" + fixcourseName + "]강의를 수정했습니다.");
		} catch (Exception e) {
			System.out.println("잘못된 입력 형식입니다. 이전 메뉴로 돌아갑니다.");
		}
	}
	
	//강의 제거
	public void removeCourse() {
		try {
			System.out.println("삭제할 강의명을 입력해주세요.");
			System.out.print("강의명 : ");
			String removecourseName = sc.nextLine();
			FileIO remove = new FileIO("CourseList.txt");
			courseList = (HashMap<String, Course>)remove.readObject();
			if(courseList == null) {
				courseList = new HashMap<String, Course>();
			}
			courseList.remove(removecourseName);
			remove.writeObject(courseList);
			System.out.println("[" + removecourseName + "]강의를 삭제했습니다.");
		} catch (Exception e) {
			System.out.println("잘못된 입력 형식입니다. 이전 메뉴로 돌아갑니다.");
		}
	}
}
