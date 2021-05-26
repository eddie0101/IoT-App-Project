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

public class Publish {

	JFrame frame;
	private JLabel topicLabel;
	private JTextField topicTextField;
	private JLabel messageLabel;
	
	public Publish() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame("Publish");
		frame.setBackground(Color.DARK_GRAY);
		JPanel panelPublish=new JPanel();
		panelPublish.setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 350, 300);
		frame.setResizable(false);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		panelPublish.setBorder(BorderFactory.createEmptyBorder(30,30, 10, 30));
		frame.getContentPane().add(panelPublish);
		
		panelPublish.setBorder(BorderFactory.createEmptyBorder(30,30, 10, 30));
		panelPublish.setLayout(null);
		panelPublish.setLayout(null);
		
		topicLabel = new JLabel("Topic");
		topicLabel.setForeground(Color.LIGHT_GRAY);
		topicLabel.setFont(new Font("Cambria", Font.BOLD, 15));
		topicLabel.setBounds(49, 10, 252, 19);
		panelPublish.add(topicLabel);
		
		topicTextField = new JTextField();
		topicTextField.setBackground(Color.GRAY);
		topicTextField.setForeground(Color.BLACK);
		topicTextField.setFont(new Font("Courier New", Font.BOLD, 15));
		topicTextField.setBounds(49, 39, 252, 28);
		panelPublish.add(topicTextField);
		topicTextField.setColumns(10);
		
		messageLabel = new JLabel("Message");
		messageLabel.setFont(new Font("Cambria", Font.BOLD, 15));
		messageLabel.setForeground(Color.LIGHT_GRAY);
		messageLabel.setBounds(49, 87, 252, 19);
		panelPublish.add(messageLabel);
		
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("Courier New", Font.BOLD, 15));
		textPane.setBackground(Color.GRAY);
		textPane.setBounds(49, 116, 252, 69);
		panelPublish.add(textPane);
		
		JButton publishButton = new JButton("publish");
		publishButton.setFont(new Font("Cambria", Font.BOLD, 15));
		publishButton.setBounds(49, 199, 252, 40);
		panelPublish.add(publishButton);
	}
}
