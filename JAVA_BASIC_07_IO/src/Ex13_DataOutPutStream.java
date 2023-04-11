import java.io.DataOutputStream;
import java.io.FileOutputStream;

/*
보조 Stream
DataOutputStream
DataInputStream

징잠
JAVA가 지원하는 8가지 기본타입별로 write, read 가능
단 조건은 읽고 쓰는건 DataOutPutStream / DataInPutStream 서로 호환 가능

============================================================
성적.txt	>> 규칙을 정의해야 한다.
100, 99, 60, 50
50, 55, 30, 100
읽는법 : Line 단위 read -> split -> 타입변환 -> Array -> read 연산
============================================================
*/
public class Ex13_DataOutPutStream {

	public static void main(String[] args) {
		int[] score = {100,60,55,95,50};
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		
		try {
			fos = new FileOutputStream("score.txt");
			dos = new DataOutputStream(fos);
			for (int i = 0; i < score.length; i++) {
				dos.writeInt(score[i]);	//정수값 그대로 write
				//조건 : Byte write 파일은 반드시
				//DataInputStream 통해서만 read 가능
				//채팅시...
				//dos.writeUTF(null);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				dos.close();
				fos.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
