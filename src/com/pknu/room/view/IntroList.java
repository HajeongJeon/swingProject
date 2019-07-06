package com.pknu.room.view;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import javax.imageio.ImageIO;

import com.pknu.room.dao.RoomDao;
import com.pknu.room.dao.RoomDao2;
import com.pknu.room.dao.RoomDao3;
import com.pknu.room.dao.RoomDao4;
import com.pknu.room.vo.RoomVO;

public class IntroList extends JFrame 
	implements MouseListener, ActionListener{
	
	// Field
	JLayeredPane layeredPane;
	JPanel panel1, panel2, panel3, panel4;
	JLabel label1;
	
	Vector v, v2, v3, v4;
	Vector colNames, colNames2, colNames3, colNames4;
	
	DefaultTableModel model, model2, model3, model4;
	public JTable 			  jt, jt2, jt3, jt4;
	JScrollPane 	  pane, pane2, pane3, pane4;
	
	private JPanel panel1_1;
	private JPanel panel1_2;
	private JPanel panel2_1;
	private JPanel panel2_2;
	private JPanel panel3_1;
	private JPanel panel3_2;
	private JPanel panel4_1;
	private JPanel panel4_2;
	private JButton btnCorrect;
	private JButton btnDelete;
	private JButton btnInsert;
	private JButton btnView;
	
	private static final String dateFormat = " yyyy-MM-dd";
	private JLabel today;
	
	public int selRow;
	public String csid;
	public RoomDao mDao;
	
	public IntroList() {
		// JFrame
		super("숙소, 트립, 장소를 모두 한 곳에서 - 에어비엔비");
		getContentPane().setBackground(Color.WHITE);
		JFrame window = new JFrame();
		getContentPane().setLayout(null);
		
		// JLayeredPane
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(133, 20, 840, 652);
		getContentPane().add(layeredPane);
		
		// JPanel
		superPane1();
		superPane2();
		superPane3();
		superPane4();
		
		// JButton
		JButton btn1 = new JButton("\uACE0\uAC1D \uD655\uC778");
		btn1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btn1.setForeground(SystemColor.menuText);
 		btn1.setBackground(new Color(255, 255, 255));
 		btn1.setBorderPainted(true);
 		btn1.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				btn1.setForeground(SystemColor.menuText);
		 		btn1.setBackground(SystemColor.inactiveCaption);
		 		btn1.setBorderPainted(false);
			}

			@Override
			public void focusLost(FocusEvent e) {
				btn1.setForeground(SystemColor.menuText);
		 		btn1.setBackground(new Color(255, 255, 255));
		 		btn1.setBorderPainted(true);
			}
 			
 		});
		btn1.setBounds(12, 282, 109, 57);
		getContentPane().add(btn1);
		
			// btn1 action
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				switchPanels(panel1);
			}
			
		});
		
		JButton btn2 = new JButton("\uC608\uC57D \uD655\uC778");
		btn2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btn2.setForeground(SystemColor.menuText);
 		btn2.setBackground(new Color(255, 255, 255));
 		btn2.setBorderPainted(true);
 		btn2.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				btn2.setForeground(SystemColor.menuText);
		 		btn2.setBackground(SystemColor.inactiveCaption);
		 		btn2.setBorderPainted(false);
			}

			@Override
			public void focusLost(FocusEvent e) {
				btn2.setForeground(SystemColor.menuText);
		 		btn2.setBackground(new Color(255, 255, 255));
		 		btn2.setBorderPainted(true);
			}
 			
 		});
		btn2.setBounds(12, 81, 109, 57);		
		getContentPane().add(btn2);
		
			// btn2 action
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				switchPanels(panel2);
			}
			
		});
		
		JButton btn3 = new JButton("\uC219\uBC15 \uD655\uC778");
		btn3.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btn3.setForeground(SystemColor.menuText);
 		btn3.setBackground(new Color(255, 255, 255));
 		btn3.setBorderPainted(true);
 		btn3.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				btn3.setForeground(SystemColor.menuText);
		 		btn3.setBackground(SystemColor.inactiveCaption);
		 		btn3.setBorderPainted(false);
			}

			@Override
			public void focusLost(FocusEvent e) {
				btn3.setForeground(SystemColor.menuText);
		 		btn3.setBackground(new Color(255, 255, 255));
		 		btn3.setBorderPainted(true);
			}
 			
 		});
		btn3.setBounds(12, 148, 109, 57);
		getContentPane().add(btn3);
		
			// btn3 action
		btn3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				switchPanels(panel3);
			}
			
		});
		
		JButton btn4 = new JButton("\uAC1D\uC2E4 \uD655\uC778");
		btn4.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btn4.setBounds(12, 215, 109, 57);
		btn4.setForeground(SystemColor.menuText);
 		btn4.setBackground(new Color(255, 255, 255));
 		btn4.setBorderPainted(true);
 		btn4.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				btn4.setForeground(SystemColor.menuText);
		 		btn4.setBackground(SystemColor.inactiveCaption);
		 		btn4.setBorderPainted(false);
			}

			@Override
			public void focusLost(FocusEvent e) {
				btn4.setForeground(SystemColor.menuText);
		 		btn4.setBackground(new Color(255, 255, 255));
		 		btn4.setBorderPainted(true);
			}
 			
 		});
		getContentPane().add(btn4);
		
			// btn4 action
		btn4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				switchPanels(panel4);
			}
			
		});
		
		// 오늘 날짜 추가
		today = new JLabel("TODAY :" + now());
		today.setBounds(12, 10, 138, 21);
		getContentPane().add(today);
		today.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
	
		// 이벤트 연결
		/*btnCorrect.addActionListener(this);*/
