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

public class JFrameSample extends JFrame implements ActionListener{

	public JFrameSample(String title) {
		setTitle(title);
		setBounds(1000, 1000, 1000, 1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel p = new JPanel();
		//ここらへんでどういう配置にするかFlowかBoxか等々
		//p.setLayout(new BoxLayout(p,BoxLayout.LINE_AXIS));

		JPanel p2 = new JPanel();
		//p.setLayout(new FlowLayout());
		//JLabel label = new JLabel("SYTd 梅雨クエスト 現在の手札は100枚です。");
		//label.setHorizontalAlignment(SwingConstants.BOTTOM);
		/*JButton btn = new JButton("Push");
		JButton btn2 = new JButton("Help");*/

		/*セルらちゃん表示&処理*/
		create("./png/SELRAisTHIS.png", "SELRA",p);

		/*syuya表示&処理*/
		create("./png/syuya.png", "岡田としや",p);

		/*ブルボン表示&処理*/
		create("./png/burubon.png", "burubon",p);

		/*混沌表示&処理*/
		/*ImageIcon icon4 = new ImageIcon("./png/kame.png");
		int iconHeight4 = icon.getIconHeight();
		int iconWidth4 = icon.getIconWidth();
		JButton lite = new JButton("混沌");
		lite.setPreferredSize(new Dimension(iconHeight4,iconWidth4));
		lite.setIcon(icon4);
		lite.addActionListener(this);
		lite.setActionCommand("混沌");*/
		create("./png/kame.png", "混沌",p2);

		/*ImageIcon icon5 = new ImageIcon("./png/kame2.png");
		int iconHeight5 = icon.getIconHeight();
		int iconWidth5= icon.getIconWidth();
		JButton kame = new JButton("混沌2");
		lite.setPreferredSize(new Dimension(iconHeight5,iconWidth5));
		lite.setIcon(icon5);
		lite.addActionListener(this);
		lite.setActionCommand("混沌2");*/
		create("./png/kame2.png", "混沌2",p2);

		/*ImageIcon icon6 = new ImageIcon("./png/ninjin.png");
		int iconHeight6 = icon.getIconHeight();
		int iconWidth6 = icon.getIconWidth();
		JButton ninjin = new JButton("混沌3");
		lite.setPreferredSize(new Dimension(iconHeight6,iconWidth6));
		lite.setIcon(icon6);
		lite.addActionListener(this);
		lite.setActionCommand("混沌3");*/
		create("./png/ninjin.png", "混沌3",p2);



		//p.setFont(new Font(Font.MONOSPACED,Font.BOLD, 20));
		//p.add(label);

		//とりあえずJPnael pに追加
	   /* p.add(syuya);
	    p.add(selra);
	    p.add(burubon);*/

	    //もう一個のパネルp2に追加したい
	    /*p2.add(lite);
	    p2.add(kame);
	    p2.add(ninjin);*/

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
		MediaTracker tracker = new MediaTracker(this);
		Image smallImage = icon.getImage().getScaledInstance(icon.getIconWidth(),
				                                              -1, Image.SCALE_SMOOTH);
		tracker.addImage(smallImage, 1);
		ImageIcon smallIcon = new ImageIcon(smallImage);
		button.setIcon(smallIcon);
		button.addActionListener(this);
		button.setActionCommand(characterName);
		panel.add(button);

	}

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		//JFrame frame = new JFrame("つゆ クエスト");
		JFrameSample jfs = new JFrameSample("SYTd 梅雨クエスト");
		//画面デバイスを獲得
		/*GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice gd = ge.getDefaultScreenDevice();
		gd.setFullScreenWindow(jfs);*/
	    //frame.setLayout(new FlowLayout());
		//何かキーを押すと終了

		/*JLabel label = new JLabel("SYTd 梅雨クエスト\n(何かキーを押すとプログラム終了!!)");
		label.setFont(new Font(Font.MONOSPACED,Font.BOLD, 20));
		frame.add(label);

		/*JButton button1 = new JButton("ここを押せ");
		button1.addActionListener(null);
        frame.getContentPane().add(button1,BorderLayout.WEST);*/


		/*JPanel p = new JPanel();
		JButton btn1 = new JButton("Save");
		JButton btn2 = new JButton("Cancel");
		JButton btn3 = new JButton("Help");

		p.add(btn1);
		p.add(btn2);
		p.add(btn3);

		frame.getContentPane().add(p,BorderLayout.CENTER);*/
		jfs.setVisible(true);


	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd =e.getActionCommand();
		// TODO 自動生成されたメソッド・スタブ
		JLabel label1 = new JLabel("あああああああああ");
		JLabel label2 = new JLabel("い");
		JLabel label3 = new JLabel("ブリブリブリ");
	    if (cmd.equals("burubon")){
	    	JOptionPane.showMessageDialog(this, label1);
	   }else if (cmd.equals("syuya")){
	    	JOptionPane.showMessageDialog(this, label2);
	   }
	   else if(cmd.equals("SELRA")) {
		   JOptionPane.showConfirmDialog(this, label3);
	   }
	    System.exit(0);
	}

}
