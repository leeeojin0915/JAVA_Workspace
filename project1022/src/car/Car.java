/*������ �ڵ���, �ý�, ����, Ʈ���� �ڹ� ���� �ݿ��ϵ� ���뼺�� ����ؼ� ������ ������*/
package car;
public class Car{
	String brand; //������
	
	//�θ�Ŭ���� ������ ����
	/*
	public Car(){
		System.out.println("�ڽ��� superȣ�⿡ ���� �� ȣ�� �˴ϴ�.");
	}*/
	//�����ڰ� �Ű����� �ִ� �����ڸ� ������. �����ڰ� �����ڸ� �����ϸ� �����Ϸ��� ���� ����Ʈ ������
	//�ڵ� ������ ���� ����, CarŬ������ �����ڰ� ���� 1���� �ְԵȴ�.
	public Car(String brand){ //�Ű����� �ִ� �����ڶ� new Car("����")������ ȣ���ؾ��Ѵ�.
		this.brand=brand;
	}
	public Car(){
	}
	public void move(){
		System.out.println("���� �����Դϴ�");
	}

}

