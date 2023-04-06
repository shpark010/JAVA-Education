package kr.or.kosa;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BookManager {
	private HashMap<String, Book> books;
	
	Scanner sc = new Scanner(System.in);
	
	public BookManager() {
		this.books = new HashMap<String,Book>();
	}
	
	
	//실행함수
	public void run() {
		boolean run = false;
		while(!run) {
			System.out.println("1:추가 2:삭제 3:검색 4:도서 목록 5:ISBN 목록 0:종료");
			int selectMenu = Integer.parseInt(sc.nextLine());
			switch(selectMenu) {
				case 0 :
					System.out.println("종료합니다...");
					run = !run;
					break;
				case 1 :
					//도서 추가
					addBook();
					break;
				case 2 :
					//도서 삭제
					removeBook();
					break;
				case 3 :
					//도서 검색
					searchBook();
					break;
				case 4 :
					//전체 도서 목록
					bookList();
					break;
				case 5 :
					//ISBN 목록
					listISBN();
					break;
					
			}
		}
	}
	
	//도서 추가
	public void addBook() {
		System.out.print("추가할 도서 ISBN:");
		String bookNum = sc.nextLine();
		if(!books.containsKey(bookNum)) {
			System.out.print("도서 제목:");
			String bookName = sc.nextLine();
			System.out.print("가격:");
			int bookPrice = Integer.parseInt(sc.nextLine());
			books.put(bookNum, new Book(bookNum, bookName, bookPrice));
			System.out.printf("ISBN:%s 이름:%s 가격:%d 생성하였습니다.\n",bookNum,bookName,bookPrice);
		}else {
			System.out.println("해당 도서 번호는 이미 있는 번호 입니다.");
		}
	}
	
	//도서 삭제
	public void removeBook() {
		System.out.print("삭제할 도서 ISBN:");
		String bookNum = sc.nextLine();
		if(books.containsKey(bookNum)) {
			books.remove(bookNum);
			System.out.println("삭제하였습니다.");
		}else {
			System.out.println("해당 도서 번호는 존재하지 않습니다.");
		}
	}
	//도서 검색
	public void searchBook() {
		System.out.print("검색할 도서 ISBN:");
		String bookNum = sc.nextLine();
		for (Map.Entry m : books.entrySet()) {
			if(books.containsKey(bookNum)) {
				System.out.println("검색결과>>ISBN:" + m.getKey() + " 이름:" + ((Book)m.getValue()).getBookName() + " 가격:" + ((Book)m.getValue()).getBookPrice());
			}else {
				System.out.println("해당 도서 번호는 존재하지 않습니다.");
			}			
		}
	}
	//도서 목록
	public void bookList() {
		for(Map.Entry m : books.entrySet()) {
			System.out.println("ISBN:" + m.getKey() + " 이름:" + ((Book)m.getValue()).getBookName() + " 가격:" + ((Book)m.getValue()).getBookPrice());
		}
	}
	//ISBN 목록
	public void listISBN() {
		System.out.println("도서수:" + books.size());
		for(Map.Entry m : books.entrySet()) {
			System.out.println(m.getKey());
		}
	}
}
