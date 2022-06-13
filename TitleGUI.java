import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import java.awt.*;

public class TitleGUI extends JFrame implements ActionListener{
    private static String title = "Tuyu Field";
    JButton boyButton;
    JButton girlButton;

    public TitleGUI(){
    }

    public void createTitle(){
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

    private JFrame createFrame(String title){
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(600, 400);
        return frame;
    }

    private JPanel createPanel(){
        return new JPanel();
    }

    private JButton createButton(Icon icon){
        return new JButton(icon);
    }

    private JLabel createLabel(String labelName){
        JLabel label = new JLabel(labelName);
        label.setPreferredSize(new Dimension(200, 100));
        return label;
    }

    public static void main(String[] args){
        TitleGUI titleGUI = new TitleGUI();
        titleGUI.createTitle();
    }

    public void actionPerformed(ActionEvent event){
        if(event.getSource() == boyButton){
            //ここにすとらてじいいいいいいを
        }
        if(event.getSource() == girlButton){
            //生成して欲しいねんけどわからんち
        }
    }
}
