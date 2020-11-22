import java.util.*;

public class BST {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int cases = in.nextInt();
		for(int i=0; i<cases; i++) {
			int N = in.nextInt();
			int n = 1;
			while(N % (n*2) == 0) {
				n *= 2;
			}
			int min = N - n + 1;
			int max = N + n - 1;
			System.out.println(min + " " + max);
		}
		in.close();
	}

}
