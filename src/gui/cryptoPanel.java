package gui;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class cryptoPanel {
	JPanel panel = new JPanel();
	public JPanel getPanel() {
		panel.setLayout(null);
		String CBmenu_1[] = {"AES", "RSA", "SHA-256"};
		
		JComboBox<String> toCrypto = new JComboBox<String>(CBmenu_1);
		JButton crypto = new JButton("암호화");
		crypto.setBackground(Color.WHITE);
		
		JLabel toCrypto_LB = new JLabel("암호 종류 : ");
		JLabel fileName_LB = new JLabel("파일 이름 : ");
		JLabel content_LB = new JLabel("내용");
		
		JTextArea content = new JTextArea(15, 40);
		JTextField fileName = new JTextField(10);
		
		content.setBorder(new LineBorder(Color.BLACK, 1));
		
		toCrypto_LB.setSize(60, 20);	toCrypto.setSize(160, 20);
		fileName_LB.setSize(60, 20);	fileName.setSize(160, 20);
		content_LB.setSize(60, 20);		content.setSize(510, 200);
		crypto.setSize(510, 60);
		
		toCrypto_LB.setLocation(10, 10);	toCrypto.setLocation(80, 10);
		fileName_LB.setLocation(290, 10);	fileName.setLocation(360, 10);
		content_LB.setLocation(10, 40);		content.setLocation(10, 60);
		crypto.setLocation(10, 265);
		
		panel.add(toCrypto_LB);		panel.add(toCrypto);
		panel.add(fileName_LB);		panel.add(content_LB);
		panel.add(crypto);			panel.add(fileName);
		panel.add(content);
		
		return panel;
	}
	
}
