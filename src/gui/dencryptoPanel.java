package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class dencryptoPanel {
	JPanel panel = new JPanel();
	JButton decrypto = new JButton("복호화");
	JLabel toDecrypto_LB = new JLabel("암호 종류 : ");
	JLabel fileName_LB = new JLabel("파일 이름 : ");
	JLabel content_LB = new JLabel("내용");
	
	JTextArea content = new JTextArea(15, 40);
	JTextField fileName = new JTextField(10);
	public JPanel getPanel() {
		panel.setLayout(null);
		String CBmenu_1[] = {"AES", "RSA", "SHA-256"};
		JComboBox<String> toEncrypto = new JComboBox<String>(CBmenu_1);
		decrypto.setBackground(Color.WHITE);
		decrypto.addActionListener(new ActionClass());
		content.setBorder(new LineBorder(Color.BLACK, 1));
		
		toDecrypto_LB.setSize(67, 20);	toEncrypto.setSize(160, 20);
		fileName_LB.setSize(70, 20);	fileName.setSize(160, 20);
		content_LB.setSize(60, 20);		content.setSize(510, 200);
		decrypto.setSize(510, 60);
		
		toDecrypto_LB.setLocation(10, 10);	toEncrypto.setLocation(80, 10);
		fileName_LB.setLocation(290, 10);	fileName.setLocation(360, 10);
		content_LB.setLocation(10, 40);		content.setLocation(10, 60);
		decrypto.setLocation(10, 265);
		
		panel.add(toDecrypto_LB);		panel.add(toEncrypto);
		panel.add(fileName_LB);			panel.add(content_LB);
		panel.add(decrypto);			panel.add(fileName);
		panel.add(content);
		
		return panel;
	}
	class ActionClass implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent ae) {
			// TODO Auto-generated method stub
			if(ae.getSource().equals(decrypto)) {
				System.out.println(content.getText());
			}
		}
		
	}
}
