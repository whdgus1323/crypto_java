package RSA;

import java.security.PrivateKey;

public class Decrypto {
	private String base64PrivateKey;
	private String encrypText;
	
	public Decrypto(String base64PrivateKey, String encrypText) {
		// TODO Auto-generated constructor stub
		this.base64PrivateKey = base64PrivateKey;
		this.encrypText = encrypText;
	}
	
	public void decrypto() throws Exception {
		PrivateKey prKey = CipherUtil.getPrivateKeyFromBase64String(this.base64PrivateKey);
		System.out.println("암호문 : " + this.encrypText);
		
		String decrypText = CipherUtil.decryptRSA(encrypText, prKey);
		System.out.println("평문  : " + decrypText);
	}
}
