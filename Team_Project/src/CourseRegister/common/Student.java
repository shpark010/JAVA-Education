package CourseRegister.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Student implements Serializable {
	private String name;			//학생 이름
	private String studentID;		//학번
	private String pwd;				//비밀번호
	private List<Course> courseList;//수강 신청 목록
	private int availableGrade;		//이수 가능 학점
	
	//학생 생성자 : 생성시 이름, 학번, 비밀번호를 parameter로 갖는다.
	//(신청 목록은 null, 이수 가능 학점은 21로 초기화)
	public Student(String name, String studentID, String pwd) {
		super();
		this.name = name;
		this.studentID = studentID;
		this.pwd = pwd;
		this.courseList = new ArrayList<Course>();
		this.availableGrade = 21;
	}

	public List<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}

	public int getAvailableGrade() {
		return availableGrade;
	}

	public void setAvailableGrade(int availableGrade) {
		this.availableGrade = availableGrade;
	}

	public String getName() {
		return name;
	}

	public String getStudentID() {
		return studentID;
	}

	public String getPwd() {
		return pwd;
	}
	
	public void decreaseAvailableGrade(int credit) {
		this.availableGrade-=credit;
	}
	
	public void increaseAvailableGrade(int credit) {
		this.availableGrade+=credit;
		if(this.availableGrade>21) {
			this.availableGrade = 21;
		}
	}
	
}
