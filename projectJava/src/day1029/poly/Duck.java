package day1029.poly;

public class Duck extends Bird{

	String color="white";
	
	//부모의 메서드를 재정의
	@Override
	public void fly() {
		System.out.println("오리가 난다요");
	}
	public void quack() {
		System.out.println("꽥꽥");
	}
}
