/*윈도우에 들어갈 수 있는 여러 컴포넌트 알아보기
ex)버튼,텍스트필드,라디오박스,체크박스,초이스,이미지,textarea...
*/
package gui;
import java.awt.Frame;//사용하려는 클래스의 위치 등록
								//어딘가에 .class로 존재하기 때문에 사용가능 할 것이다.
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.Checkbox;
import java.awt.TextArea;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.Image;

class App1{
	public static void main(String[] args){
		//윈도우 생성

		/* 난생처음 보는 클래스를 만났을때 대처법
			대처자세0)사용하려는 클래스가 대충 어던 목적으로 지원되는 것인지 그 용도파악
			대처자세1)자바의 모든 객체는 결국 3가지 유형밖에 없다
			대처자세2)클래스는 쓰라고 만든것이다, 따라서 메모리에 올리는 법을 알면된다.

			1)일반클래스 : new 하면 된다.new 뒤의 생성자조사(api.문서를 통해서)
			2)추상클래스 : new 불가하므로, 자식을 정의해서 new하거나 이미 구현한
							인스턴스를 이용(api 문서 통해_)
			3)인터페이스 : new 불가하므로, 자식을 정의해서 new하거나 이미 구현한
							인스턴스를 이용
		*/

		//처음보지만 일반이기 때문에 new 다음에 오는 생성자를 조사해서 사용
		Frame frame=new Frame();//자바 윈도우프로그래밍에서의 윈도우
		//프레임은 디폴트가 눈에 보이지 않는 상태,따라서 보이도록 메서드 호출
		frame.setVisible(true);//window 객체로부터 상속받은 메서드
		//매개변수로는 논리값을 사용할 수 있다.
		//윈도우의 너비,높이를 지정할 수 있는 메서드 찾기
		frame.setSize(300,400); //api찾아보기
		 
		//윈도우가 생성되었으므로 윈도우 안에 배치할 각종 컴포넌트를 올려놓아보자
		//버튼 button(일반)
		Button bt=new Button("나버튼");
		
		//버튼을 부착하기 전에 레이아웃 스타일을 지정해야하는데 레이아웃은 추후 배울것                                                                                      
		FlowLayout flow=new FlowLayout();
		frame.setLayout(flow);//윈도우에 플로우 방식의 배치적용

		//버튼을 윈도우 컨테이너에 부착
		frame.add(bt); //add메서드의 매개변수는 component형이므로
		//Button도 component의 자식이기 때문에 같은 자료형에 해당하여 add()를 쓸 수 있따.

		//html에서의 input type="text"는 자바에서는 TextField라한다
		TextField t=new TextField("회원정보",10);
		frame.add(t);

		//check
		Checkbox ch1=new Checkbox("독서");
		Checkbox ch2=new Checkbox("수영");
		Checkbox ch3=new Checkbox("컴퓨터");
		frame.add(ch1);
		frame.add(ch2);
		frame.add(ch3);
		//TextArea
		TextArea area=new TextArea(5,20); //5행20열
		frame.add(area);

		//그냥 텍스트
		Label la=new Label("회원가입 양식");
		frame.add(la);


		//이미지 넣기
		//image는 추상클래스이며 플랫폼이 지정한 방식으로 얻ㅇ르 수 있따
		Toolkit kit=Toolkit.getDefaultToolkit();//static메서드 따라서 클래스명을 접근가능
		//툴킷은 이미지를 로컷아의 경로로부터 얻어 올 수 있따.
		//경로사용시 주의할 점 : 역슬래시는 윈도우 os에서만 사용하는표기이므로
		//중립 경로  필요
		Image img=kit.getImage("D:/koreaIT/Workspace/images/bts/4.jpg");
		System.out.println(img);
		//화면에 출력하는 수업은 오늘 불가 왜? 지금까지 html에서는 이미지를
		//html문서에 덧붙여서 구현했으나, 자바와 같은 일반적인 컴파일 기반의 프로그래밍에서는
		//렌더링(직접그리는작업)을 해야함
	}

}
