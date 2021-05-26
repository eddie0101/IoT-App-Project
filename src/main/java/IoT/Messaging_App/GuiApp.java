package IoT.Messaging_App;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPasswordField;


public class GuiApp {

	JFrame frame;
	static JTextField textField_Host;
	static JTextField textField_Port;
	static JTextField textField_ClientID;
	private JTextField textField_3;
	private JPasswordField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	static JPanel panel1;

	
	//public static void main(String[] args) {
		
	//}

	
	public GuiApp() {
		initialize();
	}

	
	void initialize() {
		frame = new JFrame("GUI");
		panel1= new JPanel();
		
		frame.setBounds(100, 100, 701, 525);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 2, 0, 0));

		
		panel1.setBorder(BorderFactory.createEmptyBorder(30,30, 10, 30));
		panel1.setLayout(new GridLayout(0,1));
		
		frame.getContentPane().add(panel1);
		
		JLabel lblNewLabel_1 = new JLabel("Host");
		panel1.add(lblNewLabel_1);
		
		textField_Host = new JTextField();
		panel1.add(textField_Host);
		textField_Host.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Port");
		panel1.add(lblNewLabel_2);
		
		textField_Port = new JTextField();
		panel1.add(textField_Port);
		textField_Port.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ClientID");
		panel1.add(lblNewLabel);
		
		textField_ClientID = new JTextField();
		panel1.add(textField_ClientID);
		textField_ClientID.setColumns(10);
	
		
		
		
		JLabel lblNewLabel_3 = new JLabel("Username");
		panel1.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		panel1.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Password");
		panel1.add(lblNewLabel_4);
		
		textField_4 = new JPasswordField();
		panel1.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Keep Alive");
		panel1.add(lblNewLabel_5);
		
		textField_5 = new JTextField();
		panel1.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Last-will Topic");
		panel1.add(lblNewLabel_6);
		
		textField_6 = new JTextField();
		panel1.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("QoS");
		
		panel1.add(lblNewLabel_7);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2"}));
		comboBox.setMaximumRowCount(3);
		comboBox.setToolTipText("1");
		panel1.add(comboBox);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Last-Will Retain");
		chckbxNewCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
		panel1.add(chckbxNewCheckBox);
		
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(30,30, 10, 30));
		panel.setLayout(new GridLayout(0,1));
		
		frame.getContentPane().add(panel);
		
		
		JLabel lblNewLabel_8_1 = new JLabel("Last-Will Message");
		lblNewLabel_8_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_8_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_1.setEnabled(false);
		panel.add(lblNewLabel_8_1);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setTabSize(10);
		textArea_1.setRows(5);
		panel.add(textArea_1);
	}
	
	

}