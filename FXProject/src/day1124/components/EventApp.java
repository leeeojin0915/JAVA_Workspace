package day1124.components;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class EventApp extends Application {
	Button bt;
	TextField t;
	ImageView imageView;
	public void start(Stage stage) throws Exception {
		bt=new Button("버튼");
		t=new TextField();
		imageView=new ImageView("https://img.hankyung.com/photo/201904/01.19439017.1.jpg");
		imageView.setPreserveRatio(true);
		imageView.setFitWidth(200);
		imageView.setFitHeight(200);
		
		//이벤트소스와 이벤트핸들러 연결
		//객체가 보유한 메서드가 달랑 1개 이므로 람다식 사용 가능
		bt.setOnAction((e)->{
			
		});
		/*t.setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent e) {
				if(e.getCode()==KeyCode.ENTER) {					
					System.out.println("dddf?");
				}
			}
		});*/
		t.setOnKeyReleased((e)->{
			if(e.getCode()==KeyCode.ENTER) {
				System.out.println("엔터");
			}
		});
		
		imageView.setOnMouseClicked((e)->{
			System.out.println("마우스");
		});
		
		FlowPane flow=new FlowPane(bt,t,imageView);//가변형 인자로 선언된 생성자 이므로
		//매개변수의 갯수를 실행 타임에 결정 지을 수 있 다.
		//test(1,1,1,1,1,2,2,2);
		showWindow(stage, flow);
		
		
		
	}
	public void test(int...x) {//갯수를 호출자가 결정
		System.out.println("매개변수의 수는"+x.length);
		for(int v:x) {
			System.out.println("값은"+v);
		}
	}
	public void showWindow(Stage stage, Parent parent) {
		Scene s = new Scene(parent);// 씬 생성
		stage.setScene(s);// 생성된 씬을 윈도우에 적용
		stage.setWidth(500);// 너비
		stage.setHeight(500);// 높이
		stage.show();// 윈도우 보여주기
	}


	public static void main(String[] args) {
		launch(args);//액션,키보드,마우스
	}

}
