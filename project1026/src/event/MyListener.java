/*jvm�� ������κ��� �̺�Ʈ ������ ������ �ش� ������ ������ �ٶ� �˸´� �̺�Ʈ ��ü�� �ν��Ͻ��� �޸𸮿� �ø���
�� �÷��� �ν��Ͻ� ������ �����ʶ� �Ҹ��� �̺�Ʈ ���� ��ü���� ���޵Ǿ�����.
�� ��, �����ʹ� ��ü�� �ҿ������� �������̽��� �����Ǵµ� �� ������ Ŭ�� ���� ������ ���� ��� ó�� ������ ���� �����ڰ�
�����ؾ��ϱ� �����̴�.
��) Ŭ���̺�Ʈ�� �ڹٿ����� �׼��̺�Ʈ�� �ϰ� �ش� ��ü�� ActionEvenet�̴�.
�� ActionEvent�� �ν��Ͻ��� ����ڰ� Ŭ���� �� ������ �����ʿ��� ���޵Ǿ�����, �����ڴ� �� �������� �߻�޼��带 ���������ν� 
�ϰ���� ������ �ϼ������� �ȴ�.
*/
package event;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class MyListener implements ActionListener{
	/*MyListener is a ActionListener*/
	public void actionPerformed(ActionEvent e){
		System.out.println("�� ������");
	}
}
