package string;
class StringTest2{
	public static void main(String[] args){
		/*String은 불변(immutable)이다.*/
		String s1="korea";
		System.out.println(s1);
		s1=s1+" fighting";
		System.out.println(s1);

		/*
		String str=null;
		for(int i=1;i<=100;i++){
			str+="줄넘기 "+i+"회\n";
		}
		System.out.println(str);
		*/

		//해결책
		//수정가능한 문자열 처리객체
		//StringBuffer, StringBuilder
		StringBuilder sb=new StringBuilder();
		sb.append("");
		for(int i=1;i<=100;i++){
			sb.append("줄넘기 "+i+"회\n");
		}
		System.out.println(sb);
	}
}
