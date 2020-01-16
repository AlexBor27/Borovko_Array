package array;

import java.util.ArrayList;
import java.util.Scanner;

/*****************************************************************
 * Составить алгоритм: на входе есть числовой массив, необходимо *
 * вывести элементы массива кратны 3				 *			 *
 *****************************************************************/

public class Array {

	private static ArrayList<Integer> arrayList = new ArrayList<Integer>();
	private static int numberOfArrayElements;
	private static int elementNumber;
	private static boolean numberOfArrayElementsIsOk = false;
	private static boolean isElementNumberOk = false;

	public static void inputValues() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Укажите количество чисел");
		String str = scan.nextLine();
		checkNumberOfArrayElementsIsTrue(str);
		if (numberOfArrayElementsIsOk == true && numberOfArrayElements <= 0) {
			System.out.println("Перезапустите программу и введите натуральное число");
		} else if (numberOfArrayElementsIsOk == true) {
			System.out.println("Введите набор чисел, после каждого нажмите Enter");
			for (int i = 0; i < numberOfArrayElements; i++) {
				str = scan.nextLine();
				checkEachElementForIntegerValue(str);
				if (isElementNumberOk == true) {
					arrayList.add(elementNumber);
					isElementNumberOk = false;
				}
			}
		}

		isMultipleCheck();
		scan.close();
	}

	public static void checkNumberOfArrayElementsIsTrue(String numberOfArray) {

		try {
			numberOfArrayElements = Integer.parseInt(numberOfArray);
			numberOfArrayElementsIsOk = true;
		} catch (NumberFormatException e) {
			System.out.print(
					"Значение " + numberOfArray + " не является натуральным " + "числом, перезапустите программу");
		}

	}

	public static void checkEachElementForIntegerValue(String element) {
		try {
			elementNumber = Integer.parseInt(element);
			isElementNumberOk = true;
		} catch (NumberFormatException e) {
			System.out.print("Значение" + element + " не является целым " + "числом, перезапустите программу");
		}
	}

	public static void isMultipleCheck() {
		for (int i = 0; i < arrayList.size(); i++) {
			if (arrayList.get(i) % 3 == 0 && arrayList.get(i) > 0) {
				System.out.print(arrayList.get(i) + " - кратно 3 ");
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		inputValues();

	}

}
