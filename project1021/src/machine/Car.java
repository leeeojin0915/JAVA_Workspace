class Car{
	String color="red";
	int  price=500;
	String name="Benz";
	Wheel wheel;// 이코드가 낯설지 않은 이유?
	//클래스 안에는 자료형을 둘 수 있는데 자바의 자료형은 총 4개이다
	//따라서 이 클래스 안에는 문자, 숫자, 논리값 이외에도 객체형도 올 수 있다
	//객체자료형도 자료형이니까

	//클래스 명과 동일한 이름의 메서드를 가리켜 생성자라 하고
	//생성자는 이름에서도 알 수 있듯, 객체의 생성타임에 무언가 초기화 작업이 있을때 작업을 수행하는 용도의 메서드
	public Car(){
		this.wheel=new Wheel();
	}
	public static void main(String[] args){
		Car c=new Car();
		//자동차 이름출력
		System.out.println(c.name);
		//자동차 바퀴의 브랜드 색상,가격을 출력
		System.out.println(c.wheel.brand);

	}

}
