package DB2021TEAM11;
/*데이터베이스 sql문과 GUI를 사용하기위한 import*/
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*영화사 테이블에 삽입하는 인터페이스를 제공하는 클래스*/
public class InsertCompany extends JFrame implements ActionListener {//GUI와 이벤트 처리
	/*CompleteButton : 누르면 삽입이 완료됨
	 * CancleButton: 누르면 삽입이 취소되고 창이 닫힘*/
	JButton CompleteButton = new JButton("완료");
	JButton CancleButton = new JButton("취소");
	
	/*각 attribute에 삽입할 값을 받을 JTextField*/
	JTextField film_company = new JTextField(50);
	JTextField category = new JTextField(30);
	JTextField name = new JTextField(20);
	JTextField company_number = new JTextField(15);
	JTextField address = new JTextField(50);
	JTextField named_movie = new JTextField(50);
	
	/*삽입,갱신,삭제 매소드를 사용하기 위하여 DAO 객체 생성*/
	DAO dao = new DAO();
	
	/*생성자*/
	public InsertCompany() {
		/*창을 생성함*/
		this.setTitle("영화사 데이터 삽입");
		this.setSize(500,700);//창 크기
		this.setResizable(false);//창 크기를 바꿀 수 있는지에 대한 여부(false는 창 크기를 바꿀 수 없게 한다.)
		this.setLocationRelativeTo(null);//창이 가운데 나오도록 함
		this.setVisible(true);//창이 보이도록 함
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//창을 닫으면 JFrame이 꺼지도록 함
		this.setLayout(new GridLayout(7,2));
		
		/*사용자로부터 값을 입력받는 부분. 각 attribute에 넣을 값을 입력받음*/
		this.add(new JLabel("영화사 이름(영어입력)"));
		this.add(film_company);
		film_company.addActionListener((ActionListener) this);
		this.add(new JLabel("분류(film distributor company/film production company)"));
		this.add(category);
		category.addActionListener((ActionListener) this);
		this.add(new JLabel("대표자(영어입력)"));
		this.add(name);
		name.addActionListener((ActionListener) this);
		this.add(new JLabel("회사번호(000-000-0000)"));
		this.add(company_number);
		company_number.addActionListener((ActionListener) this);
		this.add(new JLabel("주소(도시)(영어입력)"));
		this.add(address);
		address.addActionListener((ActionListener) this);
		this.add(new JLabel("제작영화(영어입력)"));
		this.add(named_movie);
		named_movie.addActionListener((ActionListener) this);
		
		/*버튼*/
		this.add(CompleteButton);
		this.add(CancleButton);
		
		/*버튼을 눌렀을때의 이벤트처리에 대하여 연결하는 부분*/
		CompleteButton.addActionListener((ActionListener) this);
		CancleButton.addActionListener((ActionListener)this);
		
		}

	/*버튼을 눌렀을 때의 이벤트 처리에 대한 부분*/
	public void actionPerformed(ActionEvent e) {
		/*CompleteButton을 누른 경우 입력받은 값들을 insert_...()메소드에 넣어 호출한 후 창을 닫는다(모든 창을 닫는건 아님)
		 * CancleButton을 누른 경우 삽입하지 않고 창을 그냥 받는다(모든 창을 닫는건 아님)*/
        if(e.getSource() == CompleteButton){
        	try {
        		String fc = film_company.getText();
        		String c = category.getText();
        		String n = name.getText();
        		String cn = company_number.getText();
        		String a = address.getText();
        		String nm = named_movie.getText();

				dao.insert_company(fc,c,n,cn,a,nm);
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
