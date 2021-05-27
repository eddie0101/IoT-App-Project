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
import java.awt.event.ActionEvent;

public class Subscribe {

	JFrame frameSub;
	JTextPane textPane;
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
    	textPane.setText(allTextMessages);
    }
	
	public void subscribeBtnPressed(MqttClient clientParameter) {

		subscribeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					clientParameter.subscribe(topicTextField.getText());
				} catch (MqttException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				clientParameter.setCallback(new MqttCallback() {
					
					@Override
					public void messageArrived(String topic, MqttMessage message) throws Exception {
						// TODO Auto-generated method stub
						printTextMessage(message.toString());
					}
					
					@Override
					public void deliveryComplete(IMqttDeliveryToken token) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void connectionLost(Throwable cause) {
						// TODO Auto-generated method stub
						
					}
				});
			}
		});
			
		
//		client.setCallback(new MqttCallback() {
//			
//			@Override
//			public void messageArrived(String topic, MqttMessage message) throws Exception {
//				// TODO Auto-generated method stub
//				System.out.println("topic -> " + topic);
//				printTextMessage(message.toString());
//			}
//			
//			@Override
//			public void deliveryComplete(IMqttDeliveryToken token) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void connectionLost(Throwable cause) {
//				// TODO Auto-generated method stub
//				
//			}
//		});
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
		
		textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setFont(new Font("Courier New", Font.BOLD, 15));
		textPane.setBackground(Color.GRAY);
		textPane.setBounds(49, 116, 252, 69);
		panelSubscribe.add(textPane);
		
		subscribeButton = new JButton("subscribe");
		subscribeButton.setFont(new Font("Cambria", Font.BOLD, 15));
		subscribeButton.setBounds(49, 199, 252, 40);
		panelSubscribe.add(subscribeButton);
	}
}
