import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class GUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	private CardLayout layout = new CardLayout();
	private JButton BoyButton;
	private JButton GirlButton;
	private Tuyu tuyu;
	private TitleGUI titlegui;
	private JPanel cards;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		titlegui = new TitleGUI();
		tuyu = titlegui.getterTuyu();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(layout);

		//1枚目
		JPanel choose = new JPanel();
		choose.setBounds(12, 125, 410, 126);

		JLabel selectLabel = new JLabel("相手の戦略を選んでね");
		selectLabel.setFont(new Font("MS UI Gothic", Font.PLAIN, 25));

		BoyButton = titlegui.createIconNamedButton("./png/kakkoiiman.png", "男の子戦略");
		BoyButton.addActionListener(this);
		choose.add(BoyButton);

		GirlButton = titlegui.createIconNamedButton("./png/kawaiiwoman.png", "女の子戦略");
		GirlButton.addActionListener(this);
		choose.add(GirlButton);
		contentPane.add(choose);
		choose.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		choose.add(selectLabel);

		//2枚目
		JPanel game = new JPanel();
		game.setBounds(12, 125, 410, 126);
		contentPane.add(game);
		game.setLayout(null);

		cards = new JPanel();
		cards.setBounds(0, 444, 424, 150);
		game.add(cards);
		cards.setLayout(new BoxLayout(cards, BoxLayout.X_AXIS));

	}

	@Override
	public void actionPerformed(ActionEvent event) {
		String cmd = event.getActionCommand();
		if (cmd.equals("男の子戦略")) {
			//ここにすとらてじいいいいいいを
			tuyu.addPlayer(Strategy.STRATEGY.PLAYERSTRATEGY.name());
			tuyu.addPlayer(Strategy.STRATEGY.BOYSTRATEGY.name());
			gaming();
			layout.next(contentPane);

		}
		if (cmd.equals("女の子戦略")) {
			//生成して欲しいねんけどわからんち
			//tuyu.addPlayer(Strategy.STRATEGY.PLAYERSTRATEGY.name());
			tuyu.addPlayer(Strategy.STRATEGY.BOYSTRATEGY.name());
			tuyu.addPlayer(Strategy.STRATEGY.GIRLSTRATEGY.name());
			gaming();
			layout.next(contentPane);

		}

	}

	public void gaming() {
		System.out.println(tuyu.players.size());
		tuyu.makePlayerHand();
		for (int i = 0; i < tuyu.getPlayer(0).getHandMaisu(); i++) {
			JButton cardButton = titlegui.createIconNamedButton("./png/tako.png", tuyu.getCardName(0, i));
			cards.add(cardButton);
		}
	}
}