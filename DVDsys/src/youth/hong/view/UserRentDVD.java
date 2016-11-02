package youth.hong.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import youth.hong.biz.DVDBiz;
import youth.hong.biz.impl.DVDBizImpl;
import youth.hong.entity.DVD;

public class UserRentDVD extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	private JPanel panelTable = null;// 用来保存Jtable的面板

	private JTable table = null;

	private JPanel panelButton = null;

	private JButton btn_search = null;

	private JButton btn_rent = null;

	private JButton btn_exit = null;

	private JComboBox<String> cb_type = null;

	private JLabel lb_type = null;

	public UserRentDVD() {
		super();
		init();
		register();
	}

	private void init() {
		this.setTitle("DVD租赁信息查询");
		this.setSize(800, 500);
		this.setClosable(true);
		this.setIconifiable(true);
		this.setDefaultCloseOperation(UserRentDVD.DISPOSE_ON_CLOSE);
		panelTable = new JPanel(new BorderLayout());
		// table = new JTable();
		// panelTable.add(table);
		panelTable.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(null, null), "租赁列表"));
		panelButton = new JPanel(new GridLayout(7, 1, 10, 30));
		panelButton.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(null, null), "操作列表"));
		btn_search = new JButton("查询");
		btn_rent = new JButton("租赁");
		btn_exit = new JButton("退出");
		cb_type = new JComboBox<String>(new String[] { "全部DVD", "可借DVD", "已借DVD", "热门DVD" });
		lb_type = new JLabel("查询类型");
		panelButton.add(lb_type);
		panelButton.add(cb_type);
		panelButton.add(btn_search);
		btn_rent.setEnabled(false);// 默认租借按钮不可用
		panelButton.add(btn_rent);
		panelButton.add(new JPanel());
		panelButton.add(new JPanel());
		panelButton.add(btn_exit);

		this.getContentPane().add(panelTable, BorderLayout.CENTER);
		this.getContentPane().add(panelButton, BorderLayout.EAST);
		this.setVisible(true);

	}

	public void register() {
		
		btn_search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				List<DVD> dvds = queryDVDs();
				String[] columnNames = { "id", "DVD", "借出的次数", "是否可借" };
				Object[][] data = new Object[dvds.size()][columnNames.length];

				for (int i = 0; i < dvds.size(); i++) {

					data[i][0] = dvds.get(i).getId();
					data[i][1] = dvds.get(i).getDname();
					data[i][2] = dvds.get(i).getDcount();
					int status = dvds.get(i).getStatus();
					if (1 == status) {
						data[i][3] = "不可借";
					} else {
						data[i][3] = "可借";
					}

				}
				table = new JTable(data, columnNames);
				panelTable.add(table.getTableHeader(), BorderLayout.PAGE_START);
				for (int i = 0; i < 4; i++) {

					table.getColumnModel().getColumn(i).setPreferredWidth(130);
				}
				panelTable.add(table);

			}
		});
	}

	public List<DVD> queryDVDs() {
		String type = (String) cb_type.getSelectedItem();
		if (type == null || "".equals(type)) {
			JOptionPane.showMessageDialog(UserRentDVD.this, "出错啦！呼叫管理员", "error", JOptionPane.ERROR_MESSAGE,
					new ImageIcon("src/lib/warning.png"));
			return null;
		} else if ("全部DVD".equals(type)) {
			DVDBiz biz = new DVDBizImpl();
			return biz.queryAllDVDs();
		} else if ("可借DVD".equals(type)) {
			DVDBiz biz = new DVDBizImpl();
			return biz.canLendDVD();
		} else if ("已借DVD".equals(type)) {
			DVDBiz biz = new DVDBizImpl();
			return biz.hasLendedDVD();
		} else if ("热门DVD".equals(type)) {
			DVDBiz biz = new DVDBizImpl();
			return biz.ranking_top_five();
		} else {
			return null;

		}
	}

}
