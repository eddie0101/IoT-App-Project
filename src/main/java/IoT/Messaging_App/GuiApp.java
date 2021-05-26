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
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.text.DefaultCaret;

import java.awt.TextArea;
import java.awt.Label;
import java.awt.Button;


public class GuiApp {

	JFrame frame;
	static JTextField textField_Host;
	static JTextField textField_Port;
	static JTextField textField_ClientID;
	private JTextField textField_3;
	private JPasswordField textField_4;
	static JPanel panel1;
	static JButton connectButton;
	static TextArea textArea;
	static JButton subscribeButton;
	static JButton publishButton;

	
	//public static void main(String[] args) {
		
	//}

	
	public GuiApp() {
		initialize();
	}

	
	void initialize() {
		frame = new JFrame("GUI");
		frame.setTitle("MyIRC");
		panel1= new JPanel();
		panel1.setBackground(Color.DARK_GRAY);
		
		frame.setBounds(100, 100, 701, 525);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 2, 0, 0));

		
		panel1.setBorder(BorderFactory.createEmptyBorder(30,30, 10, 30));
		
		frame.getContentPane().add(panel1);
		panel1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Host");
		lblNewLabel_1.setFont(new Font("Cambria", Font.BOLD, 12));
		lblNewLabel_1.setBounds(30, 10, 288, 26);
		lblNewLabel_1.setForeground(Color.LIGHT_GRAY);
		panel1.add(lblNewLabel_1);
		
		textField_Host = new JTextField();
		textField_Host.setFont(new Font("Courier New", Font.BOLD, 15));
		textField_Host.setForeground(Color.BLACK);
		textField_Host.setBounds(30, 36, 288, 26);
		textField_Host.setBackground(Color.GRAY);
		panel1.add(textField_Host);
		textField_Host.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Port");
		lblNewLabel_2.setFont(new Font("Cambria", Font.BOLD, 12));
		lblNewLabel_2.setBounds(30, 60, 288, 26);
		lblNewLabel_2.setForeground(Color.LIGHT_GRAY);
		panel1.add(lblNewLabel_2);
		
		textField_Port = new JTextField();
		textField_Port.setFont(new Font("Courier New", Font.BOLD, 15));
		textField_Port.setForeground(Color.BLACK);
		textField_Port.setBounds(30, 83, 288, 26);
		textField_Port.setBackground(Color.GRAY);
		panel1.add(textField_Port);
		textField_Port.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ClientID");
		lblNewLabel.setFont(new Font("Cambria", Font.BOLD, 12));
		lblNewLabel.setBounds(30, 107, 288, 26);
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		panel1.add(lblNewLabel);
		
		textField_ClientID = new JTextField();
		textField_ClientID.setFont(new Font("Courier New", Font.BOLD, 15));
		textField_ClientID.setForeground(Color.BLACK);
		textField_ClientID.setBounds(30, 132, 288, 26);
		textField_ClientID.setBackground(Color.GRAY);
		panel1.add(textField_ClientID);
		textField_ClientID.setColumns(10);
	
		
		
		
		JLabel lblNewLabel_3 = new JLabel("Username");
		lblNewLabel_3.setFont(new Font("Cambria", Font.BOLD, 12));
		lblNewLabel_3.setBounds(30, 156, 288, 26);
		lblNewLabel_3.setForeground(Color.LIGHT_GRAY);
		panel1.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Courier New", Font.BOLD, 15));
		textField_3.setForeground(Color.BLACK);
		textField_3.setBounds(30, 181, 288, 26);
		textField_3.setBackground(Color.GRAY);
		panel1.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Password");
		lblNewLabel_4.setFont(new Font("Cambria", Font.BOLD, 12));
		lblNewLabel_4.setBounds(30, 205, 288, 26);
		lblNewLabel_4.setForeground(Color.LIGHT_GRAY);
		panel1.add(lblNewLabel_4);
		
		textField_4 = new JPasswordField();
		textField_4.setFont(new Font("Courier New", Font.BOLD, 15));
		textField_4.setForeground(Color.BLACK);
		textField_4.setBounds(30, 230, 288, 26);
		textField_4.setBackground(Color.GRAY);
		panel1.add(textField_4);
		textField_4.setColumns(10);
		
		textArea = new TextArea("", 1, 20, TextArea.SCROLLBARS_NONE);
		//textArea.setCursorPosition(textArea.getValue().length());
		//textArea = new JTextArea("", 1, 20);
		//textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		textArea.setFont(new Font("Consolas", Font.BOLD, 12));
		textArea.setForeground(Color.BLACK);
		textArea.setBackground(Color.GRAY);
		textArea.setBounds(30, 306, 288, 161);
		panel1.add(textArea);
		//caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		
		Label label = new Label("Output");
		label.setFont(new Font("Cambria", Font.BOLD, 12));
		label.setForeground(Color.LIGHT_GRAY);
		label.setBounds(30, 274, 288, 26);
		panel1.add(label);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBorder(BorderFactory.createEmptyBorder(30,30, 10, 30));
		
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		connectButton = new JButton("connect");
		connectButton.setFont(new Font("Cambria", Font.BOLD, 15));
		connectButton.setBounds(102, 36, 132, 46);
		panel.add(connectButton);
		
		subscribeButton = new JButton("subscribe");
		subscribeButton.setEnabled(false);
		subscribeButton.setFont(new Font("Cambria", Font.BOLD, 15));
		subscribeButton.setBounds(102, 120, 132, 46);
		panel.add(subscribeButton);
		
		publishButton = new JButton("publish");
		publishButton.setEnabled(false);
		publishButton.setFont(new Font("Cambria", Font.BOLD, 15));
		publishButton.setBounds(102, 204, 132, 46);
		panel.add(publishButton);
	}
}
