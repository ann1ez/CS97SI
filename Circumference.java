import java.math.*;
import java.util.Scanner;

public class Circumference {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			
			//reading input, array [x1, y1, x2, y2, x3, y3]
			String[] strCoor = in.nextLine().split(" ");
			double[] coor = new double[6];
			for(int i=0; i<6; i++) {
				coor[i] = Double.parseDouble(strCoor[i]);
			}
			
			//creating lines
			double[] l1 = equation(coor[0], coor[1], coor[2], coor[3]);
			double[] l2 = equation(coor[0], coor[1], coor[4], coor[5]);
			
			//finding the intersection
			double x = (l1[2]*l2[1] - l2[2]*l1[1]) / (l1[0]*l2[1] - l2[0]*l1[1]);
			double y = (l1[0]*l2[2] - l2[0]*l1[2]) / (l1[0]*l2[1] - l2[0]*l1[1]);
			
			//finding the distance
			double r = Math.sqrt(Math.pow(x-coor[0], 2) + Math.pow(y-coor[1], 2));
			
			//finding the area
			double area = 3.141592653589793 * 2 * r;
			
			//rounding
			BigDecimal output = BigDecimal.valueOf(area).setScale(2, RoundingMode.HALF_UP);
			System.out.println(output);
		}
		in.close();
	}
	
	public static double[] equation(double x1, double y1, double x2, double y2) {
		double[] equ = new double[3];
		equ[0] = x2 - x1;
		equ[1] = y2 - y1;
		equ[2] = equ[0]*(x1+x2)/2 + equ[1]*(y1+y2)/2;
		return equ;
	}

}
