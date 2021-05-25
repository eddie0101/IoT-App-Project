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

public class Publish {

	JFrame frame;
	private JTextField textField;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Publish window = new Publish();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Publish() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame("Publish");
		JPanel panel2=new JPanel();
		frame.setBounds(100, 100, 350, 300);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		panel2.setBorder(BorderFactory.createEmptyBorder(30,30, 10, 30));
		panel2.setLayout(new GridLayout(0,1));
		frame.getContentPane().add(panel2);
		
		
		JLabel lblNewLabel = new JLabel("Topic");
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("QoS");
		frame.getContentPane().add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2"}));

		frame.getContentPane().add(comboBox);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Retain");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_2);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		panel_1.add(chckbxNewCheckBox);
		chckbxNewCheckBox.setSelected(true);
		
		JButton btnNewButton = new JButton("Publish");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblMessage = new JLabel("Message");
		lblMessage.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMessage.setHorizontalAlignment(SwingConstants.LEFT);
		frame.getContentPane().add(lblMessage);
		
		JTextArea textArea = new JTextArea();
		textArea.setRows(10);
		frame.getContentPane().add(textArea);
		
		panel2.setBorder(BorderFactory.createEmptyBorder(30,30, 10, 30));
		panel2.setLayout(new GridLayout(0,1));
	}

}
