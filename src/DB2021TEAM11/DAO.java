package DB2021TEAM11;
import java.sql.*;//jdbc�� Ȱ���ϱ� ���� import

/*�����ͺ��̽��� �����͸� ����, ����, ������ �� �ִ� �޼ҵ带 �����ϴ� Ŭ������*/
public class DAO {//Data Access Object(������ ���� Ŭ����)
	
	/*����(Insert) ���� �żҵ�*/
	
	/*��ȭ(DB2021_Movies) ���̺� ����*/
	public void insert_movie(String name, String genre, int running_time, String date, String actor, float rating, int attandance, int prefered_age, String prefered_gender, String film_company, String director) throws SQLException{
		PreparedStatement pstmt = null;//����ڷκ��� �Է��� �޾� �����ͺ��̽��� �ֱ� ���� PreparedStatement ��ü�� �����ϰ� null���� ó��.
		try {
			Main.conn.setAutoCommit(false);//transaction�� ���Ͽ� auto commit�� ���� �ʰ���
	         
			/*DB2021_Movies ���̺� insert�ϴ� �������� PreparedStatement ��ü�� �־���*/
	         String query_movie = "INSERT INTO DB2021_Movies VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
	         pstmt = Main.conn.prepareStatement(query_movie);
	         
	         /*PreparedStatement ��ü�� JTestField���� �Է¹��� �� �Ѱܹ޾Ƽ� �־���(������ ?�κп� ���ʴ�� ��)*/
	         pstmt.setString(1, name); //��ȭ �̸�
	         pstmt.setString(2, genre);//��ȭ �帣
	         pstmt.setInt(3, running_time);//�� �ð�
	         pstmt.setString(4, date);//���� ��¥
	         pstmt.setString(5, actor);//�⿬ ���
	         pstmt.setFloat(6, rating);//����
	         pstmt.setInt(7, attandance);//���� ��
	         pstmt.setInt(8, prefered_age);//��ȣ������
	         pstmt.setString(9, prefered_gender);//��ȣ����
	         pstmt.setString(10, film_company);//��ȭ��
	         pstmt.setString(11, director);//����
	         
	         pstmt.executeUpdate();//�Էµ� ������ �����ͺ��̽��� ����ǰ� ��. �Էµ� ������ �ش� ���̺� insert��.
	         Main.conn.commit();//������ ���ٸ� commit ����
	         
	         /*����ó��*/
	         }catch(SQLException se) {
	            se.printStackTrace();
	               try{
	                  if(Main.conn!=null)
	                	  Main.conn.rollback();//���� �߻� �� rollback ó��
	                  }
	               catch(SQLException se2){
	                  se2.printStackTrace();
	                  }
	               }finally {
	                  System.out.println("������ ������ �Ϸ�Ǿ����ϴ�!");//������ ������ �Ϸ�Ǿ����� �˸��� �ȳ���
	               }
	}
	
	/*��ȭ��(DB2021_Company) ���̺� ����*/
	public void insert_company(String company, String category, String CEO, String telnum, String address, String named_movie) throws SQLException{
		PreparedStatement pstmt = null;//����ڷκ��� �Է��� �޾� �����ͺ��̽��� �ֱ� ���� PreparedStatement ��ü�� �����ϰ� null���� ó��.
		try {
			Main.conn.setAutoCommit(false);//transaction�� ���Ͽ� auto commit�� ���� �ʰ���
	         
			/*PreparedStatement ��ü�� JTestField���� �Է¹��� �� �Ѱܹ޾Ƽ� �־���(������ ?�κп� ���ʴ�� ��)*/
	         String query_company = "INSERT INTO DB2021_Company VALUES(?, ?, ?, ?, ?, ?)";
	         pstmt = Main.conn.prepareStatement(query_company);

	         /*PreparedStatement ��ü�� JTestField���� �Է¹��� �� �Ѱܹ޾Ƽ� �־���(������ ?�κп� ���ʴ�� ��)*/
	         pstmt.setString(1, company);//ȸ���
	         pstmt.setString(2, category);//ȸ�� �з�
	         pstmt.setString(3, CEO);//ȸ�� ��ǥ
	         pstmt.setString(4, telnum);//ȸ�� ��ȭ��ȣ
	         pstmt.setString(5, address);//ȸ�� �ּ�(����)
	         pstmt.setString(6, named_movie);//���� ��ȭ
	         
	         //�Էµ� ������ �����ͺ��̽��� ����ǰ� ��. �Էµ� ������ �ش� ���̺� insert��
	         pstmt.executeUpdate();
	         
	         //������ ���ٸ� commit ����
	         Main.conn.commit();
	         
	         }catch(SQLException se) {//����ó��
	            se.printStackTrace();
	               try{
	                  if(Main.conn!=null)
	                	  Main.conn.rollback();//�����߻��� rollback ó��
	                  }
	               catch(SQLException se2){
	                  se2.printStackTrace();
	                  }
	               }finally {
	                  System.out.println("������ ������ �Ϸ�Ǿ����ϴ�!");//������ ������ �Ϸ�Ǿ����� �˸��� �ȳ���
	               }
	}
	
