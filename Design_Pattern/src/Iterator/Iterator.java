package Iterator;

public interface Iterator {
	//next() : Iterator인터페이스를 통해 Aggregator의 다음 구성 데이터를 얻을 수 있도록 한다.
	//다음 구성 데이터를 얻을 수 있다면 : [true]
	//다음 구성 데이터를 더이상 얻을 수 없다면 : [false]
	boolean next();
	//current() : 구성 데이터를 하나 얻어 반환하는 기능
	//구성 데이터에 대한 타입은 정해지지 않아 모든 객체 타입의 최상위 부모 객체 타입인 Object타입으로 설정 
	Object current();
}
