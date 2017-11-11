import java.util.Scanner;

public class Sol {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for (int i = 0; i < n; i++){
			String x = in.next();
			//System.out.println(x);
			int x1 = x.charAt(0) - 'A';
			int x2 = in.nextInt();
			String y = in.next();
			int y1 = y.charAt(0) - 'A';
			int y2 = in.nextInt();
			System.out.println(x1 + " " + x2 + " " + y1 + " " + y2 );
		}
	}

}
