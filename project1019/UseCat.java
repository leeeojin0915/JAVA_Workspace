class   UseCat{
	public static void main(String[] args){
		Cat c=new Cat();
		System.out.println("고양이 생성 완료");

		System.out.println("고양이 이름:"+c.name);
		System.out.println("고양이 나이:"+c.age);
		System.out.println("고양이 결혼여부:"+c.married);
		System.out.println("고양이 이름:"+c.name);
		c.Walk();
		c.Cry();
	}

}
