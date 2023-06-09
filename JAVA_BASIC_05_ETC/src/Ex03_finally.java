import java.io.IOException;

/*
try {

} catch(Exception e) {

} finally {
	강제적으로 실행되는 블럭
}
finally 구현했다면
예외가 발생하던, 예외가 발생하지 않던 [강제적으로 실행]되어야 하는 구문

게임 CD 설치 PC
1. 설치파일 >> C:\Temp 폴더 >> 복사
2. 복사한 파일 >> 프로그램 설치
3. 정상 설치 >> C:\Temp 복사한 파일 내용 삭제
4. 비정상 설치 >> 강제 종료 >> C:\Temp 복사한 파일 내용 삭제 

 */
public class Ex03_finally {

	static void copyFiles() {
		System.out.println("copy Files");
	}
	
	static void startInstall() {
		System.out.println("Install ...");
	}
	
	static void fileDelete() {
		System.out.println("file Delete");
	}
	
	/*
	예외가 발생 ... 정말 0/0 , index 범위
	"홍길동"이 입력되면 예외 -> 개발자가 필요에 의해서 어떤 상활을 예외적인 상황이라고 정의할 수 있다.
	>>사용자 정의 예외 처리<<
	throw new IOException
	
	*/
	public static void main(String[] args) {
		/*
		copyFiles();
		startInstall();
		fileDelete();			
		*/
		try {
			copyFiles();
			startInstall();
			throw new IOException("Install 도중 문제 발생....");
		} catch (Exception e) {
			System.out.println("예외 발생 : " + e.getMessage());
		}finally {
			//강제 실행 블럭
			//정상, 비정상 상관없이 무조건 실행되는 블럭
			//** 함수가 가지는 return을 만나도 finally는 강제로 먼저 실행되고 함수가 종료된다. **
			fileDelete();			
		}
		
	}

}
