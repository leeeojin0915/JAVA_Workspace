package use;
import car.Taxi;
import car.Bus;
import car.Truck;
//import car.*; //*의 대상이 될 수 있는 건 패키지명이 아니라 클래스명
					//현업에서는 잘 안씀 =>import에서 다루고자하는 기술이 뭔지 빨리 해서이 안됨
class UseCar{
	public static void main(String[] args){
		Taxi t=new Taxi();//택시의 인스턴스 생성
								//부모인 Car가 존재해야 택시도 존재하기 때문에 js에서 했던 원리 그대로 적용되어  Car인스턴스도 생성
		t.pass();
		t.move();
	}

}
