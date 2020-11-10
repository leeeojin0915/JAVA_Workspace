/*
 * 채팅 메세지를 보내지 않더라도 채팅에 참여하는 모든사람이 보낸 메세지를 수신하려면
 * 무한루프로 실행되면서 스트림을 읽을 쓰레드가 필요하다
 * */
package day1110.network.unicasting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientThread extends Thread {
	MultiClient multiClient;
	Socket socket;
	BufferedReader buffr;
	BufferedWriter buffw;
	boolean flag=true;
	
	public ClientThread(MultiClient multiClient,Socket socket) {
		this.socket=socket;
		this.multiClient=multiClient;
		// 접속이 성공되었으므로, 스트림을 얻을 수 있다.
		try {
			buffr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			buffw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		listen();
	}
	
	// 서버가 보낸 메세지 듣기
	public void listen() {
		String msg = null;
		try {
			while (flag) {
				msg = buffr.readLine();
				multiClient.area.append(msg + "\n");// 대화기록
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 서버에 메세지 보내기(출력)
	public void send(String msg) {
		try {
			// 백터에 들어있는 메세지 쓰레드만쿠므 본복문 수행하면서 .write,flush 수행하면 됨(멀티캐스팅)
			buffw.write(msg + "\n");
			buffw.flush();// 남아있는 데이터없이 버퍼비우기
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
