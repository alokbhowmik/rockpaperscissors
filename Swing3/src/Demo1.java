import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;
import java.awt.event.*;

public class Demo1 extends JFrame implements ActionListener{
	JLabel l1,l2,l3;
	JTextField tx1,tx2;
	ImageIcon img1,img2,img3,img4;
	JButton b1,b2,b3;
	
	
	private int user_score=0;
	private int comp_score=0;
	Demo1(){
		setBounds(100,150,500,500);
		setBackground(Color.cyan);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Font font =new Font("Algerian",Font.ITALIC,20);
		l1=new JLabel();
		l1.setForeground(new Color(190,65,67));
		l1.setFont(font);
		l1.setText("User");
		l1.setBounds(150,20,50,30);
		add(l1);
		l2=new JLabel();
		l2.setForeground(new Color(190,65,67));
		l2.setFont(font);
		l2.setText("Comp");
		l2.setBounds(340,20,60,30);
		add(l2);
		
		l3=new JLabel("");
		l3.setBounds(200,100,100,100);
		add(l3);
		
		tx1=new JTextField("0");
		tx1.setFont(new Font("Arial",Font.BOLD,20));
		tx1.setForeground(Color.red);
		tx1.setBackground(new Color(100,167,217));
		tx1.setBounds(210,20,60,30);
		tx1.setEditable(false);
		add(tx1);
		tx2=new JTextField("0");
		tx2.setFont(new Font("Bauhaus 93",Font.BOLD,20));
		tx2.setForeground(Color.red);
		tx2.setBackground(new Color(100,167,217));
		tx2.setBounds(270,20,60,30);
		tx2.setEditable(false);
		add(tx2);
		
		
		img1=new ImageIcon("D:\\photos\\rock1.png");
		b1=new JButton(img1);
		b1.setBounds(20,250,100,100);
		b1.addActionListener(this);
		add(b1);
		
		img2=new ImageIcon("D:\\photos\\paper.png");
		b2=new JButton(img2);
		b2.setBounds(150,250,100,100);
		b2.addActionListener(this);
		add(b2);
		
		img3=new ImageIcon("D:\\photos\\scissors1.png");
		b3=new JButton(img3);
		b3.setBounds(280,250,100,100);
		b3.addActionListener(this);
		add(b3);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Random rn=new Random();
		int val=rn.nextInt(3)+1;
		String arr[]={"rock","paper","scissors"};
	if(e.getSource()==b1){
//		System.out.println("Rock"+val);
		isWin("rock",arr[val-1]);
	}
	if(e.getSource()==b2){
//		System.out.println("Paper"+val);
		isWin("paper",arr[val-1]);
	}
	if(e.getSource()==b3){
//		System.out.println("Scissors"+val);
		isWin("scissors",arr[val-1]);
	}
		
	}

	private void isWin(String i, String val) {
		switch(i+val){
		case "rock"+"scissors":
		case "paper"+"rock":
		case "scissors"+"paper":
			user_score++;
		
		tx1.setText(""+user_score);
		tx2.setText(""+comp_score);
		setImage1(val);
		break;
		case "scissors"+"rock":
		case "rock"+"paper":
		case "paper"+"scissors":
			comp_score++;
		tx1.setText(""+user_score);
		tx2.setText(""+comp_score);
		setImage1(val);
		break;
		case "rock"+"rock":
		case "paper"+"paper":
		case "scissors"+"scissors":
//			comp_score++;
		tx1.setText(""+user_score);
		tx2.setText(""+comp_score);
		setImage1(val);
		break;
				
		}
		
	}

	private void setImage1(String val) {
		if(val=="scissors"){
			img4=new ImageIcon("D:\\photos\\scissors1.png");
		}
		if(val=="rock"){
			img4=new ImageIcon("D:\\photos\\rock1.png");
		}
		if(val=="paper"){
			img4=new ImageIcon("D:\\photos\\paper.png");
		}
		
		l3.setIcon(img4);
		
	}
	
}
