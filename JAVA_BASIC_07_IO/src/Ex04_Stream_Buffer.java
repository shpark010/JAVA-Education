import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

/*
(File 처리 대상) >> DISK >> 입출력의 단위가 한 byte씩

여러명 학생을 한 명씩 목적지에 보내는 것이 아니고
여러명이 탈 수 있는 버스를 대여해서 한 번에 보내고 처리

버스 : Buffer
1. I/O 성능 개선 (접근 횟수)
2. Line 단위 (enter를 기반으로)

BufferedOutputStream : 보조 스트림으로 독자적인 작업이 불가하다. 
-> File (InPut, OutPut) Stream이 존재해야 한다.

*/
public class Ex04_Stream_Buffer {

	public static void main(String[] args) {
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		
		try {
			fos = new FileOutputStream("data.txt");	//파일 없으면 파일 생성
			bos = new BufferedOutputStream(fos);	//버퍼 탄생
			
			for (int i = 0 ; i < 10 ; i++) {
				bos.write('A');	//data.txt에...
			}
			//bos.flush();
			/*
			JAVA Buffer : 8kbyte -> 약 8192byte
			1. Buffer 안에 내용이 채워지면 스스로 출발 (버퍼를 비우는 작업)
			2. 강제로 출발 : Buffer를 강제로 비우는 방법 => flush()
			3. 개발 close() 자원해제 >> 내부적으로 flush()
			*/
		} catch (Exception e) {
			
		} finally {
			try {
				bos.close();
				fos.close();
			} catch (Exception e2) {
				
			}
		}
		
	}

}
