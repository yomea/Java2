package youth.hong.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import youth.hong.biz.DVDBiz;
import youth.hong.biz.impl.DVDBizImpl;
import youth.hong.entity.DVD;
/**
 * 子窗口
 * @author may
 *
 */
public class AdminDVD extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	private JPanel panelTable = null;// 用来保存Jtable的面板

	private JTable table = null;

	private JPanel panelButton = null;

	private JButton btn_search = null;// 搜索按钮

	private JButton btn_exit = null;// 退出按钮

	private JButton btn_add = null;// 添加按钮

	private JButton btn_update = null;// 更新按钮

	private JButton btn_del = null;// 删除按钮

	private JPanel detail_panel = null;// 详细信息栏

	private JComboBox<String> cb_type = null;// 类型选择

	private JLabel lb_type = null;// 查询类型

	private JLabel lb_dname = null;// dvd的名字

	private JLabel lb_dcount = null;// dvd借出的次数

	private JLabel lb_status = null;// dvd的状态

	private JTextField tf_dname = null;// dvd名字文本框

	private JTextField tf_dcount = null;// dvd借出次数文本框

	private JComboBox<String> cb_status = null;// dvd状态下拉列表

	private DVDBiz biz = null;

	private JTextField query_text = null;

	private List<DVD> dvds = null;

	private String tf_name_str = "";

	private String countInt = "";

	private int typeInt = 0;

	public AdminDVD() {
		super();
		biz = new DVDBizImpl();
		init();
		register();
	}

	public List<DVD> search() {
		if (dvds != null) {
			dvds.clear();
		} else {
			dvds = new ArrayList<DVD>();
		}
		table.setModel(new InfoTableModel(dvds));
		//拿到当前选择框选择的下标
		int index = cb_type.getSelectedIndex();
		String content = query_text.getText();
		query_text.setText("");
		if (0 == index) {
			return biz.queryAllDVDs();
		} else {
			if (content == null || content.trim().equals("")) {
				JOptionPane.showInternalMessageDialog(AdminDVD.this, "请输入查询条件！");
			} else if (1 == index) {
				try {
					int id = Integer.parseInt(content);
					DVD dvd = biz.queryDVDById(id);
					if (dvd == null) {
						JOptionPane.showMessageDialog(AdminDVD.this, "没有结果！", "warning", JOptionPane.WARNING_MESSAGE);
					} else {
						dvds = new ArrayList<DVD>();
						dvds.add(dvd);
						return dvds;
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(AdminDVD.this, "编号不能为非数字！", "error", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				dvds = biz.queryDVDByName(content);
				if (dvds.size() <= 0) {
					JOptionPane.showMessageDialog(AdminDVD.this, "没有结果！", "error", JOptionPane.WARNING_MESSAGE);
				}
				return biz.queryDVDByName(content);
			}
		}
		return null;
	}

	public void register() {

		btn_update.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String strdname = tf_dname.getText().trim();
				String strdcount = tf_dcount.getText().trim();
				int status = cb_status.getSelectedIndex();
				if (strdname.equals(tf_name_str) && strdcount.equals(countInt) && status == typeInt) {
					JOptionPane.showInternalMessageDialog(AdminDVD.this, "您未作任何更改", "提示", JOptionPane.WARNING_MESSAGE);
					return;
				} else {
					if("".equals(strdname) || "".equals(strdcount)) {
						JOptionPane.showInternalMessageDialog(AdminDVD.this, "名字或者借出次数不能为空！", "提示", JOptionPane.WARNING_MESSAGE);
						return;
					} else {
						try {
							int rent = Integer.parseInt(strdcount);
							DVD dvd = new DVD(strdname, rent, status);
							boolean flag = false;
							int option = JOptionPane.showConfirmDialog(AdminDVD.this, "您确认添加吗？", "提示",
									JOptionPane.YES_NO_OPTION);
							if (option == JOptionPane.YES_OPTION) {
								flag = biz.modifyDVD(dvd);

							} else {
								return;
							}

							if (flag) {
								JOptionPane.showInternalMessageDialog(AdminDVD.this, "成功!", "success",
										JOptionPane.PLAIN_MESSAGE);
								return;
							} else {
								JOptionPane.showInternalMessageDialog(AdminDVD.this, "失败！", "error", JOptionPane.ERROR_MESSAGE,
										new ImageIcon("src/lib/warning.png"));
								return;
							}
						} catch (Exception e2) {
							JOptionPane.showInternalMessageDialog(AdminDVD.this, "借出次数应为数字！", "提示", JOptionPane.WARNING_MESSAGE);
							return;
						}
					}
				}

			}
		});

		cb_status.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				typeInt = cb_status.getSelectedIndex();

			}
		});

		tf_dcount.addFocusListener(new FocusAdapter() {

			@Override
			public void focusGained(FocusEvent e) {
				countInt = tf_dcount.getText().trim();
				btn_add.setEnabled(true);
			}

		});

		tf_dname.addFocusListener(new FocusAdapter() {

			@Override
			public void focusGained(FocusEvent e) {
				tf_name_str = tf_dname.getText().trim();
				btn_add.setEnabled(true);
			}

		});

		table.addMouseListener(new MouseAdapter() {
			int rowCount = -1;

			@Override
			public void mouseClicked(MouseEvent e) {
				rowCount = table.getSelectedRow();
				btn_add.setEnabled(false);
				btn_update.setEnabled(true);
				btn_del.setEnabled(true);
				if (rowCount != -1) {
					DVD dvd = dvds.get(rowCount);
					tf_dname.setText(dvd.getDname());
					tf_dcount.setText(String.valueOf(dvd.getDcount()));
					cb_status.setSelectedIndex(dvd.getStatus());
				}
			}

		});

		btn_search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				referTable();

			}
		});

		cb_type.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				JComboBox<?> source = (JComboBox<?>) e.getSource();
				int selectedIndex = source.getSelectedIndex();
				if (selectedIndex != 0) {
					query_text.setEditable(true);
				} else {
					query_text.setEditable(false);
				}

			}
		});

		btn_add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String dname = tf_dname.getText();
				String dcount = tf_dcount.getText();
				int status = cb_status.getSelectedIndex();

				if (dname == null || "".equals(dname.trim())) {
					JOptionPane.showInternalMessageDialog(AdminDVD.this, "请输入dvd的名字", "error",
							JOptionPane.ERROR_MESSAGE, new ImageIcon("src/lib/warning.png"));
					return;
				} else if (dcount == null || "".equals(dcount.trim())) {
					JOptionPane.showInternalMessageDialog(AdminDVD.this, "请输入dvd的借出次数", "error",
							JOptionPane.ERROR_MESSAGE, new ImageIcon("src/lib/warning.png"));
					return;
				} else {
					int count = 0;
					try {
						count = Integer.parseInt(dcount);
					} catch (Exception e2) {
						JOptionPane.showInternalMessageDialog(AdminDVD.this, "请输入数字", "error",
								JOptionPane.ERROR_MESSAGE, new ImageIcon("src/lib/warning.png"));
						return;
					}
					if (tf_name_str.equals(dname)) {
						JOptionPane.showInternalMessageDialog(AdminDVD.this, "重复添加", "error", JOptionPane.ERROR_MESSAGE,
								new ImageIcon("src/lib/warning.png"));
						return;
					}
					boolean flag = false;
					DVD dvd = new DVD(dname, count, status);
					int option = JOptionPane.showConfirmDialog(AdminDVD.this, "您确认添加吗？", "提示",
							JOptionPane.YES_NO_OPTION);
					if (option == JOptionPane.YES_OPTION) {
						flag = biz.addDVD(dvd);

					} else {
						return;
					}

					if (flag) {
						JOptionPane.showInternalMessageDialog(AdminDVD.this, "成功!", "success",
								JOptionPane.PLAIN_MESSAGE);
						return;
					} else {
						JOptionPane.showInternalMessageDialog(AdminDVD.this, "失败！", "error", JOptionPane.ERROR_MESSAGE,
								new ImageIcon("src/lib/warning.png"));
						return;
					}
				}

			}
		});
	}

	private void referTable() {
		dvds = search();
		if (dvds == null) {
			return;
		}
		InfoTableModel info = new InfoTableModel(dvds);
		table.setModel(info);
	}

	private void init() {
		this.setTitle("DVD记录查询");
		this.setSize(800, 500);
		this.setClosable(true);
		this.setIconifiable(true);
		this.setDefaultCloseOperation(AdminDVD.DISPOSE_ON_CLOSE);
		panelTable = new JPanel(new BorderLayout());
		detail_panel = new JPanel(new GridLayout(1, 6, 10, 0));
		table = new JTable();
		panelTable.add(table);
		panelTable.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(null, null), "租赁列表"));
		panelButton = new JPanel(new GridLayout(8, 1, 10, 30));
		panelButton.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(null, null), "操作列表"));
		btn_search = new JButton("查询");
		btn_add = new JButton("添加");
		btn_add.setEnabled(false);
		btn_update = new JButton("更新");
		btn_del = new JButton("删除");
		btn_exit = new JButton("退出");
		cb_type = new JComboBox<String>(new String[] { "全部DVD", "DVD编号", "DVD名字" });
		lb_type = new JLabel("查询类型");
		query_text = new JTextField();
		query_text.setEditable(false);// 默认不可用
		panelButton.add(lb_type);
		panelButton.add(cb_type);
		panelButton.add(query_text);
		panelButton.add(btn_search);
		btn_update.setEnabled(false);// 默认按钮不可用
		btn_del.setEnabled(false);// 默认按钮不可用
		panelButton.add(btn_add);
		panelButton.add(btn_update);
		panelButton.add(btn_del);
		panelButton.add(btn_exit);
		lb_dname = new JLabel("DVD名字");
		lb_dname.setHorizontalAlignment(JLabel.CENTER);
		lb_dcount = new JLabel("借出次数");
		lb_dcount.setHorizontalAlignment(JLabel.CENTER);
		lb_status = new JLabel("DVD状态");
		lb_status.setHorizontalAlignment(JLabel.CENTER);
		tf_dname = new JTextField(8);
		tf_dcount = new JTextField(8);
		cb_status = new JComboBox<String>(new String[] { "可借", "已借" });
		detail_panel.add(lb_dname);
		detail_panel.add(tf_dname);
		detail_panel.add(lb_dcount);
		detail_panel.add(tf_dcount);
		detail_panel.add(lb_status);
		detail_panel.add(cb_status);
		panelTable.add(detail_panel, BorderLayout.SOUTH);
		this.getContentPane().add(panelTable, BorderLayout.CENTER);
		this.getContentPane().add(panelButton, BorderLayout.EAST);
		this.setVisible(true);

	}

	/**
	 * 定义table的模式数据
	 * 
	 * @author May
	 *
	 */
	private class InfoTableModel implements TableModel {

		List<DVD> dvds = null;

		public InfoTableModel(List<DVD> dvds) {
			this.dvds = dvds;
		}

		/**
		 * 获得表格的准备出现的行数
		 * 
		 * @return
		 */
		@Override
		public int getRowCount() {
			return dvds.size();
		}

		/**
		 * 获得列数
		 * 
		 * @return
		 */
		@Override
		public int getColumnCount() {
			return 4;
		}

		/**
		 * 获得每列的列名
		 * 
		 * @param columnIndex
		 * @return
		 */
		@Override
		public String getColumnName(int columnIndex) {
			String columnName = "";
			switch (columnIndex) {
			case 0:
				columnName = "DVD编号";
				break;
			case 1:
				columnName = "DVD名称";
				break;
			case 2:
				columnName = "借出次数";
				break;
			case 3:
				columnName = "是否可借";
				break;
			default:
				columnName = "出错";
			}
			return columnName;
		}

		/**
		 * 定义每列的数据类型
		 * 
		 * @param columnIndex
		 * @return
		 */
		@Override
		public Class<?> getColumnClass(int columnIndex) {
			/*
			 * Class<?> columnType = null; switch (columnIndex) { case 0:
			 * columnType = Integer.class; break; case 1: columnType =
			 * String.class; break; case 2: columnType = Integer.class; break;
			 * case 3: columnType = String.class; break; default: columnType =
			 * String.class; }
			 */
			return getValueAt(0, columnIndex).getClass();
		}

		/**
		 * 定义表格是否可被编辑
		 * 
		 * @param rowIndex
		 * @param columnIndex
		 * @return
		 */
		@Override
		public boolean isCellEditable(int rowIndex, int columnIndex) {
			return false;
		}

		/**
		 * 获得每列每行的值
		 * 
		 * @param rowIndex
		 * @param columnIndex
		 * @return
		 */
		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			switch (columnIndex) {
			case 0:
				return dvds.get(rowIndex).getId();
			case 1:
				return dvds.get(rowIndex).getDname();
			case 2:
				return dvds.get(rowIndex).getDcount();
			case 3:
				return dvds.get(rowIndex).getStatus();
			default:
				return "错误！！！";
			}
		}

		@Override
		public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
			// TODO Auto-generated method stub

		}

		@Override
		public void addTableModelListener(TableModelListener l) {
			// TODO Auto-generated method stub

		}

		@Override
		public void removeTableModelListener(TableModelListener l) {
			// TODO Auto-generated method stub

		}

	}

}
