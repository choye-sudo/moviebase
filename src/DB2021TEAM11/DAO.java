package DB2021TEAM11;
import java.sql.*;//jdbc를 활용하기 위한 import

/*데이터베이스에 데이터를 삽입, 갱신, 삭제할 수 있는 메소드를 포함하는 클래스임*/
public class DAO {//Data Access Object(데이터 접근 클래스)
	
	/*삽입(Insert) 관련 매소드*/
	
	/*영화(DB2021_Movies) 테이블 삽입*/
	public void insert_movie(String name, String genre, int running_time, String date, String actor, float rating, int attandance, int prefered_age, String prefered_gender, String film_company, String director) throws SQLException{
		PreparedStatement pstmt = null;//사용자로부터 입력을 받아 데이터베이스에 넣기 위해 PreparedStatement 객체를 생성하고 null으로 처리.
		try {
			Main.conn.setAutoCommit(false);//transaction을 위하여 auto commit이 되지 않게함
	         
			/*DB2021_Movies 테이블에 insert하는 쿼리문을 PreparedStatement 객체에 넣어줌*/
	         String query_movie = "INSERT INTO DB2021_Movies VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
	         pstmt = Main.conn.prepareStatement(query_movie);
	         
	         /*PreparedStatement 객체에 JTestField에서 입력받은 값 넘겨받아서 넣어줌(쿼리의 ?부분에 차례대로 들어감)*/
	         pstmt.setString(1, name); //영화 이름
	         pstmt.setString(2, genre);//영화 장르
	         pstmt.setInt(3, running_time);//상영 시간
	         pstmt.setString(4, date);//개봉 날짜
	         pstmt.setString(5, actor);//출연 배우
	         pstmt.setFloat(6, rating);//평점
	         pstmt.setInt(7, attandance);//관객 수
	         pstmt.setInt(8, prefered_age);//선호연령층
	         pstmt.setString(9, prefered_gender);//선호성별
	         pstmt.setString(10, film_company);//영화사
	         pstmt.setString(11, director);//감독
	         
	         pstmt.executeUpdate();//입력된 쿼리를 데이터베이스에 적용되게 함. 입력된 데이터 해당 테이블에 insert됨.
	         Main.conn.commit();//에러가 없다면 commit 수행
	         
	         /*예외처리*/
	         }catch(SQLException se) {
	            se.printStackTrace();
	               try{
	                  if(Main.conn!=null)
	                	  Main.conn.rollback();//에러 발생 시 rollback 처리
	                  }
	               catch(SQLException se2){
	                  se2.printStackTrace();
	                  }
	               }finally {
	                  System.out.println("데이터 삽입이 완료되었습니다!");//데이터 삽입이 완료되었음을 알리는 안내문
	               }
	}
	
	/*영화사(DB2021_Company) 테이블 삽입*/
	public void insert_company(String company, String category, String CEO, String telnum, String address, String named_movie) throws SQLException{
		PreparedStatement pstmt = null;//사용자로부터 입력을 받아 데이터베이스에 넣기 위해 PreparedStatement 객체를 생성하고 null으로 처리.
		try {
			Main.conn.setAutoCommit(false);//transaction을 위하여 auto commit이 되지 않게함
	         
			/*PreparedStatement 객체에 JTestField에서 입력받은 값 넘겨받아서 넣어줌(쿼리의 ?부분에 차례대로 들어감)*/
	         String query_company = "INSERT INTO DB2021_Company VALUES(?, ?, ?, ?, ?, ?)";
	         pstmt = Main.conn.prepareStatement(query_company);

	         /*PreparedStatement 객체에 JTestField에서 입력받은 값 넘겨받아서 넣어줌(쿼리의 ?부분에 차례대로 들어감)*/
	         pstmt.setString(1, company);//회사명
	         pstmt.setString(2, category);//회사 분류
	         pstmt.setString(3, CEO);//회사 대표
	         pstmt.setString(4, telnum);//회사 전화번호
	         pstmt.setString(5, address);//회사 주소(도시)
	         pstmt.setString(6, named_movie);//제작 영화
	         
	         //입력된 쿼리를 데이터베이스에 적용되게 함. 입력된 데이터 해당 테이블에 insert됨
	         pstmt.executeUpdate();
	         
	         //에러가 없다면 commit 수행
	         Main.conn.commit();
	         
	         }catch(SQLException se) {//예외처리
	            se.printStackTrace();
	               try{
	                  if(Main.conn!=null)
	                	  Main.conn.rollback();//에러발생시 rollback 처리
	                  }
	               catch(SQLException se2){
	                  se2.printStackTrace();
	                  }
	               }finally {
	                  System.out.println("데이터 삽입이 완료되었습니다!");//데이터 삽입이 완료되었음을 알리는 안내문
	               }
	}
	
