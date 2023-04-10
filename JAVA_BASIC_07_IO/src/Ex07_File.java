import java.io.File;

/*
파일, 폴더(디렉토리) 다루는 클래스 학습
C# : 파일(File), 폴더(Directory)

JAVA : File (파일 생성&삭제 + 폴더 생성&삭제) -> 하나의 클래스로
>> a.txt 생성, 수정, 삭제, 정보 read
>> Temp 생성, 수정, 삭제, 정보 read

경로
절대경로 : C:\\, D:\\ >> C:\Duzon\Temp
상대경로 : 현재 파일을 중심으로 >> ../ >> /

*/
public class Ex07_File {

	public static void main(String[] args) {
		String path = "C:\\Duzon\\Temp\\file.txt";
		
		File f = new File(path);
		
		//File 클래스는 다양한 정보 취득
		System.out.println("파일 존재 여부 (파일,폴더) : " + f.exists());
		System.out.println("너 폴더니 : " + f.isDirectory());
		System.out.println("너 파일이니 : " + f.isFile());
		
		System.out.println("파일명 : " + f.getName());
		
		System.out.println("절대경로 : " + f.getAbsolutePath());
		
		System.out.println("파일크기 : " + f.length() + "byte");
		System.out.println("부모경로 : " + f.getParent());
		
		
	}

}
