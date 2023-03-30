package kr.or.kosa;
/*
public class AirPlane {
	private String aname;
	private int anum;
	private static int amount;
	
	

	public void createAirPlane(int num, String name) {
		aname = name;
		anum = num;
		amount++;
		confirm();
	}
	
	public void confirm() {
		System.out.printf("[비행기 이름] : %s\t[비행기 번호] : %d\n",aname,anum);
	}
	
	public void viewAmount() {
        System.out.println("누적 비행기 생산량 : " + amount);
    }
	
}
*/

//생성자를 사용해서 아래 코드를 수정하세요
public class AirPlane {
	private String aname;
	private int anum;
	private static int amount;
	
	public AirPlane(int num, String name) {
		aname = name;
		anum = num;
		amount++;
	}
	
	public void confirm() {
		System.out.printf("[비행기 이름] : %s\t[비행기 번호] : %d\n",aname,anum);
	}
	
	public void viewAmount() {
        System.out.println("누적 비행기 생산량 : " + amount);
    }
	
}