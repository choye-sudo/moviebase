package DB2021TEAM11;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;

public class GuiIntf extends JFrame{
	public GuiIntf() {
		setTitle("��ȭ ���� �����ͺ��̽�");
		setSize(700,600);
		setResizable(false);
	}
	//���α׷� ���� ȭ��
	public void FirstWindow() {
		JPanel pn = new JPanel(null);
		JLabel lb1 = new JLabel("��ȭ ���� �����ͺ��̽��� �������");
		JLabel lb2 = new JLabel("������ ���͵帱���?");		
		JButton btn1 = new JButton("������");
		JButton btn2 = new JButton("�Ϲ� �����");
		JButton btn3 = new JButton("���� ������");
		JButton btn4 = new JButton("���α׷� ����");

		lb1.setFont(new Font("Dialog",Font.BOLD,20));
		lb2.setFont(new Font("Dialog",Font.BOLD,20));
		btn1.setFont(new Font("Dialog",Font.BOLD,20));
		btn2.setFont(new Font("Dialog",Font.BOLD,20));
		btn3.setFont(new Font("Dialog",Font.BOLD,20));
		btn4.setFont(new Font("Dialog",Font.BOLD,20));
		
		lb1.setBounds(150,50,500,100);
		lb2.setBounds(150,100,500,100);
		btn1.setBounds(500,460,150,70);
		btn3.setBounds(100,250,200,100);
		btn2.setBounds(400,250,200,100);
		btn4.setBounds(250,400,200,50);

		pn.add(lb1);
		pn.add(lb2);
		pn.add(btn1);
		pn.add(btn2);
		pn.add(btn3);
		pn.add(btn4);		
		
		//������ ��ư�� ������ Panel_for_admin �޼ҵ� ȣ��
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				Panel_for_admin();
			}
		});
		
		//�Ϲ� ����� ��ư�� ������ Search Ŭ������ search_for_onlymovielover �޼ҵ� ȣ��
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//pn.setVisible(false);
				try {
					Search.search_for_onlymovielover();	
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		//���� ������ ��ư�� ������ Search Ŭ������ search_want_contact �޼ҵ� ȣ��
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//pn.setVisible(false);
				try {
					Search.search_want_contact();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		//���� ��ư�� ������ ���α׷��� ������
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		add(pn);
		setTitle("��ȭ ���� �����ͺ��̽�");
		setSize(700,600);
		setResizable(false);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//�����Ϳ� ���� �˻�, �߰�, ����, ����, ��ȸ ����� �����ִ� ȭ��
	public void Panel_for_admin() {
		JPanel pn = new JPanel(null);
		JLabel lb1 = new JLabel("������ ���͵帱���?");
		JButton btn1 = new JButton("�˻�");
		JButton btn2 = new JButton("�߰�");
		JButton btn3 = new JButton("����");
		JButton btn4 = new JButton("����");
		JButton btn5 = new JButton("����ȭ������");
		JButton btn6 = new JButton("��ȸ");
		
		lb1.setFont(new Font("Dialog",Font.BOLD,20));
		btn6.setFont(new Font("Dialog",Font.BOLD,20));
		btn1.setFont(new Font("Dialog",Font.BOLD,20));
		btn2.setFont(new Font("Dialog",Font.BOLD,20));
		btn3.setFont(new Font("Dialog",Font.BOLD,20));
		btn4.setFont(new Font("Dialog",Font.BOLD,20));
		btn5.setFont(new Font("Dialog",Font.BOLD,12));
		
		lb1.setBounds(150,35,500,100);
		btn6.setBounds(50,250,80,70);
		btn1.setBounds(180,250,80,70);
		btn2.setBounds(310,250,80,70);
		btn3.setBounds(440,250,80,70);
		btn4.setBounds(570,250,80,70);
		btn5.setBounds(275,400,150,50);
		
		pn.add(lb1);
		pn.add(btn1);
		pn.add(btn2);
		pn.add(btn3);
		pn.add(btn4);
		pn.add(btn5);
		pn.add(btn6);
		
		//��ȸ ��ư�� ������ Panel_looking �޼ҵ� ȣ��
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				Panel_looking();
			}
		});
		
		//��ȸ ��ư�� ������ Panel_searching �޼ҵ� ȣ��
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				Panel_searching();
			}
		});
		
		//�߰� ��ư�� ������ Panel_inserting �޼ҵ� ȣ��
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				Panel_inserting();
			}
		});
		
		//���� ��ư�� ������ Panel_updating �޼ҵ� ȣ��
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				Panel_updating();
			}
		});
		
		//���� ��ư�� ������ Panel_deleting �޼ҵ� ȣ��
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				Panel_deleting();
			}
		});
		
		//����ȭ������ ��ư�� ������ ó�� ȭ������ ���ư�
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				FirstWindow();
			}
		});
		
		add(pn);
		setTitle("��ȭ ���� �����ͺ��̽�");
		setSize(700,600);
		setResizable(false);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//Ư�� ������ ������ ��ȸ�� ���� ȭ��
	public void Panel_looking() {
		int n = 100, k=30;
		JPanel pn = new JPanel(null);
		JLabel lb1 = new JLabel("������ ��ȸ�ұ��?");
		JButton[] btn = new JButton[20];
		JButton btn_back = new JButton("����ȭ������");
		
		btn[1] = new JButton("���� ���� ���� ź ��ȭ���� �˻�");
		btn[2] = new JButton("õ������ ��ȭ�� ������ ��ȭ�� �˻�");
		btn[3] = new JButton("2016�� ���Ŀ� ������ ��ȭ �˻�");
		btn[4] = new JButton("�۰�ȣ ���� ����ȣ ������ ������ ��ȭ �˻�");
		btn[5] = new JButton("���� ������ ��ȭ�� �˻�");
		btn[6] = new JButton("���� ����� ������� �˻�");
		btn[7] = new JButton("����ȣ ������ ���� ź ��ȭ�� �˻�");
		btn[8] = new JButton("��ȣ���ɴ뺰 ��ȭ����");
		btn[9] = new JButton("������ 9�� �̻��� ��ȭ����");
		btn[10] = new JButton("�������� ���� ��ȭ�� ���� ���� ��ȭ�� �̸�");
		btn[11] = new JButton("�ؿ� ��ȭ������ ����� ��ȭ");
		btn[12] = new JButton("��ü ������ ��պ��� �� ���� ������ ��ȭ(�帣��)");
		btn[13] = new JButton("2000��~2010�� ���� ������ ��ȭ");
		btn[14] = new JButton("��ȭ ���̺� ��ȸ");
		btn[15] = new JButton("��ȭ�� ���̺� ��ȸ");
		btn[16] = new JButton("��ȭ�� ���̺� ��ȸ");
		btn[17] = new JButton("��� ���̺� ��ȸ");
		btn[18] = new JButton("�������� ���̺� ��ȸ");
		
		btn_back.setFont(new Font("Dialog",Font.BOLD,12));
		
		lb1.setFont(new Font("Dialog",Font.BOLD,20));
		for(int i=1; i<=18; i++) btn[i].setFont(new Font("Dialog",Font.BOLD,12));
		
		btn_back.setBounds(0,0,300,30);
		
		lb1.setBounds(150,30,500,100);
		for(int i=1; i<=18; i++) {			
			btn[i].setBounds(k,n,300,30);
			n=n+40;
			if(i==9) {
				k=350;
				n=100;
			}
		}
		
		pn.add(lb1);
		pn.add(btn_back);
		
		for(int i=1; i<=18; i++) pn.add(btn[i]);
		
		//����ȭ������ ��ư�� ������ ó�� ȭ������ ���ư�
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				FirstWindow();
			}
		});
		
		//���� ���� ���� ź ��ȭ���� �˻��� ������ Lookup Ŭ������ the_most_prized_director �޼ҵ� ȣ��
		btn[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				try {
					JPanel pn = Lookup.the_most_prized_director();
					add(pn);
					setTitle("��ȭ ���� �����ͺ��̽�");
					setSize(700,600);
					setResizable(false);
					setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		//õ������ ��ȭ�� ������ ��ȭ�� �˻��� ������ Lookup Ŭ������ over_10_million_attendance_director_company �޼ҵ� ȣ��
		btn[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				try {
					JPanel pn = Lookup.over_10_million_attendance_director_company();
					add(pn);
					setTitle("��ȭ ���� �����ͺ��̽�");
					setSize(700,600);
					setResizable(false);
					setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		//2016�� ���Ŀ� ������ ��ȭ �˻��� ������ Lookup Ŭ������ search_example_1 �޼ҵ� ȣ��
		btn[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				try {
					JPanel pn = Lookup.search_example_1();
					add(pn);
					setTitle("��ȭ ���� �����ͺ��̽�");
					setSize(700,600);
					setResizable(false);
					setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		//�۰�ȣ ���� ����ȣ ������ ������ ��ȭ �˻��� ������ Lookup Ŭ������ search_example_2 �޼ҵ� ȣ��
		btn[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				try {
					JPanel pn = Lookup.search_example_2();
					add(pn);
					setTitle("��ȭ ���� �����ͺ��̽�");
					setSize(700,600);
					setResizable(false);
					setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		//���� ������ ��ȭ�� �˻��� ������ Lookup Ŭ������ search_example_3 �޼ҵ� ȣ��
		btn[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				try {
					JPanel pn = Lookup.search_example_3();
					add(pn);
					setTitle("��ȭ ���� �����ͺ��̽�");
					setSize(700,600);
					setResizable(false);
					setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		//���� ����� ������� �˻��� ������ Lookup Ŭ������ search_example_4 �޼ҵ� ȣ��
		btn[6].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				try {
					JPanel pn = Lookup.search_example_4();
					add(pn);
					setTitle("��ȭ ���� �����ͺ��̽�");
					setSize(700,600);
					setResizable(false);
					setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		//����ȣ ������ ���� ź ��ȭ�� �˻��� ������ Lookup Ŭ������ search_example_5 �޼ҵ� ȣ��
		btn[7].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				try {
					JPanel pn = Lookup.search_example_5();
					add(pn);
					setTitle("��ȭ ���� �����ͺ��̽�");
					setSize(700,600);
					setResizable(false);
					setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		//��ȣ���ɴ뺰 ��ȭ������ ������ Lookup Ŭ������ select_db1 �޼ҵ� ȣ��
		btn[8].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				try {
					JPanel pn = Lookup.select_db1();
					add(pn);
					setTitle("��ȭ ���� �����ͺ��̽�");
					setSize(700,600);
					setResizable(false);
					setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		//������ 9�� �̻��� ��ȭ������ ������ Lookup Ŭ������ select_db2 �޼ҵ� ȣ��
		btn[9].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				try {
					JPanel pn = Lookup.select_db2();
					add(pn);
					setTitle("��ȭ ���� �����ͺ��̽�");
					setSize(700,600);
					setResizable(false);
					setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		//�������� ���� ��ȭ�� ���� ���� ��ȭ�� �̸��� ������ Lookup Ŭ������ select_db3 �޼ҵ� ȣ��
		btn[10].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				try {
					JPanel pn = Lookup.select_db3();
					add(pn);
					setTitle("��ȭ ���� �����ͺ��̽�");
					setSize(700,600);
					setResizable(false);
					setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		//�ؿ� ��ȭ������ ����� ��ȭ�� ������ Lookup Ŭ������ select_db4 �޼ҵ� ȣ��
		btn[11].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				try {
					JPanel pn = Lookup.select_db4();
					add(pn);
					setTitle("��ȭ ���� �����ͺ��̽�");
					setSize(700,600);
					setResizable(false);
					setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		//��ü ������ ��պ��� �� ���� ������ ��ȭ(�帣��)�� ������ Lookup Ŭ������ select_db5 �޼ҵ� ȣ��
		btn[12].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				try {
					JPanel pn = Lookup.select_db5();
					add(pn);
					setTitle("��ȭ ���� �����ͺ��̽�");
					setSize(700,600);
					setResizable(false);
					setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		//2000��~2010�� ���� ������ ��ȭ�� ������ Lookup Ŭ������ select_db6 �޼ҵ� ȣ��
		btn[13].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				try {
					JPanel pn = Lookup.select_db6();
					add(pn);
					setTitle("��ȭ ���� �����ͺ��̽�");
					setSize(700,600);
					setResizable(false);
					setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		//��ȭ ���̺� ��ȸ�� ������ Lookup Ŭ������ show_table_movie �޼ҵ� ȣ��
		btn[14].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				try {
					JPanel pn = Lookup.show_table_movie();
					add(pn);
					setTitle("��ȭ ���� �����ͺ��̽�");
					setSize(700,600);
					setResizable(false);
					setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		//��ȭ�� ���̺� ��ȸ�� ������ Lookup Ŭ������ show_table_company �޼ҵ� ȣ��
		btn[15].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				try {
					JPanel pn = Lookup.show_table_company();
					add(pn);
					setTitle("��ȭ ���� �����ͺ��̽�");
					setSize(700,600);
					setResizable(false);
					setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		//��ȭ�� ���̺� ��ȸ�� ������ Lookup Ŭ������ show_table_festival �޼ҵ� ȣ��
		btn[16].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				try {
					JPanel pn = Lookup.show_table_festival();
					add(pn);
					setTitle("��ȭ ���� �����ͺ��̽�");
					setSize(700,600);
					setResizable(false);
					setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		//��� ���̺� ��ȸ�� ������ Lookup Ŭ������ show_table_actor �޼ҵ� ȣ��
		btn[17].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				try {
					JPanel pn = Lookup.show_table_actor();
					add(pn);
					setTitle("��ȭ ���� �����ͺ��̽�");
					setSize(700,600);
					setResizable(false);
					setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		//�������� ���̺� ��ȸ�� ������ Lookup Ŭ������ show_table_award �޼ҵ� ȣ��
		btn[18].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				try {
					JPanel pn = Lookup.show_table_award();
					add(pn);
					setTitle("��ȭ ���� �����ͺ��̽�");
					setSize(700,600);
					setResizable(false);
					setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		add(pn);
		
		setTitle("��ȭ ���� �����ͺ��̽�");
		setSize(700,600);
		setResizable(false);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//������ �˻��� ���� ȭ��
	public void Panel_searching() {
		int n = 100, k=30;
		JPanel pn = new JPanel(null);
		JLabel lb1 = new JLabel("������ �˻��ұ��?");
		JButton[] btn = new JButton[13];
		JButton btn_back = new JButton("����ȭ������");
		btn[1] = new JButton("�帣�� ��ȭ �˻�");
		btn[2] = new JButton("��ȭ���� ��ȭ �˻�");
		btn[3] = new JButton("���� ��ȭ �˻�");
		btn[4] = new JButton("��ȭ �̸����� ��ȭ �˻�");
		btn[5] = new JButton("��ȭ�� �̸����� ��ȭ�� �˻�");
		btn[6] = new JButton("��ȭ �̸����� ��ȭ�� �˻�");
		btn[7] = new JButton("��ȭ�� �̸����� ��ȭ�� �˻�");
		btn[8] = new JButton("���� �̸����� ��ȭ�� �˻�");
		btn[9] = new JButton("��� �̸����� ��� �˻�");
		btn[10] = new JButton("�⿬������ ��� �˻�");
		btn[11] = new JButton("��ȭ �̸����� ������ �˻�");
		btn[12] = new JButton("�������� ������ �˻�");
		
		btn_back.setFont(new Font("Dialog",Font.BOLD,12));
		
		lb1.setFont(new Font("Dialog",Font.BOLD,20));
		for(int i=1; i<=12; i++) btn[i].setFont(new Font("Dialog",Font.BOLD,12));
		
		btn_back.setBounds(0,0,300,30);
		
		lb1.setBounds(150,30,500,100);
		for(int i=1; i<=12; i++) {			
			btn[i].setBounds(k,n,300,30);
			n=n+40;
			if(i==6) {
				k=350;
				n=100;
			}
		}
		pn.add(btn_back);
		
		pn.add(lb1);
		for(int i=1; i<=12; i++) pn.add(btn[i]);
		
		//����ȭ������ ��ư Ŭ���� ó�� ȭ������ ���ư�
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				FirstWindow();
			}
		});
		
		//�帣�� ��ȭ �˻��� ������ Search Ŭ������ search_movie_by_genre �޼ҵ� ȣ��
		btn[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				try {
					JPanel pn = Search.search_movie_by_genre();
					add(pn);
					setTitle("��ȭ ���� �����ͺ��̽�");
					setSize(700,600);
					setResizable(false);
					setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		//��ȭ���� ��ȭ �˻��� ������ Search Ŭ������ search_movie_by_festival �޼ҵ� ȣ��
		btn[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				try {
					JPanel pn = Search.search_movie_by_festival();
					add(pn);
					setTitle("��ȭ ���� �����ͺ��̽�");
					setSize(700,600);
					setResizable(false);
					setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		//���� ��ȭ �˻��� ������ Search Ŭ������ search_movie_by_actor �޼ҵ� ȣ��
		btn[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				try {
					JPanel pn = Search.search_movie_by_actor();
					add(pn);
					setTitle("��ȭ ���� �����ͺ��̽�");
					setSize(700,600);
					setResizable(false);
					setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		//��ȭ �̸����� ��ȭ �˻��� ������ Search Ŭ������ search_movie_by_name �޼ҵ� ȣ��
		btn[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				try {
					JPanel pn = Search.search_movie_by_name();
					add(pn);
					setTitle("��ȭ ���� �����ͺ��̽�");
					setSize(700,600);
					setResizable(false);
					setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		//��ȭ�� �̸����� ��ȭ�� �˻��� ������ Search Ŭ������ search_company_by_name �޼ҵ� ȣ��
		btn[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				try {
					JPanel pn = Search.search_company_by_name();
					add(pn);
					setTitle("��ȭ ���� �����ͺ��̽�");
					setSize(700,600);
					setResizable(false);
					setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		//��ȭ �̸����� ��ȭ�� �˻��� ������ Search Ŭ������ search_company_by_movie �޼ҵ� ȣ��
		btn[6].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				try {
					JPanel pn = Search.search_company_by_movie();
					add(pn);
					setTitle("��ȭ ���� �����ͺ��̽�");
					setSize(700,600);
					setResizable(false);
					setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		//��ȭ�� �̸����� ��ȭ�� �˻��� ������ Search Ŭ������ search_festival_by_name �޼ҵ� ȣ��
		btn[7].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				try {
					JPanel pn = Search.search_festival_by_name();
					add(pn);
					setTitle("��ȭ ���� �����ͺ��̽�");
					setSize(700,600);
					setResizable(false);
					setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		//���� �̸����� ��ȭ�� �˻��� ������ Search Ŭ������ search_festival_by_country �޼ҵ� ȣ��
		btn[8].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				try {
					JPanel pn = Search.search_festival_by_country();
					add(pn);
					setTitle("��ȭ ���� �����ͺ��̽�");
					setSize(700,600);
					setResizable(false);
					setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		//��� �̸����� ��� �˻��� ������ Search Ŭ������ search_actor_by_name �޼ҵ� ȣ��
		btn[9].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				try {
					JPanel pn = Search.search_actor_by_name();
					add(pn);
					setTitle("��ȭ ���� �����ͺ��̽�");
					setSize(700,600);
					setResizable(false);
					setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		//�⿬������ ��� �˻��� ������ Search Ŭ������ search_actor_by_film �޼ҵ� ȣ��
		btn[10].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				try {
					JPanel pn = Search.search_actor_by_film();
					add(pn);
					setTitle("��ȭ ���� �����ͺ��̽�");
					setSize(700,600);
					setResizable(false);
					setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		//��ȭ �̸����� ������ �˻��� ������ Search Ŭ������ search_award_by_film �޼ҵ� ȣ��
		btn[11].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				try {
					JPanel pn = Search.search_award_by_film();
					add(pn);
					setTitle("��ȭ ���� �����ͺ��̽�");
					setSize(700,600);
					setResizable(false);
					setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		//�������� ������ �˻��� ������ Search Ŭ������ search_award_by_director �޼ҵ� ȣ��
		btn[12].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				try {
					JPanel pn = Search.search_award_by_director();
					add(pn);
					setTitle("��ȭ ���� �����ͺ��̽�");
					setSize(700,600);
					setResizable(false);
					setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		add(pn);
		
		setTitle("��ȭ ���� �����ͺ��̽�");
		setSize(700,600);
		setResizable(false);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//������ �߰��� ���� ȭ��
	public void Panel_inserting() {
		JButton btn_movie = new JButton("1.��ȭ");
		JButton btn_company = new JButton("2.��ȭ��");
		JButton btn_festival = new JButton("3.��ȭ��");
		JButton btn_actor = new JButton("4.���");
		JButton btn_award = new JButton("5.��������");
		JButton btn_cancle = new JButton("���");
		
		JPanel ipn = new JPanel();
		
		ipn.add(btn_movie);
		ipn.add(btn_company);
		ipn.add(btn_festival);
		ipn.add(btn_actor);
		ipn.add(btn_award);
		ipn.add(btn_cancle);
		
		add(ipn);
		
		//��ȭ ��ư�� ������ ��ȭ ���̺� ������ �߰�
		btn_movie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertMovie in_m = new InsertMovie();
			}
		});

		//��ȭ�� ��ư�� ������ ��ȭ�� ���̺� ������ �߰�
		btn_company.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertCompany in_c = new InsertCompany();
			}
		});

		//��ȭ�� ��ư�� ������ ��ȭ�� ���̺� ������ �߰�
		btn_festival.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertFestival in_f = new InsertFestival();
			}
		});

		//��� ��ư�� ������ ��� ���̺� ������ �߰�
		btn_actor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertActor in_a = new InsertActor();
			}
		});

		//�������� ��ư�� ������ �������� ���̺� ������ �߰�
		btn_award.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertAward in_aw = new InsertAward();
			}
		});

		//��� ��ư�� ������ Panel_for_admin ȭ������ ���ư�
		btn_cancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ipn.setVisible(false);
				Panel_for_admin();
			}
		});
	}
	
	//������ ������ ���� ȭ��
	public void Panel_updating() {
		JButton btn_movie = new JButton("1.��ȭ");
		JButton btn_company = new JButton("2.��ȭ��");
		JButton btn_festival = new JButton("3.��ȭ��");
		JButton btn_actor = new JButton("4.���");
		JButton btn_award = new JButton("5.��������");
		JButton btn_cancle = new JButton("���");
		
		JPanel ipn = new JPanel();
		
		ipn.add(btn_movie);
		ipn.add(btn_company);
		ipn.add(btn_festival);
		ipn.add(btn_actor);
		ipn.add(btn_award);
		ipn.add(btn_cancle);
		
		add(ipn);
		
		//��ȭ ��ư�� ������ ��ȭ ���̺� ������ ����
		btn_movie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateMovie up_m = new UpdateMovie();
			}
		});

		//��ȭ�� ��ư�� ������ ��ȭ�� ���̺� ������ ����
		btn_company.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateCompany up_c = new UpdateCompany();
			}
		});

		//��ȭ�� ��ư�� ������ ��ȭ�� ���̺� ������ ����
		btn_festival.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateFestival up_f = new UpdateFestival();
			}
		});

		//��� ��ư�� ������ ��� ���̺� ������ ����
		btn_actor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateActor up_a = new UpdateActor();
			}
		});

		//�������� ��ư�� ������ �������� ���̺� ������ ����
		btn_award.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateAward up_aw = new UpdateAward();
			}
		});
		
		//��� ��ư�� ������ Panel_for_admin ȭ������ ���ư�
		btn_cancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ipn.setVisible(false);
				Panel_for_admin();
			}
		});
	}
	
	//������ ������ ���� ȭ��
	public void Panel_deleting() {
		JButton btn_movie = new JButton("1.��ȭ");
		JButton btn_company = new JButton("2.��ȭ��");
		JButton btn_festival = new JButton("3.��ȭ��");
		JButton btn_actor = new JButton("4.���");
		JButton btn_award = new JButton("5.��������");
		JButton btn_cancle = new JButton("���");
		
		JPanel ipn = new JPanel();
		
		ipn.add(btn_movie);
		ipn.add(btn_company);
		ipn.add(btn_festival);
		ipn.add(btn_actor);
		ipn.add(btn_award);
		ipn.add(btn_cancle);
		
		add(ipn);

		//��ȭ ��ư�� ������ ��ȭ ���̺� ������ ����
		btn_movie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteMovie d_m = new DeleteMovie();
			}
		});

		//��ȭ�� ��ư�� ������ ��ȭ�� ���̺� ������ ����
		btn_company.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteCompany d_c = new DeleteCompany();
			}
		});

		//��ȭ�� ��ư�� ������ ��ȭ�� ���̺� ������ ����
		btn_festival.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteFestival d_f = new DeleteFestival();
			}
		});

		//��� ��ư�� ������ ��� ���̺� ������ ����
		btn_actor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteActor d_a = new DeleteActor();
			}
		});

		//�������� ��ư�� ������ �������� ���̺� ������ ����
		btn_award.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteAward in_aw = new DeleteAward();
			}
		});
		
		//��� ��ư�� ������ Panel_for_admin ȭ������ ���ư�
		btn_cancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ipn.setVisible(false);
				Panel_for_admin();
			}
		});
	}
}

