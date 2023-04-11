package Iterator;

public class ArrayIterator implements Iterator{
	//필드
	private Array array;	//Array클래스의 객체를 필드로 선언
	private int index;	//배열에서 현재 반환할 수 있는 데이터 항목에 대한 index값을 위한 필드
	
	//생성자
	public ArrayIterator(Array array) {
		this.array = array;
		this.index = -1;
	}

	@Override
	public boolean next() {
		//index값 1증가
		index++;
		//증가된 index값이 배열의 index값으로 유효한지의 여부를 반환
		return index < array.getCount();
	}

	@Override
	public Object current() {
		//현재 index값에 해당하는 구성 데이터 객체를 반환
		return array.getItem(index);
	}
}
