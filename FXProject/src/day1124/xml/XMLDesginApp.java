package day1124.xml;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//awt및 swing은 순수한 자바 코드로만 화면 디자인을 구성해야 하므로 유지보수하기 어려움
//이러한 문젤르 해결하기 위해 디자인와 로지긍ㄹ 분리시켜 지ㅝㅇㄴ하는 방식
//fx 디자인은 자바뿐만 아니라xml로도 지원하고 있으며 사실 디자인은 앞으로 자바로하지 X
//특수경우빼교ㅗ
public class XMLDesginApp extends Application {
	public void start(Stage stage) throws Exception {
		// 현재 시점에는 디자인을 답ㅁ당하는 XML과의 연관성이 없으므로
		// xml을 읽어서 현재 자바 코드로 가져와야한다.
		// DOM vs SAX parsing(현실의 데이터를 xml로 표현했을때)dmf
		// FX에서 지원하는 xml해석 객체 이용 (자체지원)
		URL url = this.getClass().getClassLoader().getResource("day1124/xml/main.fxml");
		VBox parent=(VBox)FXMLLoader.load(url);
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