	/*��ȭ��(DB2021_Festival) ���̺� ����*/
	public void insert_festival(String festival_name, String country, String city, int begin_year) throws SQLException{
		PreparedStatement pstmt = null;//����ڷκ��� �Է��� �޾� �����ͺ��̽��� �ֱ� ���� PreparedStatement ��ü�� �����ϰ� null���� ó��.
		try {
			Main.conn.setAutoCommit(false);//transaction�� ���Ͽ� auto commit�� ���� �ʵ��� ��.
	         
			/*PreparedStatement ��ü�� JTestField���� �Է¹��� �� �Ѱܹ޾Ƽ� �־���(������ ?�κп� ���ʴ�� ��)*/
	         String query_festival = "INSERT INTO DB2021_Festival VALUES(?, ?, ?, ?)";//DB2021_Festival ���̺� insert�ϴ� ������
	         pstmt = Main.conn.prepareStatement(query_festival);
	         
	         /*PreparedStatement ��ü�� JTestField���� �Է¹��� �� �Ѱܹ޾Ƽ� �־���(������ ?�κп� ���ʴ�� ��)*/
	         pstmt.setString(1, festival_name); //��ȭ�� �̸�
	         pstmt.setString(2, country);//���� ����
	         pstmt.setString(3, city);//���� ����
	         pstmt.setInt(4, begin_year);//���ʰ�����
	         
	         //�Էµ� ������ �����ͺ��̽��� ����ǰ� ��. �Էµ� ������ �ش� ���̺� insert��.
	         pstmt.executeUpdate();
	         
	         //������ ���ٸ� commit ����
	         Main.conn.commit();
	         }catch(SQLException se) {//����ó��
	            se.printStackTrace();
	               try{
	                  if(Main.conn!=null)
	                	  Main.conn.rollback();//�����߻��� rollback ó��
	                  }
	               catch(SQLException se2){
	                  se2.printStackTrace();
	                  }
	               }finally {
	                  System.out.println("������ ������ �Ϸ�Ǿ����ϴ�!");//������ ������ �Ϸ�Ǿ����� �˸��� �ȳ���
	               }
	}
	
	/*���(DB2021_Actor) ���̺� ����*/
	public void insert_actor(String actor_name, String actor_gender, String birth, String film) throws SQLException{
		PreparedStatement pstmt = null;//����ڷκ��� �Է��� �޾� �����ͺ��̽��� �ֱ� ���� PreparedStatement ��ü�� �����ϰ� null���� ó��.
		try {
			Main.conn.setAutoCommit(false);//transaction�� ���Ͽ� auto commit�� ���� �ʵ��� ��.
	         
			/*PreparedStatement ��ü�� JTestField���� �Է¹��� �� �Ѱܹ޾Ƽ� �־���(������ ?�κп� ���ʴ�� ��)*/
	         String query_actor = "INSERT INTO DB2021_Actor VALUES(?, ?, ?, ?)";//DB2021_Actor ���̺� insert�ϴ� ������
	         pstmt = Main.conn.prepareStatement(query_actor);
	         
	         /*PreparedStatement ��ü�� JTestField���� �Է¹��� �� �Ѱܹ޾Ƽ� �־���(������ ?�κп� ���ʴ�� ��)*/
	         pstmt.setString(1, actor_name);//��� �̸�
	         pstmt.setString(2, actor_gender);//����
	         pstmt.setString(3, birth);//�������
	         pstmt.setString(4, film);//�⿬��ȭ
	         
	         //�Էµ� ������ �����ͺ��̽��� ����ǰ� ��. �Էµ� ������ �ش� ���̺� insert��.
	         pstmt.executeUpdate();
	         
	         //������ ���ٸ� commit ����
	         Main.conn.commit();
	         }catch(SQLException se) {//����ó��
	            se.printStackTrace();
	               try{
	                  if(Main.conn!=null)
	                	  Main.conn.rollback();//�����߻��� rollback ó��
	                  }
	               catch(SQLException se2){
	                  se2.printStackTrace();
	                  }
	               }finally {
	                  System.out.println("������ ������ �Ϸ�Ǿ����ϴ�!");//������ ������ �Ϸ�Ǿ����� �˸��� �ȳ���
	               }
	}
	
