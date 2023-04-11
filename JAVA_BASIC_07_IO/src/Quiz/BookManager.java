package Quiz;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
//도서 관리자 클래스
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class BookManager {
	Scanner scan = new Scanner(System.in);
	HashMap<String, Book> book_dic = new HashMap<String, Book>();
	String filename = "Book.txt";
	FileOutputStream fos = null;
	BufferedOutputStream bos = null;
	ObjectOutputStream oos = null;
	FileInputStream fis = null;
	BufferedInputStream bis = null;
	ObjectInputStream ois = null;
	
	public void Run() {
		int key = 0;
		while ((key = selectMenu()) != 0) {
			switch (key) {
			case 1:
				addBook();
				break;
			case 2:
				removeBook();
				break;
			case 3:
				searchBook();
				break;
			case 4:
				listBook();
				break;
			case 5:
				listISBN();
				break;
			default:
				System.out.println("잘못 선택하였습니다.");
				break;
			}
		}
		System.out.println("종료합니다...");
	}
	
	int selectMenu() {
		System.out.println("1:추가 2:삭제 3:검색 4:도서 목록 5:ISBN 목록0:종료");
		int key = scan.nextInt();
		scan.nextLine();
		return key;
	}

	void addBook() {
		String isbn;
		System.out.print("추가할 도서 ISBN:");
		isbn = scan.nextLine();
		if (book_dic.containsKey(isbn)) {
			System.out.println("이미 존재하는 ISBN입니다.");
			return;
		}
		String title; 
		int price;
		System.out.print("도서 제목:");
		title = scan.nextLine();
		System.out.print("가격:");
		price = Integer.parseInt(scan.nextLine());
		//입력 받은 정보를 통한 Book 객체 생성
		Book book = new Book(isbn, title, price);
		book_dic.put(isbn, book);
		System.out.println(book.toString() + " 생성하였습니다.");
		
		File file = new File(filename);
		try {
			fos = new FileOutputStream(file);
			bos = new BufferedOutputStream(fos);
			oos = new ObjectOutputStream(bos);
			
			oos.writeObject(book_dic);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
				bos.close();
				fos.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	void removeBook() {
		String isbn;
		System.out.print("삭제할 도서 ISBN:");
		isbn = scan.nextLine();
		if (book_dic.containsKey(isbn)) {
			book_dic.remove(isbn);
			System.out.println("삭제하였습니다.");
		}
		else {
			System.out.println("존재하지 않습니다.");
		}
		
		
	}

	void searchBook() {
		String isbn;
		System.out.print("검색할 도서 ISBN:");
		isbn = scan.nextLine();
		
		File file = new File(filename);
		try {
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			ois = new ObjectInputStream(bis);
			
			book_dic = (HashMap)ois.readObject();
			
			Set<String> set = book_dic.keySet();
			if(book_dic.containsKey(isbn)) {
				System.out.println("검색 결과>>" + book_dic.get(isbn).toString());
			}else {
				System.out.println("존재하지 않습니다.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();
				bis.close();
				fis.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	void listBook() {
		System.out.println("도서 목록");
		
		File file = new File(filename);
		try {
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			ois = new ObjectInputStream(bis);
			
			book_dic = (HashMap)ois.readObject();
			
			Set<String> set = book_dic.keySet();
			System.out.println("도서 수 : " + book_dic.size());
			for (Object obj : set) {
				System.out.println(book_dic.get(obj).toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();
				bis.close();
				fis.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	void listISBN() {
		System.out.println("ISBN 목록");
		int cnt = book_dic.size();
		System.out.println("도서 수:" + cnt);
		for (String isbn : book_dic.keySet()) {
			System.out.println(isbn);
		}
	}
}