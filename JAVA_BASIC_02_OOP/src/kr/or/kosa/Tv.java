package kr.or.kosa;
/*
Tv 설계도 요구사항정의
Tv는 채널 정보를 가지고 있다 (예를 들면 1~200 값을 가질 수 있다) public
Tv는 브랜드 이름를 가지고 있다 (예를 들면 엘지, 삼성) public
Tv는 채널 전환 기능을 가지고 있다 (채널은 한 채널씩 이동이 가능하다)
->채널을 증가 시키는 기능을 가지고 있다.
->채널을 감소 시키는 기능을 가지고 있다.
Tv의 채널 정보외 브랜드이름을 볼 수(출력) 있는 기능을 가지고 있다.
*/
public class Tv {
	//field
	public int channel;
	public String brand;
	
	//method
	//채널 증가
	public void up() {
		channel++;
	}
	//채널 감소
	public void down() {
		channel--;
	}
	//채널 정보 & 브랜드 이름 출력
	public void info() {
		System.out.printf("브랜드명 : [%s]\t기본 채널 : [%d]\n",brand,channel);
	}
	
	
}
