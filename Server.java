import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ソケット通信(サーバー側)
 */
public class Server {

	void runSample() {

		ServerSocket sSocket = null;
		Socket socket = null;
		BufferedReader reader = null;
		PrintWriter writer = null;

		try {
			//IPアドレスとポート番号を指定してサーバー側のソケットを作成
			sSocket = new ServerSocket();
			sSocket.bind(new InetSocketAddress("127.0.0.1", 8765));

			System.out.println("サーバー起動");

			//クライアントからの要求を待ち続けます
			socket = sSocket.accept();

			//クライアントからの受取用
			reader = new BufferedReader(
					new InputStreamReader(socket.getInputStream(), "UTF-16"));

			//サーバーからクライアントへの送信用
			writer = new PrintWriter(
					socket.getOutputStream(), true);

			//無限ループ　byeの入力でループを抜ける
			String line = null;
			while (true) {

				line = reader.readLine();

				if (line.equals("bye")) {
					break;
				}

				/*
				try {
					num = Integer.parseInt(line);
				
					if (num % 2 == 0) {
						//送信用の文字を送信
						writer.println("OK");
					} else {
						//送信用の文字を送信
						writer.println("NG");
					}
				} catch (NumberFormatException e) {
					//送信用の文字を送信
					writer.println("数値を入力して下さい");
				}
				*/

				System.out.println("client:" + line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
				if (writer != null) {
					writer.close();
				}
				if (socket != null) {
					socket.close();
				}
				if (sSocket != null) {
					sSocket.close();
				}
				System.out.println("サーバー側終了");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Server s1 = new Server();
		s1.runSample();
	}
}
