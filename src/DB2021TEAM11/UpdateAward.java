package DB2021TEAM11;
/*데이터베이스 sql문과 GUI를 사용하기위한 import*/
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*수상정보 테이블에 갱신하는 인터페이스를 제공하는 클래스*/
public class UpdateAward extends JFrame implements ActionListener {
	/*CompleteButton : 누르면 갱신이 완료됨
	 * CancleButton: 누르면 갱신이 취소되고 창이 닫힘*/
	JButton CompleteButton = new JButton("완료");
	JButton CancleButton = new JButton("취소");
	
	/*menu : 갱신할 항목(attribute)를 입력받는 JTextField
	 * award_name, film_name : 갱신할 튜플을 선별하는데 이용할 값(영화제 이름, 출품작이름)을 입력받는 JTextField
	 * update_thing : 갱신할 값을 입력받는 JTextField*/
	JTextField menu = new JTextField(20);
	JTextField award_name = new JTextField(50);
	JTextField film_name = new JTextField(50);
	JTextField update_thing = new JTextField(50);
	
	/*라벨, 텍스트 필드, 버튼의 배치를 위한 패널*/
	JPanel jp1 = new JPanel();
	JPanel jp2 = new JPanel();
	
	/*삽입,갱신,삭제 매소드를 사용하기 위하여 DAO 객체 생성*/
	DAO dao = new DAO();
	
	/*생성자*/
	public UpdateAward() {
		/*창을 생성함*/
		this.setTitle("영화사 데이터 갱신");
		this.setSize(700,500);//창 크기
		this.setResizable(false);//창 크기를 바꿀 수 있는지에 대한 여부(false는 창 크기를 바꿀 수 없게 한다.)
		this.setLocationRelativeTo(null);//창이 가운데 나오도록 함
		this.setVisible(true);//창이 보이도록 함
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//창을 닫으면 JFrame이 꺼지도록 함
		
		/*라벨, 텍스트 필드, 버튼의 배치를 위하여 레이아웃 설정함. 해당 레이아웃은 동,서,남,북,중앙 으로 나눠서 배치할 수 있게 함*/
		this.setLayout(new BorderLayout());
		
		/*사용자로부터 값을 입력받는 부분.*/
		jp1.add(new JLabel("<html>[메뉴]<br>수상 연도(year)<br>영화제 이름(festival_name)<br>출품작(film)<br>감독(director)</html>"));
		jp2.add(new JLabel("갱신할 항목(위 메뉴 중 골라 영어입력)"));
		jp2.add(menu);
		menu.addActionListener((ActionListener) this);
		jp2.add(new JLabel("갱신할 수상기록의 영화제(영어입력)(일괄갱신:영화제,영화 둘다 All)"));
		jp2.add(award_name);
		award_name.addActionListener((ActionListener) this);
		jp2.add(new JLabel("갱신할 수상기록의 출품작(영어입력)(일괄갱신:영화사,영화 둘다 All)"));
		jp2.add(film_name);
		film_name.addActionListener((ActionListener) this);
		jp2.add(new JLabel("갱신정보(선택한 항목에 따라 다르게 입력)"));
		jp2.add(update_thing);
		update_thing.addActionListener((ActionListener) this);
		jp2.add("South",CompleteButton);//버튼
		
		/*라벨, 버튼, 덱스트필들를 넣은 패널들 배치함*/
		this.add("North",jp1);
		this.add("Center",jp2);
		this.add("South",CancleButton);//버튼
		
		/*버튼을 눌렀을때의 이벤트처리에 대하여 연결하는 부분*/
		CompleteButton.addActionListener((ActionListener) this);
		CancleButton.addActionListener((ActionListener)this);
		
		}
	/*버튼을 눌렀을 때의 이벤트 처리에 대한 부분*/
	public void actionPerformed(ActionEvent e) {
		/*CompleteButton을 누른 경우 입력받은 값들을 update_...()메소드에 넣어 호출한 후 창을 닫는다(모든 창을 닫는건 아님)
		 * CancleButton을 누른 경우 삽입하지 않고 창을 그냥 받는다(모든 창을 닫는건 아님)*/
        if(e.getSource() == CompleteButton){
        	try {
        		String m = menu.getText();
        		String an = award_name.getText();
        		String fn = film_name.getText();
        		String up = update_thing.getText();
        		
				dao.update_award(m,an,fn,up);
				dispose();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
        	
                }
        else if(e.getSource() == CancleButton){
        	dispose();
            }
        }
}
