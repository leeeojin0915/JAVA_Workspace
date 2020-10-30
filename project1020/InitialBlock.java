/*초기화블럭
Why?
*/
class InitialBlock{
	int sum=0;

	//인스턴스가 생성될때, 반복문을 돌려서, 총합을 넣어주고 싶을때
	//클래스에는 변수, 메서드만 정의할 수 있다.
	/*getSum(){
		for(){}
	}*/
	//멤버영역안에 {지역화}시켰을때 갖는 의미는?
	{
		for(int i=1;i<=10;i++){
			sum+=i;
		}
		//이 클래스의 인스턴스가 생성될 때마다 이 영역을 호출하게 된다.
		//인스턴스 초기화 블럭
		System.out.println("인스턴스 초기화 블럭 호츨"+sum);
	}
	//static초기화 블럭
	//main() 메서드에 의해 실행 직전에 실행되는 초기화 블럭
	static{
		System.out.println("실행전 초기화 블럭 실행");
		System.out.println("A");
	}
	public static void main(String[] args){
		System.out.println("B");
		int a=3;
		 //그냥 블럭화 시켜놓은 것이다. 혹여나 이 안에 변수를 선언하면
		 //해당 블럭내에서만 유효하다
		/*
		{
			int b=5;
		}
		System.out.println(b); 컴파일오류
		*/
		new InitialBlock();
		new InitialBlock();
		new InitialBlock();
	}
}