/*
awt/swing/fx --> �ȵ���̵�
*/
package gui;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Panel;

class GridTest{
	public static void main(String[] args){
		Frame frame=new Frame("�׸��� ���̾ƿ�");

		//���̾ƿ� �Ŵ��� ���� �� ���
		//GridLayout layout=new GridLayout(2,3);

		//�÷ο��ġ������ ������Ʈ�� �ڽ��� ����ũ�⸦ ���� �� �ִ�.
		//FlowLayout layout=new FlowLayout();

		//�׸��带 �����ϸ鼭, ������Ʈ�� ������ ũ�⸦ �����ϴ� ���
		//�� ���� ������������ �������� ����
		//�ذ�å) ������Ʈ �� ��ġ������ ������ ������ �г��� �̿��ϸ� �ȴ�.
		//��, �κ������� �ٸ� ��ġ�����ڸ� �����Ҷ� ���� ����
		GridLayout layout=new GridLayout(1,3);
		frame.setLayout(layout);//�����ӿ� ���̾ƿ� ����
		
		Panel p=new Panel();//���� ������ ����

		Button bt1=new Button("��ư1");
		Button bt2=new Button("��ư2");
		Button bt3=new Button("��ư3");

		//�гο� ��ư �ֱ�
		p.add(bt1);
		//�����ӿ� �гγֱ�
		frame.add(p);
		frame.add(bt2);
		frame.add(bt3);

		/*for(int i=0;i<6;i++){

			frame.add(new Button("��ư"+i));
		}*/
		frame.setSize(300,200);
		frame.setVisible(true);
	}

}
