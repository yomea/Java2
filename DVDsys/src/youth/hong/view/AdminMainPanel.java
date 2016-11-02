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

public class AdminMainPanel extends JFrame {
	
	private static final long serialVersionUID = 3L;

	private JPanel main_panel = null;//�����
	
	private JPanel wel_panel = null;//��ӭ���
	
	private JPanel btn_panel = null;//��ť���
	
	private JDesktopPane funcDesktop = null;//�������
	
	private JButton btn_query_rent_dvd = null;//��ѯ�������ް�ť
	
	private JButton btn_dvd_record = null;//�鿴���޼�¼
	
	private JButton btn_exit = null;//�˳���ť
	
	private JLabel deskLabel = null;//���ͼƬ��label
	
	private JLabel lb_welcome = null;//��ӭ����
	
	private JLabel top_label = null;
	
	public AdminMainPanel(String name) {
		super(name);
		init();
		register();
	}
	
	private void init() {
		top_label = new JLabel("���鳬");
		top_label.setFont(new Font("΢���ź�", Font.BOLD, 25));
		top_label.setForeground(Color.pink);
		top_label.setBounds(0, 0, 100, 100);
		btn_panel = new JPanel(new GridLayout(7, 1, 0, 30));
		btn_query_rent_dvd = new JButton("����ԱDVD����");
		btn_dvd_record = new JButton("DVD���޼�¼��ѯ");
		btn_exit = new JButton("�˳�����");
		btn_panel.add(new JPanel());
		btn_panel.add(new JPanel());
		btn_panel.add(btn_query_rent_dvd);
		btn_panel.add(btn_dvd_record);
		btn_panel.add(btn_exit);
		btn_panel.add(new JPanel());
		btn_panel.add(new JPanel());
		btn_panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(), "��ݹ�����"));
		
		wel_panel = new JPanel();
		lb_welcome = new JLabel("��   ӭ   ��   ��   Ա  ��   ½   ��   ��   ϵ   ͳ");
		lb_welcome.setFont(new Font("����", Font.BOLD, 35));
		lb_welcome.setForeground(Color.BLUE);
		wel_panel.add(lb_welcome);
		
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new Thread(new DynamicThread()).start();
				//lb_welcome.setLocation(600, 0);
			}
		});
		//�������
		funcDesktop = new JDesktopPane();
		deskLabel = new JLabel();
		ImageIcon icon = new ImageIcon(this.getClass().getClassLoader().getResource("lib/ad.jpg"));
		deskLabel.setIcon(icon);
		deskLabel.setBounds(0, 0, 900, 600);
		//add�ĵڶ������������νṹ�����������ӽ�ȥ�Ŀؼ����ܻῴ����
		funcDesktop.add(deskLabel, new Integer(Integer.MIN_VALUE));
		funcDesktop.add(top_label,Integer.MIN_VALUE + 1);
		
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
	
	public static void main(String[] args) {
		new AdminMainPanel("");
	}
	
	private void register() {
		btn_query_rent_dvd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AdminDVD userReDVDs = new AdminDVD();
				funcDesktop.add(userReDVDs);
				//���鴰�ڷ������пؼ�����ǰ�棬�ѵ�˳��Ķ���
				userReDVDs.toFront();
				
			}
		});
		
		btn_dvd_record.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AdminRecord userRentRecord = new AdminRecord();
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
					//lb_welcome.setBounds(i, 0,800,50);
					
				}
				/*try {
					//�����240ms�����setLocation��������Ч�����ܴ��ڳ�ʼ����
					Thread.sleep(240);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				lb_welcome.setLocation(600, 0);*/
			}
			
		}
		
	}
	
}
