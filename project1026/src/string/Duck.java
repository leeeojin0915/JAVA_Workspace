package string;

/*�ڹ��� ���~��ü�� ���� ���� �� ���� �ֻ��� ��ü�� �ΰ��ִ�.
Object ��ü.�����ڰ� ����� ������� �ʴ��� ����Ʈ�� �̹� ��ӵǾ� �ִ�.
*/
class Duck{
	String name="����";
	
	/*�Ʒ��� �޼���� ObjectŬ�����κ��� ��ӹ��� �޼����̸�
	�� �޼���� ��ü�� ��Ʈ������ ��ȯ�ϰ��� �� �� �����Ѵ�.
	�� �Ʒ��� �޼���� ��ü�� ����ϰ��� �� �� � �ڵ����� �����Ѵ�.

	�Ʒ��� �޼���� Object�� �޼���������, �׽�Ʈ�� �����ϴ� ������ �˱� ���� ���
	�������̵� �غ���
	*/
	public String toString(){
		System.out.println("toString()�޼��� ����");
		return "";
	}
	public static void main(String[] args){
		Duck d=new Duck();
		//System.out.println(d);//���� ��ü�� �ƴ϶�, ������ �ּҰ�
		System.out.println(new Duck());
	}
}
