
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//import java.awt.*;
/**
 * 対戦相手を選択するためのウィンドウを生成するGUIクラス
 */
public class TitleGUI extends JFrame implements ActionListener {
	private static String title = "Tuyu Field";
	private Tuyu tuyu;
	JButton boyButton;
	JButton girlButton;

	public TitleGUI() {
		this.tuyu = new Tuyu();
	}

	public void createTitle() {
		JFrame frame = createFrame(title);
		JPanel panelUe = createPanel();
		JPanel panelNaka = createPanel();
		JLabel label = createLabel("対戦相手を選んでね");
		ImageIcon iconBoy = new ImageIcon(); //ここに男の子のアイコンのパスを
		ImageIcon iconGirl = new ImageIcon(); //ここの女の子のアイコンのパスを
		boyButton = createButton(iconBoy);
		boyButton.addActionListener(this);
		girlButton = createButton(iconGirl);
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

	private JButton createButton(Icon icon) {
		return new JButton(icon);
	}

	private JLabel createLabel(String labelName) {
		JLabel label = new JLabel(labelName);
		label.setPreferredSize(new Dimension(200, 100));
		return label;
	}

	public static void main(String[] args) {
		TitleGUI titleGUI = new TitleGUI();
		titleGUI.createTitle();
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == boyButton) {
			//ここにすとらてじいいいいいいを
			tuyu.addPlayer(Strategy.STRATEGY.BOYSTRATEGY.name());
		}
		if (event.getSource() == girlButton) {
			//生成して欲しいねんけどわからんち
			tuyu.addPlayer(Strategy.STRATEGY.GIRLSTRATEGY.name());
		}
	}

}
