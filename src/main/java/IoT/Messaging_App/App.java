package IoT.Messaging_App;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComponent;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;


public class App extends GuiApp
{

	//static String topic        = "MQTT Examples";
    static String content      = "Message from NetBeans";
    static int qos             = 2;
    static String broker;//       = "tcp://127.0.0.1:1883";
    static String clientId;//     = "JavaSample2";
    
    static boolean connectState = false;
    static String allOutputText = "";
    
    static void printOutputText(String textLine) {  // printing inside "Output" area
    	allOutputText =  allOutputText + textLine + '\n';
    	textArea.setText(allOutputText);
    }
    
	public static void main(String[] args) throws InterruptedException {
        
        MemoryPersistence persistence = new MemoryPersistence();
        
		Publish pubWindow = new Publish();
		Subscribe subWindow = new Subscribe();
        
        EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiApp appWindow = new GuiApp();
					appWindow.frame.setVisible(true);
					
					//publishWindow.frame.setVisible(true);

			        //JButton connect_button = new JButton("CONNECT");
					connectButton.addActionListener(new ActionListener() {

			            @Override
			            public void actionPerformed(ActionEvent e) {
			            	
			            	//Test username & password
			            	if(true) {
			            		
				            	try {
									//Publish publish = new Publish();
									//publish.frame.setVisible(true);
									
									
									subscribeButton.setEnabled(true);
									publishButton.setEnabled(true);
									

									subscribeButton.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											subWindow.frameSub.setVisible(true);
											
										}
									});
									
									publishButton.addActionListener(new ActionListener() {
										
										@Override
										public void actionPerformed(ActionEvent e) {
											pubWindow.framePub.setVisible(true);
											
										}
									});
								
									
									
									String host = textField_Host.getText();
									String port = textField_Port.getText();
									broker = "tcp://" + host + ":" + port;
									clientId = textField_ClientID.getText();
									
									System.out.println("Host: " + host);			printOutputText("Host: " + host);
									System.out.println("Port: " + port);			printOutputText("Port: " + port);
									System.out.println("Broker: " + broker); 		printOutputText("Broker: " + broker);
									System.out.println("ClientID: " + clientId); 	printOutputText("ClientID: " + clientId);
									connectState = true;
									
								} catch (Exception e1) {
									e1.printStackTrace();
								}
			            	}
			            }

			        });
					
					
					//panel1.add(connect_button);
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
			MqttClient client = new MqttClient(broker, clientId, persistence);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            System.out.println("Connecting to broker: " + broker);				printOutputText("Connecting to broker: "+broker);
            client.connect(connOpts);
            System.out.println("Connected");									printOutputText("Connected");
            
            

    		pubWindow.publishBtnPressed(client);
    		
            
            System.out.println("Publishing message: " + content);				printOutputText("Publishing message: " + content);
            MqttMessage message = new MqttMessage(content.getBytes());
            message.setQos(qos);
            //client.publish(topic, message);
            System.out.println("Message published");							printOutputText("Message published");
            
            
            subWindow.subscribeBtnPressed(client);
            
            
            //client.subscribe("MQTT Examples");									
            //System.out.println("Subscribed to MQTT Examples");					printOutputText("Subscribed to MQTT Examples");
            //client.subscribe("Topic_Test");										
            //System.out.println("Subscribed to Topic_Test");						printOutputText("Subscribed to Topic_Test");
            
            
            
            
//            client.setCallback(new MqttCallback() {
//				
//				@Override
//				public void messageArrived(String topic, MqttMessage message) throws Exception {
//					// TODO Auto-generated method stub
//					System.out.println(message.toString());
//				}
//				
//				@Override
//				public void deliveryComplete(IMqttDeliveryToken token) {
//					// TODO Auto-generated method stub
//					
//				}
//				
//				@Override
//				public void connectionLost(Throwable cause) {
//					// TODO Auto-generated method stub
//					
//				}
//			});
            
            Thread.sleep(1000000);
            
            
            client.disconnect();
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
