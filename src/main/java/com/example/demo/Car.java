package com.example.demo;

public class Car {

	// Fields (フィールド)
	private String name; // 名前
	private String number; // ナンバー
	private int width; // 幅
	private int height; // 高さ
	private int length; // 長さ
	private double coordX; // 現在位置X座標
	private double coordY; // 現在位置Y座標
	private double tankCap; // タンク容量
	private double fuelRemain; // 残り燃料
	private double fuelMilage; // 燃費

	// Constructors (コンストラクタ)
	public Car(String name, String number, int width, int height, int length, double tankCap, double fuelRemain, double fuelMilage) {
		super();
		this.name = name;
		this.number = number;
		this.width = width;
		this.height = height;
		this.length = length;
		this.tankCap = tankCap;
		if (tankCap < fuelRemain) {
			this.fuelRemain = tankCap;
		} else {
			this.fuelRemain = fuelRemain;
		}
		this.fuelMilage = fuelMilage;
		this.coordX = 0;
		this.coordY = 0;
	}
	

	// Methods (メソッド)
	public double getX() {
		return coordX;
	}

	public double getY() {
		return coordY;
	}

	public double getFuel() {
		return fuelRemain;
	}

	public void putSpec() {
		System.out.println("名前　　：" + this.name);
		System.out.println("ナンバー：" + this.number);
		System.out.println("車幅　　：" + this.width + "mm");
		System.out.println("車高　　：" + this.height + "mm");
		System.out.println("車長　　：" + this.length + "mm");
		System.out.println("タンク　：" + this.tankCap + "リットル");
		System.out.println("燃費　　：" + this.fuelMilage + "/リットル");
	}

	public boolean move(double moveX, double moveY) {
		double distance = Math.sqrt(Math.pow(moveX, 2) + Math.pow(moveY, 2));
		double fuelCons = distance * this.fuelMilage;
		if (fuelCons > this.fuelRemain)
			return false;
		this.coordX += moveX;
		this.coordY += moveY;
		this.fuelRemain -= fuelCons;
		return true;
	}

	public void refuel(double amount) {
		this.fuelRemain += amount;
		if (this.fuelRemain > this.tankCap)
			this.fuelRemain = this.tankCap;
	}

}
