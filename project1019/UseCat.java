class   UseCat{
	public static void main(String[] args){
		Cat c=new Cat();
		System.out.println("����� ���� �Ϸ�");

		System.out.println("����� �̸�:"+c.name);
		System.out.println("����� ����:"+c.age);
		System.out.println("����� ��ȥ����:"+c.married);
		System.out.println("����� �̸�:"+c.name);
		c.Walk();
		c.Cry();
	}

}
