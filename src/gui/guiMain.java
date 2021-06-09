package gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class guiMain extends JFrame {
	private static final long serialVersionUID = 1L;

	public guiMain() {
		// TODO Auto-generated constructor stub
		JTabbedPane pane = createTabbedPane();
		Container ct = getContentPane();
		ct.add(pane);
		
		setTitle("종합설계Ⅱ");
		setVisible(true);
		setSize(550, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public JTabbedPane createTabbedPane() {
		JTabbedPane pane = new JTabbedPane();
		
		pane.addTab("저장소", new cryptoPanel().getPanel());
		pane.addTab("암호화", new cryptoPanel().getPanel());
		pane.addTab("복호화", new encryptoPanel().getPanel());
		
		return pane;
	}
	
	class ActionClass implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new guiMain();
		
	}

}
