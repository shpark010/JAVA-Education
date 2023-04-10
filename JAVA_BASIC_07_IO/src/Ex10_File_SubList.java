import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Ex10_File_SubList {
	
	static int totalfiles = 0;
	static int totaldirs = 0;
	
	static void printFileList(File dir) {
		 System.out.println("Full Path : " + dir.getAbsolutePath());
		 
		 List<Integer> subdir = new ArrayList<>();
		 
		 File[] files = dir.listFiles();	//하위 자원 정보
		 for (int i = 0 ; i < files.length ; i++) {
			String filename = files[i].getName();	//폴더명 or 파일명
			if(files[i].isDirectory()) {
				filename = "[ DIR ] " + filename;
				//POINT
				subdir.add(i);	//폴더인 경우 intdex 관리 >> ArrayList를 통해
				//subdir[0] = 1
			}else {
				filename = filename + " / " + files[i].length() + "byte";
			}
		}
		 
		 //폴더 개수
		 //파일 개수
		 int dirnum = subdir.size();	//현재 주어진 폴더의 하위 폴더 개수
		 int filenum = files.length-dirnum;	//현재 주어진 폴더의 파일 개수
		 
		 //누적개수 (하위 폴더 자원)
		 totaldirs += dirnum;
		 totalfiles += filenum;
		 
		 System.out.println("[Current DirNum] : " + dirnum);
		 System.out.println("[Current FileNum] : " + filenum);
		 System.out.println("==================================");
		/*
		POINT (하위 폴더에 다시 하위 폴더 ...)
		[0] > a.txt
		[1] > aaa 폴더 > a-1 폴더, a-2 폴더	
		[2] > bbb 폴더 > b-1 폴더, b.txt, b-1.jpg
		[3] > java.jpg
		*/
		for (int i = 0 ; i < subdir.size() ; i++) {
			int index = subdir.get(i);
			printFileList(files[index]);	//재귀호출....
		}
	}

	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("사용법 : java [실행할 파일명] [경로명]");
			System.out.println("예시 : java Ex10_File_SubList C:\\Duzon\\Temp");
			System.exit(0);
		}
		
		File f = new File(args[0]);
		if(!f.exists() || !f.isDirectory()) {
			System.out.println("유효하지 않은 디렉토리입니다.");
			System.exit(0);
		}
		
		////////////////////////////////////////////////////////////////////////////
		//정상적인 경로 그리고 폴더가 있구나....
		printFileList(f);
		System.out.println("누적 총 파일수 : " + totalfiles);
		System.out.println("누적 총 폴더수 : " + totaldirs);
		
	}

}
