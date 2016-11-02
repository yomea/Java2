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

	private JPanel panel_main = null;// 主面板
	private JPanel panel_left = null;// 左面板
	private JPanel panel_right = null;// 右面板

	private JLabel lb_uname = null;// 用户名
	private JLabel lb_upass = null;// 密码
	private JLabel lb_type = null;// 用户类型

	private JTextField tf_uname = null;// 用户名文本框
	private JPasswordField pf_pass = null;// 密码框

	private JLabel lb_img = null;// 显示图片标签

	private JButton btn_login = null;// 登陆按钮
	private JButton btn_register = null;// 注册按钮

	private JComboBox<String> cb_type = null;// 登陆类型

	public Login(String name) {
		super(name);
		init();
		bind();
	}

	public void init() {
		this.setSize(600, 300);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(Login.EXIT_ON_CLOSE);
		//设置窗体居中显示
		// Toolkit tk = Toolkit.getDefaultToolkit();
		// Dimension dimension = tk.getScreenSize();
		// int srceenWidth = dimension.width;
		// int srceenHeight = dimension.height;
		// int windowWidth = this.getWidth();
		// int windowHeight = this.getHeight();
		// this.setLocation((srceenWidth - windowWidth) / 2, (srceenHeight -
		// windowHeight) / 2);
		// 可以用以下一行代码解决居中问题，父元件设为null；
		this.setLocationRelativeTo(null);
		panel_main = new JPanel(new GridLayout(1, 2));
		panel_left = new JPanel(new BorderLayout());
		//4行2列，水平间隔为0，垂直间隔为10
		panel_right = new JPanel(new GridLayout(4, 2, 0, 10));
		lb_upass = new JLabel("<html>密 码:</html>");
		lb_type = new JLabel("<html>类 型:</html>");
		tf_uname = new JTextField();
		pf_pass = new JPasswordField();
		cb_type = new JComboBox<String>(new String[] { "普通用户", "管理员" });
		// cb_type.addItem("普通用户");
		// cb_type.addItem("管理员");
		btn_login = new JButton("登陆");
		btn_register = new JButton("注册");
		lb_uname = new JLabel("<html>用户名:</html>");
		//设置文本居中显示
		lb_uname.setHorizontalAlignment(JLabel.CENTER);
		lb_upass.setHorizontalAlignment(JLabel.CENTER);
		lb_type.setHorizontalAlignment(JLabel.CENTER);
		lb_img = new JLabel();
		//获取图片
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
		new Register("注册");
		this.dispose();
	}

	public void login() {
		String username = tf_uname.getText();
		char[] passwordChar = pf_pass.getPassword();
		String password = new String(passwordChar);
		String typeStr = (String)cb_type.getSelectedItem();
		int type = 0;
		if("普通用户".equals(typeStr)) {
			type = 0;
		} else {
			type = 1;
		}
		if (username == null || "".equals(username.trim())) {
			JOptionPane.showMessageDialog(Login.this, "请输入用户名！", "warning", JOptionPane.ERROR_MESSAGE,
					new ImageIcon("src/lib/warning.png"));
			return;
		} else if (password == null || "".equals(password.trim())) {
			JOptionPane.showMessageDialog(Login.this, "请输入密码！", "warning", JOptionPane.ERROR_MESSAGE,
					new ImageIcon("src/lib/warning.png"));
			return;
		} else {
			User user = new User(username, password, type);
			UserBiz biz = new UserBizImpl();
			user = biz.login(user);
			if(user == null) {
				JOptionPane.showMessageDialog(Login.this, "用户不存在！", "warning", JOptionPane.ERROR_MESSAGE,
						new ImageIcon("src/lib/warning.png"));
				return;
			} else {
				if(0 == type) {
					new UserMainPanel("用户操作", user);
					
				} else {
					new AdminMainPanel("管理员操作");
				}
				this.dispose();
			}
		}
	}

	public static void main(String[] args) {
		new Login("login");
	}

}
