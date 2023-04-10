import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Team_Project {

	public static void main(String[] args) {
		if (args.length != 3 && args.length != 4) {
			System.out.println("사용법 : java [java파일명] [디렉토리경로] mkdir [생성디렉토리명]");
			System.out.println("사용법 : java [java파일명] [디렉토리경로] move [파일명] [옮길디렉토리명]");
			System.out.println("사용법 : java [java파일명] [디렉토리경로] rename [바꿀파일명] [새로운파일명]");
			System.out.println("사용법 : java [java파일명] [디렉토리경로] delete [파일명]");
			System.exit(0);
		}
		File f = new File(args[0]);
		if (!f.exists() || !f.isDirectory()) { // 존재하지 않거나 디렉토리 아니라면
			System.out.println("유효하지 않은 디렉토리입니다");
			System.exit(0);
		}
		if (args[1].equals("mkdir")) {
			String path = "";
			path = f + "\\" + args[2];
			File newfile = new File(path);
			if (newfile.exists()) {
				System.out.println("이미 존재하는 디렉토리입니다");
			} else {
				newfile.mkdir();
			}
		}else if(args[1].equals("move")) {
			String originPath = f + "\\" + args[2];
			String movePath = args[3] + "\\" + args[2];
			File originfile = new File(originPath);
			File movefile = new File(movePath);
			if(movefile.exists()) {
				System.out.println("해당 파일명운 이미 사용중입니다.");
			}else {
				try {
					
					FileInputStream input = new FileInputStream(originfile);
					FileOutputStream output = new FileOutputStream(movefile);
					int data = 0;
					while((data = input.read()) != -1) {
						output.write(data);
					}
					output.close();
					input.close();
					System.out.println(args[2] + "파일을 " + args[3] + "로 옮겼습니다.");
				} catch (IOException e) {
					e.printStackTrace();
				}
				originfile.delete();
			}
		}else if(args[1].equals("rename")) {
			String originPath = f + "\\" + args[2];
			String renamePath = f + "\\" + args[3];
			File originfile = new File(originPath);
			File renamefile = new File(renamePath);
			if(renamefile.exists()) {
				System.out.println("해당 파일명운 이미 사용중입니다.");
			}else {
				try {
					FileInputStream input = new FileInputStream(originfile);
					FileOutputStream output = new FileOutputStream(renamefile);
					int data = 0;
					while((data = input.read()) != -1) {
						output.write(data);
					}
					output.close();
					input.close();
					System.out.println(args[2] + "파일명을 " + args[3] + "로 바꿨습니다.");
				} catch (IOException e) {
					e.printStackTrace();
				}
				originfile.delete();
			}
		}else if(args[1].equals("delete")) {
			String path = "";
			path = f + "\\" + args[2];
			File deleteFile = new File(path);
			if (deleteFile.exists()) {
				System.out.println("파일을 삭제 합니다.");
				deleteFile.delete();
			} else {
				System.out.println("파일을 찾지 못했습니다.");
			}
		}else if(args[1].equals("exit")) {
			System.out.println("종료합니다.");
			System.exit(0);
		}
		
	}

}
