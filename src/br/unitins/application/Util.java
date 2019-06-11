package br.unitins.application;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.InputMismatchException;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.swing.JOptionPane;

import org.apache.commons.codec.digest.DigestUtils;

public class Util {

	public static void main(String[] args) {
		System.out.println(Util.encrypt("12345678"));
	}
	
	public static String encryptByApache(String value) {
		return DigestUtils.sha256Hex(value);
	}
	
	public static String encrypt(String value) {
		try {
			// Classe usilizada para gerar a criptografia em hash
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
			byte[] bytes = messageDigest.digest(value.getBytes());
			
			// convertendo um array de bytes em hexadecimal
			StringBuilder stringBuilder = new StringBuilder();
			for (byte b : bytes) {
				stringBuilder.append(String.format("%02X", 0xFF & b));
			}

			return stringBuilder.toString();
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public static void redirect(String url) {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(url);
		} catch (IOException e) {
			addMessageError("Erro ao redirecionar a página.");
			e.printStackTrace();
		}
	}

	public static void addMessageError(String message) {
		FacesContext.getCurrentInstance().addMessage("", new FacesMessage(message));
	}
}