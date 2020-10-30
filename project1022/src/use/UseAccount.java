package use;
//사용하려는 클래스의 위치
import bank.Account;//bank이전의 경로는 이미 classpath에 등록되어있다.
class UseAccount{
	public static void main(String[] args){
		Account acc=new Account();//계좌 클래스 생성

		//bank은행명은 public이므로 무조건 접근 가능
		//System.out.println(acc.bank);

		//customer는 protected로 선언되어 있으므로 상속관계에 있거나 같은 패키지경우에만 접근가능
		//현재 UseAccount는 Account와 상속관계가 없고 서로 다른 패키지이므로 데이터 접근불가능
		//System.out.println(acc.customer);

		//계좌번호 num변수는 개발자가아무것도 명시하지 않은 ==>default접근제한자
		//default라고 명시 X default 접근 제한자는 같은 패키지에 있는 클래스끼리만 접근해줌
		//즉, 상속관계에 있어도 같은패키지가 아니라면 접근 불가
		//System.out.println(acc.num);

		//계좌잔액 balance
		//balance는 가장 강력한 접근제한자인 private이 적용되어 있으므로 Account클래스 스스로만 접근 가능
		//우리는 Account자신이 아니라 사용XXX
		//System.out.println(acc.balance);
		//acc.balance=10;//이반법은 직접 접근으로 불가능
		acc.setBalance(10); //이방법은 간접접근으로 메서드를 통한 것이므로 접근가능
		//잔고확인
		System.out.println(acc.getBalance());

	}

}
