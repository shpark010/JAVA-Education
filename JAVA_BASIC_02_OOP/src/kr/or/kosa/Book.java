package kr.or.kosa;
/*
책은 책이름과 가격정보를 가지고 있다
책이 출판되면 반드시 책이름과 책 가격정보를 가지고 있어여 한다
책의 이름과 가격정보는 특정 기능을 통해서만 볼 수 있고 , 출판된 이후에는 수정 할 수 없다 (책의 가격,이름)
책이름과 가격정보는 각각 확인 수 있다
*/
public class Book {
	//책 기본 정보
	private String bookname;	//책 이름
	private int bookprice;		//책 가격
	
	//책 이름 정보 불러오기
	public String getBookname() {
		return bookname;
	}
	
	//책 가격 정보 불러오기
	public int getBookprice() {
		return bookprice;
	}
	
	//책 출간 시 강제적으로 이름과 가격 정보 초기화
	public Book(String name, int price) {
		bookname = name;
		bookprice = price;
	}
	
	//출간한 책의 정보를 보는 메서드
	public void bookInfo() {
		System.out.println("[책이름] : " + bookname + "\t[가격] : " + bookprice);
	}
}
