/*�����쿡 �� �� �ִ� ���� ������Ʈ �˾ƺ���
ex)��ư,�ؽ�Ʈ�ʵ�,�����ڽ�,üũ�ڽ�,���̽�,�̹���,textarea...
*/
package gui;
import java.awt.Frame;//����Ϸ��� Ŭ������ ��ġ ���
								//��򰡿� .class�� �����ϱ� ������ ��밡�� �� ���̴�.
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.Checkbox;
import java.awt.TextArea;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.Image;

class App1{
	public static void main(String[] args){
		//������ ����

		/* ����ó�� ���� Ŭ������ �������� ��ó��
			��ó�ڼ�0)����Ϸ��� Ŭ������ ���� ��� �������� �����Ǵ� ������ �� �뵵�ľ�
			��ó�ڼ�1)�ڹ��� ��� ��ü�� �ᱹ 3���� �����ۿ� ����
			��ó�ڼ�2)Ŭ������ ����� ������̴�, ���� �޸𸮿� �ø��� ���� �˸�ȴ�.

			1)�Ϲ�Ŭ���� : new �ϸ� �ȴ�.new ���� ����������(api.������ ���ؼ�)
			2)�߻�Ŭ���� : new �Ұ��ϹǷ�, �ڽ��� �����ؼ� new�ϰų� �̹� ������
							�ν��Ͻ��� �̿�(api ���� ����_)
			3)�������̽� : new �Ұ��ϹǷ�, �ڽ��� �����ؼ� new�ϰų� �̹� ������
							�ν��Ͻ��� �̿�
		*/

		//ó�������� �Ϲ��̱� ������ new ������ ���� �����ڸ� �����ؼ� ���
		Frame frame=new Frame();//�ڹ� ���������α׷��ֿ����� ������
		//�������� ����Ʈ�� ���� ������ �ʴ� ����,���� ���̵��� �޼��� ȣ��
		frame.setVisible(true);//window ��ü�κ��� ��ӹ��� �޼���
		//�Ű������δ� ������ ����� �� �ִ�.
		//�������� �ʺ�,���̸� ������ �� �ִ� �޼��� ã��
		frame.setSize(300,400); //apiã�ƺ���
		 
		//�����찡 �����Ǿ����Ƿ� ������ �ȿ� ��ġ�� ���� ������Ʈ�� �÷����ƺ���
		//��ư button(�Ϲ�)
		Button bt=new Button("����ư");
		
		//��ư�� �����ϱ� ���� ���̾ƿ� ��Ÿ���� �����ؾ��ϴµ� ���̾ƿ��� ���� ����                                                                                      
		FlowLayout flow=new FlowLayout();
		frame.setLayout(flow);//�����쿡 �÷ο� ����� ��ġ����

		//��ư�� ������ �����̳ʿ� ����
		frame.add(bt); //add�޼����� �Ű������� component���̹Ƿ�
		//Button�� component�� �ڽ��̱� ������ ���� �ڷ����� �ش��Ͽ� add()�� �� �� �ֵ�.

		//html������ input type="text"�� �ڹٿ����� TextField���Ѵ�
		TextField t=new TextField("ȸ������",10);
		frame.add(t);

		//check
		Checkbox ch1=new Checkbox("����");
		Checkbox ch2=new Checkbox("����");
		Checkbox ch3=new Checkbox("��ǻ��");
		frame.add(ch1);
		frame.add(ch2);
		frame.add(ch3);
		//TextArea
		TextArea area=new TextArea(5,20); //5��20��
		frame.add(area);

		//�׳� �ؽ�Ʈ
		Label la=new Label("ȸ������ ���");
		frame.add(la);


		//�̹��� �ֱ�
		//image�� �߻�Ŭ�����̸� �÷����� ������ ������� �򤷸� �� �ֵ�
		Toolkit kit=Toolkit.getDefaultToolkit();//static�޼��� ���� Ŭ�������� ���ٰ���
		//��Ŷ�� �̹����� ���ƾ��� ��ηκ��� ��� �� �� �ֵ�.
		//��λ��� ������ �� : �������ô� ������ os������ ����ϴ�ǥ���̹Ƿ�
		//�߸� ���  �ʿ�
		Image img=kit.getImage("D:/koreaIT/Workspace/images/bts/4.jpg");
		System.out.println(img);
		//ȭ�鿡 ����ϴ� ������ ���� �Ұ� ��? ���ݱ��� html������ �̹�����
		//html������ ���ٿ��� ����������, �ڹٿ� ���� �Ϲ����� ������ ����� ���α׷��ֿ�����
		//������(�����׸����۾�)�� �ؾ���
	}

}
