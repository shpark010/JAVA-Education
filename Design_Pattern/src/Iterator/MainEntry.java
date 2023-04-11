package Iterator;

public class MainEntry {

	public static void main(String[] args) {
		//구성 요소가 담긴 배열 생성
		Item[] items = {
				new Item("CPU", 1000),
				new Item("Keyboard", 2000),
				new Item("Mouse", 3000),
				new Item("HDD", 50)
		};
		
		//구성 데이터를 얻기 위한 클래스 객체 생성
		Array array = new Array(items);
		//반복자 생성
		Iterator it = array.iterator();
		
		//while문을 통한 구성 데이터 확보 및 출력
		//it.next()로 다음 데이터를 얻을 수 있는지 여부 확인
		while(it.next()) {
			Item item = (Item)it.current();
			System.out.println(item);
		}
	}
}
