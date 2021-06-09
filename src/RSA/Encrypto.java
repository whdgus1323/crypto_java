package RSA;

import java.security.PublicKey;

public class Encrypto {
	private String base64PublicKey;
	private String plainText;
	
	public Encrypto(String base64PublicKey, String plainText) {
		// TODO Auto-generated constructor stub
		this.base64PublicKey = base64PublicKey;
		this.plainText = plainText;
	}
	
	public String encrypto() throws Exception {
		PublicKey puKey = CipherUtil.getPublicKeyFromBase64String(this.base64PublicKey);
		System.out.println("평문  : " + this.plainText);
		
		String encrypText = CipherUtil.encryptRSA(plainText, puKey);
		System.out.println("암호문 : " + encrypText);
		
		return encrypText;
	}
}
