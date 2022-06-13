import java.awt.BorderLayout;

import javax.swing.*;
//import java.awt.*;

public class TitleGUI extends JFrame{
    private static String title = "Tuyu Field";
    public TitleGUI(){

    }
    public void createTitle(){
        JFrame frame = createFrame(title);
        JPanel panelUe = createPanel();
        JPanel panelNaka = createPanel();
        JLabel label = createLabel("対戦相手を選んでね");
        JButton boyButton = createButton("男の子");
        JButton girlButton = createButton("女の子");
        //Container container = getContentPane();
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

    private JButton createButton(String name){
        return new JButton(name);
    }

    private JLabel createLabel(String label){
        return new JLabel(label);
    }

    public static void main(String[] args){
        TitleGUI titleGUI = new TitleGUI();
        titleGUI.createTitle();
    }
}
