package youth.hong.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import youth.hong.biz.UserBiz;
import youth.hong.biz.impl.UserBizImpl;
import youth.hong.entity.User;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel panel_main = null;// �����
	private JPanel panel_left = null;// �����
	private JPanel panel_right = null;// �����

	private JLabel lb_uname = null;// �û���
	private JLabel lb_upass = null;// ����
	private JLabel lb_type = null;// �û�����

	private JTextField tf_uname = null;// �û����ı���
	private JPasswordField pf_pass = null;// �����

	private JLabel lb_img = null;// ��ʾͼƬ��ǩ

	private JButton btn_login = null;// ��½��ť
	private JButton btn_register = null;// ע�ᰴť

	private JComboBox<String> cb_type = null;// ��½����

	public Login(String name) {
		super(name);
		init();
		bind();
	}

	public void init() {
		this.setSize(600, 300);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(Login.EXIT_ON_CLOSE);
		//���ô��������ʾ
		// Toolkit tk = Toolkit.getDefaultToolkit();
		// Dimension dimension = tk.getScreenSize();
		// int srceenWidth = dimension.width;
		// int srceenHeight = dimension.height;
		// int windowWidth = this.getWidth();
		// int windowHeight = this.getHeight();
		// this.setLocation((srceenWidth - windowWidth) / 2, (srceenHeight -
		// windowHeight) / 2);
		// ����������һ�д������������⣬��Ԫ����Ϊnull��
		this.setLocationRelativeTo(null);
		panel_main = new JPanel(new GridLayout(1, 2));
		panel_left = new JPanel(new BorderLayout());
		//4��2�У�ˮƽ���Ϊ0����ֱ���Ϊ10
		panel_right = new JPanel(new GridLayout(4, 2, 0, 10));
		lb_upass = new JLabel("<html>�� ��:</html>");
		lb_type = new JLabel("<html>�� ��:</html>");
		tf_uname = new JTextField();
		pf_pass = new JPasswordField();
		cb_type = new JComboBox<String>(new String[] { "��ͨ�û�", "����Ա" });
		// cb_type.addItem("��ͨ�û�");
		// cb_type.addItem("����Ա");
		btn_login = new JButton("��½");
		btn_register = new JButton("ע��");
		lb_uname = new JLabel("<html>�û���:</html>");
		//�����ı�������ʾ
		lb_uname.setHorizontalAlignment(JLabel.CENTER);
		lb_upass.setHorizontalAlignment(JLabel.CENTER);
		lb_type.setHorizontalAlignment(JLabel.CENTER);
		lb_img = new JLabel();
		//��ȡͼƬ
		ImageIcon icon = new ImageIcon(this.getClass().getClassLoader().getResource("lib/login.jpg"));
		lb_img.setIcon(icon);
		panel_left.add(lb_img);
		panel_right.add(lb_uname);
		panel_right.add(tf_uname);
		panel_right.add(lb_upass);
		panel_right.add(pf_pass);
		panel_right.add(lb_type);
		panel_right.add(cb_type);
		panel_right.add(btn_login);
		panel_right.add(btn_register);

		panel_main.add(panel_left);
		panel_main.add(panel_right);
		this.getContentPane().add(panel_main, BorderLayout.CENTER);
		this.setResizable(false);
		this.setVisible(true);
	}

	public void bind() {
		btn_login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				login();

			}
		});

		btn_register.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				register();

			}
		});

	}

	public void register() {
		new Register("ע��");
		this.dispose();
	}

	public void login() {
		String username = tf_uname.getText();
		char[] passwordChar = pf_pass.getPassword();
		String password = new String(passwordChar);
		String typeStr = (String)cb_type.getSelectedItem();
		int type = 0;
		if("��ͨ�û�".equals(typeStr)) {
			type = 0;
		} else {
			type = 1;
		}
		if (username == null || "".equals(username.trim())) {
			JOptionPane.showMessageDialog(Login.this, "�������û�����", "warning", JOptionPane.ERROR_MESSAGE,
					new ImageIcon("src/lib/warning.png"));
			return;
		} else if (password == null || "".equals(password.trim())) {
			JOptionPane.showMessageDialog(Login.this, "���������룡", "warning", JOptionPane.ERROR_MESSAGE,
					new ImageIcon("src/lib/warning.png"));
			return;
		} else {
			User user = new User(username, password, type);
			UserBiz biz = new UserBizImpl();
			user = biz.login(user);
			if(user == null) {
				JOptionPane.showMessageDialog(Login.this, "�û������ڣ�", "warning", JOptionPane.ERROR_MESSAGE,
						new ImageIcon("src/lib/warning.png"));
				return;
			} else {
				if(0 == type) {
					new UserMainPanel("�û�����", user);
					
				} else {
					new AdminMainPanel("����Ա����");
				}
				this.dispose();
			}
		}
	}

	public static void main(String[] args) {
		new Login("login");
	}

}
