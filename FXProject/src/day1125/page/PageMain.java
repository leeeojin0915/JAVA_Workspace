/*FX에서의 페이지 전환, 화면전환*/
package day1125.page;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PageMain extends Application {
	String[] navi = { "MAIN", "SHOPPING", "MEMBER", "LOGIN" };

	Pane[] page = new Pane[navi.length];// 배열문화 시켜야 반복문 처리가능
	Button[] btn = new Button[navi.length];
	ToolBar bar;// navi를 포함하는 메뉴바
	BorderPane border;

	public void start(Stage stage) throws Exception {
		border = new BorderPane();
		// xml로 디자인된 파일ㅇ르 자바객체로 변환하기(안드로이드에서는 이 과정을 inflation이라 함)
		// 반환되는 컨테이너가 무엇인지 예측할 수 없으므로 보다 상위 자료형으로 받자
		for (int i = 0; i < page.length; i++) {
			page[i] = (Pane) FXMLLoader.load(
					this.getClass().getClassLoader().getResource("day1125/page/" + navi[i].toLowerCase() + ".fxml"));
		}

		// 네비게이션 만들기
		for (int i = 0; i < btn.length; i++) {
			btn[i] = new Button(navi[i]);
			btn[i].setId(Integer.toString(i));// 버튼에 정보심기
			// 버튼에 액션이벤트 연결
			btn[i].setOnAction((e) -> {
				Button bt = (Button) e.getSource();// 이벤트를 일으킨 컴포넌트를 구해옴

				showPage(page[Integer.parseInt(bt.getId())]);
			});
		}

		bar = new ToolBar(btn[Pages.MAIN.ordinal()], btn[Pages.SHOPPING.ordinal()], btn[Pages.MEMBER.ordinal()],
				btn[Pages.LOGIN.ordinal()]);// 툴바생성
		bar.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));
		border.setTop(bar);// 생성된 바를 top영역에 부착

		showPage(page[Pages.MEMBER.ordinal()]);

		showWindow(stage, border);
	}

	// 페이지 전환 메서드 정의 :swing에서 우리가 정의한 showPage()역할 메서드 정의
	public void showPage(Pane p) {
		// 스윙에서는 미리 부착한 컴포넌트(주로 패널)을 보이거나 안보이게 하면 되지만
		// fx는 물리적으로 부착하고 제거하는 처리로 제어함
		// 기존에 border에 븉여진 컴포넌트가 존재한다면 모두 제거
		border.getChildren().removeAll(border.getChildren());// 싹 지워짐

		border.setTop(bar);// bar다시부착
		border.setCenter(p);// xml에서 로드한 컨테이너 setVisible(true),false와 다름
	}

	public void showWindow(Stage stage, Parent parent) {
		Scene s = new Scene(parent);// 씬 생성
		stage.setScene(s);// 생성된 씬을 윈도우에 적용
		stage.setWidth(800);// 너비
		stage.setHeight(700);// 높이
		stage.show();// 윈도우 보여주기
	}

	public static void main(String[] args) {
		launch(args);
	}

}