	/*��������(DB2021_Award) ���̺� ����*/
	public void insert_award(int year, String festival, String prized_film, String prized_director) throws SQLException{
		PreparedStatement pstmt = null;//����ڷκ��� �Է��� �޾� �����ͺ��̽��� �ֱ� ���� PreparedStatement ��ü�� �����ϰ� null���� ó��.
		try {
			Main.conn.setAutoCommit(false);//transaction�� ���Ͽ� auto commit�� ���� �ʵ��� ��.
	         
			/*PreparedStatement ��ü�� JTestField���� �Է¹��� �� �Ѱܹ޾Ƽ� �־���(������ ?�κп� ���ʴ�� ��)*/
	         String query_award = "INSERT INTO DB2021_Award VALUES(?, ?, ?, ?)";//DB2021_Award ���̺� insert�ϴ� ������
	         pstmt = Main.conn.prepareStatement(query_award);
	         
	         /*PreparedStatement ��ü�� JTestField���� �Է¹��� �� �Ѱܹ޾Ƽ� �־���(������ ?�κп� ���ʴ�� ��)*/
	         pstmt.setInt(1, year); //����⵵
	         pstmt.setString(2, festival);//��ȭ���̸�
	         pstmt.setString(3, prized_film);//��ǰ��(��ȭ)
	         pstmt.setString(4, prized_director);//����
	         
	         //�Էµ� ������ �����ͺ��̽��� ����ǰ� ��. �Էµ� ������ �ش� ���̺� insert��.
	         pstmt.executeUpdate();
	         
	         //������ ���ٸ� commit ����
	         Main.conn.commit();
	         }catch(SQLException se) {//����ó��
	            se.printStackTrace();
	               try{
	                  if(Main.conn!=null)
	                	  Main.conn.rollback();//�����߻��� rollback ó��
	                  }
	               catch(SQLException se2){
	                  se2.printStackTrace();
	                  }
	               }finally {
	                  System.out.println("������ ������ �Ϸ�Ǿ����ϴ�!");//������ ������ �Ϸ�Ǿ����� �˸��� �ȳ���
	               }
	}
	
	
	
	/*����(Update) ���� �żҵ�*/
	
	/*��ȭ(DB2021_Movies) ���̺� ����*/
	public void update_movie(String menu, String name, String update_thing) throws SQLException{
		/*����ڷκ��� �Է��� �޾� �����ͺ��̽��� �����Ű���� �ϱ� ���� PreparedStatement ��ü���� �����ϰ� null���� ó��
		 * pstmt1���� ������ ���� �������� �־��ְ�, pstmt2, pstmt3���� foreign key üũ�� Ǫ�� ������ �ٽ� üũ�ϴ� ������ �־���*/
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;

        try {
        	Main.conn.setAutoCommit(false);//transaction�� ���Ͽ� auto commit�� ���� �ʵ��� ��.
        	
        	String query1 = null;//�������� �־��� ���ڿ�����
        	
        	//foreign key�� ���ؼ� ����,������ �ȵǴ� ���ܰ� �߻��ϴµ�, �̸� ���� ���ؼ� foreign key üũ�� Ǯ�ų� �ٽ� üũ�� �� �ִ� �������� �ۼ�
        	String query2 = "SET foreign_key_checks = 0";
        	String query3 = "SET foreign_key_checks = 1";
        	
        	if(name.equals("All")) {//�ش� �׸� �ϰ� ����
                query1 = "UPDATE DB2021_Movies SET "+menu+" = ?";//�����ϴ� ������. menu�� ������ �׸�(attribute)�� �ǹ���
                pstmt1 = Main.conn.prepareStatement(query1);
                pstmt1.setString(1, update_thing);
                
             }
        	else {
        		query1 = "UPDATE DB2021_Movies SET "+menu+" = ? WHERE name= ? ";
        		pstmt1 = Main.conn.prepareStatement(query1);
        		pstmt1.setString(1, update_thing);
                pstmt1.setString(2, name);
        	}
        	pstmt2 = Main.conn.prepareStatement(query2);
        	pstmt3 = Main.conn.prepareStatement(query3);
        	
        	/*foreign key�� ���ؼ� ����,������ �ȵǴ� ���� ����*/
        	pstmt2.executeUpdate();
        	pstmt1.executeUpdate();
        	pstmt3.executeUpdate();
        	
        	/*������ ���� ��� commit�ϰ�, �׷��� �ʴٸ� rollback�Ѵ�*/ 
        	Main.conn.commit();
        	}catch(SQLException se){
        		se.printStackTrace();
                try{
                	if(Main.conn!=null)
                		Main.conn.rollback();
                	}catch(SQLException se2){
                		se2.printStackTrace();
                		}
                }finally {
                	System.out.println("������ ������ �Ϸ�Ǿ����ϴ�.");
                	}
     	}
	