	/*영화제(DB2021_Festival) 테이블 삽입*/
	public void insert_festival(String festival_name, String country, String city, int begin_year) throws SQLException{
		PreparedStatement pstmt = null;//사용자로부터 입력을 받아 데이터베이스에 넣기 위해 PreparedStatement 객체를 생성하고 null으로 처리.
		try {
			Main.conn.setAutoCommit(false);//transaction을 위하여 auto commit이 되지 않도록 함.
	         
			/*PreparedStatement 객체에 JTestField에서 입력받은 값 넘겨받아서 넣어줌(쿼리의 ?부분에 차례대로 들어감)*/
	         String query_festival = "INSERT INTO DB2021_Festival VALUES(?, ?, ?, ?)";//DB2021_Festival 테이블에 insert하는 쿼리문
	         pstmt = Main.conn.prepareStatement(query_festival);
	         
	         /*PreparedStatement 객체에 JTestField에서 입력받은 값 넘겨받아서 넣어줌(쿼리의 ?부분에 차례대로 들어감)*/
	         pstmt.setString(1, festival_name); //영화제 이름
	         pstmt.setString(2, country);//개최 국가
	         pstmt.setString(3, city);//개최 도시
	         pstmt.setInt(4, begin_year);//최초개막년
	         
	         //입력된 쿼리를 데이터베이스에 적용되게 함. 입력된 데이터 해당 테이블에 insert됨.
	         pstmt.executeUpdate();
	         
	         //에러가 없다면 commit 수행
	         Main.conn.commit();
	         }catch(SQLException se) {//예외처리
	            se.printStackTrace();
	               try{
	                  if(Main.conn!=null)
	                	  Main.conn.rollback();//에러발생시 rollback 처리
	                  }
	               catch(SQLException se2){
	                  se2.printStackTrace();
	                  }
	               }finally {
	                  System.out.println("데이터 삽입이 완료되었습니다!");//데이터 삽입이 완료되었음을 알리는 안내문
	               }
	}
	
	/*배우(DB2021_Actor) 테이블 삽입*/
	public void insert_actor(String actor_name, String actor_gender, String birth, String film) throws SQLException{
		PreparedStatement pstmt = null;//사용자로부터 입력을 받아 데이터베이스에 넣기 위해 PreparedStatement 객체를 생성하고 null으로 처리.
		try {
			Main.conn.setAutoCommit(false);//transaction을 위하여 auto commit이 되지 않도록 함.
	         
			/*PreparedStatement 객체에 JTestField에서 입력받은 값 넘겨받아서 넣어줌(쿼리의 ?부분에 차례대로 들어감)*/
	         String query_actor = "INSERT INTO DB2021_Actor VALUES(?, ?, ?, ?)";//DB2021_Actor 테이블에 insert하는 쿼리문
	         pstmt = Main.conn.prepareStatement(query_actor);
	         
	         /*PreparedStatement 객체에 JTestField에서 입력받은 값 넘겨받아서 넣어줌(쿼리의 ?부분에 차례대로 들어감)*/
	         pstmt.setString(1, actor_name);//배우 이름
	         pstmt.setString(2, actor_gender);//성별
	         pstmt.setString(3, birth);//생년월일
	         pstmt.setString(4, film);//출연영화
	         
	         //입력된 쿼리를 데이터베이스에 적용되게 함. 입력된 데이터 해당 테이블에 insert됨.
	         pstmt.executeUpdate();
	         
	         //에러가 없다면 commit 수행
	         Main.conn.commit();
	         }catch(SQLException se) {//예외처리
	            se.printStackTrace();
	               try{
	                  if(Main.conn!=null)
	                	  Main.conn.rollback();//에러발생시 rollback 처리
	                  }
	               catch(SQLException se2){
	                  se2.printStackTrace();
	                  }
	               }finally {
	                  System.out.println("데이터 삽입이 완료되었습니다!");//데이터 삽입이 완료되었음을 알리는 안내문
	               }
	}
	
