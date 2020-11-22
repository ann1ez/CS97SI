import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Yeehaa {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		for(int i=1; i<=N; i++) {
			double R = Double.parseDouble(in.next());
			int n = in.nextInt();
			double cosTerm = Math.cos(Math.toRadians((n-2)*90/n));
			double r = R * cosTerm / (cosTerm + 1);
			System.out.println("Scenario #" + i + ":");
			System.out.println(round(r, 3));
			System.out.println();
		}
		in.close();
	}
	
	private static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();
	 
	    BigDecimal bd = new BigDecimal(Double.toString(value));
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}

}
