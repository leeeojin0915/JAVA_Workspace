class Shoes{
	String color;//String�� ��ü�̹Ƿ� �����Ϸ��� ���� null
	int price;//������ �����Ϸ��� ���� �ּ����� ���� ���� 0���� �ʱ�ȭ
	//�Ʒ��� �� �޼���� �Ӽ��� �����ϴ� �Ͱ�
	//�����ڿ� ���� �ʱ�ȭ�ϴ� �Ϳ� ������??
	public Shoes(String color, int price){
		this.color=color;
		this.price=price;
	}
	public void setColor(String color){ //���󺯰�
		this.color=color;
	}
	public void setPrice(int price){ //���ݺ���
		this.price=price;
	}

	public static void main(String[] args){
		Shoes s=new Shoes("Red",2000);
		//s.setColor("Red");
		//s.setPrice(200000);

		//System.out.println("�Ź��� ������"+s.color+", ������"+s.price);
		System.out.println(s.color+","+s.price);
	}
}
