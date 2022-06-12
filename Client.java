import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
	void runSample() {

		Socket cSocket = null;
		BufferedReader csInput = null;
		PrintWriter writer = null;
		BufferedReader reader = null;

		try {
			//IPアドレスとポート番号を指定してクライアント側のソケットを作成
			cSocket = new Socket("127.0.0.1", 8765);

			//クライアント側での入力用
			csInput = new BufferedReader(new InputStreamReader(System.in));

			//クライアント側からサーバへの送信用
			writer = new PrintWriter(cSocket.getOutputStream(), true);

			//サーバ側からの受取用
			reader = new BufferedReader(new InputStreamReader(cSocket.getInputStream()));

			//無限ループ　byeの入力でループを抜ける
			String line = null;
			System.out.println("サーバーに接続できた");
			while (true) {
				System.out.println("なんか入力して");

				line = csInput.readLine();

				//送信用の文字を送信
				writer.println(line);

				//byeの入力でループを抜ける
				if (line.equals("bye")) {
					break;
				}

				//サーバ側からの受取の結果を表示
				System.out.println("サーバーからの回答：" + reader.readLine());
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
				if (csInput != null) {
					csInput.close();
				}
				if (cSocket != null) {
					cSocket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("クライアント側終了です");
		}
	}

	public static void main(String[] args) {
		Client s2 = new Client();
		s2.runSample();
	}

}
