package DB2021TEAM11;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;

public class GuiIntf extends JFrame{
	public GuiIntf() {
		setTitle("영화 관리 데이터베이스");
		setSize(700,600);
		setResizable(false);
	}
	//프로그램 시작 화면
	public void FirstWindow() {
		JPanel pn = new JPanel(null);
		JLabel lb1 = new JLabel("영화 관리 데이터베이스에 어서오세요");
		JLabel lb2 = new JLabel("무엇을 도와드릴까요?");		
		JButton btn1 = new JButton("관리자");
		JButton btn2 = new JButton("일반 사용자");
		JButton btn3 = new JButton("업계 관계자");
		JButton btn4 = new JButton("프로그램 종료");

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
		
		//관리자 버튼을 누를시 Panel_for_admin 메소드 호출
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				Panel_for_admin();
			}
		});
		
		//일반 사용자 버튼을 누를시 Search 클래스의 search_for_onlymovielover 메소드 호출
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
		
		//업계 관계자 버튼을 누를시 Search 클래스의 search_want_contact 메소드 호출
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
		
		//종료 버튼을 누를시 프로그램을 종료함
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		add(pn);
		setTitle("영화 관리 데이터베이스");
		setSize(700,600);
		setResizable(false);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//데이터에 대한 검색, 추가, 갱신, 삭제, 조회 기능을 보여주는 화면
	public void Panel_for_admin() {
		JPanel pn = new JPanel(null);
		JLabel lb1 = new JLabel("무엇을 도와드릴까요?");
		JButton btn1 = new JButton("검색");
		JButton btn2 = new JButton("추가");
		JButton btn3 = new JButton("갱신");
		JButton btn4 = new JButton("삭제");
		JButton btn5 = new JButton("메인화면으로");
		JButton btn6 = new JButton("조회");
		
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
		
		//조회 버튼을 누를시 Panel_looking 메소드 호출
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				Panel_looking();
			}
		});
		
		//조회 버튼을 누를시 Panel_searching 메소드 호출
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				Panel_searching();
			}
		});
		
		//추가 버튼을 누를시 Panel_inserting 메소드 호출
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				Panel_inserting();
			}
		});
		
		//갱신 버튼을 누를시 Panel_updating 메소드 호출
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				Panel_updating();
			}
		});
		
		//삭제 버튼을 누를시 Panel_deleting 메소드 호출
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				Panel_deleting();
			}
		});
		
		//메인화면으로 버튼을 누를시 처음 화면으로 돌아감
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				FirstWindow();
			}
		});
		
		add(pn);
		setTitle("영화 관리 데이터베이스");
		setSize(700,600);
		setResizable(false);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//특정 조건의 데이터 조회를 돕는 화면
	public void Panel_looking() {
		int n = 100, k=30;
		JPanel pn = new JPanel(null);
		JLabel lb1 = new JLabel("무엇을 조회할까요?");
		JButton[] btn = new JButton[20];
		JButton btn_back = new JButton("메인화면으로");
		
		btn[1] = new JButton("가장 상을 많이 탄 영화감독 검색");
		btn[2] = new JButton("천만관객 영화를 제작한 영화사 검색");
		btn[3] = new JButton("2016년 이후에 개봉한 영화 검색");
		btn[4] = new JButton("송강호 배우와 봉준호 감독이 참여한 영화 검색");
		btn[5] = new JButton("가장 오래된 영화제 검색");
		btn[6] = new JButton("여성 배우의 생년월일 검색");
		btn[7] = new JButton("봉준호 감독이 상을 탄 영화제 검색");
		btn[8] = new JButton("선호연령대별 영화정보");
		btn[9] = new JButton("평점이 9점 이상인 영화정보");
		btn[10] = new JButton("전지현이 나온 영화가 상을 받은 영화제 이름");
		btn[11] = new JButton("해외 영화제에서 상받은 영화");
		btn[12] = new JButton("전체 관객수 평균보다 더 높은 관객수 영화(장르별)");
		btn[13] = new JButton("2000년~2010년 사이 개봉한 영화");
		btn[14] = new JButton("영화 테이블 조회");
		btn[15] = new JButton("영화사 테이블 조회");
		btn[16] = new JButton("영화제 테이블 조회");
		btn[17] = new JButton("배우 테이블 조회");
		btn[18] = new JButton("수상정보 테이블 조회");
		
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
		
		//메인화면으로 버튼을 누를시 처음 화면으로 돌아감
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				FirstWindow();
			}
		});
		
		//가장 상을 많이 탄 영화감독 검색을 누를시 Lookup 클래스의 the_most_prized_director 메소드 호출
		btn[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				try {
					JPanel pn = Lookup.the_most_prized_director();
					add(pn);
					setTitle("영화 관리 데이터베이스");
					setSize(700,600);
					setResizable(false);
					setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		//천만관객 영화를 제작한 영화사 검색을 누를시 Lookup 클래스의 over_10_million_attendance_director_company 메소드 호출
		btn[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				try {
					JPanel pn = Lookup.over_10_million_attendance_director_company();
					add(pn);
					setTitle("영화 관리 데이터베이스");
					setSize(700,600);
					setResizable(false);
					setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		//2016년 이후에 개봉한 영화 검색을 누를시 Lookup 클래스의 search_example_1 메소드 호출
		btn[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				try {
					JPanel pn = Lookup.search_example_1();
					add(pn);
					setTitle("영화 관리 데이터베이스");
					setSize(700,600);
					setResizable(false);
					setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		//송강호 배우와 봉준호 감독이 참여한 영화 검색을 누를시 Lookup 클래스의 search_example_2 메소드 호출
		btn[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				try {
					JPanel pn = Lookup.search_example_2();
					add(pn);
					setTitle("영화 관리 데이터베이스");
					setSize(700,600);
					setResizable(false);
					setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		//가장 오래된 영화제 검색을 누를시 Lookup 클래스의 search_example_3 메소드 호출
		btn[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				try {
					JPanel pn = Lookup.search_example_3();
					add(pn);
					setTitle("영화 관리 데이터베이스");
					setSize(700,600);
					setResizable(false);
					setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		//여성 배우의 생년월일 검색을 누를시 Lookup 클래스의 search_example_4 메소드 호출
		btn[6].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				try {
					JPanel pn = Lookup.search_example_4();
					add(pn);
					setTitle("영화 관리 데이터베이스");
					setSize(700,600);
					setResizable(false);
					setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		//봉준호 감독이 상을 탄 영화제 검색을 누를시 Lookup 클래스의 search_example_5 메소드 호출
		btn[7].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				try {
					JPanel pn = Lookup.search_example_5();
					add(pn);
					setTitle("영화 관리 데이터베이스");
					setSize(700,600);
					setResizable(false);
					setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		//선호연령대별 영화정보를 누를시 Lookup 클래스의 select_db1 메소드 호출
		btn[8].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				try {
					JPanel pn = Lookup.select_db1();
					add(pn);
					setTitle("영화 관리 데이터베이스");
					setSize(700,600);
					setResizable(false);
					setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		//평점이 9점 이상인 영화정보를 누를시 Lookup 클래스의 select_db2 메소드 호출
		btn[9].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				try {
					JPanel pn = Lookup.select_db2();
					add(pn);
					setTitle("영화 관리 데이터베이스");
					setSize(700,600);
					setResizable(false);
					setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		//전지현이 나온 영화가 상을 받은 영화제 이름을 누를시 Lookup 클래스의 select_db3 메소드 호출
		btn[10].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				try {
					JPanel pn = Lookup.select_db3();
					add(pn);
					setTitle("영화 관리 데이터베이스");
					setSize(700,600);
					setResizable(false);
					setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		//해외 영화제에서 상받은 영화를 누를시 Lookup 클래스의 select_db4 메소드 호출
		btn[11].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				try {
					JPanel pn = Lookup.select_db4();
					add(pn);
					setTitle("영화 관리 데이터베이스");
					setSize(700,600);
					setResizable(false);
					setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		//전체 관객수 평균보다 더 높은 관객수 영화(장르별)를 누를시 Lookup 클래스의 select_db5 메소드 호출
		btn[12].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				try {
					JPanel pn = Lookup.select_db5();
					add(pn);
					setTitle("영화 관리 데이터베이스");
					setSize(700,600);
					setResizable(false);
					setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		//2000년~2010년 사이 개봉한 영화를 누를시 Lookup 클래스의 select_db6 메소드 호출
		btn[13].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				try {
					JPanel pn = Lookup.select_db6();
					add(pn);
					setTitle("영화 관리 데이터베이스");
					setSize(700,600);
					setResizable(false);
					setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		//영화 테이블 조회를 누를시 Lookup 클래스의 show_table_movie 메소드 호출
		btn[14].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				try {
					JPanel pn = Lookup.show_table_movie();
					add(pn);
					setTitle("영화 관리 데이터베이스");
					setSize(700,600);
					setResizable(false);
					setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		//영화사 테이블 조회를 누를시 Lookup 클래스의 show_table_company 메소드 호출
		btn[15].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				try {
					JPanel pn = Lookup.show_table_company();
					add(pn);
					setTitle("영화 관리 데이터베이스");
					setSize(700,600);
					setResizable(false);
					setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		//영화제 테이블 조회를 누를시 Lookup 클래스의 show_table_festival 메소드 호출
		btn[16].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				try {
					JPanel pn = Lookup.show_table_festival();
					add(pn);
					setTitle("영화 관리 데이터베이스");
					setSize(700,600);
					setResizable(false);
					setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		//배우 테이블 조회를 누를시 Lookup 클래스의 show_table_actor 메소드 호출
		btn[17].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				try {
					JPanel pn = Lookup.show_table_actor();
					add(pn);
					setTitle("영화 관리 데이터베이스");
					setSize(700,600);
					setResizable(false);
					setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		//수상정보 테이블 조회를 누를시 Lookup 클래스의 show_table_award 메소드 호출
		btn[18].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				try {
					JPanel pn = Lookup.show_table_award();
					add(pn);
					setTitle("영화 관리 데이터베이스");
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
		
		setTitle("영화 관리 데이터베이스");
		setSize(700,600);
		setResizable(false);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//데이터 검색을 돕는 화면
	public void Panel_searching() {
		int n = 100, k=30;
		JPanel pn = new JPanel(null);
		JLabel lb1 = new JLabel("무엇을 검색할까요?");
		JButton[] btn = new JButton[13];
		JButton btn_back = new JButton("메인화면으로");
		btn[1] = new JButton("장르로 영화 검색");
		btn[2] = new JButton("영화제로 영화 검색");
		btn[3] = new JButton("배우로 영화 검색");
		btn[4] = new JButton("영화 이름으로 영화 검색");
		btn[5] = new JButton("영화사 이름으로 영화사 검색");
		btn[6] = new JButton("영화 이름으로 영화사 검색");
		btn[7] = new JButton("영화제 이름으로 영화제 검색");
		btn[8] = new JButton("국가 이름으로 영화제 검색");
		btn[9] = new JButton("배우 이름으로 배우 검색");
		btn[10] = new JButton("출연작으로 배우 검색");
		btn[11] = new JButton("영화 이름으로 수상기록 검색");
		btn[12] = new JButton("감독으로 수상기록 검색");
		
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
		
		//메인화면으로 버튼 클릭시 처음 화면으로 돌아감
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				FirstWindow();
			}
		});
		
		//장르로 영화 검색을 누를시 Search 클래스의 search_movie_by_genre 메소드 호출
		btn[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				try {
					JPanel pn = Search.search_movie_by_genre();
					add(pn);
					setTitle("영화 관리 데이터베이스");
					setSize(700,600);
					setResizable(false);
					setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		//영화제로 영화 검색을 누를시 Search 클래스의 search_movie_by_festival 메소드 호출
		btn[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				try {
					JPanel pn = Search.search_movie_by_festival();
					add(pn);
					setTitle("영화 관리 데이터베이스");
					setSize(700,600);
					setResizable(false);
					setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		//배우로 영화 검색을 누를시 Search 클래스의 search_movie_by_actor 메소드 호출
		btn[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				try {
					JPanel pn = Search.search_movie_by_actor();
					add(pn);
					setTitle("영화 관리 데이터베이스");
					setSize(700,600);
					setResizable(false);
					setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		//영화 이름으로 영화 검색을 누를시 Search 클래스의 search_movie_by_name 메소드 호출
		btn[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				try {
					JPanel pn = Search.search_movie_by_name();
					add(pn);
					setTitle("영화 관리 데이터베이스");
					setSize(700,600);
					setResizable(false);
					setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		//영화사 이름으로 영화사 검색을 누를시 Search 클래스의 search_company_by_name 메소드 호출
		btn[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				try {
					JPanel pn = Search.search_company_by_name();
					add(pn);
					setTitle("영화 관리 데이터베이스");
					setSize(700,600);
					setResizable(false);
					setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		//영화 이름으로 영화사 검색을 누를시 Search 클래스의 search_company_by_movie 메소드 호출
		btn[6].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				try {
					JPanel pn = Search.search_company_by_movie();
					add(pn);
					setTitle("영화 관리 데이터베이스");
					setSize(700,600);
					setResizable(false);
					setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		//영화제 이름으로 영화제 검색을 누를시 Search 클래스의 search_festival_by_name 메소드 호출
		btn[7].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				try {
					JPanel pn = Search.search_festival_by_name();
					add(pn);
					setTitle("영화 관리 데이터베이스");
					setSize(700,600);
					setResizable(false);
					setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		//국가 이름으로 영화제 검색을 누를시 Search 클래스의 search_festival_by_country 메소드 호출
		btn[8].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				try {
					JPanel pn = Search.search_festival_by_country();
					add(pn);
					setTitle("영화 관리 데이터베이스");
					setSize(700,600);
					setResizable(false);
					setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		//배우 이름으로 배우 검색을 누를시 Search 클래스의 search_actor_by_name 메소드 호출
		btn[9].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				try {
					JPanel pn = Search.search_actor_by_name();
					add(pn);
					setTitle("영화 관리 데이터베이스");
					setSize(700,600);
					setResizable(false);
					setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		//출연작으로 배우 검색을 누를시 Search 클래스의 search_actor_by_film 메소드 호출
		btn[10].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				try {
					JPanel pn = Search.search_actor_by_film();
					add(pn);
					setTitle("영화 관리 데이터베이스");
					setSize(700,600);
					setResizable(false);
					setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		//영화 이름으로 수상기록 검색을 누를시 Search 클래스의 search_award_by_film 메소드 호출
		btn[11].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				try {
					JPanel pn = Search.search_award_by_film();
					add(pn);
					setTitle("영화 관리 데이터베이스");
					setSize(700,600);
					setResizable(false);
					setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		//감독으로 수상기록 검색을 누를시 Search 클래스의 search_award_by_director 메소드 호출
		btn[12].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pn.setVisible(false);
				try {
					JPanel pn = Search.search_award_by_director();
					add(pn);
					setTitle("영화 관리 데이터베이스");
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
		
		setTitle("영화 관리 데이터베이스");
		setSize(700,600);
		setResizable(false);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//데이터 추가를 돕는 화면
	public void Panel_inserting() {
		JButton btn_movie = new JButton("1.영화");
		JButton btn_company = new JButton("2.영화사");
		JButton btn_festival = new JButton("3.영화제");
		JButton btn_actor = new JButton("4.배우");
		JButton btn_award = new JButton("5.수상정보");
		JButton btn_cancle = new JButton("취소");
		
		JPanel ipn = new JPanel();
		
		ipn.add(btn_movie);
		ipn.add(btn_company);
		ipn.add(btn_festival);
		ipn.add(btn_actor);
		ipn.add(btn_award);
		ipn.add(btn_cancle);
		
		add(ipn);
		
		//영화 버튼을 누를시 영화 테이블에 데이터 추가
		btn_movie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertMovie in_m = new InsertMovie();
			}
		});

		//영화사 버튼을 누를시 영화사 테이블에 데이터 추가
		btn_company.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertCompany in_c = new InsertCompany();
			}
		});

		//영화제 버튼을 누를시 영화제 테이블에 데이터 추가
		btn_festival.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertFestival in_f = new InsertFestival();
			}
		});

		//배우 버튼을 누를시 배우 테이블에 데이터 추가
		btn_actor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertActor in_a = new InsertActor();
			}
		});

		//수상정보 버튼을 누를시 수상정보 테이블에 데이터 추가
		btn_award.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertAward in_aw = new InsertAward();
			}
		});

		//취소 버튼을 누를시 Panel_for_admin 화면으로 돌아감
		btn_cancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ipn.setVisible(false);
				Panel_for_admin();
			}
		});
	}
	
	//데이터 갱신을 돕는 화면
	public void Panel_updating() {
		JButton btn_movie = new JButton("1.영화");
		JButton btn_company = new JButton("2.영화사");
		JButton btn_festival = new JButton("3.영화제");
		JButton btn_actor = new JButton("4.배우");
		JButton btn_award = new JButton("5.수상정보");
		JButton btn_cancle = new JButton("취소");
		
		JPanel ipn = new JPanel();
		
		ipn.add(btn_movie);
		ipn.add(btn_company);
		ipn.add(btn_festival);
		ipn.add(btn_actor);
		ipn.add(btn_award);
		ipn.add(btn_cancle);
		
		add(ipn);
		
		//영화 버튼을 누를시 영화 테이블 데이터 갱신
		btn_movie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateMovie up_m = new UpdateMovie();
			}
		});

		//영화사 버튼을 누를시 영화사 테이블 데이터 갱신
		btn_company.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateCompany up_c = new UpdateCompany();
			}
		});

		//영화제 버튼을 누를시 영화제 테이블 데이터 갱신
		btn_festival.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateFestival up_f = new UpdateFestival();
			}
		});

		//배우 버튼을 누를시 배우 테이블 데이터 갱신
		btn_actor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateActor up_a = new UpdateActor();
			}
		});

		//수상정보 버튼을 누를시 수상정보 테이블 데이터 갱신
		btn_award.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateAward up_aw = new UpdateAward();
			}
		});
		
		//취소 버튼을 누를시 Panel_for_admin 화면으로 돌아감
		btn_cancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ipn.setVisible(false);
				Panel_for_admin();
			}
		});
	}
	
	//데이터 삭제를 돕는 화면
	public void Panel_deleting() {
		JButton btn_movie = new JButton("1.영화");
		JButton btn_company = new JButton("2.영화사");
		JButton btn_festival = new JButton("3.영화제");
		JButton btn_actor = new JButton("4.배우");
		JButton btn_award = new JButton("5.수상정보");
		JButton btn_cancle = new JButton("취소");
		
		JPanel ipn = new JPanel();
		
		ipn.add(btn_movie);
		ipn.add(btn_company);
		ipn.add(btn_festival);
		ipn.add(btn_actor);
		ipn.add(btn_award);
		ipn.add(btn_cancle);
		
		add(ipn);

		//영화 버튼을 누를시 영화 테이블 데이터 삭제
		btn_movie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteMovie d_m = new DeleteMovie();
			}
		});

		//영화사 버튼을 누를시 영화사 테이블 데이터 삭제
		btn_company.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteCompany d_c = new DeleteCompany();
			}
		});

		//영화제 버튼을 누를시 영화제 테이블 데이터 삭제
		btn_festival.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteFestival d_f = new DeleteFestival();
			}
		});

		//배우 버튼을 누를시 배우 테이블 데이터 삭제
		btn_actor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteActor d_a = new DeleteActor();
			}
		});

		//수상정보 버튼을 누를시 수상정보 테이블 데이터 삭제
		btn_award.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteAward in_aw = new DeleteAward();
			}
		});
		
		//취소 버튼을 누를시 Panel_for_admin 화면으로 돌아감
		btn_cancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ipn.setVisible(false);
				Panel_for_admin();
			}
		});
	}
}

