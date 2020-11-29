package Mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.*;

public class Cookies {

	public static void main(String[] args) throws IOException {
//		Scanner in = new Scanner(System.in);

		float[][] points = new float[2][200];
		int numpoints = 0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        while(!s.equals(""))
        {
            String[] coor = s.split(" ");
            points[0][numpoints] = Float.parseFloat(coor[0]); //x-value
			points[1][numpoints] = Float.parseFloat(coor[1]); //y-value
			numpoints++;
            s = br.readLine();
        }
        System.out.println("done");
        
//		boolean moreinput = true;
//		while(moreinput) {
//			try {
//				points[0][numpoints] = Float.parseFloat(in.next()); //x-value
//				points[1][numpoints] = Float.parseFloat(in.next()); //y-value
//				numpoints++;
//			}
//			catch(InputMismatchException e){
//				
//			}
//		}
		
		
//		while(in.hasNext()) {
//			points[0][numpoints] = Float.parseFloat(in.next()); //x-value
//			points[1][numpoints] = Float.parseFloat(in.next()); //y-value
//			numpoints++;
//		}
//		System.out.println("read inputs");
		
		int max = 0;
		for(int i=0; i<numpoints; i++) {
			for(int j=i+1; j<numpoints; j++) {
				float[][] centers = centers(points[0][i], points[1][i], points[0][j], points[1][j]);
				max = Math.max(max, count(points, centers, numpoints, 0));
				max = Math.max(max, count(points, centers, numpoints, 1));
			}
		}
//		in.close();
		System.out.println(max);
		
	}
	
	public static float[][] centers(float x1, float y1, float x2, float y2){
		//point B coordinates
		float[] pointB = {(x1+x2)/2, (y1+y2)/2};
		
		//magnitudes of AB and BC
		float magAB = (float) Math.sqrt((x1-pointB[0])*(x1-pointB[0]) + (y1-pointB[1])*(y1-pointB[1]));
		float magBC = (float) Math.sqrt(6.25*6.25 - magAB*magAB);
		
		//vectors of AB and BC
		float[] vectorAB = {x1-pointB[0], y1-pointB[0]};
		float[] vectorBC = {(x2 - x1)/magAB * magBC, (y2 - y1)/magAB * magBC};
		
		float[][] centers = new float[2][2];
		centers[0][0] = vectorAB[0] + vectorBC[0] + x1; // x 
		centers[0][1] = vectorAB[1] + vectorBC[1] + x1; // y
		centers[0][0] = vectorAB[0] - vectorBC[0] + x1; // x
		centers[0][1] = vectorAB[1] - vectorBC[1] + x1; // y
		
		return centers;
	}
	
	public static int count(float[][] points, float[][] centers, int numpoints, int n) {
		int count =0;
		for(int k=0; k<numpoints; k++) {
			if(Math.pow(points[0][k]-centers[n][0],2) +  Math.pow(points[1][k]-centers[n][1],2) >= 6.25) {
				count++;
			}
		}
		return count;
	}

}
