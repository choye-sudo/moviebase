package DB2021TEAM11;
/*�����ͺ��̽� sql���� GUI�� ����ϱ����� import*/
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*��ȭ�� ���̺��� �����ϴ� �������̽��� �����ϴ� Ŭ����*/
public class DeleteCompany extends JFrame implements ActionListener {
	/*CompleteButton : ������ ������ �Ϸ��
	 * CancleButton: ������ ������ ��ҵǰ� â�� ����*/
	JButton CompleteButton = new JButton("����");
	JButton CancleButton = new JButton("���");
	
	/*������ Ʃ���� ������ ����(��ȭ�� �̸�, ��ȭ �̸�)�� �Է¹޴´�*/
	JTextField company_name = new JTextField(50);
	JTextField film_name = new JTextField(50);
	
	/*����,����,���� �żҵ带 ����ϱ� ���Ͽ� DAO ��ü ����*/
	DAO dao = new DAO();
	
	/*������*/
	public DeleteCompany() {
		/*â�� ������*/
		this.setTitle("��ȭ�� ������ ����");
		this.setSize(500,700);//â ũ��
		this.setResizable(false);//â ũ�⸦ �ٲ� �� �ִ����� ���� ����(false�� â ũ�⸦ �ٲ� �� ���� �Ѵ�.)
		this.setLocationRelativeTo(null);//â�� ��� �������� ��
		this.setVisible(true);//â�� ���̵��� ��
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//â�� ������ JFrame�� �������� ��
		this.setLayout(new GridLayout(12,2));
		
		/*����ڷκ��� ���� �Է¹޴� �κ�.*/
		this.add(new JLabel("������ ��ȭ�� �̸�(�����Է�)"));
		this.add(company_name);
		company_name.addActionListener((ActionListener) this);
		this.add(new JLabel("������ ��ȭ�� ���ۿ�ȭ(�����Է�)"));
		this.add(film_name);
		film_name.addActionListener((ActionListener) this);
		
		/*��ư*/
		this.add(CompleteButton);
		this.add(CancleButton);
		
		/*��ư�� ���������� �̺�Ʈó���� ���Ͽ� �����ϴ� �κ�*/
		CompleteButton.addActionListener((ActionListener) this);
		CancleButton.addActionListener((ActionListener)this);
		
		}
	/*��ư�� ������ ���� �̺�Ʈ ó���� ���� �κ�*/
	public void actionPerformed(ActionEvent e) {
		/*CompleteButton�� ���� ��� �Է¹��� ������ delete_...()�޼ҵ忡 �־� ȣ���� �� â�� �ݴ´�(��� â�� �ݴ°� �ƴ�)
		 * CancleButton�� ���� ��� �������� �ʰ� â�� �׳� �޴´�(��� â�� �ݴ°� �ƴ�)*/
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
