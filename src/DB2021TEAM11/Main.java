package DB2021TEAM11;
/*데이터베이스 sql문과 GUI swing을 사용하기위한 import*/
import java.sql.*;
import javax.swing.*;

public class Main extends JFrame {
	//데이터베이스와의 연결을 위한 필드
	private static String DRIVER = "oracle.jdbc.driver.OracleDriver";//드라이버 넣어둠
	private static String DB_URL ="jdbc:mysql://localhost:3306/DB2021Team11";;//어느 주소의 데이터베이스와 연결할지 넣어둠
	private static String USER = "DB2021Team11";//유저 아이디
	private static String PASSWORD = "DB2021Team11";//유저 비밀번호
	static Connection conn = null;//데이터베이스 연결을 위한 객체
	
	public static void main(String[] args) throws SQLException {
		conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);//데이터베이스 연결
		
		GuiIntf fr = new GuiIntf();//GUI 인터페이스를 표현해주기 위해서 GuiIntf 객체를 생성함
		fr.FirstWindow();//GuiIntf 클래스의 FirstWindow() 매소드를 이용하여 새 창을 만듦
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//창을 닫았을 때 JFrame 프로세스가 끝나게 한다
		
	}

}
