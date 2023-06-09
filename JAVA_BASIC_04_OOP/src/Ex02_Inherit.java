//두개의 설계도
class Tv {
	boolean power;
	int ch;
	
	void power() {	//두개의 기능을 하나의 함수로 처리
		//boolean
		this.power = !this.power;	//전원 스위치(토글링)
	}
	void chUp() {
		this.ch++;
	}
	void chDown() {
		this.ch--;
	}
}

class Vcr {	//비디오 플레이어
	boolean power;
	
	void power() {
		this.power = !this.power;	//전원 스위치(토글링)
	}
	void play() {
		System.out.println("재생하기");
	}
	void stop() {
		System.out.println("정지하기");
	}
	void rew() {}
	void ff() {}
}
//설계도 2개
/*
class Tv
class Vcr

제품
Tv와 Vcr 합쳐진 제품

TvVcr 출시

class TvVcr extends Tv, Vcr -> (X) 다중 상속 금지
>> 계층적 상속 ( 할아버지, 아버지 계층 구조 파악하기 힘듬 , 자원의 이름이 같으면 구분하기 힘듬 )

TvVcr 클래스 구현 방법
1. 한 놈은 상속, 다른 놈은 포함
2. 둘다 포함

TvVcr 메인 기능 : TV -> 주요(메인) 기능을 비중에 따라 나눈다.
 */
class TvVcr {
	Tv tv;
	Vcr vcr;
	
	public TvVcr() {
		this.tv = new Tv();	//초기화 (주소값 할당)
		this.vcr = new Vcr();	//초기화 (주소값 할당)
	}
}

class TvVcr2 extends Tv {
	Vcr vcr;
	public TvVcr2() {
		this.vcr = new Vcr();
	}
}

public class Ex02_Inherit {

	public static void main(String[] args) {
		TvVcr my = new TvVcr();
		my.tv.power();
		my.vcr.power();
		System.out.println(my.tv.power);
		System.out.println(my.vcr.power);
//		----------------------------------
		
		TvVcr2 tv2 = new TvVcr2();
		tv2.power();
		System.out.println("TV전원 : " + tv2.power);
		
		tv2.vcr.power();
		System.out.println("VCR전원 : " + tv2.vcr.power);
		
	}

}
