package DB2021TEAM11;
/*�����ͺ��̽� sql���� GUI swing�� ����ϱ����� import*/
import java.sql.*;
import javax.swing.*;

public class Main extends JFrame {
	//�����ͺ��̽����� ������ ���� �ʵ�
	private static String DRIVER = "oracle.jdbc.driver.OracleDriver";//����̹� �־��
	private static String DB_URL ="jdbc:mysql://localhost:3306/DB2021Team11";;//��� �ּ��� �����ͺ��̽��� �������� �־��
	private static String USER = "DB2021Team11";//���� ���̵�
	private static String PASSWORD = "DB2021Team11";//���� ��й�ȣ
	static Connection conn = null;//�����ͺ��̽� ������ ���� ��ü
	
	public static void main(String[] args) throws SQLException {
		conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);//�����ͺ��̽� ����
		
		GuiIntf fr = new GuiIntf();//GUI �������̽��� ǥ�����ֱ� ���ؼ� GuiIntf ��ü�� ������
		fr.FirstWindow();//GuiIntf Ŭ������ FirstWindow() �żҵ带 �̿��Ͽ� �� â�� ����
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//â�� �ݾ��� �� JFrame ���μ����� ������ �Ѵ�
		
	}

}
