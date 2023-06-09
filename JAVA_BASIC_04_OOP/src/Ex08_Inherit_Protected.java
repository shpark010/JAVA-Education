import kr.or.kosa.Pclass;

/*
private
default	(같은 폴더)
public
상속관계에서 protected

protected 양면성 -> 1.default의 성질 2.public의 성질 -> 어디에 만들어지느냐에 따라 달라진다.
-> [상속]이 없는 클래스 안에서 protected = default 
-> [상속]이 있는 클래스 안에서 protected = public
=> 결국 상속관계에서만 의미있다.
*/

class Dclass {
	public int i;
	private int p;
	int s;
	protected int k;	//default와 동일 (상속이 아니면 사용하지 않는다)
}

class Child2 extends Pclass {
	void method() {
		this.k = 100;	//상속관계에서 자식은 부모의 protected 자원을 사용가능 (public )
		System.out.println(this.k);
		//m(); 자식 안에서 접근 가능
	}
	
	//protected의 진정한 의미 (함수) : 재정의해! 그래야 니가 쓰는거야!(약간의 강제성)
	@Override
	protected void m() {
		// TODO Auto-generated method stub
		super.m();
	}
	
}

public class Ex08_Inherit_Protected {
	public static void main(String[] args) {
		Pclass pclass = new Pclass();
		//pclass.i; 유일하게 public 접근
		
		Child2 child2 = new Child2();
		child2.m();
	}

}
