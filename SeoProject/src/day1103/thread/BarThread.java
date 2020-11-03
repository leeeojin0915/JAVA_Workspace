package day1103.thread;

import javax.swing.JProgressBar;

public class BarThread extends Thread{
	int n;
	int time;
	JProgressBar bar;
	
	//이 쓰레드를 이용하고자하는 자는 바를 넘기시오
	public BarThread(JProgressBar bar, int time) {
		this.bar=bar;
		this.time=time;
	}
	public void run() {
		while(true) {
			n++;
			bar.setValue(n);//20퍼센트가 채워짐
			try {
				Thread.sleep(time);//non-runnable에 빠져있다가 0.5초 뒤 복귀하라는 명령
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
