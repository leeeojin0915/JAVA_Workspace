package gui;
import java.awt.*;
class LoginForm2 extends Frame{
	/*has ����� ��������� ��ü���϶��� �ǹ�*/
	Label la_id;
	Label la_pass;
	TextField t_id;
	TextField t_pass;
	Button bt_login;
	Button bt_regist;
	Panel p_center; //���Ϳ� �׸��带 ������ �г�
	Panel p_south; //���ʿ� �÷ο� ���� �г�(���⿡ ��ư2�� ���� ����)

	public LoginForm2(){
		//��ǰ����� ������ �������� ��� �ʱ�ȭ ��Ű��
		//Ư�� ��ǰ��, �� ��ü�� �¾ �� ���� �Բ� �¾�� �ϹǷ�, �������� Ÿ�̹��� ��ġ�� ����.
		la_id=new Label("ID");
		la_pass=new Label("Password");
		t_id=new TextField(15);
		t_pass=new TextField(15);
		bt_login=new Button("Login");
		bt_regist=new Button("Regist");
		p_center=new Panel();
		p_south=new Panel();

		//������ �� ���°�, ���� ���̳� ��Ÿ���� �ο����� �ʾ���
		//Frame�� �����ڰ� ���̾ƿ��� �������� ������ ����Ʈ�� BorderLayout�̴�.
		//this.setLayout(new BorderLayout());//�� �ʿ���� -->����Ʈ�� �̹� �������̾ƿ��̹Ƿ�
		p_center.setBackground(new Color(183,220,255));
		//�����г��� �������� �������̾ƿ� ���Ϳ� ����
		this.add(p_center,BorderLayout.CENTER);//CENTER�� ����Ʈ�̱� ������ ��������
		
		//����� �������� �ο��� �������̴�. final�� �� �̻� ���� ������ �� ������, static���� �ν��Ͻ��� ������ �����ϰ�
		//public���� �����Ͽ� ��� ��ü�� ������ �� �ֵ��� ���������� Ǯ�� ���� ������
		p_south.setBackground(Color.YELLOW); //color�� �ΰ��� ����ϱ� ���� �����ͷ� �������
		//p_south.setBackground(new Color(255,183,183));
		this.add(p_south,BorderLayout.SOUTH);

		//p_center�� �׸��� ����
		p_center.setLayout(new GridLayout(2,2));//2��2��¥�� �׸��� ����
		p_center.add(la_id);//�󺧺���
		p_center.add(t_id);//id�ؽ�Ʈ�ڽ�
		p_center.add(la_pass);//��
		p_center.add(t_pass);
	
		//Panel�� �ƹ��� ��ġ�����ڸ� �������� ������ ����Ʈ�� FlowLayout�̴�.
		p_south.add(bt_login);
		p_south.add(bt_regist);

		/*this�� ��Ȯ�� �ǹ� : ���۷��� ����. ��, �� �ڽ��� �ν��Ͻ��� �ּҰ��� ����
								  �ش� �ν��Ͻ��� �ڱ� �ڽ��� ����ų��*/
		this.setSize(400,150);
		this.setVisible(true);
	}
	public static void main(String[] args){
		new LoginForm2();
	}	

}