//		btnInsert.addActionListener(this);
		btnDelete.addActionListener(this);
		btnView.addActionListener(this);
		
		// Default
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(995, 710);
		this.setLocation(20, 20);
		this.setResizable(false);
		this.setVisible(true);
		
		// Autofocus off
		getContentPane().requestFocusInWindow();
		this.requestFocusInWindow();	
	}
	
	
// Methods -----------------------------------------------------------
	
	private String now() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat(dateFormat);
		return format.format(cal.getTime());
	}

	public void switchPanels(JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}
	
	public void switchTable(JTable table) {
		layeredPane.removeAll();
		layeredPane.add(table);
		layeredPane.repaint();
		layeredPane.revalidate();
	}
	
	public void deleteMember() {
		mDao = new RoomDao(this);
		int cnt = mDao.deleteMember(csid);
		this.switchPanels(panel2);
		/*
		mDao = new RoomDao(this);
		int cnt = mDao.deleteMember(csid);
		this.switchPanels(panel2);
		*/
	}
	
	public void jtRefresh() {
		RoomDao dao = new RoomDao();
		DefaultTableModel model = new DefaultTableModel(
				dao.getMemberList(), getColumnNames());
		jt.setModel(model);
	}

	
// 1) ----------------------------------------------------------------
// '예약 확인' 버튼 누르면 나오는 화면
	
	public Vector getColumnNames() {
		Vector<String> colNames = new Vector<>();
		colNames.add("이름");
		colNames.add("성");
		colNames.add("체크인 날짜");
		colNames.add("체크아웃 날짜");
		colNames.add("인원 수");
		colNames.add("국적");
		colNames.add("핸드폰");
		colNames.add("고객 ID");
		colNames.add("방 번호");
		return colNames;
	}
	
	public void superPane2() {
		panel2 = new JPanel();
		panel2.setBackground(Color.WHITE);
		panel2.setBounds(0, 0, 839, 652);
		layeredPane.add(panel2);
	
		// 제목 추가
		colNames = getColumnNames();
		
		// db 자료 가져오기
		RoomDao dao   = new RoomDao();
		v 		 	  = dao.getMemberList();
		model 	 	  = new DefaultTableModel(v, colNames);
		panel2.setLayout(null);
		
		// panel2_1 설정
		panel2_1 = new JPanel();
		panel2_1.setBounds(0, 61, 839, 534);
		panel2_1.setLayout(new CardLayout(0, 0));
		panel2.add(panel2_1);
		
		// panel2_2 설정
		panel2_2 = new JPanel();
		panel2_2.setBackground(Color.WHITE);
		panel2_2.setBounds(0, 0, 839, 49);
		panel2.add(panel2_2);
		panel2_2.setLayout(null);
		
		// 제목 레이블 추가
		JLabel reslabel = new JLabel("\uC608\uC57D \uD655\uC778");
		reslabel.setVerticalAlignment(SwingConstants.BOTTOM);
		reslabel.setHorizontalAlignment(SwingConstants.CENTER);
		reslabel.setBounds(0, 10, 839, 39);
		panel2_2.add(reslabel);
		reslabel.setFont(new Font("맑은 고딕", Font.PLAIN, 19));

		// 테이블 추가
		jt = new JTable(model);
		jt.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		pane  = new JScrollPane(jt);
		pane.setBackground(Color.white);
		panel2_1.add(pane);
		
		// '예약 삭제' 버튼 추가
		btnDelete = new JButton("예약 삭제");
		btnDelete.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnDelete.setBounds(0, 605, 110, 47);
		btnDelete.setForeground(SystemColor.menuText);
		btnDelete.setBackground(new Color(255, 255, 255));
		btnDelete.setBorderPainted(true);
		btnDelete.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				btnDelete.setForeground(SystemColor.menuText);
				btnDelete.setBackground(SystemColor.inactiveCaption);
				btnDelete.setBorderPainted(false);
			}

			@Override
			public void focusLost(FocusEvent e) {
				btnDelete.setForeground(SystemColor.menuText);
				btnDelete.setBackground(new Color(255, 255, 255));
				btnDelete.setBorderPainted(true);
			}
 			
 		});
		panel2.add(btnDelete);
		
		/*// '예약 수정' 버튼 추가
		btnCorrect = new JButton("예약 수정");
		btnCorrect.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnCorrect.setBounds(0, 605, 110, 47);
		panel2.add(btnCorrect);*/
	}


