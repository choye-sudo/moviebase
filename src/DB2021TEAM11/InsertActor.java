package DB2021TEAM11;
/*�����ͺ��̽� sql���� GUI�� ����ϱ����� import*/
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*��� ���̺� �����ϴ� �������̽��� �����ϴ� Ŭ����*/
public class InsertActor extends JFrame implements ActionListener {//GUI�� �̺�Ʈ ó��
	/*CompleteButton : ������ ������ �Ϸ��
	 * CancleButton: ������ ������ ��ҵǰ� â�� ����*/
	JButton CompleteButton = new JButton("�Ϸ�");
	JButton CancleButton = new JButton("���");
	
	/*�� attribute�� ������ ���� ���� JTextField*/
	JTextField name = new JTextField(20);
	JTextField gender  = new JTextField(20);
	JTextField birth = new JTextField(10);
	JTextField film = new JTextField(35);
	
	/*����,����,���� �żҵ带 ����ϱ� ���Ͽ� DAO ��ü ����*/
	DAO dao = new DAO();
	
	/*������*/
	public InsertActor() {
		/*â�� ������*/
		this.setTitle("��� ������ ����");
		this.setSize(500,700);//â ũ��
		this.setResizable(false);//â ũ�⸦ �ٲ� �� �ִ����� ���� ����(false�� â ũ�⸦ �ٲ� �� ���� �Ѵ�.)
		this.setLocationRelativeTo(null);//â�� ��� �������� ��
		this.setVisible(true);//â�� ���̵��� ��
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//â�� ������ JFrame�� �������� ��
		this.setLayout(new GridLayout(5,2));
		
		/*����ڷκ��� ���� �Է¹޴� �κ�. �� attribute�� ���� ���� �Է¹���*/
		this.add(new JLabel("����̸�(�����Է�)"));
		this.add(name);
		name.addActionListener((ActionListener) this);
		this.add(new JLabel("����(female/male)"));
		this.add(gender);
		gender.addActionListener((ActionListener) this);
		this.add(new JLabel("�������(0000-00-00 ����)"));
		this.add(birth);
		birth.addActionListener((ActionListener) this);
		this.add(new JLabel("�⿬��ȭ(�����Է�)"));
		this.add(film);
		film.addActionListener((ActionListener) this);
		
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
        		String g = gender.getText();
        		String b = birth.getText();
        		String f = film.getText();
        		
				dao.insert_actor(n,g,b,f);
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
