class Shoes{
	String color;//String은 객체이므로 컴파일러에 의해 null
	int price;//정수는 컴파일러에 의해 최소한의 관여 수인 0으로 초기화
	//아래의 두 메서드로 속성을 변경하는 것과
	//생성자에 의해 초기화하는 것에 차이점??
	public Shoes(String color, int price){
		this.color=color;
		this.price=price;
	}
	public void setColor(String color){ //색상변경
		this.color=color;
	}
	public void setPrice(int price){ //가격변경
		this.price=price;
	}

	public static void main(String[] args){
		Shoes s=new Shoes("Red",2000);
		//s.setColor("Red");
		//s.setPrice(200000);

		//System.out.println("신발의 색상은"+s.color+", 가격은"+s.price);
		System.out.println(s.color+","+s.price);
	}
}
