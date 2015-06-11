package com.pepperclab.springgroovy.user

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

/**
 * Created by johney on 15. 6. 10..
 */
class PasswordCrypto {

	PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();;

	private static PasswordCrypto instance;

	public static PasswordCrypto getInstance() {
		if(instance == null) {
			instance = new PasswordCrypto();
		}

		return instance;
	}

	public String encrypt(String str) {
		return passwordEncoder.encode(str);
	}
}
