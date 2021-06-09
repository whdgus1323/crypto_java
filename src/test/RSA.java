package test;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

class CipherUtil {
	//1024 비트 RSA 키쌍을 생성
	public static KeyPair getRSAKeyPari() throws NoSuchAlgorithmException {
		SecureRandom secureRandom = new SecureRandom();
		KeyPairGenerator gen;
		gen = KeyPairGenerator.getInstance("RSA");
		gen.initialize(1024, secureRandom);
		KeyPair keyPair = gen.generateKeyPair();
		return keyPair;
	}
	
	//Public Key로 RSA 암호화 수행
	public static String encryptRSA(String plainText, PublicKey publicKey)
			throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException,
			BadPaddingException, IllegalBlockSizeException {
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		byte[] bytePlain = cipher.doFinal(plainText.getBytes());
		String encrypted = Base64.getEncoder().encodeToString(bytePlain);
		return encrypted;
	}

	//Private Key로 RSA 복호화 수행
	public static String decryptRSA(String encrypted, PrivateKey privateKey) 
			throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, 
			BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException { 
		Cipher cipher = Cipher.getInstance("RSA");
		byte[] byteEncrypted = Base64.getDecoder().decode(encrypted.getBytes()); 
		cipher.init(Cipher.DECRYPT_MODE, privateKey); 
		byte[] bytePlain = cipher.doFinal(byteEncrypted); 
		String decrypted = new String(bytePlain, "utf-8"); 
		return decrypted;
	}



	//Base64 인코딩된 개인키 문자열로부터 PrivateKey 객체 얻는다.
	public static PrivateKey getPrivateKeyFromBase64String(final String keyString) 
			throws NoSuchAlgorithmException, InvalidKeySpecException { 
		final String privateKeyString = 
				keyString.replaceAll("\\n", "").replaceAll("-{5}[ a-zA-Z]*-{5}", ""); 
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		PKCS8EncodedKeySpec keySpecPKCS8 = 
				new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateKeyString)); 
		return keyFactory.generatePrivate(keySpecPKCS8); 
	} 
	
	//Base64로 인코딩된 공개키 문자열로부터 PublicKey 객체 얻는다.
	public static PublicKey getPublicKeyFromBase64String(final String keyString) 
			throws NoSuchAlgorithmException, InvalidKeySpecException { 
		final String publicKeyString = 
				keyString.replaceAll("\\n", "").replaceAll("-{5}[ a-zA-Z]*-{5}", ""); 
		KeyFactory keyFactory = KeyFactory.getInstance("RSA"); 
		X509EncodedKeySpec keySpecX509 = 
				new X509EncodedKeySpec(Base64.getDecoder().decode(publicKeyString)); 
		return keyFactory.generatePublic(keySpecX509); 
	}

}

class Encrypto {
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

class Decrypto {
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

public class RSA {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		KeyPair keyPair = CipherUtil.getRSAKeyPari();
		PublicKey publicKey = keyPair.getPublic();
		PrivateKey privateKey = keyPair.getPrivate();

		//공개키를 Base64로 인코딩한 문자열 생성
		byte[] bytePublicKey = publicKey.getEncoded(); 
		byte[] bytePrivateKey = privateKey.getEncoded(); 
		String base64PublicKey = Base64.getEncoder().encodeToString(bytePublicKey); 
		String base64PrivateKey = Base64.getEncoder().encodeToString(bytePrivateKey);
		
		String plainText = "안녕하세요 만나서 반갑습니다.\n 저는 최종현 입니다~";
		
		System.out.println("Encrypto--");
		String encrypText = new Encrypto(base64PublicKey, plainText).encrypto();
		System.out.println();
		System.out.println("Decrypto--");
		new Decrypto(base64PrivateKey, encrypText).decrypto();;
	}
}
