package file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Vector;

import AES.DecryptoAES;
import RSA.Decrypto;

public class ReadFile {
	private String name;
	private Vector<String> vector = new Vector<String>();
	public ReadFile(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}
	public String Decrypt(int flag) {
		try {
			String Text;
			if(flag==1) Text = new DecryptoAES().decryptAES256(vector.lastElement(), vector.firstElement());
			else if(flag==2) Text = new Decrypto(vector.firstElement(), vector.lastElement()).decrypto();
			else Text = "Error!";
			return Text;
		} catch (Exception e) {
			// TODO: handle exception
			return "Error!";
		}
		
	}
	public String fileRead(int flag) throws Exception {
		try {
			File file = new File("data/"+this.name);
			if(file.exists()) {
				BufferedReader inFile = new BufferedReader(new FileReader(file));
				String line = null;
				while((line = inFile.readLine())!=null) {
					vector.add(line);
				}
			}			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return Decrypt(flag);
	}
}
