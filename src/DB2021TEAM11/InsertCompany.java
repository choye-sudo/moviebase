package DB2021TEAM11;
/*�����ͺ��̽� sql���� GUI�� ����ϱ����� import*/
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*��ȭ�� ���̺� �����ϴ� �������̽��� �����ϴ� Ŭ����*/
public class InsertCompany extends JFrame implements ActionListener {//GUI�� �̺�Ʈ ó��
	/*CompleteButton : ������ ������ �Ϸ��
	 * CancleButton: ������ ������ ��ҵǰ� â�� ����*/
	JButton CompleteButton = new JButton("�Ϸ�");
	JButton CancleButton = new JButton("���");
	
	/*�� attribute�� ������ ���� ���� JTextField*/
	JTextField film_company = new JTextField(50);
	JTextField category = new JTextField(30);
	JTextField name = new JTextField(20);
	JTextField company_number = new JTextField(15);
	JTextField address = new JTextField(50);
	JTextField named_movie = new JTextField(50);
	
	/*����,����,���� �żҵ带 ����ϱ� ���Ͽ� DAO ��ü ����*/
	DAO dao = new DAO();
	
	/*������*/
	public InsertCompany() {
		/*â�� ������*/
		this.setTitle("��ȭ�� ������ ����");
		this.setSize(500,700);//â ũ��
		this.setResizable(false);//â ũ�⸦ �ٲ� �� �ִ����� ���� ����(false�� â ũ�⸦ �ٲ� �� ���� �Ѵ�.)
		this.setLocationRelativeTo(null);//â�� ��� �������� ��
		this.setVisible(true);//â�� ���̵��� ��
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//â�� ������ JFrame�� �������� ��
		this.setLayout(new GridLayout(7,2));
		
		/*����ڷκ��� ���� �Է¹޴� �κ�. �� attribute�� ���� ���� �Է¹���*/
		this.add(new JLabel("��ȭ�� �̸�(�����Է�)"));
		this.add(film_company);
		film_company.addActionListener((ActionListener) this);
		this.add(new JLabel("�з�(film distributor company/film production company)"));
		this.add(category);
		category.addActionListener((ActionListener) this);
		this.add(new JLabel("��ǥ��(�����Է�)"));
		this.add(name);
		name.addActionListener((ActionListener) this);
		this.add(new JLabel("ȸ���ȣ(000-000-0000)"));
		this.add(company_number);
		company_number.addActionListener((ActionListener) this);
		this.add(new JLabel("�ּ�(����)(�����Է�)"));
		this.add(address);
		address.addActionListener((ActionListener) this);
		this.add(new JLabel("���ۿ�ȭ(�����Է�)"));
		this.add(named_movie);
		named_movie.addActionListener((ActionListener) this);
		
		/*��ư*/
		this.add(CompleteButton);
		this.add(CancleButton);
		
		/*��ư�� ���������� �̺�Ʈó���� ���Ͽ� �����ϴ� �κ�*/
		CompleteButton.addActionListener((ActionListener) this);
		CancleButton.addActionListener((ActionListener)this);
		
		}

	/*��ư�� ������ ���� �̺�Ʈ ó���� ���� �κ�*/
	public void actionPerformed(ActionEvent e) {
		/*CompleteButton�� ���� ��� �Է¹��� ������ insert_...()�޼ҵ忡 �־� ȣ���� �� â�� �ݴ´�(��� â�� �ݴ°� �ƴ�)
		 * CancleButton�� ���� ��� �������� �ʰ� â�� �׳� �޴´�(��� â�� �ݴ°� �ƴ�)*/
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
