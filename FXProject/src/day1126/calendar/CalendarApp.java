package day1126.calendar;

import java.util.Calendar;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class CalendarApp extends Application {
	ChoiceBox ch_yy;// 연도
	ChoiceBox ch_mm;// 월
	Button bt;
	TilePane tilePane;
	int startDayOfWeek;// 해당 월의 시작요일
	int lastDate;// 각 월의 마지막 날
	Box[] box=new Box[7*6];

	public void start(Stage stage) throws Exception {
		BorderPane borderPane = (BorderPane) FXMLLoader
				.load(this.getClass().getClassLoader().getResource("day1126/calendar/layout.fxml"));

		// 루트 하위에 등록된 객체 찾아나서기
		// document.getelemnetById("ch_yy");
		ch_yy = (ChoiceBox) borderPane.lookup("#ch_yy");
		ch_mm = (ChoiceBox) borderPane.lookup("#ch_mm");
		tilePane = (TilePane) borderPane.lookup("#tilePane");
		bt = (Button) borderPane.lookup("#bt");

		initDate();// 초이스박스 초기화
		createTitle();// 요일구성하기
		createDateBox();

		getStartDayOfWeek();
		getLastDate();
		bt.setOnAction((e)->{
			getStartDayOfWeek();
			getLastDate();			
			printData();
		});
		// 49개의 셀을 생성하여,보더페인의 센터에 부착
//		for(int i=0;i<7*6;i++) {
//			Box box=new Box(Integer.toString(i),100, 100);
//			tilePane.getChildren().add(box);
//		}

		showWindow(stage, borderPane);
	}

	public void createTitle() {
		for (int i = 0; i < Days.values().length; i++) {
			//Box box = new Box(Days.values()[i].toString(), 100, 100);
			Box box=new Box(Days.values()[i].toString(), 100, 100);;
			tilePane.getChildren().add(box);
		}
	}

	// 행:6, 열:7
	public void createDateBox() {
		for (int i = 0; i < 7 * 6; i++) {
			box[i] = new Box(Integer.toString(i), 100, 100);
			tilePane.getChildren().add(box[i]);
		}
	}

	public void initDate() {
		for (int i = 2020; i >= 1990; i--) {
			ch_yy.getItems().add(i);
		}
		// ch_yy.getSelectionModel().select(n);//n번째요소가 선택되어있게
		ch_yy.getSelectionModel().selectFirst();// 무조건첫번째

		for (int i = 1; i <= 12; i++) {
			ch_mm.getItems().add(i);
		}
		ch_mm.getSelectionModel().selectFirst();

	}

	// 해당 월의 시작 요일 구하기(그래야 해당 요일부터 1일씩 출력을 시작한다)
	// 주의!요일은 1부터 시작,월은 0부터시작
	public void getStartDayOfWeek() {
		// 날짜 객체만들기(왜?조작해야한다)
		Calendar cal = Calendar.getInstance();
//		System.out.println(cal);

		// 이 날짜를 왜곡시키자 내가 원하는 날짜로
		int yy = (Integer) ch_yy.getValue();
		int mm = (Integer) ch_mm.getValue();
		cal.set(yy, mm - 1, 1);// 조작을 가함
		startDayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		System.out.println("조작된 월의 현재요일은:" + cal.get(Calendar.DAY_OF_WEEK));// 조작된 상태의 날짜 객체에 현재 요일을 물어보자

	}

	// 해당 월이 몇 일까지 있는지
	public void getLastDate() {
		Calendar cal = Calendar.getInstance();

		int yy = (Integer) ch_yy.getValue();
		int mm = (Integer) ch_mm.getValue();

		// 주의)해당월을 0일 즉 날짜만 조작해도 월이 자동으로 변환된다.
		cal.set(yy, mm, 0);
		// 조작된 상태이므로 현재 객체가 몇일에 와 있는지 조사
		lastDate = cal.get(Calendar.DATE);
		System.out.println(lastDate);
	}
	//생성된 박스들을 대상으로 내부의 텍스트 출력
	public void printData() {
		//모든박스를 다시초기화
		for(int i=0;i<box.length;i++) {
			box[i].erase();
		}
		//주의)출력하기 전에 유저가 선택한 년 월을 이용하여 startDayOfWeek, lastDate를 다시 구해야함
		//따라서 아래의 메서드를 다시 호출
		getStartDayOfWeek();
		getLastDate();
		//각 월에 알맞는 데이터 출력
		//반복문에서 i의 역할은 날짜 출력이 아니라 단지 반복문의 횟수를 결정하기 위한
		int n=1;//1일부터 증가하며 출력될 날짜 출력용 변수
		for(int i=(startDayOfWeek-1);i<(lastDate+(startDayOfWeek-1));i++) {
			box[i].renderText(Integer.toString(n));
			n++;
		}
	}
	public void showWindow(Stage stage, Parent parent) {
		Scene s = new Scene(parent);
		stage.setScene(s);
		stage.setWidth(720);
		stage.setHeight(780);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
