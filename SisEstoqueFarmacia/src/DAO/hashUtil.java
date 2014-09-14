package DAO;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class hashUtil {//Classe para criar o hashCode da senha...
	
	public static String stringToMD5(String string){
		String md5 = null;
		if(null == string){
			return null;
		}
	MessageDigest mdg;
	
	try{
		mdg = MessageDigest.getInstance("MD5");
		mdg.update(string.getBytes(), 0, string.length());
		//Convertendo para HEXA
		md5 = new BigInteger(1, mdg.digest()).toString(16);
		} catch (NoSuchAlgorithmException ex){
			Logger.getLogger(hashUtil.class.getName()).log(Level.SEVERE, null, ex);
		}
	return md5;
	
	}
}
