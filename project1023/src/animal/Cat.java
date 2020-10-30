package animal;
public class Cat{
	String name;
	int age;
	public Cat(String name,int age){
		this.name=name;
		this.age=age;
	}
		
		/**고양이를 울게하는 메서드
	이 메서드를 호출하실때는 첫번째 인수
	*/
	public void cry(){
		System.out.println("고양이가 울어요");
	}

}
