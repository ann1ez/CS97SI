import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		//int[][] input = new int[N][N];
		int[][] sum = new int[N][N];
		
		sum[0][0] = in.nextInt();
		for(int r=1; r<N; r++) 
		{
			sum[r][0] = sum[r-1][0] + in.nextInt();
			for(int c=1; c<r; c++) 
			{
				sum[r][c] = Math.max(sum[r-1][c-1], sum[r-1][c]) + in.nextInt();
			}
			sum[r][r] = sum[r-1][r-1] + in.nextInt();
		}
		in.close();
		
//		for(int r=0; r<N; r++) {
//			for(int c=0; c<=r; c++) {
//				input[r][c] = in.nextInt();
//			}
//		}
//		in.close();
//		
//		sum[0][0] = input[0][0];
//		for(int r=1; r<N; r++) 
//		{
//			sum[r][0] = sum[r-1][0] + input[r][0];
//			for(int c=1; c<r; c++) 
//			{
//				sum[r][c] = Math.max(sum[r-1][c-1], sum[r-1][c]) + input[r][c];
//			}
//			sum[r][r] = sum[r-1][r-1] + input[r][r];
//		}
		
		int max = 0;
		for(int i=0; i<N; i++) {
			max = Math.max(sum[N-1][i], max);
		}
		
		System.out.println(max);
	}

}
