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
	private JTextField name_fld;
	private JTextField priority_fld;
	private JTextField work_field;
	private JTextField wait_fld;
	private JTextField work_fld;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					view_scheduler frame = new view_scheduler();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public view_scheduler() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		setTitle("Best GUI 1630");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		

		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 0, 1244, 670);
		contentPane.add(tabbedPane);
		
		JPanel scheduler = new JPanel();
		tabbedPane.addTab("Scheduler", null, scheduler, null);
		scheduler.setLayout(null);
		
		JLabel prozess_lbl = new JLabel("Prozesse :");
		prozess_lbl.setFont(new Font("Tahoma", Font.BOLD, 23));
		prozess_lbl.setBounds(10, 23, 172, 31);
		scheduler.add(prozess_lbl);
		
		JButton apl_btn = new JButton("Alle Prozesse löschen");
		apl_btn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		apl_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		apl_btn.setBounds(141, 23, 193, 31);
		scheduler.add(apl_btn);
		
		JButton hzf_btn = new JButton("Hinzufügen");
		hzf_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		hzf_btn.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		hzf_btn.setBounds(97, 600, 193, 31);
		scheduler.add(hzf_btn);
		
		JButton run_btn = new JButton("RUN!");
		
		run_btn.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		run_btn.setBounds(756, 600, 193, 31);
		scheduler.add(run_btn);
		
		JEditorPane scheduler_dpl = new JEditorPane();
		scheduler_dpl.setBounds(435, 81, 794, 508);
		scheduler.add(scheduler_dpl);
		scheduler_dpl.setEditable(false); // MUSS ZUSÄTZLICH IN DEN ACTION LISTENER :)
	
		
		
		name_fld = new JTextField();
		name_fld.setBounds(47, 138, 287, 43);
		scheduler.add(name_fld);
		name_fld.setColumns(10);
		
		priority_fld = new JTextField();
		priority_fld.setColumns(10);
		priority_fld.setBounds(47, 258, 287, 43);
		scheduler.add(priority_fld);
		
		work_fld = new JTextField();
		work_fld.setColumns(10);
		work_fld.setBounds(47, 378, 287, 43);
		scheduler.add(work_fld);
		
		wait_fld = new JTextField();
		wait_fld.setColumns(10);
		wait_fld.setBounds(47, 498, 287, 43);
		scheduler.add(wait_fld);
		
		JLabel name_lbl = new JLabel("Name :");
		name_lbl.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		name_lbl.setBounds(29, 98, 305, 29);
		scheduler.add(name_lbl);
		
		JLabel priority_lbl = new JLabel("Priorität : (Integer)");
		priority_lbl.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		priority_lbl.setBounds(29, 218, 305, 29);
		scheduler.add(priority_lbl);
		
		JLabel work_lbl = new JLabel("Rechenzeit : (x ; x...)");
		work_lbl.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		work_lbl.setBounds(29, 338, 305, 29);
		scheduler.add(work_lbl);
		
		JLabel wait_lbl = new JLabel("Wartezeit : (x ; x...)");
		wait_lbl.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		wait_lbl.setBounds(29, 458, 305, 29);
		scheduler.add(wait_lbl);
		
		JLabel scheduler_lbl = new JLabel("Scheduler :");
		scheduler_lbl.setFont(new Font("Tahoma", Font.BOLD, 23));
		scheduler_lbl.setBounds(874, 23, 172, 31);
		scheduler.add(scheduler_lbl);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"RoundRobin", "FirstComeFirstServe"}));
		comboBox.setBounds(1036, 23, 193, 31);
		scheduler.add(comboBox);
		
		
		JPanel prozesse = new JPanel();
		tabbedPane.addTab("Prozesse", null, prozesse, null);
		prozesse.setLayout(new CardLayout(0, 0));
		
		JEditorPane prozesse_dpl = new JEditorPane();
		prozesse.add(prozesse_dpl, "name_799714703522400");
		prozesse_dpl.setEditable(false); // MUSS ZUSÄTZLICH IN DEN ACTION LISTENER :)
	}
}