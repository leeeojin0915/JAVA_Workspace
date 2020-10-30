package gui;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextField;

class MultiButton extends Frame{
	Button bt1;
	Button bt2;
	TextField t;
	public MultiButton(){
		bt1=new Button("버튼1");
		bt2=new Button("버튼2");
		t=new TextField(20);

		setLayout(new FlowLayout());
		add(bt1);
		add(bt2);
		add(t);

		//버튼과 리스너연결
		MyActionListener litener=new MyActionListener(bt1,bt2,t);
		bt1.addActionListener(litener);
		bt2.addActionListener(litener);
		t.addActionListener(litener);

		setSize(300,400);
		setVisible(true);
	}
	public static void main(String[] args){
		new MultiButton();
	}
}
