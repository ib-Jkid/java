package main;


import java.util.Scanner;

public class Listener {

	static Scanner scan = new Scanner(System.in);
	public static String getResponse (String x) {
		return scan.nextLine();
	}
	public static Integer getResponse (int x) {
			try {
				return scan.nextInt();
			}catch (Exception e) {
				return 0;
			}
		
	}
	public static Double getResponse (Double x) {
		try {
			return scan.nextDouble();
		}catch (Exception e) {
			return 0.0;
		}
		
	}

}
