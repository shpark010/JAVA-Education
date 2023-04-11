import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;

/*
출력 형식을 지정해주는 보조 Stream
1. printf
2. string.format
3. I/O PrintWriter : 파일에 출력을 정의할 때(이쁘게, 줄맞춰서)

현업) 세금계산서, 지출결의서 출력, 휴가서, 품의서 >> 만들어 주는 SW >> 레포팅 >> 오즈, 크리스탈 레포트

*/
public class Ex11_PrintWriter {

	public static void main(String[] args) {
		try {
			//PrintWriter 파일이 없으면 자동으로 생성
			//Write
			/*
			PrintWriter pw = new PrintWriter("C:\\Duzon\\Temp\\homework.txt");
			pw.println("***************************************************");
			pw.println("**                    HOMEWORK                   **");
			pw.printf("%3s : %5d %5d %5d %5.1f", "아무개", 100, 88, 90, (float)((100+88+90)/3));
			pw.println();
			pw.close();
			*/
			
			//Read (Line단위) 문자
			FileReader fr = new FileReader("C:\\Duzon\\Temp\\homework.txt");
			BufferedReader br = new BufferedReader(fr);
			String s = "";
			while((s = br.readLine()) != null) {
				System.out.println(s);
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
