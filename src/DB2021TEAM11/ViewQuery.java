package DB2021TEAM11;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.SQLException;
import javax.swing.*;

public class ViewQuery extends JFrame{
	static GuiIntf gif = new GuiIntf();
	
	//업계 관계자가 영화 이름으로 정보 검색을 원할때 이용하는 메소드
	public static void cont_first() throws SQLException {
		String query1 = "SELECT * FROM DB2021_contact_want_view WHERE movie_name=?";//뷰 사용
		PreparedStatement pstmt = Main.conn.prepareStatement(query1);
		
		JPanel pn1 = new JPanel(null);	
		JLabel lb1 = new JLabel("영화 이름을 입력해주세요:");
		JTextField tf1 = new JTextField(20);
		JButton btn1 = new JButton("확인");
		TextArea ta1 = new TextArea();
		
		JButton btn_back = new JButton("이전화면으로");
		btn_back.setFont(new Font("Dialog",Font.BOLD,12));
		btn_back.setBounds(0,0,300,30);
			
		lb1.setFont(new Font("Dialog",Font.BOLD,15));
		lb1.setBounds(110,40,700,100);
		btn1.setBounds(460,110,100,30);
		tf1.setBounds(110,110,250,30);						
		ta1.setBounds(110,160,450,300);
	
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String temp = tf1.getText();				
				try {
					pstmt.setString(1, temp);				
					ResultSet rs1 = pstmt.executeQuery();				
					ta1.append("정보 출력\n 영화이름 / 장르 / 러닝타임 / 개봉 날짜 / 배우 / 평점 / 관객 수 / 선호연령대 / 선호 성별 / 감독 / 영화사 이름 / 영화사 분류 / 대표 이름 / 전화번호 \n");
					while(rs1.next()) {
						//textArea에 정보를 출력함
						ta1.append(rs1.getString(1)+" / "+rs1.getString(2)+" / "+rs1.getInt(3)+" / "+rs1.getDate(4)+" / "+rs1.getString(5)+" / "+rs1.getFloat(6)+" / "+rs1.getInt(7)+" / "+rs1.getInt(8)+" / "+rs1.getString(9)+" / "+rs1.getString(10)+" / "+rs1.getString(11)+" / "+rs1.getString(12)+" / "+rs1.getString(13)+" / "+rs1.getString(14)+"\n");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		//이전 화면으로 돌아감
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn1.setVisible(false);
				try {
					(new Search()).search_want_contact();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		pn1.add(btn_back);
		
		

		pn1.add(lb1);
		pn1.add(tf1);
		pn1.add(btn1);
		pn1.add(ta1);
		
		gif.add(pn1);
		gif.setTitle("영화 관리 데이터베이스");
		gif.setSize(700,600);
		gif.setResizable(false);
		gif.setVisible(true);
	}
	
	//업계 관계자가 영화사 이름으로 정보 검색을 원할때 이용하는 메소드
	public static void cont_second() throws SQLException {
		String query2 = "SELECT * FROM DB2021_contact_want_view WHERE company_name= ? ";//뷰 사용
		PreparedStatement pstmt = Main.conn.prepareStatement(query2);
		
		JPanel pn1 = new JPanel(null);		
		JLabel lb2 = new JLabel("영화사 이름을 입력해주세요:");
		JTextField tf2 = new JTextField(20);
		JButton btn2 = new JButton("확인");
		TextArea ta2 = new TextArea();
		
		JButton btn_back = new JButton("이전화면으로");
		btn_back.setFont(new Font("Dialog",Font.BOLD,12));
		btn_back.setBounds(0,0,300,30);
			
		lb2.setFont(new Font("Dialog",Font.BOLD,15));
		lb2.setBounds(110,40,700,100);
		btn2.setBounds(460,110,100,30);
		tf2.setBounds(110,110,250,30);						
		ta2.setBounds(110,160,450,300);
	
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String temp = tf2.getText();				
				try {
					pstmt.setString(1, temp);
					ResultSet rs1 = pstmt.executeQuery();
					
					ta2.append("정보 출력\n 영화이름 / 장르 / 러닝타임 / 개봉 날짜 / 배우 / 평점 / 관객 수 / 선호연령대 / 선호 성별 / 감독 / 영화사 이름 / 영화사 분류 / 대표 이름 / 전화번호 \n");
				    while(rs1.next()) {
				    	//textArea에 정보를 출력함
				        ta2.append(rs1.getString(1)+" / "+rs1.getString(2)+" / "+rs1.getInt(3)+" / "+rs1.getDate(4)+" / "+rs1.getString(5)+" / "+rs1.getFloat(6)+" / "+rs1.getInt(7)+" / "+rs1.getInt(8)+" / "+rs1.getString(9)+" / "+rs1.getString(10)+" / "+rs1.getString(11)+" / "+rs1.getString(12)+" / "+rs1.getString(13)+" / "+rs1.getString(14)+"\n");
				    }
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		//이전 화면으로 돌아감
				btn_back.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						pn1.setVisible(false);
						try {
							(new Search()).search_want_contact();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
		
		
	    pn1.add(lb2);
		pn1.add(tf2);
		pn1.add(btn2);
		pn1.add(ta2);
		pn1.add(btn_back);
		
		gif.add(pn1);
		gif.setTitle("영화 관리 데이터베이스");
		gif.setSize(700,600);
		gif.setResizable(false);
		gif.setVisible(true);
	}

	//일반 사용자가 영화 이름으로 정보 검색을 원할때 이용하는 메소드
	public static void user_first() throws SQLException{
		String query1 = "SELECT * FROM DB2021_movielover_view WHERE movie_name=?";//뷰 사용	
		PreparedStatement pstmt = Main.conn.prepareStatement(query1);

		JPanel pn1 = new JPanel(null);
		JLabel lb1 = new JLabel("영화 이름을 입력해주세요:");
		JTextField tf1 = new JTextField(20);
		JButton btn1 = new JButton("확인");
		TextArea ta1 = new TextArea();
		
		JButton btn_back = new JButton("이전화면으로");
		btn_back.setFont(new Font("Dialog",Font.BOLD,12));
		btn_back.setBounds(0,0,300,30);
	
		lb1.setFont(new Font("Dialog",Font.BOLD,15));
		lb1.setBounds(110,40,700,100);
		btn1.setBounds(460,110,100,30);
		tf1.setBounds(110,110,250,30);						
		ta1.setBounds(110,160,450,300);
		
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String temp = tf1.getText();				
				try {
					pstmt.setString(1, temp);
					ResultSet rs1 = pstmt.executeQuery();
					ta1.append("영화이름 / 장르 / 러닝타임 / 개봉 날짜 / 평점 / 관객 수 / 선호연령대 / 선호 성별 / 수상한 상 \n");
					while(rs1.next()) {
						//textArea에 정보를 출력함
						ta1.append(""+rs1.getString(1)+" / "+rs1.getString(2)+" / "+rs1.getInt(3)+" / "+rs1.getDate(4)+" / "+rs1.getFloat(5)+" / "+rs1.getInt(6)+" / "+rs1.getInt(7)+" / "+rs1.getString(8)+" / "+rs1.getString(9)+"\n");
				    }
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		//이전 화면으로 돌아감
				btn_back.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						pn1.setVisible(false);
						try {
							(new Search()).search_for_onlymovielover();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				
				pn1.add(btn_back);
				
		pn1.add(lb1);
		pn1.add(tf1);
		pn1.add(btn1);
		pn1.add(ta1);
		
		gif.add(pn1);
		gif.setTitle("영화 관리 데이터베이스");
		gif.setSize(700,600);
		gif.setResizable(false);
		gif.setVisible(true);
	}

	//일반 사용자가 관객 수로 정보 검색을 원할때 이용하는 메소드
	public static void user_second() throws SQLException{		 
		 String query2 = "SELECT * FROM DB2021_movielover_view WHERE attendance>=?";//뷰 사용
		 PreparedStatement pstmt2 = Main.conn.prepareStatement(query2);
		 
		 JPanel pn = new JPanel(null);
		 JLabel lb2 = new JLabel("관객 수를 입력해 주세요:");
		 JTextField tf2 = new JTextField(20);
		 JButton btn2 = new JButton("확인");
		 TextArea ta2 = new TextArea();	
		 
		 JButton btn_back = new JButton("이전화면으로");
			btn_back.setFont(new Font("Dialog",Font.BOLD,12));
			btn_back.setBounds(0,0,300,30);
		
		 lb2.setFont(new Font("Dialog",Font.BOLD,15));
		 lb2.setBounds(110,40,700,100);
		 btn2.setBounds(460,110,100,30);
		 tf2.setBounds(110,110,250,30);						
		 ta2.setBounds(110,160,450,300);
			
		 btn2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String temp = tf2.getText();				
					try {
						pstmt2.setString(1, temp);
						ResultSet rs1 = pstmt2.executeQuery();
						ta2.append("영화이름 / 장르 / 러닝타임 / 개봉 날짜 / 평점 / 관객 수 / 선호연령대 / 선호 성별 / 수상한 상 \n");
						while(rs1.next()) {
							//textArea에 정보를 출력함
							ta2.append(""+rs1.getString(1)+" / "+rs1.getString(2)+" / "+rs1.getInt(3)+" / "+rs1.getDate(4)+" / "+rs1.getFloat(5)+" / "+rs1.getInt(6)+" / "+rs1.getInt(7)+" / "+rs1.getString(8)+" / "+rs1.getString(9)+"\n");
					    }
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		 
		//이전 화면으로 돌아감
			btn_back.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pn.setVisible(false);
					try {
						(new Search()).search_for_onlymovielover();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			
			pn.add(btn_back);
		 
		pn.add(lb2);
		pn.add(tf2);
		pn.add(btn2);
		pn.add(ta2);
		
		gif.add(pn);
		gif.setTitle("영화 관리 데이터베이스");
		gif.setSize(700,600);
		gif.setResizable(false);
		gif.setVisible(true);
	}
}
