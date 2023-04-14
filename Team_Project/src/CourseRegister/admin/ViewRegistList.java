package CourseRegister.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import CourseRegister.common.Course;
import CourseRegister.common.FileIO;
import CourseRegister.common.Search;
import CourseRegister.common.Student;

public class ViewRegistList implements Search {
	private HashMap<String, Course> courseList;
	private HashMap<String, Student> studentList;
	FileIO course = new FileIO("CourseList.txt");
	FileIO student = new FileIO("StudentInfo.txt");
	Scanner sc = new Scanner(System.in);

	public ViewRegistList() {
		this.courseList = (HashMap<String, Course>) course.readObject();
		this.studentList = (HashMap<String, Student>) student.readObject();
		if(this.studentList == null || this.courseList == null) {
			System.out.println("학생 정보나 강의 정보가 없습니다.");
		}
	}

	// 전체 신청 목록 보기
	@Override
	public void searchAll() {
		System.out.println("전체 신청 목록");
		List<Course> allCourse = new ArrayList<>(courseList.values());
		for (Course course : allCourse) {
			System.out.printf("강의명 : [%s] | | 신청현황 : [%d/%d]\n", course.getCourseName(), course.getRegistNumber(),
					course.getMaxStudent());
			System.out.println("신청 학생 명단");
			List<Student> registStudents = new ArrayList<>(course.getRegistStudents());
			for (Student student : registStudents) {
				System.out.print(" [" + student.getName() + "] ");
			}
			System.out.println();
		}
	}

	// 과목별 신청 내역 보기
	@Override
	public void searchByCourse() {
		try {
			System.out.println("검색할 강의을 입력해주세요.");
			System.out.print("입력란 : ");
			String courseName = sc.nextLine();
			System.out.println(courseName + " 강의 신청 목록");
			if (!courseList.containsKey(courseName)) {
				System.out.println("해당 강의는 존재하지 않습니다.");
			} else {
				System.out.println("강의 신청 현황 : " + courseList.get(courseName).getRegistNumber() + "/"
						+ courseList.get(courseName).getMaxStudent());
				List<Student> students = courseList.get(courseName).getRegistStudents();
				/*
				for (Student student : students) {
					System.out.print(" [" + student.getName() + "] ");
				}
				*/
				for (int i = 0 ; i < students.size() ; i++) {
					System.out.print(" [" + students.get(i).getName() + "] ");
				}
				System.out.println();
			}
		} catch (Exception e) {
			System.out.println("잘못된 입력입니다.");
		}
	}

	// 학생별 신청 내역 보기
	@Override
	public void searchByName() {
		try {
			System.out.println("검색할 학생을 입력해주세요.");
			System.out.print("입력란 : ");
			String studentName = sc.nextLine();
			Student searchStudent = null;
			for (Student student : studentList.values()) {
				if (student.getName().equals(studentName)) {
					searchStudent = student;
				}
			}
			if (searchStudent == null) {
				System.out.println("일치하는 학생이 없습니다.");
			}else {
				System.out.println(studentName + "학생의 신청 목록");
				List<Course> courses = searchStudent.getCourseList();
				if(courses.isEmpty()) {
					System.out.println(studentName + "학생은 신청한 강의가 없습니다.");
				}else {
					for (Course course : courses) {
						System.out.print(" [" + course.getCourseName() + "] ");
					}
					System.out.println();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("잘못된 입력입니다.");
		}

	}

}
