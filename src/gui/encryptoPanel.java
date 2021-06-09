package gui;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class encryptoPanel {
	JPanel panel = new JPanel();
	GridBagLayout gBag;
	public JPanel getPanel() {

		JLabel lbReceive = new JLabel("받는 사람:", Label.RIGHT);
		JLabel lbContent = new JLabel("내 용:", Label.RIGHT);
		JLabel lbFile = new JLabel("첨부 파일:", Label.RIGHT);

		JButton btnSearch = new JButton("찾아보기");
		JButton btnSend = new JButton("보내기");
		JTextField toPerson = new JTextField(40);
		JTextField file = new JTextField(40);
		JTextArea content = new JTextArea(5, 40);
		gBag = new GridBagLayout();

		panel.setLayout(gBag);
		gbinsert(lbReceive, 0, 0, 1, 1);
		gbinsert(toPerson, 1, 0, 3, 1);
		gbinsert(lbContent, 0, 1, 1, 1);
		gbinsert(content, 1, 1, 3, 1);
		gbinsert(lbFile, 0, 2, 1, 1);
		gbinsert(file, 1, 2, 2, 1);
		gbinsert(btnSearch, 3, 2, 1, 1);
		gbinsert(btnSend, 0, 3, 4, 1);

		return panel;
	}
	public void gbinsert(Component c, int x, int y, int w, int h) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = w;
		gbc.gridheight = h;
		gBag.setConstraints(c, gbc);
		panel.add(c);
	}
}