// 2) ----------------------------------------------------------------
// '숙박 확인' 버튼 누르면 나오는 화면
	
	public Vector getColumnNames2() {
		Vector<String> colNames2 = new Vector<>();
		colNames2.add("이름");
		colNames2.add("성");
		colNames2.add("체크인 날짜");
		colNames2.add("체크아웃 날짜");
		colNames2.add("인원 수");
		colNames2.add("국적");
		colNames2.add("핸드폰");
		colNames2.add("고객 ID");
		colNames2.add("방 번호");
		colNames2.add("숙박 번호");
		return colNames2;
	}
	
	public void superPane3() {
		panel3 = new JPanel();
		panel3.setBackground(Color.WHITE);
		panel3.setBounds(0, 0, 839, 652);
		layeredPane.add(panel3);
		
		// 제목 추가
		colNames2 = getColumnNames2();
		
		// db 자료 가져오기
		RoomDao2 dao2   = new RoomDao2();
		v2 		 	  = dao2.getMemberList();
		model2 	 	  = new DefaultTableModel(v2, colNames2);
		panel3.setLayout(null);
		
		// panel3_1 설정
		panel3_1 = new JPanel();
		panel3_1.setBounds(0, 61, 839, 534);
		panel3_1.setLayout(new CardLayout(0, 0));
		panel3.add(panel3_1);
		
		// panel3_2 설정
		panel3_2 = new JPanel();
		panel3_2.setBackground(Color.WHITE);
		panel3_2.setBounds(0, 0, 839, 51);
		panel3.add(panel3_2);
		panel3_2.setLayout(null);
		
		// 제목 레이블 추가
		JLabel acclabel = new JLabel("\uC219\uBC15 \uD655\uC778");
		acclabel.setVerticalAlignment(SwingConstants.BOTTOM);
		acclabel.setHorizontalAlignment(SwingConstants.CENTER);
		acclabel.setFont(new Font("맑은 고딕", Font.PLAIN, 19));
		acclabel.setBounds(0, 10, 839, 39);
		panel3_2.add(acclabel);
		
		// 테이블 추가
		jt2 = new JTable(model2);
		jt2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		pane2 = new JScrollPane(jt2);
		panel3_1.add(pane2);
		
		/*// '숙박 수정' 버튼 추가
		btnCorrect2 = new JButton("\uC219\uBC15 \uC218\uC815");
		btnCorrect2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnCorrect2.setBounds(0, 605, 110, 47);
		panel3.add(btnCorrect2);*/
	}
	
