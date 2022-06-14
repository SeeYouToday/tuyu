import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class GUI extends JFrame implements ActionListener {

	public enum WHOMOVABLE {
		PLAYER, AITE;
	}

	private JPanel contentPane;
	private CardLayout layout = new CardLayout();
	private JButton BoyButton;
	private JButton GirlButton;
	private Tuyu tuyu;
	private TuyuAction tuyuAction;
	private TitleGUI titlegui;
	private JPanel playerCards;
	private ArrayList<JButton> playerHand = new ArrayList<>();
	//private ArrayList<JLabel> aiteHand = new ArrayList<>();
	private boolean isStarted = false;
	private JPanel aiteCards;
	private JLabel aiteNameAndHP;
	private String aiteName;
	private JButton GandouButton;
	private int aiteHP;
	private int playerHP;
	private JLabel playerNameAndHP;
	private JProgressBar aiteHPbar;
	private JProgressBar playerHPbar;
	private String playerName;
	private JTextField yourNameBox;
	private Card.KIND turnType;
	private WHOMOVABLE whoMovable;
	private JTextArea broadCastBox;
	private JLabel whatActionLabel;
	private JLabel whoTurnLabel;
	private JLabel yourCardLabel;
	private JLabel aiteCardLabel;
	private JLabel arrowLabel;
	private JButton passButton;
	private JLayeredPane titlePanel;

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
		tuyuAction = new TuyuAction(tuyu);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(layout);

		/*
		titlePanel = new JLayeredPane();
		contentPane.add(titlePanel, "name_656593377436300");
		titlePanel.setLayout(null);
		
		JLabel titleLabel = new JLabel();
		titleLabel.setBounds(482, 10, 0, 0);
		titlePanel.setLayer(titleLabel, 1);
		titleLabel.setIcon(titlegui.createIcomImageLabel("./png/title.png"));
		titlePanel.add(titleLabel);
		contentPane.add(titlePanel);
		*/

		//1枚目
		JPanel inputNamePanel = new JPanel();
		contentPane.add(inputNamePanel, "name_621173694056900");
		inputNamePanel.setLayout(null);

		yourNameBox = new JTextField();
		yourNameBox.setFont(new Font("MS UI Gothic", Font.PLAIN, 40));
		yourNameBox.setBounds(388, 10, 474, 56);
		inputNamePanel.add(yourNameBox);
		yourNameBox.setColumns(10);

		JLabel tellMeNameLabel = new JLabel("あなたの名前を教えてね");
		tellMeNameLabel.setFont(new Font("MS UI Gothic", Font.PLAIN, 30));
		tellMeNameLabel.setBounds(12, 11, 364, 55);
		inputNamePanel.add(tellMeNameLabel);

		JLabel selectStrategylabel = new JLabel("相手の戦略を選択してね");
		selectStrategylabel.setFont(new Font("MS UI Gothic", Font.PLAIN, 30));
		selectStrategylabel.setBounds(12, 76, 364, 55);
		inputNamePanel.add(selectStrategylabel);

		JPanel strategyPanel = new JPanel();
		strategyPanel.setBounds(22, 141, 840, 400);
		inputNamePanel.add(strategyPanel);
		strategyPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		BoyButton = titlegui.createIconNamedButton("./png/kakkoiiman.png", "男の子戦略");
		BoyButton.addActionListener(this);
		strategyPanel.add(BoyButton);

		GirlButton = titlegui.createIconNamedButton("./png/kawaiiwoman.png", "女の子戦略");
		GirlButton.addActionListener(this);
		strategyPanel.add(GirlButton);

		GandouButton = titlegui.createIconNamedButton("./png/gandou.png", "Gandou戦略");
		GandouButton.addActionListener(this);
		strategyPanel.add(GandouButton);

		//2枚目
		JPanel game = new JPanel();
		game.setBackground(new Color(0, 128, 0));
		game.setBounds(12, 125, 410, 126);
		contentPane.add(game);
		game.setLayout(null);

		playerCards = new JPanel();
		playerCards.setBackground(new Color(0, 128, 0));
		playerCards.setBounds(12, 491, 672, 150);
		game.add(playerCards);
		playerCards.setLayout(new BoxLayout(playerCards, BoxLayout.X_AXIS));

		aiteCards = new JPanel();
		aiteCards.setBackground(new Color(0, 128, 0));
		aiteCards.setBounds(257, 10, 549, 136);
		game.add(aiteCards);

		JPanel weatherPanel = new JPanel();
		weatherPanel.setBorder(new LineBorder(new Color(0, 128, 128), 6));
		weatherPanel.setBackground(new Color(0, 0, 255));
		weatherPanel.setForeground(new Color(255, 255, 255));
		weatherPanel.setBounds(818, 10, 144, 136);
		game.add(weatherPanel);
		weatherPanel.setLayout(null);

		JLabel weatherLabel = new JLabel("Now Weather ");
		weatherLabel.setFont(new Font("MS UI Gothic", Font.BOLD | Font.ITALIC, 19));
		weatherLabel.setForeground(new Color(255, 255, 255));
		weatherLabel.setBounds(12, 10, 120, 44);
		weatherPanel.add(weatherLabel);

		JPanel whoTurnPanel = new JPanel();
		whoTurnPanel.setBackground(new Color(0, 139, 139));
		whoTurnPanel.setBounds(26, 10, 208, 136);
		game.add(whoTurnPanel);
		whoTurnPanel.setLayout(null);

		whatActionLabel = new JLabel("攻撃");
		whatActionLabel.setBackground(new Color(0, 0, 0));
		whatActionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		whatActionLabel.setFont(new Font("HG明朝E", Font.BOLD | Font.ITALIC, 50));
		whatActionLabel.setBounds(12, 73, 184, 53);
		whoTurnPanel.add(whatActionLabel);

		whoTurnLabel = new JLabel("name");
		whoTurnLabel.setHorizontalAlignment(SwingConstants.CENTER);
		whoTurnLabel.setFont(new Font("HG明朝E", Font.BOLD | Font.ITALIC, 25));
		whoTurnLabel.setBackground(Color.BLACK);
		whoTurnLabel.setBounds(12, 10, 184, 53);
		whoTurnPanel.add(whoTurnLabel);

		JPanel aiteStus = new JPanel();
		aiteStus.setBounds(12, 172, 238, 54);
		game.add(aiteStus);
		aiteStus.setLayout(null);

		aiteNameAndHP = new JLabel("aiteName&HP");
		aiteNameAndHP.setFont(new Font("MS UI Gothic", Font.PLAIN, 28));
		aiteNameAndHP.setBounds(0, 0, 238, 27);
		aiteStus.add(aiteNameAndHP);

		aiteHPbar = new JProgressBar();
		aiteHPbar.setValue(30);
		aiteHPbar.setBackground(Color.GRAY);
		aiteHPbar.setForeground(Color.GREEN);
		aiteHPbar.setBounds(0, 30, 238, 24);
		aiteStus.add(aiteHPbar);

		JPanel playerStus = new JPanel();
		playerStus.setLayout(null);
		playerStus.setBounds(12, 236, 238, 54);
		game.add(playerStus);

		playerNameAndHP = new JLabel("playerName&HP");
		playerNameAndHP.setFont(new Font("MS UI Gothic", Font.PLAIN, 28));
		playerNameAndHP.setBounds(0, 0, 238, 27);
		playerStus.add(playerNameAndHP);

		playerHPbar = new JProgressBar();
		playerHPbar.setValue(30);
		playerHPbar.setForeground(Color.GREEN);
		playerHPbar.setBackground(Color.GRAY);
		playerHPbar.setBounds(0, 30, 238, 24);
		playerStus.add(playerHPbar);

		broadCastBox = new JTextArea() {
			@Override
			public void setText(String msg) {
				super.setText(this.getText() + msg);
			}
		};
		broadCastBox.setForeground(new Color(255, 255, 255));
		broadCastBox.setBackground(new Color(0, 0, 128));
		broadCastBox.setEditable(false);
		broadCastBox.setText("ここにメッセージが表示されます。\n");
		JScrollPane scroll = new JScrollPane(broadCastBox, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(689, 491, 273, 150);
		game.add(scroll);

		JPanel cardDeck = new JPanel();
		cardDeck.setBackground(new Color(0, 128, 0));
		cardDeck.setBounds(762, 259, 169, 159);
		game.add(cardDeck);
		cardDeck.setLayout(null);

		JLabel cardUnder = titlegui.createIconLabel("./png/うら.png");
		cardUnder.setBounds(10, 10, 100, 100);
		cardDeck.add(cardUnder);

		JLabel cardMid = titlegui.createIconLabel("./png/うら.png");
		cardMid.setBounds(20, 20, 100, 100);
		cardDeck.add(cardMid);

		JLabel cardUpper = titlegui.createIconLabel("./png/うら.png");
		cardUpper.setBounds(30, 30, 100, 100);
		cardDeck.add(cardUpper);

		yourCardLabel = new JLabel();
		yourCardLabel.setBounds(290, 323, 100, 100);
		game.add(yourCardLabel);

		aiteCardLabel = new JLabel();
		aiteCardLabel.setBounds(634, 323, 100, 100);
		game.add(aiteCardLabel);

		arrowLabel = new JLabel("");
		arrowLabel.setForeground(new Color(255, 0, 0));
		arrowLabel.setFont(new Font("MS UI Gothic", Font.BOLD, 99));
		arrowLabel.setHorizontalAlignment(SwingConstants.CENTER);
		arrowLabel.setBounds(420, 274, 144, 136);
		game.add(arrowLabel);

		passButton = new JButton("パスんご");
		passButton.setFont(new Font("MS UI Gothic", Font.BOLD, 25));
		passButton.setBounds(12, 414, 130, 48);
		passButton.addActionListener(this);
		game.add(passButton);

	}

	@Override
	public void actionPerformed(ActionEvent event) {
		String cmd = event.getActionCommand();

		if (cmd.equals("男の子戦略")) {
			//ここにすとらてじいいいいいいを
			tuyu.addPlayer(Strategy.STRATEGY.PLAYERSTRATEGY.name(), playerName);
			//tuyu.addPlayer(Strategy.STRATEGY.GIRLSTRATEGY.name());
			tuyu.addPlayer(Strategy.STRATEGY.BOYSTRATEGY.name(), Strategy.STRATEGY.BOYSTRATEGY.toString());
			aiteName = Strategy.STRATEGY.BOYSTRATEGY.toString();
			run();
			layout.next(contentPane);

		}
		if (cmd.equals("女の子戦略")) {
			//生成して欲しいねんけどわからんち
			tuyu.addPlayer(Strategy.STRATEGY.PLAYERSTRATEGY.name(), playerName);
			//uyu.addPlayer(Strategy.STRATEGY.BOYSTRATEGY.name());
			tuyu.addPlayer(Strategy.STRATEGY.GIRLSTRATEGY.name(), Strategy.STRATEGY.GIRLSTRATEGY.toString());
			aiteName = Strategy.STRATEGY.GIRLSTRATEGY.toString();
			run();
			layout.next(contentPane);

		}

		if (cmd.equals("Gandou戦略")) {
			//生成して欲しいねんけどわからんち
			tuyu.addPlayer(Strategy.STRATEGY.PLAYERSTRATEGY.name(), playerName);
			//tuyu.addPlayer(Strategy.STRATEGY.BOYSTRATEGY.name());
			tuyu.addPlayer(Strategy.STRATEGY.GANDOUSTRATEGY.name(), Strategy.STRATEGY.GANDOUSTRATEGY.toString());
			aiteName = Strategy.STRATEGY.GANDOUSTRATEGY.toString();
			run();
			layout.next(contentPane);

		}
		if (cmd.equals("パスんご")) {
			if ((tuyu.decideAttackCard(0).kind != Card.KIND.TOKEN && turnType == Card.KIND.ATTACK)
					|| !(whoMovable == WHOMOVABLE.PLAYER)) {
				broadCastBox.setText("あんた攻撃できるやろ！！\n");
				return;
			}
			Card nanimonaio = new Card(0, Card.KIND.TOKEN, "何もできないお！");
			broadCastBox.setText(aiteName + " は " + nanimonaio + " を使いました。\n");
			aiteCardLabel.setIcon(titlegui.createIcomImageLabel("./png/" + nanimonaio + ".png"));
			aiteCardLabel.setVisible(true);
			tuyuAction.setDefenceCard(nanimonaio);
			cardUpdate();
			turnUpdate();
		}

		if (playerHand.contains(event.getSource())) {
			int index = playerHand.indexOf(event.getSource());
			System.out.println(tuyu.getHandArray(0));
			System.out.println();
			for (JButton button : playerHand) {
				System.out.print(button.getText());
			}
			System.out.println();
			if (tuyu.getHandArray(0).get(index).kind != turnType) {
				System.out.println(turnType.name());
				System.out.println(tuyu.getHandArray(0).get(index).kind.name());
				broadCastBox.setText("このカードはこのターンで使うことはできません。\n");
				return;
			}
			;
			String iconName = tuyu.getCardName(0, index);
			cardSetting(playerHand.get(index));
			yourCardLabel.setIcon(titlegui.createIcomImageLabel("./png/" + iconName + ".png"));
			yourCardLabel.setVisible(true);
			broadCastBox.setText(playerName + " は " + iconName + " を使いました。\n");
			System.out.println(iconName + "の処理");
			System.out.println(index + 1 + "番目のカード");
			turnUpdate();
			updateHP();
		}

	}

	public void aiteBrain() {

		Timer timer = new Timer();

		TimerTask task1 = new TimerTask() {
			public void run() {
				arrowLabel.setText("→");
				arrowLabel.setForeground(new Color(255, 0, 0));
				arrowLabel.setVisible(true);
			}
		};
		timer.schedule(task1, 1000);

		TimerTask task2 = new TimerTask() {
			public void run() {
				Card defence = tuyu.decideDefenceCard(1);
				broadCastBox.setText(aiteName + " は " + defence.getName() + " を使いました。\n");
				aiteCardLabel.setIcon(titlegui.createIcomImageLabel("./png/" + defence.getName() + ".png"));
				aiteCardLabel.setVisible(true);
				tuyuAction.setDefenceCard(defence);
				turnUpdate();
			}
		};
		timer.schedule(task2, 2000);

		TimerTask task3 = new TimerTask() {
			public void run() {
				Card attack = tuyu.decideAttackCard(1);
				broadCastBox.setText(aiteName + " は " + attack.getName() + " を使いました。\n");
				aiteCardLabel.setIcon(titlegui.createIcomImageLabel("./png/" + attack.getName() + ".png"));
				aiteCardLabel.setVisible(true);
				tuyuAction.setAttackCard(attack);
				arrowLabel.setText("←");
				arrowLabel.setForeground(new Color(0, 0, 255));
				arrowLabel.setVisible(true);
				turnUpdate();
			}
		};
		timer.schedule(task3, 6000);

	}

	public void cardUpdate() {
		for (JButton jButton : playerHand) {
			jButton.setVisible(false);
		}
		playerHand.clear();

		for (int i = 0; i < tuyu.getPlayer(0).getHandMaisu(); i++) {
			JButton cardButton = titlegui.createIconNamedButton("./png/" + tuyu.getCardName(0, i) + ".png",
					tuyu.getCardName(0, i) + tuyu.getCardKind(0, i));
			cardButton.addActionListener(this);
			playerHand.add(cardButton);
			playerCards.add(cardButton);
		}
	}

	public void cardSetting(JButton button) {
		if (turnType == Card.KIND.ATTACK) {
			Card attack = tuyu.getPlayer(0).getHand().check(playerHand.indexOf(button));
			tuyuAction.setAttackCard(attack);
		} else if (turnType == Card.KIND.DEFENCE) {
			Card defence = tuyu.getPlayer(0).getHand().check(playerHand.indexOf(button));
			tuyuAction.setDefenceCard(defence);
		}

		tuyu.getPlayer(0).getHand().use(playerHand.indexOf(button));
		cardUpdate();

	}

	public void turnUpdate() {
		if (!isStarted) {
			turnType = Card.KIND.ATTACK;
			whoMovable = WHOMOVABLE.PLAYER;
			whoTurnLabel.setText(playerName + "の");
			isStarted = true;

			return;
		}

		//プレイヤーの攻撃ターン
		if (turnType == Card.KIND.ATTACK && whoMovable == WHOMOVABLE.PLAYER) {
			turnType = Card.KIND.DEFENCE;
			whoMovable = WHOMOVABLE.AITE;
			whatActionLabel.setText("防御");
			whoTurnLabel.setText(aiteName + "の");
			aiteBrain();
			//相手の防御ターン
		} else if (turnType == Card.KIND.DEFENCE && whoMovable == WHOMOVABLE.AITE) {
			turnType = Card.KIND.ATTACK;
			whatActionLabel.setText("攻撃");
			tuyuAction.action(1);
			updateHP();
			//相手の攻撃ターン
		} else if (turnType == Card.KIND.ATTACK && whoMovable == WHOMOVABLE.AITE) {
			turnType = Card.KIND.DEFENCE;
			whoMovable = WHOMOVABLE.PLAYER;
			whatActionLabel.setText("防御");
			whoTurnLabel.setText(playerName + "の");
			//プレイヤーの防御ターン
		} else if (turnType == Card.KIND.DEFENCE && whoMovable == WHOMOVABLE.PLAYER) {
			turnType = Card.KIND.ATTACK;
			whatActionLabel.setText("攻撃");
			tuyuAction.action(0);
			updateHP();
		}
	}

	public void updateHP() {
		playerHPbar.setValue(tuyu.getPlayer(0).getHP() * 100 / playerHP);
		aiteHPbar.setValue(tuyu.getPlayer(1).getHP() * 100 / aiteHP);
		playerNameAndHP.setText(playerName + " " + tuyu.getPlayer(0).getHP() + "/" + playerHP);
		aiteNameAndHP.setText(aiteName + "  " + tuyu.getPlayer(1).getHP() + "/" + aiteHP);
	}

	public void run() {
		tuyu.makePlayerHand();
		playerName = yourNameBox.getText().equals("") ? "プレイヤー" : yourNameBox.getText();

		for (int i = 0; i < tuyu.getPlayer(0).getHandMaisu(); i++) {
			JButton cardButton = titlegui.createIconNamedButton("./png/" + tuyu.getCardName(0, i) + ".png",
					tuyu.getCardName(0, i) + tuyu.getCardKind(0, i));
			cardButton.addActionListener(this);
			playerHand.add(cardButton);
			playerCards.add(cardButton);
		}

		for (int i = 0; i < tuyu.getPlayer(1).getHandMaisu(); i++) {
			JLabel cardLabel = titlegui.createIconLabel("./png/うら.png");
			//aiteHand.add(cardLabel);
			aiteCards.add(cardLabel);
		}

		aiteHP = tuyu.getPlayer(1).getHP();
		aiteNameAndHP.setText(aiteName + "  " + tuyu.getPlayer(1).getHP() + "/" + aiteHP);

		playerHP = tuyu.getPlayer(0).getHP();
		playerNameAndHP.setText(playerName + " " + tuyu.getPlayer(0).getHP() + "/" + playerHP);

		turnUpdate();
		updateHP();
		broadCastBox.setText("あなたが攻撃をするターンです。\n");

	}
}
