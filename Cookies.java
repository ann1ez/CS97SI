package Mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cookies {

	public static void main(String[] args) throws IOException {
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
		
		int max = 0;
		for(int i=0; i<numpoints; i++) {
			for(int j=i+1; j<numpoints; j++) {
				float[][] centers = centers(points[0][i], points[1][i], points[0][j], points[1][j]);
				max = Math.max(max, count(points, centers, numpoints, 0));
				max = Math.max(max, count(points, centers, numpoints, 1));
				//System.out.println(max);
			}
		}

		System.out.println(max);
		
	}
	
	public static float[][] centers(float x1, float y1, float x2, float y2){
		//point B coordinates
		float[] pointB = {(x1+x2)/2, (y1+y2)/2};
		
		//magnitudes of AB and BC
		float magAB = (float) Math.sqrt((x1-pointB[0])*(x1-pointB[0]) + (y1-pointB[1])*(y1-pointB[1]));
		float magBC = (float) Math.sqrt(6.25 - magAB*magAB);
		
		//vectors of AB and BC
		float[] vectorAB = {pointB[0]-x1, pointB[1]-y1};
		float[] vectorBC = {(pointB[1]-y1)/magAB * magBC, (pointB[0]-x1)/magAB * magBC};
		
		float[][] centers = new float[2][2];
		centers[0][0] = x1 + vectorAB[0] + vectorBC[0]; // x 
		centers[0][1] = y1 + vectorAB[1] + vectorBC[1]; // y
		centers[1][0] = x2 - vectorAB[0] - vectorBC[0]; // x
		centers[1][1] = y2 - vectorAB[1] - vectorBC[1]; // y
		
		return centers;
	}
	
	public static int count(float[][] points, float[][] centers, int numpoints, int n) {
		int count =0;
		for(int k=0; k<numpoints; k++) {
			double val = Math.pow(points[0][k]-centers[n][0],2) +  Math.pow(points[1][k]-centers[n][1],2);
			if(val <= 6.25) {
				count++;
			}
		}
		return count;
	}

}
