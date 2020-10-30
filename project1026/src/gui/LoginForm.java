
package gui;
import java.awt.Frame;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.Button;

class LoginForm extends Frame{
	public static void main(String[] args){
		Frame frame=new Frame();
		BorderLayout border=new BorderLayout();
		GridLayout grid=new GridLayout(2,1);
		Label la1=new Label("ID");
		Label la2=new Label("PASSWORD");
		Panel p1=new Panel();
		Panel p2=new Panel();
		Panel p3=new Panel();
		Panel p4=new Panel();
		TextField t1=new TextField("아이디입력");
		TextField t2=new TextField("비밀번호입력");
		Button bt1=new Button("로그인");
		Button bt2=new Button("회원가입");


		p1.add(la1);
		p2.add(la2);
		frame.add(p1);
		frame.add(t1);
		frame.add(p2);
		frame.add(t2);
		frame.setLayout(grid);

		p3.add(bt1);
		p4.add(bt2);
		frame.add(p3);
		frame.add(p4);

		frame.setSize(300,200);
		frame.setVisible(true);

	}
}