	/*수상정보(DB2021_Award) 테이블 삽입*/
	public void insert_award(int year, String festival, String prized_film, String prized_director) throws SQLException{
		PreparedStatement pstmt = null;//사용자로부터 입력을 받아 데이터베이스에 넣기 위해 PreparedStatement 객체를 생성하고 null으로 처리.
		try {
			Main.conn.setAutoCommit(false);//transaction을 위하여 auto commit이 되지 않도록 함.
	         
			/*PreparedStatement 객체에 JTestField에서 입력받은 값 넘겨받아서 넣어줌(쿼리의 ?부분에 차례대로 들어감)*/
	         String query_award = "INSERT INTO DB2021_Award VALUES(?, ?, ?, ?)";//DB2021_Award 테이블에 insert하는 쿼리문
	         pstmt = Main.conn.prepareStatement(query_award);
	         
	         /*PreparedStatement 객체에 JTestField에서 입력받은 값 넘겨받아서 넣어줌(쿼리의 ?부분에 차례대로 들어감)*/
	         pstmt.setInt(1, year); //수상년도
	         pstmt.setString(2, festival);//영화제이름
	         pstmt.setString(3, prized_film);//출품작(영화)
	         pstmt.setString(4, prized_director);//감독
	         
	         //입력된 쿼리를 데이터베이스에 적용되게 함. 입력된 데이터 해당 테이블에 insert됨.
	         pstmt.executeUpdate();
	         
	         //에러가 없다면 commit 수행
	         Main.conn.commit();
	         }catch(SQLException se) {//예외처리
	            se.printStackTrace();
	               try{
	                  if(Main.conn!=null)
	                	  Main.conn.rollback();//에러발생시 rollback 처리
	                  }
	               catch(SQLException se2){
	                  se2.printStackTrace();
	                  }
	               }finally {
	                  System.out.println("데이터 삽입이 완료되었습니다!");//데이터 삽입이 완료되었음을 알리는 안내문
	               }
	}
	
	
	
	/*갱신(Update) 관련 매소드*/
	
