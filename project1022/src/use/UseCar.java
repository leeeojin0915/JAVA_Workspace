package use;
import car.Taxi;
import car.Bus;
import car.Truck;
//import car.*; //*�� ����� �� �� �ִ� �� ��Ű������ �ƴ϶� Ŭ������
					//���������� �� �Ⱦ� =>import���� �ٷ�����ϴ� ����� ���� ���� �ؼ��� �ȵ�
class UseCar{
	public static void main(String[] args){
		Taxi t=new Taxi();//�ý��� �ν��Ͻ� ����
								//�θ��� Car�� �����ؾ� �ýõ� �����ϱ� ������ js���� �ߴ� ���� �״�� ����Ǿ�  Car�ν��Ͻ��� ����
		t.pass();
		t.move();
	}

}
