package open_file;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Read_File {
	static  String fileName;
	
	public  Read_File(String str){
			fileName=str;	
	}
	public static String getFile(){
		BufferedReader br = null;
		StringBuffer sb = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"utf-8")); //这里可以控制编码
			sb = new StringBuffer();
			String line = null;
			int count=1;
			while((line = br.readLine()) != null) {
				sb.append(String.valueOf(count)+"  ");
				sb.append(line);
				sb.append("\r\n");
				count++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}
		String data = new String(sb); //StringBuffer ==> String
		return data;
	}
	
	public static String getFile2(String fileName) {
		BufferedReader br = null;
		StringBuffer sb = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"utf-8")); //这里可以控制编码
			sb = new StringBuffer();
			String line = null;
			int count=1;
			while((line = br.readLine()) != null) {
				sb.append(String.valueOf(count)+"  ");
				sb.append(line);
				sb.append("\r\n");
				count++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}
		String data = new String(sb); //StringBuffer ==> String
		return data;
	}
	
}