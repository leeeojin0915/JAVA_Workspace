package bank;


/*고객의 계좌를 정의 : 업무가 신중해져야함 예민한 데이터를 많이 다룬다.*/
//패키지에 넣은 클래스를 public으로 공개하지 않으면 다른 어떠한 클래스도 이 클래스를 사용할 수 없다. 보안이 아니라 의미 없는 짓
//클래스는 쓰라고 만드는 것이기 때문에 public으로 공개하되 그 안의 내용들에 대해 보안처리하면 된다.
public class Account{

	public String bank="신한은행";//은행명
	protected String customer; //고객이름
	String num="022-388-85465"; //계좌번호
	private int balance=100000; //금액

	//private으로 선언되는 변수는 절대 아무도 외부에서 접근할 수 없으므로
	//변수에 접근하려면  메서드를 이용해야한다
	public void setBalance(int balance){
		this.balance=balance;
	}
	//잔고확인메서드 정의
	//private으로 선언된 변수의 값을 리턴하는 메서드를 가리켜 getter
	//위와 같이 setBalance처럼 private 변수의 값을 변경하는 메서드를 가리켜 setter
	public int getBalance(){
		return balance;
	}
	

}