	/*��ȭ��(DB2021_Company) ���̺� ����*/
	public void update_company(String menu, String company_name, String film_name, String update_thing) throws SQLException{
		/*����ڷκ��� �Է��� �޾� �����ͺ��̽��� �����Ű���� �ϱ� ���� PreparedStatement ��ü���� �����ϰ� null���� ó��
		 * pstmt1���� ������ ���� �������� �־��ְ�, pstmt2, pstmt3���� foreign key üũ�� Ǫ�� ������ �ٽ� üũ�ϴ� ������ �־���*/
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;

        try {
        	Main.conn.setAutoCommit(false);//transaction�� ���Ͽ� auto commit�� ���� �ʵ��� ��.
        	
        	String query1 = null;//�������� �־��� ���ڿ�����
        	
        	//foreign key�� ���ؼ� ����,������ �ȵǴ� ���ܰ� �߻��ϴµ�, �̸� ���� ���ؼ� foreign key üũ�� Ǯ�ų� �ٽ� üũ�� �� �ִ� �������� �ۼ�
        	String query2 = "SET foreign_key_checks = 0";
        	String query3 = "SET foreign_key_checks = 1";
        	
        	/*menu�� ������ �׸�(attribute)�� �ǹ��Ѵ�. 
        	 * All�� �Է����� ��� ������ �׸��� �ϰ������ϸ�, �׷��� ���� ��쿡�� �Է¹��� �������� ��ġ�ϴ� Ʃ���� �׸� �����Ѵ�.*/
        	if(company_name.equals("All")&&film_name.equals("All")) {
        		query1 = "UPDATE DB2021_Company SET "+menu+" = ?";
                pstmt1 = Main.conn.prepareStatement(query1);
                pstmt1.setString(1, update_thing);
             }
        	else {
        		query1 = "UPDATE DB2021_Company SET "+menu+" = ? WHERE film_company= ? AND named_movie= ? ";
        		pstmt1 = Main.conn.prepareStatement(query1);
        		pstmt1.setString(1, update_thing);
        		pstmt1.setString(2, company_name);
        		pstmt1.setString(3, film_name);
        	}
        	pstmt2 = Main.conn.prepareStatement(query2);
        	pstmt3 = Main.conn.prepareStatement(query3);
        	
        	/*foreign key�� ���ؼ� ����,������ �ȵǴ� ���� ����*/
        	pstmt2.executeUpdate();
        	pstmt1.executeUpdate();
        	pstmt3.executeUpdate();
        	
        	/*������ ���� ��� commit�ϰ�, �׷��� �ʴٸ� rollback�Ѵ�*/ 
        	Main.conn.commit();
        	}catch(SQLException se){
        		se.printStackTrace();
                try{
                	if(Main.conn!=null)
                		Main.conn.rollback();
                	}catch(SQLException se2){
                		se2.printStackTrace();
                		}
                }finally {
                	System.out.println("������ ������ �Ϸ�Ǿ����ϴ�.");
                	}
     	}
	
	/*��ȭ��(DB2021_Festival) ���̺� ����*/
	public void update_festival(String menu, String name, String update_thing) throws SQLException{
		/*����ڷκ��� �Է��� �޾� �����ͺ��̽��� �����Ű���� �ϱ� ���� PreparedStatement ��ü���� �����ϰ� null���� ó��
		 * pstmt1���� ������ ���� �������� �־��ְ�, pstmt2, pstmt3���� foreign key üũ�� Ǫ�� ������ �ٽ� üũ�ϴ� ������ �־���*/
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;

        try {
        	Main.conn.setAutoCommit(false);//transaction�� ���Ͽ� auto commit�� ���� �ʵ��� ��.
        	
        	String query1 = null;//�������� �־��� ���ڿ�����
        	
        	//foreign key�� ���ؼ� ����,������ �ȵǴ� ���ܰ� �߻��ϴµ�, �̸� ���� ���ؼ� foreign key üũ�� Ǯ�ų� �ٽ� üũ�� �� �ִ� �������� �ۼ�
        	String query2 = "SET foreign_key_checks = 0";
        	String query3 = "SET foreign_key_checks = 1";
        	
        	/*menu�� ������ �׸�(attribute)�� �ǹ��Ѵ�. 
        	 * All�� �Է����� ��� ������ �׸��� �ϰ������ϸ�, �׷��� ���� ��쿡�� �Է¹��� �������� ��ġ�ϴ� Ʃ���� �׸� �����Ѵ�.*/
        	if(name.equals("All")) {//�ش� �׸� �ϰ� ����
        		query1 = "UPDATE DB2021_Festival SET "+menu+" = ?";//�����ϴ� ������. menu�� ������ �׸�(attribute)�� �ǹ���
                pstmt1 = Main.conn.prepareStatement(query1);
                pstmt1.setString(1, update_thing);
             }
        	else {
        		query1 = "UPDATE DB2021_Festival SET "+menu+" = ? WHERE name= ? ";//�����ϴ� ������. menu�� ������ �׸�(attribute)�� �ǹ���
        		pstmt1 = Main.conn.prepareStatement(query1);
        		pstmt1.setString(1, update_thing);
        		pstmt1.setString(2, name);
        	}
        	pstmt2 = Main.conn.prepareStatement(query2);
        	pstmt3 = Main.conn.prepareStatement(query3);
        	
        	/*foreign key�� ���ؼ� ����,������ �ȵǴ� ���� ����*/
        	pstmt2.executeUpdate();
        	pstmt1.executeUpdate();
        	pstmt3.executeUpdate();
        	
        	/*������ ���� ��� commit�ϰ�, �׷��� �ʴٸ� rollback�Ѵ�*/ 
        	Main.conn.commit();
        	}catch(SQLException se){
        		se.printStackTrace();
                try{
                	if(Main.conn!=null)
                		Main.conn.rollback();
                	}catch(SQLException se2){
                		se2.printStackTrace();
                		}
                }finally {
                	System.out.println("������ ������ �Ϸ�Ǿ����ϴ�.");
                	}
     	}
	
