class UseCar{
	public static void main(String[] args){
		/*Car클래스를 선언하면셔 ,해해당 클래스가 보유한 변수인 멤버변수에
		아무런 값도 초기화 시키지 않았다면 어떤 결과가 나올까?
		이상적인 프로그래밍 언어에서는 변수에 값이 없는상태로 다른 데이터와의 연산을 
		수행하게 되면 에러 발생*/

		//지역 변수는 초기화 해야 연산이 가능하다(프로그램 기본 원칙)
		//자동차의 인스턴스를 한 개 생성한 후, 그 인스턴스 안의 멤버변수들이 갖는 값을 출력해보자
		 Car c=new Car();
		 System.out.println("자동차 색상:"+c.color);
		 System.out.println("자동차 가격:"+c.price);
		 System.out.println("자동차 자율주행모듈:"+c.autoDrive);
		 c.drive();
		 c.stop();
	}
}
