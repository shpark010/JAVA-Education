import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

/*
IO(input / output)

Stream(통로) : 데이터가 오고 가는 통로
데이터 종류 : 이미지, 파일, 문자

JAVA API를 통해 클래스를 제공 받는다
I/O 기본 단위는 Byte

추상 클래스
InPutStream, OutPutStream (추상함수이므로 재정의 필요)

====================================================

당신이 Byte 데이터 작업한다면
입력 InputStream 상속 구현하는 클래스를 사용해라

대상이
1. Memory : ByteArrayInPutStream -> 거의 사용되지 않음
2. File : FileInPutStream -> 자주 사용!!!!

---------------------------------------------------

당신이 Byte 데이터 작업한다면
출력 OutputStream 상속 구현하는 클래스를 사용해라

대상이
1. Memory : ByteArrayOutPutStream -> 거의 사용되지 않음
2. File : FileOutPutStream -> 자주 사용!!!!

사실 지금까지 memory, Array, Collection 통해서 메모리 기반 작업을 해왔다.

====================================================

*/
public class Ex01_Stream {

	public static void main(String[] args) {
		
		//byte (-128 ~ 127) 정수를 저장하는 타입
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
		byte[] outSrc = null;	//현재 메모리를 가지고 있지 않는다.
		
		//통로(빨대) >> memory >> 데이터를 read, write
		ByteArrayInputStream input = null;	//빨대(통로) 입력
		ByteArrayOutputStream output = null;	//빨대(통로) 출력
		
		input = new ByteArrayInputStream(inSrc);	//input 대상 : inSrc >> read
		output = new ByteArrayOutputStream();	//write
		
		System.out.println("outSrc  before : " + Arrays.toString(outSrc));
		
		//공식같은 로직(암기)
		int data = 0;
		//read는 추상함수로 정수값을 읽는다. 읽을 주소가 없으면 -1을 리턴
		while((data = input.read()) != -1) {	
			//System.out.println("data : " + data);		
			
			//read한 데이터를 다른 Stream을 사용해서 출력
			output.write(data);	//출력통로 안에 (빨대) 안의 데이터를 담고 있는 것
			//write 하는 대상이 data가 아니고 ByteArrayOutputStream 자신의 통로에....
		}
		/*
		while(input.read() != -1) {
			//read() 함수 자체가 내부적으로 next()를 포함하고 있기 때문에 읽고 넘긴다. 
			System.out.println("data : " + input.read());	//1,3,5,7,9
		}
		*/
		
		outSrc = output.toByteArray();	//자신이 가진 정수 데이터를 Byte[]로 바꿔서 넘겨준다.
		//주소를 outSrc에 전달
		
		System.out.println("outSrc  after : " + Arrays.toString(outSrc));
		
	}

}
