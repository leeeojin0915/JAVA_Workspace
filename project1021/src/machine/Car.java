class Car{
	String color="red";
	int  price=500;
	String name="Benz";
	Wheel wheel;// ���ڵ尡 ������ ���� ����?
	//Ŭ���� �ȿ��� �ڷ����� �� �� �ִµ� �ڹ��� �ڷ����� �� 4���̴�
	//���� �� Ŭ���� �ȿ��� ����, ����, ���� �̿ܿ��� ��ü���� �� �� �ִ�
	//��ü�ڷ����� �ڷ����̴ϱ�

	//Ŭ���� ��� ������ �̸��� �޼��带 ������ �����ڶ� �ϰ�
	//�����ڴ� �̸������� �� �� �ֵ�, ��ü�� ����Ÿ�ӿ� ���� �ʱ�ȭ �۾��� ������ �۾��� �����ϴ� �뵵�� �޼���
	public Car(){
		this.wheel=new Wheel();
	}
	public static void main(String[] args){
		Car c=new Car();
		//�ڵ��� �̸����
		System.out.println(c.name);
		//�ڵ��� ������ �귣�� ����,������ ���
		System.out.println(c.wheel.brand);

	}

}
