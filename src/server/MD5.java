package server;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
	private String code;

	public MD5(String md5) {
		Passe(md5);
	}

	public void Passe(String pass) {
		byte[] passBytes = pass.getBytes();
		try {
			MessageDigest algorithm = MessageDigest.getInstance("MD5");
			algorithm.reset();
			algorithm.update(passBytes);
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(passBytes);
			BigInteger number = new BigInteger(1, messageDigest);
			this.code = number.toString(10);

		} catch (NoSuchAlgorithmException e) {
			throw new Error("invalid JRE: have not 'MD5' impl.", e);
		}
	}

	public String codeGet() {
		return code;
	}

}