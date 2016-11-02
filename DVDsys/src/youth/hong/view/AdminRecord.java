package youth.hong.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class AdminRecord extends JInternalFrame {
		
	private static final long serialVersionUID = 1L;

	private JPanel panelTable = null;//��������Jtable�����
	
	private JTable table = null;
	
	private JPanel panelButton = null;
	
	private JButton btn_search = null;
	
	private JTextField lb_uname = null;
	
	private JButton btn_exit = null;
	
	private JComboBox<String> cb_type = null;
	
	private JLabel lb_type = null;
	
	public AdminRecord() {
		super();
		init();
	}
	
	private void init() {
		this.setTitle("DVD������Ϣ��ѯ");
		this.setSize(800, 500);
		this.setClosable(true);
		this.setIconifiable(true);
		this.setDefaultCloseOperation(AdminRecord.DISPOSE_ON_CLOSE);
		panelTable = new JPanel(new BorderLayout());
		table = new JTable();
		String[] columnNames = { "First Name", "Last Name", "Sport", "# of Years", "Vegetarian" };

		Object[][] data = { { "Kathy", "Smith", "Snowboarding", new Integer(5), new Boolean(false) },
				{ "John", "Doe", "Rowing", new Integer(3), new Boolean(true) },
				{ "Sue", "Black", "Knitting", new Integer(2), new Boolean(false) },
				{ "Jane", "White", "Speed reading", new Integer(20), new Boolean(true) },
				{ "Joe", "Brown", "Pool", new Integer(10), new Boolean(false) } };
		table = new JTable(data, columnNames);
		table.setFillsViewportHeight(true);
		panelTable.add(table.getTableHeader(), BorderLayout.PAGE_START);
		for (int i = 0; i < 5; i++) {

			table.getColumnModel().getColumn(i).setPreferredWidth(130);
			// table.getColumnModel().getColumn(i).setMinWidth(130);
			// table.getColumnModel().getColumn(i).setMaxWidth(135);
		}
		panelTable.add(table, BorderLayout.CENTER);
		panelTable.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(null, null), "�����б�"));
		panelButton = new JPanel(new GridLayout(7, 1, 10, 30));
		panelButton.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(null, null), "�����б�"));
		btn_search = new JButton("��ѯ");
		lb_uname = new JTextField("�������û���");
		btn_exit = new JButton("�˳�");
		cb_type = new JComboBox<String>(new String[] {"ָ���û����޼�¼","ȫ�����޼�¼"});
		lb_type = new JLabel("��ѯ����");
		panelButton.add(lb_type);
		panelButton.add(cb_type);
		panelButton.add(lb_uname);
		panelButton.add(btn_search);
		panelButton.add(new JPanel());
		panelButton.add(new JPanel());
		panelButton.add(btn_exit);
		
		this.getContentPane().add(panelTable, BorderLayout.CENTER);
		this.getContentPane().add(panelButton, BorderLayout.EAST);
		this.setVisible(true);
				
	}
	
}
