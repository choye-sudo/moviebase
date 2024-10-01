package DB2021TEAM11;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Search extends JFrame{
	static GuiIntf gif = new GuiIntf();
	
	/*��������*/
	public static void creating_tool(JLabel lb, JButton btn, JTextField tf, TextArea ta) {
		lb.setFont(new Font("Dialog",Font.BOLD,15));
		lb.setBounds(60,40,700,100);
		btn.setBounds(510,110,100,30);
		tf.setBounds(60,110,250,30);						
		ta.setBounds(60,160,550,300);
	}
	
	//�帣�� ��ȭ �˻�
	public static JPanel search_movie_by_genre() throws SQLException{
		JPanel pn = new JPanel(null);
		try {
			Main.conn.setAutoCommit(false); //Autocommit�� �������� ��ȯ
			String query = "SELECT name FROM DB2021_Movies WHERE genre=?";
			PreparedStatement pstmt = Main.conn.prepareStatement(query);
			
			JButton btn_back = new JButton("����ȭ������");
			btn_back.setFont(new Font("Dialog",Font.BOLD,12));
			btn_back.setBounds(0,0,300,30);
			
			JLabel lb1 = new JLabel("� �帣�� ��ȭ�� �˻��ұ��?");				
			JTextField tf1 = new JTextField(20);
			JButton btn1 = new JButton("Ȯ��");
			TextArea ta1 = new TextArea();	
				
			creating_tool(lb1, btn1, tf1, ta1);
				
			btn1.addActionListener(new ActionListener() { //Ȯ�� ��ư Ŭ���� �߻��ϴ� �̺�Ʈ
				public void actionPerformed(ActionEvent e) {
					String temp = tf1.getText();
					try {
						pstmt.setString(1, temp);
						
						ResultSet rs = pstmt.executeQuery();
						while(rs.next()) {
							ta1.append("��: "+rs.getString(1)+"\n"); //textArea�� ������ �����
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
						
				}
			});
			
			//����ȭ������ ��ư�� ������ GuiIntf Ŭ������ Panel_searching ȭ������ ���ư�
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
			Main.conn.commit(); ////�̻��� ������ commit	
		}
		catch(SQLException se) {
			se.printStackTrace();
			try{
				if(Main.conn!=null)
					Main.conn.rollback(); //���� �߻��� rollback
			}catch(SQLException se2){
				se2.printStackTrace();
			}
		}
		return pn;
	}

	//��ȭ�� �̸����� ��ȭ �˻�
	public static JPanel search_movie_by_festival() throws SQLException{
			JPanel pn = new JPanel(null);
			try {
				Main.conn.setAutoCommit(false); //Autocommit�� �������� ��ȯ
				String query = "SELECT film FROM DB2021_Award WHERE festival_name=?";
				PreparedStatement pstmt = Main.conn.prepareStatement(query);
				
				JButton btn_back = new JButton("����ȭ������");
				btn_back.setFont(new Font("Dialog",Font.BOLD,12));
				btn_back.setBounds(0,0,300,30);
				
				JLabel lb1 = new JLabel("� ��ȭ������ ������ ��ȭ�� �˻��ұ��?");
				JTextField tf1 = new JTextField(20);
				JButton btn1 = new JButton("Ȯ��");
				TextArea ta1 = new TextArea();	
				
				creating_tool(lb1, btn1, tf1, ta1);
				
				btn1.addActionListener(new ActionListener() { //Ȯ�� ��ư Ŭ���� �߻��ϴ� �̺�Ʈ
					public void actionPerformed(ActionEvent e) {
						String temp = tf1.getText();
						try {
							pstmt.setString(1, temp);
						
							ResultSet rs = pstmt.executeQuery();
							while(rs.next()) {
								ta1.append("��: "+rs.getString(1)+"\n"); //textArea�� ������ �����
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
				});
				
				//����ȭ������ ��ư�� ������ GuiIntf Ŭ������ Panel_searching ȭ������ ���ư�
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
				Main.conn.commit(); ////�̻��� ������ commit
			}
			catch(SQLException se) {
				se.printStackTrace();
				try{
					if(Main.conn!=null)
						Main.conn.rollback(); //���� �߻��� rollback
				}catch(SQLException se2){
					se2.printStackTrace();
				}
			}
			return pn;
		}
		
	//��� �̸����� ��ȭ �˻�
	public static JPanel search_movie_by_actor() throws SQLException{
			JPanel pn = new JPanel(null);
			try {
				Main.conn.setAutoCommit(false); //Autocommit�� �������� ��ȯ
				String query = "SELECT name FROM DB2021_Movies WHERE actor=?";
				PreparedStatement pstmt = Main.conn.prepareStatement(query);
				
				JButton btn_back = new JButton("����ȭ������");
				btn_back.setFont(new Font("Dialog",Font.BOLD,12));
				btn_back.setBounds(0,0,300,30);
				
				JLabel lb1 = new JLabel("� ����� ��ȭ�� �˻��ұ��?");
				JTextField tf1 = new JTextField(20);
				JButton btn1 = new JButton("Ȯ��");
				TextArea ta1 = new TextArea();	
				creating_tool(lb1, btn1, tf1, ta1);
				
				btn1.addActionListener(new ActionListener() { //Ȯ�� ��ư Ŭ���� �߻��ϴ� �̺�Ʈ
					public void actionPerformed(ActionEvent e) {
						String temp = tf1.getText();
						try {
							pstmt.setString(1, temp);
						
							ResultSet rs = pstmt.executeQuery();
							while(rs.next()) {
								ta1.append("��: "+rs.getString(1)+"\n"); //textArea�� ������ �����
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
				});
				
				//����ȭ������ ��ư�� ������ GuiIntf Ŭ������ Panel_searching ȭ������ ���ư�
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
				Main.conn.commit(); ////�̻��� ������ commit				
			}
			catch(SQLException se){
				se.printStackTrace();
				try{
					if(Main.conn!=null)
						Main.conn.rollback(); //���� �߻��� rollback
				}catch(SQLException se2){
					se2.printStackTrace();
				}
			}			
			return pn;
		}
	
	/*(�� �̿� ����1)��ȭ +��ȭ�� �˻�:��ȭ�翡 �����ϰ��� �ϴ� ����ڶ�� ����*/
	 public static void search_want_contact() throws SQLException{	
		JPanel pn = new JPanel(null);
	    JLabel lb1 = new JLabel("<html>�����ϰ��� �ϴ� ��ȭ�� ������ �ΰ��� �׸� �� ��� �˻��� �� �ֽ��ϴ�.<br> 1.��ȭ �̸� 2.��ȭ�� �̸�<br></html>");
	    JTextField tf = new JTextField(20);
		JButton btn = new JButton("Ȯ��");
		 
		JButton btn_back = new JButton("����ȭ������");
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

			
		//����ȭ������ ��ư�� ������ ó�� ȭ������ ���ư�
    	 btn_back.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	               pn.setVisible(false);
	               (new GuiIntf()).FirstWindow();
	            }
	         });
			
			
    	 
    	 btn.addActionListener(new ActionListener() { //Ȯ�� ��ư Ŭ���� �߻��ϴ� �̺�Ʈ
 			public void actionPerformed(ActionEvent e) {					
 				//pn.setVisible(false);				
 				String num = tf.getText();		 
 				switch(num) {
 				case "1"://��ȭ�̸����� �˻��� ViewQuery Ŭ������ cont_first �޼ҵ� ȣ��
 					try {
 						pn.setVisible(false);	
						ViewQuery.cont_first();
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
 					break;
			 
 				case "2": //��ȭ�� �̸����� �˻��� ViewQuery Ŭ������ cont_second �޼ҵ� ȣ��
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
	 
	 /*(�� �̿� ����2)���� ������ ���ɾ��� ���� ��ȭ�� �����ϴ� ����ڸ� ������ �˻� ����*/
	 public static JPanel search_for_onlymovielover() throws SQLException{
		JPanel pn = new JPanel(null);
	    JLabel lb = new JLabel("<html>���� ������ ������ ������ �е��� ���� �˻�����Դϴ�.<br> 1.��ȭ�̸��� �̿��� �˻� 2.�������� �Է��Ͽ� �� �̻��� �������� �޼��� ��ȭ �˻�<br></html>");
		JTextField tf = new JTextField(20);
		JButton btn = new JButton("Ȯ��");
		 
		JButton btn_back = new JButton("����ȭ������");
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

		
		//����ȭ������ ��ư�� ������ ó�� ȭ������ ���ư�
   	 	btn_back.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            pn.setVisible(false);
            (new GuiIntf()).FirstWindow();
         }
      });
		
		
   	 	
   	 
		btn.addActionListener(new ActionListener() { //Ȯ�� ��ư Ŭ���� �߻��ϴ� �̺�Ʈ
			public void actionPerformed(ActionEvent e) {					
					//pn.setVisible(false);
					String num = tf.getText();
			 
				switch(num) {
				case "1"://��ȭ�̸����� �˻��� ViewQuery Ŭ������ user_first �޼ҵ� ȣ��
					try {
						pn.setVisible(false);	
						ViewQuery.user_first();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
					 
				case "2": //��ȭ�� �̸����� �˻��� ViewQuery Ŭ������ user_second �޼ҵ� ȣ��
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
	 
	/*��ȭ �̸����� �˻�*/
	 public static JPanel search_movie_by_name() throws SQLException{
			JPanel pn = new JPanel(null);
	      try {
	    	  Main.conn.setAutoCommit(false); //Autocommit�� �������� ��ȯ
	        String query = "SELECT * FROM DB2021_Movies WHERE name=?";
	        PreparedStatement pstmt = Main.conn.prepareStatement(query);
	        
	        JButton btn_back = new JButton("����ȭ������");
			btn_back.setFont(new Font("Dialog",Font.BOLD,12));
			btn_back.setBounds(0,0,300,30);
	         
	        JLabel lb1 = new JLabel("��ȭ �̸��� �Է����ּ���:");
			JTextField tf1 = new JTextField(20);
			JButton btn1 = new JButton("Ȯ��");
			TextArea ta1 = new TextArea();	
			
			creating_tool(lb1, btn1, tf1, ta1);
	         
			btn1.addActionListener(new ActionListener() { //Ȯ�� ��ư Ŭ���� �߻��ϴ� �̺�Ʈ
				public void actionPerformed(ActionEvent e) {
					String temp = tf1.getText();
					try {
						pstmt.setString(1, temp);					
						ResultSet rs = pstmt.executeQuery();
						ta1.append("��ȭ �̸� / �帣 / ����Ÿ�� / ���� ��¥ / ��� / ���� / ���� �� / ��ȣ ���ɴ� / ��ȣ ���� / ��ȭ�� / ���� \n");
						while(rs.next()) {			
							 //textArea�� ������ �����
							ta1.append(""+rs.getString(1)+" / "+rs.getString(2)+" / "+rs.getInt(3)+" / "+rs.getDate(4)+" / "+rs.getString(5)+" / "+rs.getFloat(6)+" / "+rs.getInt(7)+" / "+rs.getInt(8)+" / "+rs.getString(9)+" / "+rs.getString(10)+" / "+rs.getString(11)+"\n");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			});
			
			//����ȭ������ ��ư�� ������ GuiIntf Ŭ������ Panel_searching ȭ������ ���ư�
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
			Main.conn.commit(); ////�̻��� ������ commit	
	      }
	      catch(SQLException se) {
	    	  se.printStackTrace();
				try{
					if(Main.conn!=null)
						Main.conn.rollback(); //���� �߻��� rollback
				}catch(SQLException se2){
					se2.printStackTrace();
				}
	      }
			return pn;
	   }	 
	 /*��ȭ�� �̸����� �˻�*/
	 public static JPanel search_company_by_name() throws SQLException{
			JPanel pn = new JPanel(null);
	      try {
	    	  Main.conn.setAutoCommit(false); //Autocommit�� �������� ��ȯ
	        String query = "SELECT * FROM DB2021_Company WHERE film_company=?";
	        PreparedStatement pstmt = Main.conn.prepareStatement(query);
	        
	        JButton btn_back = new JButton("����ȭ������");
			btn_back.setFont(new Font("Dialog",Font.BOLD,12));
			btn_back.setBounds(0,0,300,30);
	        
	        JLabel lb1 = new JLabel("��ȭ�� �̸��� �Է����ּ���:");
	        JTextField tf1 = new JTextField(20);
			JButton btn1 = new JButton("Ȯ��");
			TextArea ta1 = new TextArea();	

			creating_tool(lb1, btn1, tf1, ta1);
			
			
				
	         btn1.addActionListener(new ActionListener() { //Ȯ�� ��ư Ŭ���� �߻��ϴ� �̺�Ʈ
					public void actionPerformed(ActionEvent e) {
						String temp = tf1.getText();
						try {
							pstmt.setString(1, temp);					
							ResultSet rs = pstmt.executeQuery();
							ta1.append("��ȭ�� �̸� / �з� / ��ǥ �̸� / ��ȭ��ȣ / �ּ� / ��ǥ��ȭ \n");
							while(rs.next()) {	
								 //textArea�� ������ �����
								ta1.append(""+rs.getString(1)+" / "+rs.getString(2)+" / "+rs.getString(3)+" / "+rs.getString(4)+" / "+rs.getString(5)+" / "+rs.getString(6)+"\n");
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
				});
				
			//����ȭ������ ��ư�� ������ GuiIntf Ŭ������ Panel_searching ȭ������ ���ư�
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
			Main.conn.commit(); ////�̻��� ������ commit
	      }
	      catch(SQLException se) {
	    	  se.printStackTrace();
				try{
					if(Main.conn!=null)
						Main.conn.rollback(); //���� �߻��� rollback
				}catch(SQLException se2){
					se2.printStackTrace();
				}
	      }
			return pn;
	   }
	 /*��ȭ�� ��ȭ�� �˻�*/
	 public static JPanel search_company_by_movie() throws SQLException{
			JPanel pn = new JPanel(null);
	      try {
	    	  Main.conn.setAutoCommit(false); //Autocommit�� �������� ��ȯ
	         String query = "SELECT * FROM DB2021_Company WHERE named_movie=?";
	         PreparedStatement pstmt = Main.conn.prepareStatement(query);
	         
	         JButton btn_back = new JButton("����ȭ������");
			btn_back.setFont(new Font("Dialog",Font.BOLD,12));
			btn_back.setBounds(0,0,300,30);
	         
	         JLabel lb1 = new JLabel("��ȭ�簡 ������ ��ȭ�� �Է����ּ���:");
	         JTextField tf1 = new JTextField(20);
				JButton btn1 = new JButton("Ȯ��");
				TextArea ta1 = new TextArea();	

				creating_tool(lb1, btn1, tf1, ta1);
				
				btn1.addActionListener(new ActionListener() { //Ȯ�� ��ư Ŭ���� �߻��ϴ� �̺�Ʈ
					public void actionPerformed(ActionEvent e) {
						String temp = tf1.getText();
						try {
							pstmt.setString(1, temp);					
							ResultSet rs = pstmt.executeQuery();
							ta1.append("��ȭ�� �̸� / �з� / ��ǥ �̸� / ��ȭ��ȣ / �ּ� / ��ǥ��ȭ \n");
							while(rs.next()) {		
								 //textArea�� ������ �����	
								ta1.append(""+rs.getString(1)+" / "+rs.getString(2)+" / "+rs.getString(3)+" / "+rs.getString(4)+" / "+rs.getString(5)+" / "+rs.getString(6)+"\n");
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
				});
				
				//����ȭ������ ��ư�� ������ GuiIntf Ŭ������ Panel_searching ȭ������ ���ư�
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
			Main.conn.commit(); ////�̻��� ������ commit
	      }
	      catch(SQLException se) {
	    	  se.printStackTrace();
				try{
					if(Main.conn!=null)
						Main.conn.rollback(); //���� �߻��� rollback
				}catch(SQLException se2){
					se2.printStackTrace();
				}
	      }
			return pn;
	   }
	 /*��ȭ�� �̸����� �˻�*/
	 public static JPanel search_festival_by_name() throws SQLException{
			JPanel pn = new JPanel(null);
	      try {
	    	  Main.conn.setAutoCommit(false); //Autocommit�� �������� ��ȯ
	         String query = "SELECT * FROM DB2021_Festival WHERE name =?";
	         PreparedStatement pstmt = Main.conn.prepareStatement(query);
	         
	         JButton btn_back = new JButton("����ȭ������");
				btn_back.setFont(new Font("Dialog",Font.BOLD,12));
				btn_back.setBounds(0,0,300,30);
	         
	         JLabel lb1 = new JLabel("��ȭ�� �̸��� �Է����ּ���:");
	         JTextField tf1 = new JTextField(20);
				JButton btn1 = new JButton("Ȯ��");
				TextArea ta1 = new TextArea();	
				
				creating_tool(lb1, btn1, tf1, ta1);
	         
	         btn1.addActionListener(new ActionListener() { //Ȯ�� ��ư Ŭ���� �߻��ϴ� �̺�Ʈ
					public void actionPerformed(ActionEvent e) {
						String temp = tf1.getText();
						try {
							pstmt.setString(1, temp);					
							ResultSet rs = pstmt.executeQuery();
							ta1.append("��ȭ�� �̸� / ���� ���� / ���� ���� / ���ֳ� \n");
							while(rs.next()) {	
								 //textArea�� ������ �����		
								ta1.append(""+rs.getString(1)+" / "+rs.getString(2)+" / "+rs.getString(3)+" / "+rs.getInt(4)+"\n");
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
				});
				
			//����ȭ������ ��ư�� ������ GuiIntf Ŭ������ Panel_searching ȭ������ ���ư�
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
			Main.conn.commit(); ////�̻��� ������ commit
	      }
	      catch(SQLException se) {
	    	  se.printStackTrace();
				try{
					if(Main.conn!=null)
						Main.conn.rollback(); //���� �߻��� rollback
				}catch(SQLException se2){
					se2.printStackTrace();
				}
	      }
			return pn;
	   }
	 /*��ȭ�� ���ֱ����� �˻�*/
	 public static JPanel search_festival_by_country() throws SQLException{
			JPanel pn = new JPanel(null);
	      try {
	    	  Main.conn.setAutoCommit(false); //Autocommit�� �������� ��ȯ
	         String query = "SELECT * FROM DB2021_Festival WHERE country =?";
	         PreparedStatement pstmt = Main.conn.prepareStatement(query);
	         
	         JButton btn_back = new JButton("����ȭ������");
				btn_back.setFont(new Font("Dialog",Font.BOLD,12));
				btn_back.setBounds(0,0,300,30);
	         
	         JLabel lb1 = new JLabel("��ȭ�� ���ֱ��� �Է����ּ���:");	         
	         JTextField tf1 = new JTextField(20);
				JButton btn1 = new JButton("Ȯ��");
				TextArea ta1 = new TextArea();	
				
				creating_tool(lb1, btn1, tf1, ta1);
	         
				btn1.addActionListener(new ActionListener() { //Ȯ�� ��ư Ŭ���� �߻��ϴ� �̺�Ʈ
					public void actionPerformed(ActionEvent e) {
						String temp = tf1.getText();
						try {
							pstmt.setString(1, temp);					
							ResultSet rs = pstmt.executeQuery();
							ta1.append("��ȭ�� �̸� / ���� ���� / ���� ���� / ���ֳ� \n");
							while(rs.next()) {			
								 //textArea�� ������ �����
								ta1.append(""+rs.getString(1)+" / "+rs.getString(2)+" / "+rs.getString(3)+" / "+rs.getInt(4)+"\n");
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
				});
				
				//����ȭ������ ��ư�� ������ GuiIntf Ŭ������ Panel_searching ȭ������ ���ư�
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
			Main.conn.commit(); ////�̻��� ������ commit
	      }
	      catch(SQLException se) {
	    	  se.printStackTrace();
				try{
					if(Main.conn!=null)
						Main.conn.rollback(); //���� �߻��� rollback
				}catch(SQLException se2){
					se2.printStackTrace();
				}
	      }
			return pn;
	   }
	 
	 /*�����ι�*/
             //��ȭ�� ��ȭ��� �˻�
	 public static JPanel search_actor_by_name() throws SQLException{
		 
			JPanel pn = new JPanel(null);
	      try {
	    	  Main.conn.setAutoCommit(false); //Autocommit�� �������� ��ȯ
	         String query = "SELECT * FROM DB2021_Actor WHERE name =?";
	         PreparedStatement pstmt = Main.conn.prepareStatement(query);
	         
	         JButton btn_back = new JButton("����ȭ������");
				btn_back.setFont(new Font("Dialog",Font.BOLD,12));
				btn_back.setBounds(0,0,300,30);
	         
	         JLabel lb1 = new JLabel("����̸��� �Է����ּ���:");	         
	         JTextField tf1 = new JTextField(20);
				JButton btn1 = new JButton("Ȯ��");
				TextArea ta1 = new TextArea();	
				
				creating_tool(lb1, btn1, tf1, ta1);
	         
				btn1.addActionListener(new ActionListener() { //Ȯ�� ��ư Ŭ���� �߻��ϴ� �̺�Ʈ
					public void actionPerformed(ActionEvent e) {
						String temp = tf1.getText();
						try {
							pstmt.setString(1, temp);					
							ResultSet rs = pstmt.executeQuery();
							ta1.append("��� �̸� / ��� ���� / ��� ������� / ��� �⿬�� \n");
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
			Main.conn.commit(); ////�̻��� ������ commit
	      }
	      catch(SQLException se) {
	    	  se.printStackTrace();
				try{
					if(Main.conn!=null)
						Main.conn.rollback(); //���� �߻��� rollback
				}catch(SQLException se2){
					se2.printStackTrace();
				}
	      }
			return pn;
	   }
	 //��� �⿬������ ��� �˻�
	 public static JPanel search_actor_by_film() throws SQLException{
		 
			JPanel pn = new JPanel(null);
	      try {
	    	  Main.conn.setAutoCommit(false); //Autocommit�� �������� ��ȯ
	         String query = "SELECT * FROM DB2021_Actor WHERE film =?";
	         PreparedStatement pstmt = Main.conn.prepareStatement(query);
	         
	         JButton btn_back = new JButton("����ȭ������");
				btn_back.setFont(new Font("Dialog",Font.BOLD,12));
				btn_back.setBounds(0,0,300,30);
	         
	         JLabel lb1 = new JLabel("��� �⿬���� �Է����ּ���:");	         
	         JTextField tf1 = new JTextField(20);
				JButton btn1 = new JButton("Ȯ��");
				TextArea ta1 = new TextArea();	
				
				creating_tool(lb1, btn1, tf1, ta1);
	         
				btn1.addActionListener(new ActionListener() { //Ȯ�� ��ư Ŭ���� �߻��ϴ� �̺�Ʈ
					public void actionPerformed(ActionEvent e) {
						String temp = tf1.getText();
						try {
							pstmt.setString(1, temp);					
							ResultSet rs = pstmt.executeQuery();
							ta1.append("��� �̸� / ��� ���� / ��� ������� / ��� �⿬�� \n");
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
			Main.conn.commit(); ////�̻��� ������ commit
	      }
	      catch(SQLException se) {
	    	  se.printStackTrace();
				try{
					if(Main.conn!=null)
						Main.conn.rollback(); //���� �߻��� rollback
				}catch(SQLException se2){
					se2.printStackTrace();
				}
	      }
			return pn;
	   }
	 //������ ��ȭ�������� ��ȭ�������� �˻�
	 public static JPanel search_award_by_film() throws SQLException{
		 
			JPanel pn = new JPanel(null);
	      try {
	    	  Main.conn.setAutoCommit(false); //Autocommit�� �������� ��ȯ
	         String query = "SELECT * FROM DB2021_Award WHERE film =?";
	         PreparedStatement pstmt = Main.conn.prepareStatement(query);
	         
	         JButton btn_back = new JButton("����ȭ������");
				btn_back.setFont(new Font("Dialog",Font.BOLD,12));
				btn_back.setBounds(0,0,300,30);
	         
	         JLabel lb1 = new JLabel("������ ��ȭ �̸��� �Է����ּ���:");	         
	         JTextField tf1 = new JTextField(20);
				JButton btn1 = new JButton("Ȯ��");
				TextArea ta1 = new TextArea();	
				
				creating_tool(lb1, btn1, tf1, ta1);
	         
				btn1.addActionListener(new ActionListener() { //Ȯ�� ��ư Ŭ���� �߻��ϴ� �̺�Ʈ
					public void actionPerformed(ActionEvent e) {
						String temp = tf1.getText();
						try {
							pstmt.setString(1, temp);					
							ResultSet rs = pstmt.executeQuery();
							ta1.append("���� ���� / ��ȭ�� �̸� / ��ǰ�� / ���� \n");
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
			Main.conn.commit(); ////�̻��� ������ commit
	      }
	      catch(SQLException se) {
	    	  se.printStackTrace();
				try{
					if(Main.conn!=null)
						Main.conn.rollback(); //���� �߻��� rollback
				}catch(SQLException se2){
					se2.printStackTrace();
				}
	      }
			return pn;
	   }
	 //������ ��ȭ �������� �������� �˻�
	 public static JPanel search_award_by_director() throws SQLException{
		 
			JPanel pn = new JPanel(null);
	      try {
	    	  Main.conn.setAutoCommit(false); //Autocommit�� �������� ��ȯ
	         String query = "SELECT * FROM DB2021_Award WHERE director =?";
	         PreparedStatement pstmt = Main.conn.prepareStatement(query);
	         
	         JButton btn_back = new JButton("����ȭ������");
				btn_back.setFont(new Font("Dialog",Font.BOLD,12));
				btn_back.setBounds(0,0,300,30);
	         
	         JLabel lb1 = new JLabel("������ ��ȭ�� ���� �̸��� �Է����ּ���:");	         
	         JTextField tf1 = new JTextField(20);
				JButton btn1 = new JButton("Ȯ��");
				TextArea ta1 = new TextArea();	
				
				creating_tool(lb1, btn1, tf1, ta1);
	         
				btn1.addActionListener(new ActionListener() { //Ȯ�� ��ư Ŭ���� �߻��ϴ� �̺�Ʈ
					public void actionPerformed(ActionEvent e) {
						String temp = tf1.getText();
						try {
							pstmt.setString(1, temp);					
							ResultSet rs = pstmt.executeQuery();
							ta1.append("���� ���� / ��ȭ�� �̸� / ��ǰ�� / ���� \n");
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
			Main.conn.commit(); ////�̻��� ������ commit
	      }
	      catch(SQLException se) {
	    	  se.printStackTrace();
				try{
					if(Main.conn!=null)
						Main.conn.rollback(); //���� �߻��� rollback
				}catch(SQLException se2){
					se2.printStackTrace();
				}
	      }
			return pn;
	   }
}