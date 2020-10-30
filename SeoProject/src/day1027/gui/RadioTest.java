/*
	1) �۾� ũ�� ���� ctrl + (-,+Ű)
	2) window > Preferences > General > Appearance > Colors and Fonts > Basic > Text Font ���� 
		Verdana ü ����
	3) ����Ű ��� ���� ctrl + shift + L
	4) �ڵ� ����Ʈ :	ctrl + shift + O
	5) �ڵ� �ڵ� ���� : ctrl + shift + F
	6) �ش� ��ü�� api���� �ٷΰ���  : �ش� Ŭ���� Ŀ�� �ø� �� shift + F2(���Ű) ���ͳ� ������ ������..
	7) ���  sout �̶�� ����ܾ� �Է°� ���ÿ�  ctrl+space 
	8) ������ �� Alt + ��,�Ʒ� (�ڵ�� �̵��ϱ� move) 
	9) ������ �� ctrl + alt + ����Ű �Ʒ�
*/
package day1027.gui;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.FlowLayout;
import java.awt.Frame;

public class RadioTest extends Frame{
	// �ڹٿ����� üũ�ڽ��� ������ �����
	CheckboxGroup group;
	

	public RadioTest() {
		group = new CheckboxGroup();
		setLayout(new FlowLayout());
		this.add(new Checkbox("운동", group,false));
		this.add(new Checkbox("독서", group,false));
		this.add(new Checkbox("컴퓨터", group,false));
		this.add(new Checkbox("요리", group,false));
		this.add(new Checkbox("애견돌보기", group,true)); 
		
		setSize(300,400);
		setVisible(true);
	}

	public static void main(String[] args) {
		System.out.println("겁나빠름");
		new RadioTest();
		
	}

}
