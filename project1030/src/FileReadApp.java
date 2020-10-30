package day1030.io;

import java.io.FileInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
 * Stream �̶�? ���ǿ����� �帣�� ���ٱ⸦ �ǹ� 
 *                    ���꿡���� �帧�� ����� ���� �ƴ� �������̴�!!
 *                    but ���꿡���� �帧�� ���⿡ ���� ������ ���� �з� (������ �������� ���α׷�)
 *                     
 *                    1) �Է�(Input) : �������� ���α׷����� �����Ͱ� �귯���� �� 
 *                    2) ���(Ouput) : �������� ���α׷����� �����Ͱ� �귯������ �� 
 * �ڹٿ����� ����°� ���õ� ��Ű������  java.io �̴�!! ���⿡�� ����� ó���� ���� ������ api ����..              
 
	���ܶ�? ���α׷��� ���� ����Ǿ��� �� ���� �������� ��Ȳ�� �ǹ�(����)
			������ �߻��ϸ�? ���α׷��� ������ ���ᰡ �ǹ�����.

 * */


public class FileReadApp {
	//������ ������� �����͸� �о���̴� FileInputStream�� �н��غ���!!
	FileInputStream fis;

	public FileReadApp(){
		File file=new File("D:/koreaIT/Workspace/java_workspace/project1030/src/aa.txt");

		//���û��� ������ ������� ��Ʈ��(��)�� ��������
		try{//�� ������ ������ �߻��� ���ɼ��� �ִ� �ڵ����� ���
			fis=new FileInputStream(file);
			System.out.println("��Ʈ�� ���� ����");
			//���翡�� �̸� ���ɼ��ִ� ������ ��üȭ ���� ���� �� �� �ϳ�
			//���� ����ߴ� ������ �߻��ϸ� jvm�� ���� FileNotFoundException�ν��Ͻ��� �޸𸮿� �ö����
			//catch���� �μ��� �����Ͽ� �����ڷ� �Ͽ��� ������ ���� ������ �м��� �� �ִ� ��ȸ�� �ִ� ��
			//����ó������? ������ ���� ����

			int data=5;
			//"�о���� 1�˰��� ������ ���� "+

			while(true){ //���� ����, ó���� ���� �𸦶�
				data=fis.read();//1byte�б�
				if(data==-1)break;//������ ���� �����ϸ�, �ݺ��� ��������
				System.out.print((char)data);
			}
			

		}catch(FileNotFoundException e){//Ȥ���� ����ߴ� ������ �߻��Ѵٸ�, ������ �������� ����, ����δ� �� catch�� ���� �����϶�
			System.out.println("������ ������ ã�� �� �����ϴ�.");
			e.printStackTrace();//stack������ ������ ������ ����϶�
		}catch(IOException e){
			System.out.println("������ ���� �� �����ϴ�.");
			e.printStackTrace();
		}
	}

	public static void main(String[] args){
		new FileReadApp();
	}
}


















