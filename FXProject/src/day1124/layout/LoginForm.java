package day1124.layout;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class LoginForm extends Application{
	public void start(Stage stage) throws Exception {
		BorderPane parent=new BorderPane();
		FlowPane top=new FlowPane();
		
		TextField t=new TextField();
		Button bt=new Button("버튼");
		TextArea area=new TextArea();
		
		t.setPrefSize(400, 20);
		bt.setPrefSize(80, 20);

		top.getChildren().add(t);
		top.getChildren().add(bt);


		parent.setTop(top);
		parent.setCenter(area);
		
		showWindow(stage, parent);
		
	}
	public void showWindow(Stage stage, Parent parent) {
		Scene s = new Scene(parent);// 씬 생성
		stage.setScene(s);// 생성된 씬을 윈도우에 적용
		stage.setWidth(500);// 너비
		stage.setHeight(500);// 높이
		stage.show();// 윈도우 보여주기
	}
	public static void main(String[] args) {
		launch(args);
	}

}
