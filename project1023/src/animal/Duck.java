package animal;
public class Duck extends Bird{
	//Duck is a Bird
	//Duck형은 Bird형이다.
	//오리는 새다
	String name="난 오리";
	public void quack(){
		System.out.println("꽥꽥");
	}
	public static void main(String[] args){
		Duck d1=new Duck();
		Duck d2=new Duck();

		Bird b=new Bird();
	}
}
