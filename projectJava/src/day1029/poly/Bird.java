/*
 * 다형성에 대해 다시 한 번 공부해보자
 * 
 * */
package day1029.poly;

public class Bird {
	String name="난 새";
	String local="한국";
	
	public void fly() {
		System.out.println("난다요");
	}
	public static void main(String[] args) {
		//새들을 대상으로 다형성 공부하기
		Bird b1=new Bird();
		//Bird b2=new Duck();
		Bird b3=new Sparrow();//유연해진다.
		
		
		//b3.fly(); 새의 행동이 다양하네
		
		Bird b2=new Duck();//b2는 Bird클래스 변수ㅡ 메서드 접근
									//다형성의 특징으로서는 자식메서드를
		Duck d=new Duck(); //부모꺼내꺼
		System.out.println(d.name);
		
	}
}
