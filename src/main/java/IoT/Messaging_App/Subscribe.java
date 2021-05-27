package IoT.Messaging_App;

import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.DropMode;
import java.awt.Color;
import javax.swing.JTextPane;

public class Subscribe {

	JFrame frameSub;
	private JLabel topicLabel;
	private JTextField topicTextField;
	private JLabel messageLabel;
	
	public Subscribe() {
		initialize();
	}

	
	private void initialize() {
		frameSub = new JFrame("Publish");
		frameSub.setTitle("Subscribe");
		frameSub.setBackground(Color.DARK_GRAY);
		JPanel panelSubscribe=new JPanel();
		panelSubscribe.setBackground(Color.DARK_GRAY);
		frameSub.setBounds(100, 100, 350, 300);
		frameSub.setResizable(false);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameSub.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		panelSubscribe.setBorder(BorderFactory.createEmptyBorder(30,30, 10, 30));
		frameSub.getContentPane().add(panelSubscribe);
		
		panelSubscribe.setBorder(BorderFactory.createEmptyBorder(30,30, 10, 30));
		panelSubscribe.setLayout(null);
		//panelSubscribe.setLayout(null);
		
		topicLabel = new JLabel("Topic");
		topicLabel.setForeground(Color.LIGHT_GRAY);
		topicLabel.setFont(new Font("Cambria", Font.BOLD, 15));
		topicLabel.setBounds(49, 10, 252, 19);
		panelSubscribe.add(topicLabel);
		
		topicTextField = new JTextField();
		topicTextField.setBackground(Color.GRAY);
		topicTextField.setForeground(Color.BLACK);
		topicTextField.setFont(new Font("Courier New", Font.BOLD, 15));
		topicTextField.setBounds(49, 39, 252, 28);
		panelSubscribe.add(topicTextField);
		topicTextField.setColumns(10);
		
		messageLabel = new JLabel("Received messages");
		messageLabel.setFont(new Font("Cambria", Font.BOLD, 15));
		messageLabel.setForeground(Color.LIGHT_GRAY);
		messageLabel.setBounds(49, 87, 252, 19);
		panelSubscribe.add(messageLabel);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setFont(new Font("Courier New", Font.BOLD, 15));
		textPane.setBackground(Color.GRAY);
		textPane.setBounds(49, 116, 252, 69);
		panelSubscribe.add(textPane);
		
		JButton subscribeButton = new JButton("subscribe");
		subscribeButton.setFont(new Font("Cambria", Font.BOLD, 15));
		subscribeButton.setBounds(49, 199, 252, 40);
		panelSubscribe.add(subscribeButton);
	}
}
