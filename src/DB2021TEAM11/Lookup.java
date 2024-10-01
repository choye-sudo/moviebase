package DB2021TEAM11;

import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Lookup extends JFrame{
	static GuiIntf gif = new GuiIntf();
	/*박지은벗*/
	public static void creating_tool(JLabel lb, JButton btn, JTextField tf, TextArea ta) { //label과 button, textfield, textarea의 디폴트 구조를 만들어주는 메소드
		lb.setFont(new Font("Dialog",Font.BOLD,15));
		lb.setBounds(60,40,700,100);
		btn.setBounds(510,110,100,30);
		tf.setBounds(60,110,250,30);						
		ta.setBounds(60,160,550,300);
	}
	
	//특정 조건으로 검색하는 쿼리들	
	public static JPanel search_example_1() throws SQLException{
		JPanel pn = new JPanel(null);
	      try {
	    	 Main.conn.setAutoCommit(false); //Autocommit을 수동으로 전환
	         String query = "select name from DB2021_Movies where date_format(release_date, '%Y')>2016";
	         PreparedStatement pstmt = Main.conn.prepareStatement(query);
	         
	         JButton btn_back = new JButton("이전화면으로");
				btn_back.setFont(new Font("Dialog",Font.BOLD,12));
				btn_back.setBounds(0,0,300,30);
	         
				JButton btn1 = new JButton("출력");
				TextArea ta1 = new TextArea();	
				
				btn1.setBounds(510,110,100,30);
				ta1.setBounds(60,160,550,300);
	         
				btn1.addActionListener(new ActionListener() { //출력 버튼 클릭시 발생하는 이벤트
					public void actionPerformed(ActionEvent e) {
						try {				
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

				//이전화면으로 버튼을 누를시 GuiIntf 클래스의 Panel_looking 화면으로 돌아감
				btn_back.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		               pn.setVisible(false);
		               (new GuiIntf()).Panel_looking();
		            }
		         });

		pn.add(btn_back);

			pn.add(btn1);
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
			
			public static JPanel search_example_2() throws SQLException{
				JPanel pn = new JPanel(null);
			      try {
			    	  Main.conn.setAutoCommit(false); //Autocommit을 수동으로 전환
			         String query = "select name from DB2021_Movies where actor = \"Song Gangho\" and director = \"Bong Joonho\"";
			         PreparedStatement pstmt = Main.conn.prepareStatement(query);
			         
			         JButton btn_back = new JButton("이전화면으로");
						btn_back.setFont(new Font("Dialog",Font.BOLD,12));
						btn_back.setBounds(0,0,300,30);
			         
						JButton btn1 = new JButton("출력");
						TextArea ta1 = new TextArea();	
						
						btn1.setBounds(510,110,100,30);
						ta1.setBounds(60,160,550,300);
			         
						btn1.addActionListener(new ActionListener() { //출력 버튼 클릭시 발생하는 이벤트
							public void actionPerformed(ActionEvent e) {
								try {				
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

						//이전화면으로 버튼을 누를시 GuiIntf 클래스의 Panel_looking 화면으로 돌아감
						btn_back.addActionListener(new ActionListener() {
				            public void actionPerformed(ActionEvent e) {
				               pn.setVisible(false);
				               (new GuiIntf()).Panel_looking();
				            }
				         });

				pn.add(btn_back);

					pn.add(btn1);
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
			
			public static JPanel search_example_3() throws SQLException{
				JPanel pn = new JPanel(null);
			      try {
			    	  Main.conn.setAutoCommit(false); //Autocommit을 수동으로 전환
			         String query = "select name from DB2021_Festival having min(begin_year)";
			         PreparedStatement pstmt = Main.conn.prepareStatement(query);
			         
			         JButton btn_back = new JButton("이전화면으로");
						btn_back.setFont(new Font("Dialog",Font.BOLD,12));
						btn_back.setBounds(0,0,300,30);
			         
						JButton btn1 = new JButton("출력");
						TextArea ta1 = new TextArea();	
						
						btn1.setBounds(510,110,100,30);
						ta1.setBounds(60,160,550,300);
			         
						btn1.addActionListener(new ActionListener() { //출력 버튼 클릭시 발생하는 이벤트
							public void actionPerformed(ActionEvent e) {
								try {				
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

						//이전화면으로 버튼을 누를시 GuiIntf 클래스의 Panel_looking 화면으로 돌아감
						btn_back.addActionListener(new ActionListener() {
				            public void actionPerformed(ActionEvent e) {
				               pn.setVisible(false);
				               (new GuiIntf()).Panel_looking();
				            }
				         });

					pn.add(btn_back);

					pn.add(btn1);
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
			
			public static JPanel search_example_4() throws SQLException{
				JPanel pn = new JPanel(null);
			      try {
			    	  Main.conn.setAutoCommit(false); //Autocommit을 수동으로 전환
			         String query = "select birth from DB2021_Actor where gender = \"FEMALE\"";
			         PreparedStatement pstmt = Main.conn.prepareStatement(query);
			         
			         JButton btn_back = new JButton("이전화면으로");
						btn_back.setFont(new Font("Dialog",Font.BOLD,12));
						btn_back.setBounds(0,0,300,30);
			         
						JButton btn1 = new JButton("출력");
						TextArea ta1 = new TextArea();	
						
						btn1.setBounds(510,110,100,30);
						ta1.setBounds(60,160,550,300);
			         
						btn1.addActionListener(new ActionListener() { //출력 버튼 클릭시 발생하는 이벤트
							public void actionPerformed(ActionEvent e) {
								try {				
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

						//이전화면으로 버튼을 누를시 GuiIntf 클래스의 Panel_looking 화면으로 돌아감
						btn_back.addActionListener(new ActionListener() {
				            public void actionPerformed(ActionEvent e) {
				               pn.setVisible(false);
				               (new GuiIntf()).Panel_looking();
				            }
				         });

				pn.add(btn_back);

					pn.add(btn1);
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
			
			public static JPanel search_example_5() throws SQLException{
				JPanel pn = new JPanel(null);
			      try {
			    	  Main.conn.setAutoCommit(false); //Autocommit을 수동으로 전환
			         String query = "select distinct festival_name from DB2021_Award where director = \"Bong Joonho\"";
			         PreparedStatement pstmt = Main.conn.prepareStatement(query);
			         
			         JButton btn_back = new JButton("이전화면으로");
						btn_back.setFont(new Font("Dialog",Font.BOLD,12));
						btn_back.setBounds(0,0,300,30);
			         
						JButton btn1 = new JButton("출력");
						TextArea ta1 = new TextArea();	
						btn1.setBounds(510,110,100,30);
						ta1.setBounds(60,160,550,300);
			         
						btn1.addActionListener(new ActionListener() { //출력 버튼 클릭시 발생하는 이벤트
							public void actionPerformed(ActionEvent e) {
								try {				
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

						//이전화면으로 버튼을 누를시 GuiIntf 클래스의 Panel_looking 화면으로 돌아감
						btn_back.addActionListener(new ActionListener() {
				            public void actionPerformed(ActionEvent e) {
				               pn.setVisible(false);
				               (new GuiIntf()).Panel_looking();
				            }
				         });

				pn.add(btn_back);

					pn.add(btn1);
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
	
	/*상을 가장 많이 탄 감독 출력*/
	 public static JPanel the_most_prized_director() throws SQLException{
			JPanel pn = new JPanel(null);
	      try {
	    	  Main.conn.setAutoCommit(false); //Autocommit을 수동으로 전환
	         String query = "SELECT * FROM (SELECT director, count(director)AS num_of_prize FROM DB2021_Award GROUP BY director) AS D ORDER BY director LIMIT 1;";
	         PreparedStatement pstmt = Main.conn.prepareStatement(query);
	         
	         JButton btn_back = new JButton("이전화면으로");
				btn_back.setFont(new Font("Dialog",Font.BOLD,12));
				btn_back.setBounds(0,0,300,30);
	         
				JButton btn1 = new JButton("출력");
				TextArea ta1 = new TextArea();	
				
				btn1.setBounds(510,110,100,30);
				ta1.setBounds(60,160,550,300);
	         
				btn1.addActionListener(new ActionListener() { //출력 버튼 클릭시 발생하는 이벤트
					public void actionPerformed(ActionEvent e) {
						try {				
							ResultSet rs = pstmt.executeQuery();
							ta1.append("감독 이름 / 상을 탄 횟수 \n");
							while(rs.next()) {			
								ta1.append(""+rs.getString(1)+" / "+rs.getInt(2)+"\n"); //textArea에 정보를 출력함
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}					
					}
				});

				//이전화면으로 버튼을 누를시 GuiIntf 클래스의 Panel_looking 화면으로 돌아감
				btn_back.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		               pn.setVisible(false);
		               (new GuiIntf()).Panel_looking();
		            }
		         });

		pn.add(btn_back);

			pn.add(btn1);
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
	 /*천만 관객을 돌파한 영화의 감독과 영화제작사 출력*/
	 public static JPanel over_10_million_attendance_director_company() throws SQLException{
			JPanel pn = new JPanel(null);
	      try {
	    	  Main.conn.setAutoCommit(false); //Autocommit을 수동으로 전환
	         String query = "SELECT DB2021_Movies.name,DB2021_Movies.director,DB2021_Movies.attendance,DB2021_Company.film_company FROM DB2021_Movies INNER JOIN DB2021_Company ON DB2021_Movies.name = DB2021_Company.named_movie AND DB2021_Movies.attendance>10000000;";
	         PreparedStatement pstmt = Main.conn.prepareStatement(query);
	         
	         JButton btn_back = new JButton("이전화면으로");
				btn_back.setFont(new Font("Dialog",Font.BOLD,12));
				btn_back.setBounds(0,0,300,30);
	         
	         JButton btn1 = new JButton("출력");
				TextArea ta1 = new TextArea();	
				
				btn1.setBounds(510,110,100,30);
				ta1.setBounds(60,160,550,300);
	         
				btn1.addActionListener(new ActionListener() { //출력 버튼 클릭시 발생하는 이벤트
					public void actionPerformed(ActionEvent e) {
						try {				
							ResultSet rs = pstmt.executeQuery();
							ta1.append("영화 이름 / 감독 이름 / 관객수 / 영화사 이름 \n");
							while(rs.next()) {			
								ta1.append(""+rs.getString(1)+" / "+rs.getString(2)+" / "+rs.getInt(3)+" / "+rs.getString(4)+"\n"); //textArea에 정보를 출력함
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}					
					}
				});
				
				//이전화면으로 버튼을 누를시 GuiIntf 클래스의 Panel_looking 화면으로 돌아감
				btn_back.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		               pn.setVisible(false);
		               (new GuiIntf()).Panel_looking();
		            }
		         });

		pn.add(btn_back);

	        pn.add(btn1);
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
             //선호나이대(10,20,30대)가 낮은 순서대로 영화 정보 출력
	 public static JPanel select_db1() throws SQLException{
			JPanel pn = new JPanel(null);
		      try {
		    	 Main.conn.setAutoCommit(false); //Autocommit을 수동으로 전환
		         String query = "SELECT name, genre, running_time, release_date, actor, rating, attendance, prefered_age, prefered_gender, film_company, director from DB2021_Movies order by prefered_age";
		         PreparedStatement pstmt = Main.conn.prepareStatement(query);
		         
		         JButton btn_back = new JButton("이전화면으로");
					btn_back.setFont(new Font("Dialog",Font.BOLD,12));
					btn_back.setBounds(0,0,300,30);
		         
					JButton btn1 = new JButton("출력");
					TextArea ta1 = new TextArea();	
					
					btn1.setBounds(510,110,100,30);
					ta1.setBounds(60,160,550,300);
		         
					btn1.addActionListener(new ActionListener() { //출력 버튼 클릭시 발생하는 이벤트
						public void actionPerformed(ActionEvent e) {
							try {				
								ResultSet rs = pstmt.executeQuery();
								ta1.append("   제목    /  장르    /   상영시간   /   개봉날짜   /    배우   /    평점   /    관객수   /   선호나이대  /   선호성별   /   영화사  /  감독 \n ");
								while(rs.next()) {
									ta1.append(""+rs.getString(1)+" / "+rs.getString(2)+" / "+rs.getInt(3)+" / "+rs.getDate(4)+" / "+rs.getString(5)+" / "+rs.getInt(6)+" / "+rs.getInt(7)+" / "+rs.getInt(8)+" / "+rs.getString(9)+" / "+rs.getString(10)+" / "+rs.getString(11)+"\n\n");
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
			               (new GuiIntf()).Panel_looking();
			            }
			         });

			pn.add(btn_back);

				pn.add(btn1);
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

	 //평점이 9점이상인 영화 정보를 평점이 높은 순서대로 출력
	 public static JPanel select_db2() throws SQLException{
			JPanel pn = new JPanel(null);
		      try {
		    	 Main.conn.setAutoCommit(false); //Autocommit을 수동으로 전환
		         String query = "SELECT name, genre, running_time, release_date, actor, rating, attendance, prefered_age, prefered_gender, film_company, director from DB2021_Movies where DB2021_Movies.rating>=9 order by rating desc";
		         PreparedStatement pstmt = Main.conn.prepareStatement(query);
		         
		         JButton btn_back = new JButton("이전화면으로");
					btn_back.setFont(new Font("Dialog",Font.BOLD,12));
					btn_back.setBounds(0,0,300,30);
		         
					JButton btn1 = new JButton("출력");
					TextArea ta1 = new TextArea();	
					
					btn1.setBounds(510,110,100,30);
					ta1.setBounds(60,160,550,300);
		         
					btn1.addActionListener(new ActionListener() { //출력 버튼 클릭시 발생하는 이벤트
						public void actionPerformed(ActionEvent e) {
							try {				
								ResultSet rs = pstmt.executeQuery();
								ta1.append("   제목    /  장르    /   상영시간   /   개봉날짜   /    배우   /    평점   /    관객수   /   선호나이대  /   선호성별   /   영화사  /  감독 \n ");
								while(rs.next()) {
									ta1.append(""+rs.getString(1)+" / "+rs.getString(2)+" / "+rs.getInt(3)+" / "+rs.getDate(4)+" / "+rs.getString(5)+" / "+rs.getFloat(6)+" / "+rs.getInt(7)+" / "+rs.getInt(8)+" / "+rs.getString(9)+" / "+rs.getString(10)+" / "+rs.getString(11)+"\n\n");
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
			               (new GuiIntf()).Panel_looking();
			            }
			         });

			pn.add(btn_back);

				pn.add(btn1);
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

	 //전지현이 출연한 영화가 상을 받은 영화제 출력
	 public static JPanel select_db3() throws SQLException{
			JPanel pn = new JPanel(null);
		      try {
		    	 Main.conn.setAutoCommit(false); //Autocommit을 수동으로 전환
		         String query = "select festival_name from DB2021_Award as A where A.film= ( select film from DB2021_Actor as Actor where Actor.name='Jeon Jihyun')";
		         PreparedStatement pstmt = Main.conn.prepareStatement(query);
		         
		         JButton btn_back = new JButton("이전화면으로");
					btn_back.setFont(new Font("Dialog",Font.BOLD,12));
					btn_back.setBounds(0,0,300,30);
		         
					JButton btn1 = new JButton("출력");
					TextArea ta1 = new TextArea();	
					
					btn1.setBounds(510,110,100,30);
					ta1.setBounds(60,160,550,300);
		         
					btn1.addActionListener(new ActionListener() { //출력 버튼 클릭시 발생하는 이벤트
						public void actionPerformed(ActionEvent e) {
							try {				
								ResultSet rs = pstmt.executeQuery();
								ta1.append("영화제 이름: ");
								while(rs.next()) {
									ta1.append(""+rs.getString(1)+ " / " +"");
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
			               (new GuiIntf()).Panel_looking();
			            }
			         });

			pn.add(btn_back);

				pn.add(btn1);
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

	 //해외영화제에서 상을 받은 영화 출력
	 public static JPanel select_db4() throws SQLException{
			JPanel pn = new JPanel(null);
		      try {
		    	 Main.conn.setAutoCommit(false); //Autocommit을 수동으로 전환
		         String query = "select distinct film from DB2021_Award as A where A.festival_name not in (select name from DB2021_Festival as F where F.country='Korea')";
		         PreparedStatement pstmt = Main.conn.prepareStatement(query);
		         
		         JButton btn_back = new JButton("이전화면으로");
					btn_back.setFont(new Font("Dialog",Font.BOLD,12));
					btn_back.setBounds(0,0,300,30);
		         
					JButton btn1 = new JButton("출력");
					TextArea ta1 = new TextArea();	
					
					btn1.setBounds(510,110,100,30);
					ta1.setBounds(60,160,550,300);
		         
					btn1.addActionListener(new ActionListener() { //출력 버튼 클릭시 발생하는 이벤트
						public void actionPerformed(ActionEvent e) {
							try {				
								ResultSet rs = pstmt.executeQuery();
								ta1.append("영화 제목: ");
								while(rs.next()) {
									ta1.append(""+rs.getString(1)+" / "+"");
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
			               (new GuiIntf()).Panel_looking();
			            }
			         });

			pn.add(btn_back);

				pn.add(btn1);
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
	 //전체 관객수 평균보다 많은 영화를 장르별로 영화제목 출력
	 public static JPanel select_db5() throws SQLException{
			JPanel pn = new JPanel(null);
		      try {
		    	 Main.conn.setAutoCommit(false); //Autocommit을 수동으로 전환
		         String query = "select genre, name from  DB2021_Movies as M where M.attendance> (select avg(attendance) from  DB2021_Movies ) group by genre";
		         PreparedStatement pstmt = Main.conn.prepareStatement(query);
		         
		         JButton btn_back = new JButton("이전화면으로");
					btn_back.setFont(new Font("Dialog",Font.BOLD,12));
					btn_back.setBounds(0,0,300,30);
		         
					JButton btn1 = new JButton("출력");
					TextArea ta1 = new TextArea();	
					
					btn1.setBounds(510,110,100,30);
					ta1.setBounds(60,160,550,300);
		         
					btn1.addActionListener(new ActionListener() { //출력 버튼 클릭시 발생하는 이벤트
						public void actionPerformed(ActionEvent e) {
							try {				
								ResultSet rs = pstmt.executeQuery();
								ta1.append("  장르   /   제목   \n");
								while(rs.next()) {
									ta1.append(""+rs.getString(1)+" / "+rs.getString(2)+"\n");
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
			               (new GuiIntf()).Panel_looking();
			            }
			         });

			pn.add(btn_back);

				pn.add(btn1);
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
	 //2000년대부터 2010년대까지 개봉한 영화의 제목과 개봉날짜를 날짜 순서대로 출력
	 public static JPanel select_db6() throws SQLException{
			JPanel pn = new JPanel(null);
		      try {
		    	 Main.conn.setAutoCommit(false); //Autocommit을 수동으로 전환
		         String query = "select name,release_date from  DB2021_Movies where release_date between '2000-01-01' and '2010-12-31'order by release_date";
		         PreparedStatement pstmt = Main.conn.prepareStatement(query);
		         
		         JButton btn_back = new JButton("이전화면으로");
					btn_back.setFont(new Font("Dialog",Font.BOLD,12));
					btn_back.setBounds(0,0,300,30);
		         
					JButton btn1 = new JButton("출력");
					TextArea ta1 = new TextArea();	
					
					btn1.setBounds(510,110,100,30);
					ta1.setBounds(60,160,550,300);
		         
					btn1.addActionListener(new ActionListener() { //출력 버튼 클릭시 발생하는 이벤트
						public void actionPerformed(ActionEvent e) {
							try {				
								ResultSet rs = pstmt.executeQuery();
								ta1.append("  제목  :  개봉날짜   \n");
								while(rs.next()) {
									ta1.append(""+rs.getString(1) +" : "+rs.getString(2)+"\n");
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
			               (new GuiIntf()).Panel_looking();
			            }
			         });

			pn.add(btn_back);

				pn.add(btn1);
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
	 //영화 정보 데이터베이스 출력
	 public static JPanel show_table_movie() throws SQLException{
			JPanel pn = new JPanel(null);
		      try {
		    	 Main.conn.setAutoCommit(false); //Autocommit을 수동으로 전환
		         String query = "SELECT * FROM DB2021_Movies";
		         PreparedStatement pstmt = Main.conn.prepareStatement(query);
		         
		         JButton btn_back = new JButton("이전화면으로");
					btn_back.setFont(new Font("Dialog",Font.BOLD,12));
					btn_back.setBounds(0,0,300,30);
		         
					JButton btn1 = new JButton("출력");
					TextArea ta1 = new TextArea();	
					
					btn1.setBounds(510,110,100,30);
					ta1.setBounds(60,160,550,300);
		         
					btn1.addActionListener(new ActionListener() { //출력 버튼 클릭시 발생하는 이벤트
						public void actionPerformed(ActionEvent e) {
							try {				
								ResultSet rs = pstmt.executeQuery();
								ta1.append("영화 이름 / 장르 / 러닝타임 / 개봉 날짜 / 배우 / 평점 / 관객 수 / 선호 연령대 / 선호 성별 / 영화사 / 감독 \n");
								while(rs.next()) {
									ta1.append(""+rs.getString(1)+" / "+rs.getString(2)+" / "+rs.getInt(3)+" / "+rs.getDate(4)+" / "+rs.getString(5)+" / "+rs.getFloat(6)+" / "+rs.getInt(7)+" / "+rs.getInt(8)+" / "+rs.getString(9)+" / "+rs.getString(10)+" / "+rs.getString(11)+"\n");
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
			               (new GuiIntf()).Panel_looking();
			            }
			         });

			pn.add(btn_back);

				pn.add(btn1);
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
	 //영화사 정보 데이터베이스 출력
	 public static JPanel show_table_company() throws SQLException{
			JPanel pn = new JPanel(null);
		      try {
		    	 Main.conn.setAutoCommit(false); //Autocommit을 수동으로 전환
		         String query = "SELECT * FROM DB2021_Company";
		         PreparedStatement pstmt = Main.conn.prepareStatement(query);
		         
		         JButton btn_back = new JButton("이전화면으로");
					btn_back.setFont(new Font("Dialog",Font.BOLD,12));
					btn_back.setBounds(0,0,300,30);
		         
					JButton btn1 = new JButton("출력");
					TextArea ta1 = new TextArea();	
					
					btn1.setBounds(510,110,100,30);
					ta1.setBounds(60,160,550,300);
		         
					btn1.addActionListener(new ActionListener() { //출력 버튼 클릭시 발생하는 이벤트
						public void actionPerformed(ActionEvent e) {
							try {				
								ResultSet rs = pstmt.executeQuery();
								ta1.append("영화사 이름 / 분류 / 대표이름 / 회사전화번호 / 주소(도시) / 대표영화 \n");
								while(rs.next()) {
									ta1.append(""+rs.getString(1)+" / "+rs.getString(2)+" / "+rs.getString(3)+" / "+rs.getString(4)+" / "+rs.getString(5)+" / "+rs.getString(6)+"\n");
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
			               (new GuiIntf()).Panel_looking();
			            }
			         });

			pn.add(btn_back);

				pn.add(btn1);
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
	 //영화제 정보 데이터베이스 출력
	 public static JPanel show_table_festival() throws SQLException{
			JPanel pn = new JPanel(null);
		      try {
		    	 Main.conn.setAutoCommit(false); //Autocommit을 수동으로 전환
		         String query = "SELECT * FROM DB2021_Festival";
		         PreparedStatement pstmt = Main.conn.prepareStatement(query);
		         
		         JButton btn_back = new JButton("이전화면으로");
					btn_back.setFont(new Font("Dialog",Font.BOLD,12));
					btn_back.setBounds(0,0,300,30);
		         
					JButton btn1 = new JButton("출력");
					TextArea ta1 = new TextArea();	
					
					btn1.setBounds(510,110,100,30);
					ta1.setBounds(60,160,550,300);
		         
					btn1.addActionListener(new ActionListener() { //출력 버튼 클릭시 발생하는 이벤트
						public void actionPerformed(ActionEvent e) {
							try {				
								ResultSet rs = pstmt.executeQuery();
								ta1.append("영화제 이름 / 개최국가 / 개최장소(도시) / 최초개막년 \n");
								while(rs.next()) {
									ta1.append(""+rs.getString(1)+" / "+rs.getString(2)+" / "+rs.getString(3)+" / "+rs.getInt(4)+"\n");
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
			               (new GuiIntf()).Panel_looking();
			            }
			         });

			pn.add(btn_back);

				pn.add(btn1);
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
	 //영화배우 정보 데이터베이스 출력
	 public static JPanel show_table_actor() throws SQLException{
			JPanel pn = new JPanel(null);
		      try {
		    	 Main.conn.setAutoCommit(false); //Autocommit을 수동으로 전환
		         String query = "SELECT * FROM DB2021_Actor";
		         PreparedStatement pstmt = Main.conn.prepareStatement(query);
		         
		         JButton btn_back = new JButton("이전화면으로");
					btn_back.setFont(new Font("Dialog",Font.BOLD,12));
					btn_back.setBounds(0,0,300,30);
		         
					JButton btn1 = new JButton("출력");
					TextArea ta1 = new TextArea();	
					
					btn1.setBounds(510,110,100,30);
					ta1.setBounds(60,160,550,300);
		         
					btn1.addActionListener(new ActionListener() { //출력 버튼 클릭시 발생하는 이벤트
						public void actionPerformed(ActionEvent e) {
							try {				
								ResultSet rs = pstmt.executeQuery();
								ta1.append("이름 / 성별 / 생년월일 / 출연영화 \n");
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
			               (new GuiIntf()).Panel_looking();
			            }
			         });

			pn.add(btn_back);

				pn.add(btn1);
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
	 //영화 수상정보 데이터베이스 출력
	 public static JPanel show_table_award() throws SQLException{
			JPanel pn = new JPanel(null);
		      try {
		    	 Main.conn.setAutoCommit(false); //Autocommit을 수동으로 전환
		         String query = "SELECT * FROM DB2021_Award";
		         PreparedStatement pstmt = Main.conn.prepareStatement(query);
		         
		         JButton btn_back = new JButton("이전화면으로");
					btn_back.setFont(new Font("Dialog",Font.BOLD,12));
					btn_back.setBounds(0,0,300,30);
		         
					JButton btn1 = new JButton("출력");
					TextArea ta1 = new TextArea();	
					
					btn1.setBounds(510,110,100,30);
					ta1.setBounds(60,160,550,300);
		         
					btn1.addActionListener(new ActionListener() { //출력 버튼 클릭시 발생하는 이벤트
						public void actionPerformed(ActionEvent e) {
							try {				
								ResultSet rs = pstmt.executeQuery();
								ta1.append("수상연도 / 영화제 이름 / 출품작 / 감독 \n");
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
			               (new GuiIntf()).Panel_looking();
			            }
			         });

			pn.add(btn_back);

				pn.add(btn1);
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

		


