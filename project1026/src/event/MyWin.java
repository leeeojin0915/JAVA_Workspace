package event;
import java.awt.Frame;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.Choice;
				//MyWin is a Frame
class  MyWin extends Frame{
	Button bt;//MyWin has a by
	TextField t; 
	Choice ch;//html������ .select�ڽ��� ����

	public MyWin(){
		bt=new Button("��ư");
		t=new TextField(15);
		ch=new Choice();

		//ch�� ������ ä���
		ch.add("Java Programming");
		ch.add("JSP Programming");
		ch.add("Android Programming");
		ch.add("Spring FrameWork");
		ch.add("Mybatis FrameWork");

		this.setLayout(new FlowLayout());
		//��ư�� �����쿡 ����
		this.add(bt); //�������� �� ��Ʈ�� borderlayout�̹Ƿ� ���Ϳ����� ũ�� ��������
		this.add(t);
		this.add(ch);


		//��ư�� ������ ����
		bt.addActionListener(new MyListener());
		//�ؽ�Ʈ�ڽ��� ������ ����
		t.addKeyListener(new MyKey());
		this.addMouseListener(new MyMouse());//�����Ӱ� ������ ����
		ch.addItemListener(new MyItem());
		this.addWindowListener(new MyWindowListener());

		this.setSize(300,400);
		this.setVisible(true);
	}
	public static void main(String[] args){
		new MyWin();
	}
}
