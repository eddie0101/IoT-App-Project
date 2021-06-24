package IoT.Messaging_App;

import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.awt.Font;
import javax.swing.DropMode;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.awt.event.ActionEvent;
import java.awt.TextArea;

public class Subscribe {

	JFrame frameSub;
	TextArea textArea;
	private JButton subscribeButton;
	private JLabel topicLabel;
	private JTextField topicTextField;
	private JLabel messageLabel;
	private String allTextMessages = "";
	
	public Subscribe() {
		initialize();
	}

	private void printTextMessage(String textLine) { //printing inside "Recived messages" area
    	allTextMessages =  allTextMessages + textLine + '\n';
    	textArea.setText(allTextMessages);
    }
	
	public void subscribeBtnPressed(MqttClient client) {

		subscribeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				printTextMessage("Subscribed to topic " + topicTextField.getText() + ". Listening for messages...");
				
				try {
					client.subscribe(topicTextField.getText());
				} catch (MqttException e1) {
					e1.printStackTrace();
				}
				
				client.setCallback(new MqttCallback() {
					
					@Override
					public void messageArrived(String topic, MqttMessage message) throws Exception {
						printTextMessage(message.toString());
					}
					
					@Override
					public void deliveryComplete(IMqttDeliveryToken token) {
						
					}
					
					@Override
					public void connectionLost(Throwable cause) {
						
					}
				});
			}
		});

	}
	
	private void initialize() {
		frameSub = new JFrame("Subscribe");
		frameSub.setBackground(Color.DARK_GRAY);
		JPanel panelSubscribe=new JPanel();
		panelSubscribe.setBackground(Color.DARK_GRAY);
		frameSub.setBounds(100, 100, 350, 300);
		frameSub.setResizable(false);
		frameSub.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		panelSubscribe.setBorder(BorderFactory.createEmptyBorder(30,30, 10, 30));
		frameSub.getContentPane().add(panelSubscribe);
		
		panelSubscribe.setBorder(BorderFactory.createEmptyBorder(30,30, 10, 30));
		panelSubscribe.setLayout(null);
		
		topicLabel = new JLabel("Topic");
		topicLabel.setBounds(49, 10, 252, 19);
		topicLabel.setForeground(Color.LIGHT_GRAY);
		topicLabel.setFont(new Font("Cambria", Font.BOLD, 15));
		panelSubscribe.add(topicLabel);
		
		topicTextField = new JTextField();
		topicTextField.setBounds(49, 39, 252, 28);
		topicTextField.setBackground(Color.GRAY);
		topicTextField.setForeground(Color.BLACK);
		topicTextField.setFont(new Font("Courier New", Font.BOLD, 15));
		panelSubscribe.add(topicTextField);
		topicTextField.setColumns(10);
		
		messageLabel = new JLabel("Received messages");
		messageLabel.setBounds(49, 137, 252, 19);
		messageLabel.setFont(new Font("Cambria", Font.BOLD, 15));
		messageLabel.setForeground(Color.LIGHT_GRAY);
		panelSubscribe.add(messageLabel);
		
		subscribeButton = new JButton("subscribe");
		subscribeButton.setBounds(49, 77, 252, 40);
		subscribeButton.setFont(new Font("Cambria", Font.BOLD, 15));
		panelSubscribe.add(subscribeButton);
		
		textArea = new TextArea("", 1, 20, TextArea.SCROLLBARS_NONE);
		textArea.setEditable(false);
		textArea.setFont(new Font("Courier New", Font.BOLD, 12));
		textArea.setBackground(Color.GRAY);
		textArea.setBounds(49, 162, 252, 87);
		panelSubscribe.add(textArea);
	}
}
