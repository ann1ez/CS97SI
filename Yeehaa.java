import java.io.*;
import java.math.*;
import java.util.Scanner;

public class Yeehaa {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		for(int i=1; i<=N; i++) {
			
			BigDecimal R = new BigDecimal(in.next());
			BigDecimal n = new BigDecimal(in.next());
			
			BigDecimal radian = n.subtract(BigDecimal.valueOf(2)).multiply(BigDecimal.valueOf(1.57079632679)).divide(n,10, RoundingMode.HALF_UP);
			double cosTerm = Math.cos(radian.doubleValue());
			BigDecimal r = R.multiply(BigDecimal.valueOf(cosTerm)).divide(BigDecimal.valueOf(cosTerm).add(BigDecimal.valueOf(1)), 10, RoundingMode.HALF_UP);
			r = r.setScale(3, RoundingMode.HALF_UP);
			System.out.println("Scenario #" + i + ":");
			System.out.println(r);
			if(i<N) System.out.println();
		}
		in.close();
	}
}
