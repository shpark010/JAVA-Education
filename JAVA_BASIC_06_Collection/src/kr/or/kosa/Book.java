package kr.or.kosa;

public class Book {
	private String bookNum;
	private String bookName;
	private int bookPrice;
	
	public String getBookNum() {
		return bookNum;
	}
	public String getBookName() {
		return bookName;
	}
	public int getBookPrice() {
		return bookPrice;
	}
	
	public Book(String bookNum, String bookName, int bookPrice) {
		super();
		this.bookNum = bookNum;
		this.bookName = bookName;
		this.bookPrice = bookPrice;
	}
	
}