	/*���(DB2021_Actor) ���̺� ����*/
	public void update_actor(String menu, String name, String film_name, String update_thing) throws SQLException{
		/*����ڷκ��� �Է��� �޾� �����ͺ��̽��� �����Ű���� �ϱ� ���� PreparedStatement ��ü���� �����ϰ� null���� ó��
		 * pstmt1���� ������ ���� �������� �־��ְ�, pstmt2, pstmt3���� foreign key üũ�� Ǫ�� ������ �ٽ� üũ�ϴ� ������ �־���*/
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;

        try {
        	Main.conn.setAutoCommit(false);//transaction�� ���Ͽ� auto commit�� ���� �ʵ��� ��.
        	
        	String query1 = null;//�������� �־��� ���ڿ�����
        	
        	//foreign key�� ���ؼ� ����,������ �ȵǴ� ���ܰ� �߻��ϴµ�, �̸� ���� ���ؼ� foreign key üũ�� Ǯ�ų� �ٽ� üũ�� �� �ִ� �������� �ۼ�
        	String query2 = "SET foreign_key_checks = 0";
        	String query3 = "SET foreign_key_checks = 1";
        	
        	/*menu�� ������ �׸�(attribute)�� �ǹ��Ѵ�. 
        	 * All�� �Է����� ��� ������ �׸��� �ϰ������ϸ�, �׷��� ���� ��쿡�� �Է¹��� �������� ��ġ�ϴ� Ʃ���� �׸� �����Ѵ�.*/
        	if(name.equals("All")&&film_name.equals("All")) {//�ش� �׸� �ϰ� ����
        		query1 = "UPDATE DB2021_Actor SET "+menu+" = ?";//�����ϴ� ������. menu�� ������ �׸�(attribute)�� �ǹ���
                pstmt1 = Main.conn.prepareStatement(query1);
                pstmt1.setString(1, update_thing);
             }
        	else {
        		query1 = "UPDATE DB2021_Actor SET "+menu+" = ? WHERE name= ? AND film= ? ";//�����ϴ� ������. menu�� ������ �׸�(attribute)�� �ǹ���
        		pstmt1 = Main.conn.prepareStatement(query1);
        		pstmt1.setString(1, update_thing);
        		pstmt1.setString(2, name);
        		pstmt1.setString(3, film_name);
        	}
        	pstmt2 = Main.conn.prepareStatement(query2);
        	pstmt3 = Main.conn.prepareStatement(query3);
        	
        	/*foreign key�� ���ؼ� ����,������ �ȵǴ� ���� ����*/
        	pstmt2.executeUpdate();
        	pstmt1.executeUpdate();
        	pstmt3.executeUpdate();
        	
        	/*������ ���� ��� commit�ϰ�, �׷��� �ʴٸ� rollback�Ѵ�*/ 
        	Main.conn.commit();
        	}catch(SQLException se){
        		se.printStackTrace();
                try{
                	if(Main.conn!=null)
                		Main.conn.rollback();
                	}catch(SQLException se2){
                		se2.printStackTrace();
                		}
                }finally {
                	System.out.println("������ ������ �Ϸ�Ǿ����ϴ�.");
                	}
     	}
	