// 3) ----------------------------------------------------------------
// '객실 확인' 버튼 누르면 나오는 화면
		
	public Vector getColumnNames3() {
		Vector<String> colNames3 = new Vector<>();
		colNames3.add("방 번호");
		colNames3.add("방 타입");
		colNames3.add("층 수");
		colNames3.add("인원 수");
		return colNames3;
	}
		
	public void superPane4() {
		panel4 = new JPanel();
		panel4.setBackground(Color.WHITE);
		panel4.setBounds(0, 0, 839, 652);
		layeredPane.add(panel4);
		
		// 제목 추가
		colNames3 = getColumnNames3();
				
		// db 자료 가져오기
		RoomDao3 dao3 = new RoomDao3();
		v3 		 	  = dao3.getMemberList();
		model3 	 	  = new DefaultTableModel(v3, colNames3);
		panel4.setLayout(null);
		
		// panel4_1 설정
		panel4_1 = new JPanel();
		panel4_1.setBounds(0, 61, 839, 534);
		panel4.add(panel4_1);
		panel4_1.setLayout(new CardLayout(0, 0));
		
		// panel4_2 설정
		panel4_2 = new JPanel();
		panel4_2.setBackground(Color.WHITE);
		panel4_2.setBounds(0, 0, 839, 52);
		panel4.add(panel4_2);
		panel4_2.setLayout(null);
		
		// 제목 레이블 추가
		JLabel roomlabel = new JLabel("\uAC1D\uC2E4 \uD655\uC778");
		roomlabel.setVerticalAlignment(SwingConstants.BOTTOM);
		roomlabel.setHorizontalAlignment(SwingConstants.CENTER);
		roomlabel.setFont(new Font("맑은 고딕", Font.PLAIN, 19));
		roomlabel.setBounds(0, 10, 839, 39);
		panel4_2.add(roomlabel);
		
		// 테이블 추가
		jt3 = new JTable(model3);
		jt3.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		pane3 = new JScrollPane(jt3);
		panel4_1.add(pane3);
		
		// '객실 보기' 버튼 추가
		btnView = new JButton("객실 보기");
		btnView.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnView.setBounds(0, 605, 110, 47);
		btnView.setForeground(SystemColor.menuText);
		btnView.setBackground(new Color(255, 255, 255));
		btnView.setBorderPainted(true);
		btnView.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				btnView.setForeground(SystemColor.menuText);
				btnView.setBackground(SystemColor.inactiveCaption);
				btnView.setBorderPainted(false);
			}

			@Override
			public void focusLost(FocusEvent e) {
				btnView.setForeground(SystemColor.menuText);
				btnView.setBackground(new Color(255, 255, 255));
				btnView.setBorderPainted(true);
			}
 			
 		});
		panel4.add(btnView);
			
	}

// 4) ----------------------------------------------------------------
// '고객 확인' 버튼 누르면 나오는 화면
		
	public Vector getColumnNames4() {
		Vector<String> colNames4 = new Vector<>();
		colNames4.add("고객 ID");
		colNames4.add("이름");
		colNames4.add("성");
		colNames4.add("이메일");
		return colNames4;
	}
	
	public void superPane1() {
		panel1 = new JPanel();
		panel1.setBackground(Color.WHITE);
		panel1.setBounds(0, 0, 839, 652);
		layeredPane.add(panel1);
		
	    // 제목 추가
		colNames4 = getColumnNames4();
				
		// db 자료 가져오기
		RoomDao4 dao4   = new RoomDao4();
		v4 		 	  = dao4.getMemberList();
		model4 	 	  = new DefaultTableModel(v4, colNames4);
		panel1.setLayout(null);
	
		// panel1_1 설정
		panel1_1 = new JPanel();
		panel1_1.setBounds(0, 61, 839, 534);
		panel1_1.setLayout(new CardLayout(0, 0));
		panel1.add(panel1_1);
	
		// panel1_2 설정
		panel1_2 = new JPanel();
		panel1_2.setBackground(Color.WHITE);
		panel1_2.setBounds(0, 0, 839, 50);
		panel1.add(panel1_2);
		panel1_2.setLayout(null);
		
		// 제목 레이블 추가
		JLabel cuslabel = new JLabel("\uACE0\uAC1D \uD655\uC778");
		cuslabel.setBackground(Color.WHITE);
		cuslabel.setVerticalAlignment(SwingConstants.BOTTOM);
		cuslabel.setHorizontalAlignment(SwingConstants.CENTER);
		cuslabel.setFont(new Font("맑은 고딕", Font.PLAIN, 19));
		cuslabel.setBounds(0, 10, 839, 39);
		panel1_2.add(cuslabel);

		// 테이블 추가
		jt4 = new JTable(model4);
		jt4.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		pane4  = new JScrollPane(jt4);
		panel1_1.add(pane4);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if( e.getSource() == btnView ) {
			new GetRoom(this);
		}
		
		if( e.getSource() == btnDelete ) {
			selRow = jt.getSelectedRow();
			csid = String.valueOf(jt.getValueAt(selRow, 7));
			
			/*mDao.jt.getSelectionModel().getSelectedRow();
			mDao.switchPanels(jt.panel2);*/
			
			try {
				if(selRow != -1) {
					deleteMember();
//					superPane2(); // ! 새로 불러오면 x -> refresh 사용
					jtRefresh();
					switchPanels(panel2);
				} else {
					new JOptionPane().showMessageDialog(this, "삭제할 예약을 선택해 주세요.", "오류", JOptionPane.ERROR_MESSAGE);
				}
			} catch (HeadlessException e1) {
				System.out.println("삭제 에러가 발생했습니다.");
			}
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
