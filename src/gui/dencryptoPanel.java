package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import file.ReadFile;

public class dencryptoPanel {
	String CBmenu_1[] = {"AES", "RSA", "SHA-256"};
	JPanel panel = new JPanel();
	JButton decrypto = new JButton("복호화");
	JTextArea content = new JTextArea(15, 40);
	JTextField fileName = new JTextField(10);
	JTextField keyValue = new JTextField(10);
	JComboBox<String> toEncrypto = new JComboBox<String>(CBmenu_1);
	
	public JPanel getPanel() {
		JLabel toDecrypto_LB = 	new JLabel("암호 종류 : ");
		JLabel fileName_LB = 	new JLabel("파일 이름 : ");
		JLabel key_LB = 		new JLabel("키         값 : ");
		JLabel content_LB = 	new JLabel("내용");
		
		panel.setLayout(null);
		decrypto.setBackground(Color.WHITE);
		decrypto.addActionListener(new ActionClass());
		content.setEnabled(false);
		content.setFont(new Font("맑은고딕",Font.BOLD, 15));
		content.setBackground(Color.BLACK);
		JScrollPane scrollPane = new JScrollPane(content);
		
		toDecrypto_LB.setSize(67, 20);	toEncrypto.setSize(160, 20);
		fileName_LB.setSize(70, 20);	fileName.setSize(160, 20);
		key_LB.setSize(70, 20);			keyValue.setSize(160, 20);
		content_LB.setSize(60, 20);		scrollPane.setSize(510, 200);
		decrypto.setSize(510, 60);
		
		toDecrypto_LB.setLocation(10, 10);	toEncrypto.setLocation(80, 10);
		fileName_LB.setLocation(290, 10);	fileName.setLocation(360, 10);
		key_LB.setLocation(290, 35);		keyValue.setLocation(360, 35);
		content_LB.setLocation(10, 40);		scrollPane.setLocation(10, 60);
		decrypto.setLocation(10, 265);
		
		panel.add(toDecrypto_LB);		panel.add(toEncrypto);
		panel.add(fileName_LB);			panel.add(content_LB);
		panel.add(key_LB);				panel.add(keyValue);
		panel.add(decrypto);			panel.add(fileName);
		panel.add(scrollPane);
		
		return panel;
	}
	class ActionClass implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent ae) {
			// TODO Auto-generated method stub
			if(toEncrypto.getSelectedItem().toString().equals("AES")) {
				if(ae.getSource().equals(decrypto)) {
					try {
						String plainText = new ReadFile(fileName.getText()).fileRead(1);
						content.setText(plainText);
						fileName.setText("");
						keyValue.setText("");
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			}

			if(toEncrypto.getSelectedItem().toString().equals("RSA")) {
				if(ae.getSource().equals(decrypto)) {
					try {
						String plainText = new ReadFile(fileName.getText()).fileRead(2);
						content.setText(plainText);
						fileName.setText("");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			if(toEncrypto.getSelectedItem().toString().equals("SHA-256")) {
				content.setText("SHA-256");
			}

			
		}
		
	}
}
