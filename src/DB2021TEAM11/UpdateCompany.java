package DB2021TEAM11;
/*�����ͺ��̽� sql���� GUI�� ����ϱ����� import*/
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*��ȭ�� ���̺� �����ϴ� �������̽��� �����ϴ� Ŭ����*/
public class UpdateCompany extends JFrame implements ActionListener {
	/*CompleteButton : ������ ������ �Ϸ��
	 * CancleButton: ������ ������ ��ҵǰ� â�� ����*/
	JButton CompleteButton = new JButton("�Ϸ�");
	JButton CancleButton = new JButton("���");
	
	/*menu : ������ �׸�(attribute)�� �Է¹޴� JTextField
	 * company_name, film_name : ������ Ʃ���� �����ϴµ� �̿��� ��(��ȭ�� �̸�, ���� ��ȭ)�� �Է¹޴� JTextField
	 * update_thing : ������ ���� �Է¹޴� JTextField*/
	JTextField menu = new JTextField(20);
	JTextField company_name = new JTextField(50);
	JTextField film_name = new JTextField(50);
	JTextField update_thing = new JTextField(50);
	
	/*��, �ؽ�Ʈ �ʵ�, ��ư�� ��ġ�� ���� �г�*/
	JPanel jp1 = new JPanel();
	JPanel jp2 = new JPanel();
	
	/*����,����,���� �żҵ带 ����ϱ� ���Ͽ� DAO ��ü ����*/
	DAO dao = new DAO();
	
	/*������*/
	public UpdateCompany() {
		/*â�� ������*/
		this.setTitle("��ȭ�� ������ ����");
		this.setSize(700,500);//â ũ��
		this.setResizable(false);//â ũ�⸦ �ٲ� �� �ִ����� ���� ����(false�� â ũ�⸦ �ٲ� �� ���� �Ѵ�.)
		this.setLocationRelativeTo(null);//â�� ��� �������� ��
		this.setVisible(true);//â�� ���̵��� ��
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//â�� ������ JFrame�� �������� ��
		
		/*��, �ؽ�Ʈ �ʵ�, ��ư�� ��ġ�� ���Ͽ� ���̾ƿ� ������. �ش� ���̾ƿ��� ��,��,��,��,�߾� ���� ������ ��ġ�� �� �ְ� ��*/
		this.setLayout(new BorderLayout());
		
		/*����ڷκ��� ���� �Է¹޴� �κ�.*/
		jp1.add(new JLabel("<html>[�޴�]<br>��ȭ��(���ۻ�)(film_company)<br>�з�(category)<br>��ǥ�� �̸�(name)<br>ȸ�� ��ȭ��ȣ(company_number)<br>�ּ�(����)(address)<br>��ǥ��ȭ(named_movie)</html>"));
		jp2.add(new JLabel("������ �׸�(�� �޴� �� ��� �����Է�)"));
		jp2.add(menu);
		menu.addActionListener((ActionListener) this);
		jp2.add(new JLabel("������ ��ȭ���� �̸�(�����Է�)(�ϰ�����:��ȭ��,��ȭ �Ѵ� All)"));
		jp2.add(company_name);
		company_name.addActionListener((ActionListener) this);
		jp2.add(new JLabel("������ ��ȭ���� ���ۿ�ȭ �̸�(�����Է�)(�ϰ�����:��ȭ��,��ȭ �Ѵ� All)"));
		jp2.add(film_name);
		film_name.addActionListener((ActionListener) this);
		jp2.add(new JLabel("��������(������ �׸� ���� �ٸ��� �Է�)"));
		jp2.add(update_thing);
		update_thing.addActionListener((ActionListener) this);
		jp2.add("South",CompleteButton);//��ư
		
		/*��, ��ư, ����Ʈ�ʵ鸦 ���� �гε� ��ġ��*/
		this.add("North",jp1);
		this.add("Center",jp2);
		this.add("South",CancleButton);//��ư
		
		/*��ư�� ���������� �̺�Ʈó���� ���Ͽ� �����ϴ� �κ�*/
		CompleteButton.addActionListener((ActionListener) this);
		CancleButton.addActionListener((ActionListener)this);
		
		}
	/*��ư�� ������ ���� �̺�Ʈ ó���� ���� �κ�*/
	public void actionPerformed(ActionEvent e) {
		/*CompleteButton�� ���� ��� �Է¹��� ������ update_...()�޼ҵ忡 �־� ȣ���� �� â�� �ݴ´�(��� â�� �ݴ°� �ƴ�)
		 * CancleButton�� ���� ��� �������� �ʰ� â�� �׳� �޴´�(��� â�� �ݴ°� �ƴ�)*/
        if(e.getSource() == CompleteButton){
        	try {
        		String m = menu.getText();
        		String cn = company_name.getText();
        		String fn = film_name.getText();
        		String up = update_thing.getText();
        		
				dao.update_company(m,cn,fn,up);
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