	/*��������(DB2021_Award) ���̺� ����*/
	public void update_award(String menu, String name, String film_name, String update_thing) throws SQLException{
		/*����ڷκ��� �Է��� �޾� �����ͺ��̽��� �����Ű���� �ϱ� ���� PreparedStatement ��ü���� �����ϰ� null���� ó��
		 * pstmt1���� ������ ���� �������� �־��ְ�, pstmt2, pstmt3���� foreign key üũ�� Ǫ�� ������ �ٽ� üũ�ϴ� ������ �־���*/
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;

        try {
        	Main.conn.setAutoCommit(false);//transaction�� ���Ͽ� auto commit�� ���� �ʵ��� ��.
        	
        	String query1 = null;//�������� �־��� ���ڿ�����
        	
        	//foreign key�� ���ؼ� ����,������ �ȵǴ� ���ܰ� �߻��ϴµ�, �̸� ���� ���ؼ� foreign key üũ�� Ǯ�ų� �ٽ� üũ�� �� �ִ� �������� �ۼ�
        	String query2 = "SET foreign_key_checks = 0";
        	String query3 = "SET foreign_key_checks = 1";
        	
        	/*menu�� ������ �׸�(attribute)�� �ǹ��Ѵ�. 
        	 * All�� �Է����� ��� ������ �׸��� �ϰ������ϸ�, �׷��� ���� ��쿡�� �Է¹��� �������� ��ġ�ϴ� Ʃ���� �׸� �����Ѵ�.*/
        	if(name.equals("All")&&film_name.equals("All")) {//�ش� �׸� �ϰ� ����
        		query1 = "UPDATE DB2021_Award SET "+menu+" = ?";//�����ϴ� ������. menu�� ������ �׸�(attribute)�� �ǹ���
                pstmt1 = Main.conn.prepareStatement(query1);
                pstmt1.setString(1, update_thing);
             }
        	else {
        		query1 = "UPDATE DB2021_Award SET "+menu+" = ? WHERE festival_name= ? AND film= ?";//�����ϴ� ������. menu�� ������ �׸�(attribute)�� �ǹ���
        		pstmt1 = Main.conn.prepareStatement(query1);
        		pstmt1.setString(1, update_thing);
        		pstmt1.setString(2, name);
        		pstmt1.setString(3, film_name);
        	}
        	pstmt2 = Main.conn.prepareStatement(query2);
        	pstmt3 = Main.conn.prepareStatement(query3);
        	
        	/*foreign key�� ���ؼ� ����,������ �ȵǴ� ���� ����*/
        	pstmt2.executeUpdate();
        	pstmt1.executeUpdate();
        	pstmt3.executeUpdate();
        	
        	/*������ ���� ��� commit�ϰ�, �׷��� �ʴٸ� rollback�Ѵ�*/ 
        	Main.conn.commit();
        	}catch(SQLException se){
        		se.printStackTrace();
                try{
                	if(Main.conn!=null)
                		Main.conn.rollback();
                	}catch(SQLException se2){
                		se2.printStackTrace();
                		}
                }finally {
                	System.out.println("������ ������ �Ϸ�Ǿ����ϴ�.");
                	}
     	}
	
	/*����(delete)�� ���� �޼ҵ�*/
	
	/*��ȭ(DB2021_Movies) ���̺� ����*/
    public void delete_movie(String name) throws SQLException{
    	/*����ڷκ��� �Է��� �޾� �����ͺ��̽��� �����Ű���� �ϱ� ���� PreparedStatement ��ü���� �����ϰ� null���� ó��
		 * pstmt1���� ������ ���� �������� �־��ְ�, pstmt2, pstmt3���� foreign key üũ�� Ǫ�� ������ �ٽ� üũ�ϴ� ������ �־���*/
    	PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		
		try {
			Main.conn.setAutoCommit(false);//transaction�� ���Ͽ� auto commit�� ���� �ʵ��� ��.
	         
			
	         String query1 = "DELETE from DB2021_Movies WHERE name = ?";//����ڰ� �Է��� ���� ��ġ�ϴ� �׸� ���� ���� Ʃ���� �����Ѵ�.
	       //foreign key�� ���ؼ� ����,������ �ȵǴ� ���ܰ� �߻��ϴµ�, �̸� ���� ���ؼ� foreign key üũ�� Ǯ�ų� �ٽ� üũ�� �� �ִ� �������� �ۼ�
	         String query2 = "SET foreign_key_checks = 0";
	         String query3 = "SET foreign_key_checks = 1";
	         
	         pstmt1 = Main.conn.prepareStatement(query1);
	         pstmt1.setString(1, name);
	         pstmt2 = Main.conn.prepareStatement(query2);
	         pstmt3 = Main.conn.prepareStatement(query3);
	         
	         /*foreign key�� ���ؼ� ����,������ �ȵǴ� ���� ����*/
	         pstmt2.executeUpdate();
	         pstmt1.executeUpdate();
	         pstmt3.executeUpdate();
	         
	         /*������ ���� ��� commit�ϰ�, �׷��� �ʴٸ� rollback�Ѵ�*/ 
	         Main.conn.commit();
	         
	         }catch(SQLException se) {//����ó��
	            se.printStackTrace();
	               try{
	                  if(Main.conn!=null)
	                	  Main.conn.rollback();//�����߻��� rollback ó��
	                  }
	               catch(SQLException se2){
	                  se2.printStackTrace();
	                  }
	               }finally {
	                  System.out.println("������ ������ �Ϸ�Ǿ����ϴ�!");//������ ������ �Ϸ�Ǿ����� �˸��� �ȳ���
	               }
		}
    
