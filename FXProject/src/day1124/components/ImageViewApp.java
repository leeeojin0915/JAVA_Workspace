package day1124.components;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ImageViewApp extends Application {
	String url;
	ImageView image;
	public void start(Stage stage) throws Exception {
		//1)String의 url생성
		url="https://img.hankyung.com/photo/201904/01.19439017.1.jpg";
		image=new ImageView(url);
		
		
		//2)Image객체이용
		//url="https://img.hankyung.com/photo/201904/01.19439017.1.jpg";
		//ImageView image=new ImageView(url);
		
		image.setPreserveRatio(true);//비율유지
		image.setFitWidth(400);
		image.setFitHeight(300);
		
		
		FlowPane parent=new FlowPane(image);
		
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
