/*
 * 달력에 사용되는 셀을 정의한다.
 * 
 * */
package day1126.calendar;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Box extends Canvas {
	String title;
	int width, height;
	GraphicsContext context;

	public Box(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
		this.setWidth(width);
		this.setHeight(height);
		// 모든컴포넌트는 그래픽처리에 사용되는 객체를 가지고 있다.
		context = this.getGraphicsContext2D();

		erase();
		renderText(title);
	}

	// 현재박스에 그려진 글씨 지우기
	public void erase() {
		// 채워진 사각형
		context.setFill(Color.SKYBLUE);// 페인트통 물감색을 노란색으로
		context.fillRect(0, 0, 100, 100);// 노란색 채워진 사각형

		// 구분라인
		context.setStroke(Color.PINK);
		context.strokeRect(0, 0, width, height);
	}
	
	//현재박스 글씨 그리기
	public void renderText(String title) {
		// 글씨 그리기
		this.title=title;
		context.setFill(Color.WHITE);
		context.setFont(new Font(17));
		context.fillText(title, 2, 20);
	}
}
