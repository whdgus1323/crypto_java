package RSA;

import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

public class createKey_RSA {
	private rsaVO vo = new rsaVO();
	public createKey_RSA() throws NoSuchAlgorithmException {
		// TODO Auto-generated constructor stub
		KeyPair keyPair = CipherUtil.getRSAKeyPari();
		PublicKey publicKey = keyPair.getPublic();
		PrivateKey privateKey = keyPair.getPrivate();
		
		byte[] bytePublicKey = publicKey.getEncoded(); 
		byte[] bytePrivateKey = privateKey.getEncoded(); 
		String base64PublicKey = Base64.getEncoder().encodeToString(bytePublicKey); 
		String base64PrivateKey = Base64.getEncoder().encodeToString(bytePrivateKey);
		
		vo.setBase64PrivateKey(base64PrivateKey);
		vo.setBase64PublicKey(base64PublicKey);
	}
	public rsaVO getVO() {
		return this.vo;
	}
}