    /*��ȭ��(DB2021_Company) ���̺� ����*/
    public void delete_company(String company_name, String film_name) throws SQLException{
    	/*����ڷκ��� �Է��� �޾� �����ͺ��̽��� �����Ű���� �ϱ� ���� PreparedStatement ��ü���� �����ϰ� null���� ó��
		 * pstmt1���� ������ ���� �������� �־��ְ�, pstmt2, pstmt3���� foreign key üũ�� Ǫ�� ������ �ٽ� üũ�ϴ� ������ �־���*/
    	PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		
		try {
			Main.conn.setAutoCommit(false);//transaction�� ���Ͽ� auto commit�� ���� �ʵ��� ��.
	         
	         String query1 = "DELETE from DB2021_Company WHERE film_company = ? AND named_movie = ?";//����ڰ� �Է��� ���� ��ġ�ϴ� �׸� ���� ���� Ʃ���� �����Ѵ�.
	       //foreign key�� ���ؼ� ����,������ �ȵǴ� ���ܰ� �߻��ϴµ�, �̸� ���� ���ؼ� foreign key üũ�� Ǯ�ų� �ٽ� üũ�� �� �ִ� �������� �ۼ�
	         String query2 = "SET foreign_key_checks = 0";
	         String query3 = "SET foreign_key_checks = 1";
	         
	         pstmt1 = Main.conn.prepareStatement(query1);
	         pstmt1.setString(1, company_name);
	         pstmt1.setString(2, film_name);
	         pstmt2 = Main.conn.prepareStatement(query2);
	         pstmt3 = Main.conn.prepareStatement(query3);
	         
	         /*foreign key�� ���ؼ� ����,������ �ȵǴ� ���� ����*/
	         pstmt2.executeUpdate();
	         pstmt1.executeUpdate();
	         pstmt3.executeUpdate();
	         
	         /*������ ���� ��� commit�ϰ�, �׷��� �ʴٸ� rollback�Ѵ�*/ 
	         Main.conn.commit();
	         
	         }catch(SQLException se) {//����ó��
	            se.printStackTrace();
	               try{
	                  if(Main.conn!=null)
	                	  Main.conn.rollback();//�����߻��� rollback ó��
	                  }
	               catch(SQLException se2){
	                  se2.printStackTrace();
	                  }
	               }finally {
	                  System.out.println("������ ������ �Ϸ�Ǿ����ϴ�!");//������ ������ �Ϸ�Ǿ����� �˸��� �ȳ���
	               }
		}
    
    /*��ȭ��(DB2021_Festival) ���̺� ����*/
    public void delete_festival(String name) throws SQLException{
    	/*����ڷκ��� �Է��� �޾� �����ͺ��̽��� �����Ű���� �ϱ� ���� PreparedStatement ��ü���� �����ϰ� null���� ó��
		 * pstmt1���� ������ ���� �������� �־��ְ�, pstmt2, pstmt3���� foreign key üũ�� Ǫ�� ������ �ٽ� üũ�ϴ� ������ �־���*/
    	PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		
		try {
			Main.conn.setAutoCommit(false);//transaction�� ���Ͽ� auto commit�� ���� �ʵ��� ��.
	         
	         String query1 = "DELETE from DB2021_Festival WHERE name = ? ";//����ڰ� �Է��� ���� ��ġ�ϴ� �׸� ���� ���� Ʃ���� �����Ѵ�.
	       //foreign key�� ���ؼ� ����,������ �ȵǴ� ���ܰ� �߻��ϴµ�, �̸� ���� ���ؼ� foreign key üũ�� Ǯ�ų� �ٽ� üũ�� �� �ִ� �������� �ۼ�
	         String query2 = "SET foreign_key_checks = 0";
	         String query3 = "SET foreign_key_checks = 1";
	         
	         pstmt1 = Main.conn.prepareStatement(query1);
	         pstmt1.setString(1, name);
	         pstmt2 = Main.conn.prepareStatement(query2);
	         pstmt3 = Main.conn.prepareStatement(query3);
	         
	         /*foreign key�� ���ؼ� ����,������ �ȵǴ� ���� ����*/
	         pstmt2.executeUpdate();
	         pstmt1.executeUpdate();
	         pstmt3.executeUpdate();
	         
	         /*������ ���� ��� commit�ϰ�, �׷��� �ʴٸ� rollback�Ѵ�*/ 
	         Main.conn.commit();
	         
	         }catch(SQLException se) {//����ó��
	            se.printStackTrace();
	               try{
	                  if(Main.conn!=null)
	                	  Main.conn.rollback();//�����߻��� rollback ó��
	                  }
	               catch(SQLException se2){
	                  se2.printStackTrace();
	                  }
	               }finally {
	                  System.out.println("������ ������ �Ϸ�Ǿ����ϴ�!");//������ ������ �Ϸ�Ǿ����� �˸��� �ȳ���
	               }
		}
    
