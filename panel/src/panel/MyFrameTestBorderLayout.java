package panel;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyFrameTestBorderLayout extends JFrame  {
	
	private static final long serialVersionUID = 1L;
	
	private JPanel panel1 = null;
	private JPanel panel2 = null;
	private JPanel panel3 = null;
	private JPanel panel4 = null;
	private JPanel panel5 = null;
	
	private JLabel label1 = null;
	
	private JLabel label2 = null;
	
	private JLabel label3 = null;
	
	private JLabel label4 = null;

	public MyFrameTestBorderLayout(String name) {
		super(name);
		init();
	}
	
	public void init() {
		this.setLayout(new BorderLayout());
		panel1 =new JPanel();
		panel2 =new JPanel();
		panel3 =new JPanel();
		panel4 =new JPanel();
		panel5 =new JPanel();
		
		label1 = new JLabel("hello");
		label2 = new JLabel("worldbbbbbbbbbbbbbbbbbb");
		label3 = new JLabel("sdjfslkdgsdkfgsdkfjgdfggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg");
		ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("lib/login.jpg"));
		label4 = new JLabel(icon);
		
		panel1.setBackground(Color.red);
		panel2.setBackground(Color.yellow);
		panel3.setBackground(Color.black);
		panel4.setBackground(Color.green);
		panel5.setBackground(Color.gray);
		this.getContentPane().add(panel1, BorderLayout.NORTH);
		panel1.add(label3);
		this.getContentPane().add(panel2, BorderLayout.SOUTH);
		panel2.add(label4);
		System.out.println(label4.getWidth());//为0
		this.getContentPane().add(panel3, BorderLayout.WEST);
		panel3.add(label1);
		this.getContentPane().add(panel4, BorderLayout.EAST);
		panel4.add(label2);
		this.getContentPane().add(panel5, BorderLayout.CENTER);
	//	panel5.add(label4);
		System.out.println(panel5.getWidth());//为0
		this.setSize(600, 600);
		
		this.setLocationRelativeTo(null);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setVisible(true);
		
		System.out.println(label4.getWidth());//256
		System.out.println(panel5.getWidth());//379
		
	}
	
	public static void main(String[] args) {
		/**
		 * 测试结果，采用布局管理可以使得内容随窗口的变化自动改变，四周的似乎不变，中间的会自动改变
		 */
		new MyFrameTestBorderLayout("Test");
	}

}
