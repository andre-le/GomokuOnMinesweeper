import java.util.Scanner;

public class ADifferentProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		while (in.hasNext()){
			long num1 = in.nextLong();
			long num2 = in.nextLong();
			System.out.println(Math.abs(num2 - num1));
		}
	}	

}
