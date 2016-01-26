package com.june.app.util;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class EncTest {
	public static void main(String[] args) throws Exception {
		/*
		 * PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); //
		 * String hashedPassword = passwordEncoder.encode("#kgsadmin!@#");
		 * String hashedPassword = passwordEncoder.encode("1234qwer");
		 */
		/*
		 * $2a$10$.0rrlOURgWeQjbwemsPSEOW1yIIlsjV6JmrnT56iJWnNrtr/F3k8u
		 * $2a$10$H1jy3XhjwlqLb2yG280MmekaBV547Ap18GUGvx9TfqXaJhwVF93zO
		 * $2a$10$dVLUgR0pSMqEKIbGlks1D.ZOLcwsUGT0DSO66.wr68qUCRn4UhOPi
		 * 
		 */
		/*
		 * String ensadf = BCrypt.hashpw("1234qwer", "3RzkhxXz7pDJbiHS8S1K");
		 * System.out.println("=======hashedPassword====" + hashedPassword);
		 * System.out.println("=======ensadf====" + ensadf);
		 */
		/*
		 * System.out.println("=======hashedPassword====" + hashedPassword);
		 * boolean matches = passwordEncoder.matches("1234qwer",
		 * "$2a$06$XnBrWdGpUTrlY30TKmySX.N0CEsV6v3s/QsfXqJgdJUANUMRFanBe");
		 */
		// $2a$10$8HntKnJEn7N7SuY3Ze1qzu0npW1XTkvRDIRCAgRfLzI5UEpxJsPCO
		// System.out.println("===========" + matches);
		// $2a$10$7QIlX9oPGxghvs91vNAlkOQcJmXTxIEat6hW9tg7WltdSdRVO0vPu
		// $2a$10$7QIlX9oPGxghvs91vNAlkOQcJmXTxIEat6hW9tg7WltdSdRVO0vPu
		// $2a$10$RqAAYiv7i4O4QU9pFnUG7OTa7opxlOA.QxnKJ1rpIf0J6nDSs9M2.
		// 3RzkhxXz7pDJbiHS8S1K

		// @password = Password.create("my grand secret")
		// @password #=>
		// "$2a$10$GtKs1Kbsig8ULHZzO1h2TetZfhO4Fmlxphp8bVKnUlZCBYYClPohG"

		String pass = "hello";
		System.out.println("그냥 문자열 : " + pass);

		String hashPass = BCrypt.hashpw(pass, BCrypt.gensalt(14));
		System.out.println("암호화된 String : " + hashPass);

		String pass2 = "hello2";

		System.out.println(BCrypt.checkpw(pass, hashPass));
		System.out.println(BCrypt.checkpw("1234qwer", "$2a$10$PqiTH2fLdYbrYODNpaFD/.QSzobz6SAN6asPEjHuRHHMqwQfAa8JG"));
		String h1 = BCrypt.hashpw("1234qwer", BCrypt.gensalt());
		System.out.println("=======h1====" + h1);
		System.out.println(BCrypt.checkpw("1234qwer", "$2a$10$7QIlX9oPGxghvs91vNAlkOQcJmXTxIEat6hW9tg7WltdSdRVO0vPu"));

		// BCrypt.hashpw("1234qwer", "3RzkhxXz7pDJbiHS8S1K");

		// System.out.println("=======h1111====" + BCrypt.hashpw("1234qwer",
		// "3RzkhxXz7pDJbiHS8S1K"));
	}
}
