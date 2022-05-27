package com.epy.main.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {
	
	public static void main(String [] args) {
		
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
		
		System.out.println(bCryptPasswordEncoder.encode("70073165"));
		
		//$2a$04$oGQrvCwOMmOv2uYXVFnsWein.smvRgwyoSRw1QOBxfBYOGiP3ioEq 1234
		//$2a$04$HOzm4Hmo3VZxixzaHNxuU.RoCnkerskrek8s208Wt/fx2SKEEyR2q hola		
	}
	
	
}
   