package animal;
public class Duck extends Bird{
	//Duck is a Bird
	//Duck���� Bird���̴�.
	//������ ����
	String name="�� ����";
	public void quack(){
		System.out.println("�в�");
	}
	public static void main(String[] args){
		Duck d1=new Duck();
		Duck d2=new Duck();

		Bird b=new Bird();
	}
}
