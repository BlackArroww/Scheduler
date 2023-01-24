import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JEditorPane;
import javax.swing.JTextField;
import javax.swing.JList;
import java.awt.CardLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class view_scheduler extends JFrame {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JPanel scheduler;
	private JLabel prozess_lbl;
	private JButton apl_btn;
	private JButton hzf_btn;
	private JButton run_btn;
	private JEditorPane scheduler_dpl;
	private JTextField name_fld;
	private JTextField priority_fld;
	private JTextField work_fld;
	private JTextField wait_fld;
	private JLabel name_lbl;
	private JLabel priority_lbl;
	private JLabel work_lbl;
	private JLabel wait_lbl;
	private JLabel scheduler_lbl;
	private JComboBox comboBox;
	private JPanel prozesse;
	private JEditorPane prozesse_dpl;

	public view_scheduler() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		setTitle("Best GUI 1630");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		
		
		//Create Elements for GUI
		
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 0, 1244, 670);

		scheduler = new JPanel();
		scheduler.setLayout(null);
		tabbedPane.addTab("Scheduler", null, scheduler, null);

		prozess_lbl = new JLabel("Prozesse :");
		prozess_lbl.setBounds(10, 23, 172, 31);
		prozess_lbl.setFont(new Font("Tahoma", Font.BOLD, 23));

		apl_btn = new JButton("Alle Prozesse löschen");
		apl_btn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		apl_btn.setBounds(141, 23, 193, 31);

		hzf_btn = new JButton("Hinzufügen");
		hzf_btn.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		hzf_btn.setBounds(97, 600, 193, 31);

		run_btn = new JButton("RUN!");
		run_btn.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		run_btn.setBounds(756, 600, 193, 31);

		JEditorPane scheduler_dpl = new JEditorPane();
		scheduler_dpl.setBounds(435, 81, 794, 508);
		scheduler_dpl.setEditable(false);

		name_fld = new JTextField();
		name_fld.setBounds(47, 138, 287, 43);
		name_fld.setColumns(10);

		priority_fld = new JTextField();
		priority_fld.setColumns(10);
		priority_fld.setBounds(47, 258, 287, 43);

		work_fld = new JTextField();
		work_fld.setColumns(10);
		work_fld.setBounds(47, 378, 287, 43);
		
		wait_fld = new JTextField();
		wait_fld.setColumns(10);
		wait_fld.setBounds(47, 498, 287, 43);

		name_lbl = new JLabel("Name :");
		name_lbl.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		name_lbl.setBounds(29, 98, 305, 29);

		priority_lbl = new JLabel("Priorität : (Integer)");
		priority_lbl.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		priority_lbl.setBounds(29, 218, 305, 29);

		work_lbl = new JLabel("Rechenzeit : (x ; x...)");
		work_lbl.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		work_lbl.setBounds(29, 338, 305, 29);

		wait_lbl = new JLabel("Wartezeit : (x ; x...)");
		wait_lbl.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		wait_lbl.setBounds(29, 458, 305, 29);

		scheduler_lbl = new JLabel("Scheduler :");
		scheduler_lbl.setFont(new Font("Tahoma", Font.BOLD, 23));
		scheduler_lbl.setBounds(874, 23, 172, 31);

		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setBounds(1036, 23, 193, 31);


		prozesse = new JPanel();
		prozesse.setLayout(new CardLayout(0, 0));

		prozesse_dpl = new JEditorPane();
		prozesse_dpl.setEditable(false);
		
		
		//Add Element to GUI 
		
		contentPane.add(tabbedPane);
		tabbedPane.addTab("Scheduler", null, scheduler, null);
		scheduler.add(prozess_lbl);
		scheduler.add(apl_btn);
		scheduler.add(hzf_btn);
		scheduler.add(run_btn);
		scheduler.add(scheduler_dpl);
		scheduler.add(name_fld);
		scheduler.add(priority_fld);
		scheduler.add(work_fld);
		scheduler.add(wait_fld);	
		scheduler.add(name_lbl);
		scheduler.add(priority_lbl);		
		scheduler.add(work_lbl);		
		scheduler.add(wait_lbl);		
		scheduler.add(scheduler_lbl);		
		scheduler.add(comboBox);		
		tabbedPane.addTab("Prozesse", null, prozesse, null);
		prozesse.add(prozesse_dpl);
	
		
		
	}
}