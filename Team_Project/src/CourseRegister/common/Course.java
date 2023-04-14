package CourseRegister.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Course implements Serializable{
	private String courseName;	//강의명
	private String professor;	//교수명
	private String time;			//강의 시간
	private int maxStudent;		//최대 수강 인원
	private int registNumber;	//현재 신청 인원
	private List<Student> registStudents; // 수강 신청한 학생 목록
	private int credit;	//학점
	
	//강의 생성자 : 생성시 강의명, 교수명, 강의 시간, 최대 수강 인원을 parameter로 갖는다.
	//(현재 신청 인원은 0으로 초기화)
	public Course(String courseName, String professor, String time, int maxStudent, int credit) {
		super();
		this.courseName = courseName;
		this.professor = professor;
		this.time = time;
		this.maxStudent = maxStudent;
		this.registNumber = 0;
		this.registStudents = new ArrayList<Student>();
		this.credit = credit;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getProfessor() {
		return professor;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getMaxStudent() {
		return maxStudent;
	}

	public void setMaxStudent(int maxStudent) {
		this.maxStudent = maxStudent;
	}

	public int getRegistNumber() {
		return registNumber;
	}

	public void setRegistNumber(int registNumber) {
		this.registNumber = registNumber;
	}

	public List<Student> getRegistStudents() {
		return registStudents;
	}

	public void setRegistStudents(List<Student> registStudents) {
		this.registStudents = registStudents;
	}
	

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}
	
	public void increaseRegistNumber() {
		this.registNumber++;
	}
	
	public void decreaseRegistNumber() {
		this.registNumber--;
	}
	
	public void addStudent(Student student) {
		this.registStudents.add(student);
	}
	
	public void removeStudent(Student student) {
		this.registStudents.remove(student);
	}
	
	
}
