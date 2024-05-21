package com.example.demo;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarTester {

	public static void main(String[] args) {
		SpringApplication.run(CarTester.class, args);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("車のデータを入力せよ。");

		System.out.print("名前　　　：");
		String inputName = sc.next();
		
		System.out.print("ナンバー　：");
		String inputNumber = sc.next();
		
		int inputWidth = inputValidInt(sc, "車幅　　　：");
		int inputHeight = inputValidInt(sc, "高さ　　　：");
		int inputLength = inputValidInt(sc, "長さ　　　：");

		double inputTankCap = inputValidDouble(sc, "タンク容量：");
		double inputFuelRemain = inputValidDouble(sc, "ガソリン量：");
		double inputFuelMileage = inputValidDouble(sc, "燃費　　　：");

		Car car = new Car(inputName, inputNumber, inputWidth, inputHeight, inputLength, inputTankCap, inputFuelRemain,
				inputFuelMileage);

		boolean isMoving = true;
		double inputMoveX = 0;
		double inputMoveY = 0;
		boolean fuelSufficient = true;
		while (isMoving) {
			System.out.println("現在値：(" + car.getX() + ", " + car.getY() + ")");
			System.out.println("残り燃料：" + car.getFuel());
			System.out.print("移動しますか [0…No/1…Yes]:");
			String inputMoving = sc.next();
			if (inputMoving.equals("1")) {
				inputMoveX = inputValidDouble(sc, "X方向の移動距離：");
				inputMoveY = inputValidDouble(sc, "Y方向の移動距離：");
				fuelSufficient = car.move(inputMoveX, inputMoveY);
				if (!fuelSufficient) {
					System.out.println("残り燃料が不足。給油を行う。");
					double inputRefuelAmount = inputValidDouble(sc, "給油量：");
					car.refuel(inputRefuelAmount);
					System.out.println("車を給油されました。");
				}
			} else if (inputMoving.equals("0")) {
				isMoving = false;
			} else {
				System.out.println("入力したデータは不正。求められるデータタイプ：0または１");
			}
		}

		System.out.println("プログラムが閉まります。ご利用いただいてありがとうございます。");
	}

	private static int inputValidInt(Scanner scan, String strText) {
		boolean validInput = false;
		int inputInt = 0;
		while (!validInput) {
			System.out.print(strText);
			String tempInput = scan.next();
			try {
				inputInt = Integer.parseInt(tempInput);
				validInput = true;
			} catch (Exception e) {
				System.out.println("入力したデータは無効な番号。求められるデータタイプ：Integer");
			}
		}
		return inputInt;
	}

	private static double inputValidDouble(Scanner scan, String strText) {
		boolean validInput = false;
		double inputDouble = 0.0;
		while (!validInput) {
			System.out.print(strText);
			String tempInput = scan.next();
			try {
				inputDouble = Double.parseDouble(tempInput);
				validInput = true;
			} catch (Exception e) {
				System.out.println("入力したデータは無効な番号。求められるデータタイプ：Double");
			}
		}
		return inputDouble;
	}

}
