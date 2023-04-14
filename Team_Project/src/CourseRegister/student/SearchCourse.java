package CourseRegister.student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import CourseRegister.common.Course;
import CourseRegister.common.FileIO;
import CourseRegister.common.Search;
import CourseRegister.common.Student;

public class SearchCourse implements Search {
	private HashMap<String, Course> courseList;
	private HashMap<String, Student> studentList;
	FileIO course = new FileIO("CourseList.txt");
	FileIO student = new FileIO("StudentInfo.txt");
	Scanner sc = new Scanner(System.in);
	
	public SearchCourse() {
		this.courseList = (HashMap<String, Course>)course.readObject();
		this.studentList = (HashMap<String, Student>)student.readObject();
	}
	
	//전체 강의 목록
	@Override
	public void searchAll() {
		System.out.println("전체 강의 목록");
		List<Course> allCourse = new ArrayList<>(courseList.values());
		for (Course course : allCourse) {
		    System.out.printf("강의명 : [%s] | 교수명 : [%s] | 강의 시간 : [%s] | 학점 : [%d] | 신청현황 : [%d/%d]\n",
		    		course.getCourseName(), course.getProfessor(), course.getTime(), course.getCredit(), course.getRegistNumber(), course.getMaxStudent());
		}
	}
	
	//과목명 검색
	@Override
	public void searchByCourse() {
		try {
			System.out.println("검색할 강의을 입력해주세요.");
			System.out.print("입력란 : ");
			String courseName = sc.nextLine();
			System.out.println("[" + courseName + "]" + " 강의 정보를 찾습니다...");
			boolean found = false;
			List<Course> courselist = new ArrayList<>(courseList.values());
			for (Course course : courselist) {
				if (course.getCourseName().equals(courseName)) { // 해당 필드에서 검색어가 포함된 경우
					System.out.printf("강의명 : [%s] | 교수명 : [%s] | 강의 시간 : [%s] | 학점 : [%d] | 신청현황 : [%d/%d]\n",
							course.getCourseName(), course.getProfessor(), course.getTime(), course.getCredit(), course.getRegistNumber(), course.getMaxStudent());
					found = true;
				}
			}
			if (!found) {
			    System.out.println("해당 정보를 찾을 수 없습니다.");
			}
			System.out.println();
		} catch (Exception e) {
			System.out.println("해당 정보를 찾을 수 없습니다.");
		}
		
	}
	
	//교수명 검색
	@Override
	public void searchByName() {
		try {
			System.out.println("검색할 강의을 입력해주세요.");
			System.out.print("입력란 : ");
			String professor = sc.nextLine();
			System.out.println(professor + " 교수님 강의 정보를 찾습니다...");
			boolean found = false;
			List<Course> courselist = new ArrayList<>(courseList.values());
			for (Course course : courselist) {
				if (course.getProfessor().contains(professor)) { // 해당 필드에서 검색어가 포함된 경우
					System.out.printf("강의명 : [%s] | 교수명 : [%s] | 강의 시간 : [%s] | 학점 : [%d] | 신청현황 : [%d/%d]\n",
							course.getCourseName(), course.getProfessor(), course.getTime(), course.getCredit(), course.getRegistNumber(), course.getMaxStudent());
					found = true;
				}
			}
			if (!found) {
			    System.out.println("해당 정보를 찾을 수 없습니다.");
			}
			System.out.println();				
			
		} catch (Exception e) {
			System.out.println("해당 정보를 찾을 수 없습니다.");
		}
		
	}

}
