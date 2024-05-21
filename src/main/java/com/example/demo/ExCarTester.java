package com.example.demo;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExCarTester {

	public static void main(String[] args) {
		SpringApplication.run(ExCarTester.class, args);

		Calendar purchaseDate = new GregorianCalendar(2005, 9, 13);
		ExCar exCar = new ExCar("Test ExCar 1", "123-321", 1200, 1800, 3200, 100, 95, 10, 18000, purchaseDate);
		
		System.out.println("現在値：(" + exCar.getX() + ", " + exCar.getY() + ")");
		System.out.println("残り燃料：" + exCar.getFuel());
		System.out.println("購入日：" + exCar.getPurchaseDay());

	}

}
