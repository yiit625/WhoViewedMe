package com.example.Assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Locale;

@SpringBootApplication
public class AssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssignmentApplication.class, args);

/*
		int[] a = new int[]{ 1, 3, 5, 6, 4, 2 };

		int[] b = new int[a.length];

		for( int i =0 ; i < a.length ; i++){

			if(i % 2 == 0){
				if(i == 0){
					b[0] = a[0];
				}

				b[i] = a [i/2];
			}

			else {

				if(i == 1){
					b[i] = a[a.length-i];
				}
				b[i] = a[a.length-1-( i -1 )/2 ];

			}

		}

		int sum = 0;



		for(int k = 0 ; k < b.length ; k++) {

			if (k + 1 != b.length) {
				if (b[k] < b[k + 1]) {

					sum = sum + 1;
				}
			}
		}



		System.out.println(b);

		*/

	/*	int[][] a = new int[][]{{3, 3, 4, 2}, { 4, 4 }, {4, 0, 3, 3}, { 2, 3 }, { 3, 3, 3 } };

		int[] b = new int[a.length];

		for(int i = 0 ; i < a.length ; i++) {

			for( int k = 0 ; k < a[i].length ; k++) {

				b[i] = (a[i][k] + b[i]);

			}
			b[i] = b[i] / a[i].length;
		}

		System.out.println(b); */


	/*	int number = 482596;


		int result = 0;
		int place = 1;
		while (number > 9) {
			result += place * 10 * (number % 10);
			number /= 10;
			result += place * (number % 10);
			number /= 10;
			place *= 100;
		}
		System.out.println(result + place * number);

		int[] arrayB = { 5, 8, 9};
		int[] arrayA = { 4, 7, 8};

		int[] mergedArray = new int[arrayA.length + arrayB.length];

		int i=0, j=0, k=0;

		while (i < arrayA.length)
		{
			mergedArray[k] = arrayA[i];
			i++;
			k++;
		}

		while (j < arrayB.length)
		{
			mergedArray[k] = arrayB[j];
			j++;
			k++;
		}

		int tempVar;

		for(int m=0; m < mergedArray.length; m++){
			for(int n=1; n < (mergedArray.length-m); n++){
				if(mergedArray[n-1] > mergedArray[n]){
					//swap elements
					tempVar = mergedArray[n-1];
					mergedArray[n-1] = mergedArray[n];
					mergedArray[n] = tempVar;
				}

			}
		}

		System.out.println(mergedArray);

	 */

	}

	@Bean
	public LocaleResolver localeResolver() {
		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}





}
