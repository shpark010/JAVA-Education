import java.util.ArrayList;
import java.util.List;

import kr.or.kosa.CopyEmp;
import kr.or.kosa.Emp;

class Product {
	int price;
	int bonuspoint;
	
	Product(int price) {
		this.price = price;
		this.bonuspoint = (int)(this.price/10.0);
	}
}

class KtTv extends Product {
	KtTv() {
		super(500);
	}

	@Override
	public String toString() {
		return "KtTv";
	}
	
}

class Audio extends Product {
	Audio() {
		super(100);
	}
	
	@Override
	public String toString() {
		return "Audio";
	}
	
}

class NoteBook extends Product {
	NoteBook() {
		super(150);
	}
	
	@Override
	public String toString() {
		return "NoteBook";
	}
	
}
public class Ex07_Generic_Product {

	public static void main(String[] args) {
		//1. Array 사용해서 객체 생성
		// KtTv, Audio, NoteBook을 담을 수 있는 Cart 만드세요
		Product[] cart = new Product[3];
		cart[0] = new KtTv();
		cart[1] = new Audio();
		cart[2] = new NoteBook();
		//단점 : 배열의 크기가 고정되어 있다. (물건이 늘어나면 cart 배열을 새로 생성해야 한다)
		
		//2. ArrayList를 사용해서 Cart를 만드세요
		List<Product> pcart = new ArrayList<Product>();
		pcart.add(new KtTv());
		pcart.add(new KtTv());
		pcart.add(new KtTv());
		pcart.add(new KtTv());
		pcart.add(new Audio());
		pcart.add(new NoteBook());
		//동적으로 추가, 삭제가 가능
		for (Product product : pcart) {
			System.out.println(product);
		}
		
		System.out.println();
		
		//Emp
		//3.ArrayList를 사용해서 사원 3명 만들기
		List<Emp> emplist = new ArrayList<Emp>();
		emplist.add(new Emp(100, "김철수", "무직"));
		emplist.add(new Emp(200, "홍길동", "도적"));
		emplist.add(new Emp(300, "이영희", "주부"));
		
		//3.1 사원의 정보를 toString() 사용하지 말고 개선된 for문으로 사번, 이름, 직종을 출력하세요
		for (Emp emp : emplist) {
			System.out.printf("사원번호 : [%d] 이름 : [%s] 직종 : [%s]\n",emp.getEmpno(), emp.getEname(), emp.getJob());
		}
		
		System.out.println();
		
		//3.2 3.1과 동일한데 일반 for문을 사용해서 사원의 정보를 toString() 사용하지 말고 사번, 이름, 직종을 출력하세요
		for (int i = 0; i < emplist.size() ; i++) {
			System.out.printf("사원번호 : [%d] 이름 : [%s] 직종 : [%s]\n",emplist.get(i).getEmpno(), emplist.get(i).getEname(), emplist.get(i).getJob());
		}
		
		System.out.println();
		
		//4. ArrayList를 사용해서 사원 3명을 만드세요 (CopyEmp)
		//CopyEmp(100, "김씨", 1000);
		//CopyEmp(200, "이씨", 2000);
		//CopyEmp(300, "박씨", 3000);
		List<CopyEmp> clist = new ArrayList<CopyEmp>();
		clist.add(new CopyEmp(100, "김씨", 1000));
		clist.add(new CopyEmp(200, "이씨", 2000));
		clist.add(new CopyEmp(300, "박씨", 3000));
		
		//4.1 200번 사원의 급여를 6000으로 수정하세요 (일반 for문을 통해서) getter, setter 활용
		for (int i = 0 ; i < clist.size() ; i++) {
			if(clist.get(i).getEmpno()==200) {
				clist.get(i).setSal(6000);
				System.out.println(clist.get(i).toString());
			}
		}
		
		System.out.println();
		
		//4.2 300번 사원의 이름을 박씨에서 "궁금해씨"로 수정해서 그 결과를 출력하세요 (개선된 for문)
		for (CopyEmp cemp : clist) {
			if(cemp.getEmpno() == 300) {
				cemp.setEname("궁금해씨");
				System.out.println(cemp);
			}
		}
	}

}
