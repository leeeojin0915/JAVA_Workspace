/*�ʱ�ȭ��
Why?
*/
class InitialBlock{
	int sum=0;

	//�ν��Ͻ��� �����ɶ�, �ݺ����� ������, ������ �־��ְ� ������
	//Ŭ�������� ����, �޼��常 ������ �� �ִ�.
	/*getSum(){
		for(){}
	}*/
	//��������ȿ� {����ȭ}�������� ���� �ǹ̴�?
	{
		for(int i=1;i<=10;i++){
			sum+=i;
		}
		//�� Ŭ������ �ν��Ͻ��� ������ ������ �� ������ ȣ���ϰ� �ȴ�.
		//�ν��Ͻ� �ʱ�ȭ ��
		System.out.println("�ν��Ͻ� �ʱ�ȭ �� ȣ��"+sum);
	}
	//static�ʱ�ȭ ��
	//main() �޼��忡 ���� ���� ������ ����Ǵ� �ʱ�ȭ ��
	static{
		System.out.println("������ �ʱ�ȭ �� ����");
		System.out.println("A");
	}
	public static void main(String[] args){
		System.out.println("B");
		int a=3;
		 //�׳� ��ȭ ���ѳ��� ���̴�. Ȥ���� �� �ȿ� ������ �����ϸ�
		 //�ش� ���������� ��ȿ�ϴ�
		/*
		{
			int b=5;
		}
		System.out.println(b); �����Ͽ���
		*/
		new InitialBlock();
		new InitialBlock();
		new InitialBlock();
	}
}