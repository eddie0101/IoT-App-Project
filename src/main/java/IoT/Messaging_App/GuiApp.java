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


public class GuiApp{

	JFrame frame;
	static JTextField textField_Host;
	static JTextField textField_Port;
	static JTextField textField_ClientID;
	static JPanel panel1;
	static JButton connectButton;
	static TextArea textArea;
	static JButton subscribeButton;
	static JButton publishButton;
	static String allOutputText = "";
	
	public GuiApp() {
		initialize();
	}

	public static void printOutputText(String textLine) {  // printing inside "Output" area
    	allOutputText =  allOutputText + textLine + '\n';
    	textArea.setText(allOutputText);
    }
	
	void initialize() {
		frame = new JFrame("GUI");
		frame.setBackground(Color.DARK_GRAY);
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setTitle("MyIRC");
		panel1= new JPanel();
		panel1.setBackground(Color.DARK_GRAY);
		
		frame.setBounds(100, 100, 701, 525);
		frame.setSize(750, 400);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 2, 0, 0));

		
		panel1.setBorder(BorderFactory.createEmptyBorder(30,30, 10, 30));
		
		frame.getContentPane().add(panel1);
		panel1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Host");
		lblNewLabel_1.setFont(new Font("Cambria", Font.BOLD, 12));
		lblNewLabel_1.setBounds(30, 29, 288, 26);
		lblNewLabel_1.setForeground(Color.LIGHT_GRAY);
		panel1.add(lblNewLabel_1);
		
		textField_Host = new JTextField();
		textField_Host.setFont(new Font("Courier New", Font.BOLD, 15));
		textField_Host.setForeground(Color.BLACK);
		textField_Host.setBounds(30, 57, 288, 26);
		textField_Host.setBackground(Color.GRAY);
		panel1.add(textField_Host);
		textField_Host.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Port");
		lblNewLabel_2.setFont(new Font("Cambria", Font.BOLD, 12));
		lblNewLabel_2.setBounds(30, 93, 288, 26);
		lblNewLabel_2.setForeground(Color.LIGHT_GRAY);
		panel1.add(lblNewLabel_2);
		
		textField_Port = new JTextField();
		textField_Port.setFont(new Font("Courier New", Font.BOLD, 15));
		textField_Port.setForeground(Color.BLACK);
		textField_Port.setBounds(30, 124, 288, 26);
		textField_Port.setBackground(Color.GRAY);
		panel1.add(textField_Port);
		textField_Port.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ClientID");
		lblNewLabel.setFont(new Font("Cambria", Font.BOLD, 12));
		lblNewLabel.setBounds(30, 160, 288, 26);
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		panel1.add(lblNewLabel);
		
		textField_ClientID = new JTextField();
		textField_ClientID.setFont(new Font("Courier New", Font.BOLD, 15));
		textField_ClientID.setForeground(Color.BLACK);
		textField_ClientID.setBounds(30, 191, 288, 26);
		textField_ClientID.setBackground(Color.GRAY);
		panel1.add(textField_ClientID);
		textField_ClientID.setColumns(10);
		
		connectButton = new JButton("connect");
		connectButton.setBounds(106, 270, 132, 46);
		panel1.add(connectButton);
		connectButton.setFont(new Font("Cambria", Font.BOLD, 15));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBorder(BorderFactory.createEmptyBorder(30,30, 10, 30));
		
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		subscribeButton = new JButton("subscribe");
		subscribeButton.setEnabled(false);
		subscribeButton.setFont(new Font("Cambria", Font.BOLD, 15));
		subscribeButton.setBounds(42, 36, 132, 46);
		panel.add(subscribeButton);
		
		publishButton = new JButton("publish");
		publishButton.setEnabled(false);
		publishButton.setFont(new Font("Cambria", Font.BOLD, 15));
		publishButton.setBounds(196, 36, 132, 46);
		panel.add(publishButton);
		
		textArea = new TextArea("", 1, 20, TextArea.SCROLLBARS_NONE);
		textArea.setBounds(40, 142, 288, 192);
		panel.add(textArea);
		textArea.setEditable(false);
		textArea.setFont(new Font("Consolas", Font.BOLD, 12));
		textArea.setForeground(Color.BLACK);
		textArea.setBackground(Color.GRAY);
		
		Label label = new Label("Output");
		label.setBounds(40, 110, 288, 26);
		panel.add(label);
		label.setFont(new Font("Cambria", Font.BOLD, 12));
		label.setForeground(Color.LIGHT_GRAY);
	}
}
