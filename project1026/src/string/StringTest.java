package string;
class StringTest{
	public static void main(String[] args){
		/*
		String은 클래스다
		하지만 우리 인간은 스트링을 너무 압도적으로 많이 사용하기 때문에
		new 연산자에 의해 스트링을 생성하는 것은 불편
		따라서 String 한해서는 마치 일반 데이터타입처럼 new 쓰지 않는 표현식을 지원해준다
		이러한 String의 생성방법을 암시적,묵시적(implicit)생성법
		묵시적 생성법에 의한 String은 상수풀에 의해 관리
		*/
		String s1="apple";
		String s2="apple";
		System.out.println(s1==s2);

		//String은 시작문자인 'S'가 대문자로보아 분명 객체형임
		//우리의 개발환경에서 String.class가 어딘가에 있어야 하는데 보이지XX
		//java se의 모든 api가 모여있는 압축된 파일
		//C:\Program Files\Java\jdk1.8.0_261\jre\lib\rt.jar

		//아래와 같이 new 연산자에 의한 스트링 생성법을 명시적(explicit)생성법
		//명시적 생성법은 상수풀에 생성되지 않으므로 new할때마다 중복 여부를 따지지 않고
		//무조건 생성된다.
		String s3=new String("korea");
		String s4=new String("korea");
		System.out.println(s3==s4);

		//주소비교가 아닌, 객체 동일성 비교하는 법
		String k1="orange";
		String k2="orange";
		System.out.println(k1==k2);//주소비교
		System.out.println(k1.equals(k2));//내용비교

	}
}
