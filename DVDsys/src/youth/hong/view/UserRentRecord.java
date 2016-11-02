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

public class UserRentRecord extends JInternalFrame {
		
	private static final long serialVersionUID = 1L;

	private JPanel panelTable = null;//��������Jtable�����
	
	private JTable table = null;
	
	private JPanel panelButton = null;
	
	private JButton btn_search = null;
	
	private JButton btn_rent = null;
	
	private JButton btn_exit = null;
	
	private JComboBox<String> cb_type = null;
	
	private JLabel lb_type = null;
	
	public UserRentRecord() {
		super();
		init();
	}
	
	private void init() {
		this.setTitle("DVD������Ϣ��ѯ");
		this.setSize(800, 500);
		this.setClosable(true);
		this.setIconifiable(true);
		this.setDefaultCloseOperation(UserRentRecord.DISPOSE_ON_CLOSE);
		panelTable = new JPanel();
		table = new JTable();
		panelTable.add(table);
		panelTable.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(null, null), "�����б�"));
		panelButton = new JPanel(new GridLayout(7, 1, 10, 30));
		panelButton.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(null, null), "�����б�"));
		btn_search = new JButton("��ѯ");
		btn_rent = new JButton("��DVD");
		btn_exit = new JButton("�˳�");
		cb_type = new JComboBox<String>(new String[] {"ȫ�����޼�¼", "�ɽ�DVD", "�ѽ�DVD", "����DVD"});
		lb_type = new JLabel("��ѯ����");
		panelButton.add(lb_type);
		panelButton.add(cb_type);
		panelButton.add(btn_search);
		btn_rent.setEnabled(false);//Ĭ����谴ť������
		panelButton.add(btn_rent);
		panelButton.add(new JPanel());
		panelButton.add(new JPanel());
		panelButton.add(btn_exit);
		
		this.getContentPane().add(panelTable, BorderLayout.CENTER);
		this.getContentPane().add(panelButton, BorderLayout.EAST);
		this.setVisible(true);
				
	}
	
}
