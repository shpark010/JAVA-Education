import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Ex03_Stream_ImageCopy {

	public static void main(String[] args) {
		String oriFile = "C:\\Duzon\\Temp\\1.jpg";
		String targetFile = "copy.jpg";
		//default 경로 : 프로젝트 경로 (C:\Duzon\JAVA\Labs\JAVA_BASIC_07_IO)
		//어떠한 경로도 지정하지 않으면 프로젝트 경로가 기본적으로 설정이 된다.ㄴ
		
		FileInputStream fs = null;
		FileOutputStream fos = null;
		
		try {
			fs = new FileInputStream(oriFile);
			fos = new FileOutputStream(targetFile);
			
			int data = 0;
			while((data = fs.read()) != -1) {
				fos.write(data);	//byte값
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fs.close();
				fos.close();
			} catch (Exception e2) {
				
			}
		}
		
	}

}
