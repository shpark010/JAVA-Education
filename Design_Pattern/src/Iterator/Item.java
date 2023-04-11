package Iterator;

public class Item {
	//필드
	private String name;	//이름
	private int cost;	//가격
	
	//생성자
	public Item(String name, int cost) {
		this.name = name;
		this.cost = cost;
	}
	
	//문자열 변환 메서드인 toString()을 재정의
	@Override
	public String toString() {
		return "(" + name + ", " + cost + ")";
	}
}
