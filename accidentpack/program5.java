import java.io.*;
import java.util.Scanner;

public class program5 {
	
	public static void main(String[] args) throws FileNotFoundException {
		binarySearchTree<Report> test = Scan("accidentpack/accidents_small_sample.csv");
		test.printTreeInOrder();
	}
	
	public static binarySearchTree<Report> Scan(String loc) throws FileNotFoundException {
		binarySearchTree<Report> fin = new binarySearchTree<Report>();
		long start = System.currentTimeMillis();
		Scanner scnr = new Scanner(new File(loc));
		scnr.nextLine();
		while(scnr.hasNextLine()) {
			String split[] = scnr.nextLine().split(",");
			Report reported = new Report(split[0], (int) Integer.parseInt(split[1]), split[2], split[3], split[4], split[5], split[6], split[7], (int) Double.parseDouble(split[8]), (int) Double.parseDouble(split[9]), (int) Double.parseDouble(split[10]), split[11], Boolean.parseBoolean(split[12]), split[13]);
			fin.add(reported);
		}
		long end = System.currentTimeMillis();
		System.out.println((end-start) + " milliseconds to read the records into a Binary Search Tree");
		return fin;
	}

}
