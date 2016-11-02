package youth.hong.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import youth.hong.biz.UserBiz;
import youth.hong.biz.impl.UserBizImpl;
import youth.hong.entity.User;

public class Register extends JFrame {

	private static final long serialVersionUID = 2L;

	private JPanel panel = null;
	private JPanel panel1 = null;
	private JPanel panel2 = null;
	private JPanel panel3 = null;
	private JPanel panel4 = null;
	private JPanel panel5 = null;

	private JLabel lb_name = null;
	private JLabel lb_init_pass = null;
	private JLabel lb_confirm_pass = null;
	private JTextField tf_name = null;
	private JPasswordField userPassInit = null;
	private JPasswordField userPassConfirm = null;
	private JButton btn_confirm = null;
	private JButton btn_back = null;

	public Register(String name) {
		super(name);
		init();
		register();
	}

	public void init() {

		lb_name = new JLabel(" 用户名:");
		lb_name.setFont(new Font("宋体", Font.BOLD, 15));
		lb_init_pass = new JLabel("   密码:");
		lb_init_pass.setFont(new Font("宋体", Font.BOLD, 15));
		lb_confirm_pass = new JLabel("确认密码:");
		lb_confirm_pass.setFont(new Font("宋体", Font.BOLD, 15));
		tf_name = new JTextField(15);
		userPassInit = new JPasswordField(15);
		userPassConfirm = new JPasswordField(15);
		btn_confirm = new JButton("确认提交");
		btn_back = new JButton("退出");
		panel = new JPanel(new GridLayout(5, 1));
		//一个空的panel用来空行的
		panel1 = new JPanel();
		// panel的默认new FlowLayout(FlowLayout.CENTER)
		panel2 = new JPanel();
		panel3 = new JPanel();

		panel4 = new JPanel();
		panel5 = new JPanel();
		panel.add(panel1);

		panel2.add(lb_name);
		panel2.add(tf_name);

		panel.add(panel2);

		panel3.add(lb_init_pass);
		panel3.add(userPassInit);

		panel.add(panel3);

		panel4.add(lb_confirm_pass);
		panel4.add(userPassConfirm);

		panel.add(panel4);

		panel5.add(btn_confirm);
		panel5.add(btn_back);

		panel.add(panel5);
		this.getContentPane().add(panel, BorderLayout.CENTER);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.getRootPane().setDefaultButton(btn_confirm);
		this.setSize(450, 300);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}

	public void register() {
		btn_back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				exit();
			}
		});

		btn_confirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				submit();

			}
		});
	}

	public void submit() {
		char[] userPass1 = userPassInit.getPassword();
		char[] userPass2 = userPassConfirm.getPassword();
		String username = tf_name.getText();
		String password = "";
		if (username == null || "".equals(username.trim())) {
			//Register.this值得是父元件
			JOptionPane.showMessageDialog(Register.this, "请输入用户名！", "warning", JOptionPane.ERROR_MESSAGE,
					new ImageIcon("src/lib/warning.png"));
			return;
		} else if (userPass1 == null || new String(userPass1).equals("")) {
			JOptionPane.showMessageDialog(Register.this, "请输入密码！", "warning", JOptionPane.ERROR_MESSAGE,
					new ImageIcon("src/lib/warning.png"));
			return;
		} else if (userPass2 == null || new String(userPass2).equals("")) {
			JOptionPane.showMessageDialog(Register.this, "请输入确认密码！", "warning", JOptionPane.ERROR_MESSAGE,
					new ImageIcon("src/lib/warning.png"));
			return;
		} else if (!new String(userPass1).equals(new String(userPass2))) {
			JOptionPane.showMessageDialog(Register.this, "两次密码不一致！", "warning", JOptionPane.ERROR_MESSAGE,
					new ImageIcon("src/lib/warning.png"));
			return;
		} else {
			password = new String(userPass1);
			User user = new User(username, password, 0);
			UserBiz biz = new UserBizImpl();
			int status = biz.registerUser(user);
			if(status ==1) {
				new Login("login");
				this.dispose();
			} else if(status ==0){
				JOptionPane.showMessageDialog(Register.this, "重复注册！", "warning", JOptionPane.ERROR_MESSAGE,
						new ImageIcon("src/lib/warning.png"));
				return;
			} else {
				JOptionPane.showMessageDialog(Register.this, "注册失败！", "warning", JOptionPane.ERROR_MESSAGE,
						new ImageIcon("src/lib/warning.png"));
				return;
			}
		}

	}

	public void exit() {
		System.exit(0);
	}

	public static void main(String[] args) {
		new Register("注册");
	}

}
