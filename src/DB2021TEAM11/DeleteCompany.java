package DB2021TEAM11;
/*데이터베이스 sql문과 GUI를 사용하기위한 import*/
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*영화사 테이블에서 삭제하는 인터페이스를 제공하는 클래스*/
public class DeleteCompany extends JFrame implements ActionListener {
	/*CompleteButton : 누르면 삭제가 완료됨
	 * CancleButton: 누르면 삭제가 취소되고 창이 닫힘*/
	JButton CompleteButton = new JButton("삭제");
	JButton CancleButton = new JButton("취소");
	
	/*삭제할 튜플을 선별할 값을(영화사 이름, 영화 이름)를 입력받는다*/
	JTextField company_name = new JTextField(50);
	JTextField film_name = new JTextField(50);
	
	/*삽입,갱신,삭제 매소드를 사용하기 위하여 DAO 객체 생성*/
	DAO dao = new DAO();
	
	/*생성자*/
	public DeleteCompany() {
		/*창을 생성함*/
		this.setTitle("영화사 데이터 삭제");
		this.setSize(500,700);//창 크기
		this.setResizable(false);//창 크기를 바꿀 수 있는지에 대한 여부(false는 창 크기를 바꿀 수 없게 한다.)
		this.setLocationRelativeTo(null);//창이 가운데 나오도록 함
		this.setVisible(true);//창이 보이도록 함
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//창을 닫으면 JFrame이 꺼지도록 함
		this.setLayout(new GridLayout(12,2));
		
		/*사용자로부터 값을 입력받는 부분.*/
		this.add(new JLabel("삭제할 영화사 이름(영어입력)"));
		this.add(company_name);
		company_name.addActionListener((ActionListener) this);
		this.add(new JLabel("삭제할 영화사 제작영화(영어입력)"));
		this.add(film_name);
		film_name.addActionListener((ActionListener) this);
		
		/*버튼*/
		this.add(CompleteButton);
		this.add(CancleButton);
		
		/*버튼을 눌렀을때의 이벤트처리에 대하여 연결하는 부분*/
		CompleteButton.addActionListener((ActionListener) this);
		CancleButton.addActionListener((ActionListener)this);
		
		}
	/*버튼을 눌렀을 때의 이벤트 처리에 대한 부분*/
	public void actionPerformed(ActionEvent e) {
		/*CompleteButton을 누른 경우 입력받은 값들을 delete_...()메소드에 넣어 호출한 후 창을 닫는다(모든 창을 닫는건 아님)
		 * CancleButton을 누른 경우 삽입하지 않고 창을 그냥 받는다(모든 창을 닫는건 아님)*/
        if(e.getSource() == CompleteButton){
        	try {
        		String cn = company_name.getText();
        		String fn = film_name.getText();
        		
				dao.delete_company(cn,fn);
				dispose();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
        	
                }
        else if(e.getSource() == CancleButton){
        	dispose();
            }
        }

}
