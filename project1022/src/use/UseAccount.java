package use;
//����Ϸ��� Ŭ������ ��ġ
import bank.Account;//bank������ ��δ� �̹� classpath�� ��ϵǾ��ִ�.
class UseAccount{
	public static void main(String[] args){
		Account acc=new Account();//���� Ŭ���� ����

		//bank������� public�̹Ƿ� ������ ���� ����
		//System.out.println(acc.bank);

		//customer�� protected�� ����Ǿ� �����Ƿ� ��Ӱ��迡 �ְų� ���� ��Ű����쿡�� ���ٰ���
		//���� UseAccount�� Account�� ��Ӱ��谡 ���� ���� �ٸ� ��Ű���̹Ƿ� ������ ���ٺҰ���
		//System.out.println(acc.customer);

		//���¹�ȣ num������ �����ڰ��ƹ��͵� ������� ���� ==>default����������
		//default��� ��� X default ���� �����ڴ� ���� ��Ű���� �ִ� Ŭ���������� ��������
		//��, ��Ӱ��迡 �־ ������Ű���� �ƴ϶�� ���� �Ұ�
		//System.out.println(acc.num);

		//�����ܾ� balance
		//balance�� ���� ������ ������������ private�� ����Ǿ� �����Ƿ� AccountŬ���� �����θ� ���� ����
		//�츮�� Account�ڽ��� �ƴ϶� ���XXX
		//System.out.println(acc.balance);
		//acc.balance=10;//�̹ݹ��� ���� �������� �Ұ���
		acc.setBalance(10); //�̹���� ������������ �޼��带 ���� ���̹Ƿ� ���ٰ���
		//�ܰ�Ȯ��
		System.out.println(acc.getBalance());

	}

}
