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

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.awt.Font;
import javax.swing.DropMode;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

public class Publish {

	JFrame framePub;
	JButton pubBtn;
	JTextPane textPane;
	private JLabel topicLabel;
	private JTextField topicTextField;
	private JLabel messageLabel;
	
	
	public Publish() {
		initialize();
	}
	
//	private void printOutputText(String textLine) {  // printing inside "Output" area
//    	allOutputText =  allOutputText + textLine + '\n';
//    	textArea.setText(allOutputText);
//  }
	
	public void publishBtnPressed(MqttClient clientParameter) {
		
		pubBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String topicText = topicTextField.getText();
				MqttMessage message = new MqttMessage((clientParameter.getClientId() + ": " + textPane.getText()).getBytes());
				try {
					clientParameter.publish(topicText, message);
					GuiApp.printOutputText("Message published " + App.dtf.format(LocalDateTime.now()));
				} catch (MqttException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}

	
	private void initialize() {
		framePub = new JFrame("Publish");
		framePub.setBackground(Color.DARK_GRAY);
		JPanel panelPublish=new JPanel();
		panelPublish.setBackground(Color.DARK_GRAY);
		framePub.setBounds(100, 100, 350, 300);
		framePub.setResizable(false);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framePub.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		panelPublish.setBorder(BorderFactory.createEmptyBorder(30,30, 10, 30));
		framePub.getContentPane().add(panelPublish);
		
		panelPublish.setBorder(BorderFactory.createEmptyBorder(30,30, 10, 30));
		panelPublish.setLayout(null);
		//panelPublish.setLayout(null);
		
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
		
		textPane = new JTextPane();
		textPane.setFont(new Font("Courier New", Font.BOLD, 15));
		textPane.setBackground(Color.GRAY);
		textPane.setBounds(49, 116, 252, 69);
		panelPublish.add(textPane);
		
		pubBtn = new JButton("publish");
		pubBtn.setFont(new Font("Cambria", Font.BOLD, 15));
		pubBtn.setBounds(49, 199, 252, 40);
		panelPublish.add(pubBtn);
	}
}
