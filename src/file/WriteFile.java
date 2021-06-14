package file;

import java.io.FileOutputStream;
import java.io.OutputStream;

import AES.EncryptoAES;
import AES.aesVO;
import RSA.Encrypto;
import RSA.rsaVO;

public class WriteFile {
	private rsaVO rsa;
	private aesVO aes;
	private String data;
	private String name;
	private String text;
	private String key;
	public WriteFile(rsaVO vo, String data, String name) {
		// TODO Auto-generated constructor stub
		this.rsa = vo;
		this.data = data;
		this.name = name;
	}
	public WriteFile(aesVO vo, String name) {
		this.aes = vo;
		this.name = name;
	}
	public void rsaEncrypt() throws Exception {
		String base64PublicKey = rsa.getBase64PublicKey();
		key = rsa.getBase64PrivateKey();
		text = new Encrypto(base64PublicKey, this.data).encrypto();
		fileWrite();
	}
	public void aesEncrypt() throws Exception {
		key = aes.getKey();
		data = aes.getValue();
		text = EncryptoAES.encryptAES256(data, key);
		fileWrite();
	}
	public void fileWrite() {
		try {
			OutputStream output = new FileOutputStream("data/"+name);
			output.write(this.key.getBytes());
			output.write("\n".getBytes());
			output.write(this.text.getBytes());
			output.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
