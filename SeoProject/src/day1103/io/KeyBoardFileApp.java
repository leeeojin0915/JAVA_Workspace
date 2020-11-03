package day1103.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;


public class KeyBoardFileApp {
	String dir;
	FileWriter writer;
	File file;
	URI uri;
	public KeyBoardFileApp() {
		URL url=this.getClass().getClassLoader().getResource("res/");
		//디렉토리+파일명
		try {
			URL url2=new URL(url,"empty.txt");
			uri=url2.toURI();
			System.out.println(uri);
			file=new File(uri);
			writer=new FileWriter(file);
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void saveFile() {
		//키보드로부터 입력받은 데이터를 파일로 저장해본다
		//키보드 스트림은 System으로 부터 얻어와야한다
		InputStream is=System.in;//바이트
		InputStreamReader reader=new InputStreamReader(is);//문자기반 스트림으로 업그레이드
		BufferedReader buffr=new BufferedReader(reader);//버퍼기반의 문자 스트림
		
		//파일출력스트림 계열은(empty)빈 파일을 생성
		//FileWriter writer=new FileWriter(file);                     
		
		String str=null;
		try {		
				str=buffr.readLine();
				System.out.println(str);
				writer.write(str);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(writer!=null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		new KeyBoardFileApp().saveFile();
	}

}
