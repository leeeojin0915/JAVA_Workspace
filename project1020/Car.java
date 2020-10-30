/*자동차를 정의(Car)
색상
가격
자동주행모듈 장착 여부
달린다
멈춘다
*/
class Car{
	/*아래의 변수는 클래스로부터 인스턴스가 생성될때 해당 인스턴스에 포함되어지는 인스턴스 변수로서 생명력은 해당 인스턴스가 소멸될때까지 함께한다.
	
	자동차의부품이므로 자동차와 생명을 같이한다
	이러한 멤버변수는 초디화 않으면 컴파일러가 최소한의 관여로 값을 자동초기화한다.
	*/
	String color="black";//null로 초기화됨
	int price=100000000;//정수는 최소한의 값인 0으로 초기화
	boolean autoDrive=true;//false로 초기화

	public void drive(){
		System.out.println("자동차가 달립니다.");
	}

	public void stop(){
		System.out.println("자동차가 멈춥니다.");
	}

}
