package DB2021TEAM11;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Search extends JFrame{
	static GuiIntf gif = new GuiIntf();
	
	/*박지은벗*/
	public static void creating_tool(JLabel lb, JButton btn, JTextField tf, TextArea ta) {
		lb.setFont(new Font("Dialog",Font.BOLD,15));
		lb.setBounds(60,40,700,100);
		btn.setBounds(510,110,100,30);
		tf.setBounds(60,110,250,30);						
		ta.setBounds(60,160,550,300);
	}
	
	//장르로 영화 검색
	public static JPanel search_movie_by_genre() throws SQLException{
		JPanel pn = new JPanel(null);
		try {
			Main.conn.setAutoCommit(false); //Autocommit을 수동으로 전환
			String query = "SELECT name FROM DB2021_Movies WHERE genre=?";
			PreparedStatement pstmt = Main.conn.prepareStatement(query);
			
			JButton btn_back = new JButton("이전화면으로");
			btn_back.setFont(new Font("Dialog",Font.BOLD,12));
			btn_back.setBounds(0,0,300,30);
			
			JLabel lb1 = new JLabel("어떤 장르의 영화를 검색할까요?");				
			JTextField tf1 = new JTextField(20);
			JButton btn1 = new JButton("확인");
			TextArea ta1 = new TextArea();	
				
			creating_tool(lb1, btn1, tf1, ta1);
				
			btn1.addActionListener(new ActionListener() { //확인 버튼 클릭시 발생하는 이벤트
				public void actionPerformed(ActionEvent e) {
					String temp = tf1.getText();
					try {
						pstmt.setString(1, temp);
						
						ResultSet rs = pstmt.executeQuery();
						while(rs.next()) {
							ta1.append("답: "+rs.getString(1)+"\n"); //textArea에 정보를 출력함
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
						
				}
			});
			
			//이전화면으로 버튼을 누를시 GuiIntf 클래스의 Panel_searching 화면으로 돌아감
			btn_back.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pn.setVisible(false);
					(new GuiIntf()).Panel_searching();
				}
			});
			
				
			pn.add(btn1);
			pn.add(tf1);
			pn.add(lb1);
			pn.add(ta1);
			pn.add(btn_back);
			Main.conn.commit(); ////이상이 없을시 commit	
		}
		catch(SQLException se) {
			se.printStackTrace();
			try{
				if(Main.conn!=null)
					Main.conn.rollback(); //오류 발생시 rollback
			}catch(SQLException se2){
				se2.printStackTrace();
			}
		}
		return pn;
	}

	//영화제 이름으로 영화 검색
	public static JPanel search_movie_by_festival() throws SQLException{
			JPanel pn = new JPanel(null);
			try {
				Main.conn.setAutoCommit(false); //Autocommit을 수동으로 전환
				String query = "SELECT film FROM DB2021_Award WHERE festival_name=?";
				PreparedStatement pstmt = Main.conn.prepareStatement(query);
				
				JButton btn_back = new JButton("이전화면으로");
				btn_back.setFont(new Font("Dialog",Font.BOLD,12));
				btn_back.setBounds(0,0,300,30);
				
				JLabel lb1 = new JLabel("어떤 영화제에서 수상한 영화를 검색할까요?");
				JTextField tf1 = new JTextField(20);
				JButton btn1 = new JButton("확인");
				TextArea ta1 = new TextArea();	
				
				creating_tool(lb1, btn1, tf1, ta1);
				
				btn1.addActionListener(new ActionListener() { //확인 버튼 클릭시 발생하는 이벤트
					public void actionPerformed(ActionEvent e) {
						String temp = tf1.getText();
						try {
							pstmt.setString(1, temp);
						
							ResultSet rs = pstmt.executeQuery();
							while(rs.next()) {
								ta1.append("답: "+rs.getString(1)+"\n"); //textArea에 정보를 출력함
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
				});
				
				//이전화면으로 버튼을 누를시 GuiIntf 클래스의 Panel_searching 화면으로 돌아감
				btn_back.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		               pn.setVisible(false);
		               (new GuiIntf()).Panel_searching();
		            }
		         });
				
				pn.add(btn_back);
				pn.add(btn1);
				pn.add(tf1);
				pn.add(lb1);
				pn.add(ta1);
				Main.conn.commit(); ////이상이 없을시 commit
			}
			catch(SQLException se) {
				se.printStackTrace();
				try{
					if(Main.conn!=null)
						Main.conn.rollback(); //오류 발생시 rollback
				}catch(SQLException se2){
					se2.printStackTrace();
				}
			}
			return pn;
		}
		
	//배우 이름으로 영화 검색
	public static JPanel search_movie_by_actor() throws SQLException{
			JPanel pn = new JPanel(null);
			try {
				Main.conn.setAutoCommit(false); //Autocommit을 수동으로 전환
				String query = "SELECT name FROM DB2021_Movies WHERE actor=?";
				PreparedStatement pstmt = Main.conn.prepareStatement(query);
				
				JButton btn_back = new JButton("이전화면으로");
				btn_back.setFont(new Font("Dialog",Font.BOLD,12));
				btn_back.setBounds(0,0,300,30);
				
				JLabel lb1 = new JLabel("어떤 배우의 영화를 검색할까요?");
				JTextField tf1 = new JTextField(20);
				JButton btn1 = new JButton("확인");
				TextArea ta1 = new TextArea();	
				creating_tool(lb1, btn1, tf1, ta1);
				
				btn1.addActionListener(new ActionListener() { //확인 버튼 클릭시 발생하는 이벤트
					public void actionPerformed(ActionEvent e) {
						String temp = tf1.getText();
						try {
							pstmt.setString(1, temp);
						
							ResultSet rs = pstmt.executeQuery();
							while(rs.next()) {
								ta1.append("답: "+rs.getString(1)+"\n"); //textArea에 정보를 출력함
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
				});
				
				//이전화면으로 버튼을 누를시 GuiIntf 클래스의 Panel_searching 화면으로 돌아감
				btn_back.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		               pn.setVisible(false);
		               (new GuiIntf()).Panel_searching();
		            }
		         });
				
				pn.add(btn_back);

				pn.add(btn1);
				pn.add(tf1);
				pn.add(lb1);
				pn.add(ta1);
				Main.conn.commit(); ////이상이 없을시 commit				
			}
			catch(SQLException se){
				se.printStackTrace();
				try{
					if(Main.conn!=null)
						Main.conn.rollback(); //오류 발생시 rollback
				}catch(SQLException se2){
					se2.printStackTrace();
				}
			}			
			return pn;
		}
	
	/*(뷰 이용 쿼리1)영화 +영화사 검색:영화사에 컨택하고자 하는 사용자라고 가정*/
	 public static void search_want_contact() throws SQLException{	
		JPanel pn = new JPanel(null);
	    JLabel lb1 = new JLabel("<html>컨택하고자 하는 영화사 정보를 두가지 항목 중 골라서 검색할 수 있습니다.<br> 1.영화 이름 2.영화사 이름<br></html>");
	    JTextField tf = new JTextField(20);
		JButton btn = new JButton("확인");
		 
		JButton btn_back = new JButton("이전화면으로");
		btn_back.setFont(new Font("Dialog",Font.BOLD,12));
		btn_back.setBounds(0,0,300,30);
		 
		lb1.setFont(new Font("Dialog",Font.BOLD,12));
		lb1.setBounds(0,30,700,100);
		btn.setBounds(410,110,100,30);
		tf.setBounds(60,110,250,30);
		 
		 pn.add(lb1);
    	 pn.add(tf);
    	 pn.add(btn);
    	 gif.add(pn);
    	 gif.setVisible(true);
    	 pn.add(btn_back);

			
		//이전화면으로 버튼을 누를시 처음 화면으로 돌아감
    	 btn_back.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	               pn.setVisible(false);
	               (new GuiIntf()).FirstWindow();
	            }
	         });
			
			
    	 
    	 btn.addActionListener(new ActionListener() { //확인 버튼 클릭시 발생하는 이벤트
 			public void actionPerformed(ActionEvent e) {					
 				//pn.setVisible(false);				
 				String num = tf.getText();		 
 				switch(num) {
 				case "1"://영화이름으로 검색시 ViewQuery 클래스의 cont_first 메소드 호출
 					try {
 						pn.setVisible(false);	
						ViewQuery.cont_first();
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
 					break;
			 
 				case "2": //영화사 이름으로 검색시 ViewQuery 클래스의 cont_second 메소드 호출
 					try {
 						pn.setVisible(false);	
						ViewQuery.cont_second();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
 					break;
	      
 			}
 		}});
	 }
	 
	 /*(뷰 이용 쿼리2)배우와 감독에 관심없고 오직 영화만 좋아하는 사용자를 가정한 검색 쿼리*/
	 public static JPanel search_for_onlymovielover() throws SQLException{
		JPanel pn = new JPanel(null);
	    JLabel lb = new JLabel("<html>배우와 감독에 관심이 없으신 분들을 위한 검색기능입니다.<br> 1.영화이름을 이용해 검색 2.관객수를 입력하여 그 이상의 관객수를 달성한 영화 검색<br></html>");
		JTextField tf = new JTextField(20);
		JButton btn = new JButton("확인");
		 
		JButton btn_back = new JButton("이전화면으로");
		btn_back.setFont(new Font("Dialog",Font.BOLD,12));
		btn_back.setBounds(0,0,300,30);
		
		lb.setFont(new Font("Dialog",Font.BOLD,12));
		lb.setBounds(0,30,700,100);
		btn.setBounds(410,110,100,30);
		tf.setBounds(60,110,250,30);
		
		pn.add(lb);
		pn.add(tf);
		pn.add(btn);
		gif.add(pn);
   	 	gif.setVisible(true);
   	 	pn.add(btn_back);

		
		//이전화면으로 버튼을 누를시 처음 화면으로 돌아감
   	 	btn_back.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            pn.setVisible(false);
            (new GuiIntf()).FirstWindow();
         }
      });
		
		
   	 	
   	 
		btn.addActionListener(new ActionListener() { //확인 버튼 클릭시 발생하는 이벤트
			public void actionPerformed(ActionEvent e) {					
					//pn.setVisible(false);
					String num = tf.getText();
			 
				switch(num) {
				case "1"://영화이름으로 검색시 ViewQuery 클래스의 user_first 메소드 호출
					try {
						pn.setVisible(false);	
						ViewQuery.user_first();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
					 
				case "2": //영화사 이름으로 검색시 ViewQuery 클래스의 user_second 메소드 호출
					try {
						pn.setVisible(false);	
						ViewQuery.user_second();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
			 }}
		});
	      return pn;
	   }
	 
	/*영화 이름으로 검색*/
	 public static JPanel search_movie_by_name() throws SQLException{
			JPanel pn = new JPanel(null);
	      try {
	    	  Main.conn.setAutoCommit(false); //Autocommit을 수동으로 전환
	        String query = "SELECT * FROM DB2021_Movies WHERE name=?";
	        PreparedStatement pstmt = Main.conn.prepareStatement(query);
	        
	        JButton btn_back = new JButton("이전화면으로");
			btn_back.setFont(new Font("Dialog",Font.BOLD,12));
			btn_back.setBounds(0,0,300,30);
	         
	        JLabel lb1 = new JLabel("영화 이름을 입력해주세요:");
			JTextField tf1 = new JTextField(20);
			JButton btn1 = new JButton("확인");
			TextArea ta1 = new TextArea();	
			
			creating_tool(lb1, btn1, tf1, ta1);
	         
			btn1.addActionListener(new ActionListener() { //확인 버튼 클릭시 발생하는 이벤트
				public void actionPerformed(ActionEvent e) {
					String temp = tf1.getText();
					try {
						pstmt.setString(1, temp);					
						ResultSet rs = pstmt.executeQuery();
						ta1.append("영화 이름 / 장르 / 러닝타임 / 개봉 날짜 / 배우 / 평점 / 관객 수 / 선호 연령대 / 선호 성별 / 영화사 / 감독 \n");
						while(rs.next()) {			
							 //textArea에 정보를 출력함
							ta1.append(""+rs.getString(1)+" / "+rs.getString(2)+" / "+rs.getInt(3)+" / "+rs.getDate(4)+" / "+rs.getString(5)+" / "+rs.getFloat(6)+" / "+rs.getInt(7)+" / "+rs.getInt(8)+" / "+rs.getString(9)+" / "+rs.getString(10)+" / "+rs.getString(11)+"\n");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			});
			
			//이전화면으로 버튼을 누를시 GuiIntf 클래스의 Panel_searching 화면으로 돌아감
			btn_back.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	               pn.setVisible(false);
	               (new GuiIntf()).Panel_searching();
	            }
	         });
			
			pn.add(btn_back);
			
			pn.add(btn1);
			pn.add(tf1);
			pn.add(lb1);
			pn.add(ta1);
			Main.conn.commit(); ////이상이 없을시 commit	
	      }
	      catch(SQLException se) {
	    	  se.printStackTrace();
				try{
					if(Main.conn!=null)
						Main.conn.rollback(); //오류 발생시 rollback
				}catch(SQLException se2){
					se2.printStackTrace();
				}
	      }
			return pn;
	   }	 
	 /*영화사 이름으로 검색*/
	 public static JPanel search_company_by_name() throws SQLException{
			JPanel pn = new JPanel(null);
	      try {
	    	  Main.conn.setAutoCommit(false); //Autocommit을 수동으로 전환
	        String query = "SELECT * FROM DB2021_Company WHERE film_company=?";
	        PreparedStatement pstmt = Main.conn.prepareStatement(query);
	        
	        JButton btn_back = new JButton("이전화면으로");
			btn_back.setFont(new Font("Dialog",Font.BOLD,12));
			btn_back.setBounds(0,0,300,30);
	        
	        JLabel lb1 = new JLabel("영화사 이름을 입력해주세요:");
	        JTextField tf1 = new JTextField(20);
			JButton btn1 = new JButton("확인");
			TextArea ta1 = new TextArea();	

			creating_tool(lb1, btn1, tf1, ta1);
			
			
				
	         btn1.addActionListener(new ActionListener() { //확인 버튼 클릭시 발생하는 이벤트
					public void actionPerformed(ActionEvent e) {
						String temp = tf1.getText();
						try {
							pstmt.setString(1, temp);					
							ResultSet rs = pstmt.executeQuery();
							ta1.append("영화사 이름 / 분류 / 대표 이름 / 전화번호 / 주소 / 대표영화 \n");
							while(rs.next()) {	
								 //textArea에 정보를 출력함
								ta1.append(""+rs.getString(1)+" / "+rs.getString(2)+" / "+rs.getString(3)+" / "+rs.getString(4)+" / "+rs.getString(5)+" / "+rs.getString(6)+"\n");
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
				});
				
			//이전화면으로 버튼을 누를시 GuiIntf 클래스의 Panel_searching 화면으로 돌아감
	         btn_back.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		               pn.setVisible(false);
		               (new GuiIntf()).Panel_searching();
		            }
		         });
				
				pn.add(btn_back);

	        pn.add(btn1);
			pn.add(tf1);
			pn.add(lb1);
			pn.add(ta1);
			Main.conn.commit(); ////이상이 없을시 commit
	      }
	      catch(SQLException se) {
	    	  se.printStackTrace();
				try{
					if(Main.conn!=null)
						Main.conn.rollback(); //오류 발생시 rollback
				}catch(SQLException se2){
					se2.printStackTrace();
				}
	      }
			return pn;
	   }
	 /*영화사 영화로 검색*/
	 public static JPanel search_company_by_movie() throws SQLException{
			JPanel pn = new JPanel(null);
	      try {
	    	  Main.conn.setAutoCommit(false); //Autocommit을 수동으로 전환
	         String query = "SELECT * FROM DB2021_Company WHERE named_movie=?";
	         PreparedStatement pstmt = Main.conn.prepareStatement(query);
	         
	         JButton btn_back = new JButton("이전화면으로");
			btn_back.setFont(new Font("Dialog",Font.BOLD,12));
			btn_back.setBounds(0,0,300,30);
	         
	         JLabel lb1 = new JLabel("영화사가 제작한 영화를 입력해주세요:");
	         JTextField tf1 = new JTextField(20);
				JButton btn1 = new JButton("확인");
				TextArea ta1 = new TextArea();	

				creating_tool(lb1, btn1, tf1, ta1);
				
				btn1.addActionListener(new ActionListener() { //확인 버튼 클릭시 발생하는 이벤트
					public void actionPerformed(ActionEvent e) {
						String temp = tf1.getText();
						try {
							pstmt.setString(1, temp);					
							ResultSet rs = pstmt.executeQuery();
							ta1.append("영화사 이름 / 분류 / 대표 이름 / 전화번호 / 주소 / 대표영화 \n");
							while(rs.next()) {		
								 //textArea에 정보를 출력함	
								ta1.append(""+rs.getString(1)+" / "+rs.getString(2)+" / "+rs.getString(3)+" / "+rs.getString(4)+" / "+rs.getString(5)+" / "+rs.getString(6)+"\n");
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
				});
				
				//이전화면으로 버튼을 누를시 GuiIntf 클래스의 Panel_searching 화면으로 돌아감
				btn_back.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		               pn.setVisible(false);
		               (new GuiIntf()).Panel_searching();
		            }
		         });
				
				pn.add(btn_back);

	        pn.add(btn1);
			pn.add(tf1);
			pn.add(lb1);
			pn.add(ta1);
			Main.conn.commit(); ////이상이 없을시 commit
	      }
	      catch(SQLException se) {
	    	  se.printStackTrace();
				try{
					if(Main.conn!=null)
						Main.conn.rollback(); //오류 발생시 rollback
				}catch(SQLException se2){
					se2.printStackTrace();
				}
	      }
			return pn;
	   }
	 /*영화제 이름으로 검색*/
	 public static JPanel search_festival_by_name() throws SQLException{
			JPanel pn = new JPanel(null);
	      try {
	    	  Main.conn.setAutoCommit(false); //Autocommit을 수동으로 전환
	         String query = "SELECT * FROM DB2021_Festival WHERE name =?";
	         PreparedStatement pstmt = Main.conn.prepareStatement(query);
	         
	         JButton btn_back = new JButton("이전화면으로");
				btn_back.setFont(new Font("Dialog",Font.BOLD,12));
				btn_back.setBounds(0,0,300,30);
	         
	         JLabel lb1 = new JLabel("영화제 이름을 입력해주세요:");
	         JTextField tf1 = new JTextField(20);
				JButton btn1 = new JButton("확인");
				TextArea ta1 = new TextArea();	
				
				creating_tool(lb1, btn1, tf1, ta1);
	         
	         btn1.addActionListener(new ActionListener() { //확인 버튼 클릭시 발생하는 이벤트
					public void actionPerformed(ActionEvent e) {
						String temp = tf1.getText();
						try {
							pstmt.setString(1, temp);					
							ResultSet rs = pstmt.executeQuery();
							ta1.append("영화제 이름 / 개최 국가 / 개최 도시 / 개최년 \n");
							while(rs.next()) {	
								 //textArea에 정보를 출력함		
								ta1.append(""+rs.getString(1)+" / "+rs.getString(2)+" / "+rs.getString(3)+" / "+rs.getInt(4)+"\n");
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
				});
				
			//이전화면으로 버튼을 누를시 GuiIntf 클래스의 Panel_searching 화면으로 돌아감
	         btn_back.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		               pn.setVisible(false);
		               (new GuiIntf()).Panel_searching();
		            }
		         });
				
				pn.add(btn_back);

	        pn.add(btn1);
			pn.add(tf1);
			pn.add(lb1);
			pn.add(ta1);
			Main.conn.commit(); ////이상이 없을시 commit
	      }
	      catch(SQLException se) {
	    	  se.printStackTrace();
				try{
					if(Main.conn!=null)
						Main.conn.rollback(); //오류 발생시 rollback
				}catch(SQLException se2){
					se2.printStackTrace();
				}
	      }
			return pn;
	   }
	 /*영화제 개최국가로 검색*/
	 public static JPanel search_festival_by_country() throws SQLException{
			JPanel pn = new JPanel(null);
	      try {
	    	  Main.conn.setAutoCommit(false); //Autocommit을 수동으로 전환
	         String query = "SELECT * FROM DB2021_Festival WHERE country =?";
	         PreparedStatement pstmt = Main.conn.prepareStatement(query);
	         
	         JButton btn_back = new JButton("이전화면으로");
				btn_back.setFont(new Font("Dialog",Font.BOLD,12));
				btn_back.setBounds(0,0,300,30);
	         
	         JLabel lb1 = new JLabel("영화제 개최국을 입력해주세요:");	         
	         JTextField tf1 = new JTextField(20);
				JButton btn1 = new JButton("확인");
				TextArea ta1 = new TextArea();	
				
				creating_tool(lb1, btn1, tf1, ta1);
	         
				btn1.addActionListener(new ActionListener() { //확인 버튼 클릭시 발생하는 이벤트
					public void actionPerformed(ActionEvent e) {
						String temp = tf1.getText();
						try {
							pstmt.setString(1, temp);					
							ResultSet rs = pstmt.executeQuery();
							ta1.append("영화제 이름 / 개최 국가 / 개최 도시 / 개최년 \n");
							while(rs.next()) {			
								 //textArea에 정보를 출력함
								ta1.append(""+rs.getString(1)+" / "+rs.getString(2)+" / "+rs.getString(3)+" / "+rs.getInt(4)+"\n");
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
				});
				
				//이전화면으로 버튼을 누를시 GuiIntf 클래스의 Panel_searching 화면으로 돌아감
				btn_back.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		               pn.setVisible(false);
		               (new GuiIntf()).Panel_searching();
		            }
		         });
				
				pn.add(btn_back);
	         
			pn.add(btn1);
			pn.add(tf1);
			pn.add(lb1);
			pn.add(ta1);
			Main.conn.commit(); ////이상이 없을시 commit
	      }
	      catch(SQLException se) {
	    	  se.printStackTrace();
				try{
					if(Main.conn!=null)
						Main.conn.rollback(); //오류 발생시 rollback
				}catch(SQLException se2){
					se2.printStackTrace();
				}
	      }
			return pn;
	   }
	 
	 /*안정민벗*/
             //영화로 영화배우 검색
	 public static JPanel search_actor_by_name() throws SQLException{
		 
			JPanel pn = new JPanel(null);
	      try {
	    	  Main.conn.setAutoCommit(false); //Autocommit을 수동으로 전환
	         String query = "SELECT * FROM DB2021_Actor WHERE name =?";
	         PreparedStatement pstmt = Main.conn.prepareStatement(query);
	         
	         JButton btn_back = new JButton("이전화면으로");
				btn_back.setFont(new Font("Dialog",Font.BOLD,12));
				btn_back.setBounds(0,0,300,30);
	         
	         JLabel lb1 = new JLabel("배우이름을 입력해주세요:");	         
	         JTextField tf1 = new JTextField(20);
				JButton btn1 = new JButton("확인");
				TextArea ta1 = new TextArea();	
				
				creating_tool(lb1, btn1, tf1, ta1);
	         
				btn1.addActionListener(new ActionListener() { //확인 버튼 클릭시 발생하는 이벤트
					public void actionPerformed(ActionEvent e) {
						String temp = tf1.getText();
						try {
							pstmt.setString(1, temp);					
							ResultSet rs = pstmt.executeQuery();
							ta1.append("배우 이름 / 배우 성별 / 배우 생년월일 / 배우 출연작 \n");
							while(rs.next()) {			
								ta1.append(""+rs.getString(1)+" / "+rs.getString(2)+" / "+rs.getDate(3)+" / "+rs.getString(4)+"\n");
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
				});
				
				btn_back.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		               pn.setVisible(false);
		               (new GuiIntf()).Panel_searching();
		            }
		         });
				
				pn.add(btn_back);
	         
			pn.add(btn1);
			pn.add(tf1);
			pn.add(lb1);
			pn.add(ta1);
			Main.conn.commit(); ////이상이 없을시 commit
	      }
	      catch(SQLException se) {
	    	  se.printStackTrace();
				try{
					if(Main.conn!=null)
						Main.conn.rollback(); //오류 발생시 rollback
				}catch(SQLException se2){
					se2.printStackTrace();
				}
	      }
			return pn;
	   }
	 //배우 출연작으로 배우 검색
	 public static JPanel search_actor_by_film() throws SQLException{
		 
			JPanel pn = new JPanel(null);
	      try {
	    	  Main.conn.setAutoCommit(false); //Autocommit을 수동으로 전환
	         String query = "SELECT * FROM DB2021_Actor WHERE film =?";
	         PreparedStatement pstmt = Main.conn.prepareStatement(query);
	         
	         JButton btn_back = new JButton("이전화면으로");
				btn_back.setFont(new Font("Dialog",Font.BOLD,12));
				btn_back.setBounds(0,0,300,30);
	         
	         JLabel lb1 = new JLabel("배우 출연작을 입력해주세요:");	         
	         JTextField tf1 = new JTextField(20);
				JButton btn1 = new JButton("확인");
				TextArea ta1 = new TextArea();	
				
				creating_tool(lb1, btn1, tf1, ta1);
	         
				btn1.addActionListener(new ActionListener() { //확인 버튼 클릭시 발생하는 이벤트
					public void actionPerformed(ActionEvent e) {
						String temp = tf1.getText();
						try {
							pstmt.setString(1, temp);					
							ResultSet rs = pstmt.executeQuery();
							ta1.append("배우 이름 / 배우 성별 / 배우 생년월일 / 배우 출연작 \n");
							while(rs.next()) {			
								ta1.append(""+rs.getString(1)+" / "+rs.getString(2)+" / "+rs.getDate(3)+" / "+rs.getString(4)+"\n");
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
				});
				
				btn_back.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		               pn.setVisible(false);
		               (new GuiIntf()).Panel_searching();
		            }
		         });
				
				pn.add(btn_back);
	         
			pn.add(btn1);
			pn.add(tf1);
			pn.add(lb1);
			pn.add(ta1);
			Main.conn.commit(); ////이상이 없을시 commit
	      }
	      catch(SQLException se) {
	    	  se.printStackTrace();
				try{
					if(Main.conn!=null)
						Main.conn.rollback(); //오류 발생시 rollback
				}catch(SQLException se2){
					se2.printStackTrace();
				}
	      }
			return pn;
	   }
	 //수상한 영화제목으로 영화수상정보 검색
	 public static JPanel search_award_by_film() throws SQLException{
		 
			JPanel pn = new JPanel(null);
	      try {
	    	  Main.conn.setAutoCommit(false); //Autocommit을 수동으로 전환
	         String query = "SELECT * FROM DB2021_Award WHERE film =?";
	         PreparedStatement pstmt = Main.conn.prepareStatement(query);
	         
	         JButton btn_back = new JButton("이전화면으로");
				btn_back.setFont(new Font("Dialog",Font.BOLD,12));
				btn_back.setBounds(0,0,300,30);
	         
	         JLabel lb1 = new JLabel("수상한 영화 이름을 입력해주세요:");	         
	         JTextField tf1 = new JTextField(20);
				JButton btn1 = new JButton("확인");
				TextArea ta1 = new TextArea();	
				
				creating_tool(lb1, btn1, tf1, ta1);
	         
				btn1.addActionListener(new ActionListener() { //확인 버튼 클릭시 발생하는 이벤트
					public void actionPerformed(ActionEvent e) {
						String temp = tf1.getText();
						try {
							pstmt.setString(1, temp);					
							ResultSet rs = pstmt.executeQuery();
							ta1.append("수상 연도 / 영화제 이름 / 출품작 / 감독 \n");
							while(rs.next()) {			
								ta1.append(""+rs.getInt(1)+" / "+rs.getString(2)+" / "+rs.getString(3)+" / "+rs.getString(4)+"\n");
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
				});
				
				btn_back.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		               pn.setVisible(false);
		               (new GuiIntf()).Panel_searching();
		            }
		         });
				
				pn.add(btn_back);
	         
			pn.add(btn1);
			pn.add(tf1);
			pn.add(lb1);
			pn.add(ta1);
			Main.conn.commit(); ////이상이 없을시 commit
	      }
	      catch(SQLException se) {
	    	  se.printStackTrace();
				try{
					if(Main.conn!=null)
						Main.conn.rollback(); //오류 발생시 rollback
				}catch(SQLException se2){
					se2.printStackTrace();
				}
	      }
			return pn;
	   }
	 //수상한 영화 감독으로 수상정보 검색
	 public static JPanel search_award_by_director() throws SQLException{
		 
			JPanel pn = new JPanel(null);
	      try {
	    	  Main.conn.setAutoCommit(false); //Autocommit을 수동으로 전환
	         String query = "SELECT * FROM DB2021_Award WHERE director =?";
	         PreparedStatement pstmt = Main.conn.prepareStatement(query);
	         
	         JButton btn_back = new JButton("이전화면으로");
				btn_back.setFont(new Font("Dialog",Font.BOLD,12));
				btn_back.setBounds(0,0,300,30);
	         
	         JLabel lb1 = new JLabel("수상한 영화의 감독 이름을 입력해주세요:");	         
	         JTextField tf1 = new JTextField(20);
				JButton btn1 = new JButton("확인");
				TextArea ta1 = new TextArea();	
				
				creating_tool(lb1, btn1, tf1, ta1);
	         
				btn1.addActionListener(new ActionListener() { //확인 버튼 클릭시 발생하는 이벤트
					public void actionPerformed(ActionEvent e) {
						String temp = tf1.getText();
						try {
							pstmt.setString(1, temp);					
							ResultSet rs = pstmt.executeQuery();
							ta1.append("수상 연도 / 영화제 이름 / 출품작 / 감독 \n");
							while(rs.next()) {			
								ta1.append(""+rs.getInt(1)+" / "+rs.getString(2)+" / "+rs.getString(3)+" / "+rs.getString(4)+"\n");
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
				});
				
				btn_back.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		               pn.setVisible(false);
		               (new GuiIntf()).Panel_searching();
		            }
		         });
				
				pn.add(btn_back);
	         
			pn.add(btn1);
			pn.add(tf1);
			pn.add(lb1);
			pn.add(ta1);
			Main.conn.commit(); ////이상이 없을시 commit
	      }
	      catch(SQLException se) {
	    	  se.printStackTrace();
				try{
					if(Main.conn!=null)
						Main.conn.rollback(); //오류 발생시 rollback
				}catch(SQLException se2){
					se2.printStackTrace();
				}
	      }
			return pn;
	   }
}