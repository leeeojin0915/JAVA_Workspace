package test;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/* javaFX어플리케이션을 정의하기 위해서는 반드시 Application 추상클래스를 상속받아야 한다. */
public class AppMain extends Application {
	/* FX Application 생명주기 메서드가 지원됨 */
	
	public AppMain() {
		System.out.println("AppMain() 메서드 호출"+Thread.currentThread().getName());
	}
	//어플리케이션이 실행 할 준비가 되면 호출되는 메서드
	public void start(Stage stage) throws Exception {
		System.out.println("start() 메서드 호출"+Thread.currentThread().getName());
		//매개변수로 받은 stage 변수에는 어플리케이션의 윈도우이다
		
		//무대를 정의한다(fx에서는 윈도우에 반드시 하나의 scene이 존재해야함)
		VBox parent=new VBox();//수직으로 컴포넌트를 배치하는 레이아웃 객체
											//FlowLayout과 비슷
		
		Scene s=new Scene(parent);//Parent란? 부모클래스를 의미하는 것이 아니라 객체 간 포함관계에서 바깥 쪽 컨테이너를 의미
											//Swing과 비유하자면, 레이아웃 객체가 Parent이다
		Button bt=new Button("나 버튼");
		bt.setPrefSize(200, 40);
		
		//버튼을 parent에 부착
		parent.getChildren().add(bt);
		
		//신을 윈도우에 부착
		stage.setScene(s);
		bt.setOnAction((e)->{
			System.out.println("클릭");
		});
		stage.setMaxWidth(500);
		stage.setMaxHeight(500);
		stage.show();//윈도우 보이게

	}
	/*어플리케이션 시작 전,초기화를 담당하는 메서드이다. 따라서 초기화할 게 없다면 
	 * 재정의는 필수 아님
	 * 생성자 : 인스턴스가 태어날 때 호출되는 메서드(먼저 호출)
	 * vs
	 * init() : 태어난 이후에, 초기화 작업에 사용되는 메서드
	 *  */
	public void init() throws Exception {
		//자바의 쓰레드의 메서드 중 현재 실행중인 쓰레드 정보를 얻기 위한 메서드
		
		
		
		System.out.println("init() 메서드 호출"+Thread.currentThread().getName());
	}
	public void stop() throws Exception {
		System.out.println("stop() 메서드 호출"+Thread.currentThread().getName());
	}

	public static void main(String[] args) {
		System.out.println("launch() 메서드 호출"+Thread.currentThread().getName());
		launch(args);//실행 명령어
	}

}