    /*���(DB2021_Actor) ���̺� ����*/
    public void delete_actor(String name, String film) throws SQLException{
    	/*����ڷκ��� �Է��� �޾� �����ͺ��̽��� �����Ű���� �ϱ� ���� PreparedStatement ��ü���� �����ϰ� null���� ó��
		 * pstmt1���� ������ ���� �������� �־��ְ�, pstmt2, pstmt3���� foreign key üũ�� Ǫ�� ������ �ٽ� üũ�ϴ� ������ �־���*/
    	PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		
		try {
			Main.conn.setAutoCommit(false);//transaction�� ���Ͽ� auto commit�� ���� �ʵ��� ��.
	         
	         String query1 = "DELETE from DB2021_Actor WHERE name = ? AND film = ?";//����ڰ� �Է��� ���� ��ġ�ϴ� �׸� ���� ���� Ʃ���� �����Ѵ�.
	       //foreign key�� ���ؼ� ����,������ �ȵǴ� ���ܰ� �߻��ϴµ�, �̸� ���� ���ؼ� foreign key üũ�� Ǯ�ų� �ٽ� üũ�� �� �ִ� �������� �ۼ�
	         String query2 = "SET foreign_key_checks = 0";
	         String query3 = "SET foreign_key_checks = 1";
	         
	         pstmt1 = Main.conn.prepareStatement(query1);
	         pstmt1.setString(1, name);
	         pstmt1.setString(2, film);
	         pstmt2 = Main.conn.prepareStatement(query2);
	         pstmt3 = Main.conn.prepareStatement(query3);
	         
	         /*foreign key�� ���ؼ� ����,������ �ȵǴ� ���� ����*/
	         pstmt2.executeUpdate();
	         pstmt1.executeUpdate();
	         pstmt3.executeUpdate();
	         
	         /*������ ���� ��� commit�ϰ�, �׷��� �ʴٸ� rollback�Ѵ�*/ 
	         Main.conn.commit();
	         
	         }catch(SQLException se) {//����ó��
	            se.printStackTrace();
	               try{
	                  if(Main.conn!=null)
	                	  Main.conn.rollback();//�����߻��� rollback ó��
	                  }
	               catch(SQLException se2){
	                  se2.printStackTrace();
	                  }
	               }finally {
	                  System.out.println("������ ������ �Ϸ�Ǿ����ϴ�!");//������ ������ �Ϸ�Ǿ����� �˸��� �ȳ���
	               }
		}
    
    /*��������(DB2021_Award) ���̺� ����*/
    public void delete_award(String name, String film) throws SQLException{
    	/*����ڷκ��� �Է��� �޾� �����ͺ��̽��� �����Ű���� �ϱ� ���� PreparedStatement ��ü���� �����ϰ� null���� ó��
		 * pstmt1���� ������ ���� �������� �־��ְ�, pstmt2, pstmt3���� foreign key üũ�� Ǫ�� ������ �ٽ� üũ�ϴ� ������ �־���*/
    	PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		
		try {
			Main.conn.setAutoCommit(false);//transaction�� ���Ͽ� auto commit�� ���� �ʵ��� ��.
	         
	         String query1 = "DELETE from DB2021_Award WHERE festival_name = ? AND film = ?";//����ڰ� �Է��� ���� ��ġ�ϴ� �׸� ���� ���� Ʃ���� �����Ѵ�.
	       //foreign key�� ���ؼ� ����,������ �ȵǴ� ���ܰ� �߻��ϴµ�, �̸� ���� ���ؼ� foreign key üũ�� Ǯ�ų� �ٽ� üũ�� �� �ִ� �������� �ۼ�
	         String query2 = "SET foreign_key_checks = 0";
	         String query3 = "SET foreign_key_checks = 1";
	         
	         pstmt1 = Main.conn.prepareStatement(query1);
	         pstmt1.setString(1, name);
	         pstmt1.setString(2, film);
	         pstmt2 = Main.conn.prepareStatement(query2);
	         pstmt3 = Main.conn.prepareStatement(query3);
	         
	         /*foreign key�� ���ؼ� ����,������ �ȵǴ� ���� ����*/
	         pstmt2.executeUpdate();
	         pstmt1.executeUpdate();
	         pstmt3.executeUpdate();
	         
	         /*������ ���� ��� commit�ϰ�, �׷��� �ʴٸ� rollback�Ѵ�*/ 
	         Main.conn.commit();
	         
	         }catch(SQLException se) {//����ó��
	            se.printStackTrace();
	               try{
	                  if(Main.conn!=null)
	                	  Main.conn.rollback();//�����߻��� rollback ó��
	                  }
	               catch(SQLException se2){
	                  se2.printStackTrace();
	                  }
	               }finally {
	                  System.out.println("������ ������ �Ϸ�Ǿ����ϴ�!");//������ ������ �Ϸ�Ǿ����� �˸��� �ȳ���
	               }
		}
}
