
package gui;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Button;
import java.awt.TextField;

public class MyActionListener implements ActionListener{
	Button bt1; //null
	Button bt2; //null
	TextField t; //null

	public MyActionListener(Button bt1,Button bt2,TextField t){
		this.bt1=bt1;
		this.bt2=bt2;
		this.t=t;
	}
	//�������̽��� �޼��� �������̵�(overriding)
	public void actionPerformed(ActionEvent e){
		Object obj=e.getSource();//�̺�Ʈ�� ����Ų ������Ʈ ��ȯ
		//��ư�� ���� �̺�Ʈ��� ��ư�� �ּҰ��� Object��(���� ��)���� �ްԵǰ�
		//TextField      ''       TextField     '' 
		if(obj==bt1){
			System.out.println("bt1�� �����׿�");
		}else if(obj==bt2){
			System.out.println("bt2�� �����׿�");
		}else if(obj==t){
			System.out.println("t���Է��߳׿�");
		}
	}
}