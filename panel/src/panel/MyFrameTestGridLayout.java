package panel;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyFrameTestGridLayout extends JFrame  {
	
	private static final long serialVersionUID = 1L;
	
	private JPanel panel1 = null;
	private JPanel panel2 = null;
	private JPanel panel3 = null;
	private JPanel panel4 = null;
	private JPanel panel5 = null;
	
	private JPanel panel6 = null;
	private JPanel panel7 = null;
	private JPanel panel8 = null;
	private JPanel panel9 = null;
	private JPanel panel0 = null;

	public MyFrameTestGridLayout(String name) {
		super(name);
		init();
	}
	
	public void init() {
		this.setLayout(new GridLayout(5,2));
		ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("lib/login.jpg"));
		JLabel label = new JLabel(icon);
		label.setSize(10,10);//在布局管理器中设置控件的大小是无效的
		
		panel1 =new JPanel();
		panel2 =new JPanel();
		panel3 =new JPanel();
		panel4 =new JPanel();
		panel5 =new JPanel();
		panel6 =new JPanel();
		panel7 =new JPanel();
		panel8 =new JPanel();
		panel9 =new JPanel();
		panel0 =new JPanel();
		panel1.setBackground(Color.red);
		panel2.setBackground(Color.yellow);
		panel3.setBackground(Color.black);
		panel4.setBackground(Color.green);
		panel5.setBackground(Color.gray);
		
		panel6.setBackground(Color.blue);
		panel7.setBackground(Color.white);
		panel8.setBackground(Color.cyan);
		panel9.setBackground(Color.LIGHT_GRAY);
		panel0.setBackground(Color.pink);
		
		panel6.add(label);
		
		this.getContentPane().add(panel1);
		this.getContentPane().add(panel2);
		this.getContentPane().add(panel3);
		this.getContentPane().add(panel4);
		this.getContentPane().add(panel5);
		
		this.getContentPane().add(panel6);
		this.getContentPane().add(panel7);
		this.getContentPane().add(panel8);
		this.getContentPane().add(panel9);
		this.getContentPane().add(panel0);
		
		this.setSize(600, 600);
		this.setLocationRelativeTo(null);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		/**
		 * 测试结果，采用布局管理可以使得内容随窗口的变化自动改变，四周的似乎不变，中间的会自动改变
		 */
		new MyFrameTestGridLayout("Test");
	}

}
