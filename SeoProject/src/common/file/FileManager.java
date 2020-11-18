package common.file;

public class FileManager {
	
	// 1.파일명 규칙-파일명가장 마지막 슬래스의 다음 문자열부터 마지막 문자열까지
	// 2.파일명에서.(점)을 기준으로 문자열을 분리시키면 배열이 생성되고 두번째 요소가 확장
	
	//파일명 구하기:매개변수로 파일의 경로를 넘겨받아 파일명만 추출
	public static String getFilename(String path) {
		int lastIndex=path.lastIndexOf("/");//마지막에 위치한 /의 인덱스 구하기
		return path.substring(lastIndex+1, path.length());
	}
	//확장자 구하기:매개변수로 파일명을 넘겨받아 확장자를 추출한다.
	public static String getExtend(String filename) {
		String[] str=filename.split("\\.");//점을 기준으로 문자열 분리..분리 후에는 배열이 반환됨,\\->익스케이핑
		return str[1];//두번째 칸이 확장자
	}
	//확장자 구하기 업데이트:마지막 점을 기준으로 가져와야 문제가 없다.
	public static String getExtends2(String filename) {
		//마지막 점의 위치 구하기 lastIndexOf사용
		int lastIndex=filename.lastIndexOf(".");
		
		//마지막 점 다음 문자부터 가져와야 하므로 +1을 더한다.
		return filename.substring(lastIndex+1, filename.length());
	}
	
	/*
	public static void main(String[] args) {
		String filename=getFilename("https://images-na.ssl-images-amazon.com/images/I/91qvAndeVYL._RI_.jpg");
		System.out.println(filename);
		
		String ext=getExtend(filename);
		System.out.println(ext);
	}
	*/
	
}
