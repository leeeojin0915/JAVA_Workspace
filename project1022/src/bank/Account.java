package bank;


/*���� ���¸� ���� : ������ ������������ ������ �����͸� ���� �ٷ��.*/
//��Ű���� ���� Ŭ������ public���� �������� ������ �ٸ� ��� Ŭ������ �� Ŭ������ ����� �� ����. ������ �ƴ϶� �ǹ� ���� ��
//Ŭ������ ����� ����� ���̱� ������ public���� �����ϵ� �� ���� ����鿡 ���� ����ó���ϸ� �ȴ�.
public class Account{

	public String bank="��������";//�����
	protected String customer; //���̸�
	String num="022-388-85465"; //���¹�ȣ
	private int balance=100000; //�ݾ�

	//private���� ����Ǵ� ������ ���� �ƹ��� �ܺο��� ������ �� �����Ƿ�
	//������ �����Ϸ���  �޼��带 �̿��ؾ��Ѵ�
	public void setBalance(int balance){
		this.balance=balance;
	}
	//�ܰ�Ȯ�θ޼��� ����
	//private���� ����� ������ ���� �����ϴ� �޼��带 ������ getter
	//���� ���� setBalanceó�� private ������ ���� �����ϴ� �޼��带 ������ setter
	public int getBalance(){
		return balance;
	}
	

}
