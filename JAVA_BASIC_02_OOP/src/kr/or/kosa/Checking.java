package kr.or.kosa;

public class Checking {

	public static void main(String[] args) {
		Book book = new Book("break time", 15000);
		System.out.println(book.getBookname());
		System.out.println(book.getBookprice());
		book.bookInfo();
		
		AirPlane a = new AirPlane(707, "대한항공");
	}

}
