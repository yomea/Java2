package youth.hong.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import youth.hong.entity.User;

public class UserMainPanel extends JFrame {
	
	private static final long serialVersionUID = 3L;

	private JPanel main_panel = null;//主面板
	
	private JPanel wel_panel = null;//欢迎面板
	
	private JPanel btn_panel = null;//按钮面板
	
	private JDesktopPane funcDesktop = null;//桌面面板
	
	private JButton btn_query_rent_dvd = null;//查询所有租赁按钮
	
	private JButton btn_dvd_record = null;//查看租赁记录
	
	private JButton btn_exit = null;//退出按钮
	
	private JLabel deskLabel = null;//存放图片的label
	
	private JLabel lb_welcome = null;//欢迎标题
	
	private JLabel top_label = null;
	
	private User user;
	
	public UserMainPanel(String name, User user) {
		super(name);
		this.user = user;
		init();
		register();
	}
	
	private void init() {
		top_label = new JLabel("龙珠超");
		top_label.setFont(new Font("微软雅黑", Font.BOLD, 25));
		top_label.setForeground(Color.pink);
		top_label.setBounds(0, 0, 100, 100);
		btn_panel = new JPanel(new GridLayout(7, 1, 0, 30));
		btn_query_rent_dvd = new JButton("DVD租赁操作");
		btn_dvd_record = new JButton("DVD租赁记录查询");
		btn_exit = new JButton("退出窗口");
		btn_panel.add(new JPanel());
		btn_panel.add(new JPanel());
		btn_panel.add(btn_query_rent_dvd);
		btn_panel.add(btn_dvd_record);
		btn_panel.add(btn_exit);
		btn_panel.add(new JPanel());
		btn_panel.add(new JPanel());
		btn_panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(), "快捷功能区"));
		
		wel_panel = new JPanel();
		lb_welcome = new JLabel("欢   迎  " + user.getUname() + "   登   陆   管   理   系   统");
		lb_welcome.setFont(new Font("宋体", Font.BOLD, 35));
		lb_welcome.setForeground(Color.BLUE);
		wel_panel.add(lb_welcome);
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new Thread(new DynamicThread()).start();
				
			}
		});
		
		funcDesktop = new JDesktopPane();
		deskLabel = new JLabel();
		ImageIcon icon = new ImageIcon(this.getClass().getClassLoader().getResource("lib/ad.jpg"));
		deskLabel.setIcon(icon);
		deskLabel.setBounds(0, 0, 900, 600);
		funcDesktop.add(deskLabel, new Integer(Integer.MIN_VALUE));
		funcDesktop.add(top_label);
		
		main_panel = new JPanel(new BorderLayout());
		main_panel.add(wel_panel, BorderLayout.NORTH);
		main_panel.add(funcDesktop, BorderLayout.CENTER);
		main_panel.add(btn_panel, BorderLayout.EAST);
		
		this.add(main_panel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(1000,600);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
	
	private void register() {
		btn_query_rent_dvd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				UserRentDVD userReDVDs = new UserRentDVD();
				funcDesktop.add(userReDVDs);
				userReDVDs.toFront();
				
			}
		});
		
		btn_dvd_record.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				UserRentRecord userRentRecord = new UserRentRecord();
				funcDesktop.add(userRentRecord);
				userRentRecord.toFront();
				
			}
		});
	}
	
	private class DynamicThread implements Runnable {

		@Override
		public void run() {
			while(true) {
				for(int i = 900; i > -900; i--) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					lb_welcome.setLocation(i, 0);
					
				}
			}
			
		}
		
	}
	
}
