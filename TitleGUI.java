
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import java.awt.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * 対戦相手を選択するためのウィンドウを生成するGUIクラス
 */
public class TitleGUI extends JFrame implements ActionListener {
	private static String title = "Tuyu Field";
	private Tuyu tuyu;
	JButton boyButton;
	JButton girlButton;
	static TitleGUI titleGUI;

	public TitleGUI() {
		this.tuyu = new Tuyu();
	}

	public void createTitle() {
		JFrame frame = createFrame(title);
		JPanel panelUe = createPanel();
		JPanel panelNaka = createPanel();
		JLabel label = createLabel("対戦相手を選んでね", 400, 300);
		ImageIcon iconBoy = new ImageIcon("./png/kakkoiiman.png"); //ここに男の子のアイコンのパスを
		ImageIcon iconGirl = new ImageIcon("./png/kawaiiwoman.png"); //ここの女の子のアイコンのパスを
		//boyButton = createIconButton(iconBoy);
		boyButton = createIconNamedButton("./png/kakkoiiman.png", "男の子戦略");
		boyButton.addActionListener(this);
		//girlButton = createIconButton(iconGirl);
		girlButton = createIconNamedButton("./png/kawaiiwoman.png", "女の子戦略");
		girlButton.addActionListener(this);
		panelUe.add(label);
		frame.add(panelUe, BorderLayout.NORTH);
		panelNaka.add(boyButton);
		panelNaka.add(girlButton);
		frame.add(panelNaka, BorderLayout.CENTER);
	}

	private JFrame createFrame(String title) {
		JFrame frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(600, 400);
		return frame;
	}

	private JPanel createPanel() {
		return new JPanel();
	}

	private JButton createIconButton(Icon icon) {
		return new JButton(icon);
	}

	private JButton createNamedButton(String name) {
		return new JButton(name);
	}

	public JButton createIconNamedButton(String iconPath, String name) {
		ImageIcon icon = new ImageIcon(iconPath);
		JButton button = new JButton(name);
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
		button.setActionCommand(name);
		return button;
	}

	public JLabel createIconLabel(String iconPath) {
		ImageIcon icon = new ImageIcon(iconPath);
		JLabel label = new JLabel();
		//画像の拡大処理
		MediaTracker tracker = new MediaTracker(this);
		Image smallImage = icon.getImage().getScaledInstance((int) (icon.getIconWidth() * 2),
				-1, Image.SCALE_SMOOTH);
		tracker.addImage(smallImage, 1);
		ImageIcon smallIcon = new ImageIcon(smallImage);
		label.setIcon(smallIcon);
		//水平方向を中央揃えで設定
		label.setHorizontalTextPosition(JButton.CENTER);
		//垂直方法を下部で設定
		label.setVerticalTextPosition(SwingConstants.BOTTOM);
		return label;
	}

	public ImageIcon createIcomImageLabel(String iconPath) {
		ImageIcon icon = new ImageIcon(iconPath);
		//画像の拡大処理
		MediaTracker tracker = new MediaTracker(this);
		Image smallImage = icon.getImage().getScaledInstance((int) (icon.getIconWidth() * 2),
				-1, Image.SCALE_SMOOTH);
		tracker.addImage(smallImage, 1);
		return new ImageIcon(smallImage);
	}

	public Tuyu getterTuyu() {
		return tuyu;
	}

	private JLabel createLabel(String labelName, int width, int height) {
		JLabel label = new JLabel(labelName);
		label.setPreferredSize(new Dimension(width, height));
		return label;
	}

	public static void main(String[] args) {
		titleGUI = new TitleGUI();
		titleGUI.createTitle();
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == boyButton) {
			//ここにすとらてじいいいいいいを
			tuyu.addPlayer(Strategy.STRATEGY.BOYSTRATEGY.name(), Strategy.STRATEGY.BOYSTRATEGY.toString());
			titleGUI.setVisible(false);

		}
		if (event.getSource() == girlButton) {
			//生成して欲しいねんけどわからんち
			tuyu.addPlayer(Strategy.STRATEGY.GIRLSTRATEGY.name(), Strategy.STRATEGY.GIRLSTRATEGY.toString());
			titleGUI.setVisible(false);

		}
	}

}
