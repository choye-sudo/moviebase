package DB2021TEAM11;
/*�����ͺ��̽� sql���� GUI�� ����ϱ����� import*/
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*��ȭ ���̺� �����ϴ� �������̽��� �����ϴ� Ŭ����*/
public class InsertMovie extends JFrame implements ActionListener{//GUI�� �̺�Ʈ ó��
	/*CompleteButton : ������ ������ �Ϸ��
	 * CancleButton: ������ ������ ��ҵǰ� â�� ����*/
	JButton CompleteButton = new JButton("�Ϸ�");
	JButton CancleButton = new JButton("���");
	
	/*�� attribute�� ������ ���� ���� JTextField*/
	JTextField name = new JTextField(50);
	JTextField genre = new JTextField(20);
	JTextField running_time = new JTextField(10);
	JTextField release_date = new JTextField(10);
	JTextField actor = new JTextField(20);
	JTextField rating = new JTextField(10);
	JTextField attendance = new JTextField(10);
	JTextField prefered_age = new JTextField(10);
	JTextField prefered_gender = new JTextField(10);
	JTextField film_company = new JTextField(50);
	JTextField director = new JTextField(20);
	
	/*����,����,���� �żҵ带 ����ϱ� ���Ͽ� DAO ��ü ����*/
	DAO dao = new DAO();
	
	/*������*/
	public InsertMovie() {
		/*â�� ������*/
		this.setTitle("��ȭ ������ ����");
		this.setSize(500,700);//â ũ��
		this.setResizable(false);//â ũ�⸦ �ٲ� �� �ִ����� ���� ����(false�� â ũ�⸦ �ٲ� �� ���� �Ѵ�.)
		this.setLocationRelativeTo(null);//â�� ��� �������� ��
		this.setVisible(true);//â�� ���̵��� ��
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//â�� ������ JFrame�� �������� ��
		this.setLayout(new GridLayout(12,2));
		
		/*����ڷκ��� ���� �Է¹޴� �κ�. �� attribute�� ���� ���� �Է¹���*/
		this.add(new JLabel("��ȭ �̸�(�����Է�)"));
		this.add(name);
		name.addActionListener((ActionListener) this);
		this.add(new JLabel("�帣(�����Է�)"));
		this.add(genre);
		genre.addActionListener((ActionListener) this);
		this.add(new JLabel("�󿵽ð�(��)"));
		this.add(running_time);
		running_time.addActionListener((ActionListener) this);
		this.add(new JLabel("���� ��¥(0000-00-00 ����)"));
		this.add(release_date);
		release_date.addActionListener((ActionListener) this);
		this.add(new JLabel("�⿬ ���(�����Է�)"));
		this.add(actor);
		actor.addActionListener((ActionListener) this);
		this.add(new JLabel("����(0.00 ����)"));
		this.add(rating);
		rating.addActionListener((ActionListener) this);
		this.add(new JLabel("���� ��(��)"));
		this.add(attendance);
		attendance.addActionListener((ActionListener) this);
		this.add(new JLabel("��ȣ���ɴ�(10��:10/20��:20/30��:30)"));
		this.add(prefered_age);
		prefered_age.addActionListener((ActionListener) this);
		this.add(new JLabel("��ȣ����(male/female)"));
		this.add(prefered_gender);
		prefered_gender.addActionListener((ActionListener) this);
		this.add(new JLabel("��ȭ��(�����Է�)"));
		this.add(film_company);
		film_company.addActionListener((ActionListener) this);
		this.add(new JLabel("����(�����Է�)"));
		this.add(director);
		director.addActionListener((ActionListener) this);
		
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
        		String g = genre.getText();
        		int rt = 0;
        		rt = Integer.parseInt(running_time.getText());
        		String rd = release_date.getText();
        		String a = actor.getText();
        		float r = Float.parseFloat(rating.getText());
        		int at = 0;
        		at = Integer.parseInt(attendance.getText());
        		int pa = 0;
        		pa = Integer.parseInt(prefered_age.getText());
        		String pg = prefered_gender.getText();
        		String fc = film_company.getText();
        		String d = director.getText();
        		
				dao.insert_movie(n,g,rt,rd,a,r,at,pa,pg,fc,d);
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
