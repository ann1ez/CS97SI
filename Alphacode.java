import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String x = in.nextLine();
		while(!(x.length() == 1 && Integer.parseInt(x)==0)) 
		{
			//do stuff
			int l = x.length();
			long[] count = new long[l];
			count[0] = 1;
			count[1] = 1;
			if(Integer.parseInt(x.substring(l-2)) <= 26)
				count[1]++;
			
			for(int i = 3; i<=l; i++) {
				count[i-1] = count[i-2];
				if(Integer.parseInt(x.substring(l-i, l-i+2)) <= 26)
					count[i-1] += count[i-3];
			}
			
			System.out.println(count[l-1]);
			
			//increment
			x = in.nextLine();
		}
		
		in.close();

	}

}
