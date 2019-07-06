package com.pknu.room.view;


import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import javax.imageio.ImageIO;

public class GetRoom extends JFrame 
	implements MouseListener, ActionListener {
	
	// fields
	JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8;
	IntroList i1;
	
	// 생성자(화면설정)
	public GetRoom(IntroList i1) {
		super("객실 보기");
		this.i1 = i1;  					// !
		
		createUI();
		
		// 이벤트 연결
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		btn6.addActionListener(this);
		btn7.addActionListener(this);
		btn8.addActionListener(this);
		
//		this.setSize(350, 380);
//		this.setVisible(true);
	}
	
	

	private void createUI() {
		getContentPane().setBackground(new Color(255, 255, 255));
		setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		
		
		// panels 생성
		JPanel pbtn1 		= new JPanel();
		pbtn1.setBackground(new Color(255, 255, 255));
		pbtn1.setBounds(30, 30, 207, 57);
		getContentPane().add(pbtn1);
		
		JPanel pbtn2 		= new JPanel();
		pbtn2.setBackground(new Color(255, 255, 255));
		pbtn2.setBounds(60, 127, 200, 150);
		getContentPane().add(pbtn2);
		
		JPanel pbtn3 		= new JPanel();
		pbtn3.setBackground(new Color(255, 255, 255));
		pbtn3.setBounds(290, 127, 200, 150);
		getContentPane().add(pbtn3);
		
		JPanel pbtn4 		= new JPanel();
		pbtn4.setBackground(new Color(255, 255, 255));
		pbtn4.setBounds(520, 127, 200, 150);
		getContentPane().add(pbtn4);
		
		JPanel pbtn5 		= new JPanel();
		pbtn5.setBackground(new Color(255, 255, 255));
		pbtn5.setBounds(750, 127, 200, 150);
		getContentPane().add(pbtn5);
		
		JPanel pbtn6 		= new JPanel();
		pbtn6.setBackground(new Color(255, 255, 255));
		pbtn6.setBounds(60, 382, 200, 150);
		getContentPane().add(pbtn6);
		
		JPanel pbtn7 		= new JPanel();
		pbtn7.setBackground(new Color(255, 255, 255));
		pbtn7.setBounds(290, 382, 200, 150);
		getContentPane().add(pbtn7);
		
		JPanel pbtn8 		= new JPanel();
		pbtn8.setBackground(new Color(255, 255, 255));
		pbtn8.setBounds(520, 382, 200, 150);
		getContentPane().add(pbtn8);
		
		JPanel pbtn9 		= new JPanel();
		pbtn9.setBackground(new Color(255, 255, 255));
		pbtn9.setBounds(750, 382, 200, 150);
		getContentPane().add(pbtn9);
		
		JPanel pbtn10 		= new JPanel();
		pbtn10.setBackground(Color.WHITE);
		pbtn10.setBounds(60, 317, 200, 35);
		getContentPane().add(pbtn10);
		
		JPanel pbtn11 		= new JPanel();
		pbtn11.setBackground(Color.WHITE);
		pbtn11.setBounds(290, 317, 200, 35);
		getContentPane().add(pbtn11);
		
		JPanel pbtn12 		= new JPanel();
		pbtn12.setBackground(Color.WHITE);
		pbtn12.setBounds(520, 317, 200, 35);
		getContentPane().add(pbtn12);
		
		JPanel pbtn13 		= new JPanel();
		pbtn13.setBackground(Color.WHITE);
		pbtn13.setBounds(750, 317, 200, 35);
		getContentPane().add(pbtn13);
		
		JPanel pbtn14 		= new JPanel();
		pbtn14.setBackground(Color.WHITE);
		pbtn14.setBounds(60, 571, 200, 35);
		getContentPane().add(pbtn14);
		
		JPanel pbtn15 		= new JPanel();
		pbtn15.setBackground(Color.WHITE);
		pbtn15.setBounds(290, 571, 200, 35);
		getContentPane().add(pbtn15);
		
		JPanel pbtn16 		= new JPanel();
		pbtn16.setBackground(Color.WHITE);
		pbtn16.setBounds(520, 571, 200, 35);
		getContentPane().add(pbtn16);
		
		JPanel pbtn17 		= new JPanel();
		pbtn17.setBackground(Color.WHITE);
		pbtn17.setBounds(750, 571, 200, 35);
		getContentPane().add(pbtn17);
		
		
		
		/*JPanel pbtn 		= new JPanel();
		pbtn.setBounds(30, 400, 792, 38);
		getContentPane().add(pbtn);*/
		
				
		
		// 화면 상단에 제목 추가
		JLabel lbl1 = new JLabel("<html><b style= \"color:#484848\">객실 선택</b><html>");
		lbl1.setBackground(new Color(255, 255, 255));
		
		lbl1.setVerticalAlignment(SwingConstants.TOP);
		lbl1.setFont(new Font("맑은 고딕", Font.BOLD, 29));
		pbtn1.add(lbl1);
		
		// 이미지 1 추가
		ImageIcon pic1 = new ImageIcon("./image/airbnb02_1.jpg");
	    pbtn2.add(new JLabel(pic1));
	    this.add(pbtn2);
	    this.pack();
	    
	    // 이미지 2 추가
		ImageIcon pic2 = new ImageIcon("./image/airbnb02_2.jpg");
	    pbtn3.add(new JLabel(pic2));
	    this.add(pbtn3);
	    this.pack();
	    
	    // 이미지 3 추가
	    ImageIcon pic3 = new ImageIcon("./image/airbnb03_1.jpg");
	    pbtn4.add(new JLabel(pic3));
	    this.add(pbtn4);
	    this.pack();
	    
	    // 이미지 4 추가
	    ImageIcon pic4 = new ImageIcon("./image/airbnb03_2.jpg");
	    pbtn5.add(new JLabel(pic4));
	    this.add(pbtn5);
	    this.pack();
	    
	    // 이미지 5 추가
	    ImageIcon pic5 = new ImageIcon("./image/airbnb04_1.jpg");
	    pbtn6.add(new JLabel(pic5));
	    this.add(pbtn6);
	    this.pack();
	    
	    // 이미지 6 추가
	    ImageIcon pic6 = new ImageIcon("./image/airbnb04_2.jpg");
	    pbtn7.add(new JLabel(pic6));
	    this.add(pbtn7);
	    this.pack();
	    
	    // 이미지 7 추가
	    ImageIcon pic7 = new ImageIcon("./image/airbnb04_3.jpg");
	    pbtn8.add(new JLabel(pic7));
	    this.add(pbtn8);
	    this.pack();
	    
	    // 이미지 8 추가
	    ImageIcon pic8 = new ImageIcon("./image/airbnb04_4.jpg");
	    pbtn9.add(new JLabel(pic8));
	    this.add(pbtn9);
	    this.pack();
	    
	    
	    // 버튼 1 추가
 		btn1 	= new JButton("선택");	
 		btn1.setFont(new Font("맑은 고딕", Font.BOLD, 12));
 		btn1.setForeground(Color.WHITE);
 		btn1.setBackground(SystemColor.activeCaption);
 		btn1.setBorderPainted(false);
 		
 		pbtn10.add(btn1);
 		
 		// 버튼 2 추가
 		btn2 	= new JButton("선택");	
 		btn2.setFont(new Font("맑은 고딕", Font.BOLD, 12));
 		btn2.setForeground(Color.WHITE);
 		btn2.setBackground(SystemColor.activeCaption);
 		btn2.setBorderPainted(false);
 		
 		pbtn11.add(btn2);
 		
 		// 버튼 3 추가
 		btn3 	= new JButton("선택");	
 		btn3.setFont(new Font("맑은 고딕", Font.BOLD, 12));
 		btn3.setForeground(Color.WHITE);
 		btn3.setBackground(SystemColor.activeCaption);
 		btn3.setBorderPainted(false);
 		
 		pbtn12.add(btn3);
 		
 		// 버튼 4 추가
 		btn4 	= new JButton("선택");	
 		btn4.setFont(new Font("맑은 고딕", Font.BOLD, 12));
 		btn4.setForeground(Color.WHITE);
 		btn4.setBackground(SystemColor.activeCaption);
 		btn4.setBorderPainted(false);
 		
 		pbtn13.add(btn4);
 		
 		// 버튼 5 추가
 		btn5 	= new JButton("선택");	
 		btn5.setFont(new Font("맑은 고딕", Font.BOLD, 12));
 		btn5.setForeground(Color.WHITE);
 		btn5.setBackground(SystemColor.activeCaption);
 		btn5.setBorderPainted(false);
 		
 		pbtn14.add(btn5);
 		
 		// 버튼 6 추가
 		btn6 	= new JButton("선택");	
 		btn6.setFont(new Font("맑은 고딕", Font.BOLD, 12));
 		btn6.setForeground(Color.WHITE);
 		btn6.setBackground(SystemColor.activeCaption);
 		btn6.setBorderPainted(false);
 		
 		pbtn15.add(btn6);
 		
 		// 버튼 7 추가
 		btn7 	= new JButton("선택");	
 		btn7.setFont(new Font("맑은 고딕", Font.BOLD, 12));
 		btn7.setForeground(Color.WHITE);
 		btn7.setBackground(SystemColor.activeCaption);
 		btn7.setBorderPainted(false);
 		
 		pbtn16.add(btn7);
 		
 		// 버튼 8 추가
 		btn8 	= new JButton("선택");	
 		btn8.setFont(new Font("맑은 고딕", Font.BOLD, 12));
 		btn8.setForeground(Color.WHITE);
 		btn8.setBackground(SystemColor.activeCaption);
 		btn8.setBorderPainted(false);
 		
 		pbtn17.add(btn8);
 		
 		// 객실 이름 1 추가
		JLabel name1 = new JLabel("스탠더드 더블");
		name1.setHorizontalAlignment(SwingConstants.CENTER);
		name1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		name1.setBackground(Color.WHITE);
		name1.setBounds(60, 276, 200, 30);
		getContentPane().add(name1);
		
 		// 객실 이름 2 추가
		JLabel name2 = new JLabel("이그젝티브 더블");
		name2.setHorizontalAlignment(SwingConstants.CENTER);
		name2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		name2.setBackground(Color.WHITE);
		name2.setBounds(290, 276, 200, 30);
		getContentPane().add(name2);
 		
 		// 객실 이름 3 추가
		JLabel name3 = new JLabel("스탠더드 트윈");
		name3.setHorizontalAlignment(SwingConstants.CENTER);
		name3.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		name3.setBackground(Color.WHITE);
		name3.setBounds(520, 277, 200, 30);
		getContentPane().add(name3);
 		
 		// 객실 이름 4 추가
		JLabel name4 = new JLabel("이그젝티브 트윈");
		name4.setHorizontalAlignment(SwingConstants.CENTER);
		name4.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		name4.setBackground(Color.WHITE);
		name4.setBounds(750, 277, 200, 30);
		getContentPane().add(name4);
 		
 		// 객실 이름 5 추가
		JLabel name5 = new JLabel("디럭스 트윈");
		name5.setHorizontalAlignment(SwingConstants.CENTER);
		name5.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		name5.setBackground(Color.WHITE);
		name5.setBounds(60, 531, 200, 30);
		getContentPane().add(name5);
 		
 		// 객실 이름 6 추가
		JLabel name6 = new JLabel("테라스 룸");
		name6.setHorizontalAlignment(SwingConstants.CENTER);
		name6.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		name6.setBackground(Color.WHITE);
		name6.setBounds(290, 531, 200, 30);
		getContentPane().add(name6);
		
 		// 객실 이름 7 추가
		JLabel name7 = new JLabel("테라스 스위트");
		name7.setHorizontalAlignment(SwingConstants.CENTER);
		name7.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		name7.setBackground(Color.WHITE);
		name7.setBounds(520, 531, 200, 30);
		getContentPane().add(name7);
 		
 		// 객실 이름 8 추가
		JLabel name8 = new JLabel("이그젝티브 스위트");
		name8.setHorizontalAlignment(SwingConstants.CENTER);
		name8.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		name8.setBackground(Color.WHITE);
		name8.setBounds(750, 531, 200, 30);
		getContentPane().add(name8);
		
		// default
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(1030, 700);
		this.setVisible(true);
		this.setLocation(120, 120);
		this.setResizable(false);
		
		// autofocus off
		this.requestFocusInWindow();
//		getContentPane().requestFocusInWindow();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		if( e.getSource() == btn1 ) {
			i1.jt3.getSelectionModel().setSelectionInterval(0,0);
			i1.switchPanels(i1.panel4);
			this.dispose();
		}
		if( e.getSource() == btn2 ) {
			i1.jt3.getSelectionModel().setSelectionInterval(1,1);
			i1.switchPanels(i1.panel4);
			this.dispose();
		}
		if( e.getSource() == btn3 ) {
			i1.jt3.getSelectionModel().setSelectionInterval(2,2);
			i1.switchPanels(i1.panel4);
			this.dispose();
		}
		if( e.getSource() == btn4 ) {
			i1.jt3.getSelectionModel().setSelectionInterval(3,3);
			i1.switchPanels(i1.panel4);
			this.dispose();
		}
		if( e.getSource() == btn5 ) {
			i1.jt3.getSelectionModel().setSelectionInterval(4,4);
			i1.switchPanels(i1.panel4);
			this.dispose();
		}
		if( e.getSource() == btn6 ) {
			i1.jt3.getSelectionModel().setSelectionInterval(5,5);
			i1.switchPanels(i1.panel4);
			this.dispose();
		}
		if( e.getSource() == btn7 ) {
			i1.jt3.getSelectionModel().setSelectionInterval(6,6);
			i1.switchPanels(i1.panel4);
			this.dispose();
		}
		if( e.getSource() == btn8 ) {
			i1.jt3.getSelectionModel().setSelectionInterval(7,7);
			i1.switchPanels(i1.panel4);
			this.dispose();
		}
	
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
