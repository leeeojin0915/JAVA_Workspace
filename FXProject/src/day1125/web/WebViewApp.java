
/*awt/Swing에서는 부분적으로나마 html이 적용 될 수 있으나
 * javascript는 실행 될 수 없다.
 * */
package day1125.web;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class WebViewApp extends Application {
	WebView webView;

	public void start(Stage stage) throws Exception {
		webView=new WebView();
		webView.getEngine().load("https://www.youtube.com/watch?v=eb5UD5S7inw");
		webView.setPrefSize(500, 500);
		showWindow(stage, webView);
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