	/*영화(DB2021_Movies) 테이블 갱신*/
	public void update_movie(String menu, String name, String update_thing) throws SQLException{
		/*사용자로부터 입력을 받아 데이터베이스에 적용시키도록 하기 위해 PreparedStatement 객체들을 생성하고 null으로 처리
		 * pstmt1에는 갱신을 위한 쿼리문을 넣어주고, pstmt2, pstmt3에는 foreign key 체크를 푸는 쿼리와 다시 체크하는 쿼리를 넣어줌*/
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;

        try {
        	Main.conn.setAutoCommit(false);//transaction을 위하여 auto commit이 되지 않도록 함.
        	
        	String query1 = null;//쿼리문을 넣어줄 문자열변수
        	
        	//foreign key로 인해서 갱신,삭제가 안되는 예외가 발생하는데, 이를 막기 위해서 foreign key 체크를 풀거나 다시 체크할 수 있는 쿼리문을 작성
        	String query2 = "SET foreign_key_checks = 0";
        	String query3 = "SET foreign_key_checks = 1";
        	
        	if(name.equals("All")) {//해당 항목 일괄 갱신
                query1 = "UPDATE DB2021_Movies SET "+menu+" = ?";//갱신하는 쿼리문. menu는 갱신할 항목(attribute)을 의미함
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
        	
        	/*foreign key로 인해서 갱신,삭제가 안되는 예외 방지*/
        	pstmt2.executeUpdate();
        	pstmt1.executeUpdate();
        	pstmt3.executeUpdate();
        	
        	/*에러가 없을 경우 commit하고, 그렇지 않다면 rollback한다*/ 
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
                	System.out.println("데이터 갱신이 완료되었습니다.");
                	}
     	}
	
	/*영화사(DB2021_Company) 테이블 삽입*/
	public void update_company(String menu, String company_name, String film_name, String update_thing) throws SQLException{
		/*사용자로부터 입력을 받아 데이터베이스에 적용시키도록 하기 위해 PreparedStatement 객체들을 생성하고 null으로 처리
		 * pstmt1에는 갱신을 위한 쿼리문을 넣어주고, pstmt2, pstmt3에는 foreign key 체크를 푸는 쿼리와 다시 체크하는 쿼리를 넣어줌*/
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;

        try {
        	Main.conn.setAutoCommit(false);//transaction을 위하여 auto commit이 되지 않도록 함.
        	
        	String query1 = null;//쿼리문을 넣어줄 문자열변수
        	
        	//foreign key로 인해서 갱신,삭제가 안되는 예외가 발생하는데, 이를 막기 위해서 foreign key 체크를 풀거나 다시 체크할 수 있는 쿼리문을 작성
        	String query2 = "SET foreign_key_checks = 0";
        	String query3 = "SET foreign_key_checks = 1";
        	
        	/*menu는 갱신할 항목(attribute)을 의미한다. 
        	 * All을 입력했을 경우 갱신할 항목을 일괄갱신하며, 그렇지 않은 경우에는 입력받은 변수값과 일치하는 튜플의 항목만 갱신한다.*/
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
        	
        	/*foreign key로 인해서 갱신,삭제가 안되는 예외 방지*/
        	pstmt2.executeUpdate();
        	pstmt1.executeUpdate();
        	pstmt3.executeUpdate();
        	
        	/*에러가 없을 경우 commit하고, 그렇지 않다면 rollback한다*/ 
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
                	System.out.println("데이터 갱신이 완료되었습니다.");
                	}
     	}
	
	/*영화제(DB2021_Festival) 테이블 갱신*/
	public void update_festival(String menu, String name, String update_thing) throws SQLException{
		/*사용자로부터 입력을 받아 데이터베이스에 적용시키도록 하기 위해 PreparedStatement 객체들을 생성하고 null으로 처리
		 * pstmt1에는 갱신을 위한 쿼리문을 넣어주고, pstmt2, pstmt3에는 foreign key 체크를 푸는 쿼리와 다시 체크하는 쿼리를 넣어줌*/
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;

        try {
        	Main.conn.setAutoCommit(false);//transaction을 위하여 auto commit이 되지 않도록 함.
        	
        	String query1 = null;//쿼리문을 넣어줄 문자열변수
        	
        	//foreign key로 인해서 갱신,삭제가 안되는 예외가 발생하는데, 이를 막기 위해서 foreign key 체크를 풀거나 다시 체크할 수 있는 쿼리문을 작성
        	String query2 = "SET foreign_key_checks = 0";
        	String query3 = "SET foreign_key_checks = 1";
        	
        	/*menu는 갱신할 항목(attribute)을 의미한다. 
        	 * All을 입력했을 경우 갱신할 항목을 일괄갱신하며, 그렇지 않은 경우에는 입력받은 변수값과 일치하는 튜플의 항목만 갱신한다.*/
        	if(name.equals("All")) {//해당 항목 일괄 갱신
        		query1 = "UPDATE DB2021_Festival SET "+menu+" = ?";//갱신하는 쿼리문. menu는 갱신할 항목(attribute)을 의미함
                pstmt1 = Main.conn.prepareStatement(query1);
                pstmt1.setString(1, update_thing);
             }
        	else {
        		query1 = "UPDATE DB2021_Festival SET "+menu+" = ? WHERE name= ? ";//갱신하는 쿼리문. menu는 갱신할 항목(attribute)을 의미함
        		pstmt1 = Main.conn.prepareStatement(query1);
        		pstmt1.setString(1, update_thing);
        		pstmt1.setString(2, name);
        	}
        	pstmt2 = Main.conn.prepareStatement(query2);
        	pstmt3 = Main.conn.prepareStatement(query3);
        	
        	/*foreign key로 인해서 갱신,삭제가 안되는 예외 방지*/
        	pstmt2.executeUpdate();
        	pstmt1.executeUpdate();
        	pstmt3.executeUpdate();
        	
        	/*에러가 없을 경우 commit하고, 그렇지 않다면 rollback한다*/ 
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
                	System.out.println("데이터 갱신이 완료되었습니다.");
                	}
     	}
	
	/*배우(DB2021_Actor) 테이블 갱신*/
	public void update_actor(String menu, String name, String film_name, String update_thing) throws SQLException{
		/*사용자로부터 입력을 받아 데이터베이스에 적용시키도록 하기 위해 PreparedStatement 객체들을 생성하고 null으로 처리
		 * pstmt1에는 갱신을 위한 쿼리문을 넣어주고, pstmt2, pstmt3에는 foreign key 체크를 푸는 쿼리와 다시 체크하는 쿼리를 넣어줌*/
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;

        try {
        	Main.conn.setAutoCommit(false);//transaction을 위하여 auto commit이 되지 않도록 함.
        	
        	String query1 = null;//쿼리문을 넣어줄 문자열변수
        	
        	//foreign key로 인해서 갱신,삭제가 안되는 예외가 발생하는데, 이를 막기 위해서 foreign key 체크를 풀거나 다시 체크할 수 있는 쿼리문을 작성
        	String query2 = "SET foreign_key_checks = 0";
        	String query3 = "SET foreign_key_checks = 1";
        	
        	/*menu는 갱신할 항목(attribute)을 의미한다. 
        	 * All을 입력했을 경우 갱신할 항목을 일괄갱신하며, 그렇지 않은 경우에는 입력받은 변수값과 일치하는 튜플의 항목만 갱신한다.*/
        	if(name.equals("All")&&film_name.equals("All")) {//해당 항목 일괄 갱신
        		query1 = "UPDATE DB2021_Actor SET "+menu+" = ?";//갱신하는 쿼리문. menu는 갱신할 항목(attribute)을 의미함
                pstmt1 = Main.conn.prepareStatement(query1);
                pstmt1.setString(1, update_thing);
             }
        	else {
        		query1 = "UPDATE DB2021_Actor SET "+menu+" = ? WHERE name= ? AND film= ? ";//갱신하는 쿼리문. menu는 갱신할 항목(attribute)을 의미함
        		pstmt1 = Main.conn.prepareStatement(query1);
        		pstmt1.setString(1, update_thing);
        		pstmt1.setString(2, name);
        		pstmt1.setString(3, film_name);
        	}
        	pstmt2 = Main.conn.prepareStatement(query2);
        	pstmt3 = Main.conn.prepareStatement(query3);
        	
        	/*foreign key로 인해서 갱신,삭제가 안되는 예외 방지*/
        	pstmt2.executeUpdate();
        	pstmt1.executeUpdate();
        	pstmt3.executeUpdate();
        	
        	/*에러가 없을 경우 commit하고, 그렇지 않다면 rollback한다*/ 
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
                	System.out.println("데이터 갱신이 완료되었습니다.");
                	}
     	}
	
	/*수상정보(DB2021_Award) 테이블 갱신*/
	public void update_award(String menu, String name, String film_name, String update_thing) throws SQLException{
		/*사용자로부터 입력을 받아 데이터베이스에 적용시키도록 하기 위해 PreparedStatement 객체들을 생성하고 null으로 처리
		 * pstmt1에는 갱신을 위한 쿼리문을 넣어주고, pstmt2, pstmt3에는 foreign key 체크를 푸는 쿼리와 다시 체크하는 쿼리를 넣어줌*/
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;

        try {
        	Main.conn.setAutoCommit(false);//transaction을 위하여 auto commit이 되지 않도록 함.
        	
        	String query1 = null;//쿼리문을 넣어줄 문자열변수
        	
        	//foreign key로 인해서 갱신,삭제가 안되는 예외가 발생하는데, 이를 막기 위해서 foreign key 체크를 풀거나 다시 체크할 수 있는 쿼리문을 작성
        	String query2 = "SET foreign_key_checks = 0";
        	String query3 = "SET foreign_key_checks = 1";
        	
        	/*menu는 갱신할 항목(attribute)을 의미한다. 
        	 * All을 입력했을 경우 갱신할 항목을 일괄갱신하며, 그렇지 않은 경우에는 입력받은 변수값과 일치하는 튜플의 항목만 갱신한다.*/
        	if(name.equals("All")&&film_name.equals("All")) {//해당 항목 일괄 갱신
        		query1 = "UPDATE DB2021_Award SET "+menu+" = ?";//갱신하는 쿼리문. menu는 갱신할 항목(attribute)을 의미함
                pstmt1 = Main.conn.prepareStatement(query1);
                pstmt1.setString(1, update_thing);
             }
        	else {
        		query1 = "UPDATE DB2021_Award SET "+menu+" = ? WHERE festival_name= ? AND film= ?";//갱신하는 쿼리문. menu는 갱신할 항목(attribute)을 의미함
        		pstmt1 = Main.conn.prepareStatement(query1);
        		pstmt1.setString(1, update_thing);
        		pstmt1.setString(2, name);
        		pstmt1.setString(3, film_name);
        	}
        	pstmt2 = Main.conn.prepareStatement(query2);
        	pstmt3 = Main.conn.prepareStatement(query3);
        	
        	/*foreign key로 인해서 갱신,삭제가 안되는 예외 방지*/
        	pstmt2.executeUpdate();
        	pstmt1.executeUpdate();
        	pstmt3.executeUpdate();
        	
        	/*에러가 없을 경우 commit하고, 그렇지 않다면 rollback한다*/ 
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
                	System.out.println("데이터 갱신이 완료되었습니다.");
                	}
     	}
	
	/*삭제(delete)를 관련 메소드*/
	
	/*영화(DB2021_Movies) 테이블 삭제*/
    public void delete_movie(String name) throws SQLException{
    	/*사용자로부터 입력을 받아 데이터베이스에 적용시키도록 하기 위해 PreparedStatement 객체들을 생성하고 null으로 처리
		 * pstmt1에는 삭제를 위한 쿼리문을 넣어주고, pstmt2, pstmt3에는 foreign key 체크를 푸는 쿼리와 다시 체크하는 쿼리를 넣어줌*/
    	PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		
		try {
			Main.conn.setAutoCommit(false);//transaction을 위하여 auto commit이 되지 않도록 함.
	         
			
	         String query1 = "DELETE from DB2021_Movies WHERE name = ?";//사용자가 입력한 값과 일치하는 항목 값을 가진 튜플을 삭제한다.
	       //foreign key로 인해서 갱신,삭제가 안되는 예외가 발생하는데, 이를 막기 위해서 foreign key 체크를 풀거나 다시 체크할 수 있는 쿼리문을 작성
	         String query2 = "SET foreign_key_checks = 0";
	         String query3 = "SET foreign_key_checks = 1";
	         
	         pstmt1 = Main.conn.prepareStatement(query1);
	         pstmt1.setString(1, name);
	         pstmt2 = Main.conn.prepareStatement(query2);
	         pstmt3 = Main.conn.prepareStatement(query3);
	         
	         /*foreign key로 인해서 갱신,삭제가 안되는 예외 방지*/
	         pstmt2.executeUpdate();
	         pstmt1.executeUpdate();
	         pstmt3.executeUpdate();
	         
	         /*에러가 없을 경우 commit하고, 그렇지 않다면 rollback한다*/ 
	         Main.conn.commit();
	         
	         }catch(SQLException se) {//예외처리
	            se.printStackTrace();
	               try{
	                  if(Main.conn!=null)
	                	  Main.conn.rollback();//에러발생시 rollback 처리
	                  }
	               catch(SQLException se2){
	                  se2.printStackTrace();
	                  }
	               }finally {
	                  System.out.println("데이터 삭제가 완료되었습니다!");//데이터 삽입이 완료되었음을 알리는 안내문
	               }
		}
    
    /*영화사(DB2021_Company) 테이블 삭제*/
    public void delete_company(String company_name, String film_name) throws SQLException{
    	/*사용자로부터 입력을 받아 데이터베이스에 적용시키도록 하기 위해 PreparedStatement 객체들을 생성하고 null으로 처리
		 * pstmt1에는 삭제를 위한 쿼리문을 넣어주고, pstmt2, pstmt3에는 foreign key 체크를 푸는 쿼리와 다시 체크하는 쿼리를 넣어줌*/
    	PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		
		try {
			Main.conn.setAutoCommit(false);//transaction을 위하여 auto commit이 되지 않도록 함.
	         
	         String query1 = "DELETE from DB2021_Company WHERE film_company = ? AND named_movie = ?";//사용자가 입력한 값과 일치하는 항목 값을 가진 튜플을 삭제한다.
	       //foreign key로 인해서 갱신,삭제가 안되는 예외가 발생하는데, 이를 막기 위해서 foreign key 체크를 풀거나 다시 체크할 수 있는 쿼리문을 작성
	         String query2 = "SET foreign_key_checks = 0";
	         String query3 = "SET foreign_key_checks = 1";
	         
	         pstmt1 = Main.conn.prepareStatement(query1);
	         pstmt1.setString(1, company_name);
	         pstmt1.setString(2, film_name);
	         pstmt2 = Main.conn.prepareStatement(query2);
	         pstmt3 = Main.conn.prepareStatement(query3);
	         
	         /*foreign key로 인해서 갱신,삭제가 안되는 예외 방지*/
	         pstmt2.executeUpdate();
	         pstmt1.executeUpdate();
	         pstmt3.executeUpdate();
	         
	         /*에러가 없을 경우 commit하고, 그렇지 않다면 rollback한다*/ 
	         Main.conn.commit();
	         
	         }catch(SQLException se) {//예외처리
	            se.printStackTrace();
	               try{
	                  if(Main.conn!=null)
	                	  Main.conn.rollback();//에러발생시 rollback 처리
	                  }
	               catch(SQLException se2){
	                  se2.printStackTrace();
	                  }
	               }finally {
	                  System.out.println("데이터 삭제가 완료되었습니다!");//데이터 삽입이 완료되었음을 알리는 안내문
	               }
		}
    
    /*영화제(DB2021_Festival) 테이블 삭제*/
    public void delete_festival(String name) throws SQLException{
    	/*사용자로부터 입력을 받아 데이터베이스에 적용시키도록 하기 위해 PreparedStatement 객체들을 생성하고 null으로 처리
		 * pstmt1에는 삭제를 위한 쿼리문을 넣어주고, pstmt2, pstmt3에는 foreign key 체크를 푸는 쿼리와 다시 체크하는 쿼리를 넣어줌*/
    	PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		
		try {
			Main.conn.setAutoCommit(false);//transaction을 위하여 auto commit이 되지 않도록 함.
	         
	         String query1 = "DELETE from DB2021_Festival WHERE name = ? ";//사용자가 입력한 값과 일치하는 항목 값을 가진 튜플을 삭제한다.
	       //foreign key로 인해서 갱신,삭제가 안되는 예외가 발생하는데, 이를 막기 위해서 foreign key 체크를 풀거나 다시 체크할 수 있는 쿼리문을 작성
	         String query2 = "SET foreign_key_checks = 0";
	         String query3 = "SET foreign_key_checks = 1";
	         
	         pstmt1 = Main.conn.prepareStatement(query1);
	         pstmt1.setString(1, name);
	         pstmt2 = Main.conn.prepareStatement(query2);
	         pstmt3 = Main.conn.prepareStatement(query3);
	         
	         /*foreign key로 인해서 갱신,삭제가 안되는 예외 방지*/
	         pstmt2.executeUpdate();
	         pstmt1.executeUpdate();
	         pstmt3.executeUpdate();
	         
	         /*에러가 없을 경우 commit하고, 그렇지 않다면 rollback한다*/ 
	         Main.conn.commit();
	         
	         }catch(SQLException se) {//예외처리
	            se.printStackTrace();
	               try{
	                  if(Main.conn!=null)
	                	  Main.conn.rollback();//에러발생시 rollback 처리
	                  }
	               catch(SQLException se2){
	                  se2.printStackTrace();
	                  }
	               }finally {
	                  System.out.println("데이터 삭제가 완료되었습니다!");//데이터 삽입이 완료되었음을 알리는 안내문
	               }
		}
    
    /*배우(DB2021_Actor) 테이블 삭제*/
    public void delete_actor(String name, String film) throws SQLException{
    	/*사용자로부터 입력을 받아 데이터베이스에 적용시키도록 하기 위해 PreparedStatement 객체들을 생성하고 null으로 처리
		 * pstmt1에는 삭제를 위한 쿼리문을 넣어주고, pstmt2, pstmt3에는 foreign key 체크를 푸는 쿼리와 다시 체크하는 쿼리를 넣어줌*/
    	PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		
		try {
			Main.conn.setAutoCommit(false);//transaction을 위하여 auto commit이 되지 않도록 함.
	         
	         String query1 = "DELETE from DB2021_Actor WHERE name = ? AND film = ?";//사용자가 입력한 값과 일치하는 항목 값을 가진 튜플을 삭제한다.
	       //foreign key로 인해서 갱신,삭제가 안되는 예외가 발생하는데, 이를 막기 위해서 foreign key 체크를 풀거나 다시 체크할 수 있는 쿼리문을 작성
	         String query2 = "SET foreign_key_checks = 0";
	         String query3 = "SET foreign_key_checks = 1";
	         
	         pstmt1 = Main.conn.prepareStatement(query1);
	         pstmt1.setString(1, name);
	         pstmt1.setString(2, film);
	         pstmt2 = Main.conn.prepareStatement(query2);
	         pstmt3 = Main.conn.prepareStatement(query3);
	         
	         /*foreign key로 인해서 갱신,삭제가 안되는 예외 방지*/
	         pstmt2.executeUpdate();
	         pstmt1.executeUpdate();
	         pstmt3.executeUpdate();
	         
	         /*에러가 없을 경우 commit하고, 그렇지 않다면 rollback한다*/ 
	         Main.conn.commit();
	         
	         }catch(SQLException se) {//예외처리
	            se.printStackTrace();
	               try{
	                  if(Main.conn!=null)
	                	  Main.conn.rollback();//에러발생시 rollback 처리
	                  }
	               catch(SQLException se2){
	                  se2.printStackTrace();
	                  }
	               }finally {
	                  System.out.println("데이터 삭제가 완료되었습니다!");//데이터 삽입이 완료되었음을 알리는 안내문
	               }
		}
    
    /*수상정보(DB2021_Award) 테이블 삭제*/
    public void delete_award(String name, String film) throws SQLException{
    	/*사용자로부터 입력을 받아 데이터베이스에 적용시키도록 하기 위해 PreparedStatement 객체들을 생성하고 null으로 처리
		 * pstmt1에는 삭제를 위한 쿼리문을 넣어주고, pstmt2, pstmt3에는 foreign key 체크를 푸는 쿼리와 다시 체크하는 쿼리를 넣어줌*/
    	PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		
		try {
			Main.conn.setAutoCommit(false);//transaction을 위하여 auto commit이 되지 않도록 함.
	         
	         String query1 = "DELETE from DB2021_Award WHERE festival_name = ? AND film = ?";//사용자가 입력한 값과 일치하는 항목 값을 가진 튜플을 삭제한다.
	       //foreign key로 인해서 갱신,삭제가 안되는 예외가 발생하는데, 이를 막기 위해서 foreign key 체크를 풀거나 다시 체크할 수 있는 쿼리문을 작성
	         String query2 = "SET foreign_key_checks = 0";
	         String query3 = "SET foreign_key_checks = 1";
	         
	         pstmt1 = Main.conn.prepareStatement(query1);
	         pstmt1.setString(1, name);
	         pstmt1.setString(2, film);
	         pstmt2 = Main.conn.prepareStatement(query2);
	         pstmt3 = Main.conn.prepareStatement(query3);
	         
	         /*foreign key로 인해서 갱신,삭제가 안되는 예외 방지*/
	         pstmt2.executeUpdate();
	         pstmt1.executeUpdate();
	         pstmt3.executeUpdate();
	         
	         /*에러가 없을 경우 commit하고, 그렇지 않다면 rollback한다*/ 
	         Main.conn.commit();
	         
	         }catch(SQLException se) {//예외처리
	            se.printStackTrace();
	               try{
	                  if(Main.conn!=null)
	                	  Main.conn.rollback();//에러발생시 rollback 처리
	                  }
	               catch(SQLException se2){
	                  se2.printStackTrace();
	                  }
	               }finally {
	                  System.out.println("데이터 삭제가 완료되었습니다!");//데이터 삽입이 완료되었음을 알리는 안내문
	               }
		}
}
