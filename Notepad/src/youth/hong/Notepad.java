package youth.hong;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Notepad extends JFrame {
	private static final long serialVersionUID = 1L;

	private JScrollPane scroll = null;
	private JTextArea jtt = null;
	private JMenuBar menuBar = null;
	private JMenu menuFile = null;
	private JMenu menuHelp = null;
	private JMenuItem menuItemNew = null;
	private JMenuItem menuItemOpen = null;
	private JMenuItem menuItemExit = null;
	private JMenuItem menuItemAbout = null;

	public Notepad(String name) {
		super(name);
	}

	public void lanuchFram() {
		this.setSize(500, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		menuBar = new JMenuBar();
		menuFile = new JMenu("文件");
		menuHelp = new JMenu("帮助");
		menuItemNew = new JMenuItem("新建");
		menuItemOpen = new JMenuItem("打开");
		menuItemExit = new JMenuItem("退出");
		menuItemAbout = new JMenuItem("关于");
		menuFile.add(menuItemNew);
		menuFile.add(menuItemOpen);
		menuFile.add(menuItemExit);
		menuHelp.add(menuItemAbout);
		menuBar.add(menuFile);
		menuBar.add(menuHelp);
		this.setJMenuBar(menuBar);

		jtt = new JTextArea();
		jtt.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		scroll = new JScrollPane(jtt);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.add(scroll, BorderLayout.CENTER);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension dimension = kit.getScreenSize();
		int screenWidth = dimension.width;
		int screenHeight = dimension.height;
		int windowWidth = this.getWidth();
		int windowHeight = this.getHeight();
		this.setLocation((screenWidth - windowWidth) / 2, (screenHeight - windowHeight) / 2);
		this.setVisible(true);
	}

	public void setRigister() {
		menuItemNew.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				newFile();

			}
		});

		menuItemOpen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				open();

			}
		});

		menuItemExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				exit();

			}
		});

		menuItemAbout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				about();

			}
		});

	}

	public void about() {
		new MyDialog(Notepad.this, "about", true).setVisible(true);
		;
	}

	public void newFile() {
		String text = jtt.getText();
		if (!"".equals(text)) {
			int opertion = JOptionPane.showConfirmDialog(null, "确认保存？", "提示", JOptionPane.YES_NO_OPTION);
			if (opertion == JOptionPane.YES_OPTION) {
				FileDialog fileDialog = new FileDialog(this, "保存", FileDialog.SAVE);
				fileDialog.setVisible(true);
			} else {
				jtt.setText("");
			}
		}
	}

	public void open() {
		jtt.setText("");
		FileDialog fileDialog = new FileDialog(this, "保存", FileDialog.LOAD);
		InputStream in = null;
		BufferedReader br = null;
		// fileDialog.setMultipleMode(true);
		fileDialog.setFilenameFilter(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				if(name.endsWith(".java") || name.endsWith(".txt")) {
					return true;
				} else {
					return false;
					
				}
			}
		});
		fileDialog.setVisible(true);
		File[] files = fileDialog.getFiles();
		for (File file : files) {
			try {
				in = new FileInputStream(file);
				br = new BufferedReader(new InputStreamReader(in, "GBK"));
				String string = "";
				while ((string = br.readLine()) != null) {
					jtt.append(string + "\n");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void exit() {
		newFile();
		System.exit(0);
	}

	public static void main(String[] args) {
		Notepad notepad = new Notepad("notepad");
		notepad.lanuchFram();
		notepad.setRigister();
	}

	private class MyDialog extends JDialog {
		private static final long serialVersionUID = 2L;

		private JLabel label = null;
		private JButton button = null;
		private JPanel panel = null;

		public MyDialog(Frame frame, String title, boolean model) {
			super(frame, title, model);
			init();
			register();
		}

		public void init() {
			label = new JLabel("<html>一个小小记事本，多多指教！</html>");
			label.setHorizontalAlignment(JLabel.CENTER);
			button = new JButton("ok");
			panel = new JPanel();
			panel.add(label, BorderLayout.CENTER);
			panel.add(button, BorderLayout.SOUTH);
			this.add(panel);
			this.setSize(200, 200);
			Toolkit kit = Toolkit.getDefaultToolkit();
			Dimension dimension = kit.getScreenSize();
			int screenWidth = dimension.width;
			int screenHeight = dimension.height;
			int windowWidth = this.getWidth();
			int windowHeight = this.getHeight();
			this.setLocation((screenWidth - windowWidth) / 2, (screenHeight - windowHeight) / 2);

		}

		public void register() {
			button.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					MyDialog.this.dispose();

				}
			});
		}

	}

}
