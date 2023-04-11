package Iterator;

public class Array implements Aggregator{
	//필드
	private Item[] items;	//배열 데이터
	
	//생성자
	public Array(Item[] items) {
		this.items = items;
	}
	
	//메서드
	
	//배열 index를 통해 구성 데이터를 얻을 수 있는 메서드
	public Item getItem(int index) {
		return items[index];
	}
	
	//배열의 구성 데이터의 개수를 알 수 있는 메서드
	public int getCount() {
		return items.length;
	}

	@Override
	public Iterator iterator() {
		return new ArrayIterator(this);
	}
}
