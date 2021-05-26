package IoT.Messaging_App;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;


public class App extends GuiApp
{

	static String topic        = "MQTT Examples";
    static String content      = "Message from NetBeans";
    static int qos             = 2;
    static String broker;//       = "tcp://127.0.0.1:1883";
    static String clientId;//     = "JavaSample2";
    
    static boolean connectState = false;
    
	public static void main(String[] args) throws InterruptedException {
        
        MemoryPersistence persistence = new MemoryPersistence();
        
        
        EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiApp window = new GuiApp();
					window.frame.setVisible(true);

			        JButton connect_button = new JButton("CONNECT");
					connect_button.addActionListener(new ActionListener() {

			            @Override
			            public void actionPerformed(ActionEvent e) {
			            	
			            	//Test username & password
			            	if(true) {
			            		
				            	try {
									Publish publish = new Publish();
									publish.frame.setVisible(true);
									String host = textField_Host.getText();
									String port = textField_Port.getText();
									broker = "tcp://" + host + ":" + port;
									clientId = textField_ClientID.getText();
									
									System.out.println("Host: " + host);
									System.out.println("Port: " + port);
									System.out.println("Broker: " + broker);
									System.out.println("ClientID: " + clientId);
									connectState = true;
									
								} catch (Exception e1) {
									e1.printStackTrace();
								}
			            	}
			            }

			        });
					
					
					panel1.add(connect_button);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

        
        
        while (true) {
        	if (connectState)
        		break;
        	Thread.sleep(500);
        }
        
        try {
        	
            @SuppressWarnings("resource")
			MqttClient sampleClient = new MqttClient(broker, clientId, persistence);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            System.out.println("Connecting to broker: "+broker);
            sampleClient.connect(connOpts);
            System.out.println("Connected");
            System.out.println("Publishing message: "+content);
            MqttMessage message = new MqttMessage(content.getBytes());
            message.setQos(qos);
            sampleClient.publish(topic, message);
            System.out.println("Message published");
            sampleClient.subscribe("MQTT Examples");
            System.out.println("Subscribed to MQTT Examples");
            sampleClient.subscribe("Topic_Test");
            System.out.println("Subscribed to Topic_Test");
            
            
            
            //sampleClient.messageArrivedComplete(qos, qos);
            
            sampleClient.setCallback(new MqttCallback() {
				
				@Override
				public void messageArrived(String topic, MqttMessage message) throws Exception {
					// TODO Auto-generated method stub
					System.out.println(message.toString());
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
            
            Thread.sleep(100000);
            
            
            sampleClient.disconnect();
            System.out.println("Disconnected");
            //System.exit(0);
        } catch(MqttException me) {
            System.out.println("reason "+me.getReasonCode());
            System.out.println("msg "+me.getMessage());
            System.out.println("loc "+me.getLocalizedMessage());
            System.out.println("cause "+me.getCause());
            System.out.println("excep "+me);
            me.printStackTrace();
        }
    }
}
