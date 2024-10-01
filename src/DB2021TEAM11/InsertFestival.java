package DB2021TEAM11;
/*�����ͺ��̽� sql���� GUI�� ����ϱ����� import*/
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*��ȭ�� ���̺� �����ϴ� �������̽��� �����ϴ� Ŭ����*/
public class InsertFestival extends JFrame implements ActionListener {//GUI�� �̺�Ʈ ó��
	/*CompleteButton : ������ ������ �Ϸ��
	 * CancleButton: ������ ������ ��ҵǰ� â�� ����*/
	JButton CompleteButton = new JButton("�Ϸ�");
	JButton CancleButton = new JButton("���");
	
	/*�� attribute�� ������ ���� ���� JTextField*/
	JTextField name = new JTextField(60);
	JTextField country = new JTextField(10);
	JTextField city = new JTextField(20);
	JTextField begin_year = new JTextField(4);
	
	/*����,����,���� �żҵ带 ����ϱ� ���Ͽ� DAO ��ü ����*/
	DAO dao = new DAO();
	
	/*������*/
	public InsertFestival() {
		/*â�� ������*/
		this.setTitle("��ȭ�� ������ ����");
		this.setSize(500,700);//â ũ��
		this.setResizable(false);//â ũ�⸦ �ٲ� �� �ִ����� ���� ����(false�� â ũ�⸦ �ٲ� �� ���� �Ѵ�.)
		this.setLocationRelativeTo(null);//â�� ��� �������� ��
		this.setVisible(true);//â�� ���̵��� ��
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//â�� ������ JFrame�� �������� ��
		this.setLayout(new GridLayout(5,2));
		
		/*����ڷκ��� ���� �Է¹޴� �κ�. �� attribute�� ���� ���� �Է¹���*/
		this.add(new JLabel("��ȭ�� �̸�(�����Է�)"));
		this.add(name);
		name.addActionListener((ActionListener) this);
		this.add(new JLabel("���ֱ�(�����Է�)"));
		this.add(country);
		country.addActionListener((ActionListener) this);
		this.add(new JLabel("������(����)(�����Է�)"));
		this.add(city);
		city.addActionListener((ActionListener) this);
		this.add(new JLabel("���ʰ�����(0000 ����)"));
		this.add(begin_year);
		begin_year.addActionListener((ActionListener) this);
		
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
        		String n = name.getText();
        		String co = country.getText();
        		String c = city.getText();
        		int by = 0;
        		by = Integer.parseInt(begin_year.getText());
        		
				dao.insert_festival(n,co,c,by);
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
