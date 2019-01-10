package com.kh.common.wrapper;

import java.nio.charset.Charset;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class EncryptWrapper extends HttpServletRequestWrapper {

	public EncryptWrapper(HttpServletRequest request) {
		super(request);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getParameter(String key) {
		System.out.println("EncryptWrapper 실행");
		String value = "";
		
		if(key != null && 
			("memberPwd".equals(key) || "memberPwd_new".equals(key))) {
			System.out.println("암호화전 : "+super.getParameter(key));
			
			value = getSha512(super.getParameter(key));
			
			System.out.println("암호화후 : "+value);
		}
		else {
			value = super.getParameter(key);
		}
		
		return value;
	}
	
	
	
	private String getSha512(String memberPwd) {
		String encPwd = null;
		MessageDigest md = null;
		
		try {
			md = MessageDigest.getInstance("SHA-512");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		byte[] bytes = memberPwd.getBytes(Charset.forName("utf-8"));
		md.update(bytes);

		byte[] encBytes = md.digest();
		
		encPwd = Base64.getEncoder().encodeToString(encBytes);
		
		return encPwd;
		
		
		
	}

}
