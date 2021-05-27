package com.example.Assignment;

import io.swagger.models.auth.In;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class AssignmentApplication {

	public static void main(String[] args) throws Exception {

		String keyword = "hello";
		byte[] keytest = keyword.getBytes();
		byte [] text = {1, 2, 3, 4, 5};
		RC4 rc4 = new RC4(keytest);

		System.out.print("\noriginal text: ");
		for (int i = 0; i < text.length; i++) {
			System.out.print(text[i]);
		}

		byte[] cipher = rc4.encrypt(text); //encryption
		System.out.print("\ncipher: ");
		for (int i = 0; i < cipher.length; i++) {
			System.out.print(cipher[i]);
		}

		byte[] backtext = rc4.decrypt(cipher); //decryption
		System.out.print("\nback to text: ");
		for (int i = 0; i < backtext.length; i++) {
			System.out.print(backtext[i]);
		}
		System.out.println();


		SELAM
				Yigit
	/*	String keyword = "hello";
		byte[] keytest = keyword.getBytes(); //convert keyword to byte

		int[] text = {1, 2, 3, 4, 5}; // text as 12345

		RC42 rc42 = new RC42(keytest);

		System.out.print("\noriginal text: ");
		for (int i = 0; i < text.length; i++) {
			System.out.print(text[i]);
		}

		int[] cipher = rc42.encrypt(text); //encryption
		System.out.print("\ncipher: ");
		for (int i = 0; i < cipher.length; i++) {
			System.out.print(cipher[i]);
		}

		int[] backtext = rc42.decrypt(cipher); //decryption
		System.out.print("\nback to text: ");
		for (int i = 0; i < backtext.length; i++) {
			System.out.print(backtext[i]);
		}
		System.out.println();*/

		//	SpringApplication.run(AssignmentApplication.class, args);

	}


/*	@Bean
	public LocaleResolver localeResolver() {
		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}*/


	yigit
}



