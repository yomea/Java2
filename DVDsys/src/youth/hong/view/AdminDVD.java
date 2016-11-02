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
 * �Ӵ���
 * @author may
 *
 */
public class AdminDVD extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	private JPanel panelTable = null;// ��������Jtable�����

	private JTable table = null;

	private JPanel panelButton = null;

	private JButton btn_search = null;// ������ť

	private JButton btn_exit = null;// �˳���ť

	private JButton btn_add = null;// ��Ӱ�ť

	private JButton btn_update = null;// ���°�ť

	private JButton btn_del = null;// ɾ����ť

	private JPanel detail_panel = null;// ��ϸ��Ϣ��

	private JComboBox<String> cb_type = null;// ����ѡ��

	private JLabel lb_type = null;// ��ѯ����

	private JLabel lb_dname = null;// dvd������

	private JLabel lb_dcount = null;// dvd����Ĵ���

	private JLabel lb_status = null;// dvd��״̬

	private JTextField tf_dname = null;// dvd�����ı���

	private JTextField tf_dcount = null;// dvd��������ı���

	private JComboBox<String> cb_status = null;// dvd״̬�����б�

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
		//�õ���ǰѡ���ѡ����±�
		int index = cb_type.getSelectedIndex();
		String content = query_text.getText();
		query_text.setText("");
		if (0 == index) {
			return biz.queryAllDVDs();
		} else {
			if (content == null || content.trim().equals("")) {
				JOptionPane.showInternalMessageDialog(AdminDVD.this, "�������ѯ������");
			} else if (1 == index) {
				try {
					int id = Integer.parseInt(content);
					DVD dvd = biz.queryDVDById(id);
					if (dvd == null) {
						JOptionPane.showMessageDialog(AdminDVD.this, "û�н����", "warning", JOptionPane.WARNING_MESSAGE);
					} else {
						dvds = new ArrayList<DVD>();
						dvds.add(dvd);
						return dvds;
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(AdminDVD.this, "��Ų���Ϊ�����֣�", "error", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				dvds = biz.queryDVDByName(content);
				if (dvds.size() <= 0) {
					JOptionPane.showMessageDialog(AdminDVD.this, "û�н����", "error", JOptionPane.WARNING_MESSAGE);
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
					JOptionPane.showInternalMessageDialog(AdminDVD.this, "��δ���κθ���", "��ʾ", JOptionPane.WARNING_MESSAGE);
					return;
				} else {
					if("".equals(strdname) || "".equals(strdcount)) {
						JOptionPane.showInternalMessageDialog(AdminDVD.this, "���ֻ��߽����������Ϊ�գ�", "��ʾ", JOptionPane.WARNING_MESSAGE);
						return;
					} else {
						try {
							int rent = Integer.parseInt(strdcount);
							DVD dvd = new DVD(strdname, rent, status);
							boolean flag = false;
							int option = JOptionPane.showConfirmDialog(AdminDVD.this, "��ȷ�������", "��ʾ",
									JOptionPane.YES_NO_OPTION);
							if (option == JOptionPane.YES_OPTION) {
								flag = biz.modifyDVD(dvd);

							} else {
								return;
							}

							if (flag) {
								JOptionPane.showInternalMessageDialog(AdminDVD.this, "�ɹ�!", "success",
										JOptionPane.PLAIN_MESSAGE);
								return;
							} else {
								JOptionPane.showInternalMessageDialog(AdminDVD.this, "ʧ�ܣ�", "error", JOptionPane.ERROR_MESSAGE,
										new ImageIcon("src/lib/warning.png"));
								return;
							}
						} catch (Exception e2) {
							JOptionPane.showInternalMessageDialog(AdminDVD.this, "�������ӦΪ���֣�", "��ʾ", JOptionPane.WARNING_MESSAGE);
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
					JOptionPane.showInternalMessageDialog(AdminDVD.this, "������dvd������", "error",
							JOptionPane.ERROR_MESSAGE, new ImageIcon("src/lib/warning.png"));
					return;
				} else if (dcount == null || "".equals(dcount.trim())) {
					JOptionPane.showInternalMessageDialog(AdminDVD.this, "������dvd�Ľ������", "error",
							JOptionPane.ERROR_MESSAGE, new ImageIcon("src/lib/warning.png"));
					return;
				} else {
					int count = 0;
					try {
						count = Integer.parseInt(dcount);
					} catch (Exception e2) {
						JOptionPane.showInternalMessageDialog(AdminDVD.this, "����������", "error",
								JOptionPane.ERROR_MESSAGE, new ImageIcon("src/lib/warning.png"));
						return;
					}
					if (tf_name_str.equals(dname)) {
						JOptionPane.showInternalMessageDialog(AdminDVD.this, "�ظ����", "error", JOptionPane.ERROR_MESSAGE,
								new ImageIcon("src/lib/warning.png"));
						return;
					}
					boolean flag = false;
					DVD dvd = new DVD(dname, count, status);
					int option = JOptionPane.showConfirmDialog(AdminDVD.this, "��ȷ�������", "��ʾ",
							JOptionPane.YES_NO_OPTION);
					if (option == JOptionPane.YES_OPTION) {
						flag = biz.addDVD(dvd);

					} else {
						return;
					}

					if (flag) {
						JOptionPane.showInternalMessageDialog(AdminDVD.this, "�ɹ�!", "success",
								JOptionPane.PLAIN_MESSAGE);
						return;
					} else {
						JOptionPane.showInternalMessageDialog(AdminDVD.this, "ʧ�ܣ�", "error", JOptionPane.ERROR_MESSAGE,
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
		this.setTitle("DVD��¼��ѯ");
		this.setSize(800, 500);
		this.setClosable(true);
		this.setIconifiable(true);
		this.setDefaultCloseOperation(AdminDVD.DISPOSE_ON_CLOSE);
		panelTable = new JPanel(new BorderLayout());
		detail_panel = new JPanel(new GridLayout(1, 6, 10, 0));
		table = new JTable();
		panelTable.add(table);
		panelTable.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(null, null), "�����б�"));
		panelButton = new JPanel(new GridLayout(8, 1, 10, 30));
		panelButton.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(null, null), "�����б�"));
		btn_search = new JButton("��ѯ");
		btn_add = new JButton("���");
		btn_add.setEnabled(false);
		btn_update = new JButton("����");
		btn_del = new JButton("ɾ��");
		btn_exit = new JButton("�˳�");
		cb_type = new JComboBox<String>(new String[] { "ȫ��DVD", "DVD���", "DVD����" });
		lb_type = new JLabel("��ѯ����");
		query_text = new JTextField();
		query_text.setEditable(false);// Ĭ�ϲ�����
		panelButton.add(lb_type);
		panelButton.add(cb_type);
		panelButton.add(query_text);
		panelButton.add(btn_search);
		btn_update.setEnabled(false);// Ĭ�ϰ�ť������
		btn_del.setEnabled(false);// Ĭ�ϰ�ť������
		panelButton.add(btn_add);
		panelButton.add(btn_update);
		panelButton.add(btn_del);
		panelButton.add(btn_exit);
		lb_dname = new JLabel("DVD����");
		lb_dname.setHorizontalAlignment(JLabel.CENTER);
		lb_dcount = new JLabel("�������");
		lb_dcount.setHorizontalAlignment(JLabel.CENTER);
		lb_status = new JLabel("DVD״̬");
		lb_status.setHorizontalAlignment(JLabel.CENTER);
		tf_dname = new JTextField(8);
		tf_dcount = new JTextField(8);
		cb_status = new JComboBox<String>(new String[] { "�ɽ�", "�ѽ�" });
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
	 * ����table��ģʽ����
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
		 * ��ñ���׼�����ֵ�����
		 * 
		 * @return
		 */
		@Override
		public int getRowCount() {
			return dvds.size();
		}

		/**
		 * �������
		 * 
		 * @return
		 */
		@Override
		public int getColumnCount() {
			return 4;
		}

		/**
		 * ���ÿ�е�����
		 * 
		 * @param columnIndex
		 * @return
		 */
		@Override
		public String getColumnName(int columnIndex) {
			String columnName = "";
			switch (columnIndex) {
			case 0:
				columnName = "DVD���";
				break;
			case 1:
				columnName = "DVD����";
				break;
			case 2:
				columnName = "�������";
				break;
			case 3:
				columnName = "�Ƿ�ɽ�";
				break;
			default:
				columnName = "����";
			}
			return columnName;
		}

		/**
		 * ����ÿ�е���������
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
		 * �������Ƿ�ɱ��༭
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
		 * ���ÿ��ÿ�е�ֵ
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
				return "���󣡣���";
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
