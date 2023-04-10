import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
Today Point

Byte 데이터를 read / write 대상이 File로

FileInPutStream
FileOutPutStream

주 사용처 : 이미지, 엑셀 파일을 read, write 할 때

File >> 1.txt , 1.data (write, read)

I/O 자원은 개발자가 직접적으로 자원에 대한 헤제 작업을 해줘야 한다.
(워드 파일 작업중에 같은 파일 연 경우 -> 현재 편집중에 있습니다. -> 기존 파일 닫기)
>>Close()
>> 예외처리 (강제된) : 사용하는 I/O 클래스는 강제로 예외처리를 요구하는 코드가 많다.

*/
public class Ex02_FileStream {

	public static void main(String[] args) {
		FileInputStream fs = null;
		FileOutputStream fos = null;
		
		String path = "C:\\Duzon\\Temp\\a.txt";
		
		try {
			
			fs = new FileInputStream(path);
			fos = new FileOutputStream("C:\\Duzon\\Temp\\new.txt",true);
			//현재 Temp 폴더 안에 new.txt. 파일이 없다.
			/*
			FileOutputStream
			1. write할 파일이 존재하지 않으면 자동으로 파일을 생성(create 기능을 내포)
			
			2. fos = new FileOutputStream("C:\\Duzon\\Temp\\new.txt", false);
			false -> Overwrite (기존에 파일이 있으면 덮어쓰기 한다.)
			true -> append (기존에 파일이 있으면 추가한다.)
			*/
			int data = 0;
			while((data = fs.read()) != -1) {
				//System.out.println("정수 : " + data + " : " + (char)data);
				fos.write(data);	//출력 스트림 C:\\Duzon\\Temp\\new.txt
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//정상, 비정상
			//함수가 강제로 return을 하더라도
			//finally 강제 실행
			//자원해제 : (I/O) 자원은 가비지 컬렉터가 관리하지 않는다.
			//close() 명시적으로 소멸자 호출
			try {
				fs.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}

}
