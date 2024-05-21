package com.example.demo;

import java.util.Calendar;

public class ExCar extends Car {

	private double totalMileage; // 総走行距離
	private Calendar purchaseDay;

	public ExCar(String name, String number, int width, int height, int length, double tankCap, double fuelRemain,
			double fuelMilage, double totalMileage, Calendar purchaseDay) {
		super(name, number, width, height, length, tankCap, fuelRemain, fuelMilage);
		this.totalMileage = totalMileage;
		this.purchaseDay = purchaseDay;
	}

	public double getTotalMileage() {
		return totalMileage;
	}

	public String getPurchaseDay() {
		String dayKanji = "";
		switch (purchaseDay.get(Calendar.DAY_OF_WEEK)) {
		case 1:
			dayKanji = "日";
			break;
		case 2:
			dayKanji = "月";
			break;
		case 3:
			dayKanji = "火";
			break;
		case 4:
			dayKanji = "水";
			break;
		case 5:
			dayKanji = "木";
			break;
		case 6:
			dayKanji = "金";
			break;
		case 7:
			dayKanji = "土";
			break;
		default:
			break;
		}
		return purchaseDay.get(Calendar.YEAR) + "年" + purchaseDay.get(Calendar.MONTH) + "月"
				+ purchaseDay.get(Calendar.DAY_OF_MONTH) + "日" + "(" + dayKanji + ")";
	}

}
