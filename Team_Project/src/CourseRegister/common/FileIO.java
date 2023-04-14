package CourseRegister.common;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class FileIO {
    private FileInputStream fis;
    private FileOutputStream fos;
    private BufferedInputStream bis;
    private BufferedOutputStream bos;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private FileReader fr;
    private BufferedReader br;
    private FileWriter fw;
    private BufferedWriter bw;
    private String filename;
    
    // 생성자
    public FileIO(String filename) {
    	this.filename = filename;
    }
    
    //텍스트 파일 데이터 읽기
    public String readFile() {
    	String str = "";
    	try {
    		File file = new File(filename);
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String line = "";
			while ((line = br.readLine()) != null) {
				str += line;
	         }
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return str;
    }
    
    //텍스트 파일 데이터 쓰기
    public void writeFile() {
    	try {
			fw = new FileWriter(filename);
			bw = new BufferedWriter(fw);
			
			//bw.write();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    //역직렬화 데이터 읽기
    public Object readObject() {
    	Object obj = null;
    	try {
    		File file = new File(filename);
    		if (!file.exists()) {
    			file.createNewFile();
    	    }
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			ois = new ObjectInputStream(bis);
			obj = ois.readObject();
		}catch (EOFException e) {
			System.out.println("저장된 정보가 없어 " + filename + " 파일을 생성합니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
	            if (ois != null) {
	                ois.close();
	            }
	            if (bis != null) {
	                bis.close();
	            }
	            if (fis != null) {
	                fis.close();
	            }
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
    	return obj;
    }
    
    //직렬화 데이터 쓰기
    public void writeObject(Object obj) {
    	try {
			fos = new FileOutputStream(filename, false);
			bos = new BufferedOutputStream(fos);
			oos = new ObjectOutputStream(bos);
			
			oos.writeObject(obj);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
				bos.close();
				fos.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
    }
}
