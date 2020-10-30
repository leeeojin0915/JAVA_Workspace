/*현실의 자동차, 택시, 버스, 트럭을 자바 언어로 반영하되 재사용성을 고려해서 설계해 보세요*/
package car;
public class Car{
	String brand; //제조사
	
	//부모클래스 생성자 정의
	/*
	public Car(){
		System.out.println("자식의 super호출에 의해 난 호출 됩니다.");
	}*/
	//개발자가 매개변수 있는 생성자만 정의함. 개발자가 생성자를 정의하면 컴파일러에 의한 디폴트 생성자
	//자동 삽입은 없음 따라서, Car클래스는 생성자가 오직 1개만 있게된다.
	public Car(String brand){ //매개변수 있는 생성자라서 new Car("벤츠")식으로 호출해야한다.
		this.brand=brand;
	}
	public Car(){
	}
	public void move(){
		System.out.println("차가 움직입니다");
	}

}

