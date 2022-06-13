import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class JFrameSample extends JFrame implements ActionListener {

	/*コンストラクタ
	 * とりあえずここに全部書いてます
	 * */
	public JFrameSample(String title) {
		setTitle(title);
		//x,y,幅,高さ
		setBounds(0, 0, 1800, 1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel p = new JPanel();

		JPanel p2 = new JPanel();

		/*セルらちゃん表示&処理*/
		create("./png/SELRAisTHIS.png", "SELRA", p);

		/*syuya表示&処理*/
		create("./png/syuya.png", "岡田としや", p);

		/*ブルボン表示&処理*/
		create("./png/burubon.png", "burubon", p);

		/*かめ表示&処理*/
		create("./png/abareruhito.png", "混沌", p2);
		/*かめ(二体目)追加*/
		create("./png/turtle.png", "混沌2", p2);
		/*人参追加*/
		create("./png/carrot.png", "混沌3", p2);
		/*gandou等を追加*/
		create("./png/gandou.png", "gandou", p2);
		create("./png/mentuyu.png", "mentuyu", p2);
		create("./png/rainy.png", "雨", p2);
		create("./png/kusokimosnail.png", "カタツムリ", p2);
		create("./png/baiuzensen.png", "梅雨前線", p2);
		create("./png/kusokimofrog.png", "カエルDX", p2);
		create("./png/tako.png", "タコ", p2);

		//p.setFont(new Font(Font.MONOSPACED,Font.BOLD, 20));
		//p.add(label);

		p.setLayout(new BoxLayout(p, BoxLayout.LINE_AXIS));
		p2.setLayout(new BoxLayout(p2, BoxLayout.LINE_AXIS));

		//自分のカード
		getContentPane().add(p, BorderLayout.SOUTH);
		//相手のカード
		getContentPane().add(p2, BorderLayout.NORTH);

	}

	/*画像付きボタンを生成そしてどのパネルに追加するかを指定*/
	public void create(String fileName, String characterName, JPanel panel) {
		ImageIcon icon = new ImageIcon(fileName);
		JButton button = new JButton(characterName);
		//画像の拡大処理
		MediaTracker tracker = new MediaTracker(this);
		Image smallImage = icon.getImage().getScaledInstance((int) (icon.getIconWidth() * 2),
				-1, Image.SCALE_SMOOTH);
		tracker.addImage(smallImage, 1);
		ImageIcon smallIcon = new ImageIcon(smallImage);

		button.setIcon(smallIcon);
		//水平方向を中央揃えで設定
		button.setHorizontalTextPosition(JButton.CENTER);
		//垂直方法を下部で設定
		button.setVerticalTextPosition(SwingConstants.BOTTOM);
		button.addActionListener(this);
		button.setActionCommand(characterName);
		panel.add(button);

	}

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		JFrameSample jfs = new JFrameSample("SYTd 梅雨クエスト");
		jfs.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		// TODO 自動生成されたメソッド・スタブ
		JLabel label1 = new JLabel("あああああああああ");
		JLabel label2 = new JLabel("い");
		JLabel label3 = new JLabel("ブリブリブリ");
		if (cmd.equals("burubon")) {
			JOptionPane.showMessageDialog(this, label1);
		} else if (cmd.equals("syuya")) {
			JOptionPane.showMessageDialog(this, label2);
		} else if (cmd.equals("SELRA")) {
			JOptionPane.showConfirmDialog(this, label3);
		}
		System.exit(0);
	}

}
