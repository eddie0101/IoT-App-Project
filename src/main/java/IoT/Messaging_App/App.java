package IoT.Messaging_App;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
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

    static String broker;	      // = "tcp://127.0.0.1:1883";
    static String clientId;
    
    static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("(HH:mm:ss - dd/MM/yyyy)");
    
    static boolean connectState = false;
    
    
	public static void main(String[] args) throws InterruptedException {
        
        MemoryPersistence persistence = new MemoryPersistence();
        
		Publish pubWindow = new Publish();
		Subscribe subWindow = new Subscribe();
        
        EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiApp appWindow = new GuiApp();
					appWindow.frame.setVisible(true);
					
					connectButton.addActionListener(new ActionListener() {
	
			            @Override
			            public void actionPerformed(ActionEvent e) {
			            	
			            	if(true) {
			            		
				            	try {
	
									String host = textField_Host.getText();
									String port = textField_Port.getText();
									broker = "tcp://" + host + ":" + port;
									clientId = textField_ClientID.getText();
									
									System.out.println("Host: " + host);			//printOutputText("Host: " + host);
									System.out.println("Port: " + port);			//printOutputText("Port: " + port);
									System.out.println("Broker: " + broker); 		//printOutputText("Broker: " + broker);
									System.out.println("ClientID: " + clientId); 	//printOutputText("ClientID: " + clientId);
									connectState = true;
									
									subscribeButton.setEnabled(true);
									publishButton.setEnabled(true);
									

									subscribeButton.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											subWindow.frameSub.setVisible(true);
											subWindow.frameSub.setTitle("Subscribe (" + clientId + ")");
											
										}
									});
									
									publishButton.addActionListener(new ActionListener() {
										
										@Override
										public void actionPerformed(ActionEvent e) {
											pubWindow.framePub.setVisible(true);
											pubWindow.framePub.setTitle("Publish (" + clientId + ")");
											
										}
									});
								
									
									
									
								} catch (Exception e1) {
									e1.printStackTrace();
								}
			            	}
			            }
	
			        });
					
					
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
            printOutputText("Connecting to broker: " + broker);
            client.connect(connOpts);
            Thread.sleep(500);
            printOutputText("Connected");
            
            
    
    		pubWindow.publishBtnPressed(client);
            
            subWindow.subscribeBtnPressed(client);
            
            
            Thread.sleep(1000000);
            
            
            client.disconnect();
            System.out.println("Disconnected");
            
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
